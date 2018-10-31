package skycoin.libjava;

import static org.junit.Assert.*;

import org.junit.Test;
import skycoin.libjava.skycoin;

/**
 * Unit test for simple App.
 */
public class cipher_ecTest extends skycoin {
  static { System.loadLibrary("skycoin"); }

  @Test
  public void TestECmult() {
    SWIGTYPE_p_Number_Handle u1 = new_Number_HandlePtr();
    SWIGTYPE_p_Number_Handle u2 = new_Number_HandlePtr();
    SKY_secp256k1go_Number_Create(u1);
    SKY_secp256k1go_Number_Create(u2);
    secp256k1go__XYZ public_kej = new secp256k1go__XYZ();
    secp256k1go__XYZ expres = new secp256k1go__XYZ();
    secp256k1go__XYZ pr = new secp256k1go__XYZ();
    SKY_secp256k1go_Field_SetHex(
        public_kej.getX(),
        "0EAEBCD1DF2DF853D66CE0E1B0FDA07F67D1CABEFDE98514AAD795B86A6EA66D");
    SKY_secp256k1go_Field_SetHex(
        public_kej.getY(),
        "BEB26B67D7A00E2447BAECCC8A4CEF7CD3CAD67376AC1C5785AEEBB4F6441C16");
    SKY_secp256k1go_Field_SetHex(
        public_kej.getZ(),
        "0000000000000000000000000000000000000000000000000000000000000001");
    SKY_secp256k1go_Number_SetHex(
        u1, "B618EBA71EC03638693405C75FC1C9ABB1A74471BAAF1A3A8B9005821491C4B4");
    SKY_secp256k1go_Number_SetHex(
        u2, "8554470195DE4678B06EDE9F9286545B51FF2D9AA756CE35A39011783563EA60");
    SKY_secp256k1go_Field_SetHex(
        expres.getX(),
        "EB6752420B6BDB40A760AC26ADD7E7BBD080BF1DF6C0B009A0D310E4511BDF49");
    SKY_secp256k1go_Field_SetHex(
        expres.getY(),
        "8E8CEB84E1502FC536FFE67967BC44314270A0B38C79865FFED5A85D138DCA6B");
    SKY_secp256k1go_Field_SetHex(
        expres.getZ(),
        "813925AF112AAB8243F8CCBADE4CC7F63DF387263028DE6E679232A73A7F3C31");

    assertEquals(SKY_secp256k1go_XYZ_ECmult(public_kej, pr, u2, u1),
                 (long)SKY_OK);
    SWIGTYPE_p_unsigned_char val = new_CharPtr();
    assertEquals(SKY_secp256k1go_XYZ_Equals(pr, expres, val), SKY_OK);
    assertEquals(CharPtr_value(val), 1);
  }

  @Test
  public void TestMultGen() {
    SWIGTYPE_p_Number_Handle noce = new_Number_HandlePtr();
    long err = SKY_secp256k1go_Number_Create(noce);
    secp256k1go__Field x = new secp256k1go__Field();
    secp256k1go__Field y = new secp256k1go__Field();
    secp256k1go__Field z = new secp256k1go__Field();
    secp256k1go__XYZ pr = new secp256k1go__XYZ();
    SKY_secp256k1go_Number_SetHex(
        noce,
        "9E3CD9AB0F32911BFDE39AD155F527192CE5ED1F51447D63C4F154C118DA598E");
    SKY_secp256k1go_Field_SetHex(
        x, "02D1BF36D37ACD68E4DD00DB3A707FD176A37E42F81AEF9386924032D3428FF0");
    SKY_secp256k1go_Field_SetHex(
        y, "FD52E285D33EC835230EA69F89D9C38673BD5B995716A4063C893AF02F938454");
    SKY_secp256k1go_Field_SetHex(
        z, "4C6ACE7C8C062A1E046F66FD8E3981DC4E8E844ED856B5415C62047129268C1B");
    SKY_secp256k1go_ECmultGen(pr, noce);
    SKY_secp256k1go_Field_Normalize(pr.getX());
    SKY_secp256k1go_Field_Normalize(pr.getY());
    SKY_secp256k1go_Field_Normalize(pr.getZ());
    SWIGTYPE_p_unsigned_char val = new_CharPtr();
    assertEquals(SKY_secp256k1go_Field_Equals(pr.getX(), x, val), SKY_OK);
    assertEquals(CharPtr_value(val), 1);
    assertEquals(SKY_secp256k1go_Field_Equals(pr.getY(), y, val), SKY_OK);
    assertEquals(CharPtr_value(val), 1);
    assertEquals(SKY_secp256k1go_Field_Equals(pr.getZ(), z, val), SKY_OK);
    assertEquals(CharPtr_value(val), 1);
  }
}
