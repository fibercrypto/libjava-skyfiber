package org.openapitools.client.api;

import org.openapitools.client.ApiClient;
import org.openapitools.client.EncodingUtils;

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
import feign.*;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-08-05T23:30:16.371-04:00[America/Havana]")
public interface DefaultApi extends ApiClient.Api {


  /**
   * Returns the total number of unique address that have coins.
   * 
   * @return InlineResponse200
   */
  @RequestLine("GET /api/v1/addresscount")
  @Headers({
    "Accept: application/json",
  })
  InlineResponse200 addressCount();

  /**
   * 
   * Returns the historical, spent outputs associated with an address
   * @param address address to filter by (required)
   * @return List&lt;Object&gt;
   */
  @RequestLine("GET /api/v1/address_uxouts?address={address}")
  @Headers({
    "Accept: application/json",
  })
  List<Object> addressUxouts(@Param("address") String address);

  /**
   * 
   * Returns the historical, spent outputs associated with an address
   * Note, this is equivalent to the other <code>addressUxouts</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link AddressUxoutsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>address - address to filter by (required)</li>
   *   </ul>
   * @return List&lt;Object&gt;
   */
  @RequestLine("GET /api/v1/address_uxouts?address={address}")
  @Headers({
  "Accept: application/json",
  })
  List<Object> addressUxouts(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>addressUxouts</code> method in a fluent style.
   */
  public static class AddressUxoutsQueryParams extends HashMap<String, Object> {
    public AddressUxoutsQueryParams address(final String value) {
      put("address", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @return String
   */
  @RequestLine("GET /api/v1/rawtx")
  @Headers({
    "Accept: text/plain",
  })
  String apiV1RawtxGet();

  /**
   * 
   * 
   * @return String
   */
  @RequestLine("GET /api/v2/metrics")
  @Headers({
    "Accept: text/plain",
  })
  String apiV2MetricsGet();

  /**
   * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
   * 
   * @param addrs command separated list of addresses (required)
   * @return Object
   */
  @RequestLine("GET /api/v1/balance?addrs={addrs}")
  @Headers({
    "Accept: application/json",
  })
  Object balanceGet(@Param("addrs") String addrs);

  /**
   * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
   * 
   * Note, this is equivalent to the other <code>balanceGet</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link BalanceGetQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>addrs - command separated list of addresses (required)</li>
   *   </ul>
   * @return Object
   */
  @RequestLine("GET /api/v1/balance?addrs={addrs}")
  @Headers({
  "Accept: application/json",
  })
  Object balanceGet(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>balanceGet</code> method in a fluent style.
   */
  public static class BalanceGetQueryParams extends HashMap<String, Object> {
    public BalanceGetQueryParams addrs(final String value) {
      put("addrs", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
   * 
   * @param addrs command separated list of addresses (required)
   * @return Object
   */
  @RequestLine("POST /api/v1/balance?addrs={addrs}")
  @Headers({
    "Accept: application/json",
  })
  Object balancePost(@Param("addrs") String addrs);

  /**
   * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
   * 
   * Note, this is equivalent to the other <code>balancePost</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link BalancePostQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>addrs - command separated list of addresses (required)</li>
   *   </ul>
   * @return Object
   */
  @RequestLine("POST /api/v1/balance?addrs={addrs}")
  @Headers({
  "Accept: application/json",
  })
  Object balancePost(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>balancePost</code> method in a fluent style.
   */
  public static class BalancePostQueryParams extends HashMap<String, Object> {
    public BalancePostQueryParams addrs(final String value) {
      put("addrs", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
   * 
   * @param hash get block by hash (optional)
   * @param seq get block by sequence number (optional)
   * @return List&lt;BlockSchema&gt;
   */
  @RequestLine("GET /api/v1/block?hash={hash}&seq={seq}")
  @Headers({
    "Accept: application/json",
  })
  List<BlockSchema> block(@Param("hash") String hash, @Param("seq") Integer seq);

  /**
   * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
   * 
   * Note, this is equivalent to the other <code>block</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link BlockQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>hash - get block by hash (optional)</li>
   *   <li>seq - get block by sequence number (optional)</li>
   *   </ul>
   * @return List&lt;BlockSchema&gt;
   */
  @RequestLine("GET /api/v1/block?hash={hash}&seq={seq}")
  @Headers({
  "Accept: application/json",
  })
  List<BlockSchema> block(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>block</code> method in a fluent style.
   */
  public static class BlockQueryParams extends HashMap<String, Object> {
    public BlockQueryParams hash(final String value) {
      put("hash", EncodingUtils.encode(value));
      return this;
    }
    public BlockQueryParams seq(final Integer value) {
      put("seq", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Returns the blockchain metadata.
   * 
   * @return Object
   */
  @RequestLine("GET /api/v1/blockchain/metadata")
  @Headers({
    "Accept: application/json",
  })
  Object blockchainMetadata();

  /**
   * Returns the blockchain sync progress.
   * 
   * @return Object
   */
  @RequestLine("GET /api/v1/blockchain/progress")
  @Headers({
    "Accept: application/json",
  })
  Object blockchainProgress();

  /**
   * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
   * 
   * @param start start seq (optional)
   * @param end end seq (optional)
   * @param seq comma-separated list of block seqs (optional)
   * @return InlineResponse2001
   */
  @RequestLine("GET /api/v1/blocks?start={start}&end={end}&seq={seq}")
  @Headers({
    "Accept: application/json",
  })
  InlineResponse2001 blocks(@Param("start") Integer start, @Param("end") Integer end, @Param("seq") List<Integer> seq);

  /**
   * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
   * 
   * Note, this is equivalent to the other <code>blocks</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link BlocksQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>start - start seq (optional)</li>
   *   <li>end - end seq (optional)</li>
   *   <li>seq - comma-separated list of block seqs (optional)</li>
   *   </ul>
   * @return InlineResponse2001
   */
  @RequestLine("GET /api/v1/blocks?start={start}&end={end}&seq={seq}")
  @Headers({
  "Accept: application/json",
  })
  InlineResponse2001 blocks(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>blocks</code> method in a fluent style.
   */
  public static class BlocksQueryParams extends HashMap<String, Object> {
    public BlocksQueryParams start(final Integer value) {
      put("start", EncodingUtils.encode(value));
      return this;
    }
    public BlocksQueryParams end(final Integer value) {
      put("end", EncodingUtils.encode(value));
      return this;
    }
    public BlocksQueryParams seq(final List<Integer> value) {
      put("seq", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
  }

  /**
   * 
   * coinSupplyHandler returns coin distribution supply stats
   * @return InlineResponse2002
   */
  @RequestLine("GET /api/v1/coinSupply")
  @Headers({
    "Accept: application/json",
  })
  InlineResponse2002 coinSupply();

  /**
   * Creates a new CSRF token. Previous CSRF tokens are invalidated by this call.
   * 
   * @return InlineResponse2003
   */
  @RequestLine("GET /api/v1/csrf")
  @Headers({
    "Accept: application/json",
  })
  InlineResponse2003 csrf();

  /**
   * 
   * 
   * @param type storage type. (optional)
   * @param key key of the specific value to get. (optional)
   */
  @RequestLine("DELETE /api/v2/data")
  @Headers({
    "Accept: application/json",
    "type: {type}",
    
    "key: {key}"
  })
  void dataDELETE(@Param("type") String type, @Param("key") String key);

  /**
   * 
   * 
   * @param type storage type. (optional)
   * @param key key of the specific value to get. (optional)
   * @return Object
   */
  @RequestLine("GET /api/v2/data")
  @Headers({
    "Accept: application/json",
    "type: {type}",
    
    "key: {key}"
  })
  Object dataGET(@Param("type") String type, @Param("key") String key);

  /**
   * 
   * 
   * @param type storage type. (optional)
   * @param key key of the specific value to get. (optional)
   * @param val additional value. (optional)
   */
  @RequestLine("POST /api/v2/data")
  @Headers({
    "Accept: application/json",
    "type: {type}",
    
    "key: {key}",
    
    "val: {val}"
  })
  void dataPOST(@Param("type") String type, @Param("key") String key, @Param("val") String val);

  /**
   * defaultConnectionsHandler returns the list of default hardcoded bootstrap addresses.\\n They are not necessarily connected to.
   * 
   * @return List&lt;String&gt;
   */
  @RequestLine("GET /api/v1/network/defaultConnections")
  @Headers({
    "Accept: application/json",
  })
  List<String> defaultConnections();

  /**
   * Returns node health data.
   * 
   * @return Object
   */
  @RequestLine("GET /api/v1/health")
  @Headers({
    "Accept: application/json",
  })
  Object health();

  /**
   * 
   * Returns the most recent N blocks on the blockchain
   * @param num Num of blockss (required)
   * @return Object
   */
  @RequestLine("GET /api/v1/last_blocks?num={num}")
  @Headers({
    "Accept: application/json",
  })
  Object lastBlocks(@Param("num") Integer num);

  /**
   * 
   * Returns the most recent N blocks on the blockchain
   * Note, this is equivalent to the other <code>lastBlocks</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link LastBlocksQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>num - Num of blockss (required)</li>
   *   </ul>
   * @return Object
   */
  @RequestLine("GET /api/v1/last_blocks?num={num}")
  @Headers({
  "Accept: application/json",
  })
  Object lastBlocks(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>lastBlocks</code> method in a fluent style.
   */
  public static class LastBlocksQueryParams extends HashMap<String, Object> {
    public LastBlocksQueryParams num(final Integer value) {
      put("num", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * This endpoint returns a specific connection.
   * 
   * @param addr Address port (required)
   * @return NetworkConnectionSchema
   */
  @RequestLine("GET /api/v1/network/connection?addr={addr}")
  @Headers({
    "Accept: application/json",
  })
  NetworkConnectionSchema networkConnection(@Param("addr") String addr);

  /**
   * This endpoint returns a specific connection.
   * 
   * Note, this is equivalent to the other <code>networkConnection</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link NetworkConnectionQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>addr - Address port (required)</li>
   *   </ul>
   * @return NetworkConnectionSchema
   */
  @RequestLine("GET /api/v1/network/connection?addr={addr}")
  @Headers({
  "Accept: application/json",
  })
  NetworkConnectionSchema networkConnection(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>networkConnection</code> method in a fluent style.
   */
  public static class NetworkConnectionQueryParams extends HashMap<String, Object> {
    public NetworkConnectionQueryParams addr(final String value) {
      put("addr", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * This endpoint returns all outgoings connections.
   * 
   * @param states Connection status. (optional)
   * @param direction Direction of the connection. (optional)
   * @return InlineResponse2004
   */
  @RequestLine("GET /api/v1/network/connections?states={states}&direction={direction}")
  @Headers({
    "Accept: application/json",
  })
  InlineResponse2004 networkConnections(@Param("states") String states, @Param("direction") String direction);

  /**
   * This endpoint returns all outgoings connections.
   * 
   * Note, this is equivalent to the other <code>networkConnections</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link NetworkConnectionsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>states - Connection status. (optional)</li>
   *   <li>direction - Direction of the connection. (optional)</li>
   *   </ul>
   * @return InlineResponse2004
   */
  @RequestLine("GET /api/v1/network/connections?states={states}&direction={direction}")
  @Headers({
  "Accept: application/json",
  })
  InlineResponse2004 networkConnections(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>networkConnections</code> method in a fluent style.
   */
  public static class NetworkConnectionsQueryParams extends HashMap<String, Object> {
    public NetworkConnectionsQueryParams states(final String value) {
      put("states", EncodingUtils.encode(value));
      return this;
    }
    public NetworkConnectionsQueryParams direction(final String value) {
      put("direction", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * This endpoint disconnects a connection by ID or address
   * @param id Address id. (required)
   */
  @RequestLine("POST /api/v1/network/connection/disconnect?id={id}")
  @Headers({
    "Accept: application/json",
  })
  void networkConnectionsDisconnect(@Param("id") String id);

  /**
   * 
   * This endpoint disconnects a connection by ID or address
   * Note, this is equivalent to the other <code>networkConnectionsDisconnect</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link NetworkConnectionsDisconnectQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>id - Address id. (required)</li>
   *   </ul>
   */
  @RequestLine("POST /api/v1/network/connection/disconnect?id={id}")
  @Headers({
  "Accept: application/json",
  })
  void networkConnectionsDisconnect(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>networkConnectionsDisconnect</code> method in a fluent style.
   */
  public static class NetworkConnectionsDisconnectQueryParams extends HashMap<String, Object> {
    public NetworkConnectionsDisconnectQueryParams id(final String value) {
      put("id", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * This endpoint returns all connections found through peer exchange
   * @return List&lt;String&gt;
   */
  @RequestLine("GET /api/v1/network/connections/exchange")
  @Headers({
    "Accept: application/json",
  })
  List<String> networkConnectionsExchange();

  /**
   * trustConnectionsHandler returns all trusted connections.\\n They are not necessarily connected to. In the default configuration, these will be a subset of the default hardcoded bootstrap addresses.
   * 
   * @return List&lt;String&gt;
   */
  @RequestLine("GET /api/v1/network/connections/trust")
  @Headers({
    "Accept: application/json",
  })
  List<String> networkConnectionsTrust();

  /**
   * If neither addrs nor hashes are specificed, return all unspent outputs. If only one filter is specified, then return outputs match the filter. Both filters cannot be specified.
   * 
   * @param address  (optional)
   * @param hash  (optional)
   * @return Object
   */
  @RequestLine("GET /api/v1/outputs?address={address}&hash={hash}")
  @Headers({
    "Accept: application/json",
  })
  Object outputsGet(@Param("address") List<String> address, @Param("hash") List<String> hash);

  /**
   * If neither addrs nor hashes are specificed, return all unspent outputs. If only one filter is specified, then return outputs match the filter. Both filters cannot be specified.
   * 
   * Note, this is equivalent to the other <code>outputsGet</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link OutputsGetQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>address -  (optional)</li>
   *   <li>hash -  (optional)</li>
   *   </ul>
   * @return Object
   */
  @RequestLine("GET /api/v1/outputs?address={address}&hash={hash}")
  @Headers({
  "Accept: application/json",
  })
  Object outputsGet(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>outputsGet</code> method in a fluent style.
   */
  public static class OutputsGetQueryParams extends HashMap<String, Object> {
    public OutputsGetQueryParams address(final List<String> value) {
      put("address", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public OutputsGetQueryParams hash(final List<String> value) {
      put("hash", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
  }

  /**
   * If neither addrs nor hashes are specificed, return all unspent outputs. If only one filter is specified, then return outputs match the filter. Both filters cannot be specified.
   * 
   * @param address  (optional)
   * @param hash  (optional)
   * @return Object
   */
  @RequestLine("POST /api/v1/outputs?address={address}&hash={hash}")
  @Headers({
    "Accept: application/json",
  })
  Object outputsPost(@Param("address") String address, @Param("hash") String hash);

  /**
   * If neither addrs nor hashes are specificed, return all unspent outputs. If only one filter is specified, then return outputs match the filter. Both filters cannot be specified.
   * 
   * Note, this is equivalent to the other <code>outputsPost</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link OutputsPostQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>address -  (optional)</li>
   *   <li>hash -  (optional)</li>
   *   </ul>
   * @return Object
   */
  @RequestLine("POST /api/v1/outputs?address={address}&hash={hash}")
  @Headers({
  "Accept: application/json",
  })
  Object outputsPost(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>outputsPost</code> method in a fluent style.
   */
  public static class OutputsPostQueryParams extends HashMap<String, Object> {
    public OutputsPostQueryParams address(final String value) {
      put("address", EncodingUtils.encode(value));
      return this;
    }
    public OutputsPostQueryParams hash(final String value) {
      put("hash", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @return List&lt;InlineResponse20010&gt;
   */
  @RequestLine("GET /api/v1/pendingTxs")
  @Headers({
    "Accept: application/json",
  })
  List<InlineResponse20010> pendingTxs();

  /**
   * 
   * Broadcasts all unconfirmed transactions from the unconfirmed transaction pool
   * @return Object
   */
  @RequestLine("POST /api/v1/resendUnconfirmedTxns")
  @Headers({
    "Accept: application/json",
  })
  Object resendUnconfirmedTxns();

  /**
   * Returns the top skycoin holders.
   * 
   * @param includeDistribution include distribution addresses or not, default value false (optional)
   * @param n include distribution addresses or not, default value false (optional)
   * @return Object
   */
  @RequestLine("GET /api/v1/richlist?include-distribution={includeDistribution}&n={n}")
  @Headers({
    "Accept: application/json",
  })
  Object richlist(@Param("includeDistribution") Boolean includeDistribution, @Param("n") String n);

  /**
   * Returns the top skycoin holders.
   * 
   * Note, this is equivalent to the other <code>richlist</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link RichlistQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>includeDistribution - include distribution addresses or not, default value false (optional)</li>
   *   <li>n - include distribution addresses or not, default value false (optional)</li>
   *   </ul>
   * @return Object
   */
  @RequestLine("GET /api/v1/richlist?include-distribution={includeDistribution}&n={n}")
  @Headers({
  "Accept: application/json",
  })
  Object richlist(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>richlist</code> method in a fluent style.
   */
  public static class RichlistQueryParams extends HashMap<String, Object> {
    public RichlistQueryParams includeDistribution(final Boolean value) {
      put("include-distribution", EncodingUtils.encode(value));
      return this;
    }
    public RichlistQueryParams n(final String value) {
      put("n", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * Returns a transaction identified by its txid hash with just id
   * @param txid transaction Id (required)
   * @return Transaction
   */
  @RequestLine("GET /api/v1/transaction?txid={txid}")
  @Headers({
    "Accept: application/json",
  })
  Transaction transaction(@Param("txid") String txid);

  /**
   * 
   * Returns a transaction identified by its txid hash with just id
   * Note, this is equivalent to the other <code>transaction</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link TransactionQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>txid - transaction Id (required)</li>
   *   </ul>
   * @return Transaction
   */
  @RequestLine("GET /api/v1/transaction?txid={txid}")
  @Headers({
  "Accept: application/json",
  })
  Transaction transaction(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>transaction</code> method in a fluent style.
   */
  public static class TransactionQueryParams extends HashMap<String, Object> {
    public TransactionQueryParams txid(final String value) {
      put("txid", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Broadcast a hex-encoded, serialized transaction to the network.
   * 
   * @param rawtx hex-encoded serialized transaction string. (required)
   * @param noBroadcast Disable the network broadcast (optional)
   * @return String
   */
  @RequestLine("POST /api/v1/injectTransaction")
  @Headers({
    "Accept: application/json",
    "rawtx: {rawtx}",
    
    "no_broadcast: {noBroadcast}"
  })
  String transactionInject(@Param("rawtx") String rawtx, @Param("noBroadcast") Boolean noBroadcast);

  /**
   * 
   * 
   * @param transactionV2ParamsAddress  (optional)
   * @return InlineResponse2008
   */
  @RequestLine("POST /api/v2/transaction")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  InlineResponse2008 transactionPost(TransactionV2ParamsAddress transactionV2ParamsAddress);

  /**
   * 
   * 
   * @param transactionV2ParamsUnspent Unspent parameters (required)
   * @return InlineResponse2008
   */
  @RequestLine("POST /api/v2/transaction/unspent")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  InlineResponse2008 transactionPostUnspent(TransactionV2ParamsUnspent transactionV2ParamsUnspent);

  /**
   * Returns the hex-encoded byte serialization of a transaction. The transaction may be confirmed or unconfirmed.
   * 
   * @param txid Transaction id hash (optional)
   * @return Object
   */
  @RequestLine("GET /api/v2/transaction/raw?txid={txid}")
  @Headers({
    "Accept: application/json",
  })
  Object transactionRaw(@Param("txid") String txid);

  /**
   * Returns the hex-encoded byte serialization of a transaction. The transaction may be confirmed or unconfirmed.
   * 
   * Note, this is equivalent to the other <code>transactionRaw</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link TransactionRawQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>txid - Transaction id hash (optional)</li>
   *   </ul>
   * @return Object
   */
  @RequestLine("GET /api/v2/transaction/raw?txid={txid}")
  @Headers({
  "Accept: application/json",
  })
  Object transactionRaw(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>transactionRaw</code> method in a fluent style.
   */
  public static class TransactionRawQueryParams extends HashMap<String, Object> {
    public TransactionRawQueryParams txid(final String value) {
      put("txid", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * Decode and verify an encoded transaction
   * @param transactionVerifyRequest  (required)
   * @return Object
   */
  @RequestLine("POST /api/v2/transaction/verify")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  Object transactionVerify(TransactionVerifyRequest transactionVerifyRequest);

  /**
   * Returns transactions that match the filters.
   * 
   * @param addrs command separated list of addresses (optional)
   * @param confirmed Whether the transactions should be confirmed [optional, must be 0 or 1; if not provided, returns all] (optional)
   * @return Object
   */
  @RequestLine("GET /api/v1/transactions?addrs={addrs}&confirmed={confirmed}")
  @Headers({
    "Accept: application/json",
  })
  Object transactionsGet(@Param("addrs") String addrs, @Param("confirmed") String confirmed);

  /**
   * Returns transactions that match the filters.
   * 
   * Note, this is equivalent to the other <code>transactionsGet</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link TransactionsGetQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>addrs - command separated list of addresses (optional)</li>
   *   <li>confirmed - Whether the transactions should be confirmed [optional, must be 0 or 1; if not provided, returns all] (optional)</li>
   *   </ul>
   * @return Object
   */
  @RequestLine("GET /api/v1/transactions?addrs={addrs}&confirmed={confirmed}")
  @Headers({
  "Accept: application/json",
  })
  Object transactionsGet(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>transactionsGet</code> method in a fluent style.
   */
  public static class TransactionsGetQueryParams extends HashMap<String, Object> {
    public TransactionsGetQueryParams addrs(final String value) {
      put("addrs", EncodingUtils.encode(value));
      return this;
    }
    public TransactionsGetQueryParams confirmed(final String value) {
      put("confirmed", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Returns transactions that match the filters.
   * 
   * @param addrs command separated list of addresses (optional)
   * @param confirmed Whether the transactions should be confirmed [optional, must be 0 or 1; if not provided, returns all] (optional)
   * @return Object
   */
  @RequestLine("POST /api/v1/transactions?addrs={addrs}&confirmed={confirmed}")
  @Headers({
    "Accept: application/json",
  })
  Object transactionsPost(@Param("addrs") String addrs, @Param("confirmed") String confirmed);

  /**
   * Returns transactions that match the filters.
   * 
   * Note, this is equivalent to the other <code>transactionsPost</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link TransactionsPostQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>addrs - command separated list of addresses (optional)</li>
   *   <li>confirmed - Whether the transactions should be confirmed [optional, must be 0 or 1; if not provided, returns all] (optional)</li>
   *   </ul>
   * @return Object
   */
  @RequestLine("POST /api/v1/transactions?addrs={addrs}&confirmed={confirmed}")
  @Headers({
  "Accept: application/json",
  })
  Object transactionsPost(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>transactionsPost</code> method in a fluent style.
   */
  public static class TransactionsPostQueryParams extends HashMap<String, Object> {
    public TransactionsPostQueryParams addrs(final String value) {
      put("addrs", EncodingUtils.encode(value));
      return this;
    }
    public TransactionsPostQueryParams confirmed(final String value) {
      put("confirmed", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Returns an unspent output by ID.
   * 
   * @param uxid uxid to filter by (optional)
   * @return Object
   */
  @RequestLine("GET /api/v1/uxout?uxid={uxid}")
  @Headers({
    "Accept: application/json",
  })
  Object uxout(@Param("uxid") String uxid);

  /**
   * Returns an unspent output by ID.
   * 
   * Note, this is equivalent to the other <code>uxout</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link UxoutQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>uxid - uxid to filter by (optional)</li>
   *   </ul>
   * @return Object
   */
  @RequestLine("GET /api/v1/uxout?uxid={uxid}")
  @Headers({
  "Accept: application/json",
  })
  Object uxout(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>uxout</code> method in a fluent style.
   */
  public static class UxoutQueryParams extends HashMap<String, Object> {
    public UxoutQueryParams uxid(final String value) {
      put("uxid", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Verifies a Skycoin address.
   * 
   * @param address Address id. (required)
   * @return Object
   */
  @RequestLine("POST /api/v2/address/verify?address={address}")
  @Headers({
    "Accept: application/json",
  })
  Object verifyAddress(@Param("address") Address address);

  /**
   * Verifies a Skycoin address.
   * 
   * Note, this is equivalent to the other <code>verifyAddress</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link VerifyAddressQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>address - Address id. (required)</li>
   *   </ul>
   * @return Object
   */
  @RequestLine("POST /api/v2/address/verify?address={address}")
  @Headers({
  "Accept: application/json",
  })
  Object verifyAddress(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>verifyAddress</code> method in a fluent style.
   */
  public static class VerifyAddressQueryParams extends HashMap<String, Object> {
    public VerifyAddressQueryParams address(final Address value) {
      put("address", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * versionHandler returns the application version info
   * @return InlineResponse2005
   */
  @RequestLine("GET /api/v1/version")
  @Headers({
    "Accept: application/json",
  })
  InlineResponse2005 version();

  /**
   * Returns a wallet by id.
   * 
   * @param id tags to filter by (required)
   * @return Object
   */
  @RequestLine("GET /api/v1/wallet?id={id}")
  @Headers({
    "Accept: application/json",
  })
  Object wallet(@Param("id") String id);

  /**
   * Returns a wallet by id.
   * 
   * Note, this is equivalent to the other <code>wallet</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link WalletQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>id - tags to filter by (required)</li>
   *   </ul>
   * @return Object
   */
  @RequestLine("GET /api/v1/wallet?id={id}")
  @Headers({
  "Accept: application/json",
  })
  Object wallet(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>wallet</code> method in a fluent style.
   */
  public static class WalletQueryParams extends HashMap<String, Object> {
    public WalletQueryParams id(final String value) {
      put("id", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Returns the wallet&#39;s balance, both confirmed and predicted.  The predicted balance is the confirmed balance minus the pending spends.
   * 
   * @param id tags to filter by (required)
   * @return Object
   */
  @RequestLine("GET /api/v1/wallet/balance?id={id}")
  @Headers({
    "Accept: application/json",
  })
  Object walletBalance(@Param("id") String id);

  /**
   * Returns the wallet&#39;s balance, both confirmed and predicted.  The predicted balance is the confirmed balance minus the pending spends.
   * 
   * Note, this is equivalent to the other <code>walletBalance</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link WalletBalanceQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>id - tags to filter by (required)</li>
   *   </ul>
   * @return Object
   */
  @RequestLine("GET /api/v1/wallet/balance?id={id}")
  @Headers({
  "Accept: application/json",
  })
  Object walletBalance(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>walletBalance</code> method in a fluent style.
   */
  public static class WalletBalanceQueryParams extends HashMap<String, Object> {
    public WalletBalanceQueryParams id(final String value) {
      put("id", EncodingUtils.encode(value));
      return this;
    }
  }

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
   * @return Object
   */
  @RequestLine("POST /api/v1/wallet/create")
  @Headers({
    "Accept: application/json",
    "seed-passphrase: {seedPassphrase}",
    
    "type: {type}",
    
    "bip44-coin: {bip44Coin}",
    
    "seed: {seed}",
    
    "xpub: {xpub}",
    
    "label: {label}",
    
    "scan: {scan}",
    
    "encrypt: {encrypt}",
    
    "password: {password}"
  })
  Object walletCreate(@Param("type") String type, @Param("seed") String seed, @Param("label") String label, @Param("seedPassphrase") String seedPassphrase, @Param("bip44Coin") String bip44Coin, @Param("xpub") String xpub, @Param("scan") Integer scan, @Param("encrypt") Boolean encrypt, @Param("password") String password);

  /**
   * Decrypts wallet.
   * 
   * @param id Wallet id. (required)
   * @param password Wallet password. (required)
   * @return Object
   */
  @RequestLine("POST /api/v1/wallet/decrypt")
  @Headers({
    "Accept: application/json",
    "id: {id}",
    
    "password: {password}"
  })
  Object walletDecrypt(@Param("id") String id, @Param("password") String password);

  /**
   * Encrypt wallet.
   * 
   * @param id Wallet id. (required)
   * @param password Wallet password. (required)
   * @return Object
   */
  @RequestLine("POST /api/v1/wallet/encrypt")
  @Headers({
    "Accept: application/json",
    "id: {id}",
    
    "password: {password}"
  })
  Object walletEncrypt(@Param("id") String id, @Param("password") String password);

  /**
   * 
   * Returns the wallet directory path
   * @param addr Address port (required)
   * @return InlineResponse2007
   */
  @RequestLine("GET /api/v1/wallets/folderName?addr={addr}")
  @Headers({
    "Accept: application/json",
  })
  InlineResponse2007 walletFolder(@Param("addr") String addr);

  /**
   * 
   * Returns the wallet directory path
   * Note, this is equivalent to the other <code>walletFolder</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link WalletFolderQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>addr - Address port (required)</li>
   *   </ul>
   * @return InlineResponse2007
   */
  @RequestLine("GET /api/v1/wallets/folderName?addr={addr}")
  @Headers({
  "Accept: application/json",
  })
  InlineResponse2007 walletFolder(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>walletFolder</code> method in a fluent style.
   */
  public static class WalletFolderQueryParams extends HashMap<String, Object> {
    public WalletFolderQueryParams addr(final String value) {
      put("addr", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * Generates new addresses
   * @param id Wallet Id (required)
   * @param num The number you want to generate (optional)
   * @param password Wallet Password (optional)
   * @return Object
   */
  @RequestLine("POST /api/v1/wallet/newAddress?id={id}&num={num}&password={password}")
  @Headers({
    "Accept: application/json",
  })
  Object walletNewAddress(@Param("id") String id, @Param("num") String num, @Param("password") String password);

  /**
   * 
   * Generates new addresses
   * Note, this is equivalent to the other <code>walletNewAddress</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link WalletNewAddressQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>id - Wallet Id (required)</li>
   *   <li>num - The number you want to generate (optional)</li>
   *   <li>password - Wallet Password (optional)</li>
   *   </ul>
   * @return Object
   */
  @RequestLine("POST /api/v1/wallet/newAddress?id={id}&num={num}&password={password}")
  @Headers({
  "Accept: application/json",
  })
  Object walletNewAddress(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>walletNewAddress</code> method in a fluent style.
   */
  public static class WalletNewAddressQueryParams extends HashMap<String, Object> {
    public WalletNewAddressQueryParams id(final String value) {
      put("id", EncodingUtils.encode(value));
      return this;
    }
    public WalletNewAddressQueryParams num(final String value) {
      put("num", EncodingUtils.encode(value));
      return this;
    }
    public WalletNewAddressQueryParams password(final String value) {
      put("password", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * Returns the wallet directory path
   * @param entropy Entropy bitSize. (optional)
   * @return Object
   */
  @RequestLine("GET /api/v1/wallet/newSeed?entropy={entropy}")
  @Headers({
    "Accept: application/json",
  })
  Object walletNewSeed(@Param("entropy") String entropy);

  /**
   * 
   * Returns the wallet directory path
   * Note, this is equivalent to the other <code>walletNewSeed</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link WalletNewSeedQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>entropy - Entropy bitSize. (optional)</li>
   *   </ul>
   * @return Object
   */
  @RequestLine("GET /api/v1/wallet/newSeed?entropy={entropy}")
  @Headers({
  "Accept: application/json",
  })
  Object walletNewSeed(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>walletNewSeed</code> method in a fluent style.
   */
  public static class WalletNewSeedQueryParams extends HashMap<String, Object> {
    public WalletNewSeedQueryParams entropy(final String value) {
      put("entropy", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Recovers an encrypted wallet by providing the seed. The first address will be generated from seed and compared to the first address of the specified wallet. If they match, the wallet will be regenerated with an optional password. If the wallet is not encrypted, an error is returned.
   * Recovers an encrypted wallet by providing the wallet seed and optional seed passphrase
   * @param id Wallet id. (required)
   * @param seed Wallet seed. (required)
   * @param seedPassphrase Wallet seed-passphrase. (optional)
   * @param password Wallet password. (optional)
   * @return Object
   */
  @RequestLine("POST /api/v2/wallet/recover")
  @Headers({
    "Accept: application/json",
    "id: {id}",
    
    "seed: {seed}",
    
    "seed-passphrase: {seedPassphrase}",
    
    "password: {password}"
  })
  Object walletRecover(@Param("id") String id, @Param("seed") String seed, @Param("seedPassphrase") String seedPassphrase, @Param("password") String password);

  /**
   * This endpoint only works for encrypted wallets. If the wallet is unencrypted, The seed will be not returned.
   * 
   * @param id Wallet Id. (required)
   * @param password Wallet password. (required)
   * @return Object
   */
  @RequestLine("POST /api/v1/wallet/seed?id={id}&password={password}")
  @Headers({
    "Accept: application/json",
  })
  Object walletSeed(@Param("id") String id, @Param("password") String password);

  /**
   * This endpoint only works for encrypted wallets. If the wallet is unencrypted, The seed will be not returned.
   * 
   * Note, this is equivalent to the other <code>walletSeed</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link WalletSeedQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>id - Wallet Id. (required)</li>
   *   <li>password - Wallet password. (required)</li>
   *   </ul>
   * @return Object
   */
  @RequestLine("POST /api/v1/wallet/seed?id={id}&password={password}")
  @Headers({
  "Accept: application/json",
  })
  Object walletSeed(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>walletSeed</code> method in a fluent style.
   */
  public static class WalletSeedQueryParams extends HashMap<String, Object> {
    public WalletSeedQueryParams id(final String value) {
      put("id", EncodingUtils.encode(value));
      return this;
    }
    public WalletSeedQueryParams password(final String value) {
      put("password", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Verifies a wallet seed.
   * 
   * @param seed Seed to be verified. (optional)
   * @return Object
   */
  @RequestLine("POST /api/v2/wallet/seed/verify")
  @Headers({
    "Accept: application/json",
    "seed: {seed}"
  })
  Object walletSeedVerify(@Param("seed") String seed);

  /**
   * Creates a signed transaction
   * 
   * @param walletTransactionRequest  (required)
   * @return Object
   */
  @RequestLine("POST /api/v1/wallet/transaction")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  Object walletTransaction(WalletTransactionRequest walletTransactionRequest);

  /**
   * Creates a signed transaction
   * 
   * @param walletTransactionSignRequest  (required)
   * @return InlineResponse2009
   */
  @RequestLine("POST /api/v2/wallet/transaction/sign")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  InlineResponse2009 walletTransactionSign(WalletTransactionSignRequest walletTransactionSignRequest);

  /**
   * 
   * 
   * @param id Wallet Id. (required)
   * @return InlineResponse2006
   */
  @RequestLine("GET /api/v1/wallet/transactions?id={id}")
  @Headers({
    "Accept: application/json",
  })
  InlineResponse2006 walletTransactions(@Param("id") String id);

  /**
   * 
   * 
   * Note, this is equivalent to the other <code>walletTransactions</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link WalletTransactionsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>id - Wallet Id. (required)</li>
   *   </ul>
   * @return InlineResponse2006
   */
  @RequestLine("GET /api/v1/wallet/transactions?id={id}")
  @Headers({
  "Accept: application/json",
  })
  InlineResponse2006 walletTransactions(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>walletTransactions</code> method in a fluent style.
   */
  public static class WalletTransactionsQueryParams extends HashMap<String, Object> {
    public WalletTransactionsQueryParams id(final String value) {
      put("id", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Unloads wallet from the wallet service.
   * 
   * @param id Wallet Id. (required)
   */
  @RequestLine("POST /api/v1/wallet/unload?id={id}")
  @Headers({
    "Accept: application/json",
  })
  void walletUnload(@Param("id") String id);

  /**
   * Unloads wallet from the wallet service.
   * 
   * Note, this is equivalent to the other <code>walletUnload</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link WalletUnloadQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>id - Wallet Id. (required)</li>
   *   </ul>
   */
  @RequestLine("POST /api/v1/wallet/unload?id={id}")
  @Headers({
  "Accept: application/json",
  })
  void walletUnload(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>walletUnload</code> method in a fluent style.
   */
  public static class WalletUnloadQueryParams extends HashMap<String, Object> {
    public WalletUnloadQueryParams id(final String value) {
      put("id", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Update the wallet.
   * 
   * @param id Wallet Id. (required)
   * @param label The label the wallet will be updated to. (required)
   * @return String
   */
  @RequestLine("POST /api/v1/wallet/update")
  @Headers({
    "Accept: application/json",
    "id: {id}",
    
    "label: {label}"
  })
  String walletUpdate(@Param("id") String id, @Param("label") String label);

  /**
   * 
   * Returns all loaded wallets
   * @return List&lt;Object&gt;
   */
  @RequestLine("GET /api/v1/wallets")
  @Headers({
    "Accept: application/json",
  })
  List<Object> wallets();
}
