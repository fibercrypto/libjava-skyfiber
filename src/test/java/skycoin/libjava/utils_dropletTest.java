package skycoin.libjava;

import static org.junit.Assert.*;

import java.math.*;

import org.junit.Test;
import skycoin.libjava.*;

/**
 * Unit test for simple App.
 */
public class utils_dropletTest extends skycoin {
  static { System.loadLibrary("skycoin"); }

  transutils utils = new transutils();

  class droplet_TestStr {
    public String s;
    public BigInteger n;
    public int e;
  }

  droplet_TestStr cases[];

  private void FullCases() {
    cases = new droplet_TestStr[30];

    droplet_TestStr cas = new droplet_TestStr();

    cas.s = "0";
    cas.n = utils.toBigInteger(0);
    cases[0] = cas;

    cas = new droplet_TestStr();
    cas.s = "0.";
    cas.n = utils.toBigInteger(0);
    cases[1] = cas;

    cas = new droplet_TestStr();
    cas.s = "0.0";
    cas.n = utils.toBigInteger(0);
    cases[2] = cas;

    cas = new droplet_TestStr();
    cas.s = "0.000000";
    cas.n = utils.toBigInteger(0);
    cases[3] = cas;

    cas = new droplet_TestStr();
    cas.s = "0.0000000";
    cas.n = utils.toBigInteger(0);
    cases[4] = cas;

    cas = new droplet_TestStr();
    cas.s = "0.0000001";
    cas.n = utils.toBigInteger(0);
    cas.e = SKY_ErrTooManyDecimals;
    cases[5] = cas;

    cas = new droplet_TestStr();
    cas.s = "0.000001";
    cas.n = utils.toBigInteger(1);
    cases[6] = cas;

    cas = new droplet_TestStr();
    cas.s = "0.0000010";
    cas.n = utils.toBigInteger(1);
    cases[7] = cas;

    cas = new droplet_TestStr();
    cas.s = "1";
    cas.n = utils.toBigInteger(1e6);
    cases[8] = cas;

    cas = new droplet_TestStr();
    cas.s = "1.000001";
    cas.n = utils.toBigInteger(1e6 + 1);
    cases[9] = cas;

    cas = new droplet_TestStr();
    cas.s = "-1";
    cas.e = SKY_ErrNegativeValue;
    cases[10] = cas;

    cas = new droplet_TestStr();
    cas.s = "10000";
    cas.n = utils.toBigInteger(1e6 * 1e4);
    cases[11] = cas;

    cas = new droplet_TestStr();
    cas.s = "123456789.123456";
    cas.n = utils.toBigInteger(123456789123456.0);
    cases[12] = cas;

    cas = new droplet_TestStr();
    cas.s = "123.000456";
    cas.n = utils.toBigInteger(123000456);
    cases[13] = cas;

    cas = new droplet_TestStr();
    cas.s = "100SKY";
    cas.e = SKY_ERROR;
    cases[14] = cas;

    cas = new droplet_TestStr();
    cas.s = "";
    cas.e = SKY_ERROR;
    cases[15] = cas;

    cas = new droplet_TestStr();
    cas.s = "999999999999999999999999999999999999999999";
    cas.e = SKY_ErrTooLarge;
    cases[16] = cas;

    cas = new droplet_TestStr();
    cas.s = "9223372036854.775807";
    cas.n = utils.toBigInteger(9223372036854775807.0);
    cases[17] = cas;

    cas = new droplet_TestStr();
    cas.s = "-9223372036854.775807";
    cas.e = SKY_ErrNegativeValue;
    cases[18] = cas;

    cas = new droplet_TestStr();
    cas.s = "9223372036854775808";
    cas.e = SKY_ErrTooLarge;
    cases[19] = cas;

    cas = new droplet_TestStr();
    cas.s = "9223372036854775807.000001";
    cas.e = SKY_ErrTooLarge;
    cases[20] = cas;

    cas = new droplet_TestStr();
    cas.s = "9223372036854775807";
    cas.e = SKY_ErrTooLarge;
    cases[21] = cas;

    cas = new droplet_TestStr();
    cas.s = "9223372036854775806.000001";
    cas.e = SKY_ErrTooLarge;
    cases[22] = cas;

    cas = new droplet_TestStr();
    cas.s = "1.1";
    cas.n = utils.toBigInteger(1e6 + 1e5);
    cases[23] = cas;

    cas = new droplet_TestStr();
    cas.s = "1.01";
    cas.n = utils.toBigInteger(1e6 + 1e4);
    cases[24] = cas;

    cas = new droplet_TestStr();
    cas.s = "1.001";
    cas.n = utils.toBigInteger(1e6 + 1e3);
    cases[25] = cas;

    cas = new droplet_TestStr();
    cas.s = "1.0001";
    cas.n = utils.toBigInteger(1e6 + 1e2);
    cases[26] = cas;

    cas = new droplet_TestStr();
    cas.s = "1.00001";
    cas.n = utils.toBigInteger(1e6 + 1e1);
    cases[27] = cas;

    cas = new droplet_TestStr();
    cas.s = "1.000001";
    cas.n = utils.toBigInteger(1e6 + 1e0);
    cases[28] = cas;

    cas = new droplet_TestStr();
    cas.s = "1.0000001";
    cas.e = SKY_ErrTooManyDecimals;
    cases[29] = cas;
  }

  @Test
  public void TestFromString () {
    FullCases ();
      for (int i = 0; i < cases.length; i++) {
          droplet_TestStr tc = cases[i];
          SWIGTYPE_p_unsigned_long_long  n =  new_GoUint64Ptr();
          
          _GoString_ strtest = new _GoString_();
          strtest.SetString(tc.s);
          long err = SKY_droplet_FromString (strtest, n);
          BigInteger n_v = GoUint64Ptr_value(n);
          if (tc.e == SKY_OK) {
              assertEquals (err, SKY_OK);

              assertEquals (tc.n, n_v);
          } else {
              assertEquals (tc.e, err);
              assertEquals (0, n_v);
          }
      }
  }
}