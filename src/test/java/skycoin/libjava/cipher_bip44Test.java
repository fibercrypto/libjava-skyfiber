package skyfiber.libjava;

import org.junit.Test;

import skyfiber.libjava.skycoin;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class cipher_bip44Test extends skycoin {
    static {
        System.loadLibrary("skycoin");
    }
    public long CoinTypeBitcoin = 0;
    public long CoinTypeBitcoinTestnet = 1;
    public long CoinTypeSkycoin = 8000;
    public long ExternalChainIndex = 0;
    public long ChangeChainIndex = 1;
    public long FirstHardenedChild = 0x80000000;

    private GoSlice mustDefaultSeed() {
        GoSlice seed = new_GoSlicePtr();
        _GoString_ mnemonic = new _GoString_();
        mnemonic.setP("dizzy cigar grant ramp inmate uniform gold success able payment faith practice");
        mnemonic.setN(78);
        _GoString_ passphrase = new _GoString_();
        passphrase.setP("");
        passphrase.setN(0);
        long err = SKY_bip39_NewSeed(mnemonic, passphrase, seed);
        assertEquals(err, SKY_OK);
        _GoString_ str = new _GoString_();
        err = SKY_base58_Hex2String(seed, str);
        assertEquals(err, SKY_OK);
        assertEquals(str.getP(),
                "24e563fb095d766df3862c70432cc1b2210b24d232da69af7af09d2ec86d28782ce58035bae29994c84081836aebe36a9b46af1578262fefc53e37efbe94be57");
        return seed;
    }

    @Test
    public void TestNewCoin() {
        // bad seed
        GoSlice tmp = new GoSlice();
        SKY_cipher_RandByte(3, tmp);
        SWIGTYPE_p_Coin__Handle coin = new_Coin__HandlePtr();
        long err = SKY_bip44_NewCoin(tmp, CoinTypeBitcoin, coin);
        assertEquals(err, SKY_ErrInvalidSeedLength);

        // bad coin_type
        GoSlice Bad = mustDefaultSeed();
        err = SKY_bip44_NewCoin(Bad, FirstHardenedChild, coin);
        assertEquals(err, SKY_ErrInvalidCoinType);
        err = SKY_bip44_NewCoin(Bad, FirstHardenedChild + 1, coin);
        assertEquals(err, SKY_ErrInvalidCoinType);

        SWIGTYPE_p_Coin__Handle c = new_Coin__HandlePtr();
        err = SKY_bip44_NewCoin(Bad, CoinTypeBitcoin, c);
        assertEquals(err, SKY_OK);

        SWIGTYPE_p_Account__Handle account = new_Account__HandlePtr();
        err = SKY_bip44_Coin_Account(c, 0, account);
        assertEquals(err, SKY_OK);
        _GoString_ acc_string = new _GoString_();
        err = SKY_bip44_Account_String(account, acc_string);
        assertEquals(err, SKY_OK);
        assertEquals(acc_string.getP(),
                "xprv9yKAFQtFghZSe4mfdpdqFm1WWmGeQbYMB4MSGUB85zbKGQgSxty4duZb8k6hNoHVd2UR7Y3QhWU3rS9wox9ewgVG7gDLyYTL4yzEuqUCjvF");
        SWIGTYPE_p_PrivateKey__Handle privk = new_PrivateKey__HandlePtr();
        SWIGTYPE_p_PublicKey__Handle pubk = new_PublicKey__HandlePtr();
        err = SKY_bip44_Account_GetPrivateKey(account, privk);
        assertEquals(err, SKY_OK);
        err = SKY_bip32_PrivateKey_Publickey(privk, pubk);
        assertEquals(err, SKY_OK);
        _GoString_ pubk_string = new _GoString_();
        err = SKY_bip32_PublicKey_String(pubk, pubk_string);
        assertEquals(err, SKY_OK);
        assertEquals(pubk_string.getP(),
                "xpub6CJWevR9X57jrYr8jrAqctxF4o78p4GCYHH34rajeL8J9D1bWSHKBht4yzwiTQ4FP4HyQpx99iLxvU54rbEbcxBUgxzTGGudBVXb1N2gcHF");

        err = SKY_bip44_Coin_Account(c, 1, account);
        assertEquals(err, SKY_OK);
        err = SKY_bip44_Account_String(account, acc_string);
        assertEquals(err, SKY_OK);
        assertEquals(acc_string.getP(),
                "xprv9yKAFQtFghZSgShGXkxHsYQfFaqMyutf3izng8tV4Tmp7gidQUPB8kCuv66yukidivM2oSaUvGus8ffnYvYKChB7DME2H2AvUq8LM2rXUzF");
        privk = new_PrivateKey__HandlePtr();
        pubk = new_PublicKey__HandlePtr();
        err = SKY_bip44_Account_GetPrivateKey(account, privk);
        assertEquals(err, SKY_OK);
        err = SKY_bip32_PrivateKey_Publickey(privk, pubk);
        assertEquals(err, SKY_OK);
        err = SKY_bip32_PublicKey_String(pubk, pubk_string);
        assertEquals(err, SKY_OK);
        assertEquals(pubk_string.getP(),
                "xpub6CJWevR9X57jtvmjdnVJEgMPocfrPNcWQwvPUXJ6coJnzV3mx1hRgYXPmQJh5vLQvrVCY8LtJB5xLLiPJVmpSwBe2yhonQLoQuSsCF8YPLN");

        SWIGTYPE_p_Account__Handle account_temp = new_Account__HandlePtr();
        err = SKY_bip44_Coin_Account(c, 0x80000000, account_temp);
        assertEquals(err, SKY_ErrInvalidAccount);
        err = SKY_bip44_Coin_Account(c, 0x80000001, account_temp);
        assertEquals(err, SKY_ErrInvalidAccount);

        SWIGTYPE_p_PrivateKey__Handle external = new_PrivateKey__HandlePtr();
        err = SKY_bip44_Account_External(account, external);
        assertEquals(err, SKY_OK);
        _GoString_ privk_string = new _GoString_();
        err = SKY_bip32_PrivateKey_String(external, privk_string);
        assertEquals(err, SKY_OK);
        assertEquals(privk_string.getP(),
                "xprv9zjsvjLiqSerDzbeRXPeXwz8tuQ7eRUABkgFAgLPHw1KzGKkgBhJhGaMYHM8j2KDXBZTCv4m19qjxrrD7gusrtdpZ7xzJywdXHaMZEjf3Uv");
        pubk = new_PublicKey__HandlePtr();
        err = SKY_bip32_PrivateKey_Publickey(external, pubk);
        assertEquals(err, SKY_OK);
        err = SKY_bip32_PublicKey_String(pubk, pubk_string);
        assertEquals(err, SKY_OK);
        assertEquals(pubk_string.getP(),
                "xpub6DjELEscfpD9SUg7XYveu5vsSwEc3tC1Yybqy4jzrGYJs4euDj1ZF4tqPZYvViMn9cvBobHyubuuh69PZ1szaBBx5oxPiQzD492B6C4QDHe");

        SWIGTYPE_p_PublicKey__Handle external0 = new_PublicKey__HandlePtr();
        err = SKY_bip32_PrivateKey_NewPublicChildKey(external, 0, external0);
        assertEquals(err, SKY_OK);
        GoSlice Key = new GoSlice();
        _GoString_ KeyStr = new _GoString_();
        err = SKY_bip32_PublicKey_GetKey(external0, Key);
        assertEquals(err, SKY_OK);
        err = SKY_base58_Hex2String(Key, KeyStr);
        assertEquals(KeyStr.getP(), "034d36f3bcd74e19204e75b81b9c0726e41b799858b92bab73f4cd7498308c5c8b");

        SWIGTYPE_p_PublicKey__Handle external1 = new_PublicKey__HandlePtr();
        err = SKY_bip32_PrivateKey_NewPublicChildKey(external, 1, external1);
        assertEquals(err, SKY_OK);
        GoSlice Key1 = new GoSlice();
        _GoString_ Key1Str = new _GoString_();
        err = SKY_bip32_PublicKey_GetKey(external1, Key1);
        assertEquals(err, SKY_OK);
        SKY_base58_Hex2String(Key1, Key1Str);
        assertEquals(Key1Str.getP(), "02f7309e9f559d847ee9cc9ee144cfa490791e33e908fdbde2dade50a389408b01");

        SWIGTYPE_p_PrivateKey__Handle change = new_PrivateKey__HandlePtr();
        err = SKY_bip44_Account_Change(account, change);
        assertEquals(err, SKY_OK);
        err = SKY_bip32_PrivateKey_String(change, privk_string);
        assertEquals(err, SKY_OK);
        assertEquals(privk_string.getP(),
                "xprv9zjsvjLiqSerGzJyBrpZgCaGpQCeFDnZEuAV714WigmFyHT4nFLhZLeuHzLNE19PgkZeQ5Uf2pjFZjQTHbkugDbmw5TAPAvgo2jsaTnZo2A");
        pubk = new_PublicKey__HandlePtr();
        err = SKY_bip32_PrivateKey_Publickey(change, pubk);
        assertEquals(err, SKY_OK);
        err = SKY_bip32_PublicKey_String(pubk, pubk_string);
        assertEquals(err, SKY_OK);
        assertEquals(pubk_string.getP(),
                "xpub6DjELEscfpD9VUPSHtMa3LX1NS38egWQc865uPU8H2JEr5nDKnex78yP9GxhFr5cnCRgiQF1dkv7aR7moraPrv73KHwSkDaXdWookR1Sh9p");

        SWIGTYPE_p_PublicKey__Handle change0 = new_PublicKey__HandlePtr();
        err = SKY_bip32_PrivateKey_NewPublicChildKey(change, 0, change0);
        assertEquals(err, SKY_OK);
        err = SKY_bip32_PublicKey_GetKey(change0, Key);
        assertEquals(err, SKY_OK);
        SKY_base58_Hex2String(Key, KeyStr);
        assertEquals(KeyStr.getP(), "026d3eb891e81ecabedfa8560166af383457aedaf172af9d57d00508faa5f57c4c");

        SWIGTYPE_p_PublicKey__Handle change1 = new_PublicKey__HandlePtr();
        err = SKY_bip32_PrivateKey_NewPublicChildKey(change, 1, change1);
        assertEquals(err, SKY_OK);
        err = SKY_bip32_PublicKey_GetKey(change1, Key1);
        assertEquals(err, SKY_OK);
        SKY_base58_Hex2String(Key1, Key1Str);
        assertEquals(Key1Str.getP(), "02681b301293fdf0292cd679b37d60b92a71b389fd994b2b57c8daf99532bfb4a5");
    }

}
