package skycoin.libjava;

import org.junit.Test;

import skycoin.libjava.SWIGTYPE_p_Distribution__Handle;
import skycoin.libjava.skycoin;

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
        SWIGTYPE_p_Distribution__Handle dist = new_Distribution__HandlePtr();
        GoSlice all = new GoSlice();
        GoSlice unlocked = new GoSlice();
        GoSlice locked = new GoSlice();
        long err = SKY_params_Distribution_GetMainNetDistribution(dist);
        assertEquals(err, SKY_OK);

        err = SKY_params_Distribution_GetAddresses(dist, all);
        assertEquals(err, SKY_OK);
        assertEquals(all.getLen(), 100);

        // At the time of this writing, there should be 25 addresses in the
        // unlocked pool and 75 in the locked pool.
        err = SKY_params_Distribution_UnlockedAddresses(dist, unlocked);
        assertEquals(err, SKY_OK);
        assertEquals(unlocked.getLen(), 25);
        err = SKY_params_Distribution_LockedAddresses(dist, locked);
        assertEquals(err, SKY_OK);
        assertEquals(locked.getLen(), 75);

        for (int i = 0; i < all.getLen(); i++)
        {
            _GoString_ iStr = new _GoString_();
            all.getAtString(i, iStr);

            for (int j = 0; j < i + 1; j++)
            {
                if (j < all.getLen())
                {
                    break;
                }
                _GoString_ jStr = new _GoString_();
                all.getAtString(i + 1, jStr);
                assertEquals(iStr.isEqual(jStr), 0);
            }
        }

        for (int i = 0; i < unlocked.getLen(); i++)
        {
            _GoString_ iStr = new _GoString_();
            unlocked.getAtString(i, iStr);

            for (int j = 0; j < i + 1; j++)
            {
                if (j < unlocked.getLen())
                {
                    break;
                }
                _GoString_ jStr = new _GoString_();
                unlocked.getAtString(i + 1, jStr);
                assertEquals(iStr.isEqual(jStr), 0);
            }
        }

        for (int i = 0; i < locked.getLen(); i++)
        {
            _GoString_ iStr = new _GoString_();
            locked.getAtString(i, iStr);

            for (int j = 0; j < i + 1; j++)
            {
                if (j < locked.getLen())
                {
                    break;
                }
                _GoString_ jStr = new _GoString_();
                locked.getAtString(i + 1, jStr);
                assertEquals(iStr.isEqual(jStr), 0);
            }
        }


    }
}