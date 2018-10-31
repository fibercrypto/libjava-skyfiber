package skycoin.libjava;

import static org.junit.Assert.*;

import org.junit.Test;
import skycoin.libjava.*;

/**
 * Unit test for simple App.
 */
public class cipher_hashTest extends skycoin {
    static {
        System.loadLibrary("skycoin");
    }

    private void freshSumRipemd160(GoSlice bytes, cipher_Ripemd160 rp160) {
        SKY_cipher_HashRipemd160(bytes, rp160);
    }

    private void freshSumSHA256(GoSlice bytes, cipher_SHA256 sha256) {
        SKY_cipher_SumSHA256(bytes, sha256);
    }

    @Test

    public void TestHashRipemd160() {
        GoSlice b = new GoSlice();
        long err = SKY_cipher_RandByte(128, b);
        cipher_Ripemd160 hr = new cipher_Ripemd160();
        err = SKY_cipher_HashRipemd160(b, hr);
        assertEquals(err, SKY_OK);
        b = new GoSlice();
        err = SKY_cipher_RandByte(160, b);
        cipher_Ripemd160 r = new cipher_Ripemd160();
        err = SKY_cipher_HashRipemd160(b, r);
        assertEquals(r.isEqual(new cipher_Ripemd160()), 0);
        // 2nd hash should not be affected by previous
        b = new GoSlice();
        err = SKY_cipher_RandByte(256, b);
        cipher_Ripemd160 r2 = new cipher_Ripemd160();
        err = SKY_cipher_HashRipemd160(b, r2);
        assertEquals(err, SKY_OK);
        assertEquals(r2.isEqual(new cipher_Ripemd160()), 0);
        cipher_Ripemd160 r3 = new cipher_Ripemd160();
        freshSumRipemd160(b, r3);
        assertEquals(r2.isEqual(r3), 1);
    }

    @Test

    public void TestRipemd160Set() {
        cipher_Ripemd160 h = new cipher_Ripemd160();
        GoSlice b = new GoSlice();
        long err = SKY_cipher_RandByte(21, b);
        err = SKY_cipher_Ripemd160_Set(h, b);
        assertEquals(err, SKY_ErrInvalidLengthRipemd160);
        b = new GoSlice();
        h = new cipher_Ripemd160();
        SKY_cipher_RandByte(100, b);
        err = SKY_cipher_Ripemd160_Set(h, b);
        assertEquals(err, SKY_ErrInvalidLengthRipemd160);

        b = new GoSlice();
        h = new cipher_Ripemd160();
        SKY_cipher_RandByte(19, b);
        err = SKY_cipher_Ripemd160_Set(h, b);
        assertEquals(err, SKY_ErrInvalidLengthRipemd160);

        b = new GoSlice();
        h = new cipher_Ripemd160();
        SKY_cipher_RandByte(0, b);
        err = SKY_cipher_Ripemd160_Set(h, b);
        assertEquals(err, SKY_ErrInvalidLengthRipemd160);

        b = new GoSlice();
        h = new cipher_Ripemd160();
        SKY_cipher_RandByte(20, b);
        err = SKY_cipher_Ripemd160_Set(h, b);
        assertEquals(err, SKY_OK);
    }

    @Test

    public void TestSHA256Set() {
        cipher_SHA256 h = new cipher_SHA256();
        GoSlice b = new GoSlice();
        long err = SKY_cipher_RandByte(33, b);
        err = SKY_cipher_SHA256_Set(h, b);
        assertEquals(err, SKY_ErrInvalidLengthSHA256);
        h = new cipher_SHA256();
        b = new GoSlice();
        SKY_cipher_RandByte(100, b);
        err = SKY_cipher_SHA256_Set(h, b);
        assertEquals(err, SKY_ErrInvalidLengthSHA256);
        h = new cipher_SHA256();
        b = new GoSlice();
        SKY_cipher_RandByte(31, b);
        err = SKY_cipher_SHA256_Set(h, b);
        assertEquals(err, SKY_ErrInvalidLengthSHA256);
        h = new cipher_SHA256();
        b = new GoSlice();
        SKY_cipher_RandByte(0, b);
        err = SKY_cipher_SHA256_Set(h, b);
        assertEquals(err, SKY_ErrInvalidLengthSHA256);
        h = new cipher_SHA256();
        b = new GoSlice();
        SKY_cipher_RandByte(32, b);
        err = SKY_cipher_SHA256_Set(h, b);
        assertEquals(err, SKY_OK);
    }

    @Test

    public void TestSHA256Hex() {
        cipher_SHA256 h = new cipher_SHA256();
        GoSlice b = new GoSlice();
        SKY_cipher_RandByte(32, b);
        long err = SKY_cipher_SHA256_Set(h, b);
        assertEquals(err, SKY_OK);
        _GoString_ s = new _GoString_();
        err = SKY_cipher_SHA256_Hex(h, s);
        cipher_SHA256 h2 = new cipher_SHA256();
        err = SKY_cipher_SHA256FromHex(s, h2);
        assertEquals(err, SKY_OK);
        assertEquals(h.isEqual(h2), 1);
        _GoString_ s1 = new _GoString_();
        err = SKY_cipher_SHA256_Hex(h, s1);
        assertEquals(err, SKY_OK);
        assertEquals(s1.getP(), s.getP());
    }

    class StrTest {
        public String input;
        public String output;
    }

    @Test

    public void TestSHA256KnownValue() {

        StrTest caseval = new StrTest();
        caseval.input = "skycoin";
        caseval.output = "5a42c0643bdb465d90bf673b99c14f5fa02db71513249d904573d2b8b63d353d";
        StrTest caseval1 = new StrTest();
        caseval1.input = "hello world";
        caseval1.output = "b94d27b9934d3e08a52e52d7da7dabfac484efe37a5380ee9088f7ace2efcde9";
        StrTest caseval2= new StrTest();
        caseval2.input = "hello world asd awd awd awdapodawpokawpod ";
        caseval2.output = "99d71f95cafe05ea2dddebc35b6083bd5af0e44850c9dc5139b4476c99950be4";
        StrTest[] val = { caseval, caseval1, caseval2 };

        for (int i = 0; i < val.length; i++) {
            StrTest io = val[i];
            GoSlice b = new GoSlice();
            cipher_SHA256 h = new cipher_SHA256();
            _GoString_ input = new _GoString_();
            _GoString_ output = new _GoString_();
            input.setP(io.input);
            b.convertString(input);
            long err = SKY_cipher_SumSHA256(b, h);
            assertEquals(err, SKY_OK);
            err = SKY_cipher_SHA256_Hex(h, output);
            assertEquals(err, SKY_OK);
            assertEquals(output.getP(), io.output);
        }
    }

    @Test

    public void TestSumSHA256() {
        GoSlice b = new GoSlice();
        long err = SKY_cipher_RandByte(256, b);
        cipher_SHA256 h1 = new cipher_SHA256();
        err = SKY_cipher_SumSHA256(b, h1);
        assertEquals(h1.isEqual(new cipher_SHA256()), 0);
        // A second call to Sum should not be influenced by the original
        GoSlice c = new GoSlice();
        err = SKY_cipher_RandByte(256, c);
        cipher_SHA256 h2 = new cipher_SHA256();
        err = SKY_cipher_SumSHA256(c, h2);
        assertEquals(h2.isEqual(new cipher_SHA256()), 0);
        cipher_SHA256 h3 = new cipher_SHA256();
        freshSumSHA256(c, h3);
        assertEquals(h2.isEqual(h3), 1);
    }

    // @Test
    // public void TestSHA256FromHex () {
    // // Invalid hex hash
    // var h = new cipher_SHA256 ();
    // long err = SKY_cipher_SHA256FromHex ("cawcd", h);
    // assertEquals (err, SKY_ERROR);
    // // Truncated hex hash
    // var b = new GoSlice ();
    // err = SKY_cipher_RandByte (128, b);
    // h = new cipher_SHA256 ();
    // err = SKY_cipher_SumSHA256 (b, h);
    // var str = h.getStr ();
    // var str1 = GoStringp_value(str);
    // Console.WriteLine (str1.p);
    // }
}