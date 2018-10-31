package skycoin.libjava;

import static org.junit.Assert.*;

import org.junit.Test;
import skycoin.libjava.skycoin;

/**
 * Unit test for simple App.
 */
public class cipher_fieldTest extends skycoin {
  static { System.loadLibrary("skycoin"); }

  @Test
  public void TestFeInv() {
    secp256k1go__Field in_ = new secp256k1go__Field();
    secp256k1go__Field out_ = new secp256k1go__Field();
    secp256k1go__Field exp = new secp256k1go__Field();

    String in_hex =
        "813925AF112AAB8243F8CCBADE4CC7F63DF387263028DE6E679232A73A7F3C31";
    String exp_hex =
        "7F586430EA30F914965770F6098E492699C62EE1DF6CAFFA77681C179FDF3117";

    long err = SKY_secp256k1go_Field_SetHex(in_, in_hex);
    assertEquals(err, SKY_OK);
    err = SKY_secp256k1go_Field_SetHex(exp, exp_hex);
    assertEquals(err, SKY_OK);
    err = SKY_secp256k1go_Field_Inv(in_, out_);
    assertEquals(err, SKY_OK);
    SWIGTYPE_p_unsigned_char val = new_CharPtr();
    err = SKY_secp256k1go_Field_Equals(out_, exp, val);
    assertEquals(err, SKY_OK);
    assertEquals(CharPtr_value(val), 1);
  }
}