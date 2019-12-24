package skyfiber.libjava;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class cipher_cryptoTest extends skycoin {
    static {
        System.loadLibrary("skycoin");
    }

    @Test
    public void TestNewPubKey() {
        GoSlice b = new GoSlice();
        cipher_PubKey p = new cipher_PubKey();
        long err = SKY_cipher_RandByte(31, b);
        assertEquals(err, SKY_OK);
        err = SKY_cipher_NewPubKey(b, p);
        assertEquals(err, SKY_ErrInvalidLengthPubKey);
        b = new GoSlice();
        err = SKY_cipher_RandByte(32, b);
        assertEquals(err, SKY_OK);
        err = SKY_cipher_NewPubKey(b, p);
        assertEquals(err, SKY_ErrInvalidLengthPubKey);
        b = new GoSlice();
        err = SKY_cipher_RandByte(34, b);
        assertEquals(err, SKY_OK);
        err = SKY_cipher_NewPubKey(b, p);
        assertEquals(err, SKY_ErrInvalidLengthPubKey);
        b = new GoSlice();
        err = SKY_cipher_RandByte(0, b);
        assertEquals(err, SKY_OK);
        err = SKY_cipher_NewPubKey(b, p);
        assertEquals(err, SKY_ErrInvalidLengthPubKey);
        b = new GoSlice();
        err = SKY_cipher_RandByte(100, b);
        assertEquals(err, SKY_OK);
        err = SKY_cipher_NewPubKey(b, p);
        assertEquals(err, SKY_ErrInvalidLengthPubKey);
        b = new GoSlice();
        p = new cipher_PubKey();
        err = SKY_cipher_NewPubKey(b, p);
        assertEquals(err, SKY_ErrInvalidLengthPubKey);

        cipher_SecKey s = new cipher_SecKey();
        GoSlice pTemp = new GoSlice();
        err = SKY_cipher_GenerateKeyPair(p, s);
        pTemp = p.toSlice();
        assertEquals(err, SKY_OK);
        cipher_PubKey p2 = new cipher_PubKey();
        err = SKY_cipher_NewPubKey(pTemp, p2);
        assertEquals(err, SKY_OK);
        assertEquals(p.isEqual(p2), 1);
    }

    @Test
    public void TestPubKeyVerify() {
        // Random bytes should not be valid, most of the time
        boolean failed = false;
        for (int i = 0; i < 10; i++) {
            GoSlice b = new GoSlice();
            long err = SKY_cipher_RandByte(33, b);
            assertEquals(err, SKY_OK);
            cipher_PubKey p = new cipher_PubKey();
            p.assignSlice(b);
            err = SKY_cipher_PubKey_Verify(p);
            if (err != SKY_OK) {
                failed = true;
                break;
            }
        }
        assertTrue(failed);
    }

    @Test
    public void TestPubKeyVerifyNil() {
        // Empty public key should not be valid
        cipher_PubKey p = new cipher_PubKey();
        long err = SKY_cipher_PubKey_Verify(p);
        assertNotEquals(err, SKY_OK);
    }

    @Test
    public void TestPubKeyVerifyDefault1() {
        // Generated pub key should be valid
        cipher_PubKey p = new cipher_PubKey();
        cipher_SecKey s = new cipher_SecKey();
        long err = SKY_cipher_GenerateKeyPair(p, s);
        err = SKY_cipher_PubKey_Verify(p);
        assertEquals(err, SKY_OK);
    }

    @Test
    public void TestPubKeyVerifyDefault2() {
        for (int i = 0; i < 1024; i++) {
            cipher_PubKey p = new cipher_PubKey();
            cipher_SecKey s = new cipher_SecKey();
            long err = SKY_cipher_GenerateKeyPair(p, s);
            err = SKY_cipher_PubKey_Verify(p);
            assertEquals(err, SKY_OK);
        }
    }

    @Test
    public void TestPubKeyToAddress() {
        cipher_PubKey p = new cipher_PubKey();
        cipher_SecKey s = new cipher_SecKey();
        cipher__Address addr = new cipher__Address();
        cipher__Address addr1 = new cipher__Address();
        long err = SKY_cipher_GenerateKeyPair(p, s);
        err = SKY_cipher_AddressFromPubKey(p, addr);
        err = SKY_cipher_Address_Verify(addr, p);
        assertEquals(err, SKY_OK);
        _GoString_ addrStr = new _GoString_();
        err = SKY_cipher_Address_String(addr, addrStr);
        assertEquals(err, SKY_OK);
        err = SKY_cipher_DecodeBase58Address(addrStr, addr1);
        assertEquals(err, SKY_OK);
    }

    @Test
    public void TestPubKeyToAddress2() {
        for (int i = 0; i < 1024; i++) {
            cipher_PubKey p = new cipher_PubKey();
            cipher_SecKey s = new cipher_SecKey();
            cipher__Address addr = new cipher__Address();
            cipher__Address addr1 = new cipher__Address();
            long err = SKY_cipher_GenerateKeyPair(p, s);
            err = SKY_cipher_AddressFromPubKey(p, addr);
            err = SKY_cipher_Address_Verify(addr, p);
            assertEquals(err, SKY_OK);
            _GoString_ addrStr = new _GoString_();
            err = SKY_cipher_Address_String(addr, addrStr);
            assertEquals(err, SKY_OK);
            err = SKY_cipher_DecodeBase58Address(addrStr, addr1);
            assertEquals(err, SKY_OK);
        }
    }

    @Test
    public void TestMustNewSecKey() {
        GoSlice b = new GoSlice();
        cipher_SecKey p = new cipher_SecKey();
        long err = SKY_cipher_RandByte(31, b);
        assertEquals(err, SKY_OK);
        err = SKY_cipher_NewSecKey(b, p);
        assertEquals(err, SKY_ErrInvalidLengthSecKey);
        err = SKY_cipher_RandByte(32, b);
        assertEquals(err, SKY_OK);
        err = SKY_cipher_NewSecKey(b, p);
        assertEquals(err, SKY_ErrInvalidLengthSecKey);
        err = SKY_cipher_RandByte(34, b);
        assertEquals(err, SKY_OK);
        err = SKY_cipher_NewSecKey(b, p);
        assertEquals(err, SKY_ErrInvalidLengthSecKey);
        err = SKY_cipher_RandByte(0, b);
        assertEquals(err, SKY_OK);
        err = SKY_cipher_NewSecKey(b, p);
        assertEquals(err, SKY_ErrInvalidLengthSecKey);
        err = SKY_cipher_RandByte(100, b);
        assertEquals(err, SKY_OK);
        err = SKY_cipher_NewSecKey(b, p);
        assertEquals(err, SKY_ErrInvalidLengthSecKey);
        b = new GoSlice();
        err = SKY_cipher_RandByte(32, b);
        assertEquals(err, SKY_OK);
        err = SKY_cipher_NewSecKey(b, p);
        assertEquals(err, SKY_OK);
        GoSlice b1 = new GoSlice();
        cipher_SecKey p1 = new cipher_SecKey();
        err = SKY_cipher_RandByte(32, b1);
        assertEquals(err, SKY_OK);
        err = SKY_cipher_NewSecKey(b1, p1);
        assertEquals(err, SKY_OK);
    }

    @Test
    public void TestSecKeyVerify() {
        // Empty secret key should not be valid
        cipher_SecKey s = new cipher_SecKey();
        long err = SKY_cipher_SecKey_Verify(s);
        assertEquals(err, SKY_ErrInvalidSecKey);
        // Generated sec key should be valid
        cipher_PubKey p = new cipher_PubKey();
        s = new cipher_SecKey();
        err = SKY_cipher_GenerateKeyPair(p, s);
        assertEquals(err, SKY_OK);
        assertEquals(SKY_cipher_SecKey_Verify(s), SKY_OK);
    }

    @Test
    public void TestECDHonce() {
        cipher_PubKey pub1 = new cipher_PubKey();
        cipher_PubKey pub2 = new cipher_PubKey();
        cipher_SecKey sec1 = new cipher_SecKey();
        cipher_SecKey sec2 = new cipher_SecKey();
        GoSlice buf1 = new GoSlice();
        GoSlice buf2 = new GoSlice();
        long err = SKY_cipher_GenerateKeyPair(pub1, sec1);
        assertEquals(err, SKY_OK);
        err = SKY_cipher_GenerateKeyPair(pub2, sec2);
        assertEquals(err, SKY_OK);
        err = SKY_cipher_ECDH(pub2, sec1, buf1);
        assertEquals(err, SKY_OK);
        err = SKY_cipher_ECDH(pub1, sec2, buf2);
        assertEquals(err, SKY_OK);
        assertEquals(buf1.isEqual(buf2), 1);
    }

    @Test
    public void TestECDHloop() {
        for (int i = 0; i < 128; i++) {
            cipher_PubKey pub1 = new cipher_PubKey();
            cipher_PubKey pub2 = new cipher_PubKey();
            cipher_SecKey sec1 = new cipher_SecKey();
            cipher_SecKey sec2 = new cipher_SecKey();
            GoSlice buf1 = new GoSlice();
            GoSlice buf2 = new GoSlice();
            long err = SKY_cipher_GenerateKeyPair(pub1, sec1);
            assertEquals(err, SKY_OK);
            err = SKY_cipher_GenerateKeyPair(pub2, sec2);
            assertEquals(err, SKY_OK);
            err = SKY_cipher_ECDH(pub2, sec1, buf1);
            assertEquals(err, SKY_OK);
            err = SKY_cipher_ECDH(pub1, sec2, buf2);
            assertEquals(err, SKY_OK);
            assertEquals(buf1.isEqual(buf2), 1);
        }
    }

    @Test
    public void TestNewSig() {
        GoSlice b = new GoSlice();
        long err = SKY_cipher_RandByte(64, b);
        cipher_Sig s = new cipher_Sig();
        err = SKY_cipher_NewSig(b, s);
        assertEquals(err, SKY_ErrInvalidLengthSig);
        err = SKY_cipher_RandByte(66, b);
        err = SKY_cipher_NewSig(b, s);
        assertEquals(err, SKY_ErrInvalidLengthSig);
        err = SKY_cipher_RandByte(67, b);
        err = SKY_cipher_NewSig(b, s);
        assertEquals(err, SKY_ErrInvalidLengthSig);
        err = SKY_cipher_RandByte(0, b);
        err = SKY_cipher_NewSig(b, s);
        assertEquals(err, SKY_ErrInvalidLengthSig);
        err = SKY_cipher_RandByte(100, b);
        err = SKY_cipher_NewSig(b, s);
        assertEquals(err, SKY_ErrInvalidLengthSig);
        s = new cipher_Sig();
        b = new GoSlice();
        err = SKY_cipher_RandByte(65, b);
        err = SKY_cipher_NewSig(b, s);
        assertEquals(err, SKY_OK);
        GoSlice b1 = new GoSlice();
        err = SKY_cipher_RandByte(65, b1);
        cipher_Sig s1 = new cipher_Sig();
        err = SKY_cipher_NewSig(b1, s1);
        assertEquals(err, SKY_OK);
    }

    @Test
    public void TestSignHash() {
        cipher_PubKey p = new cipher_PubKey();
        cipher_SecKey s = new cipher_SecKey();
        cipher__Address a = new cipher__Address();
        long err = SKY_cipher_GenerateKeyPair(p, s);
        assertEquals(err, SKY_OK);
        err = SKY_cipher_AddressFromPubKey(p, a);
        assertEquals(err, SKY_OK);
        GoSlice b_temp = new GoSlice();
        err = SKY_cipher_RandByte(256, b_temp);
        assertEquals(err, SKY_OK);
        cipher_SHA256 h = new cipher_SHA256();
        err = SKY_cipher_SumSHA256(b_temp, h);
        assertEquals(err, SKY_OK);
        cipher_Sig sig = new cipher_Sig();
        err = SKY_cipher_SignHash(h, s, sig);
        assertEquals(err, SKY_OK);
        assertEquals(sig.isEqual(new cipher_Sig()), 0);
    }

    @Test
    public void TestPubKeyFromSecKey() {
        cipher_PubKey p = new cipher_PubKey();
        cipher_SecKey s = new cipher_SecKey();
        long err = SKY_cipher_GenerateKeyPair(p, s);
        cipher_PubKey p1 = new cipher_PubKey();
        err = SKY_cipher_PubKeyFromSecKey(s, p1);
        assertEquals(err, SKY_OK);
        assertEquals(p1.isEqual(p), 1);

        s = new cipher_SecKey();
        err = SKY_cipher_PubKeyFromSecKey(s, p);
        assertEquals(err, SKY_ErrPubKeyFromNullSecKey);
    }

    @Test
    public void TestPubKeyFromSig() {
        cipher_PubKey p = new cipher_PubKey();
        cipher_SecKey s = new cipher_SecKey();
        GoSlice b = new GoSlice();
        cipher_SHA256 h = new cipher_SHA256();
        long err = SKY_cipher_GenerateKeyPair(p, s);
        err = SKY_cipher_RandByte(256, b);
        err = SKY_cipher_SumSHA256(b, h);
        cipher_Sig sig = new cipher_Sig();
        err = SKY_cipher_SignHash(h, s, sig);
        cipher_PubKey p2 = new cipher_PubKey();
        err = SKY_cipher_PubKeyFromSig(sig, h, p2);
        assertEquals(err, SKY_OK);
        assertEquals(p2.isEqual(p), 1);
        p2 = new cipher_PubKey();
        err = SKY_cipher_PubKeyFromSig(new cipher_Sig(), h, p2);
        assertEquals(err, SKY_ErrInvalidSigPubKeyRecovery);
    }

    @Test
    public void TestGenerateKeyPair() {
        cipher_PubKey p = new cipher_PubKey();
        cipher_SecKey s = new cipher_SecKey();
        long err = SKY_cipher_GenerateKeyPair(p, s);
        err = SKY_cipher_PubKey_Verify(p);
        assertEquals(err, SKY_OK);
        err = SKY_cipher_SecKey_Verify(s);
        assertEquals(err, SKY_OK);
    }

    @Test
    public void TestGenerateDeterministicKeyPair() {
        GoSlice seed = new GoSlice();
        long err = SKY_cipher_RandByte(32, seed);
        cipher_PubKey p = new cipher_PubKey();
        cipher_SecKey s = new cipher_SecKey();
        err = SKY_cipher_GenerateDeterministicKeyPair(seed, p, s);
        err = SKY_cipher_PubKey_Verify(p);
        assertEquals(err, SKY_OK);
        err = SKY_cipher_SecKey_Verify(s);
        assertEquals(err, SKY_OK);
        p = new cipher_PubKey();
        s = new cipher_SecKey();
        err = SKY_cipher_GenerateDeterministicKeyPair(seed, p, s);
        err = SKY_cipher_PubKey_Verify(p);
        assertEquals(err, SKY_OK);
        err = SKY_cipher_SecKey_Verify(s);
        assertEquals(err, SKY_OK);
    }
}