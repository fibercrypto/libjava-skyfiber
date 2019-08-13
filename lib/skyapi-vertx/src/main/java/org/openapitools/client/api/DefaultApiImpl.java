package org.openapitools.client.api;

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

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.MultiMap;
import io.vertx.core.json.JsonObject;

import com.fasterxml.jackson.core.type.TypeReference;

import java.util.*;

import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.Pair;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-08-06T00:35:41.357-04:00[America/Havana]")
public class DefaultApiImpl implements DefaultApi {

    private ApiClient apiClient;

    public DefaultApiImpl() {
        this(null);
    }

    public DefaultApiImpl(ApiClient apiClient) {
        this.apiClient = apiClient != null ? apiClient : Configuration.getDefaultApiClient();
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Returns the total number of unique address that have coins.
     * 
     * @param resultHandler Asynchronous result handler
     */
    public void addressCount(Handler<AsyncResult<InlineResponse200>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v1/addresscount";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] {  };
        TypeReference<InlineResponse200> localVarReturnType = new TypeReference<InlineResponse200>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * 
     * Returns the historical, spent outputs associated with an address
     * @param address address to filter by (required)
     * @param resultHandler Asynchronous result handler
     */
    public void addressUxouts(String address, Handler<AsyncResult<List<Object>>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'address' is set
        if (address == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'address' when calling addressUxouts"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v1/address_uxouts";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "address", address));

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] {  };
        TypeReference<List<Object>> localVarReturnType = new TypeReference<List<Object>>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * 
     * 
     * @param resultHandler Asynchronous result handler
     */
    public void apiV1RawtxGet(Handler<AsyncResult<String>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v1/rawtx";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "text/plain" };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] {  };
        TypeReference<String> localVarReturnType = new TypeReference<String>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * 
     * 
     * @param resultHandler Asynchronous result handler
     */
    public void apiV2MetricsGet(Handler<AsyncResult<String>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v2/metrics";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "text/plain" };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] {  };
        TypeReference<String> localVarReturnType = new TypeReference<String>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
     * 
     * @param addrs command separated list of addresses (required)
     * @param resultHandler Asynchronous result handler
     */
    public void balanceGet(String addrs, Handler<AsyncResult<Object>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'addrs' is set
        if (addrs == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'addrs' when calling balanceGet"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v1/balance";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "addrs", addrs));

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] {  };
        TypeReference<Object> localVarReturnType = new TypeReference<Object>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
     * 
     * @param addrs command separated list of addresses (required)
     * @param resultHandler Asynchronous result handler
     */
    public void balancePost(String addrs, Handler<AsyncResult<Object>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'addrs' is set
        if (addrs == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'addrs' when calling balancePost"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v1/balance";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "addrs", addrs));

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] { "csrfAuth" };
        TypeReference<Object> localVarReturnType = new TypeReference<Object>() {};
        apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
     * 
     * @param hash get block by hash (optional)
     * @param seq get block by sequence number (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void block(String hash, Integer seq, Handler<AsyncResult<List<BlockSchema>>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v1/block";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "hash", hash));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "seq", seq));

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] {  };
        TypeReference<List<BlockSchema>> localVarReturnType = new TypeReference<List<BlockSchema>>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * Returns the blockchain metadata.
     * 
     * @param resultHandler Asynchronous result handler
     */
    public void blockchainMetadata(Handler<AsyncResult<Object>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v1/blockchain/metadata";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] {  };
        TypeReference<Object> localVarReturnType = new TypeReference<Object>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * Returns the blockchain sync progress.
     * 
     * @param resultHandler Asynchronous result handler
     */
    public void blockchainProgress(Handler<AsyncResult<Object>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v1/blockchain/progress";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] {  };
        TypeReference<Object> localVarReturnType = new TypeReference<Object>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
     * 
     * @param start start seq (optional)
     * @param end end seq (optional)
     * @param seq comma-separated list of block seqs (optional, default to new ArrayList&lt;&gt;())
     * @param resultHandler Asynchronous result handler
     */
    public void blocks(Integer start, Integer end, List<Integer> seq, Handler<AsyncResult<InlineResponse2001>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v1/blocks";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "start", start));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "end", end));
        localVarQueryParams.addAll(apiClient.parameterToPairs("multi", "seq", seq));

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] {  };
        TypeReference<InlineResponse2001> localVarReturnType = new TypeReference<InlineResponse2001>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * 
     * coinSupplyHandler returns coin distribution supply stats
     * @param resultHandler Asynchronous result handler
     */
    public void coinSupply(Handler<AsyncResult<InlineResponse2002>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v1/coinSupply";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] {  };
        TypeReference<InlineResponse2002> localVarReturnType = new TypeReference<InlineResponse2002>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * Creates a new CSRF token. Previous CSRF tokens are invalidated by this call.
     * 
     * @param resultHandler Asynchronous result handler
     */
    public void csrf(Handler<AsyncResult<InlineResponse2003>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v1/csrf";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] {  };
        TypeReference<InlineResponse2003> localVarReturnType = new TypeReference<InlineResponse2003>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * 
     * 
     * @param type storage type. (optional)
     * @param key key of the specific value to get. (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void dataDELETE(String type, String key, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v2/data";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        if (type != null)
        localVarHeaderParams.add("type", apiClient.parameterToString(type));
if (key != null)
        localVarHeaderParams.add("key", apiClient.parameterToString(key));

        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml" };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] {  };

        apiClient.invokeAPI(localVarPath, "DELETE", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, null, resultHandler);
    }
    /**
     * 
     * 
     * @param type storage type. (optional)
     * @param key key of the specific value to get. (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void dataGET(String type, String key, Handler<AsyncResult<Object>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v2/data";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        if (type != null)
        localVarHeaderParams.add("type", apiClient.parameterToString(type));
if (key != null)
        localVarHeaderParams.add("key", apiClient.parameterToString(key));

        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] {  };
        TypeReference<Object> localVarReturnType = new TypeReference<Object>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * 
     * 
     * @param type storage type. (optional)
     * @param key key of the specific value to get. (optional)
     * @param val additional value. (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void dataPOST(String type, String key, String val, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v2/data";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        if (type != null)
        localVarHeaderParams.add("type", apiClient.parameterToString(type));
if (key != null)
        localVarHeaderParams.add("key", apiClient.parameterToString(key));
if (val != null)
        localVarHeaderParams.add("val", apiClient.parameterToString(val));

        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml" };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] {  };

        apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, null, resultHandler);
    }
    /**
     * defaultConnectionsHandler returns the list of default hardcoded bootstrap addresses.\\n They are not necessarily connected to.
     * 
     * @param resultHandler Asynchronous result handler
     */
    public void defaultConnections(Handler<AsyncResult<List<String>>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v1/network/defaultConnections";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] {  };
        TypeReference<List<String>> localVarReturnType = new TypeReference<List<String>>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * Returns node health data.
     * 
     * @param resultHandler Asynchronous result handler
     */
    public void health(Handler<AsyncResult<Object>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v1/health";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] {  };
        TypeReference<Object> localVarReturnType = new TypeReference<Object>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * 
     * Returns the most recent N blocks on the blockchain
     * @param num Num of blockss (required)
     * @param resultHandler Asynchronous result handler
     */
    public void lastBlocks(Integer num, Handler<AsyncResult<Object>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'num' is set
        if (num == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'num' when calling lastBlocks"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v1/last_blocks";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "num", num));

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] {  };
        TypeReference<Object> localVarReturnType = new TypeReference<Object>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * This endpoint returns a specific connection.
     * 
     * @param addr Address port (required)
     * @param resultHandler Asynchronous result handler
     */
    public void networkConnection(String addr, Handler<AsyncResult<NetworkConnectionSchema>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'addr' is set
        if (addr == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'addr' when calling networkConnection"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v1/network/connection";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "addr", addr));

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] {  };
        TypeReference<NetworkConnectionSchema> localVarReturnType = new TypeReference<NetworkConnectionSchema>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * This endpoint returns all outgoings connections.
     * 
     * @param states Connection status. (optional)
     * @param direction Direction of the connection. (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void networkConnections(String states, String direction, Handler<AsyncResult<InlineResponse2004>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v1/network/connections";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "states", states));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "direction", direction));

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] { "csrfAuth" };
        TypeReference<InlineResponse2004> localVarReturnType = new TypeReference<InlineResponse2004>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * 
     * This endpoint disconnects a connection by ID or address
     * @param id Address id. (required)
     * @param resultHandler Asynchronous result handler
     */
    public void networkConnectionsDisconnect(String id, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling networkConnectionsDisconnect"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v1/network/connection/disconnect";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "id", id));

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml" };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] { "csrfAuth" };

        apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, null, resultHandler);
    }
    /**
     * 
     * This endpoint returns all connections found through peer exchange
     * @param resultHandler Asynchronous result handler
     */
    public void networkConnectionsExchange(Handler<AsyncResult<List<String>>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v1/network/connections/exchange";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] {  };
        TypeReference<List<String>> localVarReturnType = new TypeReference<List<String>>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * trustConnectionsHandler returns all trusted connections.\\n They are not necessarily connected to. In the default configuration, these will be a subset of the default hardcoded bootstrap addresses.
     * 
     * @param resultHandler Asynchronous result handler
     */
    public void networkConnectionsTrust(Handler<AsyncResult<List<String>>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v1/network/connections/trust";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] {  };
        TypeReference<List<String>> localVarReturnType = new TypeReference<List<String>>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * If neither addrs nor hashes are specificed, return all unspent outputs. If only one filter is specified, then return outputs match the filter. Both filters cannot be specified.
     * 
     * @param address  (optional, default to new ArrayList&lt;&gt;())
     * @param hash  (optional, default to new ArrayList&lt;&gt;())
     * @param resultHandler Asynchronous result handler
     */
    public void outputsGet(List<String> address, List<String> hash, Handler<AsyncResult<Object>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v1/outputs";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(apiClient.parameterToPairs("multi", "address", address));
        localVarQueryParams.addAll(apiClient.parameterToPairs("multi", "hash", hash));

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] {  };
        TypeReference<Object> localVarReturnType = new TypeReference<Object>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * If neither addrs nor hashes are specificed, return all unspent outputs. If only one filter is specified, then return outputs match the filter. Both filters cannot be specified.
     * 
     * @param address  (optional)
     * @param hash  (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void outputsPost(String address, String hash, Handler<AsyncResult<Object>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v1/outputs";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "address", address));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "hash", hash));

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] { "csrfAuth" };
        TypeReference<Object> localVarReturnType = new TypeReference<Object>() {};
        apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * 
     * 
     * @param resultHandler Asynchronous result handler
     */
    public void pendingTxs(Handler<AsyncResult<List<InlineResponse20010>>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v1/pendingTxs";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] {  };
        TypeReference<List<InlineResponse20010>> localVarReturnType = new TypeReference<List<InlineResponse20010>>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * 
     * Broadcasts all unconfirmed transactions from the unconfirmed transaction pool
     * @param resultHandler Asynchronous result handler
     */
    public void resendUnconfirmedTxns(Handler<AsyncResult<Object>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v1/resendUnconfirmedTxns";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application-json", "application/json", "application/xml" };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] { "csrfAuth" };
        TypeReference<Object> localVarReturnType = new TypeReference<Object>() {};
        apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * Returns the top skycoin holders.
     * 
     * @param includeDistribution include distribution addresses or not, default value false (optional)
     * @param n include distribution addresses or not, default value false (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void richlist(Boolean includeDistribution, String n, Handler<AsyncResult<Object>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v1/richlist";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "include-distribution", includeDistribution));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "n", n));

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] {  };
        TypeReference<Object> localVarReturnType = new TypeReference<Object>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * 
     * Returns a transaction identified by its txid hash with just id
     * @param txid transaction Id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void transaction(String txid, Handler<AsyncResult<Transaction>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'txid' is set
        if (txid == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'txid' when calling transaction"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v1/transaction";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "txid", txid));

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] {  };
        TypeReference<Transaction> localVarReturnType = new TypeReference<Transaction>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * Broadcast a hex-encoded, serialized transaction to the network.
     * 
     * @param rawtx hex-encoded serialized transaction string. (required)
     * @param noBroadcast Disable the network broadcast (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void transactionInject(String rawtx, Boolean noBroadcast, Handler<AsyncResult<String>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'rawtx' is set
        if (rawtx == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'rawtx' when calling transactionInject"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v1/injectTransaction";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        if (rawtx != null)
        localVarHeaderParams.add("rawtx", apiClient.parameterToString(rawtx));
if (noBroadcast != null)
        localVarHeaderParams.add("no_broadcast", apiClient.parameterToString(noBroadcast));

        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "text/plain", "application/json", "application/xml" };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] { "csrfAuth" };
        TypeReference<String> localVarReturnType = new TypeReference<String>() {};
        apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * 
     * 
     * @param transactionV2ParamsAddress  (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void transactionPost(TransactionV2ParamsAddress transactionV2ParamsAddress, Handler<AsyncResult<InlineResponse2008>> resultHandler) {
        Object localVarBody = transactionV2ParamsAddress;
        
        // create path and map variables
        String localVarPath = "/api/v2/transaction";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = { "application/json" };
        String[] localVarAuthNames = new String[] { "csrfAuth" };
        TypeReference<InlineResponse2008> localVarReturnType = new TypeReference<InlineResponse2008>() {};
        apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * 
     * 
     * @param transactionV2ParamsUnspent Unspent parameters (required)
     * @param resultHandler Asynchronous result handler
     */
    public void transactionPostUnspent(TransactionV2ParamsUnspent transactionV2ParamsUnspent, Handler<AsyncResult<InlineResponse2008>> resultHandler) {
        Object localVarBody = transactionV2ParamsUnspent;
        
        // verify the required parameter 'transactionV2ParamsUnspent' is set
        if (transactionV2ParamsUnspent == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'transactionV2ParamsUnspent' when calling transactionPostUnspent"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v2/transaction/unspent";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = { "application/json" };
        String[] localVarAuthNames = new String[] { "csrfAuth" };
        TypeReference<InlineResponse2008> localVarReturnType = new TypeReference<InlineResponse2008>() {};
        apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * Returns the hex-encoded byte serialization of a transaction. The transaction may be confirmed or unconfirmed.
     * 
     * @param txid Transaction id hash (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void transactionRaw(String txid, Handler<AsyncResult<Object>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v2/transaction/raw";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "txid", txid));

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] {  };
        TypeReference<Object> localVarReturnType = new TypeReference<Object>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * 
     * Decode and verify an encoded transaction
     * @param transactionVerifyRequest  (required)
     * @param resultHandler Asynchronous result handler
     */
    public void transactionVerify(TransactionVerifyRequest transactionVerifyRequest, Handler<AsyncResult<Object>> resultHandler) {
        Object localVarBody = transactionVerifyRequest;
        
        // verify the required parameter 'transactionVerifyRequest' is set
        if (transactionVerifyRequest == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'transactionVerifyRequest' when calling transactionVerify"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v2/transaction/verify";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = { "application/json" };
        String[] localVarAuthNames = new String[] { "csrfAuth" };
        TypeReference<Object> localVarReturnType = new TypeReference<Object>() {};
        apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * Returns transactions that match the filters.
     * 
     * @param addrs command separated list of addresses (optional)
     * @param confirmed Whether the transactions should be confirmed [optional, must be 0 or 1; if not provided, returns all] (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void transactionsGet(String addrs, String confirmed, Handler<AsyncResult<Object>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v1/transactions";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "addrs", addrs));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "confirmed", confirmed));

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] {  };
        TypeReference<Object> localVarReturnType = new TypeReference<Object>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * Returns transactions that match the filters.
     * 
     * @param addrs command separated list of addresses (optional)
     * @param confirmed Whether the transactions should be confirmed [optional, must be 0 or 1; if not provided, returns all] (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void transactionsPost(String addrs, String confirmed, Handler<AsyncResult<Object>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v1/transactions";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "addrs", addrs));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "confirmed", confirmed));

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] { "csrfAuth" };
        TypeReference<Object> localVarReturnType = new TypeReference<Object>() {};
        apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * Returns an unspent output by ID.
     * 
     * @param uxid uxid to filter by (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void uxout(String uxid, Handler<AsyncResult<Object>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v1/uxout";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "uxid", uxid));

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] {  };
        TypeReference<Object> localVarReturnType = new TypeReference<Object>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * Verifies a Skycoin address.
     * 
     * @param address Address id. (required)
     * @param resultHandler Asynchronous result handler
     */
    public void verifyAddress(Address address, Handler<AsyncResult<Object>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'address' is set
        if (address == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'address' when calling verifyAddress"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v2/address/verify";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "address", address));

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] { "csrfAuth" };
        TypeReference<Object> localVarReturnType = new TypeReference<Object>() {};
        apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * 
     * versionHandler returns the application version info
     * @param resultHandler Asynchronous result handler
     */
    public void version(Handler<AsyncResult<InlineResponse2005>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v1/version";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] {  };
        TypeReference<InlineResponse2005> localVarReturnType = new TypeReference<InlineResponse2005>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * Returns a wallet by id.
     * 
     * @param id tags to filter by (required)
     * @param resultHandler Asynchronous result handler
     */
    public void wallet(String id, Handler<AsyncResult<Object>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling wallet"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v1/wallet";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "id", id));

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] {  };
        TypeReference<Object> localVarReturnType = new TypeReference<Object>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * Returns the wallet&#39;s balance, both confirmed and predicted.  The predicted balance is the confirmed balance minus the pending spends.
     * 
     * @param id tags to filter by (required)
     * @param resultHandler Asynchronous result handler
     */
    public void walletBalance(String id, Handler<AsyncResult<Object>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling walletBalance"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v1/wallet/balance";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "id", id));

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] {  };
        TypeReference<Object> localVarReturnType = new TypeReference<Object>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
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
     * @param resultHandler Asynchronous result handler
     */
    public void walletCreate(String type, String seed, String label, String seedPassphrase, String bip44Coin, String xpub, Integer scan, Boolean encrypt, String password, Handler<AsyncResult<Object>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'type' is set
        if (type == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'type' when calling walletCreate"));
            return;
        }
        
        // verify the required parameter 'seed' is set
        if (seed == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'seed' when calling walletCreate"));
            return;
        }
        
        // verify the required parameter 'label' is set
        if (label == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'label' when calling walletCreate"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v1/wallet/create";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        if (seedPassphrase != null)
        localVarHeaderParams.add("seed-passphrase", apiClient.parameterToString(seedPassphrase));
if (type != null)
        localVarHeaderParams.add("type", apiClient.parameterToString(type));
if (bip44Coin != null)
        localVarHeaderParams.add("bip44-coin", apiClient.parameterToString(bip44Coin));
if (seed != null)
        localVarHeaderParams.add("seed", apiClient.parameterToString(seed));
if (xpub != null)
        localVarHeaderParams.add("xpub", apiClient.parameterToString(xpub));
if (label != null)
        localVarHeaderParams.add("label", apiClient.parameterToString(label));
if (scan != null)
        localVarHeaderParams.add("scan", apiClient.parameterToString(scan));
if (encrypt != null)
        localVarHeaderParams.add("encrypt", apiClient.parameterToString(encrypt));
if (password != null)
        localVarHeaderParams.add("password", apiClient.parameterToString(password));

        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] { "csrfAuth" };
        TypeReference<Object> localVarReturnType = new TypeReference<Object>() {};
        apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * Decrypts wallet.
     * 
     * @param id Wallet id. (required)
     * @param password Wallet password. (required)
     * @param resultHandler Asynchronous result handler
     */
    public void walletDecrypt(String id, String password, Handler<AsyncResult<Object>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling walletDecrypt"));
            return;
        }
        
        // verify the required parameter 'password' is set
        if (password == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'password' when calling walletDecrypt"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v1/wallet/decrypt";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        if (id != null)
        localVarHeaderParams.add("id", apiClient.parameterToString(id));
if (password != null)
        localVarHeaderParams.add("password", apiClient.parameterToString(password));

        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] { "csrfAuth" };
        TypeReference<Object> localVarReturnType = new TypeReference<Object>() {};
        apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * Encrypt wallet.
     * 
     * @param id Wallet id. (required)
     * @param password Wallet password. (required)
     * @param resultHandler Asynchronous result handler
     */
    public void walletEncrypt(String id, String password, Handler<AsyncResult<Object>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling walletEncrypt"));
            return;
        }
        
        // verify the required parameter 'password' is set
        if (password == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'password' when calling walletEncrypt"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v1/wallet/encrypt";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        if (id != null)
        localVarHeaderParams.add("id", apiClient.parameterToString(id));
if (password != null)
        localVarHeaderParams.add("password", apiClient.parameterToString(password));

        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] { "csrfAuth" };
        TypeReference<Object> localVarReturnType = new TypeReference<Object>() {};
        apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * 
     * Returns the wallet directory path
     * @param addr Address port (required)
     * @param resultHandler Asynchronous result handler
     */
    public void walletFolder(String addr, Handler<AsyncResult<InlineResponse2007>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'addr' is set
        if (addr == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'addr' when calling walletFolder"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v1/wallets/folderName";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "addr", addr));

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] {  };
        TypeReference<InlineResponse2007> localVarReturnType = new TypeReference<InlineResponse2007>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * 
     * Generates new addresses
     * @param id Wallet Id (required)
     * @param num The number you want to generate (optional)
     * @param password Wallet Password (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void walletNewAddress(String id, String num, String password, Handler<AsyncResult<Object>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling walletNewAddress"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v1/wallet/newAddress";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "id", id));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "num", num));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "password", password));

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] { "csrfAuth" };
        TypeReference<Object> localVarReturnType = new TypeReference<Object>() {};
        apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * 
     * Returns the wallet directory path
     * @param entropy Entropy bitSize. (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void walletNewSeed(String entropy, Handler<AsyncResult<Object>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v1/wallet/newSeed";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "entropy", entropy));

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] {  };
        TypeReference<Object> localVarReturnType = new TypeReference<Object>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * Recovers an encrypted wallet by providing the seed. The first address will be generated from seed and compared to the first address of the specified wallet. If they match, the wallet will be regenerated with an optional password. If the wallet is not encrypted, an error is returned.
     * Recovers an encrypted wallet by providing the wallet seed and optional seed passphrase
     * @param id Wallet id. (required)
     * @param seed Wallet seed. (required)
     * @param seedPassphrase Wallet seed-passphrase. (optional)
     * @param password Wallet password. (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void walletRecover(String id, String seed, String seedPassphrase, String password, Handler<AsyncResult<Object>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling walletRecover"));
            return;
        }
        
        // verify the required parameter 'seed' is set
        if (seed == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'seed' when calling walletRecover"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v2/wallet/recover";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        if (id != null)
        localVarHeaderParams.add("id", apiClient.parameterToString(id));
if (seed != null)
        localVarHeaderParams.add("seed", apiClient.parameterToString(seed));
if (seedPassphrase != null)
        localVarHeaderParams.add("seed-passphrase", apiClient.parameterToString(seedPassphrase));
if (password != null)
        localVarHeaderParams.add("password", apiClient.parameterToString(password));

        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] { "csrfAuth" };
        TypeReference<Object> localVarReturnType = new TypeReference<Object>() {};
        apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * This endpoint only works for encrypted wallets. If the wallet is unencrypted, The seed will be not returned.
     * 
     * @param id Wallet Id. (required)
     * @param password Wallet password. (required)
     * @param resultHandler Asynchronous result handler
     */
    public void walletSeed(String id, String password, Handler<AsyncResult<Object>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling walletSeed"));
            return;
        }
        
        // verify the required parameter 'password' is set
        if (password == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'password' when calling walletSeed"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v1/wallet/seed";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "id", id));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "password", password));

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] { "csrfAuth" };
        TypeReference<Object> localVarReturnType = new TypeReference<Object>() {};
        apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * Verifies a wallet seed.
     * 
     * @param seed Seed to be verified. (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void walletSeedVerify(String seed, Handler<AsyncResult<Object>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v2/wallet/seed/verify";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        if (seed != null)
        localVarHeaderParams.add("seed", apiClient.parameterToString(seed));

        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] { "csrfAuth" };
        TypeReference<Object> localVarReturnType = new TypeReference<Object>() {};
        apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * Creates a signed transaction
     * 
     * @param walletTransactionRequest  (required)
     * @param resultHandler Asynchronous result handler
     */
    public void walletTransaction(WalletTransactionRequest walletTransactionRequest, Handler<AsyncResult<Object>> resultHandler) {
        Object localVarBody = walletTransactionRequest;
        
        // verify the required parameter 'walletTransactionRequest' is set
        if (walletTransactionRequest == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'walletTransactionRequest' when calling walletTransaction"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v1/wallet/transaction";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = { "application/json" };
        String[] localVarAuthNames = new String[] { "csrfAuth" };
        TypeReference<Object> localVarReturnType = new TypeReference<Object>() {};
        apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * Creates a signed transaction
     * 
     * @param walletTransactionSignRequest  (required)
     * @param resultHandler Asynchronous result handler
     */
    public void walletTransactionSign(WalletTransactionSignRequest walletTransactionSignRequest, Handler<AsyncResult<InlineResponse2009>> resultHandler) {
        Object localVarBody = walletTransactionSignRequest;
        
        // verify the required parameter 'walletTransactionSignRequest' is set
        if (walletTransactionSignRequest == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'walletTransactionSignRequest' when calling walletTransactionSign"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v2/wallet/transaction/sign";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = { "application/json" };
        String[] localVarAuthNames = new String[] { "csrfAuth" };
        TypeReference<InlineResponse2009> localVarReturnType = new TypeReference<InlineResponse2009>() {};
        apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * 
     * 
     * @param id Wallet Id. (required)
     * @param resultHandler Asynchronous result handler
     */
    public void walletTransactions(String id, Handler<AsyncResult<InlineResponse2006>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling walletTransactions"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v1/wallet/transactions";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "id", id));

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] {  };
        TypeReference<InlineResponse2006> localVarReturnType = new TypeReference<InlineResponse2006>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * Unloads wallet from the wallet service.
     * 
     * @param id Wallet Id. (required)
     * @param resultHandler Asynchronous result handler
     */
    public void walletUnload(String id, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling walletUnload"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v1/wallet/unload";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "id", id));

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml" };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] { "csrfAuth" };

        apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, null, resultHandler);
    }
    /**
     * Update the wallet.
     * 
     * @param id Wallet Id. (required)
     * @param label The label the wallet will be updated to. (required)
     * @param resultHandler Asynchronous result handler
     */
    public void walletUpdate(String id, String label, Handler<AsyncResult<String>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling walletUpdate"));
            return;
        }
        
        // verify the required parameter 'label' is set
        if (label == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'label' when calling walletUpdate"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v1/wallet/update";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        if (id != null)
        localVarHeaderParams.add("id", apiClient.parameterToString(id));
if (label != null)
        localVarHeaderParams.add("label", apiClient.parameterToString(label));

        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "text/plain", "application/json", "application/xml" };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] { "csrfAuth" };
        TypeReference<String> localVarReturnType = new TypeReference<String>() {};
        apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * 
     * Returns all loaded wallets
     * @param resultHandler Asynchronous result handler
     */
    public void wallets(Handler<AsyncResult<List<Object>>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v1/wallets";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/json", "application/xml",  };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] {  };
        TypeReference<List<Object>> localVarReturnType = new TypeReference<List<Object>>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
}
