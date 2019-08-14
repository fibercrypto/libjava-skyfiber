package org.openapitools.client.api;

import org.openapitools.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface DefaultApi {
  /**
   * Returns the total number of unique address that have coins.
   * 
   * @return Call&lt;InlineResponse200&gt;
   */
  @GET("api/v1/addresscount")
  Call<InlineResponse200> addressCount();
    

  /**
   * 
   * Returns the historical, spent outputs associated with an address
   * @param address address to filter by (required)
   * @return Call&lt;List&lt;Object&gt;&gt;
   */
  @GET("api/v1/address_uxouts")
  Call<List<Object>> addressUxouts(
    @retrofit2.http.Query("address") String address
  );

  /**
   * 
   * 
   * @return Call&lt;String&gt;
   */
  @GET("api/v1/rawtx")
  Call<String> apiV1RawtxGet();
    

  /**
   * 
   * 
   * @return Call&lt;String&gt;
   */
  @GET("api/v2/metrics")
  Call<String> apiV2MetricsGet();
    

  /**
   * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
   * 
   * @param addrs command separated list of addresses (required)
   * @return Call&lt;Object&gt;
   */
  @GET("api/v1/balance")
  Call<Object> balanceGet(
    @retrofit2.http.Query("addrs") String addrs
  );

  /**
   * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
   * 
   * @param addrs command separated list of addresses (required)
   * @return Call&lt;Object&gt;
   */
  @POST("api/v1/balance")
  Call<Object> balancePost(
    @retrofit2.http.Query("addrs") String addrs
  );

  /**
   * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
   * 
   * @param hash get block by hash (optional)
   * @param seq get block by sequence number (optional)
   * @return Call&lt;List&lt;BlockSchema&gt;&gt;
   */
  @GET("api/v1/block")
  Call<List<BlockSchema>> block(
    @retrofit2.http.Query("hash") String hash, @retrofit2.http.Query("seq") Integer seq
  );

  /**
   * Returns the blockchain metadata.
   * 
   * @return Call&lt;Object&gt;
   */
  @GET("api/v1/blockchain/metadata")
  Call<Object> blockchainMetadata();
    

  /**
   * Returns the blockchain sync progress.
   * 
   * @return Call&lt;Object&gt;
   */
  @GET("api/v1/blockchain/progress")
  Call<Object> blockchainProgress();
    

  /**
   * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
   * 
   * @param start start seq (optional)
   * @param end end seq (optional)
   * @param seq comma-separated list of block seqs (optional, default to new ArrayList&lt;Integer&gt;())
   * @return Call&lt;InlineResponse2001&gt;
   */
  @GET("api/v1/blocks")
  Call<InlineResponse2001> blocks(
    @retrofit2.http.Query("start") Integer start, @retrofit2.http.Query("end") Integer end, @retrofit2.http.Query("seq") List<Integer> seq
  );

  /**
   * 
   * coinSupplyHandler returns coin distribution supply stats
   * @return Call&lt;InlineResponse2002&gt;
   */
  @GET("api/v1/coinSupply")
  Call<InlineResponse2002> coinSupply();
    

  /**
   * Creates a new CSRF token. Previous CSRF tokens are invalidated by this call.
   * 
   * @return Call&lt;InlineResponse2003&gt;
   */
  @GET("api/v1/csrf")
  Call<InlineResponse2003> csrf();
    

  /**
   * 
   * 
   * @param type storage type. (optional)
   * @param key key of the specific value to get. (optional)
   * @return Call&lt;Void&gt;
   */
  @DELETE("api/v2/data")
  Call<Void> dataDELETE(
    @retrofit2.http.Header("type") String type, @retrofit2.http.Header("key") String key
  );

  /**
   * 
   * 
   * @param type storage type. (optional)
   * @param key key of the specific value to get. (optional)
   * @return Call&lt;Object&gt;
   */
  @GET("api/v2/data")
  Call<Object> dataGET(
    @retrofit2.http.Header("type") String type, @retrofit2.http.Header("key") String key
  );

  /**
   * 
   * 
   * @param type storage type. (optional)
   * @param key key of the specific value to get. (optional)
   * @param val additional value. (optional)
   * @return Call&lt;Void&gt;
   */
  @POST("api/v2/data")
  Call<Void> dataPOST(
    @retrofit2.http.Header("type") String type, @retrofit2.http.Header("key") String key, @retrofit2.http.Header("val") String val
  );

  /**
   * defaultConnectionsHandler returns the list of default hardcoded bootstrap addresses.\\n They are not necessarily connected to.
   * 
   * @return Call&lt;List&lt;String&gt;&gt;
   */
  @GET("api/v1/network/defaultConnections")
  Call<List<String>> defaultConnections();
    

  /**
   * Returns node health data.
   * 
   * @return Call&lt;Object&gt;
   */
  @GET("api/v1/health")
  Call<Object> health();
    

  /**
   * 
   * Returns the most recent N blocks on the blockchain
   * @param num Num of blockss (required)
   * @return Call&lt;Object&gt;
   */
  @GET("api/v1/last_blocks")
  Call<Object> lastBlocks(
    @retrofit2.http.Query("num") Integer num
  );

  /**
   * This endpoint returns a specific connection.
   * 
   * @param addr Address port (required)
   * @return Call&lt;NetworkConnectionSchema&gt;
   */
  @GET("api/v1/network/connection")
  Call<NetworkConnectionSchema> networkConnection(
    @retrofit2.http.Query("addr") String addr
  );

  /**
   * This endpoint returns all outgoings connections.
   * 
   * @param states Connection status. (optional)
   * @param direction Direction of the connection. (optional)
   * @return Call&lt;InlineResponse2004&gt;
   */
  @GET("api/v1/network/connections")
  Call<InlineResponse2004> networkConnections(
    @retrofit2.http.Query("states") String states, @retrofit2.http.Query("direction") String direction
  );

  /**
   * 
   * This endpoint disconnects a connection by ID or address
   * @param id Address id. (required)
   * @return Call&lt;Void&gt;
   */
  @POST("api/v1/network/connection/disconnect")
  Call<Void> networkConnectionsDisconnect(
    @retrofit2.http.Query("id") String id
  );

  /**
   * 
   * This endpoint returns all connections found through peer exchange
   * @return Call&lt;List&lt;String&gt;&gt;
   */
  @GET("api/v1/network/connections/exchange")
  Call<List<String>> networkConnectionsExchange();
    

  /**
   * trustConnectionsHandler returns all trusted connections.\\n They are not necessarily connected to. In the default configuration, these will be a subset of the default hardcoded bootstrap addresses.
   * 
   * @return Call&lt;List&lt;String&gt;&gt;
   */
  @GET("api/v1/network/connections/trust")
  Call<List<String>> networkConnectionsTrust();
    

  /**
   * If neither addrs nor hashes are specificed, return all unspent outputs. If only one filter is specified, then return outputs match the filter. Both filters cannot be specified.
   * 
   * @param address  (optional, default to new ArrayList&lt;String&gt;())
   * @param hash  (optional, default to new ArrayList&lt;String&gt;())
   * @return Call&lt;Object&gt;
   */
  @GET("api/v1/outputs")
  Call<Object> outputsGet(
    @retrofit2.http.Query("address") List<String> address, @retrofit2.http.Query("hash") List<String> hash
  );

  /**
   * If neither addrs nor hashes are specificed, return all unspent outputs. If only one filter is specified, then return outputs match the filter. Both filters cannot be specified.
   * 
   * @param address  (optional)
   * @param hash  (optional)
   * @return Call&lt;Object&gt;
   */
  @POST("api/v1/outputs")
  Call<Object> outputsPost(
    @retrofit2.http.Query("address") String address, @retrofit2.http.Query("hash") String hash
  );

  /**
   * 
   * 
   * @return Call&lt;List&lt;InlineResponse20010&gt;&gt;
   */
  @GET("api/v1/pendingTxs")
  Call<List<InlineResponse20010>> pendingTxs();
    

  /**
   * 
   * Broadcasts all unconfirmed transactions from the unconfirmed transaction pool
   * @return Call&lt;Object&gt;
   */
  @POST("api/v1/resendUnconfirmedTxns")
  Call<Object> resendUnconfirmedTxns();
    

  /**
   * Returns the top skycoin holders.
   * 
   * @param includeDistribution include distribution addresses or not, default value false (optional)
   * @param n include distribution addresses or not, default value false (optional)
   * @return Call&lt;Object&gt;
   */
  @GET("api/v1/richlist")
  Call<Object> richlist(
    @retrofit2.http.Query("include-distribution") Boolean includeDistribution, @retrofit2.http.Query("n") String n
  );

  /**
   * 
   * Returns a transaction identified by its txid hash with just id
   * @param txid transaction Id (required)
   * @return Call&lt;Transaction&gt;
   */
  @GET("api/v1/transaction")
  Call<Transaction> transaction(
    @retrofit2.http.Query("txid") String txid
  );

  /**
   * Broadcast a hex-encoded, serialized transaction to the network.
   * 
   * @param rawtx hex-encoded serialized transaction string. (required)
   * @param noBroadcast Disable the network broadcast (optional)
   * @return Call&lt;String&gt;
   */
  @POST("api/v1/injectTransaction")
  Call<String> transactionInject(
    @retrofit2.http.Header("rawtx") String rawtx, @retrofit2.http.Header("no_broadcast") Boolean noBroadcast
  );

  /**
   * 
   * 
   * @param transactionV2ParamsAddress  (optional)
   * @return Call&lt;InlineResponse2008&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/v2/transaction")
  Call<InlineResponse2008> transactionPost(
    @retrofit2.http.Body TransactionV2ParamsAddress transactionV2ParamsAddress
  );

  /**
   * 
   * 
   * @param transactionV2ParamsUnspent Unspent parameters (required)
   * @return Call&lt;InlineResponse2008&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/v2/transaction/unspent")
  Call<InlineResponse2008> transactionPostUnspent(
    @retrofit2.http.Body TransactionV2ParamsUnspent transactionV2ParamsUnspent
  );

  /**
   * Returns the hex-encoded byte serialization of a transaction. The transaction may be confirmed or unconfirmed.
   * 
   * @param txid Transaction id hash (optional)
   * @return Call&lt;Object&gt;
   */
  @GET("api/v2/transaction/raw")
  Call<Object> transactionRaw(
    @retrofit2.http.Query("txid") String txid
  );

  /**
   * 
   * Decode and verify an encoded transaction
   * @param transactionVerifyRequest  (required)
   * @return Call&lt;Object&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/v2/transaction/verify")
  Call<Object> transactionVerify(
    @retrofit2.http.Body TransactionVerifyRequest transactionVerifyRequest
  );

  /**
   * Returns transactions that match the filters.
   * 
   * @param addrs command separated list of addresses (optional)
   * @param confirmed Whether the transactions should be confirmed [optional, must be 0 or 1; if not provided, returns all] (optional)
   * @return Call&lt;Object&gt;
   */
  @GET("api/v1/transactions")
  Call<Object> transactionsGet(
    @retrofit2.http.Query("addrs") String addrs, @retrofit2.http.Query("confirmed") String confirmed
  );

  /**
   * Returns transactions that match the filters.
   * 
   * @param addrs command separated list of addresses (optional)
   * @param confirmed Whether the transactions should be confirmed [optional, must be 0 or 1; if not provided, returns all] (optional)
   * @return Call&lt;Object&gt;
   */
  @POST("api/v1/transactions")
  Call<Object> transactionsPost(
    @retrofit2.http.Query("addrs") String addrs, @retrofit2.http.Query("confirmed") String confirmed
  );

  /**
   * Returns an unspent output by ID.
   * 
   * @param uxid uxid to filter by (optional)
   * @return Call&lt;Object&gt;
   */
  @GET("api/v1/uxout")
  Call<Object> uxout(
    @retrofit2.http.Query("uxid") String uxid
  );

  /**
   * Verifies a Skycoin address.
   * 
   * @param address Address id. (required)
   * @return Call&lt;Object&gt;
   */
  @POST("api/v2/address/verify")
  Call<Object> verifyAddress(
    @retrofit2.http.Query("address") Address address
  );

  /**
   * 
   * versionHandler returns the application version info
   * @return Call&lt;InlineResponse2005&gt;
   */
  @GET("api/v1/version")
  Call<InlineResponse2005> version();
    

  /**
   * Returns a wallet by id.
   * 
   * @param id tags to filter by (required)
   * @return Call&lt;Object&gt;
   */
  @GET("api/v1/wallet")
  Call<Object> wallet(
    @retrofit2.http.Query("id") String id
  );

  /**
   * Returns the wallet&#39;s balance, both confirmed and predicted.  The predicted balance is the confirmed balance minus the pending spends.
   * 
   * @param id tags to filter by (required)
   * @return Call&lt;Object&gt;
   */
  @GET("api/v1/wallet/balance")
  Call<Object> walletBalance(
    @retrofit2.http.Query("id") String id
  );

  /**
   * 
   * Create a wallet
   * @param type wallet seed passphrase [optional, bip44 type wallet only] (required)
   * @param seed Wallet seed. (required)
   * @param label Wallet label. (required)
   * @param seedPassphrase wallet seed passphrase [optional, bip44 type wallet only] (optional)
   * @param bip44Coin BIP44 coin type [optional, defaults to 8000 (skycoin&#39;s coin type), only valid if type is \&quot;bip44\&quot;] (optional)
   * @param xpub xpub key [required for xpub wallets] (optional)
   * @param scan The number of addresses to scan ahead for balances. (optional)
   * @param encrypt Encrypt wallet. (optional)
   * @param password Wallet Password (optional)
   * @return Call&lt;Object&gt;
   */
  @POST("api/v1/wallet/create")
  Call<Object> walletCreate(
    @retrofit2.http.Header("type") String type, @retrofit2.http.Header("seed") String seed, @retrofit2.http.Header("label") String label, @retrofit2.http.Header("seed-passphrase") String seedPassphrase, @retrofit2.http.Header("bip44-coin") String bip44Coin, @retrofit2.http.Header("xpub") String xpub, @retrofit2.http.Header("scan") Integer scan, @retrofit2.http.Header("encrypt") Boolean encrypt, @retrofit2.http.Header("password") String password
  );

  /**
   * Decrypts wallet.
   * 
   * @param id Wallet id. (required)
   * @param password Wallet password. (required)
   * @return Call&lt;Object&gt;
   */
  @POST("api/v1/wallet/decrypt")
  Call<Object> walletDecrypt(
    @retrofit2.http.Header("id") String id, @retrofit2.http.Header("password") String password
  );

  /**
   * Encrypt wallet.
   * 
   * @param id Wallet id. (required)
   * @param password Wallet password. (required)
   * @return Call&lt;Object&gt;
   */
  @POST("api/v1/wallet/encrypt")
  Call<Object> walletEncrypt(
    @retrofit2.http.Header("id") String id, @retrofit2.http.Header("password") String password
  );

  /**
   * 
   * Returns the wallet directory path
   * @param addr Address port (required)
   * @return Call&lt;InlineResponse2007&gt;
   */
  @GET("api/v1/wallets/folderName")
  Call<InlineResponse2007> walletFolder(
    @retrofit2.http.Query("addr") String addr
  );

  /**
   * 
   * Generates new addresses
   * @param id Wallet Id (required)
   * @param num The number you want to generate (optional)
   * @param password Wallet Password (optional)
   * @return Call&lt;Object&gt;
   */
  @POST("api/v1/wallet/newAddress")
  Call<Object> walletNewAddress(
    @retrofit2.http.Query("id") String id, @retrofit2.http.Query("num") String num, @retrofit2.http.Query("password") String password
  );

  /**
   * 
   * Returns the wallet directory path
   * @param entropy Entropy bitSize. (optional)
   * @return Call&lt;Object&gt;
   */
  @GET("api/v1/wallet/newSeed")
  Call<Object> walletNewSeed(
    @retrofit2.http.Query("entropy") String entropy
  );

  /**
   * Recovers an encrypted wallet by providing the seed. The first address will be generated from seed and compared to the first address of the specified wallet. If they match, the wallet will be regenerated with an optional password. If the wallet is not encrypted, an error is returned.
   * Recovers an encrypted wallet by providing the wallet seed and optional seed passphrase
   * @param id Wallet id. (required)
   * @param seed Wallet seed. (required)
   * @param seedPassphrase Wallet seed-passphrase. (optional)
   * @param password Wallet password. (optional)
   * @return Call&lt;Object&gt;
   */
  @POST("api/v2/wallet/recover")
  Call<Object> walletRecover(
    @retrofit2.http.Header("id") String id, @retrofit2.http.Header("seed") String seed, @retrofit2.http.Header("seed-passphrase") String seedPassphrase, @retrofit2.http.Header("password") String password
  );

  /**
   * This endpoint only works for encrypted wallets. If the wallet is unencrypted, The seed will be not returned.
   * 
   * @param id Wallet Id. (required)
   * @param password Wallet password. (required)
   * @return Call&lt;Object&gt;
   */
  @POST("api/v1/wallet/seed")
  Call<Object> walletSeed(
    @retrofit2.http.Query("id") String id, @retrofit2.http.Query("password") String password
  );

  /**
   * Verifies a wallet seed.
   * 
   * @param seed Seed to be verified. (optional)
   * @return Call&lt;Object&gt;
   */
  @POST("api/v2/wallet/seed/verify")
  Call<Object> walletSeedVerify(
    @retrofit2.http.Header("seed") String seed
  );

  /**
   * Creates a signed transaction
   * 
   * @param walletTransactionRequest  (required)
   * @return Call&lt;Object&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/v1/wallet/transaction")
  Call<Object> walletTransaction(
    @retrofit2.http.Body WalletTransactionRequest walletTransactionRequest
  );

  /**
   * Creates a signed transaction
   * 
   * @param walletTransactionSignRequest  (required)
   * @return Call&lt;InlineResponse2009&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/v2/wallet/transaction/sign")
  Call<InlineResponse2009> walletTransactionSign(
    @retrofit2.http.Body WalletTransactionSignRequest walletTransactionSignRequest
  );

  /**
   * 
   * 
   * @param id Wallet Id. (required)
   * @return Call&lt;InlineResponse2006&gt;
   */
  @GET("api/v1/wallet/transactions")
  Call<InlineResponse2006> walletTransactions(
    @retrofit2.http.Query("id") String id
  );

  /**
   * Unloads wallet from the wallet service.
   * 
   * @param id Wallet Id. (required)
   * @return Call&lt;Void&gt;
   */
  @POST("api/v1/wallet/unload")
  Call<Void> walletUnload(
    @retrofit2.http.Query("id") String id
  );

  /**
   * Update the wallet.
   * 
   * @param id Wallet Id. (required)
   * @param label The label the wallet will be updated to. (required)
   * @return Call&lt;String&gt;
   */
  @POST("api/v1/wallet/update")
  Call<String> walletUpdate(
    @retrofit2.http.Header("id") String id, @retrofit2.http.Header("label") String label
  );

  /**
   * 
   * Returns all loaded wallets
   * @return Call&lt;List&lt;Object&gt;&gt;
   */
  @GET("api/v1/wallets")
  Call<List<Object>> wallets();
    

}
