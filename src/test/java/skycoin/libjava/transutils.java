// package skycoin.libjava;

// import java.math.BigDecimal;
// import java.math.BigInteger;

// import static org.junit.Assert.assertEquals;

// public class transutils extends skycoin {
//     static {
//         System.loadLibrary("skycoin");
//     }
//    public String OS = System.getProperty("os.name");
//     public cipher__Address makeAddress() {
//         cipher_PubKey pubkey = new cipher_PubKey();
//         cipher_SecKey seckey = new cipher_SecKey();
//         cipher__Address addr = new cipher__Address();
//         long result = SKY_cipher_GenerateKeyPair(pubkey, seckey);
//         assertEquals(result, SKY_OK);
//         result = SKY_cipher_AddressFromPubKey(pubkey, addr);
//         return addr;
//     }

//     public SWIGTYPE_p_Transaction__Handle makeEmptyTransaction() {
//         SWIGTYPE_p_Transaction__Handle txn = new_Transaction__HandlePtr();
//         long result = SKY_coin_Create_Transaction(txn);
//         assertEquals(result, SKY_OK);
//         return txn;
//     }

//     public SWIGTYPE_p_Transaction__Handle
//     copyTransaction(SWIGTYPE_p_Transaction__Handle handle) {
//         SWIGTYPE_p_Transaction__Handle handle2 = new_Transaction__HandlePtr();
//         long err = SKY_coin_Transaction_Verify(handle);
//         assertEquals(err, SKY_OK);
//         err = SKY_coin_Transaction_Copy(handle, handle2);
//         assertEquals(err, SKY_OK);
//         return handle2;
//     }

//     public void makeTransactionFromUxOut(coin__UxOut ux, cipher_SecKey s,
//                                          SWIGTYPE_p_Transaction__Handle handle,
//                                          coin__Transaction ptx) {
//         handle = makeEmptyTransaction();
//         cipher_SHA256 h = new cipher_SHA256();
//         assertEquals(SKY_cipher_SecKey_Verify(s), SKY_OK);
//         long err = SKY_coin_UxOut_Hash(ux, h);
//         assertEquals(err, SKY_OK);
//         SWIGTYPE_p_unsigned_short r = new_GoUint16Ptr();
//         SKY_coin_Transaction_PushInput(handle, h, r);
//         assertEquals(err, SKY_OK);
//         err = SKY_coin_Transaction_PushOutput(
//                 handle, makeAddress(), BigDecimal.valueOf(1e6).toBigInteger(),
//                 BigDecimal.valueOf(50).toBigInteger());
//         assertEquals(err, SKY_OK);
//         err = SKY_coin_Transaction_PushOutput(
//                 handle, makeAddress(), BigDecimal.valueOf(5e6).toBigInteger(),
//                 BigDecimal.valueOf(50).toBigInteger());
//         assertEquals(err, SKY_OK);
//         cipher_SecKeys seckeys = new cipher_SecKeys();
//         seckeys.allocate(1);
//         seckeys.setAt(0, s);
//         err = SKY_coin_Transaction_SignInputs(handle, seckeys);
//         assertEquals(err, SKY_OK);
//         err = SKY_coin_Transaction_UpdateHeader(handle);
//         assertEquals(err, SKY_OK);
//         err = SKY_coin_GetTransactionObject(handle, ptx);
//         assertEquals(err, SKY_OK);
//         err = SKY_coin_Transaction_Verify(handle);
//         assertEquals(err, SKY_OK);
//     }

//     public void makeTransaction(SWIGTYPE_p_Transaction__Handle handle,
//                                 coin__Transaction ptx) {
//         cipher_SecKey s = new cipher_SecKey();
//         coin__UxOut ux = new coin__UxOut();
//         makeUxOutWithSecret(ux, s);
//         makeTransactionFromUxOut(ux, s, handle, ptx);
//     }

//     public SWIGTYPE_p_Transactions__Handle makeTransactions(int n) {
//         SWIGTYPE_p_Transactions__Handle handle = new_Transactions__HandlePtr();
//         SKY_coin_Create_Transactions(handle);
//         for (int i = 0; i < n; i++) {
//             SWIGTYPE_p_Transaction__Handle thandle = makeEmptyTransaction();
//             coin__Transaction ptx = new coin__Transaction();
//             makeTransaction(thandle, ptx);
//             SKY_coin_Transactions_Add(handle, thandle);
//         }
//         SWIGTYPE_p_long_long count = new_GointPtr();
//         SKY_coin_Transactions_Length(handle, count);
//         assertEquals(n, GointPtr_value(count));
//         return handle;
//     }

//     public coin__UxBody makeUxBody() {
//         coin__UxBody uxb = new coin__UxBody();
//         cipher_SecKey s = new cipher_SecKey();
//         makeUxBodyWithSecret(uxb, s);
//         return uxb;
//     }

//     public coin__UxOut makeUxOut() {
//         coin__UxOut uxb = new coin__UxOut();
//         cipher_SecKey s = new cipher_SecKey();
//         makeUxOutWithSecret(uxb, s);
//         return uxb;
//     }

//     public coin_UxOutArray makeUxOutArray(int n) {
//         coin_UxOutArray result = new coin_UxOutArray();

//         for (int i = 0; i < n; i++) {
//             result.append(makeUxOut());
//         }
//         assertEquals(result.getCount(), n);
//         return result;
//     }

//     public cipher_SHA256 RandSHA256() {
//         cipher_SHA256 sha = new cipher_SHA256();
//         GoSlice b = new GoSlice();
//         long err = SKY_cipher_RandByte(128, b);
//         assertEquals(err, SKY_OK);
//         err = SKY_cipher_SumSHA256(b, sha);
//         assertEquals(err, SKY_OK);
//         return sha;
//     }

//     public GoSlice RandBytes(int n) {
//         GoSlice b = new GoSlice();
//         long err = SKY_cipher_RandByte(n, b);
//         assertEquals(err, SKY_OK);
//         return b;
//     }

//     public SWIGTYPE_p_FeeCalculator feeCalc = feeCalc();
//     public SWIGTYPE_p_FeeCalculator badCalc = badCalc();
//     public SWIGTYPE_p_FeeCalculator fix121 = fix121();
//     public SWIGTYPE_p_FeeCalculator calc = calcCalc();
//     public SWIGTYPE_p_FeeCalculator overflow = overflow();

//     public BigInteger bigIntegerMaxValue =
//             BigDecimal.valueOf(1.8446744073709552e20).toBigInteger();

//     public long MaxValue16 = 65535;

//     public BigInteger toBigInteger(double num) {
//         return BigDecimal.valueOf(num).toBigInteger();
//     }
// }