package skycoin.libjava;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Base64;
import skycoin.libjava.*;

/**
 * Unit test for simple App.
 */
public class cipher_chacha20poly1305Test extends skycoin {
  static { System.loadLibrary("skycoin"); }

  private String cutString(String str, String ini, String end) {
    int endIndex = str.lastIndexOf(end);
    String outs = str.substring(0, endIndex);
    int offset = ini.length();
    int initIndex = outs.lastIndexOf(ini) + offset;
    int cut = outs.length() - initIndex;
    outs = outs.substring(initIndex, cut);
    return outs;
  }

  @Test

  public void TestScryptChacha20poly1305Encrypt() {
    for (int i = 1; i < 20; i++) {
      String name = "N=1<<" + i + "(" + (1 << i) + ")"
                    + ", R=8, p=1, keyLen=32";
      encrypt__ScryptChacha20poly1305 crypto =
          new encrypt__ScryptChacha20poly1305();
      crypto.setN(1 << i);
      crypto.setR(8);
      crypto.setP(1);
      crypto.setKeyLen(32);
      GoSlice encData = new GoSlice();
      GoSlice plain = new GoSlice();
      GoSlice passwd = new GoSlice();
      _GoString_ plaintext = new _GoString_();
      _GoString_ passwdText = new _GoString_();
      plaintext.setP("plaintext");
      plain.convertString(plaintext);
      passwdText.setP("password");
      passwd.convertString(passwdText);
      long err = SKY_encrypt_ScryptChacha20poly1305_Encrypt(crypto, plain,
                                                            passwd, encData);
      assertEquals(err, SKY_OK);
      assertEquals(encData.getLen() > 2, true);
      _GoString_ str = new _GoString_();
      encData.getString(str);

      if (str.getN() <= 188) {
        byte[] metab = Base64.getDecoder().decode(str.getP());
        String meta = new String(metab);

        SWIGTYPE_p_long_long n = new_GointPtr();
        SWIGTYPE_p_long_long r = new_GointPtr();
        SWIGTYPE_p_long_long p = new_GointPtr();
        SWIGTYPE_p_long_long keyLen = new_GointPtr();
        meta = cutString(meta, "{", "}");
        parseJsonMetaData(meta, n, r, p, keyLen);
        assertEquals(1 << i, GointPtr_value(n));
        assertEquals(8, GointPtr_value(r));
        assertEquals(1, GointPtr_value(p));
        assertEquals(32, GointPtr_value(keyLen));
      }
    }
  }

  class StructTest {
    public String name;
    public GoSlice data;
    public GoSlice encData;
    public GoSlice encPwd;
    public GoSlice decPwd;
    public long err;
  }

  @Test

  public void TestScryptChacha20poly1305Decrypt() {

    StructTest casett = new StructTest();

    // StructTest.data
    GoSlice pData = new GoSlice();
    _GoString_ pDataText = new _GoString_();
    pDataText.setP("plaintext");
    pData.convertString(pDataText);

    // StructTest.encData
    GoSlice pencData = new GoSlice();
    _GoString_ pencDataText = new _GoString_();
    pencDataText.setP(
        "dQB7Im4iOjUyNDI4OCwiciI6OCwicCI6MSwia2V5TGVuIjozMiwic2FsdCI6ImpiejUrSFNjTFFLWkI5T0tYblNNRmt2WDBPY3JxVGZ0ZFpDNm9KUFpaeHc9Iiwibm9uY2UiOiJLTlhOQmRQa1ZUWHZYNHdoIn3PQFmOot0ETxTuv//skTG7Q57UVamGCgG5");
    pencData.convertString(pDataText);
    // StructTest.encPwd
    GoSlice pencPwd = new GoSlice();
    _GoString_ pencPwdText = new _GoString_();
    pencPwdText.setP("pwd");
    pencPwd.convertString(pencPwdText);

    // StructTest.decPwd
    GoSlice pdecPwd = new GoSlice();
    _GoString_ pdecPwdText = new _GoString_();
    pdecPwdText.setP("pwd");
    pdecPwd.convertString(pdecPwdText);
    casett.data = pData;
    casett.decPwd = pdecPwd;
    casett.encData = pencData;
    casett.encPwd = pencPwd;
    casett.err = SKY_ERROR;
    StructTest[] tt = {casett};

    for (int i = 0; i < tt.length; i++) {
      StructTest tc = tt[i];
      String name = "N=1<<19 r=8 p=1 keyLen=32 " + tc.name;
      encrypt__ScryptChacha20poly1305 crypto =
          new encrypt__ScryptChacha20poly1305();
      GoSlice data = new GoSlice();
      long err = SKY_encrypt_ScryptChacha20poly1305_Decrypt(crypto, tc.encData,
                                                            tc.decPwd, data);
      assertEquals(name, err, tc.err);
    }
  }
}