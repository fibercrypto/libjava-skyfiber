package skycoin.libjava;

import static org.junit.Assert.*;

import org.junit.Test;

public class cipher_bip39Test extends skycoin {
  static { System.loadLibrary("skycoin"); }

  @Test
  public void TestIsMnemonicValid() {
    _GoString_ m = new _GoString_();
    long err = SKY_bip39_NewDefaultMnemomic(m);
    assertEquals(err, SKY_OK);
    SWIGTYPE_p_unsigned_char val = new_CharPtr();
    err = SKY_bip39_IsMnemonicValid(m, val);
    assertEquals(err, SKY_OK);
    assertTrue(CharPtr_value(val) == 1);

    // Truncated
    String str = m.getP();
    str = str.substring(0, str.length() - 15);
    _GoString_ Str = new _GoString_();
    Str.SetString(str);
    err = SKY_bip39_IsMnemonicValid(Str, val);
    assertEquals(err, SKY_OK);
    assertFalse(CharPtr_value(val) == 1);

    // Trailing whitespace
    str = m.getP();
    str += " ";
    Str.SetString(str);
    err = SKY_bip39_IsMnemonicValid(Str, val);
    assertEquals(err, SKY_OK);
    assertFalse(CharPtr_value(val) == 1);

    str = m.getP();
    str += "/n";
    Str.SetString(str);
    err = SKY_bip39_IsMnemonicValid(Str, val);
    assertEquals(err, SKY_OK);
    assertFalse(CharPtr_value(val) == 1);

    // Trailing whitespace
    str = m.getP();
    str += " ";
    Str.SetString(str);
    err = SKY_bip39_IsMnemonicValid(Str, val);
    assertEquals(err, SKY_OK);
    assertFalse(CharPtr_value(val) == 1);

    str = m.getP();
    str += "/n";
    Str.SetString(str);
    err = SKY_bip39_IsMnemonicValid(Str, val);
    assertEquals(err, SKY_OK);
    assertFalse(CharPtr_value(val) == 1);

    // Preceding whitespace
    str = m.getP();
    str.concat(" ");
    str.concat(str);
    Str.SetString(str);
    err = SKY_bip39_IsMnemonicValid(Str, val);
    assertEquals(err, SKY_OK);
    assertFalse(CharPtr_value(val) == 1);

    str = m.getP();
    str += "/n" + str;
    Str.SetString(str);
    err = SKY_bip39_IsMnemonicValid(Str, val);
    assertEquals(err, SKY_OK);
    assertFalse(CharPtr_value(val) == 1);

    // Extra whitespace between words
    str = m.getP();
    String[] ms = str.split(" ", 0);
    str.join(" ", ms);
    Str.SetString(str);
    err = SKY_bip39_IsMnemonicValid(Str, val);
    assertEquals(err, SKY_OK);
    assertFalse(CharPtr_value(val) == 1);

    // Contains invalid word
    str = m.getP();
    ms = str.split(" ", 0);
    ms[2] = "foo";
    str.join(" ", ms);
    Str.SetString(str);
    err = SKY_bip39_IsMnemonicValid(Str, val);
    assertEquals(err, SKY_OK);
    assertFalse(CharPtr_value(val) == 1);

    // Invalid number of words
    str = m.getP();
    ms = str.split(" ", 0);
    String[] ms1 = new String[ms.length - 1];
    for (int i = 0; i < ms1.length; i++) {
      ms1[i] = ms[i];
    }
    Str.SetString(str.join(" ", ms1));
    err = SKY_bip39_IsMnemonicValid(Str, val);
    assertEquals(err, SKY_OK);
    assertFalse(CharPtr_value(val) == 1);
  }
}
