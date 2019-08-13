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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-08-06T00:13:07.983-04:00[America/Havana]")
@Component("org.openapitools.client.api.DefaultApi")
public class DefaultApi {
    private ApiClient apiClient;

    public DefaultApi() {
        this(new ApiClient());
    }

    @Autowired
    public DefaultApi(ApiClient apiClient) {
        this.apiClient = apiClient;
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
     * <p><b>200</b> - addressCount response object
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @return InlineResponse200
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public InlineResponse200 addressCount() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/api/v1/addresscount").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<InlineResponse200> returnType = new ParameterizedTypeReference<InlineResponse200>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
     * Returns the historical, spent outputs associated with an address
     * <p><b>200</b> - Return address uxouts
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @param address address to filter by
     * @return List&lt;Object&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Object> addressUxouts(String address) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'address' is set
        if (address == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'address' when calling addressUxouts");
        }
        
        String path = UriComponentsBuilder.fromPath("/api/v1/address_uxouts").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "address", address));

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<List<Object>> returnType = new ParameterizedTypeReference<List<Object>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - Response is araw transaction by id
     * @return String
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public String apiV1RawtxGet() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/api/v1/rawtx").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<String> returnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - Metrics
     * @return String
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public String apiV2MetricsGet() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/api/v2/metrics").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<String> returnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
     * 
     * <p><b>200</b> - Returns the balance of one or more addresses
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @param addrs command separated list of addresses
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object balanceGet(String addrs) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'addrs' is set
        if (addrs == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'addrs' when calling balanceGet");
        }
        
        String path = UriComponentsBuilder.fromPath("/api/v1/balance").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "addrs", addrs));

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
     * 
     * <p><b>200</b> - Returns the balance of one or more addresses
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @param addrs command separated list of addresses
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object balancePost(String addrs) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'addrs' is set
        if (addrs == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'addrs' when calling balancePost");
        }
        
        String path = UriComponentsBuilder.fromPath("/api/v1/balance").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "addrs", addrs));

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "csrfAuth" };

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
     * 
     * <p><b>200</b> - Return block Array
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @param hash get block by hash
     * @param seq get block by sequence number
     * @return List&lt;BlockSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<BlockSchema> block(String hash, Integer seq) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/api/v1/block").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "hash", hash));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "seq", seq));

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<List<BlockSchema>> returnType = new ParameterizedTypeReference<List<BlockSchema>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Returns the blockchain metadata.
     * 
     * <p><b>200</b> - This endpoint returns the blockchain metadata.
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object blockchainMetadata() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/api/v1/blockchain/metadata").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Returns the blockchain sync progress.
     * 
     * <p><b>200</b> - This endpoint returns the blockchain sync progress
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object blockchainProgress() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/api/v1/blockchain/progress").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
     * 
     * <p><b>200</b> - Get blocks in specific range
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @param start start seq
     * @param end end seq
     * @param seq comma-separated list of block seqs
     * @return InlineResponse2001
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public InlineResponse2001 blocks(Integer start, Integer end, List<Integer> seq) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/api/v1/blocks").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "start", start));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "end", end));
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)), "seq", seq));

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<InlineResponse2001> returnType = new ParameterizedTypeReference<InlineResponse2001>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
     * coinSupplyHandler returns coin distribution supply stats
     * <p><b>200</b> - CoinSupply records the coin supply info.
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @return InlineResponse2002
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public InlineResponse2002 coinSupply() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/api/v1/coinSupply").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<InlineResponse2002> returnType = new ParameterizedTypeReference<InlineResponse2002>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Creates a new CSRF token. Previous CSRF tokens are invalidated by this call.
     * 
     * <p><b>200</b> - Return a csrf Token.
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @return InlineResponse2003
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public InlineResponse2003 csrf() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/api/v1/csrf").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<InlineResponse2003> returnType = new ParameterizedTypeReference<InlineResponse2003>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - This endpoint returns empty json
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @param type storage type.
     * @param key key of the specific value to get.
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void dataDELETE(String type, String key) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/api/v2/data").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        if (type != null)
        headerParams.add("type", apiClient.parameterToString(type));
        if (key != null)
        headerParams.add("key", apiClient.parameterToString(key));

        final String[] accepts = { 
            "application/json", "application/xml"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - Return multiKey
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @param type storage type.
     * @param key key of the specific value to get.
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object dataGET(String type, String key) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/api/v2/data").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        if (type != null)
        headerParams.add("type", apiClient.parameterToString(type));
        if (key != null)
        headerParams.add("key", apiClient.parameterToString(key));

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - This endpoint returns empty json
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @param type storage type.
     * @param key key of the specific value to get.
     * @param val additional value.
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void dataPOST(String type, String key, String val) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/api/v2/data").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        if (type != null)
        headerParams.add("type", apiClient.parameterToString(type));
        if (key != null)
        headerParams.add("key", apiClient.parameterToString(key));
        if (val != null)
        headerParams.add("val", apiClient.parameterToString(val));

        final String[] accepts = { 
            "application/json", "application/xml"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * defaultConnectionsHandler returns the list of default hardcoded bootstrap addresses.\\n They are not necessarily connected to.
     * 
     * <p><b>200</b> - This endpoint return an list of default connections.
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @return List&lt;String&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<String> defaultConnections() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/api/v1/network/defaultConnections").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<List<String>> returnType = new ParameterizedTypeReference<List<String>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Returns node health data.
     * 
     * <p><b>200</b> - This endpoint returns node health data.
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object health() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/api/v1/health").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
     * Returns the most recent N blocks on the blockchain
     * <p><b>200</b> - Returns the most recent N blocks on the blockchain
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @param num Num of blockss
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object lastBlocks(Integer num) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'num' is set
        if (num == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'num' when calling lastBlocks");
        }
        
        String path = UriComponentsBuilder.fromPath("/api/v1/last_blocks").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "num", num));

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * This endpoint returns a specific connection.
     * 
     * <p><b>200</b> - This endpoint return a connection struct
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @param addr Address port
     * @return NetworkConnectionSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public NetworkConnectionSchema networkConnection(String addr) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'addr' is set
        if (addr == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'addr' when calling networkConnection");
        }
        
        String path = UriComponentsBuilder.fromPath("/api/v1/network/connection").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "addr", addr));

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<NetworkConnectionSchema> returnType = new ParameterizedTypeReference<NetworkConnectionSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * This endpoint returns all outgoings connections.
     * 
     * <p><b>200</b> - This endpoint return networks connections
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @param states Connection status.
     * @param direction Direction of the connection.
     * @return InlineResponse2004
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public InlineResponse2004 networkConnections(String states, String direction) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/api/v1/network/connections").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "states", states));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "direction", direction));

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "csrfAuth" };

        ParameterizedTypeReference<InlineResponse2004> returnType = new ParameterizedTypeReference<InlineResponse2004>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
     * This endpoint disconnects a connection by ID or address
     * <p><b>200</b> - This endpoint
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @param id Address id.
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void networkConnectionsDisconnect(String id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling networkConnectionsDisconnect");
        }
        
        String path = UriComponentsBuilder.fromPath("/api/v1/network/connection/disconnect").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "id", id));

        final String[] accepts = { 
            "application/json", "application/xml"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "csrfAuth" };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
     * This endpoint returns all connections found through peer exchange
     * <p><b>200</b> - This endpoint return a list of all connections found through peer exchange.
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @return List&lt;String&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<String> networkConnectionsExchange() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/api/v1/network/connections/exchange").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<List<String>> returnType = new ParameterizedTypeReference<List<String>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * trustConnectionsHandler returns all trusted connections.\\n They are not necessarily connected to. In the default configuration, these will be a subset of the default hardcoded bootstrap addresses.
     * 
     * <p><b>200</b> - This endpoint return a list of trusted connections.
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @return List&lt;String&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<String> networkConnectionsTrust() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/api/v1/network/connections/trust").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<List<String>> returnType = new ParameterizedTypeReference<List<String>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * If neither addrs nor hashes are specificed, return all unspent outputs. If only one filter is specified, then return outputs match the filter. Both filters cannot be specified.
     * 
     * <p><b>200</b> - UnspentOutputsSummary records unspent outputs in different status.
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @param address The address parameter
     * @param hash The hash parameter
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object outputsGet(List<String> address, List<String> hash) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/api/v1/outputs").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)), "address", address));
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)), "hash", hash));

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * If neither addrs nor hashes are specificed, return all unspent outputs. If only one filter is specified, then return outputs match the filter. Both filters cannot be specified.
     * 
     * <p><b>200</b> - UnspentOutputsSummary records unspent outputs in different status.
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @param address The address parameter
     * @param hash The hash parameter
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object outputsPost(String address, String hash) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/api/v1/outputs").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "address", address));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "hash", hash));

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "csrfAuth" };

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - Transaction inputs include the owner address, coins, hours and calculated hours.
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @return List&lt;InlineResponse20010&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<InlineResponse20010> pendingTxs() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/api/v1/pendingTxs").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<List<InlineResponse20010>> returnType = new ParameterizedTypeReference<List<InlineResponse20010>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
     * Broadcasts all unconfirmed transactions from the unconfirmed transaction pool
     * <p><b>200</b> - OK, Broadcasts all unconfirmed transactions from the unconfirmed transaction pool
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object resendUnconfirmedTxns() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/api/v1/resendUnconfirmedTxns").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application-json", "application/json", "application/xml"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "csrfAuth" };

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Returns the top skycoin holders.
     * 
     * <p><b>200</b> - Represent richlist response
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @param includeDistribution include distribution addresses or not, default value false
     * @param n include distribution addresses or not, default value false
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object richlist(Boolean includeDistribution, String n) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/api/v1/richlist").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "include-distribution", includeDistribution));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "n", n));

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
     * Returns a transaction identified by its txid hash with just id
     * <p><b>200</b> - Returns a transaction identified by its txid hash.
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @param txid transaction Id
     * @return Transaction
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Transaction transaction(String txid) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'txid' is set
        if (txid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'txid' when calling transaction");
        }
        
        String path = UriComponentsBuilder.fromPath("/api/v1/transaction").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "txid", txid));

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Transaction> returnType = new ParameterizedTypeReference<Transaction>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Broadcast a hex-encoded, serialized transaction to the network.
     * 
     * <p><b>200</b> - Broadcasts a hex-encoded, serialized transaction to the network
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @param rawtx hex-encoded serialized transaction string.
     * @param noBroadcast Disable the network broadcast
     * @return String
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public String transactionInject(String rawtx, Boolean noBroadcast) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'rawtx' is set
        if (rawtx == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'rawtx' when calling transactionInject");
        }
        
        String path = UriComponentsBuilder.fromPath("/api/v1/injectTransaction").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        if (rawtx != null)
        headerParams.add("rawtx", apiClient.parameterToString(rawtx));
        if (noBroadcast != null)
        headerParams.add("no_broadcast", apiClient.parameterToString(noBroadcast));

        final String[] accepts = { 
            "text/plain", "application/json", "application/xml"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "csrfAuth" };

        ParameterizedTypeReference<String> returnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - Response is a transaction
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @param transactionV2ParamsAddress The transactionV2ParamsAddress parameter
     * @return InlineResponse2008
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public InlineResponse2008 transactionPost(TransactionV2ParamsAddress transactionV2ParamsAddress) throws RestClientException {
        Object postBody = transactionV2ParamsAddress;
        
        String path = UriComponentsBuilder.fromPath("/api/v2/transaction").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "csrfAuth" };

        ParameterizedTypeReference<InlineResponse2008> returnType = new ParameterizedTypeReference<InlineResponse2008>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - Response is a transaction
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @param transactionV2ParamsUnspent Unspent parameters
     * @return InlineResponse2008
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public InlineResponse2008 transactionPostUnspent(TransactionV2ParamsUnspent transactionV2ParamsUnspent) throws RestClientException {
        Object postBody = transactionV2ParamsUnspent;
        
        // verify the required parameter 'transactionV2ParamsUnspent' is set
        if (transactionV2ParamsUnspent == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'transactionV2ParamsUnspent' when calling transactionPostUnspent");
        }
        
        String path = UriComponentsBuilder.fromPath("/api/v2/transaction/unspent").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "csrfAuth" };

        ParameterizedTypeReference<InlineResponse2008> returnType = new ParameterizedTypeReference<InlineResponse2008>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Returns the hex-encoded byte serialization of a transaction. The transaction may be confirmed or unconfirmed.
     * 
     * <p><b>200</b> - Returns the hex-encoded byte serialization of a transaction
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @param txid Transaction id hash
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object transactionRaw(String txid) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/api/v2/transaction/raw").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "txid", txid));

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
     * Decode and verify an encoded transaction
     * <p><b>200</b> - Responses ok
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @param transactionVerifyRequest The transactionVerifyRequest parameter
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object transactionVerify(TransactionVerifyRequest transactionVerifyRequest) throws RestClientException {
        Object postBody = transactionVerifyRequest;
        
        // verify the required parameter 'transactionVerifyRequest' is set
        if (transactionVerifyRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'transactionVerifyRequest' when calling transactionVerify");
        }
        
        String path = UriComponentsBuilder.fromPath("/api/v2/transaction/verify").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "csrfAuth" };

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Returns transactions that match the filters.
     * 
     * <p><b>200</b> - Returns transactions that match the filters.
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @param addrs command separated list of addresses
     * @param confirmed Whether the transactions should be confirmed [optional, must be 0 or 1; if not provided, returns all]
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object transactionsGet(String addrs, String confirmed) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/api/v1/transactions").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "addrs", addrs));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "confirmed", confirmed));

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Returns transactions that match the filters.
     * 
     * <p><b>200</b> - Returns transactions that match the filters.
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @param addrs command separated list of addresses
     * @param confirmed Whether the transactions should be confirmed [optional, must be 0 or 1; if not provided, returns all]
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object transactionsPost(String addrs, String confirmed) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/api/v1/transactions").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "addrs", addrs));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "confirmed", confirmed));

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "csrfAuth" };

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Returns an unspent output by ID.
     * 
     * <p><b>200</b> - Response for endpoint /api/v1/uxout
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @param uxid uxid to filter by
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object uxout(String uxid) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/api/v1/uxout").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "uxid", uxid));

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Verifies a Skycoin address.
     * 
     * <p><b>200</b>
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @param address Address id.
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object verifyAddress(Address address) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'address' is set
        if (address == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'address' when calling verifyAddress");
        }
        
        String path = UriComponentsBuilder.fromPath("/api/v2/address/verify").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "address", address));

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "csrfAuth" };

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
     * versionHandler returns the application version info
     * <p><b>200</b> - BuildInfo represents the build info
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @return InlineResponse2005
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public InlineResponse2005 version() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/api/v1/version").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<InlineResponse2005> returnType = new ParameterizedTypeReference<InlineResponse2005>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Returns a wallet by id.
     * 
     * <p><b>200</b> - Response for endpoint /api/v1/wallet
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @param id tags to filter by
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object wallet(String id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling wallet");
        }
        
        String path = UriComponentsBuilder.fromPath("/api/v1/wallet").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "id", id));

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Returns the wallet&#39;s balance, both confirmed and predicted.  The predicted balance is the confirmed balance minus the pending spends.
     * 
     * <p><b>200</b> - Returns the wallets balance
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @param id tags to filter by
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object walletBalance(String id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling walletBalance");
        }
        
        String path = UriComponentsBuilder.fromPath("/api/v1/wallet/balance").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "id", id));

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
     * Create a wallet
     * <p><b>200</b> - Response for endpoint /api/v1/wallet
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @param type wallet seed passphrase [optional, bip44 type wallet only]
     * @param seed Wallet seed.
     * @param label Wallet label.
     * @param seedPassphrase wallet seed passphrase [optional, bip44 type wallet only]
     * @param bip44Coin BIP44 coin type [optional, defaults to 8000 (skycoin&#39;s coin type), only valid if type is \&quot;bip44\&quot;]
     * @param xpub xpub key [required for xpub wallets]
     * @param scan The number of addresses to scan ahead for balances.
     * @param encrypt Encrypt wallet.
     * @param password Wallet Password
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object walletCreate(String type, String seed, String label, String seedPassphrase, String bip44Coin, String xpub, Integer scan, Boolean encrypt, String password) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'type' is set
        if (type == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'type' when calling walletCreate");
        }
        
        // verify the required parameter 'seed' is set
        if (seed == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'seed' when calling walletCreate");
        }
        
        // verify the required parameter 'label' is set
        if (label == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'label' when calling walletCreate");
        }
        
        String path = UriComponentsBuilder.fromPath("/api/v1/wallet/create").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        if (seedPassphrase != null)
        headerParams.add("seed-passphrase", apiClient.parameterToString(seedPassphrase));
        if (type != null)
        headerParams.add("type", apiClient.parameterToString(type));
        if (bip44Coin != null)
        headerParams.add("bip44-coin", apiClient.parameterToString(bip44Coin));
        if (seed != null)
        headerParams.add("seed", apiClient.parameterToString(seed));
        if (xpub != null)
        headerParams.add("xpub", apiClient.parameterToString(xpub));
        if (label != null)
        headerParams.add("label", apiClient.parameterToString(label));
        if (scan != null)
        headerParams.add("scan", apiClient.parameterToString(scan));
        if (encrypt != null)
        headerParams.add("encrypt", apiClient.parameterToString(encrypt));
        if (password != null)
        headerParams.add("password", apiClient.parameterToString(password));

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "csrfAuth" };

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Decrypts wallet.
     * 
     * <p><b>200</b> - This endpoint decrypts wallets.
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @param id Wallet id.
     * @param password Wallet password.
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object walletDecrypt(String id, String password) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling walletDecrypt");
        }
        
        // verify the required parameter 'password' is set
        if (password == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'password' when calling walletDecrypt");
        }
        
        String path = UriComponentsBuilder.fromPath("/api/v1/wallet/decrypt").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        if (id != null)
        headerParams.add("id", apiClient.parameterToString(id));
        if (password != null)
        headerParams.add("password", apiClient.parameterToString(password));

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "csrfAuth" };

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Encrypt wallet.
     * 
     * <p><b>200</b> - This endpoint encrypt wallets.
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @param id Wallet id.
     * @param password Wallet password.
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object walletEncrypt(String id, String password) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling walletEncrypt");
        }
        
        // verify the required parameter 'password' is set
        if (password == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'password' when calling walletEncrypt");
        }
        
        String path = UriComponentsBuilder.fromPath("/api/v1/wallet/encrypt").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        if (id != null)
        headerParams.add("id", apiClient.parameterToString(id));
        if (password != null)
        headerParams.add("password", apiClient.parameterToString(password));

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "csrfAuth" };

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
     * Returns the wallet directory path
     * <p><b>200</b> - This endpoint return the wallet directory path
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @param addr Address port
     * @return InlineResponse2007
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public InlineResponse2007 walletFolder(String addr) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'addr' is set
        if (addr == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'addr' when calling walletFolder");
        }
        
        String path = UriComponentsBuilder.fromPath("/api/v1/wallets/folderName").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "addr", addr));

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<InlineResponse2007> returnType = new ParameterizedTypeReference<InlineResponse2007>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
     * Generates new addresses
     * <p><b>200</b> - This endpoint generate new addresses
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @param id Wallet Id
     * @param num The number you want to generate
     * @param password Wallet Password
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object walletNewAddress(String id, String num, String password) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling walletNewAddress");
        }
        
        String path = UriComponentsBuilder.fromPath("/api/v1/wallet/newAddress").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "id", id));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "num", num));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "password", password));

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "csrfAuth" };

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
     * Returns the wallet directory path
     * <p><b>200</b> - Generates wallet seed
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @param entropy Entropy bitSize.
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object walletNewSeed(String entropy) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/api/v1/wallet/newSeed").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "entropy", entropy));

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Recovers an encrypted wallet by providing the seed. The first address will be generated from seed and compared to the first address of the specified wallet. If they match, the wallet will be regenerated with an optional password. If the wallet is not encrypted, an error is returned.
     * Recovers an encrypted wallet by providing the wallet seed and optional seed passphrase
     * <p><b>200</b> - This endpoint recover wallets.
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @param id Wallet id.
     * @param seed Wallet seed.
     * @param seedPassphrase Wallet seed-passphrase.
     * @param password Wallet password.
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object walletRecover(String id, String seed, String seedPassphrase, String password) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling walletRecover");
        }
        
        // verify the required parameter 'seed' is set
        if (seed == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'seed' when calling walletRecover");
        }
        
        String path = UriComponentsBuilder.fromPath("/api/v2/wallet/recover").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        if (id != null)
        headerParams.add("id", apiClient.parameterToString(id));
        if (seed != null)
        headerParams.add("seed", apiClient.parameterToString(seed));
        if (seedPassphrase != null)
        headerParams.add("seed-passphrase", apiClient.parameterToString(seedPassphrase));
        if (password != null)
        headerParams.add("password", apiClient.parameterToString(password));

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "csrfAuth" };

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * This endpoint only works for encrypted wallets. If the wallet is unencrypted, The seed will be not returned.
     * 
     * <p><b>200</b> - This endpoint Returns seed of wallet of given id
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @param id Wallet Id.
     * @param password Wallet password.
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object walletSeed(String id, String password) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling walletSeed");
        }
        
        // verify the required parameter 'password' is set
        if (password == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'password' when calling walletSeed");
        }
        
        String path = UriComponentsBuilder.fromPath("/api/v1/wallet/seed").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "id", id));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "password", password));

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "csrfAuth" };

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Verifies a wallet seed.
     * 
     * <p><b>200</b> - Verifies a wallet seed.
     * <p><b>422</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @param seed Seed to be verified.
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object walletSeedVerify(String seed) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/api/v2/wallet/seed/verify").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        if (seed != null)
        headerParams.add("seed", apiClient.parameterToString(seed));

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "csrfAuth" };

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Creates a signed transaction
     * 
     * <p><b>200</b> - Returns blocks between a start and end point.
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @param walletTransactionRequest The walletTransactionRequest parameter
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object walletTransaction(WalletTransactionRequest walletTransactionRequest) throws RestClientException {
        Object postBody = walletTransactionRequest;
        
        // verify the required parameter 'walletTransactionRequest' is set
        if (walletTransactionRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'walletTransactionRequest' when calling walletTransaction");
        }
        
        String path = UriComponentsBuilder.fromPath("/api/v1/wallet/transaction").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "csrfAuth" };

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Creates a signed transaction
     * 
     * <p><b>200</b> - Signs an unsigned transaction, returning the transaction with updated signatures and the encoded, serialized transaction.
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @param walletTransactionSignRequest The walletTransactionSignRequest parameter
     * @return InlineResponse2009
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public InlineResponse2009 walletTransactionSign(WalletTransactionSignRequest walletTransactionSignRequest) throws RestClientException {
        Object postBody = walletTransactionSignRequest;
        
        // verify the required parameter 'walletTransactionSignRequest' is set
        if (walletTransactionSignRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'walletTransactionSignRequest' when calling walletTransactionSign");
        }
        
        String path = UriComponentsBuilder.fromPath("/api/v2/wallet/transaction/sign").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "csrfAuth" };

        ParameterizedTypeReference<InlineResponse2009> returnType = new ParameterizedTypeReference<InlineResponse2009>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - This endpoint returns all unconfirmed transactions for all addresses in a given wallet.
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @param id Wallet Id.
     * @return InlineResponse2006
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public InlineResponse2006 walletTransactions(String id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling walletTransactions");
        }
        
        String path = UriComponentsBuilder.fromPath("/api/v1/wallet/transactions").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "id", id));

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<InlineResponse2006> returnType = new ParameterizedTypeReference<InlineResponse2006>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Unloads wallet from the wallet service.
     * 
     * <p><b>200</b> - This endpoint returns nothing.
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @param id Wallet Id.
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void walletUnload(String id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling walletUnload");
        }
        
        String path = UriComponentsBuilder.fromPath("/api/v1/wallet/unload").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "id", id));

        final String[] accepts = { 
            "application/json", "application/xml"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "csrfAuth" };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Update the wallet.
     * 
     * <p><b>200</b> - This endpoint Returns the label the wallet will be updated to .
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @param id Wallet Id.
     * @param label The label the wallet will be updated to.
     * @return String
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public String walletUpdate(String id, String label) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling walletUpdate");
        }
        
        // verify the required parameter 'label' is set
        if (label == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'label' when calling walletUpdate");
        }
        
        String path = UriComponentsBuilder.fromPath("/api/v1/wallet/update").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        if (id != null)
        headerParams.add("id", apiClient.parameterToString(id));
        if (label != null)
        headerParams.add("label", apiClient.parameterToString(label));

        final String[] accepts = { 
            "text/plain", "application/json", "application/xml"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "csrfAuth" };

        ParameterizedTypeReference<String> returnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
     * Returns all loaded wallets
     * <p><b>200</b> - This endpoint return all loaded wallets
     * <p><b>0</b> - A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures.
     * @return List&lt;Object&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Object> wallets() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/api/v1/wallets").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json", "application/xml", 
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<List<Object>> returnType = new ParameterizedTypeReference<List<Object>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
