package org.openapitools.client.api;

import org.openapitools.client.ApiClient;
import org.openapitools.client.model.Address;
import org.openapitools.client.model.BlockSchema;
import org.openapitools.client.model.InlineResponse200;
import org.openapitools.client.model.InlineResponse2001;
import org.openapitools.client.model.InlineResponse20010;
import org.openapitools.client.model.InlineResponse2002;
import org.openapitools.client.model.InlineResponse2003;
import org.openapitools.client.model.InlineResponse2004;
import org.openapitools.client.model.InlineResponse2005;
import org.openapitools.client.model.InlineResponse2006;
import org.openapitools.client.model.InlineResponse2007;
import org.openapitools.client.model.InlineResponse2008;
import org.openapitools.client.model.InlineResponse2009;
import org.openapitools.client.model.InlineResponseDefault;
import org.openapitools.client.model.NetworkConnectionSchema;
import org.openapitools.client.model.Transaction;
import org.openapitools.client.model.TransactionV2ParamsAddress;
import org.openapitools.client.model.TransactionV2ParamsUnspent;
import org.openapitools.client.model.TransactionVerifyRequest;
import org.openapitools.client.model.WalletTransactionRequest;
import org.openapitools.client.model.WalletTransactionSignRequest;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for DefaultApi
 */
public class DefaultApiTest {

    private DefaultApi api;

    @Before
    public void setup() {
        api = new ApiClient().buildClient(DefaultApi.class);
    }

    
    /**
     * Returns the total number of unique address that have coins.
     *
     * 
     */
    @Test
    public void addressCountTest() {
        // InlineResponse200 response = api.addressCount();

        // TODO: test validations
    }

    
    /**
     * 
     *
     * Returns the historical, spent outputs associated with an address
     */
    @Test
    public void addressUxoutsTest() {
        String address = null;
        // List<Object> response = api.addressUxouts(address);

        // TODO: test validations
    }

    /**
     * 
     *
     * Returns the historical, spent outputs associated with an address
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void addressUxoutsTestQueryMap() {
        DefaultApi.AddressUxoutsQueryParams queryParams = new DefaultApi.AddressUxoutsQueryParams()
            .address(null);
        // List<Object> response = api.addressUxouts(queryParams);

    // TODO: test validations
    }
    
    /**
     * 
     *
     * 
     */
    @Test
    public void apiV1RawtxGetTest() {
        // String response = api.apiV1RawtxGet();

        // TODO: test validations
    }

    
    /**
     * 
     *
     * 
     */
    @Test
    public void apiV2MetricsGetTest() {
        // String response = api.apiV2MetricsGet();

        // TODO: test validations
    }

    
    /**
     * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
     *
     * 
     */
    @Test
    public void balanceGetTest() {
        String addrs = null;
        // Object response = api.balanceGet(addrs);

        // TODO: test validations
    }

    /**
     * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
     *
     * 
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void balanceGetTestQueryMap() {
        DefaultApi.BalanceGetQueryParams queryParams = new DefaultApi.BalanceGetQueryParams()
            .addrs(null);
        // Object response = api.balanceGet(queryParams);

    // TODO: test validations
    }
    
    /**
     * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
     *
     * 
     */
    @Test
    public void balancePostTest() {
        String addrs = null;
        // Object response = api.balancePost(addrs);

        // TODO: test validations
    }

    /**
     * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
     *
     * 
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void balancePostTestQueryMap() {
        DefaultApi.BalancePostQueryParams queryParams = new DefaultApi.BalancePostQueryParams()
            .addrs(null);
        // Object response = api.balancePost(queryParams);

    // TODO: test validations
    }
    
    /**
     * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
     *
     * 
     */
    @Test
    public void blockTest() {
        String hash = null;
        Integer seq = null;
        // List<BlockSchema> response = api.block(hash, seq);

        // TODO: test validations
    }

    /**
     * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
     *
     * 
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void blockTestQueryMap() {
        DefaultApi.BlockQueryParams queryParams = new DefaultApi.BlockQueryParams()
            .hash(null)
            .seq(null);
        // List<BlockSchema> response = api.block(queryParams);

    // TODO: test validations
    }
    
    /**
     * Returns the blockchain metadata.
     *
     * 
     */
    @Test
    public void blockchainMetadataTest() {
        // Object response = api.blockchainMetadata();

        // TODO: test validations
    }

    
    /**
     * Returns the blockchain sync progress.
     *
     * 
     */
    @Test
    public void blockchainProgressTest() {
        // Object response = api.blockchainProgress();

        // TODO: test validations
    }

    
    /**
     * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
     *
     * 
     */
    @Test
    public void blocksTest() {
        Integer start = null;
        Integer end = null;
        List<Integer> seq = null;
        // InlineResponse2001 response = api.blocks(start, end, seq);

        // TODO: test validations
    }

    /**
     * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
     *
     * 
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void blocksTestQueryMap() {
        DefaultApi.BlocksQueryParams queryParams = new DefaultApi.BlocksQueryParams()
            .start(null)
            .end(null)
            .seq(null);
        // InlineResponse2001 response = api.blocks(queryParams);

    // TODO: test validations
    }
    
    /**
     * 
     *
     * coinSupplyHandler returns coin distribution supply stats
     */
    @Test
    public void coinSupplyTest() {
        // InlineResponse2002 response = api.coinSupply();

        // TODO: test validations
    }

    
    /**
     * Creates a new CSRF token. Previous CSRF tokens are invalidated by this call.
     *
     * 
     */
    @Test
    public void csrfTest() {
        // InlineResponse2003 response = api.csrf();

        // TODO: test validations
    }

    
    /**
     * 
     *
     * 
     */
    @Test
    public void dataDELETETest() {
        String type = null;
        String key = null;
        // api.dataDELETE(type, key);

        // TODO: test validations
    }

    
    /**
     * 
     *
     * 
     */
    @Test
    public void dataGETTest() {
        String type = null;
        String key = null;
        // Object response = api.dataGET(type, key);

        // TODO: test validations
    }

    
    /**
     * 
     *
     * 
     */
    @Test
    public void dataPOSTTest() {
        String type = null;
        String key = null;
        String val = null;
        // api.dataPOST(type, key, val);

        // TODO: test validations
    }

    
    /**
     * defaultConnectionsHandler returns the list of default hardcoded bootstrap addresses.\\n They are not necessarily connected to.
     *
     * 
     */
    @Test
    public void defaultConnectionsTest() {
        // List<String> response = api.defaultConnections();

        // TODO: test validations
    }

    
    /**
     * Returns node health data.
     *
     * 
     */
    @Test
    public void healthTest() {
        // Object response = api.health();

        // TODO: test validations
    }

    
    /**
     * 
     *
     * Returns the most recent N blocks on the blockchain
     */
    @Test
    public void lastBlocksTest() {
        Integer num = null;
        // Object response = api.lastBlocks(num);

        // TODO: test validations
    }

    /**
     * 
     *
     * Returns the most recent N blocks on the blockchain
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void lastBlocksTestQueryMap() {
        DefaultApi.LastBlocksQueryParams queryParams = new DefaultApi.LastBlocksQueryParams()
            .num(null);
        // Object response = api.lastBlocks(queryParams);

    // TODO: test validations
    }
    
    /**
     * This endpoint returns a specific connection.
     *
     * 
     */
    @Test
    public void networkConnectionTest() {
        String addr = null;
        // NetworkConnectionSchema response = api.networkConnection(addr);

        // TODO: test validations
    }

    /**
     * This endpoint returns a specific connection.
     *
     * 
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void networkConnectionTestQueryMap() {
        DefaultApi.NetworkConnectionQueryParams queryParams = new DefaultApi.NetworkConnectionQueryParams()
            .addr(null);
        // NetworkConnectionSchema response = api.networkConnection(queryParams);

    // TODO: test validations
    }
    
    /**
     * This endpoint returns all outgoings connections.
     *
     * 
     */
    @Test
    public void networkConnectionsTest() {
        String states = null;
        String direction = null;
        // InlineResponse2004 response = api.networkConnections(states, direction);

        // TODO: test validations
    }

    /**
     * This endpoint returns all outgoings connections.
     *
     * 
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void networkConnectionsTestQueryMap() {
        DefaultApi.NetworkConnectionsQueryParams queryParams = new DefaultApi.NetworkConnectionsQueryParams()
            .states(null)
            .direction(null);
        // InlineResponse2004 response = api.networkConnections(queryParams);

    // TODO: test validations
    }
    
    /**
     * 
     *
     * This endpoint disconnects a connection by ID or address
     */
    @Test
    public void networkConnectionsDisconnectTest() {
        String id = null;
        // api.networkConnectionsDisconnect(id);

        // TODO: test validations
    }

    /**
     * 
     *
     * This endpoint disconnects a connection by ID or address
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void networkConnectionsDisconnectTestQueryMap() {
        DefaultApi.NetworkConnectionsDisconnectQueryParams queryParams = new DefaultApi.NetworkConnectionsDisconnectQueryParams()
            .id(null);
        // api.networkConnectionsDisconnect(queryParams);

    // TODO: test validations
    }
    
    /**
     * 
     *
     * This endpoint returns all connections found through peer exchange
     */
    @Test
    public void networkConnectionsExchangeTest() {
        // List<String> response = api.networkConnectionsExchange();

        // TODO: test validations
    }

    
    /**
     * trustConnectionsHandler returns all trusted connections.\\n They are not necessarily connected to. In the default configuration, these will be a subset of the default hardcoded bootstrap addresses.
     *
     * 
     */
    @Test
    public void networkConnectionsTrustTest() {
        // List<String> response = api.networkConnectionsTrust();

        // TODO: test validations
    }

    
    /**
     * If neither addrs nor hashes are specificed, return all unspent outputs. If only one filter is specified, then return outputs match the filter. Both filters cannot be specified.
     *
     * 
     */
    @Test
    public void outputsGetTest() {
        List<String> address = null;
        List<String> hash = null;
        // Object response = api.outputsGet(address, hash);

        // TODO: test validations
    }

    /**
     * If neither addrs nor hashes are specificed, return all unspent outputs. If only one filter is specified, then return outputs match the filter. Both filters cannot be specified.
     *
     * 
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void outputsGetTestQueryMap() {
        DefaultApi.OutputsGetQueryParams queryParams = new DefaultApi.OutputsGetQueryParams()
            .address(null)
            .hash(null);
        // Object response = api.outputsGet(queryParams);

    // TODO: test validations
    }
    
    /**
     * If neither addrs nor hashes are specificed, return all unspent outputs. If only one filter is specified, then return outputs match the filter. Both filters cannot be specified.
     *
     * 
     */
    @Test
    public void outputsPostTest() {
        String address = null;
        String hash = null;
        // Object response = api.outputsPost(address, hash);

        // TODO: test validations
    }

    /**
     * If neither addrs nor hashes are specificed, return all unspent outputs. If only one filter is specified, then return outputs match the filter. Both filters cannot be specified.
     *
     * 
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void outputsPostTestQueryMap() {
        DefaultApi.OutputsPostQueryParams queryParams = new DefaultApi.OutputsPostQueryParams()
            .address(null)
            .hash(null);
        // Object response = api.outputsPost(queryParams);

    // TODO: test validations
    }
    
    /**
     * 
     *
     * 
     */
    @Test
    public void pendingTxsTest() {
        // List<InlineResponse20010> response = api.pendingTxs();

        // TODO: test validations
    }

    
    /**
     * 
     *
     * Broadcasts all unconfirmed transactions from the unconfirmed transaction pool
     */
    @Test
    public void resendUnconfirmedTxnsTest() {
        // Object response = api.resendUnconfirmedTxns();

        // TODO: test validations
    }

    
    /**
     * Returns the top skycoin holders.
     *
     * 
     */
    @Test
    public void richlistTest() {
        Boolean includeDistribution = null;
        String n = null;
        // Object response = api.richlist(includeDistribution, n);

        // TODO: test validations
    }

    /**
     * Returns the top skycoin holders.
     *
     * 
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void richlistTestQueryMap() {
        DefaultApi.RichlistQueryParams queryParams = new DefaultApi.RichlistQueryParams()
            .includeDistribution(null)
            .n(null);
        // Object response = api.richlist(queryParams);

    // TODO: test validations
    }
    
    /**
     * 
     *
     * Returns a transaction identified by its txid hash with just id
     */
    @Test
    public void transactionTest() {
        String txid = null;
        // Transaction response = api.transaction(txid);

        // TODO: test validations
    }

    /**
     * 
     *
     * Returns a transaction identified by its txid hash with just id
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void transactionTestQueryMap() {
        DefaultApi.TransactionQueryParams queryParams = new DefaultApi.TransactionQueryParams()
            .txid(null);
        // Transaction response = api.transaction(queryParams);

    // TODO: test validations
    }
    
    /**
     * Broadcast a hex-encoded, serialized transaction to the network.
     *
     * 
     */
    @Test
    public void transactionInjectTest() {
        String rawtx = null;
        Boolean noBroadcast = null;
        // String response = api.transactionInject(rawtx, noBroadcast);

        // TODO: test validations
    }

    
    /**
     * 
     *
     * 
     */
    @Test
    public void transactionPostTest() {
        TransactionV2ParamsAddress transactionV2ParamsAddress = null;
        // InlineResponse2008 response = api.transactionPost(transactionV2ParamsAddress);

        // TODO: test validations
    }

    
    /**
     * 
     *
     * 
     */
    @Test
    public void transactionPostUnspentTest() {
        TransactionV2ParamsUnspent transactionV2ParamsUnspent = null;
        // InlineResponse2008 response = api.transactionPostUnspent(transactionV2ParamsUnspent);

        // TODO: test validations
    }

    
    /**
     * Returns the hex-encoded byte serialization of a transaction. The transaction may be confirmed or unconfirmed.
     *
     * 
     */
    @Test
    public void transactionRawTest() {
        String txid = null;
        // Object response = api.transactionRaw(txid);

        // TODO: test validations
    }

    /**
     * Returns the hex-encoded byte serialization of a transaction. The transaction may be confirmed or unconfirmed.
     *
     * 
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void transactionRawTestQueryMap() {
        DefaultApi.TransactionRawQueryParams queryParams = new DefaultApi.TransactionRawQueryParams()
            .txid(null);
        // Object response = api.transactionRaw(queryParams);

    // TODO: test validations
    }
    
    /**
     * 
     *
     * Decode and verify an encoded transaction
     */
    @Test
    public void transactionVerifyTest() {
        TransactionVerifyRequest transactionVerifyRequest = null;
        // Object response = api.transactionVerify(transactionVerifyRequest);

        // TODO: test validations
    }

    
    /**
     * Returns transactions that match the filters.
     *
     * 
     */
    @Test
    public void transactionsGetTest() {
        String addrs = null;
        String confirmed = null;
        // Object response = api.transactionsGet(addrs, confirmed);

        // TODO: test validations
    }

    /**
     * Returns transactions that match the filters.
     *
     * 
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void transactionsGetTestQueryMap() {
        DefaultApi.TransactionsGetQueryParams queryParams = new DefaultApi.TransactionsGetQueryParams()
            .addrs(null)
            .confirmed(null);
        // Object response = api.transactionsGet(queryParams);

    // TODO: test validations
    }
    
    /**
     * Returns transactions that match the filters.
     *
     * 
     */
    @Test
    public void transactionsPostTest() {
        String addrs = null;
        String confirmed = null;
        // Object response = api.transactionsPost(addrs, confirmed);

        // TODO: test validations
    }

    /**
     * Returns transactions that match the filters.
     *
     * 
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void transactionsPostTestQueryMap() {
        DefaultApi.TransactionsPostQueryParams queryParams = new DefaultApi.TransactionsPostQueryParams()
            .addrs(null)
            .confirmed(null);
        // Object response = api.transactionsPost(queryParams);

    // TODO: test validations
    }
    
    /**
     * Returns an unspent output by ID.
     *
     * 
     */
    @Test
    public void uxoutTest() {
        String uxid = null;
        // Object response = api.uxout(uxid);

        // TODO: test validations
    }

    /**
     * Returns an unspent output by ID.
     *
     * 
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void uxoutTestQueryMap() {
        DefaultApi.UxoutQueryParams queryParams = new DefaultApi.UxoutQueryParams()
            .uxid(null);
        // Object response = api.uxout(queryParams);

    // TODO: test validations
    }
    
    /**
     * Verifies a Skycoin address.
     *
     * 
     */
    @Test
    public void verifyAddressTest() {
        Address address = null;
        // Object response = api.verifyAddress(address);

        // TODO: test validations
    }

    /**
     * Verifies a Skycoin address.
     *
     * 
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void verifyAddressTestQueryMap() {
        DefaultApi.VerifyAddressQueryParams queryParams = new DefaultApi.VerifyAddressQueryParams()
            .address(null);
        // Object response = api.verifyAddress(queryParams);

    // TODO: test validations
    }
    
    /**
     * 
     *
     * versionHandler returns the application version info
     */
    @Test
    public void versionTest() {
        // InlineResponse2005 response = api.version();

        // TODO: test validations
    }

    
    /**
     * Returns a wallet by id.
     *
     * 
     */
    @Test
    public void walletTest() {
        String id = null;
        // Object response = api.wallet(id);

        // TODO: test validations
    }

    /**
     * Returns a wallet by id.
     *
     * 
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void walletTestQueryMap() {
        DefaultApi.WalletQueryParams queryParams = new DefaultApi.WalletQueryParams()
            .id(null);
        // Object response = api.wallet(queryParams);

    // TODO: test validations
    }
    
    /**
     * Returns the wallet&#39;s balance, both confirmed and predicted.  The predicted balance is the confirmed balance minus the pending spends.
     *
     * 
     */
    @Test
    public void walletBalanceTest() {
        String id = null;
        // Object response = api.walletBalance(id);

        // TODO: test validations
    }

    /**
     * Returns the wallet&#39;s balance, both confirmed and predicted.  The predicted balance is the confirmed balance minus the pending spends.
     *
     * 
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void walletBalanceTestQueryMap() {
        DefaultApi.WalletBalanceQueryParams queryParams = new DefaultApi.WalletBalanceQueryParams()
            .id(null);
        // Object response = api.walletBalance(queryParams);

    // TODO: test validations
    }
    
    /**
     * 
     *
     * Create a wallet
     */
    @Test
    public void walletCreateTest() {
        String type = null;
        String seed = null;
        String label = null;
        String seedPassphrase = null;
        String bip44Coin = null;
        String xpub = null;
        Integer scan = null;
        Boolean encrypt = null;
        String password = null;
        // Object response = api.walletCreate(type, seed, label, seedPassphrase, bip44Coin, xpub, scan, encrypt, password);

        // TODO: test validations
    }

    
    /**
     * Decrypts wallet.
     *
     * 
     */
    @Test
    public void walletDecryptTest() {
        String id = null;
        String password = null;
        // Object response = api.walletDecrypt(id, password);

        // TODO: test validations
    }

    
    /**
     * Encrypt wallet.
     *
     * 
     */
    @Test
    public void walletEncryptTest() {
        String id = null;
        String password = null;
        // Object response = api.walletEncrypt(id, password);

        // TODO: test validations
    }

    
    /**
     * 
     *
     * Returns the wallet directory path
     */
    @Test
    public void walletFolderTest() {
        String addr = null;
        // InlineResponse2007 response = api.walletFolder(addr);

        // TODO: test validations
    }

    /**
     * 
     *
     * Returns the wallet directory path
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void walletFolderTestQueryMap() {
        DefaultApi.WalletFolderQueryParams queryParams = new DefaultApi.WalletFolderQueryParams()
            .addr(null);
        // InlineResponse2007 response = api.walletFolder(queryParams);

    // TODO: test validations
    }
    
    /**
     * 
     *
     * Generates new addresses
     */
    @Test
    public void walletNewAddressTest() {
        String id = null;
        String num = null;
        String password = null;
        // Object response = api.walletNewAddress(id, num, password);

        // TODO: test validations
    }

    /**
     * 
     *
     * Generates new addresses
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void walletNewAddressTestQueryMap() {
        DefaultApi.WalletNewAddressQueryParams queryParams = new DefaultApi.WalletNewAddressQueryParams()
            .id(null)
            .num(null)
            .password(null);
        // Object response = api.walletNewAddress(queryParams);

    // TODO: test validations
    }
    
    /**
     * 
     *
     * Returns the wallet directory path
     */
    @Test
    public void walletNewSeedTest() {
        String entropy = null;
        // Object response = api.walletNewSeed(entropy);

        // TODO: test validations
    }

    /**
     * 
     *
     * Returns the wallet directory path
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void walletNewSeedTestQueryMap() {
        DefaultApi.WalletNewSeedQueryParams queryParams = new DefaultApi.WalletNewSeedQueryParams()
            .entropy(null);
        // Object response = api.walletNewSeed(queryParams);

    // TODO: test validations
    }
    
    /**
     * Recovers an encrypted wallet by providing the seed. The first address will be generated from seed and compared to the first address of the specified wallet. If they match, the wallet will be regenerated with an optional password. If the wallet is not encrypted, an error is returned.
     *
     * Recovers an encrypted wallet by providing the wallet seed and optional seed passphrase
     */
    @Test
    public void walletRecoverTest() {
        String id = null;
        String seed = null;
        String seedPassphrase = null;
        String password = null;
        // Object response = api.walletRecover(id, seed, seedPassphrase, password);

        // TODO: test validations
    }

    
    /**
     * This endpoint only works for encrypted wallets. If the wallet is unencrypted, The seed will be not returned.
     *
     * 
     */
    @Test
    public void walletSeedTest() {
        String id = null;
        String password = null;
        // Object response = api.walletSeed(id, password);

        // TODO: test validations
    }

    /**
     * This endpoint only works for encrypted wallets. If the wallet is unencrypted, The seed will be not returned.
     *
     * 
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void walletSeedTestQueryMap() {
        DefaultApi.WalletSeedQueryParams queryParams = new DefaultApi.WalletSeedQueryParams()
            .id(null)
            .password(null);
        // Object response = api.walletSeed(queryParams);

    // TODO: test validations
    }
    
    /**
     * Verifies a wallet seed.
     *
     * 
     */
    @Test
    public void walletSeedVerifyTest() {
        String seed = null;
        // Object response = api.walletSeedVerify(seed);

        // TODO: test validations
    }

    
    /**
     * Creates a signed transaction
     *
     * 
     */
    @Test
    public void walletTransactionTest() {
        WalletTransactionRequest walletTransactionRequest = null;
        // Object response = api.walletTransaction(walletTransactionRequest);

        // TODO: test validations
    }

    
    /**
     * Creates a signed transaction
     *
     * 
     */
    @Test
    public void walletTransactionSignTest() {
        WalletTransactionSignRequest walletTransactionSignRequest = null;
        // InlineResponse2009 response = api.walletTransactionSign(walletTransactionSignRequest);

        // TODO: test validations
    }

    
    /**
     * 
     *
     * 
     */
    @Test
    public void walletTransactionsTest() {
        String id = null;
        // InlineResponse2006 response = api.walletTransactions(id);

        // TODO: test validations
    }

    /**
     * 
     *
     * 
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void walletTransactionsTestQueryMap() {
        DefaultApi.WalletTransactionsQueryParams queryParams = new DefaultApi.WalletTransactionsQueryParams()
            .id(null);
        // InlineResponse2006 response = api.walletTransactions(queryParams);

    // TODO: test validations
    }
    
    /**
     * Unloads wallet from the wallet service.
     *
     * 
     */
    @Test
    public void walletUnloadTest() {
        String id = null;
        // api.walletUnload(id);

        // TODO: test validations
    }

    /**
     * Unloads wallet from the wallet service.
     *
     * 
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void walletUnloadTestQueryMap() {
        DefaultApi.WalletUnloadQueryParams queryParams = new DefaultApi.WalletUnloadQueryParams()
            .id(null);
        // api.walletUnload(queryParams);

    // TODO: test validations
    }
    
    /**
     * Update the wallet.
     *
     * 
     */
    @Test
    public void walletUpdateTest() {
        String id = null;
        String label = null;
        // String response = api.walletUpdate(id, label);

        // TODO: test validations
    }

    
    /**
     * 
     *
     * Returns all loaded wallets
     */
    @Test
    public void walletsTest() {
        // List<Object> response = api.wallets();

        // TODO: test validations
    }

    
}
