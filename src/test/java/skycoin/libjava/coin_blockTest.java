// package skycoin.libjava;

// import static org.junit.Assert.*;

// import java.math.BigDecimal;

// import org.junit.Test;
// import skycoin.libjava.skycoin;
// import skycoin.libjava.transutils;

// /**
// * Unit test for simple App.
// */
// public class coin_blockTest extends skycoin {
// static {
// System.loadLibrary("skycoin");
// }

// public SWIGTYPE_p_Transactions__Handle makeTestTransactions() {
// SWIGTYPE_p_Transactions__Handle txns = new_Transactions__HandlePtr();
// long err = SKY_coin_Create_Transactions(txns);
// assertEquals(err, SKY_OK);
// SWIGTYPE_p_Transaction__Handle txn = transutils.makeEmptyTransaction();
// err = SKY_coin_Transactions_Add(txns, txn);
// assertEquals(err, SKY_OK);
// return txns;
// }

// public long makeNewBlock(cipher_SHA256 uxHash, SWIGTYPE_p_Block__Handle
// newBlock) {
// cipher_SHA256 bodyhash = new cipher_SHA256();
// SWIGTYPE_p_Block__Handle block = new_Block__HandlePtr();
// SWIGTYPE_p_Transactions__Handle transactions = makeTestTransactions();
// long err = SKY_coin_NewEmptyBlock(transactions, block);
// assertEquals(err, SKY_OK);

// SWIGTYPE_p_p_coin__Block pBlockP = new_coin__BlockPtr();
// err = SKY_coin_GetBlockObject(block, pBlockP);
// assertEquals(err, SKY_OK);
// coin__Block pBlock = coin__BlockPtr_value(pBlockP);
// coin__BlockHeader pBH = pBlock.getHead();

// pBH.setVersion((long) 0x02);
// pBH.setTime(BigDecimal.valueOf(100).toBigInteger());
// pBH.setBkSeq(BigDecimal.valueOf(0).toBigInteger());
// pBH.setFee(BigDecimal.valueOf(10).toBigInteger());
// pBlock.setHead(pBH);

// SWIGTYPE_p_BlockBody__Handle body = new_BlockBody__HandlePtr();
// err = SKY_coin_GetBlockBody(block, body);
// assertEquals(err, SKY_OK);
// err = SKY_coin_BlockBody_Hash(body, bodyhash);
// assertEquals(err, SKY_OK);
// err = SKY_coin_NewBlock(block, 100 + 200, uxHash, transactions,
// transutils.feeCalc, newBlock);
// assertEquals(err, SKY_OK);
// return err;
// }

// // [Test]

// // public void
// // TestNewBlock() {
// // var txns = transutils.makeTransactions(1);
// // var block = new_Block__HandlePtr();
// // var err = SKY_coin_NewEmptyBlock(txns, block);
// // assertEquals(err, SKY_OK);
// // var pBlockP = new_coin__BlockPtr();
// // err = SKY_coin_GetBlockObject(block, pBlockP);
// // assertEquals(err, SKY_OK);
// // var pBlock = coin__BlockPtr_value(pBlockP);
// // pBlock.Head.Version = 0x02;
// // pBlock.Head.Time = 100;
// // pBlock.Head.BkSeq = 98;
// // var uxHash = transutils.RandSHA256();
// // // invalid txn fees panics
// // err =
// // SKY_coin_NewBlock(block, 133, uxHash, txns, transutils.badCalc, block);
// // assertEquals(err, SKY_ERROR);
// // // no txns panics
// // var tnxs1 = new_Transactions__Handlep();
// // SKY_coin_Create_Transactions(tnxs1);
// // err =
// // SKY_coin_NewBlock(block, 133, uxHash, tnxs1, transutils.feeCalc, block);
// // assertEquals(err, SKY_ERROR);

// // // Valid block in fine
// // ulong fee = 121;
// // ulong currentTime = 133;
// // var b = new_Block__HandlePtr();
// // err = SKY_coin_NewBlock(block, currentTime, uxHash, txns,
// transutils.fix121,
// // b);
// // assertEquals(err, SKY_OK);

// // var pBlock2P = new_coin__BlockPtr();
// // err = SKY_coin_GetBlockObject(b, pBlock2P);
// // var pBlock2 = coin__BlockPtr_value(pBlock2P);
// // assertEquals(pBlock2.Head.Fee, fee);
// // var hashs = GoUint8Ptr_value(pBlock2.Head.PrevHash);
// // var prevHash = new cipher_SHA256();
// // var prevHashP = new cipher_SHA256();
// // SKY_coin_Block_PreHashHeader(block, prevHash);
// // SKY_coin_Block_HashHeader(b, prevHashP);
// // assertEquals(prevHash.isEqual(prevHashP), 0);
// // assertEquals(pBlock2.Head.Time, currentTime);
// // assertEquals(pBlock2.Head.BkSeq, pBlock.Head.BkSeq + 1);
// // var pUxHash = new cipher_SHA256();
// // convertGoUint8toSHA256(pBlock2.Head.UxHash, pUxHash);
// // assertEquals(uxHash.isEqual(pUxHash), 1);
// // }

// // [Test]

// // public void
// // TestBlockHashHeader() {
// // var uxHash = transutils.RandSHA256();
// // var b = new_Block__HandlePtr();
// // var err = makeNewBlock(uxHash, b);
// // assertEquals(err, SKY_OK);

// // var sha1 = new cipher_SHA256();
// // var sha2 = new cipher_SHA256();
// // err = SKY_coin_Block_HashHeader(b, sha1);
// // assertEquals(err, SKY_OK);

// // var chP = new_coin__BlockPtr();
// // SKY_coin_GetBlockObject(b, chP);
// // var ch = coin__BlockPtr_value(chP);
// // SKY_coin_BlockHeader_Hash(ch.Head, sha2);
// // assertEquals(sha1.isEqual(sha2), 1);
// // assertEquals(sha1.isEqual(new cipher_SHA256()), 0);
// // }

// // [Test]

// // public void
// // TestBlockHashBody() {
// // var uxHash = transutils.RandSHA256();
// // var b = new_Block__HandlePtr();
// // var err = makeNewBlock(uxHash, b);
// // assertEquals(err, SKY_OK);

// // var sha1 = new cipher_SHA256();
// // var sha2 = new cipher_SHA256();
// // SKY_coin_Block_HashBody(b, sha1);
// // var body = new_BlockBody__HandlePtr();
// // SKY_coin_GetBlockBody(b, body);
// // SKY_coin_BlockBody_Hash(body, sha2);
// // assertEquals(sha1.isEqual(sha2), 1);
// // var hb = new cipher_SHA256();
// // SKY_coin_Block_HashBody(b, hb);
// // var bh = new cipher_SHA256();
// // SKY_coin_BlockBody_Hash(body, bh);
// // assertEquals(bh.isEqual(hb), 1);
// // }

// // [Test]

// // public void
// // TestNewGenesisBlock() {
// // var pubkey = new cipher_PubKey();
// // var seckey = new cipher_SecKey();
// // ulong genTime = 1000;
// // ulong genCoins = (ulong)1000e6;

// // var err = SKY_cipher_GenerateKeyPair(pubkey, seckey);
// // assertEquals(err, SKY_OK);
// // var addr = new cipher__Address();
// // err = SKY_cipher_AddressFromPubKey(pubkey, addr);
// // assertEquals(err, SKY_OK);
// // var block = new_Block__HandlePtr();
// // err = SKY_coin_NewGenesisBlock(addr, genCoins, genTime, block);
// // assertEquals(err, SKY_OK);
// // var pBlockPP = new_coin__BlockPtr();
// // err = SKY_coin_GetBlockObject(block, pBlockPP);
// // var pBlock = coin__BlockPtr_value(pBlockPP);
// // assertEquals(err, SKY_OK);
// // var nullHash = new cipher_SHA256();
// // var Head = new GoSlice();
// // err = SKY_coin_BlockHeader_Bytes(pBlock.Head, Head);
// // assertEquals(err, SKY_OK);
// // var strnullHash = nullHash.getStr();
// // var strHead = new _GoString_();
// // Head.getString(strHead);
// // assertEquals(strnullHash.p, strHead.p);
// // assertEquals(genTime, pBlock.Head.Time);
// // assertEquals(0, pBlock.Head.BkSeq);
// // assertEquals(0, pBlock.Head.Version);
// // assertEquals(0, pBlock.Head.Fee);
// // }

// // struct testcase {
// // public int index;
// // public int failure;
// // }

// // [Test]

// // public void

// // TestCreateUnspent() {
// // var p = new cipher_PubKey();
// // var s = new cipher_SecKey();
// // var a = new cipher__Address();

// // var err = SKY_cipher_GenerateKeyPair(p, s);
// // assertEquals(err, SKY_OK);
// // err = SKY_cipher_AddressFromPubKey(p, a);
// // assertEquals(err, SKY_OK);
// // var h = new cipher_SHA256();
// // var handle = new_Transaction__Handlep();
// // makeEmptyTransaction(handle);
// // err = SKY_coin_Transaction_PushOutput(handle, a, 11000000, 255);
// // assertEquals(err, SKY_OK);
// // var bh = new coin__BlockHeader();
// // bh.Time = 0;
// // bh.BkSeq = 1;
// // testcase[] t = new testcase[2];
// // var tc = new testcase();
// // tc.index = 0;
// // tc.failure = SKY_OK;
// // t[0] = tc;
// // tc = new testcase();
// // tc.failure = SKY_ERROR;
// // tc.index = 10;
// // t[1] = tc;
// // var ux = new coin__UxOut();
// // var tests_count = t.Length;
// // for (int i = 0; i < tests_count; i++) {
// // err = SKY_coin_CreateUnspent(bh, handle, t[i].index, ux);
// // if (t[i].failure == SKY_ERROR) {
// // continue;
// // }
// // assertEquals(bh.Time, ux.Head.Time);
// // assertEquals(bh.BkSeq, ux.Head.BkSeq);
// // }
// // }

// // [Test]

// // public void
// // TestCreateUnspents() {
// // var a = new cipher__Address();
// // var p = new cipher_PubKey();
// // var s = new cipher_SecKey();

// // var err = SKY_cipher_GenerateKeyPair(p, s);
// // assertEquals(err, SKY_OK);
// // err = SKY_cipher_AddressFromPubKey(p, a);
// // assertEquals(err, SKY_OK);
// // var h = new cipher_SHA256();
// // var txn = new_Transaction__Handlep();
// // makeEmptyTransaction(txn);
// // err = SKY_coin_Transaction_PushOutput(txn, a, (ulong)11e6, 255);
// // assertEquals(err, SKY_OK);
// // var bh = new coin__BlockHeader();
// // bh.Time = 0;
// // bh.BkSeq = 1;
// // var uxouts = new coin_UxOutArray();
// // err = SKY_coin_CreateUnspents(bh, txn, uxouts);
// // assertEquals(err, SKY_OK);
// // assertEquals(uxouts.count, 1);
// // }
// }