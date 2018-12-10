package skycoin.libjava;

import static org.junit.Assert.*;

import java.math.*;

import org.junit.Test;
import skycoin.libjava.*;

/**
 * Unit test for simple App.
 */
public class utils_feeTest extends skycoin {
  static { System.loadLibrary("skycoin"); }

  transutils utils = new transutils();

  class verifyTxFeeTestCase {
    public long inputHours;
    public long ouputHours;
    public long err;

    public verifyTxFeeTestCase() {
      err = 0;
      inputHours = 0;
      ouputHours = 0;
    }

    public void setParameter(long pIn, long pOut, long pErr) {
      err = pErr;
      inputHours = pIn;
      ouputHours = pOut;
    }
  }

  verifyTxFeeTestCase[] burnFactor2verifyTxFeeTestCase =
      new verifyTxFeeTestCase[15];

  public void FullburnFactor2verifyTxFeeTestCase() {

    verifyTxFeeTestCase cases = new verifyTxFeeTestCase();
    cases.inputHours = 0;
    cases.ouputHours = 0;
    cases.err = SKY_ErrTxnNoFee;
    burnFactor2verifyTxFeeTestCase[0] = cases;

    cases = new verifyTxFeeTestCase();
    cases.inputHours = 1;
    cases.ouputHours = 0;
    cases.err = SKY_OK;
    burnFactor2verifyTxFeeTestCase[1] = cases;

    cases = new verifyTxFeeTestCase();
    cases.inputHours = 1;
    cases.ouputHours = 1;
    cases.err = SKY_ErrTxnNoFee;
    burnFactor2verifyTxFeeTestCase[2] = cases;

    cases = new verifyTxFeeTestCase();
    cases.inputHours = 2;
    cases.ouputHours = 0;
    cases.err = SKY_OK;
    burnFactor2verifyTxFeeTestCase[3] = cases;

    cases = new verifyTxFeeTestCase();
    cases.inputHours = 2;
    cases.ouputHours = 1;
    cases.err = SKY_OK;
    burnFactor2verifyTxFeeTestCase[4] = cases;

    cases = new verifyTxFeeTestCase();
    cases.inputHours = 2;
    cases.ouputHours = 2;
    cases.err = SKY_ErrTxnNoFee;
    burnFactor2verifyTxFeeTestCase[5] = cases;

    cases = new verifyTxFeeTestCase();
    cases.inputHours = 3;
    cases.ouputHours = 0;
    cases.err = SKY_OK;
    burnFactor2verifyTxFeeTestCase[6] = cases;

    cases = new verifyTxFeeTestCase();
    cases.inputHours = 3;
    cases.ouputHours = 1;
    cases.err = SKY_OK;
    burnFactor2verifyTxFeeTestCase[7] = cases;

    cases = new verifyTxFeeTestCase();
    cases.inputHours = 3;
    cases.ouputHours = 2;
    cases.err = SKY_ErrTxnInsufficientFee;
    burnFactor2verifyTxFeeTestCase[8] = cases;

    cases = new verifyTxFeeTestCase();
    cases.inputHours = 3;
    cases.ouputHours = 3;
    cases.err = SKY_ErrTxnNoFee;
    burnFactor2verifyTxFeeTestCase[9] = cases;

    cases = new verifyTxFeeTestCase();
    cases.inputHours = 4;
    cases.ouputHours = 0;
    cases.err = SKY_OK;
    burnFactor2verifyTxFeeTestCase[10] = cases;

    cases = new verifyTxFeeTestCase();
    cases.inputHours = 4;
    cases.ouputHours = 1;
    cases.err = SKY_OK;
    burnFactor2verifyTxFeeTestCase[11] = cases;

    cases = new verifyTxFeeTestCase();
    cases.inputHours = 4;
    cases.ouputHours = 2;
    cases.err = SKY_OK;
    burnFactor2verifyTxFeeTestCase[12] = cases;

    cases = new verifyTxFeeTestCase();
    cases.inputHours = 4;
    cases.ouputHours = 3;
    cases.err = SKY_ErrTxnInsufficientFee;
    burnFactor2verifyTxFeeTestCase[13] = cases;

    cases = new verifyTxFeeTestCase();
    cases.inputHours = 4;
    cases.ouputHours = 4;
    cases.err = SKY_ErrTxnNoFee;
    burnFactor2verifyTxFeeTestCase[14] = cases;
  }

  @Test
  public void TestVerifyTransactionFee() {
    FullburnFactor2verifyTxFeeTestCase();
    SWIGTYPE_p_Transaction__Handle empty = utils.makeEmptyTransaction();
    SWIGTYPE_p_unsigned_long_long hours = new_GoUint64Ptr();
    long err = SKY_coin_Transaction_OutputHours(empty, hours);
    assertEquals(err, SKY_OK);
    assertEquals(GoUint64Ptr_value(hours), utils.toBigInteger(0));

    // A txn with no outputs hours and no coinhours burn fee is valid
    err = SKY_fee_VerifyTransactionFee(empty, utils.toBigInteger(0), 2);
    assertEquals(err, SKY_ErrTxnNoFee);

    // A txn with no outputs hours but with a coinhours burn fee is valid
    err = SKY_fee_VerifyTransactionFee(empty, utils.toBigInteger(100), 2);
    assertEquals(err, SKY_OK);
    SWIGTYPE_p_Transaction__Handle txn = utils.makeEmptyTransaction();
    cipher__Address addr = new cipher__Address();
    addr = utils.makeAddress();
    assertEquals(err, 0);
    err = SKY_coin_Transaction_PushOutput(txn, addr, utils.toBigInteger(0),
                                          utils.toBigInteger(1000000));
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_PushOutput(txn, addr, utils.toBigInteger(0),
                                          utils.toBigInteger(3000000));
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_OutputHours(txn, hours);
    assertEquals(err, SKY_OK);
    assertEquals(GoUint64Ptr_value(hours), utils.toBigInteger(4000000));

    // A txn with insufficient net coinhours burn fee is invalid
    err = SKY_fee_VerifyTransactionFee(txn, utils.toBigInteger(0), 2);
    assertEquals(err, SKY_ErrTxnNoFee);
    err = SKY_fee_VerifyTransactionFee(txn, utils.toBigInteger(1), 2);
    assertEquals(err, SKY_ErrTxnInsufficientFee);

    // A txn with sufficient net coinhours burn fee is valid
    err = SKY_coin_Transaction_OutputHours(txn, hours);
    assertEquals(err, SKY_OK);
    err = SKY_fee_VerifyTransactionFee(txn, GoUint64Ptr_value(hours), 2);
    assertEquals(err, SKY_OK);
    err = SKY_coin_Transaction_OutputHours(txn, hours);
    assertEquals(err, SKY_OK);
    err = SKY_fee_VerifyTransactionFee(
        txn, (GoUint64Ptr_value(hours).multiply(utils.toBigInteger(10))), 2);
    assertEquals(err, SKY_OK);

    // fee + hours overflows
    err = SKY_fee_VerifyTransactionFee(
        txn, ((utils.bigIntegerMaxValue.subtract(utils.toBigInteger(3000000)))),
        2);
    assertEquals(err, SKY_ERROR);

    // txn has overflowing output hours
    err = SKY_coin_Transaction_PushOutput(
        txn, addr, utils.toBigInteger(0),
        (utils.bigIntegerMaxValue.subtract(
            utils.toBigInteger(1000000 - 3000000 + 1))));
    assertEquals("txn has overflowing output hours", err, SKY_OK);
    err = SKY_fee_VerifyTransactionFee(txn, utils.toBigInteger(10), 2);
    assertEquals("SKY_fee_VerifyTransactionFee failed", err, SKY_ErrTxnInsufficientFee);

    int len = burnFactor2verifyTxFeeTestCase.length;
    for (int i = 0; i < len; i++) {
      txn = new_Transaction__HandlePtr();
      txn = utils.makeEmptyTransaction();
      verifyTxFeeTestCase tc = burnFactor2verifyTxFeeTestCase[i];
      err = SKY_coin_Transaction_PushOutput(txn, addr, utils.toBigInteger(0),
                                            utils.toBigInteger(tc.ouputHours));
      assertEquals(err, SKY_OK);
      assertTrue(tc.inputHours >= tc.ouputHours);
      err = SKY_fee_VerifyTransactionFee(
          txn, utils.toBigInteger(tc.inputHours - tc.ouputHours), 2);
      assertEquals(tc.err, err);
    }
  }
}