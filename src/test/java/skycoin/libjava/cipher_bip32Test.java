package skycoin.libjava;

import org.junit.Test;

import skycoin.libjava.skycoin;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

/**
 * Unit test for simple App.
 */
public class cipher_bip32Test extends skycoin {
        static {
                System.loadLibrary("skycoin");
        }
        transutils utils = new transutils();
        private long FirstHardenedChild = 2147483648L;

        private class testChildKey {
                public String path;
                public String privKey;
                public String pubKey;
                public String fingerprint;
                public String identifier;
                public String chainCode;
                public String hexPubKey;
                public String wifPrivKey;
                public long childNUmber;
                public byte depth;
        }

        private class testMasterKey {
                public String seed;
                public testChildKey[] children;
                public String privkey;
                public String pubKey;
                public String hexPubKey;
                public String wifPrivKey;
                public String fingerprint;
                public String identifier;
                public String chainCode;
                public long childNUmber;
                public byte depth;
                public int depthNumber;
        }

        private void assertPrivateKeySerialization(SWIGTYPE_p_PrivateKey__Handle key, String expectedTmp) {
                GoSlice expectedBytes = new GoSlice();
                _GoString_ expected = new _GoString_();
                expected.setP(expectedTmp);
                expected.setN(expectedTmp.length());
                long err = SKY_base58_Decode(expected, expectedBytes);
                assertEquals(SKY_OK, err);
                GoSlice serialized = new GoSlice();
                err = SKY_bip32_PrivateKey_Serialize(key, serialized);
                assertEquals(SKY_OK, err);
                assertEquals(expectedBytes.isEqual(serialized), 1);
                SWIGTYPE_p_PrivateKey__Handle key2 = new_PrivateKey__HandlePtr();
                err = SKY_bip32_DeserializePrivateKey(serialized, key2);
                assertEquals(SKY_OK, err);
                assertEquals(isPrivateKeyEq(key, key2), 1);
                SWIGTYPE_p_PrivateKey__Handle key3 = new_PrivateKey__HandlePtr();
                err = SKY_bip32_DeserializeEncodedPrivateKey(expected, key3);
                assertEquals(SKY_OK, err);
                assertEquals(isPrivateKeyEq(key2, key3), 1);
        }

        private void assertPublicKeySerialization(SWIGTYPE_p_PublicKey__Handle key, String expectedTmp) {
                GoSlice expectedBytes = new GoSlice();
                _GoString_ expected = new _GoString_();
                expected.setP(expectedTmp);
                expected.setN(expectedTmp.length());
                long err = SKY_base58_Decode(expected, expectedBytes);
                assertEquals(SKY_OK, err);
                GoSlice serialized = new GoSlice();
                err = SKY_bip32_PublicKey_Serialize(key, serialized);
                assertEquals(SKY_OK, err);
                assertEquals(expectedBytes.isEqual(serialized), 1);
                SWIGTYPE_p_PublicKey__Handle key2 = new_PublicKey__HandlePtr();
                err = SKY_bip32_DeserializePublicKey(serialized, key2);
                assertEquals(SKY_OK, err);
                assertEquals(isPublicKeyEq(key, key2), 1);
                SWIGTYPE_p_PublicKey__Handle key3 = new_PublicKey__HandlePtr();
                err = SKY_bip32_DeserializeEncodedPublicKey(expected, key3);
                assertEquals(SKY_OK, err);
                assertEquals(isPublicKeyEq(key2, key3), 1);
        }

        private void testVectorKeyPairs(testMasterKey vector) {
                // Decode master seed into hex
                GoSlice seed = new GoSlice();
                _GoString_ tmpSeed = new_GoStringPtr();
                tmpSeed.setP(vector.seed);
                tmpSeed.setN(vector.seed.length());
                long err = SKY_base58_String2Hex(tmpSeed, seed);
                assertEquals(SKY_OK, err);

                // Generate a master private and public key
                SWIGTYPE_p_PrivateKey__Handle privkey = new_PrivateKey__HandlePtr();
                err = SKY_bip32_NewMasterKey(seed, privkey);
                assertEquals(SKY_OK, err);
                SWIGTYPE_p_PublicKey__Handle pubkey = new_PublicKey__HandlePtr();
                err = SKY_bip32_PrivateKey_Publickey(privkey, pubkey);
                assertEquals(SKY_OK, err);

                SWIGTYPE_p_unsigned_char depthPrivKey = new_GoUint8Ptr();
                SWIGTYPE_p_unsigned_char depthPubKey = new_GoUint8Ptr();
                err = SKY_bip32_PrivateKey_GetDepth(privkey, depthPrivKey);
                assertEquals(SKY_OK, err);
                assertEquals(0, GoUint8Ptr_value(depthPrivKey));
                err = SKY_bip32_PublicKey_GetDepth(pubkey, depthPubKey);
                assertEquals(SKY_OK, err);
                assertEquals(0, GoUint8Ptr_value(depthPubKey));

                SWIGTYPE_p_unsigned_int childnumberPrivKey = new_GoUint32Ptr();
                SWIGTYPE_p_unsigned_int childnumberPubKey = new_GoUint32Ptr();

                err = SKY_bip32_PrivateKey_ChildNumber(privkey, childnumberPrivKey);
                assertEquals(SKY_OK, err);
                assertEquals(0, GoUint32Ptr_value(childnumberPrivKey));
                err = SKY_bip32_PublicKey_ChildNumber(pubkey, childnumberPubKey);
                assertEquals(SKY_OK, err);
                assertEquals(0, GoUint32Ptr_value(childnumberPubKey));

                _GoString_ stringPrivKey = new _GoString_();
                _GoString_ stringPubKey = new _GoString_();

                err = SKY_bip32_PrivateKey_String(privkey, stringPrivKey);
                assertEquals(SKY_OK, err);
                assertEquals(stringPrivKey.getP(), vector.privkey);
                err = SKY_bip32_PublicKey_String(pubkey, stringPubKey);
                assertEquals(SKY_OK, err);
                assertEquals(stringPubKey.getP(), vector.pubKey);

                _GoString_ hexPubKey = new _GoString_();
                GoSlice slicepubkey = new GoSlice();
                err = SKY_bip32_PublicKey_GetKey(pubkey, slicepubkey);
                assertEquals(SKY_OK, err);
                err = SKY_base58_Hex2String(slicepubkey, hexPubKey);
                assertEquals(SKY_OK, err);
                assertEquals(hexPubKey.getP(), vector.hexPubKey);

                cipher_SecKey tempSec = new cipher_SecKey();
                GoSlice sliceprivkey = new GoSlice();
                err = SKY_bip32_PrivateKey_GetKey(privkey, sliceprivkey);
                assertEquals(SKY_OK, err);
                err = SKY_cipher_NewSecKey(sliceprivkey, tempSec);
                assertEquals(SKY_OK, err);
                _GoString_ wif = new _GoString_();
                SKY_cipher_BitcoinWalletImportFormatFromSeckey(tempSec, wif);
                assertEquals(wif.getP(), vector.wifPrivKey);

                GoSlice privChainCode = new GoSlice();
                GoSlice pubChainCode = new GoSlice();
                err = SKY_bip32_PrivateKey_GetChainCode(privkey, privChainCode);
                assertEquals(SKY_OK, err);
                err = SKY_bip32_PublicKey_GetChainCode(pubkey, pubChainCode);
                assertEquals(SKY_OK, err);
                _GoString_ priv_ChainCode = new _GoString_();
                _GoString_ pub_ChainCode = new _GoString_();
                err = SKY_base58_Hex2String(privChainCode, priv_ChainCode);
                assertEquals(SKY_OK, err);
                assertEquals(priv_ChainCode.getP(), vector.chainCode);
                err = SKY_base58_Hex2String(pubChainCode, pub_ChainCode);
                assertEquals(SKY_OK, err);
                assertEquals(pub_ChainCode.getP(), vector.chainCode);

                GoSlice privFringerprint = new GoSlice();
                GoSlice pubFringerprint = new GoSlice();
                _GoString_ priv_Fringerprint = new _GoString_();
                _GoString_ pub_Fringerprint = new _GoString_();
                err = SKY_bip32_PrivateKey_Fingerprint(privkey, privFringerprint);
                assertEquals(SKY_OK, err);
                err = SKY_bip32_PublicKey_Fingerprint(pubkey, pubFringerprint);
                assertEquals(SKY_OK, err);

                err = SKY_base58_Hex2String(privFringerprint, priv_Fringerprint);
                assertEquals(SKY_OK, err);
                err = SKY_base58_Hex2String(pubFringerprint, pub_Fringerprint);
                assertEquals(SKY_OK, err);
                assertEquals(priv_Fringerprint.getP(), vector.fingerprint);
                assertEquals(pub_Fringerprint.getP(), vector.fingerprint);

                GoSlice privIdentifier = new GoSlice();
                GoSlice pubIdentifier = new GoSlice();

                _GoString_ priv_Identifier = new _GoString_();
                _GoString_ pub_Identifier = new _GoString_();
                err = SKY_bip32_PrivateKey_Identifier(privkey, privIdentifier);
                assertEquals(SKY_OK, err);
                err = SKY_bip32_PublicKey_Identifier(pubkey, pubIdentifier);
                assertEquals(SKY_OK, err);
                err = SKY_base58_Hex2String(privIdentifier, priv_Identifier);
                assertEquals(SKY_OK, err);
                err = SKY_base58_Hex2String(pubIdentifier, pub_Identifier);
                assertEquals(SKY_OK, err);
                assertEquals(priv_Identifier.getP(), vector.identifier);
                assertEquals(pub_Identifier.getP(), vector.identifier);

                SWIGTYPE_p_unsigned_char privDepth = new_GoUint8Ptr();
                SWIGTYPE_p_unsigned_char pubDepth = new_GoUint8Ptr();

                err = SKY_bip32_PrivateKey_GetDepth(privkey, privDepth);
                assertEquals(SKY_OK, err);
                err = SKY_bip32_PublicKey_GetDepth(pubkey, pubDepth);
                assertEquals(SKY_OK, err);
                assertEquals(vector.depth, GoUint8Ptr_value(privDepth));
                assertEquals(vector.depth, GoUint8Ptr_value(pubDepth));

                SWIGTYPE_p_unsigned_int privchildNumber = new_GoUint32Ptr();
                SWIGTYPE_p_unsigned_int pubchildNumber = new_GoUint32Ptr();
                err = SKY_bip32_PrivateKey_ChildNumber(privkey, privchildNumber);
                assertEquals(SKY_OK, err);
                err = SKY_bip32_PublicKey_ChildNumber(pubkey, pubchildNumber);
                assertEquals(SKY_OK, err);
                assertEquals(vector.childNUmber, GoUint32Ptr_value(privchildNumber));
                assertEquals(vector.childNUmber, GoUint32Ptr_value(pubchildNumber));

                // Serialize and deserialize both keys and ensure they're the same
                assertPrivateKeySerialization(privkey, vector.privkey);
                assertPublicKeySerialization(pubkey, vector.pubKey);

                GoSlice b58pk = new GoSlice();
                _GoString_ vector_privKey = new_GoStringPtr();
                vector_privKey.setP(vector.privkey);
                vector_privKey.setN(vector.privkey.length());
                err = SKY_base58_Decode(vector_privKey, b58pk);
                assertEquals(SKY_OK, err);
                SWIGTYPE_p_PrivateKey__Handle privKey2 = new_PrivateKey__HandlePtr();
                err = SKY_bip32_DeserializePrivateKey(b58pk, privKey2);
                assertEquals(SKY_OK, err);
                assertEquals(isPrivateKeyEq(privkey, privKey2), 1);

                // Test that DeserializeEncodedPrivateKey
                // is equivalent to DeserializePrivateKey(base58.Decode(key))
                SWIGTYPE_p_PrivateKey__Handle privKey3 = new_PrivateKey__HandlePtr();
                err = SKY_bip32_DeserializeEncodedPrivateKey(vector_privKey, privKey3);
                assertEquals(SKY_OK, err);
                assertEquals(isPrivateKeyEq(privKey2, privKey3), 1);

                // Iterate over the entire child chain and test the given keys
                for (int i = 0; i < vector.depthNumber; i++) {
                        System.out.println("Depth " + i);
                        testChildKey tck = vector.children[i];
                        privkey = new_PrivateKey__HandlePtr();
                        _GoString_ tck_path = new_GoStringPtr();
                        tck_path.setP(tck.path);
                        tck_path.setN(tck.path.length());
                        err = SKY_bip32_NewPrivateKeyFromPath(seed, tck_path, privkey);
                        assertEquals(SKY_OK, err);

                        // Get this private key's public key
                        pubkey = new_PublicKey__HandlePtr();
                        err = SKY_bip32_PrivateKey_Publickey(privkey, pubkey);
                        assertEquals(SKY_OK, err);

                        // Test DeserializePrivateKey
                        GoSlice ppk = new GoSlice();
                        _GoString_ tck_privkey = new _GoString_();
                        tck_privkey.setP(tck.privKey);
                        tck_privkey.setN(tck.privKey.length());
                        err = SKY_base58_Decode(tck_privkey, ppk);
                        assertEquals(SKY_OK, err);
                        SWIGTYPE_p_PrivateKey__Handle xx = new_PrivateKey__HandlePtr();
                        err = SKY_bip32_DeserializePrivateKey(ppk, xx);
                        assertEquals(SKY_OK, err);

                        assertEquals(isPrivateKeyEq(xx, privkey), 1);

                        err = SKY_bip32_PrivateKey_String(privkey, stringPrivKey);
                        assertEquals(err, SKY_OK);
                        assertEquals(stringPrivKey.getP(), tck.privKey);
                        err = SKY_bip32_PublicKey_String(pubkey, stringPubKey);
                        assertEquals(err, SKY_OK);
                        assertEquals(stringPubKey.getP(), tck.pubKey);

                        err = SKY_bip32_PrivateKey_GetChainCode(privkey, privChainCode);
                        assertEquals(SKY_OK, err);
                        err = SKY_bip32_PublicKey_GetChainCode(pubkey, pubChainCode);
                        assertEquals(SKY_OK, err);
                        err = SKY_base58_Hex2String(privChainCode, priv_ChainCode);
                        assertEquals(SKY_OK, err);
                        assertEquals(priv_ChainCode.getP(), tck.chainCode);
                        err = SKY_base58_Hex2String(pubChainCode, pub_ChainCode);
                        assertEquals(SKY_OK, err);
                        assertEquals(pub_ChainCode.getP(), tck.chainCode);

                        privFringerprint = new GoSlice();
                        err = SKY_bip32_PrivateKey_Fingerprint(privkey, privFringerprint);
                        assertEquals(SKY_OK, err);
                        pubFringerprint = new GoSlice();
                        err = SKY_bip32_PublicKey_Fingerprint(pubkey, pubFringerprint);
                        assertEquals(SKY_OK, err);
                        err = SKY_base58_Hex2String(privFringerprint, priv_Fringerprint);
                        assertEquals(SKY_OK, err);
                        err = SKY_base58_Hex2String(pubFringerprint, pub_Fringerprint);
                        assertEquals(SKY_OK, err);
                        assertEquals(pub_Fringerprint.getP(), tck.fingerprint);
                        assertEquals(pub_Fringerprint.getP(), tck.fingerprint);

                        err = SKY_bip32_PrivateKey_Identifier(privkey, privIdentifier);
                        assertEquals(SKY_OK, err);
                        err = SKY_bip32_PublicKey_Identifier(pubkey, pubIdentifier);
                        assertEquals(SKY_OK, err);
                        err = SKY_base58_Hex2String(privIdentifier, priv_Identifier);
                        assertEquals(SKY_OK, err);
                        err = SKY_base58_Hex2String(pubIdentifier, pub_Identifier);
                        assertEquals(SKY_OK, err);
                        assertEquals(priv_Identifier.getP(), tck.identifier);
                        assertEquals(pub_Identifier.getP(), tck.identifier);

                        err = SKY_bip32_PrivateKey_GetDepth(privkey, privDepth);
                        assertEquals(SKY_OK, err);
                        err = SKY_bip32_PublicKey_GetDepth(pubkey, pubDepth);
                        assertEquals(SKY_OK, err);
                        assertEquals(tck.depth, GoUint8Ptr_value(privDepth));
                        assertEquals(tck.depth, GoUint8Ptr_value(pubDepth));

                        err = SKY_bip32_PrivateKey_ChildNumber(privkey, privchildNumber);
                        assertEquals(SKY_OK, err);
                        err = SKY_bip32_PublicKey_ChildNumber(pubkey, pubchildNumber);
                        assertEquals(SKY_OK, err);
                        assertEquals(tck.childNUmber, GoUint32Ptr_value(privchildNumber));
                        assertEquals(tck.childNUmber, GoUint32Ptr_value(pubchildNumber));

                        // Serialize and deserialize both keys and ensure they're the same
                        assertPrivateKeySerialization(privkey, tck.privKey);
                        assertPublicKeySerialization(pubkey, tck.pubKey);
                }
        }

        @Test
        public void TestBip32TestVectors() {

                testMasterKey vector1 = new testMasterKey();
                vector1.seed = "000102030405060708090a0b0c0d0e0f";
                vector1.privkey = "xprv9s21ZrQH143K3QTDL4LXw2F7HEK3wJUD2nW2nRk4stbPy6cq3jPPqjiChkVvvNKmPGJxWUtg6LnF5kejMRNNU3TGtRBeJgk33yuGBxrMPHi";
                vector1.pubKey = "xpub661MyMwAqRbcFtXgS5sYJABqqG9YLmC4Q1Rdap9gSE8NqtwybGhePY2gZ29ESFjqJoCu1Rupje8YtGqsefD265TMg7usUDFdp6W1EGMcet8";
                vector1.hexPubKey = "0339a36013301597daef41fbe593a02cc513d0b55527ec2df1050e2e8ff49c85c2";
                vector1.wifPrivKey = "L52XzL2cMkHxqxBXRyEpnPQZGUs3uKiL3R11XbAdHigRzDozKZeW";
                vector1.fingerprint = "3442193e";
                vector1.identifier = "3442193e1bb70916e914552172cd4e2dbc9df811";
                vector1.chainCode = "873dff81c02f525623fd1fe5167eac3a55a049de3d314bb42ee227ffed37d508";
                vector1.childNUmber = 0;
                vector1.depth = 0;
                vector1.children = new testChildKey[5];
                vector1.depthNumber = 5;

                // 0
                testChildKey children = new testChildKey();
                children.path = "m/0'";
                children.privKey = "xprv9uHRZZhk6KAJC1avXpDAp4MDc3sQKNxDiPvvkX8Br5ngLNv1TxvUxt4cV1rGL5hj6KCesnDYUhd7oWgT11eZG7XnxHrnYeSvkzY7d2bhkJ7";
                children.pubKey = "xpub68Gmy5EdvgibQVfPdqkBBCHxA5htiqg55crXYuXoQRKfDBFA1WEjWgP6LHhwBZeNK1VTsfTFUHCdrfp1bgwQ9xv5ski8PX9rL2dZXvgGDnw";
                children.fingerprint = "5c1bd648";
                children.identifier = "5c1bd648ed23aa5fd50ba52b2457c11e9e80a6a7";
                children.chainCode = "47fdacbd0f1097043b78c63c20c34ef4ed9a111d980047ad16282c7ae6236141";
                children.hexPubKey = "035a784662a4a20a65bf6aab9ae98a6c068a81c52e4b032c0fb5400c706cfccc56";
                children.wifPrivKey = "L5BmPijJjrKbiUfG4zbiFKNqkvuJ8usooJmzuD7Z8dkRoTThYnAT";
                children.childNUmber = (2147483648L);
                children.depth = 1;
                vector1.children[0] = children;

                // 1
                children = new testChildKey();
                children.path = "m/0'/1";
                children.privKey = "xprv9wTYmMFdV23N2TdNG573QoEsfRrWKQgWeibmLntzniatZvR9BmLnvSxqu53Kw1UmYPxLgboyZQaXwTCg8MSY3H2EU4pWcQDnRnrVA1xe8fs";
                children.pubKey = "xpub6ASuArnXKPbfEwhqN6e3mwBcDTgzisQN1wXN9BJcM47sSikHjJf3UFHKkNAWbWMiGj7Wf5uMash7SyYq527Hqck2AxYysAA7xmALppuCkwQ";
                children.fingerprint = "bef5a2f9";
                children.identifier = "bef5a2f9a56a94aab12459f72ad9cf8cf19c7bbe";
                children.chainCode = "2a7857631386ba23dacac34180dd1983734e444fdbf774041578e9b6adb37c19";
                children.hexPubKey = "03501e454bf00751f24b1b489aa925215d66af2234e3891c3b21a52bedb3cd711c";
                children.wifPrivKey = "KyFAjQ5rgrKvhXvNMtFB5PCSKUYD1yyPEe3xr3T34TZSUHycXtMM";
                children.depth = 2;
                children.childNUmber = 1;
                vector1.children[1] = children;

                // 2
                children = new testChildKey();
                children.path = "m/0'/1/2'";
                children.privKey = "xprv9z4pot5VBttmtdRTWfWQmoH1taj2axGVzFqSb8C9xaxKymcFzXBDptWmT7FwuEzG3ryjH4ktypQSAewRiNMjANTtpgP4mLTj34bhnZX7UiM";
                children.pubKey = "xpub6D4BDPcP2GT577Vvch3R8wDkScZWzQzMMUm3PWbmWvVJrZwQY4VUNgqFJPMM3No2dFDFGTsxxpG5uJh7n7epu4trkrX7x7DogT5Uv6fcLW5";
                children.fingerprint = "ee7ab90c";
                children.identifier = "ee7ab90cde56a8c0e2bb086ac49748b8db9dce72";
                children.chainCode = "04466b9cc8e161e966409ca52986c584f07e9dc81f735db683c3ff6ec7b1503f";
                children.hexPubKey = "0357bfe1e341d01c69fe5654309956cbea516822fba8a601743a012a7896ee8dc2";
                children.wifPrivKey = "L43t3od1Gh7Lj55Bzjj1xDAgJDcL7YFo2nEcNaMGiyRZS1CidBVU";
                children.childNUmber = 2 + (long)(FirstHardenedChild);
                children.depth = 3;
                vector1.children[2] = children;

                // 3
                children = new testChildKey();
                children.path = "m/0'/1/2'/2";
                children.privKey = "xprvA2JDeKCSNNZky6uBCviVfJSKyQ1mDYahRjijr5idH2WwLsEd4Hsb2Tyh8RfQMuPh7f7RtyzTtdrbdqqsunu5Mm3wDvUAKRHSC34sJ7in334";
                children.pubKey = "xpub6FHa3pjLCk84BayeJxFW2SP4XRrFd1JYnxeLeU8EqN3vDfZmbqBqaGJAyiLjTAwm6ZLRQUMv1ZACTj37sR62cfN7fe5JnJ7dh8zL4fiyLHV";
                children.fingerprint = "d880d7d8";
                children.identifier = "d880d7d893848509a62d8fb74e32148dac68412f";
                children.chainCode = "cfb71883f01676f587d023cc53a35bc7f88f724b1f8c2892ac1275ac822a3edd";
                children.hexPubKey = "02e8445082a72f29b75ca48748a914df60622a609cacfce8ed0e35804560741d29";
                children.wifPrivKey = "KwjQsVuMjbCP2Zmr3VaFaStav7NvevwjvvkqrWd5Qmh1XVnCteBR";
                children.childNUmber = 2;
                children.depth = 4;
                vector1.children[3] = children;

                // 4
                children = new testChildKey();
                children.path = "m/0'/1/2'/2/1000000000";
                children.privKey = "xprvA41z7zogVVwxVSgdKUHDy1SKmdb533PjDz7J6N6mV6uS3ze1ai8FHa8kmHScGpWmj4WggLyQjgPie1rFSruoUihUZREPSL39UNdE3BBDu76";
                children.pubKey = "xpub6H1LXWLaKsWFhvm6RVpEL9P4KfRZSW7abD2ttkWP3SSQvnyA8FSVqNTEcYFgJS2UaFcxupHiYkro49S8yGasTvXEYBVPamhGW6cFJodrTHy";
                children.fingerprint = "d69aa102";
                children.identifier = "d69aa102255fed74378278c7812701ea641fdf32";
                children.chainCode = "c783e67b921d2beb8f6b389cc646d7263b4145701dadd2161548a8b078e65e9e";
                children.hexPubKey = "022a471424da5e657499d1ff51cb43c47481a03b1e77f951fe64cec9f5a48f7011";
                children.wifPrivKey = "Kybw8izYevo5xMh1TK7aUr7jHFCxXS1zv8p3oqFz3o2zFbhRXHYs";
                children.childNUmber = 1000000000;
                children.depth = 5;
                vector1.children[4] = children;

                // vector 2
                testMasterKey vector2 = new testMasterKey();
                vector2.seed = "fffcf9f6f3f0edeae7e4e1dedbd8d5d2cfccc9c6c3c0bdbab7b4b1aeaba8a5a29f9c999693908d8a8784817e7b7875726f6c696663605d5a5754514e4b484542";
                vector2.privkey = "xprv9s21ZrQH143K31xYSDQpPDxsXRTUcvj2iNHm5NUtrGiGG5e2DtALGdso3pGz6ssrdK4PFmM8NSpSBHNqPqm55Qn3LqFtT2emdEXVYsCzC2U";
                vector2.pubKey = "xpub661MyMwAqRbcFW31YEwpkMuc5THy2PSt5bDMsktWQcFF8syAmRUapSCGu8ED9W6oDMSgv6Zz8idoc4a6mr8BDzTJY47LJhkJ8UB7WEGuduB";
                vector2.hexPubKey = "03cbcaa9c98c877a26977d00825c956a238e8dddfbd322cce4f74b0b5bd6ace4a7";
                vector2.wifPrivKey = "KyjXhyHF9wTphBkfpxjL8hkDXDUSbE3tKANT94kXSyh6vn6nKaoy";
                vector2.fingerprint = "bd16bee5";
                vector2.identifier = "bd16bee53961a47d6ad888e29545434a89bdfe95";
                vector2.chainCode = "60499f801b896d83179a4374aeb7822aaeaceaa0db1f85ee3e904c4defbd9689";
                vector2.childNUmber = 0;
                vector2.depth = 0;
                vector2.children = new testChildKey[5];
                vector2.depthNumber = 5;
                // 0
                children = new testChildKey();
                children.path = "m/0";
                children.privKey = "xprv9vHkqa6EV4sPZHYqZznhT2NPtPCjKuDKGY38FBWLvgaDx45zo9WQRUT3dKYnjwih2yJD9mkrocEZXo1ex8G81dwSM1fwqWpWkeS3v86pgKt";
                children.pubKey = "xpub69H7F5d8KSRgmmdJg2KhpAK8SR3DjMwAdkxj3ZuxV27CprR9LgpeyGmXUbC6wb7ERfvrnKZjXoUmmDznezpbZb7ap6r1D3tgFxHmwMkQTPH";
                children.fingerprint = "5a61ff8e";
                children.identifier = "5a61ff8eb7aaca3010db97ebda76121610b78096";
                children.chainCode = "f0909affaa7ee7abe5dd4e100598d4dc53cd709d5a5c2cac40e7412f232f7c9c";
                children.hexPubKey = "02fc9e5af0ac8d9b3cecfe2a888e2117ba3d089d8585886c9c826b6b22a98d12ea";
                children.wifPrivKey = "L2ysLrR6KMSAtx7uPqmYpoTeiRzydXBattRXjXz5GDFPrdfPzKbj";
                children.childNUmber = 0;
                children.depth = 1;
                vector2.children[0] = children;
                // 1
                children = new testChildKey();
                children.path = "m/0/2147483647'";
                children.privKey = "xprv9wSp6B7kry3Vj9m1zSnLvN3xH8RdsPP1Mh7fAaR7aRLcQMKTR2vidYEeEg2mUCTAwCd6vnxVrcjfy2kRgVsFawNzmjuHc2YmYRmagcEPdU9";
                children.pubKey = "xpub6ASAVgeehLbnwdqV6UKMHVzgqAG8Gr6riv3Fxxpj8ksbH9ebxaEyBLZ85ySDhKiLDBrQSARLq1uNRts8RuJiHjaDMBU4Zn9h8LZNnBC5y4a";
                children.fingerprint = "d8ab4937";
                children.identifier = "d8ab493736da02f11ed682f88339e720fb0379d1";
                children.chainCode = "be17a268474a6bb9c61e1d720cf6215e2a88c5406c4aee7b38547f585c9a37d9";
                children.hexPubKey = "03c01e7425647bdefa82b12d9bad5e3e6865bee0502694b94ca58b666abc0a5c3b";
                children.wifPrivKey = "L1m5VpbXmMp57P3knskwhoMTLdhAAaXiHvnGLMribbfwzVRpz2Sr";
                children.childNUmber = 2147483647 + FirstHardenedChild;
                children.depth = 2;
                vector2.children[1] = children;
                // 2
                children = new testChildKey();
                children.path = "m/0/2147483647'/1";
                children.privKey = "xprv9zFnWC6h2cLgpmSA46vutJzBcfJ8yaJGg8cX1e5StJh45BBciYTRXSd25UEPVuesF9yog62tGAQtHjXajPPdbRCHuWS6T8XA2ECKADdw4Ef";
                children.pubKey = "xpub6DF8uhdarytz3FWdA8TvFSvvAh8dP3283MY7p2V4SeE2wyWmG5mg5EwVvmdMVCQcoNJxGoWaU9DCWh89LojfZ537wTfunKau47EL2dhHKon";
                children.fingerprint = "78412e3a";
                children.identifier = "78412e3a2296a40de124307b6485bd19833e2e34";
                children.chainCode = "f366f48f1ea9f2d1d3fe958c95ca84ea18e4c4ddb9366c336c927eb246fb38cb";
                children.hexPubKey = "03a7d1d856deb74c508e05031f9895dab54626251b3806e16b4bd12e781a7df5b9";
                children.wifPrivKey = "KzyzXnznxSv249b4KuNkBwowaN3akiNeEHy5FWoPCJpStZbEKXN2";
                children.childNUmber = 1;
                children.depth = 3;
                vector2.children[2] = children;
                // 3
                children = new testChildKey();
                children.path = "m/0/2147483647'/1/2147483646'";
                children.privKey = "xprvA1RpRA33e1JQ7ifknakTFpgNXPmW2YvmhqLQYMmrj4xJXXWYpDPS3xz7iAxn8L39njGVyuoseXzU6rcxFLJ8HFsTjSyQbLYnMpCqE2VbFWc";
                children.pubKey = "xpub6ERApfZwUNrhLCkDtcHTcxd75RbzS1ed54G1LkBUHQVHQKqhMkhgbmJbZRkrgZw4koxb5JaHWkY4ALHY2grBGRjaDMzQLcgJvLJuZZvRcEL";
                children.fingerprint = "31a507b8";
                children.identifier = "31a507b815593dfc51ffc7245ae7e5aee304246e";
                children.chainCode = "637807030d55d01f9a0cb3a7839515d796bd07706386a6eddf06cc29a65a0e29";
                children.hexPubKey = "02d2b36900396c9282fa14628566582f206a5dd0bcc8d5e892611806cafb0301f0";
                children.wifPrivKey = "L5KhaMvPYRW1ZoFmRjUtxxPypQ94m6BcDrPhqArhggdaTbbAFJEF";
                children.childNUmber = 2147483646 + FirstHardenedChild;
                children.depth = 4;
                vector2.children[3] = children;
                // 4
                children = new testChildKey();
                children.path = "m/0/2147483647'/1/2147483646'/2";
                children.privKey = "xprvA2nrNbFZABcdryreWet9Ea4LvTJcGsqrMzxHx98MMrotbir7yrKCEXw7nadnHM8Dq38EGfSh6dqA9QWTyefMLEcBYJUuekgW4BYPJcr9E7j";
                children.pubKey = "xpub6FnCn6nSzZAw5Tw7cgR9bi15UV96gLZhjDstkXXxvCLsUXBGXPdSnLFbdpq8p9HmGsApME5hQTZ3emM2rnY5agb9rXpVGyy3bdW6EEgAtqt";
                children.fingerprint = "26132fdb";
                children.identifier = "26132fdbe7bf89cbc64cf8dafa3f9f88b8666220";
                children.chainCode = "9452b549be8cea3ecb7a84bec10dcfd94afe4d129ebfd3b3cb58eedf394ed271";
                children.hexPubKey = "024d902e1a2fc7a8755ab5b694c575fce742c48d9ff192e63df5193e4c7afe1f9c";
                children.wifPrivKey = "L3WAYNAZPxx1fr7KCz7GN9nD5qMBnNiqEJNJMU1z9MMaannAt4aK";
                children.childNUmber = 2;
                children.depth = 5;
                vector2.children[4] = children;

                // Vector 3
                testMasterKey vector3 = new testMasterKey();
                vector3.seed = "4b381541583be4423346c643850da4b320e46a87ae3d2a4e6da11eba819cd4acba45d239319ac14f863b8d5ab5a0d0c64d2e8a1e7d1457df2e5a3c51c73235be";
                vector3.privkey = "xprv9s21ZrQH143K25QhxbucbDDuQ4naNntJRi4KUfWT7xo4EKsHt2QJDu7KXp1A3u7Bi1j8ph3EGsZ9Xvz9dGuVrtHHs7pXeTzjuxBrCmmhgC6";
                vector3.pubKey = "xpub661MyMwAqRbcEZVB4dScxMAdx6d4nFc9nvyvH3v4gJL378CSRZiYmhRoP7mBy6gSPSCYk6SzXPTf3ND1cZAceL7SfJ1Z3GC8vBgp2epUt13";
                vector3.hexPubKey = "03683af1ba5743bdfc798cf814efeeab2735ec52d95eced528e692b8e34c4e5669";
                vector3.wifPrivKey = "KwFPqAq9SKx1sPg15Qk56mqkHwrfGPuywtLUxoWPkiTSBoxCs8am";
                vector3.fingerprint = "41d63b50";
                vector3.identifier = "41d63b50d8dd5e730cdf4c79a56fc929a757c548";
                vector3.chainCode = "01d28a3e53cffa419ec122c968b3259e16b65076495494d97cae10bbfec3c36f";
                vector3.childNUmber = 0;
                vector3.depth = 0;
                vector3.children = new testChildKey[1];
                vector3.depthNumber = 1;
                // 0
                children = new testChildKey();
                children.path = "m/0'";
                children.privKey = "xprv9uPDJpEQgRQfDcW7BkF7eTya6RPxXeJCqCJGHuCJ4GiRVLzkTXBAJMu2qaMWPrS7AANYqdq6vcBcBUdJCVVFceUvJFjaPdGZ2y9WACViL4L";
                children.pubKey = "xpub68NZiKmJWnxxS6aaHmn81bvJeTESw724CRDs6HbuccFQN9Ku14VQrADWgqbhhTHBaohPX4CjNLf9fq9MYo6oDaPPLPxSb7gwQN3ih19Zm4Y";
                children.fingerprint = "c61368bb";
                children.identifier = "c61368bb50e066acd95bd04a0b23d3837fb75698";
                children.chainCode = "e5fea12a97b927fc9dc3d2cb0d1ea1cf50aa5a1fdc1f933e8906bb38df3377bd";
                children.hexPubKey = "027c3591221e28939e45f8ea297d62c3640ebb09d7058b01d09c963d984a40ad49";
                children.wifPrivKey = "L3z3MSqZtDQ1FPHKi7oWf1nc9rMEGFtZUDCoFa7n4F695g5qZiSu";
                children.childNUmber = FirstHardenedChild;
                children.depth = 1;
                vector3.children[0] = children;

                testMasterKey vector4 = new testMasterKey();
                vector4.seed = "d13de7bd1e54422d1a3b3b699a27fb460de2849e7e66a005c647e8e4a54075cb";
                vector4.privkey = "xprv9s21ZrQH143K3zWpEJm5QtHFh93eNJrNbNqzqLN5XoE9MvC7gs5TmBFaL2PpaXpDc8FBYVe5EChc73ApjSQ5fWsXS7auHy1MmG6hdpywE1q";
                vector4.pubKey = "xpub661MyMwAqRbcGUbHLLJ5n2DzFAt8mmaDxbmbdimh68m8EiXGEQPiJya4BJat5yMzy4e68VSUoLGCu5uvzf8dUoGvwuJsLE6F1cibmWsxFNn";
                vector4.hexPubKey = "0298ccc720d5dea817c7077605263bae52bca083cf8888fee77ff4c1b4797ee180";
                vector4.wifPrivKey = "KwDiCU5bs8xQwsRgxjhkcJcVuR7NE4Mei8X9uSAVviVTE7JmMoS6";
                vector4.fingerprint = "1a87677b";
                vector4.identifier = "1a87677be6f73cc9655e8b4c5d2fd0aeeb1b23c7";
                vector4.chainCode = "c23ab32b36ddff49fae350a1bed8ec6b4d9fc252238dd789b7273ba4416054eb";
                vector4.childNUmber = 0;
                vector4.depth = 0;
                vector4.children = new testChildKey[1];
                vector4.depthNumber = 1;
                // 0
                children = new testChildKey();
                children.path = "m/44'/0'/0'/0/0'";
                children.privKey = "xprvA3cqPFaMpr7n1wRh6BPtYfwdYRoKCaPzgDdQnUmgMrz1WxWNEW3EmbBr9ieh9BJAsRGKFPLvotb4p4Aq79jddUVKPVJt7exVzLHcv777JVf";
                children.pubKey = "xpub6GcBnm7FfDg5ERWACCvtuotN6Tdoc37r3SZ1asBHvCWzPkqWn3MVKPWKzy6GsfmdMUGanR3D12dH1cp5tJauuubwc4FAJDn67SH2uUjwAT1";
                children.fingerprint = "e371d69b";
                children.identifier = "e371d69b5dae6eacee832a130ee9f55545275a09";
                children.chainCode = "ca27553aa89617e982e621637d6478f564b32738f8bbe2e48d0a58a8e0f6da40";
                children.hexPubKey = "027c3591221e28939e45f8ea297d62c3640ebb09d7058b01d09c963d984a40ad49";
                children.wifPrivKey = "L3z3MSqZtDQ1FPHKi7oWf1nc9rMEGFtZUDCoFa7n4F695g5qZiSu";
                children.childNUmber = FirstHardenedChild;
                children.depth = 5;
                vector4.children[0] = children;

                System.out.println("Vector1");
                testVectorKeyPairs(vector1);
                System.out.println("Vector2");
                testVectorKeyPairs(vector2);
                System.out.println("Vector3");
                testVectorKeyPairs(vector3);
                System.out.println("Vector4");
                testVectorKeyPairs(vector4);
        }

}
