/*
 * Payments
 * Call the Payments API to authorize payments, capture authorized payments, refund payments that have already been captured, and show payment information. Use the Payments API in conjunction with the <a href=\"/docs/api/orders/v2/\">Orders API</a>. For more information, see the <a href=\"/docs/checkout/\">PayPal Checkout Overview</a>.
 *
 * The version of the OpenAPI document: 2.5
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package org.openapitools.client.api;

import com.fasterxml.jackson.core.type.TypeReference;

import org.openapitools.client.ApiException;
import org.openapitools.client.ApiClient;
import org.openapitools.client.Configuration;
import org.openapitools.client.model.*;
import org.openapitools.client.Pair;

import org.openapitools.client.model.Authorization2;
import org.openapitools.client.model.AuthorizationsCapture400Response;
import org.openapitools.client.model.AuthorizationsCapture422Response;
import org.openapitools.client.model.AuthorizationsGet403Response;
import org.openapitools.client.model.AuthorizationsGet404Response;
import org.openapitools.client.model.AuthorizationsReauthorize400Response;
import org.openapitools.client.model.AuthorizationsReauthorize422Response;
import org.openapitools.client.model.AuthorizationsVoid401Response;
import org.openapitools.client.model.AuthorizationsVoid409Response;
import org.openapitools.client.model.AuthorizationsVoid422Response;
import org.openapitools.client.model.Capture2;
import org.openapitools.client.model.CaptureRequest;
import org.openapitools.client.model.Error400;
import org.openapitools.client.model.Error401;
import org.openapitools.client.model.ErrorDefault;
import org.openapitools.client.model.ReauthorizeRequest;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-06-11T03:52:37.374153451Z[Atlantic/Reykjavik]")
public class AuthorizationsApi {


  private ApiClient apiClient;

  public AuthorizationsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public AuthorizationsApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Capture authorized payment
   * Captures an authorized payment, by ID.
   * @param authorizationId The PayPal-generated ID for the authorized payment to void. (required)
   * @param payPalRequestId The server stores keys for 45 days. (optional)
   * @param prefer The preferred server response upon successful completion of the request. Value is:&lt;ul&gt;&lt;li&gt;&lt;code&gt;return&#x3D;minimal&lt;/code&gt;. The server returns a minimal response to optimize communication between the API caller and the server. A minimal response includes the &lt;code&gt;id&lt;/code&gt;, &lt;code&gt;status&lt;/code&gt; and HATEOAS links.&lt;/li&gt;&lt;li&gt;&lt;code&gt;return&#x3D;representation&lt;/code&gt;. The server returns a complete resource representation, including the current state of the resource.&lt;/li&gt;&lt;/ul&gt; (optional, default to return&#x3D;minimal)
   * @param captureRequest  (optional)
   * @return Capture2
   * @throws ApiException if fails to make API call
   */
  public Capture2 authorizationsCapture(String authorizationId, String payPalRequestId, String prefer, CaptureRequest captureRequest) throws ApiException {
    return this.authorizationsCapture(authorizationId, payPalRequestId, prefer, captureRequest, Collections.emptyMap());
  }


  /**
   * Capture authorized payment
   * Captures an authorized payment, by ID.
   * @param authorizationId The PayPal-generated ID for the authorized payment to void. (required)
   * @param payPalRequestId The server stores keys for 45 days. (optional)
   * @param prefer The preferred server response upon successful completion of the request. Value is:&lt;ul&gt;&lt;li&gt;&lt;code&gt;return&#x3D;minimal&lt;/code&gt;. The server returns a minimal response to optimize communication between the API caller and the server. A minimal response includes the &lt;code&gt;id&lt;/code&gt;, &lt;code&gt;status&lt;/code&gt; and HATEOAS links.&lt;/li&gt;&lt;li&gt;&lt;code&gt;return&#x3D;representation&lt;/code&gt;. The server returns a complete resource representation, including the current state of the resource.&lt;/li&gt;&lt;/ul&gt; (optional, default to return&#x3D;minimal)
   * @param captureRequest  (optional)
   * @param additionalHeaders additionalHeaders for this call
   * @return Capture2
   * @throws ApiException if fails to make API call
   */
  public Capture2 authorizationsCapture(String authorizationId, String payPalRequestId, String prefer, CaptureRequest captureRequest, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = captureRequest;
    
    // verify the required parameter 'authorizationId' is set
    if (authorizationId == null) {
      throw new ApiException(400, "Missing the required parameter 'authorizationId' when calling authorizationsCapture");
    }
    
    // create path and map variables
    String localVarPath = "/v2/payments/authorizations/{authorization_id}/capture"
      .replaceAll("\\{" + "authorization_id" + "\\}", apiClient.escapeString(authorizationId.toString()));

    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (payPalRequestId != null)
      localVarHeaderParams.put("PayPal-Request-Id", apiClient.parameterToString(payPalRequestId));
if (prefer != null)
      localVarHeaderParams.put("Prefer", apiClient.parameterToString(prefer));

    localVarHeaderParams.putAll(additionalHeaders);

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "Oauth2" };

    TypeReference<Capture2> localVarReturnType = new TypeReference<Capture2>() {};
    return apiClient.invokeAPI(
        localVarPath,
        "POST",
        localVarQueryParams,
        localVarCollectionQueryParams,
        localVarQueryStringJoiner.toString(),
        localVarPostBody,
        localVarHeaderParams,
        localVarCookieParams,
        localVarFormParams,
        localVarAccept,
        localVarContentType,
        localVarAuthNames,
        localVarReturnType
    );
  }

  /**
   * Show details for authorized payment
   * Shows details for an authorized payment, by ID.
   * @param authorizationId The PayPal-generated ID for the authorized payment to void. (required)
   * @return Authorization2
   * @throws ApiException if fails to make API call
   */
  public Authorization2 authorizationsGet(String authorizationId) throws ApiException {
    return this.authorizationsGet(authorizationId, Collections.emptyMap());
  }


  /**
   * Show details for authorized payment
   * Shows details for an authorized payment, by ID.
   * @param authorizationId The PayPal-generated ID for the authorized payment to void. (required)
   * @param additionalHeaders additionalHeaders for this call
   * @return Authorization2
   * @throws ApiException if fails to make API call
   */
  public Authorization2 authorizationsGet(String authorizationId, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'authorizationId' is set
    if (authorizationId == null) {
      throw new ApiException(400, "Missing the required parameter 'authorizationId' when calling authorizationsGet");
    }
    
    // create path and map variables
    String localVarPath = "/v2/payments/authorizations/{authorization_id}"
      .replaceAll("\\{" + "authorization_id" + "\\}", apiClient.escapeString(authorizationId.toString()));

    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    
    localVarHeaderParams.putAll(additionalHeaders);

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "Oauth2" };

    TypeReference<Authorization2> localVarReturnType = new TypeReference<Authorization2>() {};
    return apiClient.invokeAPI(
        localVarPath,
        "GET",
        localVarQueryParams,
        localVarCollectionQueryParams,
        localVarQueryStringJoiner.toString(),
        localVarPostBody,
        localVarHeaderParams,
        localVarCookieParams,
        localVarFormParams,
        localVarAccept,
        localVarContentType,
        localVarAuthNames,
        localVarReturnType
    );
  }

  /**
   * Reauthorize authorized payment
   * Reauthorizes an authorized PayPal account payment, by ID. To ensure that funds are still available, reauthorize a payment after its initial three-day honor period expires. Within the 29-day authorization period, you can issue multiple re-authorizations after the honor period expires.&lt;br/&gt;&lt;br/&gt;If 30 days have transpired since the date of the original authorization, you must create an authorized payment instead of reauthorizing the original authorized payment.&lt;br/&gt;&lt;br/&gt;A reauthorized payment itself has a new honor period of three days.&lt;br/&gt;&lt;br/&gt;You can reauthorize an authorized payment from 4 to 29 days after the 3-day honor period. The allowed amount depends on context and geography, for example in US it is up to 115% of the original authorized amount, not to exceed an increase of $75 USD.&lt;br/&gt;&lt;br/&gt;Supports only the &#x60;amount&#x60; request parameter.&lt;blockquote&gt;&lt;strong&gt;Note:&lt;/strong&gt; This request is currently not supported for Partner use cases.&lt;/blockquote&gt;
   * @param authorizationId The PayPal-generated ID for the authorized payment to void. (required)
   * @param payPalRequestId The server stores keys for 45 days. (optional)
   * @param prefer The preferred server response upon successful completion of the request. Value is:&lt;ul&gt;&lt;li&gt;&lt;code&gt;return&#x3D;minimal&lt;/code&gt;. The server returns a minimal response to optimize communication between the API caller and the server. A minimal response includes the &lt;code&gt;id&lt;/code&gt;, &lt;code&gt;status&lt;/code&gt; and HATEOAS links.&lt;/li&gt;&lt;li&gt;&lt;code&gt;return&#x3D;representation&lt;/code&gt;. The server returns a complete resource representation, including the current state of the resource.&lt;/li&gt;&lt;/ul&gt; (optional, default to return&#x3D;minimal)
   * @param reauthorizeRequest  (optional)
   * @return Authorization2
   * @throws ApiException if fails to make API call
   */
  public Authorization2 authorizationsReauthorize(String authorizationId, String payPalRequestId, String prefer, ReauthorizeRequest reauthorizeRequest) throws ApiException {
    return this.authorizationsReauthorize(authorizationId, payPalRequestId, prefer, reauthorizeRequest, Collections.emptyMap());
  }


  /**
   * Reauthorize authorized payment
   * Reauthorizes an authorized PayPal account payment, by ID. To ensure that funds are still available, reauthorize a payment after its initial three-day honor period expires. Within the 29-day authorization period, you can issue multiple re-authorizations after the honor period expires.&lt;br/&gt;&lt;br/&gt;If 30 days have transpired since the date of the original authorization, you must create an authorized payment instead of reauthorizing the original authorized payment.&lt;br/&gt;&lt;br/&gt;A reauthorized payment itself has a new honor period of three days.&lt;br/&gt;&lt;br/&gt;You can reauthorize an authorized payment from 4 to 29 days after the 3-day honor period. The allowed amount depends on context and geography, for example in US it is up to 115% of the original authorized amount, not to exceed an increase of $75 USD.&lt;br/&gt;&lt;br/&gt;Supports only the &#x60;amount&#x60; request parameter.&lt;blockquote&gt;&lt;strong&gt;Note:&lt;/strong&gt; This request is currently not supported for Partner use cases.&lt;/blockquote&gt;
   * @param authorizationId The PayPal-generated ID for the authorized payment to void. (required)
   * @param payPalRequestId The server stores keys for 45 days. (optional)
   * @param prefer The preferred server response upon successful completion of the request. Value is:&lt;ul&gt;&lt;li&gt;&lt;code&gt;return&#x3D;minimal&lt;/code&gt;. The server returns a minimal response to optimize communication between the API caller and the server. A minimal response includes the &lt;code&gt;id&lt;/code&gt;, &lt;code&gt;status&lt;/code&gt; and HATEOAS links.&lt;/li&gt;&lt;li&gt;&lt;code&gt;return&#x3D;representation&lt;/code&gt;. The server returns a complete resource representation, including the current state of the resource.&lt;/li&gt;&lt;/ul&gt; (optional, default to return&#x3D;minimal)
   * @param reauthorizeRequest  (optional)
   * @param additionalHeaders additionalHeaders for this call
   * @return Authorization2
   * @throws ApiException if fails to make API call
   */
  public Authorization2 authorizationsReauthorize(String authorizationId, String payPalRequestId, String prefer, ReauthorizeRequest reauthorizeRequest, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = reauthorizeRequest;
    
    // verify the required parameter 'authorizationId' is set
    if (authorizationId == null) {
      throw new ApiException(400, "Missing the required parameter 'authorizationId' when calling authorizationsReauthorize");
    }
    
    // create path and map variables
    String localVarPath = "/v2/payments/authorizations/{authorization_id}/reauthorize"
      .replaceAll("\\{" + "authorization_id" + "\\}", apiClient.escapeString(authorizationId.toString()));

    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (payPalRequestId != null)
      localVarHeaderParams.put("PayPal-Request-Id", apiClient.parameterToString(payPalRequestId));
if (prefer != null)
      localVarHeaderParams.put("Prefer", apiClient.parameterToString(prefer));

    localVarHeaderParams.putAll(additionalHeaders);

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "Oauth2" };

    TypeReference<Authorization2> localVarReturnType = new TypeReference<Authorization2>() {};
    return apiClient.invokeAPI(
        localVarPath,
        "POST",
        localVarQueryParams,
        localVarCollectionQueryParams,
        localVarQueryStringJoiner.toString(),
        localVarPostBody,
        localVarHeaderParams,
        localVarCookieParams,
        localVarFormParams,
        localVarAccept,
        localVarContentType,
        localVarAuthNames,
        localVarReturnType
    );
  }

  /**
   * Void authorized payment
   * Voids, or cancels, an authorized payment, by ID. You cannot void an authorized payment that has been fully captured.
   * @param authorizationId The PayPal-generated ID for the authorized payment to void. (required)
   * @param payPalAuthAssertion An API-caller-provided JSON Web Token (JWT) assertion that identifies the merchant. For details, see [PayPal-Auth-Assertion](/docs/api/reference/api-requests/#paypal-auth-assertion).&lt;blockquote&gt;&lt;strong&gt;Note:&lt;/strong&gt;For three party transactions in which a partner is managing the API calls on behalf of a merchant, the partner must identify the merchant using either a PayPal-Auth-Assertion header or an access token with target_subject.&lt;/blockquote&gt; (optional)
   * @param prefer The preferred server response upon successful completion of the request. Value is:&lt;ul&gt;&lt;li&gt;&lt;code&gt;return&#x3D;minimal&lt;/code&gt;. The server returns a minimal response to optimize communication between the API caller and the server. A minimal response includes the &lt;code&gt;id&lt;/code&gt;, &lt;code&gt;status&lt;/code&gt; and HATEOAS links.&lt;/li&gt;&lt;li&gt;&lt;code&gt;return&#x3D;representation&lt;/code&gt;. The server returns a complete resource representation, including the current state of the resource.&lt;/li&gt;&lt;/ul&gt; (optional, default to return&#x3D;minimal)
   * @return Authorization2
   * @throws ApiException if fails to make API call
   */
  public Authorization2 authorizationsVoid(String authorizationId, String payPalAuthAssertion, String prefer) throws ApiException {
    return this.authorizationsVoid(authorizationId, payPalAuthAssertion, prefer, Collections.emptyMap());
  }


  /**
   * Void authorized payment
   * Voids, or cancels, an authorized payment, by ID. You cannot void an authorized payment that has been fully captured.
   * @param authorizationId The PayPal-generated ID for the authorized payment to void. (required)
   * @param payPalAuthAssertion An API-caller-provided JSON Web Token (JWT) assertion that identifies the merchant. For details, see [PayPal-Auth-Assertion](/docs/api/reference/api-requests/#paypal-auth-assertion).&lt;blockquote&gt;&lt;strong&gt;Note:&lt;/strong&gt;For three party transactions in which a partner is managing the API calls on behalf of a merchant, the partner must identify the merchant using either a PayPal-Auth-Assertion header or an access token with target_subject.&lt;/blockquote&gt; (optional)
   * @param prefer The preferred server response upon successful completion of the request. Value is:&lt;ul&gt;&lt;li&gt;&lt;code&gt;return&#x3D;minimal&lt;/code&gt;. The server returns a minimal response to optimize communication between the API caller and the server. A minimal response includes the &lt;code&gt;id&lt;/code&gt;, &lt;code&gt;status&lt;/code&gt; and HATEOAS links.&lt;/li&gt;&lt;li&gt;&lt;code&gt;return&#x3D;representation&lt;/code&gt;. The server returns a complete resource representation, including the current state of the resource.&lt;/li&gt;&lt;/ul&gt; (optional, default to return&#x3D;minimal)
   * @param additionalHeaders additionalHeaders for this call
   * @return Authorization2
   * @throws ApiException if fails to make API call
   */
  public Authorization2 authorizationsVoid(String authorizationId, String payPalAuthAssertion, String prefer, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'authorizationId' is set
    if (authorizationId == null) {
      throw new ApiException(400, "Missing the required parameter 'authorizationId' when calling authorizationsVoid");
    }
    
    // create path and map variables
    String localVarPath = "/v2/payments/authorizations/{authorization_id}/void"
      .replaceAll("\\{" + "authorization_id" + "\\}", apiClient.escapeString(authorizationId.toString()));

    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    if (payPalAuthAssertion != null)
      localVarHeaderParams.put("PayPal-Auth-Assertion", apiClient.parameterToString(payPalAuthAssertion));
if (prefer != null)
      localVarHeaderParams.put("Prefer", apiClient.parameterToString(prefer));

    localVarHeaderParams.putAll(additionalHeaders);

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "Oauth2" };

    TypeReference<Authorization2> localVarReturnType = new TypeReference<Authorization2>() {};
    return apiClient.invokeAPI(
        localVarPath,
        "POST",
        localVarQueryParams,
        localVarCollectionQueryParams,
        localVarQueryStringJoiner.toString(),
        localVarPostBody,
        localVarHeaderParams,
        localVarCookieParams,
        localVarFormParams,
        localVarAccept,
        localVarContentType,
        localVarAuthNames,
        localVarReturnType
    );
  }

}
