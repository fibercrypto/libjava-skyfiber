package skyfiber.libjava;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class coin_blockTest extends skycoin {
    static {
        System.loadLibrary("skycoin");
    }

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

    public long makeNewBlock(cipher_SHA256 uxHash, SWIGTYPE_p_Block__Handle newBlock) {
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

        pBH.setVersion((long) 0x02);
        pBH.setTime(BigDecimal.valueOf(100).toBigInteger());
        pBH.setBkSeq(BigDecimal.valueOf(0).toBigInteger());
        pBH.setFee(BigDecimal.valueOf(10).toBigInteger());
        pBlock.setHead(pBH);

        SWIGTYPE_p_BlockBody__Handle body = new_BlockBody__HandlePtr();
        err = SKY_coin_GetBlockBody(block, body);
        assertEquals(err, SKY_OK);
        err = SKY_coin_BlockBody_Hash(body, bodyhash);
        assertEquals(err, SKY_OK);
        err = SKY_coin_NewBlock(block, BigDecimal.valueOf(100 + 200).toBigInteger(), uxHash, transactions,
                utils.feeCalc, newBlock);
        assertEquals(err, SKY_OK);
        return err;
    }

    @Test

    public void TestNewBlock() {

        SWIGTYPE_p_Block__Handle prevBlock = new_Block__HandlePtr();
        SWIGTYPE_p_Block__Handle newBlock = new_Block__HandlePtr();
        SWIGTYPE_p_BlockHeader__Handle pPrevBlockHeader = new_BlockHeader__HandlePtr();
        SWIGTYPE_p_Transactions__Handle txns = makeTestTransactions();
        long err = SKY_coin_NewEmptyBlock(txns, prevBlock);
        err = SKY_coin_Block_GetBlockHeader(prevBlock, pPrevBlockHeader);
        assertEquals(err, SKY_OK);

        SKY_coin_BlockHeader_SetTime(pPrevBlockHeader, utils.toBigInteger(100));
        SKY_coin_BlockHeader_SetBkSeq(pPrevBlockHeader, utils.toBigInteger(98));
        cipher_SHA256 uxHash = utils.RandSHA256();
        // invalid txn fees panics
        txns = new_Transactions__HandlePtr();
        SKY_coin_Create_Transactions(txns);
        err = SKY_coin_NewBlock(prevBlock, utils.toBigInteger(133), uxHash, txns, utils.badCalc, newBlock);
        assertEquals(err, SKY_ERROR);
        // no txns panics
        txns = new_Transactions__HandlePtr();
        SKY_coin_Create_Transactions(txns);
        err = SKY_coin_NewBlock(prevBlock, utils.toBigInteger(133), uxHash, txns, utils.feeCalc, newBlock);
        assertEquals(err, SKY_ERROR);

        // Valid block in fine
        txns = new_Transactions__HandlePtr();
        err = SKY_coin_Create_Transactions(txns);
        assertEquals(err, SKY_OK);
        SWIGTYPE_p_Transaction__Handle tnx = utils.makeEmptyTransaction();
        err = SKY_coin_Transactions_Add(txns, tnx);
        assertEquals(err, SKY_OK);

        long fee = 121;
        long currentTime = 133;
        newBlock = new_Block__HandlePtr();
        err = SKY_coin_NewBlock(prevBlock, utils.toBigInteger(currentTime), uxHash, txns, utils.fix121, newBlock);
        assertEquals(err, SKY_OK);

        SWIGTYPE_p_BlockHeader__Handle pnewBlockHeader = new_BlockHeader__HandlePtr();
        err = SKY_coin_Block_GetBlockHeader(newBlock, pnewBlockHeader);
        SWIGTYPE_p_unsigned_long_long pHeadFee = new_GoUint64Ptr();
        SWIGTYPE_p_unsigned_long_long pHeadTime = new_GoUint64Ptr();
        SWIGTYPE_p_unsigned_long_long pHeadBkSeq = new_GoUint64Ptr();
        SKY_coin_BlockHeader_Fee(pnewBlockHeader, pHeadFee);
        SKY_coin_BlockHeader_Time(pnewBlockHeader, pHeadTime);
        SKY_coin_BlockHeader_BkSeq(pnewBlockHeader, pHeadBkSeq);
        SWIGTYPE_p_long_long pTransLength = new_GoIntPtr();
        err = SKY_coin_Transactions_Length(txns, pTransLength);
        assertEquals(err, SKY_OK);
        assertEquals(GoUint64Ptr_value(pHeadFee), utils.toBigInteger((fee * GoIntPtr_value(pTransLength))));
        assertEquals(GoUint64Ptr_value(pHeadTime), utils.toBigInteger(currentTime));
        pPrevBlockHeader = new_BlockHeader__HandlePtr();
        err = SKY_coin_Block_GetBlockHeader(prevBlock, pPrevBlockHeader);
        assertEquals(err, SKY_OK);
        SWIGTYPE_p_unsigned_long_long pPrevBkSeq = new_GoUint64Ptr();
        SKY_coin_BlockHeader_BkSeq(pPrevBlockHeader, pPrevBkSeq);
        cipher_SHA256 pnewuxHash = new cipher_SHA256();
        SKY_coin_BlockHeader_UxHash(pnewBlockHeader, pnewuxHash);
        assertEquals(pnewuxHash.isEqual(uxHash), 1);

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

        SWIGTYPE_p_BlockHeader__Handle blockheader = new_BlockHeader__HandlePtr();
        err = SKY_coin_Block_GetBlockHeader(b, blockheader);
        assertEquals(err, SKY_OK);
        err = SKY_coin_BlockHeader_Hash(blockheader, sha2);
        assertEquals(err, SKY_OK);
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
        err = SKY_coin_Transaction_PushOutput(handle, a, BigDecimal.valueOf(11000000).toBigInteger(),
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
        err = SKY_coin_Transaction_PushOutput(txn, a, BigDecimal.valueOf(11e6).toBigInteger(), BigInteger.valueOf(255));
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