// package skycoin.libjava;

// import org.junit.Test;

// import static org.junit.Assert.assertEquals;

// public class cipher_bitcoinTest extends skycoin {
//     static {
//         System.loadLibrary("skycoin");
//     }

//     transutils utils = new transutils();

//     @Test
//     public void TestDecodeBase58BitcoinAddress() {
//         cipher_PubKey p = new cipher_PubKey();
//         cipher_SecKey s = new cipher_SecKey();
//         cipher__BitcoinAddress a = new cipher__BitcoinAddress();
//         cipher__BitcoinAddress addrTmp = new cipher__BitcoinAddress();

//         long err = SKY_cipher_GenerateKeyPair(p, s);
//         assertEquals(err, SKY_OK);
//         SKY_cipher_BitcoinAddressFromPubKey(p, a);
//         err = SKY_cipher_BitcoinAddress_Verify(a, p);
//         assertEquals(err, SKY_OK);
//         _GoString_ Str = new _GoString_();
//         Str.SetString("");
//         err = SKY_cipher_DecodeBase58BitcoinAddress(Str, addrTmp);
//         assertEquals(err, SKY_ErrInvalidBase58String);
//         Str.SetString("cascs");
//         err = SKY_cipher_DecodeBase58BitcoinAddress(Str, addrTmp);
//         if (utils.OS.equals("Linux")) {
//             assertEquals(err, SKY_ErrInvalidBase58Char);
//         } else {
//             assertEquals(err, SKY_ErrAddressInvalidLength);
//         }

//         GoSlice b = new GoSlice();
//         SKY_cipher_BitcoinAddress_Bytes(a, b);
//         b.setLen(b.getLen() / 2);
//         _GoString_ h = new _GoString_();
//         SKY_base58_Hex2Base58Str(b, h);
//         err = SKY_cipher_DecodeBase58BitcoinAddress(h, addrTmp);
//         assertEquals(err, SKY_ErrAddressInvalidLength);

//         b = new GoSlice();
//         SKY_cipher_BitcoinAddress_Bytes(a, b);
//         h = new _GoString_();
//         SKY_base58_Hex2Base58Str(b, h);
//         err = SKY_cipher_DecodeBase58BitcoinAddress(h, addrTmp);
//         assertEquals(err, SKY_OK);
//         assertEquals(a.isEqual(addrTmp), 1);

//         _GoString_ As = new _GoString_();
//         SKY_cipher_BitcoinAddress_String(a, As);
//         err = SKY_cipher_DecodeBase58BitcoinAddress(As, addrTmp);
//         assertEquals(err, SKY_OK);
//         assertEquals(a.isEqual(addrTmp), 1);

//         // preceding whitespace is invalid
//         _GoString_ as2 = new _GoString_();
//         as2.SetString(" " + As.getP());
//         err = SKY_cipher_DecodeBase58BitcoinAddress(as2, addrTmp);
//         assertEquals(err, SKY_ErrInvalidBase58Char);

//         // preceding zeroes are invalid
//         as2.SetString("000" + As.getP());
//         err = SKY_cipher_DecodeBase58BitcoinAddress(as2, addrTmp);
//         assertEquals(err, SKY_ErrInvalidBase58Char);

//         // trailing whitespace is invalid
//         as2.SetString(As.getP() + " ");
//         err = SKY_cipher_DecodeBase58BitcoinAddress(as2, addrTmp);
//         assertEquals(err, SKY_ErrInvalidBase58Char);

//         // trailing zeroes are invalid
//         as2.SetString(As.getP() + "000");
//         err = SKY_cipher_DecodeBase58BitcoinAddress(as2, addrTmp);
//         assertEquals(err, SKY_ErrInvalidBase58Char);
//     }

//     @Test
//     public void TestBitcoinAddressFromBytes() {
//         cipher_SecKey s = new cipher_SecKey();
//         cipher_PubKey p = new cipher_PubKey();
//         long err = SKY_cipher_GenerateKeyPair(p, s);
//         assertEquals(err, SKY_OK);
//         cipher__BitcoinAddress a = new cipher__BitcoinAddress();
//         SKY_cipher_BitcoinAddressFromPubKey(p, a);
//         GoSlice pk = new GoSlice();
//         GoSlice b = new GoSlice();
//         cipher__BitcoinAddress a2 = new cipher__BitcoinAddress();
//         SKY_cipher_BitcoinAddress_Bytes(a, b);
//         err = SKY_cipher_BitcoinAddressFromBytes(b, a2);
//         assertEquals(err, SKY_OK);
//         assertEquals(a2.isEqual(a), 1);

//         // Invalid number of bytes
//         SKY_cipher_BitcoinAddress_Bytes(a, b);
//         b.setLen(b.getLen() - 2);
//         err = SKY_cipher_BitcoinAddressFromBytes(b, a2);
//         assertEquals(err, SKY_ErrAddressInvalidLength);

//         // Invalid checksum
//         SKY_cipher_BitcoinAddress_Bytes(a, b);

//         b.setAtChar('2', b.getLen() - 1);
//         err = SKY_cipher_BitcoinAddressFromBytes(b, a2);
//         assertEquals(err, SKY_ErrAddressInvalidChecksum);

//         a.setVersion((short) 2);
//         SKY_cipher_BitcoinAddress_Bytes(a, b);
//         err = SKY_cipher_BitcoinAddressFromBytes(b, a2);
//         assertEquals(err, SKY_ErrAddressInvalidVersion);
//     }

//     @Test
//     public void TestBitcoinAddressFromSecKey() {
//         cipher_PubKey p = new cipher_PubKey();
//         cipher_SecKey s = new cipher_SecKey();
//         cipher__BitcoinAddress a = new cipher__BitcoinAddress();
//         cipher__BitcoinAddress a2 = new cipher__BitcoinAddress();
//         SKY_cipher_GenerateKeyPair(p, s);
//         long err = SKY_cipher_BitcoinAddressFromSecKey(s, a);
//         assertEquals(err, SKY_OK);
//         // Valid pubkey+address
//         err = SKY_cipher_BitcoinAddress_Verify(a, p);
//         assertEquals(err, SKY_OK);

//         err = SKY_cipher_BitcoinAddressFromSecKey(new cipher_SecKey(), a2);
//         assertEquals(err, SKY_ErrPubKeyFromNullSecKey);
//     }

//     @Test
//     public void TestBitcoinAddressNull() {
//         cipher__BitcoinAddress a = new cipher__BitcoinAddress();
//         assertEquals(SKY_cipher_BitcoinAddress_Null(a), 1);

//         cipher_PubKey p = new cipher_PubKey();
//         cipher_SecKey s = new cipher_SecKey();
//         long err = SKY_cipher_GenerateKeyPair(p, s);
//         SKY_cipher_BitcoinAddressFromPubKey(p, a);
//         assertEquals(SKY_cipher_BitcoinAddress_Null(a), 0);
//     }

//     @Test
//     public void TestBitcoinAddressVerify() {
//         cipher_PubKey p = new cipher_PubKey();
//         cipher_SecKey s = new cipher_SecKey();
//         cipher__BitcoinAddress a = new cipher__BitcoinAddress();
//         SKY_cipher_GenerateKeyPair(p, s);
//         SKY_cipher_BitcoinAddressFromPubKey(p, a);

//         // Valid pubkey+address
//         long err = SKY_cipher_BitcoinAddress_Verify(a, p);
//         assertEquals(err, SKY_OK);

//         // Invalid pubkey
//         err = SKY_cipher_BitcoinAddress_Verify(a, new cipher_PubKey());
//         assertEquals(err, SKY_ErrAddressInvalidPubKey);
//         cipher_PubKey p2 = new cipher_PubKey();
//         cipher_SecKey s2 = new cipher_SecKey();
//         SKY_cipher_GenerateKeyPair(p2, s2);
//         err = SKY_cipher_BitcoinAddress_Verify(a, p2);
//         assertEquals(err, SKY_ErrAddressInvalidPubKey);

//         // Bad Version
//         a.setVersion((short) 0X001);
//         err = SKY_cipher_BitcoinAddress_Verify(a, p2);
//         assertEquals(err, SKY_ErrAddressInvalidVersion);
//     }

//     @Test
//     public void TestBitcoinWIPRoundTrio() {
//         cipher_PubKey p = new cipher_PubKey();
//         cipher_SecKey seckey1 = new cipher_SecKey();
//         long err = SKY_cipher_GenerateKeyPair(p, seckey1);
//         _GoString_ wip1 = new _GoString_();
//         SKY_cipher_BitcoinWalletImportFormatFromSeckey(seckey1, wip1);
//         cipher_SecKey seckey2 = new cipher_SecKey();
//         assertEquals(err, SKY_OK);
//         err = SKY_cipher_SecKeyFromBitcoinWalletImportFormat(wip1, seckey2);
//         assertEquals(err, SKY_OK);
//         _GoString_ wip2 = new _GoString_();
//         SKY_cipher_BitcoinWalletImportFormatFromSeckey(seckey2, wip2);
//         assertEquals(err, SKY_OK);
//         assertEquals(seckey1.isEqual(seckey2), 1);
//         _GoString_ seckey1_hex = new _GoString_();
//         _GoString_ seckey2_hex = new _GoString_();
//         err = SKY_cipher_SecKey_Hex(seckey1, seckey1_hex);
//         assertEquals(err, SKY_OK);
//         err = SKY_cipher_SecKey_Hex(seckey2, seckey2_hex);
//         assertEquals(err, SKY_OK);
//         assertEquals(seckey1_hex.getP(), seckey2_hex.getP());
//         assertEquals(wip1.getP(), wip2.getP());
//     }
// }
