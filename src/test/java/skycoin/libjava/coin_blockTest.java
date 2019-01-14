package skycoin.libjava;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.Test;
import skycoin.libjava.skycoin;
import skycoin.libjava.transutils;

/**
 * Unit test for simple App.
 */
public class coin_blockTest extends skycoin {
  static { System.loadLibrary("skycoin"); }

  transutils utils = new transutils();

  public SWIGTYPE_p_Transactions__Handle makeTestTransactions() {
    SWIGTYPE_p_Transactions__Handle txns = new_Transactions__HandlePtr();
    long err = SKY_coin_Create_Transactions(txns);
    assertEquals(err, SKY_OK);
    SWIGTYPE_p_Transaction__Handle txn = utils.makeEmptyTransaction();
    err = SKY_coin_Transactions_Add(txns, txn);
    assertEquals(err, SKY_OK);
    return txns;
  }

  public long makeNewBlock(cipher_SHA256 uxHash,
                           SWIGTYPE_p_Block__Handle newBlock) {
    cipher_SHA256 bodyhash = new cipher_SHA256();
    SWIGTYPE_p_Block__Handle block = new_Block__HandlePtr();
    SWIGTYPE_p_Transactions__Handle transactions = makeTestTransactions();
    long err = SKY_coin_NewEmptyBlock(transactions, block);
    assertEquals(err, SKY_OK);

    SWIGTYPE_p_p_coin__Block pBlockP = new_coin__BlockPtr();
    err = SKY_coin_GetBlockObject(block, pBlockP);
    assertEquals(err, SKY_OK);
    coin__Block pBlock = coin__BlockPtr_value(pBlockP);
    coin__BlockHeader pBH = pBlock.getHead();

    pBH.setVersion((long)0x02);
    pBH.setTime(BigDecimal.valueOf(100).toBigInteger());
    pBH.setBkSeq(BigDecimal.valueOf(0).toBigInteger());
    pBH.setFee(BigDecimal.valueOf(10).toBigInteger());
    pBlock.setHead(pBH);

    SWIGTYPE_p_BlockBody__Handle body = new_BlockBody__HandlePtr();
    err = SKY_coin_GetBlockBody(block, body);
    assertEquals(err, SKY_OK);
    err = SKY_coin_BlockBody_Hash(body, bodyhash);
    assertEquals(err, SKY_OK);
    err = SKY_coin_NewBlock(block, BigDecimal.valueOf(100 + 200).toBigInteger(),
                            uxHash, transactions, utils.feeCalc, newBlock);
    assertEquals(err, SKY_OK);
    return err;
  }

  @Test

  public void TestNewBlock() {
    SWIGTYPE_p_Transactions__Handle txns = utils.makeTransactions(1);
    SWIGTYPE_p_Block__Handle block = new_Block__HandlePtr();
    long err = SKY_coin_NewEmptyBlock(txns, block);
    assertEquals(err, SKY_OK);
    SWIGTYPE_p_p_coin__Block pBlockP = new_coin__BlockPtr();
    err = SKY_coin_GetBlockObject(block, pBlockP);
    assertEquals(err, SKY_OK);
    coin__Block pBlock = coin__BlockPtr_value(pBlockP);
    coin__BlockHeader pBlockTemp = pBlock.getHead();
    pBlockTemp.setVersion(0x02);
    pBlockTemp.setTime(BigDecimal.valueOf(100).toBigInteger());
    pBlockTemp.setBkSeq(BigDecimal.valueOf(98).toBigInteger());
    pBlock.setHead(pBlockTemp);
    cipher_SHA256 uxHash = utils.RandSHA256();
    // invalid txn fees panics
    err = SKY_coin_NewBlock(block, BigDecimal.valueOf(133).toBigInteger(),
                            uxHash, txns, utils.badCalc, block);
    assertEquals(err, SKY_ERROR);
    // no txns panics
    SWIGTYPE_p_Transactions__Handle tnxs1 = new_Transactions__HandlePtr();
    SKY_coin_Create_Transactions(tnxs1);
    err = SKY_coin_NewBlock(block, BigDecimal.valueOf(133).toBigInteger(),
                            uxHash, tnxs1, utils.feeCalc, block);
    assertEquals(err, SKY_ERROR);

    // Valid block in fine
    long fee = 121;
    BigInteger currentTime = BigDecimal.valueOf(133).toBigInteger();
    SWIGTYPE_p_Block__Handle b = new_Block__HandlePtr();
    err = SKY_coin_NewBlock(block, currentTime, uxHash, txns, utils.fix121, b);
    assertEquals(err, SKY_OK);

    SWIGTYPE_p_p_coin__Block pBlock2P = new_coin__BlockPtr();
    err = SKY_coin_GetBlockObject(b, pBlock2P);
    coin__Block pBlock2 = coin__BlockPtr_value(pBlock2P);
    assertEquals(pBlock2.getHead().getFee(),
                 BigDecimal.valueOf(fee).toBigInteger());
    cipher_SHA256 prevHash = new cipher_SHA256();
    cipher_SHA256 prevHashP = new cipher_SHA256();
    SKY_coin_Block_PreHashHeader(block, prevHash);
    SKY_coin_Block_HashHeader(b, prevHashP);
    assertEquals(prevHash.isEqual(prevHashP), 0);
    assertEquals(pBlock2.getHead().getTime(), currentTime);
    assertEquals(
        pBlock2.getHead().getBkSeq(),
        pBlock.getHead().getBkSeq().add(BigDecimal.valueOf(1).toBigInteger()));
    cipher_SHA256 pUxHash = new cipher_SHA256();
    convertGoUint8toSHA256(pBlock2.getHead().getUxHash(), pUxHash);
    assertEquals(uxHash.isEqual(pUxHash), 1);
  }

  @Test

  public void TestBlockHashHeader() {
    cipher_SHA256 uxHash = utils.RandSHA256();
    SWIGTYPE_p_Block__Handle b = new_Block__HandlePtr();
    long err = makeNewBlock(uxHash, b);
    assertEquals(err, SKY_OK);

    cipher_SHA256 sha1 = new cipher_SHA256();
    cipher_SHA256 sha2 = new cipher_SHA256();
    err = SKY_coin_Block_HashHeader(b, sha1);
    assertEquals(err, SKY_OK);

    SWIGTYPE_p_p_coin__Block chP = new_coin__BlockPtr();
    SKY_coin_GetBlockObject(b, chP);
    coin__Block ch = coin__BlockPtr_value(chP);
    SKY_coin_BlockHeader_Hash(ch.getHead(), sha2);
    assertEquals(sha1.isEqual(sha2), 1);
    assertEquals(sha1.isEqual(new cipher_SHA256()), 0);
  }

  @Test

  public void TestBlockHashBody() {
    cipher_SHA256 uxHash = utils.RandSHA256();
    SWIGTYPE_p_Block__Handle b = new_Block__HandlePtr();
    long err = makeNewBlock(uxHash, b);
    assertEquals(err, SKY_OK);

    cipher_SHA256 sha1 = new cipher_SHA256();
    cipher_SHA256 sha2 = new cipher_SHA256();
    SKY_coin_Block_HashBody(b, sha1);
    SWIGTYPE_p_BlockBody__Handle body = new_BlockBody__HandlePtr();
    SKY_coin_GetBlockBody(b, body);
    SKY_coin_BlockBody_Hash(body, sha2);
    assertEquals(sha1.isEqual(sha2), 1);
    cipher_SHA256 hb = new cipher_SHA256();
    SKY_coin_Block_HashBody(b, hb);
    cipher_SHA256 bh = new cipher_SHA256();
    SKY_coin_BlockBody_Hash(body, bh);
    assertEquals(bh.isEqual(hb), 1);
  }

  @Test

  public void TestNewGenesisBlock() {
    cipher_PubKey pubkey = new cipher_PubKey();
    cipher_SecKey seckey = new cipher_SecKey();
    BigInteger genTime = BigDecimal.valueOf(1000).toBigInteger();
    BigInteger genCoins = BigDecimal.valueOf(1000e6).toBigInteger();
    BigInteger zero = BigDecimal.valueOf(0).toBigInteger();

    long err = SKY_cipher_GenerateKeyPair(pubkey, seckey);
    assertEquals(err, SKY_OK);
    cipher__Address addr = new cipher__Address();
    err = SKY_cipher_AddressFromPubKey(pubkey, addr);
    assertEquals(err, SKY_OK);
    SWIGTYPE_p_Block__Handle block = new_Block__HandlePtr();
    err = SKY_coin_NewGenesisBlock(addr, genCoins, genTime, block);
    assertEquals(err, SKY_OK);
    SWIGTYPE_p_p_coin__Block pBlockPP = new_coin__BlockPtr();
    err = SKY_coin_GetBlockObject(block, pBlockPP);
    coin__Block pBlock = coin__BlockPtr_value(pBlockPP);
    assertEquals(err, SKY_OK);
    cipher_SHA256 nullHash = new cipher_SHA256();
    GoSlice Head = new GoSlice();
    err = SKY_coin_BlockHeader_Bytes(pBlock.getHead(), Head);
    assertEquals(err, SKY_OK);
    _GoString_ strnullHash = nullHash.getStr();
    _GoString_ strHead = new _GoString_();
    Head.getString(strHead);
    assertEquals(strnullHash.getP(), strHead.getP());
    assertEquals(genTime, pBlock.getHead().getTime());
    assertEquals(zero, pBlock.getHead().getBkSeq());
    assertEquals(0, pBlock.getHead().getVersion());
    assertEquals(zero, pBlock.getHead().getFee());
  }

  class testcase {
    public int index;
    public int failure;
  }

  @Test

  public void TestCreateUnspent() {
    cipher_PubKey p = new cipher_PubKey();
    cipher_SecKey s = new cipher_SecKey();
    cipher__Address a = new cipher__Address();

    long err = SKY_cipher_GenerateKeyPair(p, s);
    assertEquals(err, SKY_OK);
    err = SKY_cipher_AddressFromPubKey(p, a);
    assertEquals(err, SKY_OK);
    cipher_SHA256 h = new cipher_SHA256();
    SWIGTYPE_p_Transaction__Handle handle = new_Transaction__HandlePtr();
    makeEmptyTransaction(handle);
    err = SKY_coin_Transaction_PushOutput(
        handle, a, BigDecimal.valueOf(11000000).toBigInteger(),
        BigDecimal.valueOf(255).toBigInteger());
    assertEquals(err, SKY_OK);
    coin__BlockHeader bh = new coin__BlockHeader();
    bh.setTime(BigInteger.valueOf(0));
    bh.setBkSeq(BigInteger.valueOf(1));
    testcase[] t = new testcase[2];
    testcase tc = new testcase();
    tc.index = 0;
    tc.failure = SKY_OK;
    t[0] = tc;
    tc = new testcase();
    tc.failure = SKY_ERROR;
    tc.index = 10;
    t[1] = tc;
    coin__UxOut ux = new coin__UxOut();
    long tests_count = t.length;
    for (int i = 0; i < tests_count; i++) {
      err = SKY_coin_CreateUnspent(bh, handle, t[i].index, ux);
      if (t[i].failure == SKY_ERROR) {
        continue;
      }
      assertEquals(bh.getTime(), ux.getHead().getTime());
      assertEquals(bh.getBkSeq(), ux.getHead().getBkSeq());
    }
  }

  @Test

  public void TestCreateUnspents() {
    cipher__Address a = new cipher__Address();
    cipher_PubKey p = new cipher_PubKey();
    cipher_SecKey s = new cipher_SecKey();

    long err = SKY_cipher_GenerateKeyPair(p, s);
    assertEquals(err, SKY_OK);
    err = SKY_cipher_AddressFromPubKey(p, a);
    assertEquals(err, SKY_OK);
    cipher_SHA256 h = new cipher_SHA256();
    SWIGTYPE_p_Transaction__Handle txn = new_Transaction__HandlePtr();
    makeEmptyTransaction(txn);
    err = SKY_coin_Transaction_PushOutput(
        txn, a, BigDecimal.valueOf(11e6).toBigInteger(),
        BigInteger.valueOf(255));
    assertEquals(err, SKY_OK);
    coin__BlockHeader bh = new coin__BlockHeader();
    bh.setTime(BigInteger.valueOf(0));
    bh.setBkSeq(BigInteger.valueOf(1));
    coin_UxOutArray uxouts = new coin_UxOutArray();
    err = SKY_coin_CreateUnspents(bh, txn, uxouts);
    assertEquals(err, SKY_OK);
    assertEquals(uxouts.getCount(), 1);
  }
}