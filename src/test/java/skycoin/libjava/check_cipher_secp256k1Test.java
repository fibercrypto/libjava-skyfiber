// package skycoin.libjava;

// import static org.junit.Assert.assertEquals;

// import org.junit.Test;
// import java.util.Random;

// /**
//  * Unit test for simple App.
//  */
// public class check_cipher_secp256k1Test extends skycoin {
//   static {
//     System.loadLibrary("skycoin");
//   }
//   transutils utils = new transutils();

//   String[] _testSeckey = { "08efb79385c9a8b0d1c6f5f6511be0c6f6c2902963d874a3a4bacc18802528d3",
//       "78298d9ecdc0640c9ae6883201a53f4518055442642024d23c45858f45d0c3e6",
//       "04e04fe65bfa6ded50a12769a3bd83d7351b2dbff08c9bac14662b23a3294b9e",
//       "2f5141f1b75747996c5de77c911dae062d16ae48799052c04ead20ccd5afa113" };

//   @Test

//   public void Test_Abnormal_Keys2() {
//     for (int i = 0; i < _testSeckey.length; i++) {
//       GoSlice seckkey1 = new GoSlice();
//       GoSlice pubkey1 = new GoSlice();
//       _GoString_ tt = new _GoString_();
//       tt.setP(_testSeckey[i]);
//       tt.setN(tt.getString().length());
//       long err = SKY_base58_String2Hex(tt, seckkey1);
//       assertEquals(err, SKY_OK);
//       err = SKY_secp256k1_PubkeyFromSeckey(seckkey1, pubkey1);
//       assertEquals(err, SKY_OK);
//       err = SKY_secp256k1_VerifyPubkey(pubkey1);
//       assertEquals(err, 1);
//     }
//   }

//   @Test

//   public void Test_Abnormal_Keys3() {
//     for (int i = 0; i < _testSeckey.length; i++) {
//       GoSlice seckkey1 = new GoSlice();
//       GoSlice pubkey1 = new GoSlice();
//       _GoString_ tt = new _GoString_();
//       tt.setP(_testSeckey[i]);
//       tt.setN(tt.getString().length());
//       long err = SKY_base58_String2Hex(tt, seckkey1);
//       assertEquals(err, SKY_OK);
//       err = SKY_secp256k1_PubkeyFromSeckey(seckkey1, pubkey1);
//       assertEquals(err, SKY_OK);

//       GoSlice seckkey2 = new GoSlice();
//       GoSlice pubkey2 = new GoSlice();
//       int n = (int) Math.random() % 4;
//       tt.setP(_testSeckey[n]);
//       tt.setN(tt.getString().length());
//       err = SKY_base58_String2Hex(tt, seckkey2);
//       assertEquals(err, SKY_OK);
//       err = SKY_secp256k1_PubkeyFromSeckey(seckkey2, pubkey2);
//       assertEquals(err, SKY_OK);
//       GoSlice puba = new GoSlice();
//       GoSlice pubb = new GoSlice();
//       err = SKY_secp256k1_ECDH(pubkey1, seckkey2, puba);
//       assertEquals(err, SKY_OK);
//       err = SKY_secp256k1_ECDH(pubkey2, seckkey1, pubb);
//       assertEquals(err, SKY_OK);
//     }
//   }
// }
