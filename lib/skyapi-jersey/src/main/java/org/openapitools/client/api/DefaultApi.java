package org.openapitools.client.api;

import org.openapitools.client.ApiException;
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.Configuration;
import org.openapitools.client.Pair;

import javax.ws.rs.core.GenericType;

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

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-07-31T11:01:12.060-04:00[America/Havana]")
public class DefaultApi {
  private ApiClient apiClient;

  public DefaultApi() {
    this(Configuration.getDefaultApiClient());
  }

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
   * @return InlineResponse200
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> addressCount response object </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public InlineResponse200 addressCount() throws ApiException {
    return addressCountWithHttpInfo().getData();
      }

  /**
   * Returns the total number of unique address that have coins.
   * 
   * @return ApiResponse&lt;InlineResponse200&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> addressCount response object </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<InlineResponse200> addressCountWithHttpInfo() throws ApiException {
    Object localVarPostBody = new Object();
    
    // create path and map variables
    String localVarPath = "/api/v1/addresscount";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<InlineResponse200> localVarReturnType = new GenericType<InlineResponse200>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * 
   * Returns the historical, spent outputs associated with an address
   * @param address address to filter by (required)
   * @return List&lt;Object&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Return address uxouts </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public List<Object> addressUxouts(String address) throws ApiException {
    return addressUxoutsWithHttpInfo(address).getData();
      }

  /**
   * 
   * Returns the historical, spent outputs associated with an address
   * @param address address to filter by (required)
   * @return ApiResponse&lt;List&lt;Object&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Return address uxouts </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<Object>> addressUxoutsWithHttpInfo(String address) throws ApiException {
    Object localVarPostBody = new Object();
    
    // verify the required parameter 'address' is set
    if (address == null) {
      throw new ApiException(400, "Missing the required parameter 'address' when calling addressUxouts");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/address_uxouts";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "address", address));

    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<List<Object>> localVarReturnType = new GenericType<List<Object>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * 
   * 
   * @return String
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Response is araw transaction by id </td><td>  -  </td></tr>
     </table>
   */
  public String apiV1RawtxGet() throws ApiException {
    return apiV1RawtxGetWithHttpInfo().getData();
      }

  /**
   * 
   * 
   * @return ApiResponse&lt;String&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Response is araw transaction by id </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<String> apiV1RawtxGetWithHttpInfo() throws ApiException {
    Object localVarPostBody = new Object();
    
    // create path and map variables
    String localVarPath = "/api/v1/rawtx";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "text/plain"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<String> localVarReturnType = new GenericType<String>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * 
   * 
   * @return String
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Metrics </td><td>  -  </td></tr>
     </table>
   */
  public String apiV2MetricsGet() throws ApiException {
    return apiV2MetricsGetWithHttpInfo().getData();
      }

  /**
   * 
   * 
   * @return ApiResponse&lt;String&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Metrics </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<String> apiV2MetricsGetWithHttpInfo() throws ApiException {
    Object localVarPostBody = new Object();
    
    // create path and map variables
    String localVarPath = "/api/v2/metrics";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "text/plain"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<String> localVarReturnType = new GenericType<String>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
   * 
   * @param addrs command separated list of addresses (required)
   * @return Object
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns the balance of one or more addresses </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public Object balanceGet(String addrs) throws ApiException {
    return balanceGetWithHttpInfo(addrs).getData();
      }

  /**
   * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
   * 
   * @param addrs command separated list of addresses (required)
   * @return ApiResponse&lt;Object&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns the balance of one or more addresses </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Object> balanceGetWithHttpInfo(String addrs) throws ApiException {
    Object localVarPostBody = new Object();
    
    // verify the required parameter 'addrs' is set
    if (addrs == null) {
      throw new ApiException(400, "Missing the required parameter 'addrs' when calling balanceGet");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/balance";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "addrs", addrs));

    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<Object> localVarReturnType = new GenericType<Object>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
   * 
   * @param addrs command separated list of addresses (required)
   * @return Object
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns the balance of one or more addresses </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public Object balancePost(String addrs) throws ApiException {
    return balancePostWithHttpInfo(addrs).getData();
      }

  /**
   * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
   * 
   * @param addrs command separated list of addresses (required)
   * @return ApiResponse&lt;Object&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns the balance of one or more addresses </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Object> balancePostWithHttpInfo(String addrs) throws ApiException {
    Object localVarPostBody = new Object();
    
    // verify the required parameter 'addrs' is set
    if (addrs == null) {
      throw new ApiException(400, "Missing the required parameter 'addrs' when calling balancePost");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/balance";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "addrs", addrs));

    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "csrfAuth" };

    GenericType<Object> localVarReturnType = new GenericType<Object>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
   * 
   * @param hash get block by hash (optional)
   * @param seq get block by sequence number (optional)
   * @return List&lt;BlockSchema&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Return block Array </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public List<BlockSchema> block(String hash, Integer seq) throws ApiException {
    return blockWithHttpInfo(hash, seq).getData();
      }

  /**
   * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
   * 
   * @param hash get block by hash (optional)
   * @param seq get block by sequence number (optional)
   * @return ApiResponse&lt;List&lt;BlockSchema&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Return block Array </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<BlockSchema>> blockWithHttpInfo(String hash, Integer seq) throws ApiException {
    Object localVarPostBody = new Object();
    
    // create path and map variables
    String localVarPath = "/api/v1/block";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "hash", hash));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "seq", seq));

    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<List<BlockSchema>> localVarReturnType = new GenericType<List<BlockSchema>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns the blockchain metadata.
   * 
   * @return Object
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint returns the blockchain metadata. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public Object blockchainMetadata() throws ApiException {
    return blockchainMetadataWithHttpInfo().getData();
      }

  /**
   * Returns the blockchain metadata.
   * 
   * @return ApiResponse&lt;Object&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint returns the blockchain metadata. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Object> blockchainMetadataWithHttpInfo() throws ApiException {
    Object localVarPostBody = new Object();
    
    // create path and map variables
    String localVarPath = "/api/v1/blockchain/metadata";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<Object> localVarReturnType = new GenericType<Object>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns the blockchain sync progress.
   * 
   * @return Object
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint returns the blockchain sync progress </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public Object blockchainProgress() throws ApiException {
    return blockchainProgressWithHttpInfo().getData();
      }

  /**
   * Returns the blockchain sync progress.
   * 
   * @return ApiResponse&lt;Object&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint returns the blockchain sync progress </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Object> blockchainProgressWithHttpInfo() throws ApiException {
    Object localVarPostBody = new Object();
    
    // create path and map variables
    String localVarPath = "/api/v1/blockchain/progress";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<Object> localVarReturnType = new GenericType<Object>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
   * 
   * @param start start seq (optional)
   * @param end end seq (optional)
   * @param seq comma-separated list of block seqs (optional, default to new ArrayList&lt;Integer&gt;())
   * @return InlineResponse2001
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Get blocks in specific range </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public InlineResponse2001 blocks(Integer start, Integer end, List<Integer> seq) throws ApiException {
    return blocksWithHttpInfo(start, end, seq).getData();
      }

  /**
   * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
   * 
   * @param start start seq (optional)
   * @param end end seq (optional)
   * @param seq comma-separated list of block seqs (optional, default to new ArrayList&lt;Integer&gt;())
   * @return ApiResponse&lt;InlineResponse2001&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Get blocks in specific range </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<InlineResponse2001> blocksWithHttpInfo(Integer start, Integer end, List<Integer> seq) throws ApiException {
    Object localVarPostBody = new Object();
    
    // create path and map variables
    String localVarPath = "/api/v1/blocks";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "start", start));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "end", end));
    localVarQueryParams.addAll(apiClient.parameterToPairs("multi", "seq", seq));

    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<InlineResponse2001> localVarReturnType = new GenericType<InlineResponse2001>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * 
   * coinSupplyHandler returns coin distribution supply stats
   * @return InlineResponse2002
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> CoinSupply records the coin supply info. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public InlineResponse2002 coinSupply() throws ApiException {
    return coinSupplyWithHttpInfo().getData();
      }

  /**
   * 
   * coinSupplyHandler returns coin distribution supply stats
   * @return ApiResponse&lt;InlineResponse2002&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> CoinSupply records the coin supply info. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<InlineResponse2002> coinSupplyWithHttpInfo() throws ApiException {
    Object localVarPostBody = new Object();
    
    // create path and map variables
    String localVarPath = "/api/v1/coinSupply";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<InlineResponse2002> localVarReturnType = new GenericType<InlineResponse2002>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Creates a new CSRF token. Previous CSRF tokens are invalidated by this call.
   * 
   * @return InlineResponse2003
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Return a csrf Token. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public InlineResponse2003 csrf() throws ApiException {
    return csrfWithHttpInfo().getData();
      }

  /**
   * Creates a new CSRF token. Previous CSRF tokens are invalidated by this call.
   * 
   * @return ApiResponse&lt;InlineResponse2003&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Return a csrf Token. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<InlineResponse2003> csrfWithHttpInfo() throws ApiException {
    Object localVarPostBody = new Object();
    
    // create path and map variables
    String localVarPath = "/api/v1/csrf";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<InlineResponse2003> localVarReturnType = new GenericType<InlineResponse2003>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * 
   * 
   * @param type storage type. (optional)
   * @param key key of the specific value to get. (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint returns empty json </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public void dataDELETE(String type, String key) throws ApiException {

    dataDELETEWithHttpInfo(type, key);
  }

  /**
   * 
   * 
   * @param type storage type. (optional)
   * @param key key of the specific value to get. (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint returns empty json </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> dataDELETEWithHttpInfo(String type, String key) throws ApiException {
    Object localVarPostBody = new Object();
    
    // create path and map variables
    String localVarPath = "/api/v2/data";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    if (type != null)
      localVarHeaderParams.put("type", apiClient.parameterToString(type));
if (key != null)
      localVarHeaderParams.put("key", apiClient.parameterToString(key));

    
    final String[] localVarAccepts = {
      "application/json", "application/xml"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };


    return apiClient.invokeAPI(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * 
   * 
   * @param type storage type. (optional)
   * @param key key of the specific value to get. (optional)
   * @return Object
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Return multiKey </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public Object dataGET(String type, String key) throws ApiException {
    return dataGETWithHttpInfo(type, key).getData();
      }

  /**
   * 
   * 
   * @param type storage type. (optional)
   * @param key key of the specific value to get. (optional)
   * @return ApiResponse&lt;Object&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Return multiKey </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Object> dataGETWithHttpInfo(String type, String key) throws ApiException {
    Object localVarPostBody = new Object();
    
    // create path and map variables
    String localVarPath = "/api/v2/data";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    if (type != null)
      localVarHeaderParams.put("type", apiClient.parameterToString(type));
if (key != null)
      localVarHeaderParams.put("key", apiClient.parameterToString(key));

    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<Object> localVarReturnType = new GenericType<Object>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * 
   * 
   * @param type storage type. (optional)
   * @param key key of the specific value to get. (optional)
   * @param val additional value. (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint returns empty json </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public void dataPOST(String type, String key, String val) throws ApiException {

    dataPOSTWithHttpInfo(type, key, val);
  }

  /**
   * 
   * 
   * @param type storage type. (optional)
   * @param key key of the specific value to get. (optional)
   * @param val additional value. (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint returns empty json </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> dataPOSTWithHttpInfo(String type, String key, String val) throws ApiException {
    Object localVarPostBody = new Object();
    
    // create path and map variables
    String localVarPath = "/api/v2/data";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    if (type != null)
      localVarHeaderParams.put("type", apiClient.parameterToString(type));
if (key != null)
      localVarHeaderParams.put("key", apiClient.parameterToString(key));
if (val != null)
      localVarHeaderParams.put("val", apiClient.parameterToString(val));

    
    final String[] localVarAccepts = {
      "application/json", "application/xml"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };


    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * defaultConnectionsHandler returns the list of default hardcoded bootstrap addresses.\\n They are not necessarily connected to.
   * 
   * @return List&lt;String&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint return an list of default connections. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public List<String> defaultConnections() throws ApiException {
    return defaultConnectionsWithHttpInfo().getData();
      }

  /**
   * defaultConnectionsHandler returns the list of default hardcoded bootstrap addresses.\\n They are not necessarily connected to.
   * 
   * @return ApiResponse&lt;List&lt;String&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint return an list of default connections. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<String>> defaultConnectionsWithHttpInfo() throws ApiException {
    Object localVarPostBody = new Object();
    
    // create path and map variables
    String localVarPath = "/api/v1/network/defaultConnections";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<List<String>> localVarReturnType = new GenericType<List<String>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns node health data.
   * 
   * @return Object
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint returns node health data. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public Object health() throws ApiException {
    return healthWithHttpInfo().getData();
      }

  /**
   * Returns node health data.
   * 
   * @return ApiResponse&lt;Object&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint returns node health data. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Object> healthWithHttpInfo() throws ApiException {
    Object localVarPostBody = new Object();
    
    // create path and map variables
    String localVarPath = "/api/v1/health";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<Object> localVarReturnType = new GenericType<Object>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * 
   * Returns the most recent N blocks on the blockchain
   * @param num Num of blockss (required)
   * @return Object
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns the most recent N blocks on the blockchain </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public Object lastBlocks(Integer num) throws ApiException {
    return lastBlocksWithHttpInfo(num).getData();
      }

  /**
   * 
   * Returns the most recent N blocks on the blockchain
   * @param num Num of blockss (required)
   * @return ApiResponse&lt;Object&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns the most recent N blocks on the blockchain </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Object> lastBlocksWithHttpInfo(Integer num) throws ApiException {
    Object localVarPostBody = new Object();
    
    // verify the required parameter 'num' is set
    if (num == null) {
      throw new ApiException(400, "Missing the required parameter 'num' when calling lastBlocks");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/last_blocks";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "num", num));

    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<Object> localVarReturnType = new GenericType<Object>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * This endpoint returns a specific connection.
   * 
   * @param addr Address port (required)
   * @return NetworkConnectionSchema
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint return a connection struct </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public NetworkConnectionSchema networkConnection(String addr) throws ApiException {
    return networkConnectionWithHttpInfo(addr).getData();
      }

  /**
   * This endpoint returns a specific connection.
   * 
   * @param addr Address port (required)
   * @return ApiResponse&lt;NetworkConnectionSchema&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint return a connection struct </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<NetworkConnectionSchema> networkConnectionWithHttpInfo(String addr) throws ApiException {
    Object localVarPostBody = new Object();
    
    // verify the required parameter 'addr' is set
    if (addr == null) {
      throw new ApiException(400, "Missing the required parameter 'addr' when calling networkConnection");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/network/connection";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "addr", addr));

    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<NetworkConnectionSchema> localVarReturnType = new GenericType<NetworkConnectionSchema>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * This endpoint returns all outgoings connections.
   * 
   * @param states Connection status. (optional)
   * @param direction Direction of the connection. (optional)
   * @return InlineResponse2004
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint return networks connections </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public InlineResponse2004 networkConnections(String states, String direction) throws ApiException {
    return networkConnectionsWithHttpInfo(states, direction).getData();
      }

  /**
   * This endpoint returns all outgoings connections.
   * 
   * @param states Connection status. (optional)
   * @param direction Direction of the connection. (optional)
   * @return ApiResponse&lt;InlineResponse2004&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint return networks connections </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<InlineResponse2004> networkConnectionsWithHttpInfo(String states, String direction) throws ApiException {
    Object localVarPostBody = new Object();
    
    // create path and map variables
    String localVarPath = "/api/v1/network/connections";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "states", states));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "direction", direction));

    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "csrfAuth" };

    GenericType<InlineResponse2004> localVarReturnType = new GenericType<InlineResponse2004>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * 
   * This endpoint disconnects a connection by ID or address
   * @param id Address id. (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public void networkConnectionsDisconnect(String id) throws ApiException {

    networkConnectionsDisconnectWithHttpInfo(id);
  }

  /**
   * 
   * This endpoint disconnects a connection by ID or address
   * @param id Address id. (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> networkConnectionsDisconnectWithHttpInfo(String id) throws ApiException {
    Object localVarPostBody = new Object();
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling networkConnectionsDisconnect");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/network/connection/disconnect";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "id", id));

    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "csrfAuth" };


    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * 
   * This endpoint returns all connections found through peer exchange
   * @return List&lt;String&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint return a list of all connections found through peer exchange. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public List<String> networkConnectionsExchange() throws ApiException {
    return networkConnectionsExchangeWithHttpInfo().getData();
      }

  /**
   * 
   * This endpoint returns all connections found through peer exchange
   * @return ApiResponse&lt;List&lt;String&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint return a list of all connections found through peer exchange. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<String>> networkConnectionsExchangeWithHttpInfo() throws ApiException {
    Object localVarPostBody = new Object();
    
    // create path and map variables
    String localVarPath = "/api/v1/network/connections/exchange";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<List<String>> localVarReturnType = new GenericType<List<String>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * trustConnectionsHandler returns all trusted connections.\\n They are not necessarily connected to. In the default configuration, these will be a subset of the default hardcoded bootstrap addresses.
   * 
   * @return List&lt;String&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint return a list of trusted connections. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public List<String> networkConnectionsTrust() throws ApiException {
    return networkConnectionsTrustWithHttpInfo().getData();
      }

  /**
   * trustConnectionsHandler returns all trusted connections.\\n They are not necessarily connected to. In the default configuration, these will be a subset of the default hardcoded bootstrap addresses.
   * 
   * @return ApiResponse&lt;List&lt;String&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint return a list of trusted connections. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<String>> networkConnectionsTrustWithHttpInfo() throws ApiException {
    Object localVarPostBody = new Object();
    
    // create path and map variables
    String localVarPath = "/api/v1/network/connections/trust";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<List<String>> localVarReturnType = new GenericType<List<String>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * If neither addrs nor hashes are specificed, return all unspent outputs. If only one filter is specified, then return outputs match the filter. Both filters cannot be specified.
   * 
   * @param address  (optional, default to new ArrayList&lt;String&gt;())
   * @param hash  (optional, default to new ArrayList&lt;String&gt;())
   * @return Object
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> UnspentOutputsSummary records unspent outputs in different status. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public Object outputsGet(List<String> address, List<String> hash) throws ApiException {
    return outputsGetWithHttpInfo(address, hash).getData();
      }

  /**
   * If neither addrs nor hashes are specificed, return all unspent outputs. If only one filter is specified, then return outputs match the filter. Both filters cannot be specified.
   * 
   * @param address  (optional, default to new ArrayList&lt;String&gt;())
   * @param hash  (optional, default to new ArrayList&lt;String&gt;())
   * @return ApiResponse&lt;Object&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> UnspentOutputsSummary records unspent outputs in different status. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Object> outputsGetWithHttpInfo(List<String> address, List<String> hash) throws ApiException {
    Object localVarPostBody = new Object();
    
    // create path and map variables
    String localVarPath = "/api/v1/outputs";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("multi", "address", address));
    localVarQueryParams.addAll(apiClient.parameterToPairs("multi", "hash", hash));

    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<Object> localVarReturnType = new GenericType<Object>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * If neither addrs nor hashes are specificed, return all unspent outputs. If only one filter is specified, then return outputs match the filter. Both filters cannot be specified.
   * 
   * @param address  (optional)
   * @param hash  (optional)
   * @return Object
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> UnspentOutputsSummary records unspent outputs in different status. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public Object outputsPost(String address, String hash) throws ApiException {
    return outputsPostWithHttpInfo(address, hash).getData();
      }

  /**
   * If neither addrs nor hashes are specificed, return all unspent outputs. If only one filter is specified, then return outputs match the filter. Both filters cannot be specified.
   * 
   * @param address  (optional)
   * @param hash  (optional)
   * @return ApiResponse&lt;Object&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> UnspentOutputsSummary records unspent outputs in different status. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Object> outputsPostWithHttpInfo(String address, String hash) throws ApiException {
    Object localVarPostBody = new Object();
    
    // create path and map variables
    String localVarPath = "/api/v1/outputs";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "address", address));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "hash", hash));

    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "csrfAuth" };

    GenericType<Object> localVarReturnType = new GenericType<Object>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * 
   * 
   * @return List&lt;InlineResponse20010&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Transaction inputs include the owner address, coins, hours and calculated hours. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public List<InlineResponse20010> pendingTxs() throws ApiException {
    return pendingTxsWithHttpInfo().getData();
      }

  /**
   * 
   * 
   * @return ApiResponse&lt;List&lt;InlineResponse20010&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Transaction inputs include the owner address, coins, hours and calculated hours. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<InlineResponse20010>> pendingTxsWithHttpInfo() throws ApiException {
    Object localVarPostBody = new Object();
    
    // create path and map variables
    String localVarPath = "/api/v1/pendingTxs";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<List<InlineResponse20010>> localVarReturnType = new GenericType<List<InlineResponse20010>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * 
   * Broadcasts all unconfirmed transactions from the unconfirmed transaction pool
   * @return Object
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK, Broadcasts all unconfirmed transactions from the unconfirmed transaction pool </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public Object resendUnconfirmedTxns() throws ApiException {
    return resendUnconfirmedTxnsWithHttpInfo().getData();
      }

  /**
   * 
   * Broadcasts all unconfirmed transactions from the unconfirmed transaction pool
   * @return ApiResponse&lt;Object&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK, Broadcasts all unconfirmed transactions from the unconfirmed transaction pool </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Object> resendUnconfirmedTxnsWithHttpInfo() throws ApiException {
    Object localVarPostBody = new Object();
    
    // create path and map variables
    String localVarPath = "/api/v1/resendUnconfirmedTxns";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application-json", "application/json", "application/xml"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "csrfAuth" };

    GenericType<Object> localVarReturnType = new GenericType<Object>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns the top skycoin holders.
   * 
   * @param includeDistribution include distribution addresses or not, default value false (optional)
   * @param n include distribution addresses or not, default value false (optional)
   * @return Object
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Represent richlist response </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public Object richlist(Boolean includeDistribution, String n) throws ApiException {
    return richlistWithHttpInfo(includeDistribution, n).getData();
      }

  /**
   * Returns the top skycoin holders.
   * 
   * @param includeDistribution include distribution addresses or not, default value false (optional)
   * @param n include distribution addresses or not, default value false (optional)
   * @return ApiResponse&lt;Object&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Represent richlist response </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Object> richlistWithHttpInfo(Boolean includeDistribution, String n) throws ApiException {
    Object localVarPostBody = new Object();
    
    // create path and map variables
    String localVarPath = "/api/v1/richlist";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "include-distribution", includeDistribution));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "n", n));

    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<Object> localVarReturnType = new GenericType<Object>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * 
   * Returns a transaction identified by its txid hash with just id
   * @param txid transaction Id (required)
   * @return Transaction
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a transaction identified by its txid hash. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public Transaction transaction(String txid) throws ApiException {
    return transactionWithHttpInfo(txid).getData();
      }

  /**
   * 
   * Returns a transaction identified by its txid hash with just id
   * @param txid transaction Id (required)
   * @return ApiResponse&lt;Transaction&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a transaction identified by its txid hash. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Transaction> transactionWithHttpInfo(String txid) throws ApiException {
    Object localVarPostBody = new Object();
    
    // verify the required parameter 'txid' is set
    if (txid == null) {
      throw new ApiException(400, "Missing the required parameter 'txid' when calling transaction");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/transaction";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "txid", txid));

    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<Transaction> localVarReturnType = new GenericType<Transaction>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Broadcast a hex-encoded, serialized transaction to the network.
   * 
   * @param rawtx hex-encoded serialized transaction string. (required)
   * @return String
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Broadcasts a hex-encoded, serialized transaction to the network </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public String transactionInject(String rawtx) throws ApiException {
    return transactionInjectWithHttpInfo(rawtx).getData();
      }

  /**
   * Broadcast a hex-encoded, serialized transaction to the network.
   * 
   * @param rawtx hex-encoded serialized transaction string. (required)
   * @return ApiResponse&lt;String&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Broadcasts a hex-encoded, serialized transaction to the network </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<String> transactionInjectWithHttpInfo(String rawtx) throws ApiException {
    Object localVarPostBody = new Object();
    
    // verify the required parameter 'rawtx' is set
    if (rawtx == null) {
      throw new ApiException(400, "Missing the required parameter 'rawtx' when calling transactionInject");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/injectTransaction";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    if (rawtx != null)
      localVarHeaderParams.put("rawtx", apiClient.parameterToString(rawtx));

    
    final String[] localVarAccepts = {
      "text/plain", "application/json", "application/xml"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "csrfAuth" };

    GenericType<String> localVarReturnType = new GenericType<String>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * 
   * 
   * @param transactionV2ParamsAddress  (optional)
   * @return InlineResponse2008
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Response is a transaction </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public InlineResponse2008 transactionPost(TransactionV2ParamsAddress transactionV2ParamsAddress) throws ApiException {
    return transactionPostWithHttpInfo(transactionV2ParamsAddress).getData();
      }

  /**
   * 
   * 
   * @param transactionV2ParamsAddress  (optional)
   * @return ApiResponse&lt;InlineResponse2008&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Response is a transaction </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<InlineResponse2008> transactionPostWithHttpInfo(TransactionV2ParamsAddress transactionV2ParamsAddress) throws ApiException {
    Object localVarPostBody = transactionV2ParamsAddress;
    
    // create path and map variables
    String localVarPath = "/api/v2/transaction";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "csrfAuth" };

    GenericType<InlineResponse2008> localVarReturnType = new GenericType<InlineResponse2008>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * 
   * 
   * @param transactionV2ParamsUnspent Unspent parameters (required)
   * @return InlineResponse2008
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Response is a transaction </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public InlineResponse2008 transactionPostUnspent(TransactionV2ParamsUnspent transactionV2ParamsUnspent) throws ApiException {
    return transactionPostUnspentWithHttpInfo(transactionV2ParamsUnspent).getData();
      }

  /**
   * 
   * 
   * @param transactionV2ParamsUnspent Unspent parameters (required)
   * @return ApiResponse&lt;InlineResponse2008&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Response is a transaction </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<InlineResponse2008> transactionPostUnspentWithHttpInfo(TransactionV2ParamsUnspent transactionV2ParamsUnspent) throws ApiException {
    Object localVarPostBody = transactionV2ParamsUnspent;
    
    // verify the required parameter 'transactionV2ParamsUnspent' is set
    if (transactionV2ParamsUnspent == null) {
      throw new ApiException(400, "Missing the required parameter 'transactionV2ParamsUnspent' when calling transactionPostUnspent");
    }
    
    // create path and map variables
    String localVarPath = "/api/v2/transaction/unspent";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "csrfAuth" };

    GenericType<InlineResponse2008> localVarReturnType = new GenericType<InlineResponse2008>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns the hex-encoded byte serialization of a transaction. The transaction may be confirmed or unconfirmed.
   * 
   * @param txid Transaction id hash (optional)
   * @return Object
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns the hex-encoded byte serialization of a transaction </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public Object transactionRaw(String txid) throws ApiException {
    return transactionRawWithHttpInfo(txid).getData();
      }

  /**
   * Returns the hex-encoded byte serialization of a transaction. The transaction may be confirmed or unconfirmed.
   * 
   * @param txid Transaction id hash (optional)
   * @return ApiResponse&lt;Object&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns the hex-encoded byte serialization of a transaction </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Object> transactionRawWithHttpInfo(String txid) throws ApiException {
    Object localVarPostBody = new Object();
    
    // create path and map variables
    String localVarPath = "/api/v2/transaction/raw";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "txid", txid));

    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<Object> localVarReturnType = new GenericType<Object>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * 
   * Decode and verify an encoded transaction
   * @param transactionVerifyRequest  (required)
   * @return Object
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Responses ok </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public Object transactionVerify(TransactionVerifyRequest transactionVerifyRequest) throws ApiException {
    return transactionVerifyWithHttpInfo(transactionVerifyRequest).getData();
      }

  /**
   * 
   * Decode and verify an encoded transaction
   * @param transactionVerifyRequest  (required)
   * @return ApiResponse&lt;Object&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Responses ok </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Object> transactionVerifyWithHttpInfo(TransactionVerifyRequest transactionVerifyRequest) throws ApiException {
    Object localVarPostBody = transactionVerifyRequest;
    
    // verify the required parameter 'transactionVerifyRequest' is set
    if (transactionVerifyRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'transactionVerifyRequest' when calling transactionVerify");
    }
    
    // create path and map variables
    String localVarPath = "/api/v2/transaction/verify";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "csrfAuth" };

    GenericType<Object> localVarReturnType = new GenericType<Object>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns transactions that match the filters.
   * 
   * @param addrs command separated list of addresses (optional)
   * @param confirmed Whether the transactions should be confirmed [optional, must be 0 or 1; if not provided, returns all] (optional)
   * @return Object
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns transactions that match the filters. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public Object transactionsGet(String addrs, String confirmed) throws ApiException {
    return transactionsGetWithHttpInfo(addrs, confirmed).getData();
      }

  /**
   * Returns transactions that match the filters.
   * 
   * @param addrs command separated list of addresses (optional)
   * @param confirmed Whether the transactions should be confirmed [optional, must be 0 or 1; if not provided, returns all] (optional)
   * @return ApiResponse&lt;Object&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns transactions that match the filters. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Object> transactionsGetWithHttpInfo(String addrs, String confirmed) throws ApiException {
    Object localVarPostBody = new Object();
    
    // create path and map variables
    String localVarPath = "/api/v1/transactions";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "addrs", addrs));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "confirmed", confirmed));

    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<Object> localVarReturnType = new GenericType<Object>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns transactions that match the filters.
   * 
   * @param addrs command separated list of addresses (optional)
   * @param confirmed Whether the transactions should be confirmed [optional, must be 0 or 1; if not provided, returns all] (optional)
   * @return Object
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns transactions that match the filters. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public Object transactionsPost(String addrs, String confirmed) throws ApiException {
    return transactionsPostWithHttpInfo(addrs, confirmed).getData();
      }

  /**
   * Returns transactions that match the filters.
   * 
   * @param addrs command separated list of addresses (optional)
   * @param confirmed Whether the transactions should be confirmed [optional, must be 0 or 1; if not provided, returns all] (optional)
   * @return ApiResponse&lt;Object&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns transactions that match the filters. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Object> transactionsPostWithHttpInfo(String addrs, String confirmed) throws ApiException {
    Object localVarPostBody = new Object();
    
    // create path and map variables
    String localVarPath = "/api/v1/transactions";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "addrs", addrs));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "confirmed", confirmed));

    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "csrfAuth" };

    GenericType<Object> localVarReturnType = new GenericType<Object>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns an unspent output by ID.
   * 
   * @param uxid uxid to filter by (optional)
   * @return Object
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Response for endpoint /api/v1/uxout </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public Object uxout(String uxid) throws ApiException {
    return uxoutWithHttpInfo(uxid).getData();
      }

  /**
   * Returns an unspent output by ID.
   * 
   * @param uxid uxid to filter by (optional)
   * @return ApiResponse&lt;Object&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Response for endpoint /api/v1/uxout </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Object> uxoutWithHttpInfo(String uxid) throws ApiException {
    Object localVarPostBody = new Object();
    
    // create path and map variables
    String localVarPath = "/api/v1/uxout";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "uxid", uxid));

    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<Object> localVarReturnType = new GenericType<Object>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Verifies a Skycoin address.
   * 
   * @param address Address id. (required)
   * @return Object
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public Object verifyAddress(Address address) throws ApiException {
    return verifyAddressWithHttpInfo(address).getData();
      }

  /**
   * Verifies a Skycoin address.
   * 
   * @param address Address id. (required)
   * @return ApiResponse&lt;Object&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Object> verifyAddressWithHttpInfo(Address address) throws ApiException {
    Object localVarPostBody = new Object();
    
    // verify the required parameter 'address' is set
    if (address == null) {
      throw new ApiException(400, "Missing the required parameter 'address' when calling verifyAddress");
    }
    
    // create path and map variables
    String localVarPath = "/api/v2/address/verify";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "address", address));

    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "csrfAuth" };

    GenericType<Object> localVarReturnType = new GenericType<Object>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * 
   * versionHandler returns the application version info
   * @return InlineResponse2005
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> BuildInfo represents the build info </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public InlineResponse2005 version() throws ApiException {
    return versionWithHttpInfo().getData();
      }

  /**
   * 
   * versionHandler returns the application version info
   * @return ApiResponse&lt;InlineResponse2005&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> BuildInfo represents the build info </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<InlineResponse2005> versionWithHttpInfo() throws ApiException {
    Object localVarPostBody = new Object();
    
    // create path and map variables
    String localVarPath = "/api/v1/version";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<InlineResponse2005> localVarReturnType = new GenericType<InlineResponse2005>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns a wallet by id.
   * 
   * @param id tags to filter by (required)
   * @return Object
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Response for endpoint /api/v1/wallet </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public Object wallet(String id) throws ApiException {
    return walletWithHttpInfo(id).getData();
      }

  /**
   * Returns a wallet by id.
   * 
   * @param id tags to filter by (required)
   * @return ApiResponse&lt;Object&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Response for endpoint /api/v1/wallet </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Object> walletWithHttpInfo(String id) throws ApiException {
    Object localVarPostBody = new Object();
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling wallet");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/wallet";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "id", id));

    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<Object> localVarReturnType = new GenericType<Object>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns the wallet&#39;s balance, both confirmed and predicted.  The predicted balance is the confirmed balance minus the pending spends.
   * 
   * @param id tags to filter by (required)
   * @return Object
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns the wallets balance </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public Object walletBalance(String id) throws ApiException {
    return walletBalanceWithHttpInfo(id).getData();
      }

  /**
   * Returns the wallet&#39;s balance, both confirmed and predicted.  The predicted balance is the confirmed balance minus the pending spends.
   * 
   * @param id tags to filter by (required)
   * @return ApiResponse&lt;Object&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns the wallets balance </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Object> walletBalanceWithHttpInfo(String id) throws ApiException {
    Object localVarPostBody = new Object();
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling walletBalance");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/wallet/balance";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "id", id));

    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<Object> localVarReturnType = new GenericType<Object>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * 
   * Loads wallet from seed, will scan ahead N address and load addresses till the last one that have coins.
   * @param seed Wallet seed. (required)
   * @param label Wallet label. (required)
   * @param scan The number of addresses to scan ahead for balances. (optional)
   * @param encrypt Encrypt wallet. (optional)
   * @param password Wallet Password (optional)
   * @return Object
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint return a new wallet </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public Object walletCreate(String seed, String label, Integer scan, Boolean encrypt, String password) throws ApiException {
    return walletCreateWithHttpInfo(seed, label, scan, encrypt, password).getData();
      }

  /**
   * 
   * Loads wallet from seed, will scan ahead N address and load addresses till the last one that have coins.
   * @param seed Wallet seed. (required)
   * @param label Wallet label. (required)
   * @param scan The number of addresses to scan ahead for balances. (optional)
   * @param encrypt Encrypt wallet. (optional)
   * @param password Wallet Password (optional)
   * @return ApiResponse&lt;Object&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint return a new wallet </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Object> walletCreateWithHttpInfo(String seed, String label, Integer scan, Boolean encrypt, String password) throws ApiException {
    Object localVarPostBody = new Object();
    
    // verify the required parameter 'seed' is set
    if (seed == null) {
      throw new ApiException(400, "Missing the required parameter 'seed' when calling walletCreate");
    }
    
    // verify the required parameter 'label' is set
    if (label == null) {
      throw new ApiException(400, "Missing the required parameter 'label' when calling walletCreate");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/wallet/create";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    if (seed != null)
      localVarHeaderParams.put("seed", apiClient.parameterToString(seed));
if (label != null)
      localVarHeaderParams.put("label", apiClient.parameterToString(label));
if (scan != null)
      localVarHeaderParams.put("scan", apiClient.parameterToString(scan));
if (encrypt != null)
      localVarHeaderParams.put("encrypt", apiClient.parameterToString(encrypt));
if (password != null)
      localVarHeaderParams.put("password", apiClient.parameterToString(password));

    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "csrfAuth" };

    GenericType<Object> localVarReturnType = new GenericType<Object>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Decrypts wallet.
   * 
   * @param id Wallet id. (required)
   * @param password Wallet password. (required)
   * @return Object
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint decrypts wallets. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public Object walletDecrypt(String id, String password) throws ApiException {
    return walletDecryptWithHttpInfo(id, password).getData();
      }

  /**
   * Decrypts wallet.
   * 
   * @param id Wallet id. (required)
   * @param password Wallet password. (required)
   * @return ApiResponse&lt;Object&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint decrypts wallets. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Object> walletDecryptWithHttpInfo(String id, String password) throws ApiException {
    Object localVarPostBody = new Object();
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling walletDecrypt");
    }
    
    // verify the required parameter 'password' is set
    if (password == null) {
      throw new ApiException(400, "Missing the required parameter 'password' when calling walletDecrypt");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/wallet/decrypt";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    if (id != null)
      localVarHeaderParams.put("id", apiClient.parameterToString(id));
if (password != null)
      localVarHeaderParams.put("password", apiClient.parameterToString(password));

    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "csrfAuth" };

    GenericType<Object> localVarReturnType = new GenericType<Object>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Encrypt wallet.
   * 
   * @param id Wallet id. (required)
   * @param password Wallet password. (required)
   * @return Object
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint encrypt wallets. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public Object walletEncrypt(String id, String password) throws ApiException {
    return walletEncryptWithHttpInfo(id, password).getData();
      }

  /**
   * Encrypt wallet.
   * 
   * @param id Wallet id. (required)
   * @param password Wallet password. (required)
   * @return ApiResponse&lt;Object&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint encrypt wallets. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Object> walletEncryptWithHttpInfo(String id, String password) throws ApiException {
    Object localVarPostBody = new Object();
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling walletEncrypt");
    }
    
    // verify the required parameter 'password' is set
    if (password == null) {
      throw new ApiException(400, "Missing the required parameter 'password' when calling walletEncrypt");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/wallet/encrypt";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    if (id != null)
      localVarHeaderParams.put("id", apiClient.parameterToString(id));
if (password != null)
      localVarHeaderParams.put("password", apiClient.parameterToString(password));

    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "csrfAuth" };

    GenericType<Object> localVarReturnType = new GenericType<Object>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * 
   * Returns the wallet directory path
   * @param addr Address port (required)
   * @return InlineResponse2007
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint return the wallet directory path </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public InlineResponse2007 walletFolder(String addr) throws ApiException {
    return walletFolderWithHttpInfo(addr).getData();
      }

  /**
   * 
   * Returns the wallet directory path
   * @param addr Address port (required)
   * @return ApiResponse&lt;InlineResponse2007&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint return the wallet directory path </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<InlineResponse2007> walletFolderWithHttpInfo(String addr) throws ApiException {
    Object localVarPostBody = new Object();
    
    // verify the required parameter 'addr' is set
    if (addr == null) {
      throw new ApiException(400, "Missing the required parameter 'addr' when calling walletFolder");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/wallets/folderName";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "addr", addr));

    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<InlineResponse2007> localVarReturnType = new GenericType<InlineResponse2007>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * 
   * Generates new addresses
   * @param id Wallet Id (required)
   * @param num The number you want to generate (optional)
   * @param password Wallet Password (optional)
   * @return Object
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint generate new addresses </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public Object walletNewAddress(String id, String num, String password) throws ApiException {
    return walletNewAddressWithHttpInfo(id, num, password).getData();
      }

  /**
   * 
   * Generates new addresses
   * @param id Wallet Id (required)
   * @param num The number you want to generate (optional)
   * @param password Wallet Password (optional)
   * @return ApiResponse&lt;Object&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint generate new addresses </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Object> walletNewAddressWithHttpInfo(String id, String num, String password) throws ApiException {
    Object localVarPostBody = new Object();
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling walletNewAddress");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/wallet/newAddress";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "id", id));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "num", num));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "password", password));

    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "csrfAuth" };

    GenericType<Object> localVarReturnType = new GenericType<Object>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * 
   * Returns the wallet directory path
   * @param entropy Entropy bitSize. (optional)
   * @return Object
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Generates wallet seed </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public Object walletNewSeed(String entropy) throws ApiException {
    return walletNewSeedWithHttpInfo(entropy).getData();
      }

  /**
   * 
   * Returns the wallet directory path
   * @param entropy Entropy bitSize. (optional)
   * @return ApiResponse&lt;Object&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Generates wallet seed </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Object> walletNewSeedWithHttpInfo(String entropy) throws ApiException {
    Object localVarPostBody = new Object();
    
    // create path and map variables
    String localVarPath = "/api/v1/wallet/newSeed";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "entropy", entropy));

    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<Object> localVarReturnType = new GenericType<Object>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Recovers an encrypted wallet by providing the seed. The first address will be generated from seed and compared to the first address of the specified wallet. If they match, the wallet will be regenerated with an optional password. If the wallet is not encrypted, an error is returned.
   * 
   * @param id Wallet id. (required)
   * @param seed Wallet seed. (required)
   * @param password Wallet password. (optional)
   * @return Object
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint recover wallets. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public Object walletRecover(String id, String seed, String password) throws ApiException {
    return walletRecoverWithHttpInfo(id, seed, password).getData();
      }

  /**
   * Recovers an encrypted wallet by providing the seed. The first address will be generated from seed and compared to the first address of the specified wallet. If they match, the wallet will be regenerated with an optional password. If the wallet is not encrypted, an error is returned.
   * 
   * @param id Wallet id. (required)
   * @param seed Wallet seed. (required)
   * @param password Wallet password. (optional)
   * @return ApiResponse&lt;Object&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint recover wallets. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Object> walletRecoverWithHttpInfo(String id, String seed, String password) throws ApiException {
    Object localVarPostBody = new Object();
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling walletRecover");
    }
    
    // verify the required parameter 'seed' is set
    if (seed == null) {
      throw new ApiException(400, "Missing the required parameter 'seed' when calling walletRecover");
    }
    
    // create path and map variables
    String localVarPath = "/api/v2/wallet/recover";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    if (id != null)
      localVarHeaderParams.put("id", apiClient.parameterToString(id));
if (seed != null)
      localVarHeaderParams.put("seed", apiClient.parameterToString(seed));
if (password != null)
      localVarHeaderParams.put("password", apiClient.parameterToString(password));

    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "csrfAuth" };

    GenericType<Object> localVarReturnType = new GenericType<Object>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * This endpoint only works for encrypted wallets. If the wallet is unencrypted, The seed will be not returned.
   * 
   * @param id Wallet Id. (required)
   * @param password Wallet password. (required)
   * @return Object
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint Returns seed of wallet of given id </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public Object walletSeed(String id, String password) throws ApiException {
    return walletSeedWithHttpInfo(id, password).getData();
      }

  /**
   * This endpoint only works for encrypted wallets. If the wallet is unencrypted, The seed will be not returned.
   * 
   * @param id Wallet Id. (required)
   * @param password Wallet password. (required)
   * @return ApiResponse&lt;Object&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint Returns seed of wallet of given id </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Object> walletSeedWithHttpInfo(String id, String password) throws ApiException {
    Object localVarPostBody = new Object();
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling walletSeed");
    }
    
    // verify the required parameter 'password' is set
    if (password == null) {
      throw new ApiException(400, "Missing the required parameter 'password' when calling walletSeed");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/wallet/seed";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "id", id));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "password", password));

    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "csrfAuth" };

    GenericType<Object> localVarReturnType = new GenericType<Object>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Verifies a wallet seed.
   * 
   * @param seed Seed to be verified. (optional)
   * @return Object
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Verifies a wallet seed. </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public Object walletSeedVerify(String seed) throws ApiException {
    return walletSeedVerifyWithHttpInfo(seed).getData();
      }

  /**
   * Verifies a wallet seed.
   * 
   * @param seed Seed to be verified. (optional)
   * @return ApiResponse&lt;Object&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Verifies a wallet seed. </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Object> walletSeedVerifyWithHttpInfo(String seed) throws ApiException {
    Object localVarPostBody = new Object();
    
    // create path and map variables
    String localVarPath = "/api/v2/wallet/seed/verify";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    if (seed != null)
      localVarHeaderParams.put("seed", apiClient.parameterToString(seed));

    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "csrfAuth" };

    GenericType<Object> localVarReturnType = new GenericType<Object>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Creates a signed transaction
   * 
   * @param walletTransactionRequest  (required)
   * @return Object
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns blocks between a start and end point. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public Object walletTransaction(WalletTransactionRequest walletTransactionRequest) throws ApiException {
    return walletTransactionWithHttpInfo(walletTransactionRequest).getData();
      }

  /**
   * Creates a signed transaction
   * 
   * @param walletTransactionRequest  (required)
   * @return ApiResponse&lt;Object&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns blocks between a start and end point. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Object> walletTransactionWithHttpInfo(WalletTransactionRequest walletTransactionRequest) throws ApiException {
    Object localVarPostBody = walletTransactionRequest;
    
    // verify the required parameter 'walletTransactionRequest' is set
    if (walletTransactionRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'walletTransactionRequest' when calling walletTransaction");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/wallet/transaction";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "csrfAuth" };

    GenericType<Object> localVarReturnType = new GenericType<Object>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Creates a signed transaction
   * 
   * @param walletTransactionSignRequest  (required)
   * @return InlineResponse2009
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Signs an unsigned transaction, returning the transaction with updated signatures and the encoded, serialized transaction. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public InlineResponse2009 walletTransactionSign(WalletTransactionSignRequest walletTransactionSignRequest) throws ApiException {
    return walletTransactionSignWithHttpInfo(walletTransactionSignRequest).getData();
      }

  /**
   * Creates a signed transaction
   * 
   * @param walletTransactionSignRequest  (required)
   * @return ApiResponse&lt;InlineResponse2009&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Signs an unsigned transaction, returning the transaction with updated signatures and the encoded, serialized transaction. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<InlineResponse2009> walletTransactionSignWithHttpInfo(WalletTransactionSignRequest walletTransactionSignRequest) throws ApiException {
    Object localVarPostBody = walletTransactionSignRequest;
    
    // verify the required parameter 'walletTransactionSignRequest' is set
    if (walletTransactionSignRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'walletTransactionSignRequest' when calling walletTransactionSign");
    }
    
    // create path and map variables
    String localVarPath = "/api/v2/wallet/transaction/sign";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "csrfAuth" };

    GenericType<InlineResponse2009> localVarReturnType = new GenericType<InlineResponse2009>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * 
   * 
   * @param id Wallet Id. (required)
   * @return InlineResponse2006
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint returns all unconfirmed transactions for all addresses in a given wallet. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public InlineResponse2006 walletTransactions(String id) throws ApiException {
    return walletTransactionsWithHttpInfo(id).getData();
      }

  /**
   * 
   * 
   * @param id Wallet Id. (required)
   * @return ApiResponse&lt;InlineResponse2006&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint returns all unconfirmed transactions for all addresses in a given wallet. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<InlineResponse2006> walletTransactionsWithHttpInfo(String id) throws ApiException {
    Object localVarPostBody = new Object();
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling walletTransactions");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/wallet/transactions";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "id", id));

    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<InlineResponse2006> localVarReturnType = new GenericType<InlineResponse2006>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Unloads wallet from the wallet service.
   * 
   * @param id Wallet Id. (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint returns nothing. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public void walletUnload(String id) throws ApiException {

    walletUnloadWithHttpInfo(id);
  }

  /**
   * Unloads wallet from the wallet service.
   * 
   * @param id Wallet Id. (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint returns nothing. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> walletUnloadWithHttpInfo(String id) throws ApiException {
    Object localVarPostBody = new Object();
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling walletUnload");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/wallet/unload";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "id", id));

    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "csrfAuth" };


    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * Update the wallet.
   * 
   * @param id Wallet Id. (required)
   * @param label The label the wallet will be updated to. (required)
   * @return String
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint Returns the label the wallet will be updated to . </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public String walletUpdate(String id, String label) throws ApiException {
    return walletUpdateWithHttpInfo(id, label).getData();
      }

  /**
   * Update the wallet.
   * 
   * @param id Wallet Id. (required)
   * @param label The label the wallet will be updated to. (required)
   * @return ApiResponse&lt;String&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint Returns the label the wallet will be updated to . </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<String> walletUpdateWithHttpInfo(String id, String label) throws ApiException {
    Object localVarPostBody = new Object();
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling walletUpdate");
    }
    
    // verify the required parameter 'label' is set
    if (label == null) {
      throw new ApiException(400, "Missing the required parameter 'label' when calling walletUpdate");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/wallet/update";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    if (id != null)
      localVarHeaderParams.put("id", apiClient.parameterToString(id));
if (label != null)
      localVarHeaderParams.put("label", apiClient.parameterToString(label));

    
    final String[] localVarAccepts = {
      "text/plain", "application/json", "application/xml"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "csrfAuth" };

    GenericType<String> localVarReturnType = new GenericType<String>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * 
   * Returns all loaded wallets
   * @return List&lt;Object&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint return all loaded wallets </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public List<Object> wallets() throws ApiException {
    return walletsWithHttpInfo().getData();
      }

  /**
   * 
   * Returns all loaded wallets
   * @return ApiResponse&lt;List&lt;Object&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> This endpoint return all loaded wallets </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> A GenericError is the default error message that is generated. For certain status codes there are more appropriate error structures. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<Object>> walletsWithHttpInfo() throws ApiException {
    Object localVarPostBody = new Object();
    
    // create path and map variables
    String localVarPath = "/api/v1/wallets";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json", "application/xml", 
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<List<Object>> localVarReturnType = new GenericType<List<Object>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
