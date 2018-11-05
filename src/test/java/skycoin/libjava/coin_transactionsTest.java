package skycoin.libjava;

import static org.junit.Assert.*;

import java.math.*;

import org.junit.Test;
import skycoin.libjava.*;

/**
 * Unit test for simple App.
 */
public class coin_transactionsTest extends skycoin {
  static { System.loadLibrary("skycoin"); }

  transutils utils = new transutils();

  @Test
  public void TestTransactionVerify() {

    // Mismatch header hash
    SWIGTYPE_p_Transaction__Handle tx = utils.makeEmptyTransaction();
    coin__Transaction ptx = makeTransaction(tx);
    ptx.setInnerHash(new cipher_SHA256());
    long err = SKY_coin_Transaction_Verify(tx);
    assertEquals(err, SKY_ERROR);

    // No inputs
    tx = new_Transaction__HandlePtr();
    makeTransaction(tx);
    err = SKY_coin_Transaction_ResetInputs(tx, 0);
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_UpdateHeader(tx);
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_Verify(tx);
    assertEquals(err, SKY_ERROR);

    // No outputs
    makeTransaction(tx);
    err = SKY_coin_Transaction_ResetOutputs(tx, 0);
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_UpdateHeader(tx);
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_Verify(tx);
    assertEquals(err, SKY_ERROR);

    // Invalid number of Sigs
    makeTransaction(tx);
    err = SKY_coin_Transaction_ResetSignatures(tx, 0);
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_UpdateHeader(tx);
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_Verify(tx);
    assertEquals(err, SKY_ERROR);
    err = SKY_coin_Transaction_ResetSignatures(tx, 20);
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_UpdateHeader(tx);
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_Verify(tx);
    assertEquals(err, SKY_ERROR);

    // Too many sigs & inputs
    makeTransaction(tx);
    err = SKY_coin_Transaction_ResetSignatures(tx, utils.MaxValue16);
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_ResetInputs(tx, utils.MaxValue16);
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_UpdateHeader(tx);
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_Verify(tx);
    assertEquals(err, SKY_ERROR);

    // Duplicate inputs
    coin__UxOut ux = new coin__UxOut();
    cipher_SecKey s = new cipher_SecKey();
    cipher_SHA256 h = new cipher_SHA256();

    makeUxOutWithSecret(ux, s);
    makeTransactionFromUxOut(ux, s, tx);
    err = SKY_coin_Transaction_GetInputAt(tx, 0, h);
    assertEquals(err, SKY_OK);
    SWIGTYPE_p_unsigned_short p1 = new_GoUint16Ptr();
    err = SKY_coin_Transaction_PushInput(tx, h, p1);
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_ResetSignatures(tx, 0);
    assertEquals(err, SKY_OK);
    cipher_SecKeys secKeys = new cipher_SecKeys();
    secKeys.allocate(2);
    secKeys.setAt(0, s);
    secKeys.setAt(1, s);
    err = SKY_coin_Transaction_SignInputs(tx, secKeys);
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_UpdateHeader(tx);
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_Verify(tx);
    assertEquals(err, SKY_ERROR);

    // Duplicate outputs
    makeTransaction(tx);
    coin__TransactionOutput pOutput = new coin__TransactionOutput();
    err = SKY_coin_Transaction_GetOutputAt(tx, 0, pOutput);
    pOutput.setAddress(new cipher__Address());
    err = SKY_coin_Transaction_ResetOutputs(tx, 0);
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_PushOutput(
        tx, pOutput.getAddress(), pOutput.getCoins(), pOutput.getHours());
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_PushOutput(
        tx, pOutput.getAddress(), pOutput.getCoins(), pOutput.getHours());
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_UpdateHeader(tx);
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_Verify(tx);
    assertEquals(err, SKY_ERROR);

    // Output coins are 0
    makeTransaction(tx);
    err = SKY_coin_Transaction_GetOutputAt(tx, 0, pOutput);
    pOutput.setCoins(BigInteger.valueOf(0));
    err = SKY_coin_Transaction_ResetOutputs(tx, 0);
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_PushOutput(
        tx, pOutput.getAddress(), pOutput.getCoins(), pOutput.getHours());
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_UpdateHeader(tx);
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_Verify(tx);
    assertEquals(err, SKY_ERROR);

    // Output coin overflow
    makeTransaction(tx);
    err = SKY_coin_Transaction_GetOutputAt(tx, 0, pOutput);
    pOutput.setCoins(utils.bigIntegerMaxValue.subtract(
        BigDecimal.valueOf(3e6).toBigInteger()));
    err = SKY_coin_Transaction_PushOutput(
        tx, pOutput.getAddress(), pOutput.getCoins(), pOutput.getHours());
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_UpdateHeader(tx);
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_Verify(tx);
    assertEquals(err, SKY_ERROR);

    // Output coins are not multiples of 1e6 (valid, decimal restriction is not
    // enforced here)
    makeTransaction(tx);
    err = SKY_coin_Transaction_GetOutputAt(tx, 0, pOutput);
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_ResetOutputs(tx, 0);
    assertEquals(err, SKY_OK);
    pOutput.setCoins(pOutput.getCoins().add(BigInteger.valueOf(10)));
    err = SKY_coin_Transaction_PushOutput(
        tx, pOutput.getAddress(), pOutput.getCoins(), pOutput.getHours());
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_UpdateHeader(tx);
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_ResetSignatures(tx, 0);
    assertEquals(err, SKY_OK);
    cipher_PubKey p = new cipher_PubKey();
    s = new cipher_SecKey();
    err = SKY_cipher_GenerateKeyPair(p, s);
    assertEquals(err, SKY_OK);
    secKeys = new cipher_SecKeys();
    secKeys.allocate(1);
    secKeys.setAt(0, s);
    err = SKY_coin_Transaction_SignInputs(tx, secKeys);
    assertEquals(err, SKY_OK);
    assertTrue(pOutput.getCoins().mod(BigDecimal.valueOf(3e6).toBigInteger()) !=
               BigInteger.valueOf(0));
    err = SKY_coin_Transaction_Verify(tx);
    assertEquals(err, SKY_OK);
    // Valid
    makeTransaction(tx);
    err = SKY_coin_Transaction_GetOutputAt(tx, 0, pOutput);
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_ResetOutputs(tx, 0);
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_PushOutput(
        tx, pOutput.getAddress(), BigDecimal.valueOf(10e6).toBigInteger(),
        pOutput.getHours());
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_PushOutput(
        tx, pOutput.getAddress(), BigDecimal.valueOf(1e6).toBigInteger(),
        pOutput.getHours());
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_UpdateHeader(tx);
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_Verify(tx);
    assertEquals(err, SKY_OK);
  }

  @Test

  public void TestTransactionVerifyInput() {
    // Valid
    coin__UxOut ux = new coin__UxOut();
    cipher_SecKey s = new cipher_SecKey();
    makeUxOutWithSecret(ux, s);
    SWIGTYPE_p_Transaction__Handle tx = new_Transaction__HandlePtr();
    makeTransactionFromUxOut(ux, s, tx);
    coin_UxOutArray seckeys = new coin_UxOutArray();
    seckeys.allocate(1);
    seckeys.setAt(0, ux);
    long err = SKY_coin_Transaction_VerifyInput(tx, seckeys);
    assertEquals(err, SKY_OK);
  }

  @Test

  public void TestTransactionPushInput() {
    SWIGTYPE_p_Transaction__Handle tx = new_Transaction__HandlePtr();
    makeEmptyTransaction(tx);
    coin__UxOut ux = new coin__UxOut();
    makeUxOut(ux);
    cipher_SHA256 sha = new cipher_SHA256();
    long err = SKY_coin_UxOut_Hash(ux, sha);
    assertEquals(err, SKY_OK);
    SWIGTYPE_p_unsigned_short r = new_GoUint16Ptr();
    err = SKY_coin_Transaction_PushInput(tx, sha, r);
    assertEquals(GoUint16Ptr_value(r), 0);
    SWIGTYPE_p_long_long count = new_GointPtr();
    err = SKY_coin_Transaction_GetInputsCount(tx, count);
    assertEquals(err, SKY_OK);
    assertEquals(GointPtr_value(count), 1);
    cipher_SHA256 sha1 = new cipher_SHA256();
    err = SKY_coin_Transaction_GetInputAt(tx, 0, sha1);
    assertEquals(err, SKY_OK);
    assertEquals(sha.isEqual(sha1), 1);
    err = SKY_coin_Transaction_ResetInputs(tx, 0);
    assertEquals(err, SKY_OK);
    for (long i = 0; i < utils.MaxValue16; i++) {
      r = new_GoUint16Ptr();
      err = SKY_coin_Transaction_PushInput(tx, new cipher_SHA256(), r);
      assertEquals(err, SKY_OK);
    }
    makeUxOut(ux);
    err = SKY_coin_UxOut_Hash(ux, sha);
    assertEquals(err, SKY_OK);
  }

  @Test

  public void TestTransactionPushOutput() {
    SWIGTYPE_p_Transaction__Handle tx = utils.makeEmptyTransaction();
    cipher__Address a = utils.makeAddress();
    long err = SKY_coin_Transaction_PushOutput(tx, a, BigInteger.valueOf(100),
                                               BigInteger.valueOf(150));
    assertEquals(err, SKY_OK);
    SWIGTYPE_p_long_long count = new_GointPtr();
    err = SKY_coin_Transaction_GetOutputsCount(tx, count);
    assertEquals(err, SKY_OK);
    assertEquals(GointPtr_value(count), 1);
    coin__TransactionOutput pOut1 = new coin__TransactionOutput();
    coin__TransactionOutput pOut = new coin__TransactionOutput();
    pOut1.setAddress(a);
    pOut1.setCoins(BigInteger.valueOf(100));
    pOut1.setHours(BigInteger.valueOf(150));
    err = SKY_coin_Transaction_GetOutputAt(tx, 0, pOut);
    assertEquals(err, SKY_OK);
    assertEquals(pOut.isEqual(pOut1), 1);
    for (int i = 1; i < 20; i++) {
      a = utils.makeAddress();
      err = SKY_coin_Transaction_PushOutput(
          tx, a, BigInteger.valueOf(i).multiply(BigInteger.valueOf(100)),
          BigInteger.valueOf(i).multiply(BigInteger.valueOf(50)));
      assertEquals(err, SKY_OK);
      count = new_GointPtr();
      err = SKY_coin_Transaction_GetOutputsCount(tx, count);
      assertEquals(err, SKY_OK);
      assertEquals(GointPtr_value(count), (i + 1));
      pOut1 = new coin__TransactionOutput();
      pOut = new coin__TransactionOutput();
      pOut1.setAddress(a);
      pOut1.setCoins(BigInteger.valueOf(i).multiply(BigInteger.valueOf(100)));
      pOut1.setHours(BigInteger.valueOf(i).multiply(BigInteger.valueOf(50)));
      err = SKY_coin_Transaction_GetOutputAt(tx, i, pOut);
      assertEquals(err, SKY_OK);
      assertEquals(pOut.isEqual(pOut1), 1);
    }
  }

  @Test

  public void TestTransactionSignInputs() {
    SWIGTYPE_p_Transaction__Handle handle = utils.makeEmptyTransaction();
    // Panics if txns already signed
    cipher_Sig sig = new cipher_Sig();
    long err = SKY_coin_Transaction_PushSignature(handle, sig);
    assertEquals(err, SKY_OK);
    cipher_SecKeys seckeys = new cipher_SecKeys();
    seckeys.allocate(1);
    seckeys.setAt(0, new cipher_SecKey());
    // Panics if not enough keys
    handle = utils.makeEmptyTransaction();
    cipher_SecKey s = new cipher_SecKey();
    cipher_SecKey s2 = new cipher_SecKey();
    coin__UxOut ux = new coin__UxOut();
    coin__UxOut ux2 = new coin__UxOut();
    makeUxOutWithSecret(ux, s);
    cipher_SHA256 h = new cipher_SHA256();
    err = SKY_coin_UxOut_Hash(ux, h);
    assertEquals(err, SKY_OK);
    SWIGTYPE_p_unsigned_short r = new_GoUint16Ptr();
    err = SKY_coin_Transaction_PushInput(handle, h, r);
    assertEquals(err, SKY_OK);
    makeUxOutWithSecret(ux2, s2);
    err = SKY_coin_UxOut_Hash(ux2, h);
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_PushInput(handle, h, r);
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_PushOutput(handle, utils.makeAddress(),
                                          BigInteger.valueOf(40),
                                          BigInteger.valueOf(80));
    assertEquals(err, SKY_OK);
    SWIGTYPE_p_long_long count = new_GointPtr();
    err = SKY_coin_Transaction_GetSignaturesCount(handle, count);
    assertEquals(err, SKY_OK);
    assertEquals(GointPtr_value(count), 0);
    // Valid signing
    h = new cipher_SHA256();
    SKY_coin_Transaction_HashInner(handle, h);
    seckeys = new cipher_SecKeys();
    seckeys.allocate(2);
    seckeys.setAt(0, s);
    seckeys.setAt(1, s2);
    err = SKY_coin_Transaction_SignInputs(handle, seckeys);
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_GetSignaturesCount(handle, count);
    assertEquals(err, SKY_OK);
    assertEquals(GointPtr_value(count), 2);
    cipher_SHA256 h2 = new cipher_SHA256();
    err = SKY_coin_Transaction_HashInner(handle, h2);
    assertEquals(err, SKY_OK);
    assertEquals(h.isEqual(h2), 1);
    cipher_PubKey p = new cipher_PubKey();
    err = SKY_cipher_PubKeyFromSecKey(s, p);
    assertEquals(err, SKY_OK);
    cipher__Address a = new cipher__Address();
    cipher__Address a2 = new cipher__Address();
    err = SKY_cipher_AddressFromPubKey(p, a);
    assertEquals(err, SKY_OK);
    err = SKY_cipher_PubKeyFromSecKey(s2, p);
    assertEquals(err, SKY_OK);
    err = SKY_cipher_AddressFromPubKey(p, a2);
    assertEquals(err, SKY_OK);
    cipher_SHA256 sha1 = new cipher_SHA256();
    cipher_SHA256 sha2 = new cipher_SHA256();
    cipher_SHA256 txin0 = new cipher_SHA256();
    cipher_SHA256 txin1 = new cipher_SHA256();
    err = SKY_coin_Transaction_GetInputAt(handle, 0, txin0);
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_GetInputAt(handle, 1, txin1);
    assertEquals(err, SKY_OK);
    err = SKY_cipher_AddSHA256(h, txin0, sha1);
    assertEquals(err, SKY_OK);
    err = SKY_cipher_AddSHA256(h, txin1, sha2);
    assertEquals(err, SKY_OK);
    cipher_Sig txsig0 = new cipher_Sig();
    cipher_Sig txsig1 = new cipher_Sig();
    err = SKY_coin_Transaction_GetSignatureAt(handle, 0, txsig0);
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_GetSignatureAt(handle, 1, txsig1);
    assertEquals(err, SKY_OK);
  }

  @Test
  public void TestTransactionHash() {
    SWIGTYPE_p_Transaction__Handle handle = new_Transaction__HandlePtr();
    makeTransaction(handle);
    cipher_SHA256 h = new cipher_SHA256();
    cipher_SHA256 h2 = new cipher_SHA256();
    long err = SKY_coin_Transaction_Hash(handle, h);
    assertEquals(err, SKY_OK);
    assertEquals(h.isEqual(h2), 0);
    err = SKY_coin_Transaction_HashInner(handle, h2);
    assertEquals(err, SKY_OK);
    assertEquals(h.isEqual(h2), 0);
  }

  @Test

  public void TestTransactionUpdateHeader() {
    SWIGTYPE_p_Transaction__Handle handle = new_Transaction__HandlePtr();
    coin__Transaction tx = makeTransaction(handle);
    cipher_SHA256 h = new cipher_SHA256();
    cipher_SHA256 h1 = new cipher_SHA256();
    cipher_SHA256 h2 = new cipher_SHA256();
    long err = SKY_coin_Transaction_HashInner(handle, h);
    assertEquals(err, SKY_OK);
    tx.setInnerHash(new cipher_SHA256());
    err = SKY_coin_Transaction_UpdateHeader(handle);
    assertEquals(err, SKY_OK);
    cipher_SHA256 arg = new cipher_SHA256();
    arg = tx.GetInnerHash();
    h1.assignFrom(arg);
    err = SKY_coin_Transaction_HashInner(handle, h2);
    assertEquals(err, SKY_OK);
    assertEquals(h1.isEqual(new cipher_SHA256()), 0);
    assertEquals(h1.isEqual(h), 1);
    assertEquals(h1.isEqual(h2), 1);
  }

  @Test

  public void TestTransactionHashInner() {
    SWIGTYPE_p_Transaction__Handle handle = new_Transaction__HandlePtr();
    makeTransaction(handle);
    cipher_SHA256 h = new cipher_SHA256();
    long err = SKY_coin_Transaction_HashInner(handle, h);
    assertEquals(err, SKY_OK);
    assertEquals(h.isEqual(new cipher_SHA256()), 0);

    // If tx.In is changed, hash should change
    SWIGTYPE_p_Transaction__Handle handle2 = utils.copyTransaction(handle);
    assertEquals(err, SKY_OK);
    coin__UxOut ux = new coin__UxOut();
    makeUxOut(ux);
    h = new cipher_SHA256();
    cipher_SHA256 h1 = new cipher_SHA256();
    err = SKY_coin_UxOut_Hash(ux, h);
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_SetInputAt(handle2, 0, h);
    assertEquals(err, SKY_OK);
    err = SKY_coin_UxOut_Hash(ux, h1);
    assertEquals(err, SKY_OK);
    assertEquals(h.isEqual(h1), 1);
    err = SKY_coin_Transaction_HashInner(handle, h);
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_HashInner(handle2, h1);
    assertEquals(err, SKY_OK);
    assertEquals(h.isEqual(h1), 0);

    // If tx.Out is changed, hash should change
    handle2 = utils.copyTransaction(handle);
    cipher__Address a = utils.makeAddress();
    coin__TransactionOutput pOut = new coin__TransactionOutput();
    err = SKY_coin_Transaction_GetOutputAt(handle2, 0, pOut);
    assertEquals(err, SKY_OK);
    pOut.setAddress(a);
    err = SKY_coin_Transaction_SetOutputAt(handle2, 0, pOut);
    assertEquals(err, SKY_OK);
    cipher_SHA256 sha1 = new cipher_SHA256();
    cipher_SHA256 sha2 = new cipher_SHA256();
    err = SKY_coin_Transaction_HashInner(handle, sha1);
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_HashInner(handle2, sha2);
    assertEquals(err, SKY_OK);
    assertEquals(sha1.isEqual(sha2), 0);

    // If tx.Head is changed, hash should not change
    handle2 = utils.copyTransaction(handle);
    cipher_Sig sig = new cipher_Sig();
    err = SKY_coin_Transaction_PushSignature(handle, sig);
    assertEquals(err, SKY_OK);
    sha1 = new cipher_SHA256();
    sha2 = new cipher_SHA256();
    err = SKY_coin_Transaction_HashInner(handle, sha1);
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_HashInner(handle2, sha2);
    assertEquals(err, SKY_OK);
    assertEquals(sha1.isEqual(sha2), 1);
  }

  @Test

  public void TestTransactionSerialization() {
    SWIGTYPE_p_Transaction__Handle handle = new_Transaction__HandlePtr();
    coin__Transaction tx = makeTransaction(handle);
    GoSlice b = new GoSlice();
    long err = SKY_coin_Transaction_Serialize(handle, b);
    assertEquals(err, SKY_OK);
    SWIGTYPE_p_Transaction__Handle handle2 = new_Transaction__HandlePtr();
    err = SKY_coin_TransactionDeserialize(b, handle2);
    assertEquals(err, SKY_OK);
    coin__Transaction tx2 = new coin__Transaction();
    err = SKY_coin_GetTransactionObject(handle2, tx2);
    assertEquals(err, SKY_OK);
    assertEquals(tx.isEqual(tx2), 0);
  }

  @Test

  public void TestTransactionOutputHours() {
    SWIGTYPE_p_Transaction__Handle handle = utils.makeEmptyTransaction();
    long err = SKY_coin_Transaction_PushOutput(
        handle, utils.makeAddress(), BigDecimal.valueOf(1e6).toBigInteger(),
        BigInteger.valueOf(100));
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_PushOutput(
        handle, utils.makeAddress(), BigDecimal.valueOf(1e6).toBigInteger(),
        BigInteger.valueOf(200));
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_PushOutput(
        handle, utils.makeAddress(), BigDecimal.valueOf(1e6).toBigInteger(),
        BigInteger.valueOf(500));
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_PushOutput(
        handle, utils.makeAddress(), BigDecimal.valueOf(1e6).toBigInteger(),
        BigInteger.valueOf(0));
    assertEquals(err, SKY_OK);
    SWIGTYPE_p_unsigned_long_long hours = new_GoUint64Ptr();
    err = SKY_coin_Transaction_OutputHours(handle, hours);
    assertEquals(err, SKY_OK);
    assertEquals(GoUint64Ptr_value(hours), BigInteger.valueOf(800));
    err = SKY_coin_Transaction_PushOutput(
        handle, utils.makeAddress(), BigDecimal.valueOf(1e6).toBigInteger(),
        utils.bigIntegerMaxValue.subtract(BigInteger.valueOf(700)));
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_OutputHours(handle, hours);
    assertEquals(err, SKY_OK);
  }

  // @Test

  // public void
  // TestTransactionsSize() {
  // var handle = new_Transactions__Handlep();
  // long err = (uint)makeTransactions(10, handle);
  // var size = (long)0;
  // for (int i = 0; i < 10; i++) {
  // SWIGTYPE_p_Transaction__Handle tx = utils.makeEmptyTransaction();
  // err = SKY_coin_Transactions_GetAt(handle, i, tx);
  // assertEquals(err, SKY_OK);
  // GoSlice b = new GoSlice();
  // err = SKY_coin_Transaction_Serialize(tx, b);
  // assertEquals(err, SKY_OK);
  // size += b.len;
  // }
  // Assert.AreNotEqual(size, 0);
  // var sizetx = new_Gointp();
  // err = SKY_coin_Transactions_Size(handle, sizetx);
  // assertEquals(err, SKY_OK);
  // assertEquals(Gointp_value(sizetx), size);
  // }

  // @Test

  // public void
  // TestTransactionsHashes() {
  // var handle = new_Transactions__Handlep();
  // makeTransactions(4, handle);
  // var hashes = new cipher_SHA256s();
  // long err = SKY_coin_Transactions_Hashes(handle, hashes);
  // assertEquals(err, SKY_OK);
  // var len_hashes = hashes.count;
  // assertEquals(len_hashes, 4);
  // for (int i = 0; i < len_hashes; i++) {
  // var tx = new_Transaction__Handlep();
  // err = SKY_coin_Transactions_GetAt(handle, i, tx);
  // assertEquals(err, SKY_OK);
  // cipher_SHA256 h = new cipher_SHA256();
  // err = SKY_coin_Transaction_Hash(tx, h);
  // assertEquals(err, SKY_OK);
  // assertEquals(h.isEqual(hashes.getAt(i)), 1);
  // }
  // }

  // @Test

  // public void TestTransactionsTruncateBytesTo() {
  // var handles = new_Transactions__Handlep();
  // long err = (uint) makeTransactions(10, handles);
  // var trunc = (long) 0;
  // var count = new_Gointp();
  // var len_tnxs = new_Gointp();
  // err = SKY_coin_Transactions_Length(handles, len_tnxs);
  // long len_tnxs_value = Gointp_value(len_tnxs);
  // for (long i = 0; i < (len_tnxs_value / 2); i++) {
  // count = new_Gointp();
  // SWIGTYPE_p_Transaction__Handle handle = new_Transaction__HandlePtr();
  // err = SKY_coin_Transactions_GetAt(handles, (long) i, handle);
  // assertEquals(err, SKY_OK);
  // err = SKY_coin_Transaction_Size(handle, count);
  // assertEquals(err, SKY_OK);
  // trunc += Gointp_value(count);
  // }
  // // Trucating halfway
  // var tnxs2 = new_Transactions__Handlep();
  // err = SKY_coin_Transactions_TruncateBytesTo(handles, trunc, tnxs2);
  // assertEquals(err, SKY_OK);
  // var len_tnxs2 = new_Gointp();

  // err = SKY_coin_Transactions_Length(tnxs2, len_tnxs2);
  // assertEquals(err, SKY_OK);

  // assertEquals(err, SKY_OK);
  // assertEquals(Gointp_value(len_tnxs2), len_tnxs_value / 2);
  // count = new_Gointp();
  // err = SKY_coin_Transactions_Size(tnxs2, count);
  // assertEquals(err, SKY_OK);
  // assertEquals(Gointp_value(count), trunc);

  // // Stepping into next boundary has same cutoff, must exceed
  // trunc += 1;
  // err = SKY_coin_Transactions_TruncateBytesTo(handles, trunc, tnxs2);
  // assertEquals(err, SKY_OK);
  // err = SKY_coin_Transactions_Length(tnxs2, count);
  // assertEquals(err, SKY_OK);
  // assertEquals(Gointp_value(count), len_tnxs_value / 2);
  // err = SKY_coin_Transactions_Size(tnxs2, count);
  // assertEquals(err, SKY_OK);
  // assertEquals(Gointp_value(count), trunc - 1);

  // // Moving to 1 before next level
  // var tnxs_5 = utils.makeEmptyTransaction();
  // err = SKY_coin_Transactions_GetAt(handles, 5, tnxs_5);
  // assertEquals(err, SKY_OK);
  // count = new_Gointp();
  // err = SKY_coin_Transaction_Size(tnxs_5, count);
  // assertEquals(err, SKY_OK);
  // trunc += (Gointp_value(count) - 2);
  // err = SKY_coin_Transactions_TruncateBytesTo(handles, trunc, tnxs2);
  // assertEquals(err, SKY_OK);
  // err = SKY_coin_Transactions_Length(tnxs2, count);
  // assertEquals(err, SKY_OK);
  // assertEquals(Gointp_value(count), 5);
  // err = SKY_coin_Transactions_Size(tnxs2, count);
  // assertEquals(err, SKY_OK);
  // var count_tnxs5 = new_Gointp();
  // err = SKY_coin_Transaction_Size(tnxs_5, count_tnxs5);
  // assertEquals(err, SKY_OK);
  // assertEquals((trunc - Gointp_value(count_tnxs5) + 1), Gointp_value(count));

  // // Moving to next level
  // trunc += 1;
  // err = SKY_coin_Transactions_TruncateBytesTo(handles, trunc, tnxs2);
  // assertEquals(err, SKY_OK);
  // err = SKY_coin_Transactions_Length(tnxs2, count);
  // assertEquals(err, SKY_OK);
  // assertEquals(Gointp_value(count), 6);
  // err = SKY_coin_Transactions_Size(tnxs2, count);
  // assertEquals(err, SKY_OK);
  // assertEquals(Gointp_value(count), trunc);

  // // Truncating to full available amt
  // var trunc1 = new_Gointp();
  // err = SKY_coin_Transactions_Size(handles, trunc1);
  // assertEquals(err, SKY_OK);
  // err = SKY_coin_Transactions_TruncateBytesTo(handles, Gointp_value(trunc1),
  // tnxs2);
  // assertEquals(err, SKY_OK);
  // err = SKY_coin_Transactions_Size(tnxs2, count);
  // assertEquals(err, SKY_OK);
  // assertEquals(Gointp_value(count), Gointp_value(trunc1));

  // // Truncating to 0
  // trunc = 0;
  // err = SKY_coin_Transactions_TruncateBytesTo(handles, 0, tnxs2);
  // assertEquals(err, SKY_OK);
  // err = SKY_coin_Transactions_Length(tnxs2, count);
  // assertEquals(err, SKY_OK);
  // assertEquals(Gointp_value(count), 0);
  // err = SKY_coin_Transactions_Size(tnxs2, count);
  // assertEquals(err, SKY_OK);
  // assertEquals(Gointp_value(count), trunc);
  // }

  // struct ux
  // {
  // public ulong coins;
  // public ulong hours;}
  // struct StrTest{
  // public string name;
  // public ux[] inUxs;
  // public ux[] outUxs;
  // public int err;
  // public ulong headTime;}

  // StrTest[] cases;

  // public void FullCases() {
  // cases = new StrTest[5];

  // var c = new StrTest();
  // c.name = "Input coins overflow";
  // c.err = SKY_ERROR;
  // c.inUxs = new ux[2];
  // c.inUxs[0].coins = (ulong)(ulong.MaxValue - 1e6 + 1);
  // c.inUxs[0].hours = 10;
  // c.inUxs[1].coins = (ulong)1e6;
  // c.inUxs[1].hours = 0;
  // c.outUxs = new ux[0];
  // c.headTime = 0;
  // cases[0] = c;

  // c = new StrTest();
  // c.name = "Output coins overflow";
  // c.err = SKY_ERROR;
  // c.inUxs = new ux[1];
  // c.inUxs[0].coins = (ulong)10e6;
  // c.inUxs[0].hours = 10;
  // c.outUxs = new ux[2];
  // c.outUxs[0].coins = (ulong)(ulong.MaxValue - 10e6 + 1);
  // c.outUxs[0].coins = 0;
  // c.outUxs[1].coins = (ulong)20e6;
  // c.outUxs[1].hours = 1;
  // c.headTime = 0;
  // cases[1] = c;

  // c = new StrTest();
  // c.name = "Insufficient coins";
  // c.err = SKY_ERROR;
  // // c.headTime = 0;
  // c.inUxs = new ux[2];
  // c.inUxs[0].coins = (ulong)10e6;
  // c.inUxs[0].hours = 10;
  // c.inUxs[1].coins = (ulong)15e6;
  // c.inUxs[1].hours = 10;
  // c.outUxs = new ux[2];
  // c.outUxs[0].coins = (ulong)20e6;
  // c.outUxs[0].coins = 1;
  // c.outUxs[1].coins = (ulong)10e6;
  // c.outUxs[1].hours = 1;
  // cases[2] = c;

  // c = new StrTest();
  // c.name = "Destroyed coins";
  // c.err = SKY_ERROR;
  // c.inUxs = new ux[2];
  // c.inUxs[0].coins = (ulong)10e6;
  // c.inUxs[0].hours = 10;
  // c.inUxs[1].coins = (ulong)15e6;
  // c.inUxs[1].hours = 10;
  // c.outUxs = new ux[2];
  // c.outUxs[0].coins = (ulong)5e6;
  // c.outUxs[0].coins = 1;
  // c.outUxs[1].coins = (ulong)10e6;
  // c.outUxs[1].hours = 1;
  // c.headTime = 0;
  // cases[3] = c;

  // c = new StrTest();
  // c.name = "valid";
  // c.inUxs = new ux[2];
  // c.inUxs[0].coins = (ulong)10e6;
  // c.inUxs[0].hours = 10;
  // c.inUxs[1].coins = (ulong)15e6;
  // c.inUxs[1].hours = 10;
  // c.outUxs = new ux[3];
  // c.outUxs[0].coins = (ulong)10e6;
  // c.outUxs[0].hours = 11;
  // c.outUxs[1].coins = (ulong)10e6;
  // c.outUxs[1].hours = 1;
  // c.outUxs[2].coins = (ulong)5e6;
  // c.outUxs[2].hours = 0;
  // c.headTime = 0;
  // c.err = SKY_OK;
  // cases[4] = c;
  // }

  // @Test

  // public void TestVerifyTransactionCoinsSpending() {
  // FullCases();
  // for (int i = 0; i < cases.Length; i++) {
  // var tc = cases[i];
  // var uxIn = new coin_UxOutArray();
  // var uxOut = new coin_UxOutArray();

  // uxIn.allocate(tc.inUxs.Length);
  // uxOut.allocate(tc.outUxs.Length);
  // for (int j = 0; j < tc.inUxs.Length; j++) {
  // var ch = tc.inUxs[j];
  // var puxIn = new coin__UxOut();
  // puxIn.Body.Coins = ch.coins;
  // puxIn.Body.Hours = ch.hours;
  // uxIn.setAt(j, puxIn);
  // }
  // for (int j = 0; j < tc.outUxs.Length; j++) {
  // var ch = tc.outUxs[j];
  // var puxOut = new coin__UxOut();
  // puxOut.Body.Coins = ch.coins;
  // puxOut.Body.Hours = ch.hours;
  // uxOut.setAt(j, puxOut);
  // }
  // assertEquals(tc.inUxs.Length, uxIn.count);
  // assertEquals(tc.outUxs.Length, uxOut.count);
  // long err = SKY_coin_VerifyTransactionCoinsSpending(uxIn, uxOut);
  // assertEquals(err, tc.err, "Iteration " + i.ToString() + tc.name);
  // }
  // }

  // public void FullCases2() {

  // cases = new StrTest[7];
  // var c = new StrTest();
  // c.name = "Input coins overflow";
  // c.err = SKY_ERROR;
  // c.inUxs = new ux[2];
  // c.inUxs[0].hours = (ulong)(ulong.MaxValue - 1e6 + 1);
  // c.inUxs[0].coins = (ulong)3e6;
  // c.inUxs[1].coins = (ulong)1e6;
  // c.inUxs[1].hours = (ulong)1e6;
  // c.outUxs = new ux[0];
  // cases[0] = c;

  // c = new StrTest();
  // c.name = "Insufficient coin hours";
  // c.inUxs = new ux[2];
  // c.inUxs[0].coins = (ulong)10e6;
  // c.inUxs[0].hours = 10;
  // c.inUxs[1].coins = (ulong)15e6;
  // c.inUxs[1].hours = 10;
  // c.outUxs = new ux[2];
  // c.outUxs[0].coins = (ulong)15e6;
  // c.outUxs[0].hours = 10;
  // c.outUxs[1].coins = (ulong)10e6;
  // c.outUxs[1].hours = 11;
  // c.headTime = 0;
  // c.err = SKY_ERROR;
  // cases[1] = c;

  // c = new StrTest();
  // c.name = "coin hours time calculation overflow";
  // c.err = SKY_ERROR;
  // c.inUxs = new ux[2];
  // c.inUxs[0].coins = (ulong)10e6;
  // c.inUxs[0].hours = 10;
  // c.inUxs[1].coins = (ulong)15e6;
  // c.inUxs[1].hours = 10;
  // c.outUxs = new ux[3];
  // c.outUxs[0].coins = (ulong)10e6;
  // c.outUxs[0].hours = 11;
  // c.outUxs[1].coins = (ulong)10e6;
  // c.outUxs[1].hours = 1;
  // c.outUxs[2].coins = (ulong)5e6;
  // c.outUxs[2].hours = 0;
  // c.headTime = ulong.MaxValue;
  // cases[2] = c;

  // c = new StrTest();
  // c.name =
  // "Invalid (coin hours overflow when adding earned hours, which is treated as
  // 0, and now enough coin hours)";
  // c.err = SKY_ERROR;
  // c.inUxs = new ux[1];
  // c.inUxs[0].coins = (ulong)10e6;
  // c.inUxs[0].hours = ulong.MaxValue;
  // c.outUxs = new ux[1];
  // c.outUxs[0].coins = (ulong)10e6;
  // c.outUxs[0].hours = 1;
  // c.headTime = (long)1e6;
  // cases[3] = c;

  // c = new StrTest();
  // c.name =
  // "Valid (coin hours overflow when adding earned hours, which is treated as
  // 0, but not sending any hours)"; c.inUxs = new ux[1]; c.inUxs[0].coins =
  // (ulong)10e6; c.inUxs[0].hours = ulong.MaxValue; c.outUxs = new ux[1];
  // c.outUxs[0].coins = (ulong)10e6;
  // c.outUxs[0].hours = 0;
  // c.headTime = (long)1e6;
  // cases[4] = c;

  // c = new StrTest();
  // c.name =
  // "Valid (base inputs have insufficient coin hours, but have sufficient after
  // adjusting coinhours by headTime)";
  // c.inUxs = new ux[2];
  // c.inUxs[0].coins = (ulong)10e6;
  // c.inUxs[0].hours = 10;
  // c.inUxs[1].coins = (ulong)15e6;
  // c.inUxs[1].hours = 10;
  // c.outUxs = new ux[2];
  // c.outUxs[0].coins = (ulong)15e6;
  // c.outUxs[0].hours = 10;
  // c.outUxs[1].coins = (ulong)10e6;
  // c.outUxs[1].hours = 11;
  // c.headTime = 1492707255;
  // cases[5] = c;

  // c = new StrTest();
  // c.name = "valid";
  // c.inUxs = new ux[2];
  // c.inUxs[0].coins = (ulong)10e6;
  // c.inUxs[0].hours = 10;
  // c.inUxs[1].coins = (ulong)15e6;
  // c.inUxs[1].hours = 10;
  // c.outUxs = new ux[3];
  // c.outUxs[0].coins = (ulong)10e6;
  // c.outUxs[0].hours = 11;
  // c.outUxs[1].coins = (ulong)10e6;
  // c.outUxs[1].hours = 1;
  // c.outUxs[2].coins = (ulong)5e6;
  // c.outUxs[2].hours = 0;
  // cases[6] = c;
  // }

  // @Test

  // public void
  // TestVerifyTransactionHoursSpending() {
  // FullCases2();

  // for (int i = 0; i < cases.Length; i++) {
  // var tc = cases[i];
  // var uxIn = new coin_UxOutArray();
  // var uxOut = new coin_UxOutArray();

  // uxIn.allocate(tc.inUxs.Length);
  // uxOut.allocate(tc.outUxs.Length);
  // for (int j = 0; j < tc.inUxs.Length; j++) {
  // var ch = tc.inUxs[j];
  // var puxIn = new coin__UxOut();
  // puxIn.Body.Coins = ch.coins;
  // puxIn.Body.Hours = ch.hours;
  // uxIn.setAt(j, puxIn);
  // }
  // for (int j = 0; j < tc.outUxs.Length; j++) {
  // var ch = tc.outUxs[j];
  // var puxOut = new coin__UxOut();
  // puxOut.Body.Coins = ch.coins;
  // puxOut.Body.Hours = ch.hours;
  // uxOut.setAt(j, puxOut);
  // }
  // assertEquals(tc.inUxs.Length, uxIn.count);
  // assertEquals(tc.outUxs.Length, uxOut.count);
  // long err =
  // SKY_coin_VerifyTransactionHoursSpending(tc.headTime, uxIn, uxOut);
  // assertEquals(err, tc.err);
  // }
  // }

  // @Test

  // public void TestTransactionsFees() {
  // var txns = new_Transactions__Handlep();
  // SKY_coin_Create_Transactions(txns);

  // // Nil txns
  // var fee = new_GoUint64p();
  // long err = SKY_coin_Transactions_Fees(txns, utils.calc, fee);
  // assertEquals(err, SKY_OK);
  // assertEquals(GoUint64p_value(fee), 0);

  // var txn = new_Transaction__Handlep();
  // SKY_coin_Create_Transaction(txn);
  // err = SKY_coin_Transactions_Add(txns, txn);
  // assertEquals(err, SKY_OK);
  // err = SKY_coin_Transactions_Add(txns, txn);
  // assertEquals(err, SKY_OK);

  // // 2 transactions, calc() always returns 1
  // fee = new_GoUint64p();
  // err = SKY_coin_Transactions_Fees(txns, utils.calc, fee);
  // assertEquals(err, SKY_OK);
  // assertEquals(GoUint64p_value(fee), 2);

  // // calc error
  // fee = new_GoUint64p();
  // err = SKY_coin_Transactions_Fees(txns, utils.badCalc, fee);
  // assertEquals(err, SKY_ERROR);

  // // summing of calculated fees overflows
  // fee = new_GoUint64p();
  // err = SKY_coin_Transactions_Fees(txns, utils.overflow, fee);
  // assertEquals(err, SKY_ERROR);
  // }
}