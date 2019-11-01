// package skycoin.libjava;

// import static org.junit.Assert.assertEquals;

// import org.junit.Test;

// /**
//  * Unit test for simple App.
//  */
// public class cipher_addressTest extends skycoin {
//   static {
//     System.loadLibrary("skycoin");
//   }
//   transutils utils = new transutils();
//   @Test
//   public void TestDecodeBase58Address() {
//     long err;
//     cipher_SecKey s = new cipher_SecKey();
//     cipher_PubKey p = new cipher_PubKey();
//     err = SKY_cipher_GenerateKeyPair(p, s);
//     assertEquals(err, SKY_OK);
//     err = SKY_cipher_SecKey_Verify(s);
//     assertEquals(err, SKY_OK);
//     err = SKY_cipher_PubKey_Verify(p);
//     assertEquals(err, SKY_OK);

//     cipher__Address a = new cipher__Address();
//     cipher__Address a1 = new cipher__Address();
//     cipher__Address a2 = new cipher__Address();

//     err = SKY_cipher_AddressFromPubKey(p, a);
//     assertEquals(err, SKY_OK);
//     err = SKY_cipher_Address_Verify(a, p);
//     assertEquals(err, SKY_OK);
//     _GoString_ str = new _GoString_();

//     str.SetString("");
//     err = SKY_cipher_DecodeBase58Address(str, a1);
//     assertEquals(err, SKY_ERROR);
//     str = new _GoString_();
//     str.SetString("asa");
//     err = SKY_cipher_DecodeBase58Address(str, a1);
//     if (utils.OS.equals("Linux")){
//       assertEquals(err, SKY_ERROR);}else{
//           assertEquals(err, SKY_ErrAddressInvalidLength);
//       }

//     _GoString_ addrStr = new _GoString_();
//     err = SKY_cipher_Address_String(a, addrStr);
//     assertEquals(err, SKY_OK);
//     err = SKY_cipher_DecodeBase58Address(addrStr, a2);
//     assertEquals("Failed SKY_cipher_DecodeBase58Address", err, SKY_OK);
//     assertEquals(a.isEqual(a2), 1);
//     String as2 = " " + addrStr.getP();
//     _GoString_ strAs2 = new _GoString_();
//     err = SKY_cipher_DecodeBase58Address(strAs2, a1);
//     assertEquals(err, SKY_ERROR);

//     strAs2.SetString("000" + addrStr.getP());
//     err = SKY_cipher_DecodeBase58Address(strAs2, a1);
//     assertEquals(err, SKY_ERROR);

//     strAs2.SetString(addrStr.getP() + "000");
//     err = SKY_cipher_DecodeBase58Address(strAs2, a1);
//     assertEquals(err, SKY_ERROR);
//   }

//   @Test
//   public void TestAddressFromBytes() {
//     cipher_SecKey s = new cipher_SecKey();

//     cipher_PubKey p = new cipher_PubKey();
//     long err = SKY_cipher_GenerateKeyPair(p, s);
//     assertEquals(err, SKY_OK);
//     cipher__Address a = new cipher__Address();
//     cipher__Address a2 = new cipher__Address();
//     err = SKY_cipher_AddressFromPubKey(p, a);
//     assertEquals(err, SKY_OK);
//     GoSlice b = new GoSlice();
//     GoSlice b2 = new GoSlice();

//     err = SKY_cipher_Address_Bytes(a, b);
//     assertEquals(err, SKY_OK);
//     err = SKY_cipher_Address_Bytes(a, b2);
//     assertEquals(err, SKY_OK);
//     err = SKY_cipher_AddressFromBytes(b2, a2);
//     assertEquals(err, SKY_OK);
//     assertEquals(a2.isEqual(a), 1);
//     // INvalid number of bytes
//     long len_b = b.getLen();
//     b.setLen(len_b - 2);
//     err = SKY_cipher_AddressFromBytes(b, a2);
//     assertEquals(err, SKY_ErrAddressInvalidLength);
//     b.setLen(len_b);
//     a.setVersion((short)2);
//     err = SKY_cipher_Address_Bytes(a, b);
//     assertEquals(err, SKY_OK);
//     err = SKY_cipher_AddressFromBytes(b, a);
//     assertEquals(err, SKY_ErrAddressInvalidVersion);
//   }

//   @Test
//   public void TestAddressRoundtrip() {
//     // Tests encode and decode
//     cipher_PubKey p = new cipher_PubKey();
//     cipher_SecKey s = new cipher_SecKey();
//     long err = SKY_cipher_GenerateKeyPair(p, s);
//     assertEquals(err, SKY_OK);
//     cipher__Address a = new cipher__Address();
//     err = SKY_cipher_AddressFromPubKey(p, a);
//     assertEquals(err, SKY_OK);
//     GoSlice b = new GoSlice();
//     err = SKY_cipher_Address_Bytes(a, b);
//     assertEquals(err, SKY_OK);
//     err = SKY_cipher_AddressFromBytes(b, a);
//     assertEquals(err, SKY_OK);
//     cipher__Address a2 = new cipher__Address();
//     err = SKY_cipher_AddressFromBytes(b, a2);
//     assertEquals(err, SKY_OK);
//     assertEquals(a.isEqual(a2), 1);
//     _GoString_ str = new _GoString_();
//     _GoString_ str2 = new _GoString_();
//     err = SKY_cipher_Address_String(a, str);
//     assertEquals(err, SKY_OK);
//     err = SKY_cipher_Address_String(a2, str2);
//     assertEquals(err, SKY_OK);
//     assertEquals(str.getP(), str2.getP());
//   }

//   @Test
//   public void TestAddressVerify() {
//     cipher_PubKey p = new cipher_PubKey();
//     cipher_SecKey s = new cipher_SecKey();
//     long err = SKY_cipher_GenerateKeyPair(p, s);
//     assertEquals(err, SKY_OK);
//     cipher__Address a = new cipher__Address();
//     err = SKY_cipher_AddressFromPubKey(p, a);
//     assertEquals(err, SKY_OK);
//     // Valid pubkey+address
//     err = SKY_cipher_Address_Verify(a, p);
//     assertEquals(err, SKY_OK);
//     // Invalid pubkey
//     err = SKY_cipher_Address_Verify(a, new cipher_PubKey());
//     assertEquals(err, SKY_ErrAddressInvalidPubKey);
//     cipher_PubKey p2 = new cipher_PubKey();
//     cipher_SecKey s2 = new cipher_SecKey();
//     err = SKY_cipher_GenerateKeyPair(p2, s2);
//     assertEquals(err, SKY_OK);
//     err = SKY_cipher_Address_Verify(a, p2);
//     assertEquals(err, SKY_ErrAddressInvalidPubKey);
//     // Bad version
//     a.setVersion((short)1);
//     err = SKY_cipher_Address_Verify(a, p);
//     assertEquals(err, SKY_ErrAddressInvalidVersion);
//   }

//   @Test
//   public void TestAddressBulk() {

//     for (int i = 0; i < 1024; i++) {
//       cipher_PubKey pub = new cipher_PubKey();
//       cipher_SecKey sec = new cipher_SecKey();
//       GoSlice b = new GoSlice();
//       long err = SKY_cipher_RandByte(32, b);
//       assertEquals(err, SKY_OK);
//       err = SKY_cipher_GenerateDeterministicKeyPair(b, pub, sec);
//       assertEquals(err, SKY_OK);
//       cipher__Address a = new cipher__Address();
//       err = SKY_cipher_AddressFromPubKey(pub, a);
//       assertEquals(err, SKY_OK);
//       err = SKY_cipher_Address_Verify(a, pub);
//       assertEquals(err, SKY_OK);
//       _GoString_ s = new _GoString_();
//       err = SKY_cipher_Address_String(a, s);
//       assertEquals(err, SKY_OK);
//       cipher__Address a2 = new cipher__Address();
//       err = SKY_cipher_DecodeBase58Address(s, a2);
//       assertEquals(err, SKY_OK);
//       assertEquals(a2.isEqual(a), 1);
//     }
//   }

//   @Test
//   public void TestAddressNull() {
//     cipher__Address a = new cipher__Address();
//     assertEquals(a.isEqual(new cipher__Address()), 1);
//     cipher_PubKey p = new cipher_PubKey();
//     cipher_SecKey s = new cipher_SecKey();
//     long err = SKY_cipher_GenerateKeyPair(p, s);
//     assertEquals(err, SKY_OK);
//     err = SKY_cipher_AddressFromPubKey(p, a);
//     assertEquals(err, SKY_OK);
//     assertEquals(a.isEqual(new cipher__Address()), 0);
//   }
// }
