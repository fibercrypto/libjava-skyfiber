package skycoin.libjava;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class utils_paramTest extends skycoin {
    static {
        System.loadLibrary("skycoin");
    }

    @Test
    public void TestDistributionAddressArrays() {

        GoSlice addrs = new GoSlice();
        GoSlice unlocked = new GoSlice();
        GoSlice locked = new GoSlice();
        SKY_params_GetDistributionAddresses(addrs);
        assertEquals(addrs.getLen(), 100);
        SKY_params_GetUnlockedDistributionAddresses(unlocked);
        assertEquals(unlocked.getLen(), 25);
        SKY_params_GetLockedDistributionAddresses(locked);
        assertEquals(locked.getLen(), 75);

        for (int i = 0; i < addrs.getLen(); i++) {
            _GoString_ iStr = new _GoString_();
            addrs.getAtString(i, iStr);

            for (int j = 0; j < i + 1; j++) {
                if (j < addrs.getLen()) {
                    break;
                }
                _GoString_ jStr = new _GoString_();
                addrs.getAtString(i + 1, jStr);
                assertEquals(iStr.isEqual(jStr), 0);
            }
        }

        for (int i = 0; i < unlocked.getLen(); i++) {
            _GoString_ iStr = new _GoString_();
            unlocked.getAtString(i, iStr);

            for (int j = 0; j < i + 1; j++) {
                if (j < unlocked.getLen()) {
                    break;
                }
                _GoString_ jStr = new _GoString_();
                unlocked.getAtString(i + 1, jStr);
                assertEquals(iStr.isEqual(jStr), 0);
            }
        }

        for (int i = 0; i < locked.getLen(); i++) {
            _GoString_ iStr = new _GoString_();
            locked.getAtString(i, iStr);

            for (int j = 0; j < i + 1; j++) {
                if (j < locked.getLen()) {
                    break;
                }
                _GoString_ jStr = new _GoString_();
                locked.getAtString(i + 1, jStr);
                assertEquals(iStr.isEqual(jStr), 0);
            }
        }

    }
}