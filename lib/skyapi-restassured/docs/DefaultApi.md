# DefaultApi

All URIs are relative to *http://127.0.0.1:6420*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addressCount**](DefaultApi.md#addressCount) | **GET** /api/v1/addresscount | Returns the total number of unique address that have coins.
[**addressUxouts**](DefaultApi.md#addressUxouts) | **GET** /api/v1/address_uxouts | 
[**apiV1RawtxGet**](DefaultApi.md#apiV1RawtxGet) | **GET** /api/v1/rawtx | 
[**apiV2MetricsGet**](DefaultApi.md#apiV2MetricsGet) | **GET** /api/v2/metrics | 
[**balanceGet**](DefaultApi.md#balanceGet) | **GET** /api/v1/balance | Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
[**balancePost**](DefaultApi.md#balancePost) | **POST** /api/v1/balance | Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
[**block**](DefaultApi.md#block) | **GET** /api/v1/block | Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
[**blockchainMetadata**](DefaultApi.md#blockchainMetadata) | **GET** /api/v1/blockchain/metadata | Returns the blockchain metadata.
[**blockchainProgress**](DefaultApi.md#blockchainProgress) | **GET** /api/v1/blockchain/progress | Returns the blockchain sync progress.
[**blocks**](DefaultApi.md#blocks) | **GET** /api/v1/blocks | Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
[**coinSupply**](DefaultApi.md#coinSupply) | **GET** /api/v1/coinSupply | 
[**csrf**](DefaultApi.md#csrf) | **GET** /api/v1/csrf | Creates a new CSRF token. Previous CSRF tokens are invalidated by this call.
[**dataDELETE**](DefaultApi.md#dataDELETE) | **DELETE** /api/v2/data | 
[**dataGET**](DefaultApi.md#dataGET) | **GET** /api/v2/data | 
[**dataPOST**](DefaultApi.md#dataPOST) | **POST** /api/v2/data | 
[**defaultConnections**](DefaultApi.md#defaultConnections) | **GET** /api/v1/network/defaultConnections | defaultConnectionsHandler returns the list of default hardcoded bootstrap addresses.\\n They are not necessarily connected to.
[**health**](DefaultApi.md#health) | **GET** /api/v1/health | Returns node health data.
[**lastBlocks**](DefaultApi.md#lastBlocks) | **GET** /api/v1/last_blocks | 
[**networkConnection**](DefaultApi.md#networkConnection) | **GET** /api/v1/network/connection | This endpoint returns a specific connection.
[**networkConnections**](DefaultApi.md#networkConnections) | **GET** /api/v1/network/connections | This endpoint returns all outgoings connections.
[**networkConnectionsDisconnect**](DefaultApi.md#networkConnectionsDisconnect) | **POST** /api/v1/network/connection/disconnect | 
[**networkConnectionsExchange**](DefaultApi.md#networkConnectionsExchange) | **GET** /api/v1/network/connections/exchange | 
[**networkConnectionsTrust**](DefaultApi.md#networkConnectionsTrust) | **GET** /api/v1/network/connections/trust | trustConnectionsHandler returns all trusted connections.\\n They are not necessarily connected to. In the default configuration, these will be a subset of the default hardcoded bootstrap addresses.
[**outputsGet**](DefaultApi.md#outputsGet) | **GET** /api/v1/outputs | If neither addrs nor hashes are specificed, return all unspent outputs. If only one filter is specified, then return outputs match the filter. Both filters cannot be specified.
[**outputsPost**](DefaultApi.md#outputsPost) | **POST** /api/v1/outputs | If neither addrs nor hashes are specificed, return all unspent outputs. If only one filter is specified, then return outputs match the filter. Both filters cannot be specified.
[**pendingTxs**](DefaultApi.md#pendingTxs) | **GET** /api/v1/pendingTxs | 
[**resendUnconfirmedTxns**](DefaultApi.md#resendUnconfirmedTxns) | **POST** /api/v1/resendUnconfirmedTxns | 
[**richlist**](DefaultApi.md#richlist) | **GET** /api/v1/richlist | Returns the top skycoin holders.
[**transaction**](DefaultApi.md#transaction) | **GET** /api/v1/transaction | 
[**transactionInject**](DefaultApi.md#transactionInject) | **POST** /api/v1/injectTransaction | Broadcast a hex-encoded, serialized transaction to the network.
[**transactionPost**](DefaultApi.md#transactionPost) | **POST** /api/v2/transaction | 
[**transactionPostUnspent**](DefaultApi.md#transactionPostUnspent) | **POST** /api/v2/transaction/unspent | 
[**transactionRaw**](DefaultApi.md#transactionRaw) | **GET** /api/v2/transaction/raw | Returns the hex-encoded byte serialization of a transaction. The transaction may be confirmed or unconfirmed.
[**transactionVerify**](DefaultApi.md#transactionVerify) | **POST** /api/v2/transaction/verify | 
[**transactionsGet**](DefaultApi.md#transactionsGet) | **GET** /api/v1/transactions | Returns transactions that match the filters.
[**transactionsPost**](DefaultApi.md#transactionsPost) | **POST** /api/v1/transactions | Returns transactions that match the filters.
[**uxout**](DefaultApi.md#uxout) | **GET** /api/v1/uxout | Returns an unspent output by ID.
[**verifyAddress**](DefaultApi.md#verifyAddress) | **POST** /api/v2/address/verify | Verifies a Skycoin address.
[**version**](DefaultApi.md#version) | **GET** /api/v1/version | 
[**wallet**](DefaultApi.md#wallet) | **GET** /api/v1/wallet | Returns a wallet by id.
[**walletBalance**](DefaultApi.md#walletBalance) | **GET** /api/v1/wallet/balance | Returns the wallet&#39;s balance, both confirmed and predicted.  The predicted balance is the confirmed balance minus the pending spends.
[**walletCreate**](DefaultApi.md#walletCreate) | **POST** /api/v1/wallet/create | 
[**walletDecrypt**](DefaultApi.md#walletDecrypt) | **POST** /api/v1/wallet/decrypt | Decrypts wallet.
[**walletEncrypt**](DefaultApi.md#walletEncrypt) | **POST** /api/v1/wallet/encrypt | Encrypt wallet.
[**walletFolder**](DefaultApi.md#walletFolder) | **GET** /api/v1/wallets/folderName | 
[**walletNewAddress**](DefaultApi.md#walletNewAddress) | **POST** /api/v1/wallet/newAddress | 
[**walletNewSeed**](DefaultApi.md#walletNewSeed) | **GET** /api/v1/wallet/newSeed | 
[**walletRecover**](DefaultApi.md#walletRecover) | **POST** /api/v2/wallet/recover | Recovers an encrypted wallet by providing the seed. The first address will be generated from seed and compared to the first address of the specified wallet. If they match, the wallet will be regenerated with an optional password. If the wallet is not encrypted, an error is returned.
[**walletSeed**](DefaultApi.md#walletSeed) | **POST** /api/v1/wallet/seed | This endpoint only works for encrypted wallets. If the wallet is unencrypted, The seed will be not returned.
[**walletSeedVerify**](DefaultApi.md#walletSeedVerify) | **POST** /api/v2/wallet/seed/verify | Verifies a wallet seed.
[**walletTransaction**](DefaultApi.md#walletTransaction) | **POST** /api/v1/wallet/transaction | Creates a signed transaction
[**walletTransactionSign**](DefaultApi.md#walletTransactionSign) | **POST** /api/v2/wallet/transaction/sign | Creates a signed transaction
[**walletTransactions**](DefaultApi.md#walletTransactions) | **GET** /api/v1/wallet/transactions | 
[**walletUnload**](DefaultApi.md#walletUnload) | **POST** /api/v1/wallet/unload | Unloads wallet from the wallet service.
[**walletUpdate**](DefaultApi.md#walletUpdate) | **POST** /api/v1/wallet/update | Update the wallet.
[**wallets**](DefaultApi.md#wallets) | **GET** /api/v1/wallets | 


<a name="addressCount"></a>
# **addressCount**
> InlineResponse200 addressCount()

Returns the total number of unique address that have coins.

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.addressCount().execute(r -> r.prettyPeek());
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**InlineResponse200**](InlineResponse200.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

<a name="addressUxouts"></a>
# **addressUxouts**
> List&lt;Object&gt; addressUxouts(address)



Returns the historical, spent outputs associated with an address

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.addressUxouts()
    .addressQuery(address).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **address** | **String**| address to filter by |

### Return type

**List&lt;Object&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

<a name="apiV1RawtxGet"></a>
# **apiV1RawtxGet**
> String apiV1RawtxGet()



### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.apiV1RawtxGet().execute(r -> r.prettyPeek());
```

### Parameters
This endpoint does not need any parameter.

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain

<a name="apiV2MetricsGet"></a>
# **apiV2MetricsGet**
> String apiV2MetricsGet()



### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.apiV2MetricsGet().execute(r -> r.prettyPeek());
```

### Parameters
This endpoint does not need any parameter.

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain

<a name="balanceGet"></a>
# **balanceGet**
> Object balanceGet(addrs)

Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.balanceGet()
    .addrsQuery(addrs).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **addrs** | **String**| command separated list of addresses |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

<a name="balancePost"></a>
# **balancePost**
> Object balancePost(addrs)

Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.balancePost()
    .addrsQuery(addrs).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **addrs** | **String**| command separated list of addresses |

### Return type

**Object**

### Authorization

[csrfAuth](../README.md#csrfAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

<a name="block"></a>
# **block**
> List&lt;BlockSchema&gt; block(hash, seq)

Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.block().execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hash** | **String**| get block by hash | [optional]
 **seq** | **Integer**| get block by sequence number | [optional]

### Return type

[**List&lt;BlockSchema&gt;**](BlockSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

<a name="blockchainMetadata"></a>
# **blockchainMetadata**
> Object blockchainMetadata()

Returns the blockchain metadata.

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.blockchainMetadata().execute(r -> r.prettyPeek());
```

### Parameters
This endpoint does not need any parameter.

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

<a name="blockchainProgress"></a>
# **blockchainProgress**
> Object blockchainProgress()

Returns the blockchain sync progress.

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.blockchainProgress().execute(r -> r.prettyPeek());
```

### Parameters
This endpoint does not need any parameter.

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

<a name="blocks"></a>
# **blocks**
> InlineResponse2001 blocks(start, end, seq)

Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.blocks().execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **Integer**| start seq | [optional]
 **end** | **Integer**| end seq | [optional]
 **seq** | [**List&lt;Integer&gt;**](Integer.md)| comma-separated list of block seqs | [optional] [default to new ArrayList&lt;Integer&gt;()]

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

<a name="coinSupply"></a>
# **coinSupply**
> InlineResponse2002 coinSupply()



coinSupplyHandler returns coin distribution supply stats

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.coinSupply().execute(r -> r.prettyPeek());
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**InlineResponse2002**](InlineResponse2002.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

<a name="csrf"></a>
# **csrf**
> InlineResponse2003 csrf()

Creates a new CSRF token. Previous CSRF tokens are invalidated by this call.

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.csrf().execute(r -> r.prettyPeek());
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**InlineResponse2003**](InlineResponse2003.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

<a name="dataDELETE"></a>
# **dataDELETE**
> dataDELETE(type, key)



### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.dataDELETE().execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **type** | **String**| storage type. | [optional]
 **key** | **String**| key of the specific value to get. | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml

<a name="dataGET"></a>
# **dataGET**
> Object dataGET(type, key)



### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.dataGET().execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **type** | **String**| storage type. | [optional]
 **key** | **String**| key of the specific value to get. | [optional]

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

<a name="dataPOST"></a>
# **dataPOST**
> dataPOST(type, key, val)



### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.dataPOST().execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **type** | **String**| storage type. | [optional]
 **key** | **String**| key of the specific value to get. | [optional]
 **val** | **String**| additional value. | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml

<a name="defaultConnections"></a>
# **defaultConnections**
> List&lt;String&gt; defaultConnections()

defaultConnectionsHandler returns the list of default hardcoded bootstrap addresses.\\n They are not necessarily connected to.

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.defaultConnections().execute(r -> r.prettyPeek());
```

### Parameters
This endpoint does not need any parameter.

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

<a name="health"></a>
# **health**
> Object health()

Returns node health data.

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.health().execute(r -> r.prettyPeek());
```

### Parameters
This endpoint does not need any parameter.

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

<a name="lastBlocks"></a>
# **lastBlocks**
> Object lastBlocks(num)



Returns the most recent N blocks on the blockchain

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.lastBlocks()
    .numQuery(num).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **num** | **Integer**| Num of blockss |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

<a name="networkConnection"></a>
# **networkConnection**
> NetworkConnectionSchema networkConnection(addr)

This endpoint returns a specific connection.

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.networkConnection()
    .addrQuery(addr).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **addr** | **String**| Address port |

### Return type

[**NetworkConnectionSchema**](NetworkConnectionSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

<a name="networkConnections"></a>
# **networkConnections**
> InlineResponse2004 networkConnections(states, direction)

This endpoint returns all outgoings connections.

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.networkConnections().execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **states** | **String**| Connection status. | [optional] [enum: pending, connected, introduced]
 **direction** | **String**| Direction of the connection. | [optional] [enum: connected, introduced]

### Return type

[**InlineResponse2004**](InlineResponse2004.md)

### Authorization

[csrfAuth](../README.md#csrfAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

<a name="networkConnectionsDisconnect"></a>
# **networkConnectionsDisconnect**
> networkConnectionsDisconnect(id)



This endpoint disconnects a connection by ID or address

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.networkConnectionsDisconnect()
    .idQuery(id).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Address id. |

### Return type

null (empty response body)

### Authorization

[csrfAuth](../README.md#csrfAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml

<a name="networkConnectionsExchange"></a>
# **networkConnectionsExchange**
> List&lt;String&gt; networkConnectionsExchange()



This endpoint returns all connections found through peer exchange

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.networkConnectionsExchange().execute(r -> r.prettyPeek());
```

### Parameters
This endpoint does not need any parameter.

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

<a name="networkConnectionsTrust"></a>
# **networkConnectionsTrust**
> List&lt;String&gt; networkConnectionsTrust()

trustConnectionsHandler returns all trusted connections.\\n They are not necessarily connected to. In the default configuration, these will be a subset of the default hardcoded bootstrap addresses.

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.networkConnectionsTrust().execute(r -> r.prettyPeek());
```

### Parameters
This endpoint does not need any parameter.

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

<a name="outputsGet"></a>
# **outputsGet**
> Object outputsGet(address, hash)

If neither addrs nor hashes are specificed, return all unspent outputs. If only one filter is specified, then return outputs match the filter. Both filters cannot be specified.

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.outputsGet().execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **address** | [**List&lt;String&gt;**](String.md)|  | [optional] [default to new ArrayList&lt;String&gt;()]
 **hash** | [**List&lt;String&gt;**](String.md)|  | [optional] [default to new ArrayList&lt;String&gt;()]

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

<a name="outputsPost"></a>
# **outputsPost**
> Object outputsPost(address, hash)

If neither addrs nor hashes are specificed, return all unspent outputs. If only one filter is specified, then return outputs match the filter. Both filters cannot be specified.

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.outputsPost().execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **address** | **String**|  | [optional]
 **hash** | **String**|  | [optional]

### Return type

**Object**

### Authorization

[csrfAuth](../README.md#csrfAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

<a name="pendingTxs"></a>
# **pendingTxs**
> List&lt;InlineResponse20010&gt; pendingTxs()



### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.pendingTxs().execute(r -> r.prettyPeek());
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;InlineResponse20010&gt;**](InlineResponse20010.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

<a name="resendUnconfirmedTxns"></a>
# **resendUnconfirmedTxns**
> Object resendUnconfirmedTxns()



Broadcasts all unconfirmed transactions from the unconfirmed transaction pool

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.resendUnconfirmedTxns().execute(r -> r.prettyPeek());
```

### Parameters
This endpoint does not need any parameter.

### Return type

**Object**

### Authorization

[csrfAuth](../README.md#csrfAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application-json, application/json, application/xml

<a name="richlist"></a>
# **richlist**
> Object richlist(includeDistribution, n)

Returns the top skycoin holders.

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.richlist().execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **includeDistribution** | **Boolean**| include distribution addresses or not, default value false | [optional]
 **n** | **String**| include distribution addresses or not, default value false | [optional]

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

<a name="transaction"></a>
# **transaction**
> Transaction transaction(txid)



Returns a transaction identified by its txid hash with just id

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.transaction()
    .txidQuery(txid).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **txid** | **String**| transaction Id |

### Return type

[**Transaction**](Transaction.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

<a name="transactionInject"></a>
# **transactionInject**
> String transactionInject(rawtx, noBroadcast)

Broadcast a hex-encoded, serialized transaction to the network.

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.transactionInject()
    .rawtxHeader(rawtx).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **rawtx** | **String**| hex-encoded serialized transaction string. |
 **noBroadcast** | **Boolean**| Disable the network broadcast | [optional]

### Return type

**String**

### Authorization

[csrfAuth](../README.md#csrfAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, application/xml

<a name="transactionPost"></a>
# **transactionPost**
> InlineResponse2008 transactionPost(transactionV2ParamsAddress)



### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.transactionPost().execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **transactionV2ParamsAddress** | [**TransactionV2ParamsAddress**](TransactionV2ParamsAddress.md)|  | [optional]

### Return type

[**InlineResponse2008**](InlineResponse2008.md)

### Authorization

[csrfAuth](../README.md#csrfAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, application/xml, 

<a name="transactionPostUnspent"></a>
# **transactionPostUnspent**
> InlineResponse2008 transactionPostUnspent(transactionV2ParamsUnspent)



### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.transactionPostUnspent()
    .body(transactionV2ParamsUnspent).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **transactionV2ParamsUnspent** | [**TransactionV2ParamsUnspent**](TransactionV2ParamsUnspent.md)| Unspent parameters |

### Return type

[**InlineResponse2008**](InlineResponse2008.md)

### Authorization

[csrfAuth](../README.md#csrfAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, application/xml, 

<a name="transactionRaw"></a>
# **transactionRaw**
> Object transactionRaw(txid)

Returns the hex-encoded byte serialization of a transaction. The transaction may be confirmed or unconfirmed.

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.transactionRaw().execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **txid** | **String**| Transaction id hash | [optional]

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

<a name="transactionVerify"></a>
# **transactionVerify**
> Object transactionVerify(transactionVerifyRequest)



Decode and verify an encoded transaction

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.transactionVerify()
    .body(transactionVerifyRequest).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **transactionVerifyRequest** | [**TransactionVerifyRequest**](TransactionVerifyRequest.md)|  |

### Return type

**Object**

### Authorization

[csrfAuth](../README.md#csrfAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, application/xml, 

<a name="transactionsGet"></a>
# **transactionsGet**
> Object transactionsGet(addrs, confirmed)

Returns transactions that match the filters.

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.transactionsGet().execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **addrs** | **String**| command separated list of addresses | [optional]
 **confirmed** | **String**| Whether the transactions should be confirmed [optional, must be 0 or 1; if not provided, returns all] | [optional]

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

<a name="transactionsPost"></a>
# **transactionsPost**
> Object transactionsPost(addrs, confirmed)

Returns transactions that match the filters.

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.transactionsPost().execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **addrs** | **String**| command separated list of addresses | [optional]
 **confirmed** | **String**| Whether the transactions should be confirmed [optional, must be 0 or 1; if not provided, returns all] | [optional]

### Return type

**Object**

### Authorization

[csrfAuth](../README.md#csrfAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

<a name="uxout"></a>
# **uxout**
> Object uxout(uxid)

Returns an unspent output by ID.

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.uxout().execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uxid** | **String**| uxid to filter by | [optional]

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

<a name="verifyAddress"></a>
# **verifyAddress**
> Object verifyAddress(address)

Verifies a Skycoin address.

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.verifyAddress()
    .addressQuery(address).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **address** | [**Address**](.md)| Address id. | [default to null]

### Return type

**Object**

### Authorization

[csrfAuth](../README.md#csrfAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

<a name="version"></a>
# **version**
> InlineResponse2005 version()



versionHandler returns the application version info

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.version().execute(r -> r.prettyPeek());
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**InlineResponse2005**](InlineResponse2005.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

<a name="wallet"></a>
# **wallet**
> Object wallet(id)

Returns a wallet by id.

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.wallet()
    .idQuery(id).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| tags to filter by |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

<a name="walletBalance"></a>
# **walletBalance**
> Object walletBalance(id)

Returns the wallet&#39;s balance, both confirmed and predicted.  The predicted balance is the confirmed balance minus the pending spends.

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.walletBalance()
    .idQuery(id).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| tags to filter by |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

<a name="walletCreate"></a>
# **walletCreate**
> Object walletCreate(type, seed, label, seedPassphrase, bip44Coin, xpub, scan, encrypt, password)



Create a wallet

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.walletCreate()
    .typeHeader(type)
    .seedHeader(seed)
    .labelHeader(label).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **type** | **String**| wallet seed passphrase [optional, bip44 type wallet only] |
 **seed** | **String**| Wallet seed. |
 **label** | **String**| Wallet label. |
 **seedPassphrase** | **String**| wallet seed passphrase [optional, bip44 type wallet only] | [optional]
 **bip44Coin** | **String**| BIP44 coin type [optional, defaults to 8000 (skycoin&#39;s coin type), only valid if type is \&quot;bip44\&quot;] | [optional]
 **xpub** | **String**| xpub key [required for xpub wallets] | [optional]
 **scan** | **Integer**| The number of addresses to scan ahead for balances. | [optional]
 **encrypt** | **Boolean**| Encrypt wallet. | [optional]
 **password** | **String**| Wallet Password | [optional]

### Return type

**Object**

### Authorization

[csrfAuth](../README.md#csrfAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

<a name="walletDecrypt"></a>
# **walletDecrypt**
> Object walletDecrypt(id, password)

Decrypts wallet.

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.walletDecrypt()
    .idHeader(id)
    .passwordHeader(password).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Wallet id. |
 **password** | **String**| Wallet password. |

### Return type

**Object**

### Authorization

[csrfAuth](../README.md#csrfAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

<a name="walletEncrypt"></a>
# **walletEncrypt**
> Object walletEncrypt(id, password)

Encrypt wallet.

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.walletEncrypt()
    .idHeader(id)
    .passwordHeader(password).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Wallet id. |
 **password** | **String**| Wallet password. |

### Return type

**Object**

### Authorization

[csrfAuth](../README.md#csrfAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

<a name="walletFolder"></a>
# **walletFolder**
> InlineResponse2007 walletFolder(addr)



Returns the wallet directory path

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.walletFolder()
    .addrQuery(addr).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **addr** | **String**| Address port |

### Return type

[**InlineResponse2007**](InlineResponse2007.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

<a name="walletNewAddress"></a>
# **walletNewAddress**
> Object walletNewAddress(id, num, password)



Generates new addresses

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.walletNewAddress()
    .idQuery(id).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Wallet Id |
 **num** | **String**| The number you want to generate | [optional]
 **password** | **String**| Wallet Password | [optional]

### Return type

**Object**

### Authorization

[csrfAuth](../README.md#csrfAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

<a name="walletNewSeed"></a>
# **walletNewSeed**
> Object walletNewSeed(entropy)



Returns the wallet directory path

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.walletNewSeed().execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entropy** | **String**| Entropy bitSize. | [optional] [enum: 128, 256]

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

<a name="walletRecover"></a>
# **walletRecover**
> Object walletRecover(id, seed, seedPassphrase, password)

Recovers an encrypted wallet by providing the seed. The first address will be generated from seed and compared to the first address of the specified wallet. If they match, the wallet will be regenerated with an optional password. If the wallet is not encrypted, an error is returned.

Recovers an encrypted wallet by providing the wallet seed and optional seed passphrase

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.walletRecover()
    .idHeader(id)
    .seedHeader(seed).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Wallet id. |
 **seed** | **String**| Wallet seed. |
 **seedPassphrase** | **String**| Wallet seed-passphrase. | [optional]
 **password** | **String**| Wallet password. | [optional]

### Return type

**Object**

### Authorization

[csrfAuth](../README.md#csrfAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

<a name="walletSeed"></a>
# **walletSeed**
> Object walletSeed(id, password)

This endpoint only works for encrypted wallets. If the wallet is unencrypted, The seed will be not returned.

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.walletSeed()
    .idQuery(id)
    .passwordQuery(password).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Wallet Id. |
 **password** | **String**| Wallet password. |

### Return type

**Object**

### Authorization

[csrfAuth](../README.md#csrfAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

<a name="walletSeedVerify"></a>
# **walletSeedVerify**
> Object walletSeedVerify(seed)

Verifies a wallet seed.

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.walletSeedVerify().execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **seed** | **String**| Seed to be verified. | [optional]

### Return type

**Object**

### Authorization

[csrfAuth](../README.md#csrfAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

<a name="walletTransaction"></a>
# **walletTransaction**
> Object walletTransaction(walletTransactionRequest)

Creates a signed transaction

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.walletTransaction()
    .body(walletTransactionRequest).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **walletTransactionRequest** | [**WalletTransactionRequest**](WalletTransactionRequest.md)|  |

### Return type

**Object**

### Authorization

[csrfAuth](../README.md#csrfAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, application/xml, 

<a name="walletTransactionSign"></a>
# **walletTransactionSign**
> InlineResponse2009 walletTransactionSign(walletTransactionSignRequest)

Creates a signed transaction

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.walletTransactionSign()
    .body(walletTransactionSignRequest).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **walletTransactionSignRequest** | [**WalletTransactionSignRequest**](WalletTransactionSignRequest.md)|  |

### Return type

[**InlineResponse2009**](InlineResponse2009.md)

### Authorization

[csrfAuth](../README.md#csrfAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, application/xml, 

<a name="walletTransactions"></a>
# **walletTransactions**
> InlineResponse2006 walletTransactions(id)



### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.walletTransactions()
    .idQuery(id).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Wallet Id. |

### Return type

[**InlineResponse2006**](InlineResponse2006.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

<a name="walletUnload"></a>
# **walletUnload**
> walletUnload(id)

Unloads wallet from the wallet service.

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.walletUnload()
    .idQuery(id).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Wallet Id. |

### Return type

null (empty response body)

### Authorization

[csrfAuth](../README.md#csrfAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml

<a name="walletUpdate"></a>
# **walletUpdate**
> String walletUpdate(id, label)

Update the wallet.

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.walletUpdate()
    .idHeader(id)
    .labelHeader(label).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Wallet Id. |
 **label** | **String**| The label the wallet will be updated to. |

### Return type

**String**

### Authorization

[csrfAuth](../README.md#csrfAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, application/xml

<a name="wallets"></a>
# **wallets**
> List&lt;Object&gt; wallets()



Returns all loaded wallets

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

DefaultApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://127.0.0.1:6420")))._default();

api.wallets().execute(r -> r.prettyPeek());
```

### Parameters
This endpoint does not need any parameter.

### Return type

**List&lt;Object&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, 

