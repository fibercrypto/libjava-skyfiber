package skycoin.libjava;

import static org.junit.Assert.*;

import java.math.*;

import org.junit.Test;
import skycoin.libjava.*;

/**
 * Unit test for simple App.
 */
public class coin_outputTest extends skycoin {
  static {
    System.loadLibrary("skycoin");
  }

  transutils utils = new transutils();

  private void TestUxBodyHash() {
    coin__UxBody uxb = utils.makeUxBody();
    cipher_SHA256 hasx = new cipher_SHA256();
    long err = SKY_coin_UxBody_Hash(uxb, hasx);
    assertEquals(err, SKY_OK);
    assertEquals(hasx.isEqual(new cipher_SHA256()), 0);
  }

  @Test
  public void TestUxOutHash() {
    coin__UxBody uxb = utils.makeUxBody();
    coin__UxOut uxo = utils.makeUxOut();
    uxo.setBody(uxb);
    cipher_SHA256 hash_body = new cipher_SHA256();
    cipher_SHA256 hash_out = new cipher_SHA256();
    long err = SKY_coin_UxBody_Hash(uxb, hash_body);
    assertEquals(err, SKY_OK);
    err = SKY_coin_UxOut_Hash(uxo, hash_out);
    assertEquals(err, SKY_OK);
    assertEquals(hash_body.isEqual(hash_out), 1);
    // Head should not affect hash
    coin__UxHead uxh = new coin__UxHead();
    uxh.setTime(BigDecimal.valueOf(0).toBigInteger());
    uxh.setBkSeq(BigDecimal.valueOf(1).toBigInteger());
    uxo.setHead(uxh);
    err = SKY_coin_UxOut_Hash(uxo, hash_out);
    assertEquals(err, SKY_OK);
    assertEquals(hash_body.isEqual(hash_out), 1);
  }

  @Test
  public void TestUxOutSnapshotHash() {
    cipher_PubKey p = new cipher_PubKey();
    cipher_SecKey s = new cipher_SecKey();
    long err = SKY_cipher_GenerateKeyPair(p, s);
    assertEquals(err, SKY_OK);
    coin__UxBody uxb = new coin__UxBody();
    GoSlice b = new GoSlice();
    err = SKY_cipher_RandByte(128, b);
    assertEquals(err, SKY_OK);
    cipher_SHA256 h = new cipher_SHA256();
    err = SKY_cipher_SumSHA256(b, h);
    assertEquals(err, SKY_OK);
    uxb.SetSrcTransaction(h);
    cipher__Address a = new cipher__Address();
    err = SKY_cipher_AddressFromPubKey(p, a);
    assertEquals(err, SKY_OK);
    uxb.setAddress(a);
    uxb.setCoins(BigDecimal.valueOf(1e6).toBigInteger());
    uxb.setHours(BigDecimal.valueOf(100).toBigInteger());
    coin__UxOut uxo = new coin__UxOut();
    coin__UxHead uxh = new coin__UxHead();
    uxh.setTime(BigDecimal.valueOf(100).toBigInteger());
    uxh.setBkSeq(BigDecimal.valueOf(2).toBigInteger());
    uxo.setHead(uxh);
    uxo.setBody(uxb);
    cipher_SHA256 hn = new cipher_SHA256();
    err = SKY_coin_UxOut_SnapshotHash(uxo, hn);
    assertEquals(err, SKY_OK);
    // snapshot hash should be dependent on every field in body and head
    // Head Time
    coin__UxOut uxo_2 = uxo;
    uxh.setTime(BigDecimal.valueOf(20).toBigInteger());
    uxo_2.setHead(uxh);
    cipher_SHA256 hn_2 = new cipher_SHA256();
    err = SKY_coin_UxOut_SnapshotHash(uxo_2, hn_2);
    assertEquals(err, SKY_OK);
    assertEquals(hn.isEqual(hn_2), 0);
    // Head BkSeq
    uxo_2 = uxo;
    uxh.setBkSeq(BigDecimal.valueOf(4).toBigInteger());
    uxo_2.setHead(uxh);
    hn_2 = new cipher_SHA256();
    err = SKY_coin_UxOut_SnapshotHash(uxo_2, hn_2);
    assertEquals(err, SKY_OK);
    assertEquals(hn.isEqual(hn_2), 0);
    // Body SetSrcTransaction
    uxo_2 = uxo;
    uxb = new coin__UxBody();
    err = SKY_cipher_RandByte(128, b);
    assertEquals(err, SKY_OK);
    h = new cipher_SHA256();
    err = SKY_cipher_SumSHA256(b, h);
    assertEquals(err, SKY_OK);
    uxb.SetSrcTransaction(h);
    uxo_2.setBody(uxb);
    hn_2 = new cipher_SHA256();
    err = SKY_coin_UxOut_SnapshotHash(uxo_2, hn_2);
    assertEquals(err, SKY_OK);
    assertEquals(hn.isEqual(hn_2), 0);
    // Body Address
    cipher_PubKey p_2 = new cipher_PubKey();
    cipher_SecKey s_2 = new cipher_SecKey();
    err = SKY_cipher_GenerateKeyPair(p_2, s_2);
    assertEquals(err, SKY_OK);
    cipher__Address a_2 = new cipher__Address();
    err = SKY_cipher_AddressFromPubKey(p_2, a_2);
    assertEquals(err, SKY_OK);
    uxo_2 = uxo;
    uxb = new coin__UxBody();
    uxb.setAddress(a_2);
    uxo_2.setBody(uxb);
    hn_2 = new cipher_SHA256();
    err = SKY_coin_UxOut_SnapshotHash(uxo_2, hn_2);
    assertEquals(err, SKY_OK);
    assertEquals(hn.isEqual(hn_2), 0);
    // Body Coins
    uxo_2 = uxo;
    uxb = new coin__UxBody();
    uxb.setCoins(BigDecimal.valueOf(2).toBigInteger());
    uxo_2.setBody(uxb);
    hn_2 = new cipher_SHA256();
    err = SKY_coin_UxOut_SnapshotHash(uxo_2, hn_2);
    assertEquals(err, SKY_OK);
    assertEquals(hn.isEqual(hn_2), 0);
    // Body Hours
    uxo_2 = uxo;
    uxb = new coin__UxBody();
    uxb.setHours(BigInteger.valueOf(2));
    uxo_2.setBody(uxb);
    hn_2 = new cipher_SHA256();
    err = SKY_coin_UxOut_SnapshotHash(uxo_2, hn_2);
    assertEquals(err, SKY_OK);
    assertEquals(hn.isEqual(hn_2), 0);
  }

  @Test
  public void TestUxOutCoinHours() {
    cipher_PubKey p = new cipher_PubKey();
    cipher_SecKey s = new cipher_SecKey();
    SKY_cipher_GenerateKeyPair(p, s);
    coin__UxBody uxb = new coin__UxBody();
    GoSlice b = new GoSlice();
    SKY_cipher_RandByte(128, b);
    cipher_SHA256 h = new cipher_SHA256();
    long err = SKY_cipher_SumSHA256(b, h);
    assertEquals(err, SKY_OK);
    uxb.SetSrcTransaction(h);
    cipher__Address a = new cipher__Address();
    SKY_cipher_AddressFromPubKey(p, a);
    uxb.setAddress(a);
    uxb.setCoins(BigDecimal.valueOf(1e6).toBigInteger());
    uxb.setHours(BigDecimal.valueOf(100).toBigInteger());
    coin__UxOut uxo = new coin__UxOut();
    coin__UxHead uxh = new coin__UxHead();
    uxh.setTime(BigInteger.valueOf(100));
    uxh.setBkSeq(BigInteger.valueOf(2));
    uxo.setHead(uxh);
    uxo.setBody(uxb);

    // Less than an hour passed
    BigInteger now = uxh.getTime();
    now = now.add(BigInteger.valueOf(100));
    SWIGTYPE_p_unsigned_long_long hours = new_GoUint64Ptr();
    err = SKY_coin_UxOut_CoinHours(uxo, now, hours);
    assertEquals(err, SKY_OK);
    assertEquals("Less than an hour passed", uxh.getTime(), GoUint64Ptr_value(hours));
    // 1 hours passed
    now = uxh.getTime();
    now = now.add(BigInteger.valueOf(3600));
    err = SKY_coin_UxOut_CoinHours(uxo, now, hours);
    assertEquals(err, SKY_OK);
    BigInteger tmp = uxb.getCoins();
    tmp = tmp.divide(BigInteger.valueOf(1000000));
    tmp = tmp.add(uxh.getTime());
    assertEquals("1 hours passed", GoUint64Ptr_value(hours), tmp);
    // 6 hours passed
    now = uxh.getTime();
    now = now.add(BigInteger.valueOf(3600 * 6));
    err = SKY_coin_UxOut_CoinHours(uxo, now, hours);
    assertEquals(err, SKY_OK);
    tmp = uxb.getCoins();
    tmp = tmp.divide(BigInteger.valueOf(1000000));
    tmp = tmp.multiply(BigInteger.valueOf(6));
    tmp = tmp.add(uxh.getTime());
    assertEquals("6 hours passed", GoUint64Ptr_value(hours), tmp);
    // Time is backwards (treated as no hours passed)
    now = uxh.getTime();
    now = now.divide(BigInteger.valueOf(2));
    err = SKY_coin_UxOut_CoinHours(uxo, now, hours);
    assertEquals(err, SKY_OK);
    assertEquals(GoUint64Ptr_value(hours), uxh.getTime());
    // 1 hour has passed, output has 1.5 coins, should gain 1 coinhour
    uxb.setCoins(BigInteger.valueOf(1500000));
    now = uxh.getTime();
    now = now.add(BigInteger.valueOf(3600));
    err = SKY_coin_UxOut_CoinHours(uxo, now, hours);
    assertEquals(err, SKY_OK);
    tmp = uxb.getHours();
    tmp = tmp.add(BigInteger.valueOf(1));
    assertEquals(GoUint64Ptr_value(hours), tmp);
    // 2 hours have passed, output has 1.5 coins, should gain 3 coin hours
    uxb.setCoins(BigInteger.valueOf(1500000));
    uxo.setBody(uxb);
    now = uxh.getTime();
    now = now.add(BigInteger.valueOf(3600 * 2));
    err = SKY_coin_UxOut_CoinHours(uxo, now, hours);
    assertEquals(err, SKY_OK);
    // 1 second has passed, output has 3600 coins, should gain 1 coin hour
    uxb.setCoins(BigDecimal.valueOf(36e8).toBigInteger());
    uxo.setBody(uxb);
    now = uxh.getTime();
    now = now.add(BigInteger.valueOf(1));
    err = SKY_coin_UxOut_CoinHours(uxo, now, hours);
    assertEquals(err, SKY_OK);
    tmp = uxb.getHours();
    tmp = tmp.add(BigInteger.valueOf(1));
    assertEquals(GoUint64Ptr_value(hours), tmp);
    // 1000000 hours minus 1 second have passed, output has 1 droplet, should
    // gain 0 coin hour
    uxb.setCoins(BigInteger.valueOf(1));
    uxo.setBody(uxb);
    now = uxh.getTime();
    now = now.add(BigDecimal.valueOf((1e6 * 3600) - 1).toBigInteger());
    err = SKY_coin_UxOut_CoinHours(uxo, now, hours);
    assertEquals(err, SKY_OK);
    assertEquals(GoUint64Ptr_value(hours), uxb.getHours());
    // 1000000 hours have passed, output has 1 droplet, should gain 1 coin hour
    uxb.setCoins(BigInteger.valueOf(1));
    uxo.setBody(uxb);
    now = uxh.getTime();
    now = now.add(BigDecimal.valueOf(10e5 * 3600).toBigInteger());
    err = SKY_coin_UxOut_CoinHours(uxo, now, hours);
    assertEquals(err, SKY_OK);
    tmp = uxb.getHours();
    tmp = tmp.add(BigInteger.valueOf(1));
    assertEquals(GoUint64Ptr_value(hours), tmp);
    // No hours passed, using initial coin hours
    uxb.setCoins(BigDecimal.valueOf(10e8).toBigInteger());
    uxb.setHours(BigDecimal.valueOf(100 * 100).toBigInteger());
    uxo.setBody(uxb);
    now = uxh.getTime();
    err = SKY_coin_UxOut_CoinHours(uxo, now, hours);
    assertEquals(err, SKY_OK);
    assertEquals(GoUint64Ptr_value(hours), uxb.getHours());
    // One hour passed, using initial coin hours
    now = uxh.getTime();
    now = now.add(BigInteger.valueOf(3600));
    err = SKY_coin_UxOut_CoinHours(uxo, now, hours);
    assertEquals(err, SKY_OK);
    tmp = uxb.getHours();
    tmp = tmp.add(BigDecimal.valueOf(10e8 / 10e5).toBigInteger());
    assertEquals(GoUint64Ptr_value(hours), tmp);
    // No hours passed and no hours to begin with 0
    uxb.setHours(BigInteger.valueOf(0));
    uxo.setBody(uxb);
    now = uxh.getTime();
    err = SKY_coin_UxOut_CoinHours(uxo, now, hours);
    assertEquals(err, SKY_OK);
    assertEquals(GoUint64Ptr_value(hours), BigInteger.valueOf(0));
    // Centuries have passed, time-based calculation overflows uint64 when
    // calculating the whole coin seconds
    uxb.setCoins(BigDecimal.valueOf(20e5).toBigInteger());
    uxo.setBody(uxb);

    now = BigDecimal.valueOf(1.8446744073709552e20).toBigInteger();
    err = SKY_coin_UxOut_CoinHours(uxo, now, hours);
    assertEquals(err, SKY_ERROR);
    // Centuries have passed, time-based calculation overflows uint64 when
    // calculating the droplet seconds
    uxb.setCoins(BigDecimal.valueOf(15e5).toBigInteger());
    uxo.setBody(uxb);
    now = BigDecimal.valueOf(1.8446744073709552e20).toBigInteger();
    err = SKY_coin_UxOut_CoinHours(uxo, now, hours);
    assertEquals(err, SKY_ERROR);
    // Output would overflow if given more hours, has reached its limit
    uxb.setCoins(BigDecimal.valueOf(36e8).toBigInteger());
    uxo.setBody(uxb);
    now = BigDecimal.valueOf(1.8446744073709552e20).toBigInteger();
    err = SKY_coin_UxOut_CoinHours(uxo, now, hours);
    assertEquals(err, SKY_ERROR);
  }

  @Test
  public void TestUxArrayCoins() {
    coin_UxOutArray uxa = utils.makeUxOutArray(4);
    for (int i = 0; i < uxa.getCount(); i++) {
      coin__UxOut x = uxa.getAt(i);
      x.getBody().setCoins(BigDecimal.valueOf(1e6).toBigInteger());
    }
    SWIGTYPE_p_unsigned_long_long coins = new_GoUint64Ptr();
    long err = SKY_coin_UxArray_Coins(uxa, coins);
    assertEquals(GoUint64Ptr_value(coins), BigDecimal.valueOf(4e6).toBigInteger());
    assertEquals(err, SKY_OK);
    coin__UxOut uxo = uxa.getAt(2);
    uxo.getBody().setCoins(utils.bigIntegerMaxValue.subtract(BigDecimal.valueOf(1e6).toBigInteger()));
    uxa.setAt(2, uxo);
    err = SKY_coin_UxArray_Coins(uxa, coins);
    assertEquals(err, SKY_ERROR);
  }

  private BigInteger ux_Array_CoinsHours(coin_UxOutArray uxa, long now, long slic) {
    BigInteger result = BigInteger.valueOf(0);
    for (long i = slic; i < uxa.getCount(); i++) {
      coin__UxOut x = uxa.getAt((int) i);
      SWIGTYPE_p_unsigned_long_long time = new_GoUint64Ptr();
      long err = SKY_coin_UxOut_CoinHours(x, BigInteger.valueOf(now), time);
      result = result.add(GoUint64Ptr_value(time));
      result = result.add(result);
      assertEquals(err, SKY_OK);
    }
    return result;
  }

  @Test
  public void TestUxArrayCoinHours() {
    coin_UxOutArray uxa = new coin_UxOutArray();
    makeUxArray(uxa, 4);
    SWIGTYPE_p_unsigned_long_long count = new_GoUint64Ptr();
    coin__UxOut uxo = uxa.getAt(0);
    long err = SKY_coin_UxArray_CoinHours(uxa, uxo.getHead().getTime(), count);
    assertEquals(err, SKY_OK);
    assertEquals(GoUint64Ptr_value(count), BigInteger.valueOf(400));
    // 1 hour later
    BigInteger tmp = uxo.getHead().getTime();
    tmp = tmp.add(BigInteger.valueOf(3600));
    err = SKY_coin_UxArray_CoinHours(uxa, tmp, count);
    assertEquals(err, SKY_OK);
    assertEquals(GoUint64Ptr_value(count), BigInteger.valueOf(404));
    // 1.5 hours later

    err = SKY_coin_UxArray_CoinHours(uxa, uxo.getHead().getTime().add(BigInteger.valueOf(3600 + 1800)), count);
    assertEquals(err, SKY_OK);
    assertEquals(GoUint64Ptr_value(count), BigInteger.valueOf(404));
    // 2 hours later
    err = SKY_coin_UxArray_CoinHours(uxa, uxo.getHead().getTime().add(BigInteger.valueOf(3600 + 4600)), count);
    assertEquals(err, SKY_OK);
    assertEquals(GoUint64Ptr_value(count), BigInteger.valueOf(408));

    uxo = uxa.getAt(2);
    coin__UxBody tmpUxo = uxo.getBody();
    tmpUxo.setHours(utils.bigIntegerMaxValue.subtract(BigInteger.valueOf(100)));
    uxo.setBody(tmpUxo);
    uxa.setAt(2, uxo);
    uxo = uxa.getAt(0);
    err = SKY_coin_UxArray_CoinHours(uxa, uxo.getHead().getTime(), count);
    assertEquals(err, SKY_OK);

    err = SKY_coin_UxArray_CoinHours(uxa, uxo.getHead().getTime().multiply(BigDecimal.valueOf(10e11).toBigInteger()),
        count);
    assertEquals(err, SKY_ErrAddEarnedCoinHoursAdditionOverflow);
  }

  @Test
  public void TestUxArrayHashArray() {
    coin_UxOutArray uxa = new coin_UxOutArray();
    makeUxArray(uxa, 4);
    cipher_SHA256 sha = new cipher_SHA256();
    cipher_SHA256s hashes = new cipher_SHA256s();
    long err = SKY_coin_UxArray_Hashes(uxa, hashes);
    assertEquals(err, SKY_OK);
    assertEquals(hashes.getCount(), uxa.getCount());
    coin__UxOut uxo = uxa.getAt(0);
    err = SKY_coin_UxOut_Hash(uxo, sha);
    assertEquals(err, SKY_OK);
    assertEquals(hashes.getAt(0).isEqual(sha), 1);
    for (int i = 0; i < hashes.getCount(); i++) {
      err = SKY_coin_UxOut_Hash(uxa.getAt(i), sha);
      assertEquals(err, SKY_OK);
      assertEquals(sha.isEqual(hashes.getAt(i)), 1);
    }
  }

  @Test
  public void TestUxArrayHasDupes() {
    coin_UxOutArray uxa = new coin_UxOutArray();
    makeUxArray(uxa, 4);
    SWIGTYPE_p_unsigned_char hasDupes = new_CharPtr();
    long err = SKY_coin_UxArray_HasDupes(uxa, hasDupes);
    assertEquals(err, SKY_OK);
    assertEquals(CharPtr_value(hasDupes), 0);
    uxa.setAt(0, uxa.getAt(1));
    err = SKY_coin_UxArray_HasDupes(uxa, hasDupes);
    assertEquals(err, SKY_OK);
    assertEquals(CharPtr_value(hasDupes), 1);
  }

  @Test
  public void TestUxArraySub() {
    coin_UxOutArray uxa = new coin_UxOutArray();
    coin_UxOutArray uxb = new coin_UxOutArray();
    coin_UxOutArray uxc = new coin_UxOutArray();
    coin_UxOutArray uxd = new coin_UxOutArray();
    makeUxArray(uxa, 4);
    makeUxArray(uxb, 4);
    uxc.allocate(6);
    uxc.setAt(0, uxa.getAt(0));
    uxc.setAt(1, uxa.getAt(1));
    for (int i = 0; i < uxb.getCount(); i++) {
      uxc.setAt(i + 2, uxb.getAt(i));
    }
    uxc.setAt(6, uxa.getAt(1));
    uxc.setAt(7, uxa.getAt(2));

    long err = SKY_coin_UxArray_Sub(uxc, uxa, uxd);
    assertEquals(err, SKY_OK);
    assertEquals(uxd.getCount(), uxb.getCount());
    assertEquals(uxd.isEqual(uxb), 1);
    err = SKY_coin_UxArray_Sub(uxc, uxb, uxd);
    assertEquals(err, SKY_OK);
    assertEquals(uxd.getCount(), 2);
    coin_UxOutArray test = new coin_UxOutArray();
    test.allocate(2);
    test.setAt(0, uxa.getAt(0));
    test.setAt(1, uxa.getAt(1));
    assertEquals(test.isEqual(uxd), 1);
    // No intersection
    err = SKY_coin_UxArray_Sub(uxa, uxb, uxd);
    assertEquals(err, SKY_OK);
    assertEquals(uxd.isEqual(uxa), 1);
    err = SKY_coin_UxArray_Sub(uxb, uxa, uxd);
    assertEquals(err, SKY_OK);
    assertEquals(uxd.isEqual(uxb), 1);
  }

  public boolean manualUxArrayIsSorted(coin_UxOutArray uxa) {
    cipher_SHA256 sha_1 = new cipher_SHA256();
    cipher_SHA256 sha_2 = new cipher_SHA256();
    boolean isSort = true;
    for (int i = 0; i < uxa.getCount() - 1; i++) {
      long err = SKY_coin_UxOut_Hash(uxa.getAt(i), sha_1);
      assertEquals(err, SKY_OK);
      err = SKY_coin_UxOut_Hash(uxa.getAt(i + 1), sha_2);
      assertEquals(err, SKY_OK);
      if (sha_1.isEqual(sha_2) == 0) {
        isSort = false;
      }
    }
    return isSort;
  }

  @Test
  public void TestUxArrayLen() {
    coin_UxOutArray uxa = new coin_UxOutArray();
    makeUxArray(uxa, 4);
    assertEquals(uxa.getCount(), 4);
  }

  @Test
  public void TestUxArrayLess() {
    coin_UxOutArray uxa = new coin_UxOutArray();
    makeUxArray(uxa, 2);
    cipher_SHA256s hashes = new cipher_SHA256s();
    long err = SKY_coin_UxArray_Hashes(uxa, hashes);
    assertEquals(err, SKY_OK);
    assertEquals(hashes.getCount(), uxa.getCount());
    SWIGTYPE_p_unsigned_char less = new_CharPtr();
    SWIGTYPE_p_unsigned_char less2 = new_CharPtr();
    err = SKY_coin_UxArray_Less(uxa, 0, 1, less);
    assertEquals(err, SKY_OK);
    err = SKY_coin_UxArray_Less(uxa, 1, 0, less2);
    assertEquals(err, SKY_OK);
    assertNotEquals(CharPtr_value(less), CharPtr_value(less2));
  }

  @Test
  public void TestUxArraySwap() {
    coin_UxOutArray uxa = new coin_UxOutArray();
    uxa.allocate(2);
    coin__UxOut uxx = new coin__UxOut();
    coin__UxOut uxy = new coin__UxOut();
    makeUxOut(uxx);
    makeUxOut(uxy);
    uxa.setAt(0, uxx);
    uxa.setAt(1, uxy);
    long err = SKY_coin_UxArray_Swap(uxa, 0, 1);
    assertEquals(err, SKY_OK);
    assertEquals(uxa.getAt(0).isEqual(uxy), 0);
    assertEquals(uxa.getAt(1).isEqual(uxx), 0);
    err = SKY_coin_UxArray_Swap(uxa, 0, 1);
    assertEquals(err, SKY_OK);
    assertEquals(uxa.getAt(0).isEqual(uxx), 0);
    assertEquals(uxa.getAt(1).isEqual(uxy), 0);
    err = SKY_coin_UxArray_Swap(uxa, 1, 0);
    assertEquals(err, SKY_OK);
    assertEquals(uxa.getAt(0).isEqual(uxx), 0);
    assertEquals(uxa.getAt(1).isEqual(uxy), 0);
  }

  @Test
  public void TestAddressUxOutsKeys() {
    coin_UxOutArray uxa = new coin_UxOutArray();
    makeUxArray(uxa, 3);
    SWIGTYPE_p_AddressUxOuts_Handle uxH = new_AddressUxOuts__HandlePtr();
    long err = SKY_coin_NewAddressUxOuts(uxa, uxH);
    assertEquals(err, SKY_OK);
    cipher_Addresses keys = new cipher_Addresses();
    err = SKY_coin_AddressUxOuts_Keys(uxH, keys);
    assertEquals(err, SKY_OK);
    assertEquals(keys.getCount(), 3);
    for (int i = 0; i < keys.getCount(); i++) {
      cipher__Address k = keys.getAt(i);
      long res = uxa.getAt(0).getBody().getAddress().isEqual(k) + uxa.getAt(1).getBody().getAddress().isEqual(k)
          + uxa.getAt(2).getBody().getAddress().isEqual(k);
      assertTrue(res > 0);
    }
  }

  @Test
  public void TestAddressUxOutsSub() {
    coin_UxOutArray uxs = new coin_UxOutArray();
    coin_UxOutArray empty = new coin_UxOutArray();
    makeUxArray(uxs, 4);
    makeUxArray(empty, 0);

    SWIGTYPE_p_AddressUxOuts_Handle up = new_AddressUxOuts__HandlePtr();
    long err = SKY_coin_NewAddressUxOuts(empty, up);
    assertEquals(err, SKY_OK);
    SWIGTYPE_p_AddressUxOuts_Handle up2 = new_AddressUxOuts__HandlePtr();
    err = SKY_coin_NewAddressUxOuts(empty, up2);
    assertEquals(err, SKY_OK);

    coin__UxOut uxo = uxs.getAt(1);
    coin__UxBody tmpBody = new coin__UxBody();
    tmpBody = uxo.getBody();
    tmpBody.setAddress(uxs.getAt(0).getBody().getAddress());
    uxo.setBody(tmpBody);
    uxs.setAt(1, uxo);

    coin_UxOutArray arg = new coin_UxOutArray();
    arg.release();
    arg.allocate(1);
    arg.setAt(0, uxs.getAt(0));
    err = SKY_coin_AddressUxOuts_Set(up, uxs.getAt(0).getBody().getAddress(), arg);
    assertEquals(err, SKY_OK);
    arg.release();
    arg.allocate(1);
    arg.setAt(0, uxs.getAt(2));
    err = SKY_coin_AddressUxOuts_Set(up, uxs.getAt(2).getBody().getAddress(), arg);
    assertEquals(err, SKY_OK);
    arg.release();
    arg.allocate(1);
    arg.setAt(0, uxs.getAt(3));
    err = SKY_coin_AddressUxOuts_Set(up, uxs.getAt(3).getBody().getAddress(), arg);
    assertEquals(err, SKY_OK);

    arg.release();
    arg.allocate(1);
    arg.setAt(0, uxs.getAt(1));
    err = SKY_coin_AddressUxOuts_Set(up2, uxs.getAt(1).getBody().getAddress(), arg);
    assertEquals(err, SKY_OK);
    arg.release();
    arg.allocate(1);
    arg.setAt(0, uxs.getAt(2));
    err = SKY_coin_AddressUxOuts_Set(up2, uxs.getAt(2).getBody().getAddress(), arg);
    assertEquals(err, SKY_OK);

    SWIGTYPE_p_AddressUxOuts_Handle up3 = new_AddressUxOuts__HandlePtr();
    err = SKY_coin_AddressUxOuts_Add(up, up2, up3);
    assertEquals(err, SKY_OK);
    SWIGTYPE_p_long_long len = new_GointPtr();
    err = SKY_coin_AddressUxOuts_Length(up3, len);
    assertEquals(err, SKY_OK);
    assertEquals(GointPtr_value(len), 3);
    err = SKY_coin_AddressUxOuts_Length(up2, len);
    assertEquals(err, SKY_OK);
    assertEquals(GointPtr_value(len), 2);
  }

  @Test
  public void TestAddressUxOutsFlatten() {
    coin_UxOutArray empty = new coin_UxOutArray();
    makeUxArray(empty, 0);
    SWIGTYPE_p_AddressUxOuts_Handle up = new_AddressUxOuts__HandlePtr();
    long err = SKY_coin_NewAddressUxOuts(empty, up);
    assertEquals(err, SKY_OK);
    coin_UxOutArray uxs = new coin_UxOutArray();
    makeUxArray(uxs, 3);
    coin__UxOut uxo = uxs.getAt(2);
    coin__UxBody tmpBody = uxo.getBody();
    tmpBody.setAddress(uxs.getAt(1).getBody().getAddress());
    uxo.setBody(tmpBody);
    uxs.setAt(0, uxo);
    cipher__Address emptyAddr = new cipher__Address();
    makeAddress(emptyAddr);

    // An empty array
    err = SKY_coin_AddressUxOuts_Set(up, emptyAddr, empty);
    assertEquals(err, SKY_OK);
    // 1 element array
    coin_UxOutArray arg = new coin_UxOutArray();
    arg.release();
    arg.allocate(1);
    arg.setAt(0, uxs.getAt(0));
    err = SKY_coin_AddressUxOuts_Set(up, uxs.getAt(0).getBody().getAddress(), arg);
    assertEquals(err, SKY_OK);
    arg.release();
    arg.allocate(2);
    arg.setAt(0, uxs.getAt(1));
    arg.setAt(1, uxs.getAt(2));
    err = SKY_coin_AddressUxOuts_Set(up, uxs.getAt(1).getBody().getAddress(), arg);
    assertEquals(err, SKY_OK);

    coin_UxOutArray flat = new coin_UxOutArray();
    err = SKY_coin_AddressUxOuts_Flatten(up, flat);
    assertEquals(err, SKY_OK);
    assertEquals(flat.getCount(), 2);

    for (int i = 0; i < flat.getCount(); i++) {
      coin__UxOut ux = flat.getAt(i);
      assertNotEquals(ux.getBody().getAddress().isEqual(emptyAddr), 1);
    }
    if (flat.getAt(0).getBody().getAddress().isEqual(uxs.getAt(0).getBody().getAddress()) == 1) {
      assertEquals(flat.getAt(0).isEqual(uxs.getAt(0)), 0);
      assertEquals(flat.getAt(0).getBody().getAddress().isEqual(uxs.getAt(0).getBody().getAddress()), 1);
      assertEquals(flat.getAt(0 + 1).getBody().getAddress().isEqual(uxs.getAt(0 + 1).getBody().getAddress()), 1);
      assertEquals(flat.getAt(0 + 1).isEqual(uxs.getAt(1)), 0);
    }
  }

  @Test
  public void TestNewAddressUxOuts() {
    coin_UxOutArray uxs = new coin_UxOutArray();
    makeUxArray(uxs, 6);
    coin__UxOut ux = uxs.getAt(1);
    coin__UxBody tmpBody = ux.getBody();
    tmpBody.setAddress(uxs.getAt(0).getBody().getAddress());
    ux.setBody(tmpBody);
    uxs.setAt(1, ux);
    ux = uxs.getAt(3);

    tmpBody = ux.getBody();
    tmpBody.setAddress(uxs.getAt(2).getBody().getAddress());
    ux.setBody(tmpBody);
    uxs.setAt(3, ux);
    ux = uxs.getAt(4);
    tmpBody = ux.getBody();
    tmpBody.setAddress(uxs.getAt(2).getBody().getAddress());
    ux.setBody(tmpBody);
    uxs.setAt(4, ux);

    SWIGTYPE_p_AddressUxOuts_Handle uxo = new_AddressUxOuts__HandlePtr();
    long err = SKY_coin_NewAddressUxOuts(uxs, uxo);
    assertEquals(err, SKY_OK);
    SWIGTYPE_p_long_long len = new_GointPtr();
    err = SKY_coin_AddressUxOuts_Length(uxo, len);
    assertEquals(err, SKY_OK);
    assertEquals(GointPtr_value(len), 3);
    coin_UxOutArray uxa1 = new coin_UxOutArray();
    coin_UxOutArray uxa2 = new coin_UxOutArray();

    SKY_coin_AddressUxOuts_Get(uxo, uxs.getAt(0).getBody().getAddress(), uxa1);
    assertEquals(err, SKY_OK);
    uxa2.allocate(2);
    uxa2.setAt(1, uxs.getAt(4));
    uxa2.setAt(0, uxs.getAt(0));
    uxa2.setAt(1, uxs.getAt(4));
    uxa2.setAt(1, uxs.getAt(1));
    uxa2.setAt(1, uxs.getAt(4));
    assertEquals(uxa1.isEqual(uxa2), 0);

    uxa2.setAt(1, uxs.getAt(4));
    uxa1.release();
    SKY_coin_AddressUxOuts_Get(uxo, uxs.getAt(3).getBody().getAddress(), uxa1);
    assertEquals(err, SKY_OK);
    uxa2.release();
    uxa2.allocate(3);
    uxa2.setAt(0, uxs.getAt(2));
    uxa2.setAt(1, uxs.getAt(3));
    uxa2.setAt(1, uxs.getAt(4));
    assertEquals(uxa1.isEqual(uxa2), 0);

    uxa1.release();
    SKY_coin_AddressUxOuts_Get(uxo, uxs.getAt(5).getBody().getAddress(), uxa1);
    assertEquals(err, SKY_OK);
    uxa2.release();
    uxa2.allocate(1);
    uxa2.setAt(0, uxs.getAt(5));
    assertEquals(uxa1.isEqual(uxa2), 1);
  }
}