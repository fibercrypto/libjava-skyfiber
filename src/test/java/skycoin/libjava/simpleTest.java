package skycoin.libjava;

import static org.junit.Assert.*;
import java.io.*;

import org.junit.Test;

import skycoin.libjava.*;

/**
 * Unit test for simple App.
 */
public class simpleTest {
  static {
    System.out.print(System.getProperty("java.library.path"));
    System.loadLibrary("skycoin"); // hello.dll (Windows) or libhello.so (Unixes)
  }

  @Test
  public void pruebaJUnit() {
    assertTrue(true);
    cipher__Address a = new cipher__Address();
  }
}
