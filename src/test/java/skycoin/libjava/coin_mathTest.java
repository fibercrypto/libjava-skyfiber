package skycoin.libjava;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class coin_mathTest extends skycoin {
    static {
        System.loadLibrary("skycoin");
    }

    transutils utils = new transutils();

    BigInteger MaxBigInteger = BigDecimal.valueOf(1.8446744073709552e20).toBigInteger();

    @Test
    public void TestAddUint64() {
        SWIGTYPE_p_unsigned_long_long r = new_GoUint64Ptr();
        long err = SKY_util_AddUint64(BigInteger.valueOf(10), BigInteger.valueOf(11), r);
        assertEquals(err, SKY_OK);
        assertEquals(GoUint64Ptr_value(r), BigInteger.valueOf(21));
        err = SKY_util_AddUint64(MaxBigInteger, BigInteger.valueOf(1), r);
        assertEquals(err, SKY_OK);
    }

    class math_test {
        public BigInteger a;
        public BigInteger b;
        public int failure;
    }

    math_test[] cases = new math_test[3];

    private void FullCases() {
        math_test c = new math_test();
        c.a = BigInteger.valueOf(0);
        c.b = BigInteger.valueOf(0);
        c.failure = SKY_OK;
        cases[0] = c;

        c = new math_test();
        c.a = BigInteger.valueOf(1);
        c.b = BigInteger.valueOf(1);
        c.failure = SKY_OK;
        cases[1] = c;

        c = new math_test();
        c.a = MaxBigInteger;
        c.b = BigInteger.valueOf(0);
        c.failure = SKY_ErrUint64OverflowsInt64;
        cases[2] = c;
    }

    @Test

    public void TestUint64ToInt64() {
        FullCases();
        for (int i = 0; i < cases.length; i++) {
            SWIGTYPE_p_long_long r = new_GoIntPtr();
            long err = SKY_util_Uint64ToInt64(cases[i].a, r);
            assertEquals(err, cases[i].failure);
            assertEquals(cases[i].b, BigInteger.valueOf(GoIntPtr_value(r)));
        }
    }
}