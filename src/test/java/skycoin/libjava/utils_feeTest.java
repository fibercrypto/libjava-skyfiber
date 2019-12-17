package skycoin.libjava;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class utils_feeTest extends skycoin {
    static {
        System.loadLibrary("skycoin");
    }

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

    verifyTxFeeTestCase[] burnFactor2verifyTxFeeTestCase = new verifyTxFeeTestCase[15];

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
        err = SKY_coin_Transaction_PushOutput(txn, addr, utils.toBigInteger(0), utils.toBigInteger(1000000));
        assertEquals(err, SKY_OK);
        err = SKY_coin_Transaction_PushOutput(txn, addr, utils.toBigInteger(0), utils.toBigInteger(3000000));
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
        err = SKY_fee_VerifyTransactionFee(txn, (GoUint64Ptr_value(hours).multiply(utils.toBigInteger(10))), 2);
        assertEquals(err, SKY_OK);

        // fee + hours overflows
        err = SKY_fee_VerifyTransactionFee(txn, ((utils.bigIntegerMaxValue.subtract(utils.toBigInteger(3000000)))), 2);
        assertEquals(err, SKY_ERROR);

        // txn has overflowing output hours
        err = SKY_coin_Transaction_PushOutput(txn, addr, utils.toBigInteger(0),
                (utils.bigIntegerMaxValue.subtract(utils.toBigInteger(1000000 - 3000000 + 1))));
        assertEquals("txn has overflowing output hours", err, SKY_OK);
        err = SKY_fee_VerifyTransactionFee(txn, utils.toBigInteger(10), 2);
        assertEquals("SKY_fee_VerifyTransactionFee failed", err, SKY_ErrTxnInsufficientFee);

        int len = burnFactor2verifyTxFeeTestCase.length;
        for (int i = 0; i < len; i++) {
            txn = new_Transaction__HandlePtr();
            txn = utils.makeEmptyTransaction();
            verifyTxFeeTestCase tc = burnFactor2verifyTxFeeTestCase[i];
            err = SKY_coin_Transaction_PushOutput(txn, addr, utils.toBigInteger(0), utils.toBigInteger(tc.ouputHours));
            assertEquals(err, SKY_OK);
            assertTrue(tc.inputHours >= tc.ouputHours);
            err = SKY_fee_VerifyTransactionFee(txn, utils.toBigInteger(tc.inputHours - tc.ouputHours), 2);
            assertEquals(tc.err, err);
        }
    }

    class requiredFeeTestCase {
        public long hours;
        public long fee;
    }

    requiredFeeTestCase[] burnFactor2verifyTxFeeTestCase2 = new requiredFeeTestCase[12];

    public void FullburnFactor2RequiredFeeTestCases2() {
        requiredFeeTestCase cases = new requiredFeeTestCase();
        cases.hours = 0;
        cases.fee = 0;
        burnFactor2verifyTxFeeTestCase2[0] = cases;
        cases = new requiredFeeTestCase();
        cases.hours = 1;
        cases.fee = 1;
        burnFactor2verifyTxFeeTestCase2[1] = cases;
        cases = new requiredFeeTestCase();
        cases.hours = 2;
        cases.fee = 1;
        burnFactor2verifyTxFeeTestCase2[2] = cases;
        cases = new requiredFeeTestCase();
        cases.hours = 3;
        cases.fee = 2;
        burnFactor2verifyTxFeeTestCase2[3] = cases;
        cases = new requiredFeeTestCase();
        cases.hours = 4;
        cases.fee = 2;
        burnFactor2verifyTxFeeTestCase2[4] = cases;
        cases = new requiredFeeTestCase();
        cases.hours = 5;
        cases.fee = 3;
        burnFactor2verifyTxFeeTestCase2[5] = cases;
        cases = new requiredFeeTestCase();
        cases.hours = 6;
        cases.fee = 3;
        burnFactor2verifyTxFeeTestCase2[6] = cases;
        cases = new requiredFeeTestCase();
        cases.hours = 7;
        cases.fee = 4;
        burnFactor2verifyTxFeeTestCase2[7] = cases;
        cases = new requiredFeeTestCase();
        cases.hours = 998;
        cases.fee = 499;
        burnFactor2verifyTxFeeTestCase2[8] = cases;
        cases = new requiredFeeTestCase();
        cases.hours = 999;
        cases.fee = 500;
        burnFactor2verifyTxFeeTestCase2[9] = cases;
        cases = new requiredFeeTestCase();
        cases.hours = 1000;
        cases.fee = 500;
        burnFactor2verifyTxFeeTestCase2[10] = cases;
        cases = new requiredFeeTestCase();
        cases.hours = 1001;
        cases.fee = 501;
        burnFactor2verifyTxFeeTestCase2[11] = cases;
    }

    @Test
    public void TestRequiredFee() {
        FullburnFactor2RequiredFeeTestCases2();
        requiredFeeTestCase[] cases = burnFactor2verifyTxFeeTestCase2;

        for (int i = 0; i < cases.length; i++) {
            requiredFeeTestCase tc = burnFactor2verifyTxFeeTestCase2[i];
            SWIGTYPE_p_unsigned_long_long fee = new_GoUint64Ptr();
            long err = SKY_fee_RequiredFee(utils.toBigInteger(tc.hours), 2, fee);
            assertEquals(err, SKY_OK);
            assertEquals(utils.toBigInteger(tc.fee), GoUint64Ptr_value(fee));
            SWIGTYPE_p_unsigned_long_long remainingHours = new_GoUint64Ptr();
            err = SKY_fee_RemainingHours(utils.toBigInteger(tc.hours), 2, remainingHours);
            assertEquals(err, SKY_OK);
            assertEquals(utils.toBigInteger(tc.hours).subtract(GoUint64Ptr_value(fee)),
                    GoUint64Ptr_value(remainingHours));
        }
    }

    class uxInput {
        public long time;
        public long coins;
        public long hours;

        public void setTime(long pTime) {
            time = pTime;
        }

        public void setCoins(long pCoins) {
            coins = pCoins;
        }

        public void setHours(long pHours) {
            hours = pHours;
        }

        public uxInput() {
            time = 0;
            coins = 0;
            hours = 0;
        }
    }

    class StrTest {
        public long[] outs;
        public uxInput[] ins;
        public long headTime;
        public long fee;
        public int err;

        public StrTest() {
            headTime = 0;
            outs = new long[0];
            ins = new uxInput[0];
            fee = 0;
            err = SKY_OK;
        }
    }

    StrTest[] ListCases;

    public void FullCases() {
        ListCases = new StrTest[5];
        long headTime = 1000;
        long nextTime = (headTime + 3600); // 1 hour later

        StrTest cases = new StrTest();
        cases.fee = 5;
        cases.outs = new long[1];
        cases.outs[0] = 5;
        cases.ins = new uxInput[1];
        uxInput pInput = new uxInput();

        pInput.setTime(headTime);
        pInput.setCoins(10000000);
        pInput.setHours(10);
        cases.ins[0] = pInput;
        cases.headTime = headTime;
        ListCases[0] = cases;

        cases = new StrTest();
        cases.fee = 0;
        cases.outs = new long[3];
        cases.outs[0] = 5;
        cases.outs[1] = 7;
        cases.outs[2] = 3;
        cases.ins = new uxInput[2];
        pInput = new uxInput();

        pInput.setTime(headTime);
        pInput.setCoins(10000000);
        pInput.setHours(10);
        cases.ins[0] = pInput;
        pInput = new uxInput();

        pInput.setTime(headTime);
        pInput.setCoins(10000000);
        pInput.setHours(5);
        cases.ins[1] = pInput;
        cases.headTime = headTime;
        ListCases[1] = cases;

        cases = new StrTest();
        cases.fee = 8;
        cases.outs = new long[2];
        cases.outs[0] = 5;
        cases.outs[1] = 10;
        cases.ins = new uxInput[2];
        pInput = new uxInput();
        pInput.setTime(nextTime);
        pInput.setCoins(10000000);
        pInput.setHours(10);
        cases.ins[0] = pInput;
        pInput = new uxInput();
        pInput.setTime(headTime);
        pInput.setCoins(8000000);
        pInput.setHours(5);
        cases.ins[1] = pInput;
        cases.headTime = nextTime;
        ListCases[2] = cases;

        cases = new StrTest();
        cases.err = SKY_ErrTxnInsufficientCoinHours;
        cases.outs = new long[3];
        cases.outs[0] = 5;
        cases.outs[1] = 10;
        cases.outs[2] = 1;
        cases.ins = new uxInput[2];
        pInput = new uxInput();
        pInput.setTime(headTime);
        pInput.setCoins(10000000);
        pInput.setHours(10);
        cases.ins[0] = pInput;
        pInput = new uxInput();
        pInput.setTime(headTime);
        pInput.setCoins(8000000);
        pInput.setHours(5);
        cases.ins[1] = pInput;
        cases.headTime = headTime;
        ListCases[3] = cases;

        cases = new StrTest();
        cases.err = SKY_ErrTxnInsufficientCoinHours;
        cases.outs = new long[3];
        cases.outs[0] = 0;
        cases.outs[1] = 10;
        cases.outs[2] = utils.bigIntegerMaxValue.longValue() - 9;
        cases.ins = new uxInput[2];
        pInput = new uxInput();
        pInput.setTime(headTime);
        pInput.setCoins(10000000);
        pInput.setHours(10);
        cases.ins[0] = pInput;
        pInput = new uxInput();
        pInput.setTime(headTime);
        pInput.setCoins(10000000);
        pInput.setHours(100);
        cases.ins[1] = pInput;
        cases.headTime = headTime;
        ListCases[4] = cases;
    }

    @Test
    public void TestTransactionFee() {
        FullCases();
        cipher__Address addr = utils.makeAddress();
        for (int i = 0; i < ListCases.length; i++) {
            StrTest tc = ListCases[i];
            SWIGTYPE_p_Transaction__Handle tx = utils.makeEmptyTransaction();
            for (int j = 0; j < tc.outs.length; j++) {
                long h = tc.outs[j];
                long err1 = SKY_coin_Transaction_PushOutput(tx, addr, utils.toBigInteger(0), utils.toBigInteger(h));
                assertEquals(err1, SKY_OK);
            }
            coin_UxOutArray inUxs = utils.makeUxOutArray(tc.ins.length);
            assertEquals(inUxs.getCount(), tc.ins.length);
            for (int j = 0; j < tc.ins.length; j++) {
                uxInput b = tc.ins[j];
                coin__UxOut ux = new coin__UxOut();
                coin__UxHead pHead = ux.getHead();
                coin__UxBody pBody = ux.getBody();
                pHead.setTime(utils.toBigInteger(b.time));
                pBody.setCoins(utils.toBigInteger(b.coins));
                pBody.setHours(utils.toBigInteger(b.hours));
                ux.setHead(pHead);
                ux.setBody(pBody);
                inUxs.setAt(j, ux);
            }
            SWIGTYPE_p_unsigned_long_long fee = new_GoUint64Ptr();
            long err = SKY_fee_TransactionFee(tx, utils.toBigInteger(tc.headTime), inUxs, fee);
            assertEquals("Iteracion " + i, err, tc.err);
            BigInteger fee_v = GoUint64Ptr_value(fee);
            assertEquals(fee_v.longValue(), tc.fee);
        }
    }
}