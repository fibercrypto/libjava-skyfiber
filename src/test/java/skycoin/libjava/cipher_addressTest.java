package skycoin.libjava;

import static org.junit.Assert.*;
import java.io.*;

import org.junit.Test;

import skycoin.libjava.*;

/**
 * Unit test for simple App.
 */
public class cipher_addressTest extends skycoin {
  static {
    System.loadLibrary("skycoin");
  }

  @Test
  public void TestDecodeBase58Address() {
    long err = 0;

    cipher_SecKey s = new cipher_SecKey();
    cipher_PubKey p = new cipher_PubKey();
    err = SKY_cipher_GenerateKeyPair(p, s);
    assertEquals(err, SKY_OK);
    err = SKY_cipher_SecKey_Verify(s);
    assertEquals(err, SKY_OK);
    err = SKY_cipher_PubKey_Verify(p);
    assertEquals(err, SKY_OK);

    cipher__Address a = new cipher__Address();
    cipher__Address a1 = new cipher__Address();
    cipher__Address a2 = new cipher__Address();

    err = SKY_cipher_AddressFromPubKey(p, a);
    assertEquals(err, SKY_OK);
    err = SKY_cipher_Address_Verify(a, p);
    assertEquals(err, SKY_OK);
    _GoString_ str =new _GoString_();
   
    str.SetString("");
    err = SKY_cipher_DecodeBase58Address(str, a1);
    assertEquals(err, SKY_ErrInvalidBase58String );
    str = new _GoString_();
    str.SetString("asa");
    err = SKY_cipher_DecodeBase58Address(str, a1);
    assertEquals(err, SKY_ErrInvalidBase58Char );
    _GoString_ addrStr = new _GoString_ ();
    err = SKY_cipher_Address_String (a, addrStr);
    assertEquals(err, SKY_OK);
    err = SKY_cipher_DecodeBase58Address (addrStr, a2);
    assertEquals("Failed SKY_cipher_DecodeBase58Address", err,SKY_OK);
    
    
  }
}
