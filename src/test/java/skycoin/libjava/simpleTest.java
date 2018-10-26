package skycoin.libjava;

import static org.junit.Assert.*;
import java.io.*;

import org.junit.Test;

import skycoin.libjava.*;

/**
 * Unit test for simple App.
 */
public class simpleTest extends skycoin {
  static { System.loadLibrary("skycoin"); }

  @Test
  public void test() {
    assertTrue(true);
    cipher__Address a = new cipher__Address();
    cipher_PubKey p = new cipher_PubKey();
    cipher_SecKey s = new cipher_SecKey();

    long err = SKY_OK;
    err = skycoin.SKY_cipher_GenerateKeyPair(p, s);
    assertEquals(err, SKY_OK);
  }
}
