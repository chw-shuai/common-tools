/*
 * Payments
 * <blockquote><strong>Deprecation notice:</strong> The <code>/v1/payments</code> endpoint is deprecated. Use the <code>/v2/payments</code> endpoint instead. For details, see <a href=\"/docs/checkout/integrate/\">PayPal Checkout Basic Integration</a>.</blockquote>Use the Payments REST API to easily and securely accept online and mobile payments. The payments name space contains resource collections for payments, sales, refunds, authorizations, captures, and orders.<blockquote><strong>Important:</strong> The use of the PayPal REST <code>/payments</code> APIs to accept credit card payments is restricted. Instead, you can accept credit card payments with <a href=\"https://www.braintreepayments.com/products/braintree-direct\">Braintree Direct</a>.</blockquote>You can enable customers to make PayPal and credit card payments with only a few clicks, depending on the country. You can accept an immediate payment or authorize a payment and capture it later. You can show details for completed payments, refunds, and authorizations. You can make full or partial refunds. You also can void or re-authorize authorizations. For more information, see the <a href=\"/docs/integration/direct/payments/\">Payments overview</a>.
 *
 * The version of the OpenAPI document: 1.12
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.StringJoiner;

/**
 * The processor-provided response codes that describe the submitted payment. Supported only when the &#x60;payment_method&#x60; is &#x60;credit_card&#x60;.
 */
@JsonPropertyOrder({
  ProcessorResponse.JSON_PROPERTY_RESPONSE_CODE,
  ProcessorResponse.JSON_PROPERTY_AVS_CODE,
  ProcessorResponse.JSON_PROPERTY_CVV_CODE,
  ProcessorResponse.JSON_PROPERTY_ADVICE_CODE,
  ProcessorResponse.JSON_PROPERTY_ECI_SUBMITTED,
  ProcessorResponse.JSON_PROPERTY_VPAS
})
@JsonTypeName("processor_response")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-06-11T03:56:12.691299337Z[Atlantic/Reykjavik]")
public class ProcessorResponse {
  public static final String JSON_PROPERTY_RESPONSE_CODE = "response_code";
  private String responseCode;

  public static final String JSON_PROPERTY_AVS_CODE = "avs_code";
  private String avsCode;

  public static final String JSON_PROPERTY_CVV_CODE = "cvv_code";
  private String cvvCode;

  /**
   * The merchant advice on how to handle declines for recurring payments.
   */
  public enum AdviceCodeEnum {
    _01_NEW_ACCOUNT_INFORMATION("01_NEW_ACCOUNT_INFORMATION"),
    
    _02_TRY_AGAIN_LATER("02_TRY_AGAIN_LATER"),
    
    _02_STOP_SPECIFIC_PAYMENT("02_STOP_SPECIFIC_PAYMENT"),
    
    _03_DO_NOT_TRY_AGAIN("03_DO_NOT_TRY_AGAIN"),
    
    _03_REVOKE_AUTHORIZATION_FOR_FUTURE_PAYMENT("03_REVOKE_AUTHORIZATION_FOR_FUTURE_PAYMENT"),
    
    _21_DO_NOT_TRY_AGAIN_CARD_HOLDER_CANCELLED_RECURRRING_CHARGE("21_DO_NOT_TRY_AGAIN_CARD_HOLDER_CANCELLED_RECURRRING_CHARGE"),
    
    _21_CANCEL_ALL_RECURRING_PAYMENTS("21_CANCEL_ALL_RECURRING_PAYMENTS");

    private String value;

    AdviceCodeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static AdviceCodeEnum fromValue(String value) {
      for (AdviceCodeEnum b : AdviceCodeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_ADVICE_CODE = "advice_code";
  private AdviceCodeEnum adviceCode;

  public static final String JSON_PROPERTY_ECI_SUBMITTED = "eci_submitted";
  private String eciSubmitted;

  public static final String JSON_PROPERTY_VPAS = "vpas";
  private String vpas;

  public ProcessorResponse() {
  }

  @JsonCreator
  public ProcessorResponse(
    @JsonProperty(JSON_PROPERTY_RESPONSE_CODE) String responseCode, 
    @JsonProperty(JSON_PROPERTY_AVS_CODE) String avsCode, 
    @JsonProperty(JSON_PROPERTY_CVV_CODE) String cvvCode, 
    @JsonProperty(JSON_PROPERTY_ADVICE_CODE) AdviceCodeEnum adviceCode, 
    @JsonProperty(JSON_PROPERTY_ECI_SUBMITTED) String eciSubmitted, 
    @JsonProperty(JSON_PROPERTY_VPAS) String vpas
  ) {
    this();
    this.responseCode = responseCode;
    this.avsCode = avsCode;
    this.cvvCode = cvvCode;
    this.adviceCode = adviceCode;
    this.eciSubmitted = eciSubmitted;
    this.vpas = vpas;
  }

   /**
   * The PayPal normalized response code, which is generated from the processor&#39;s specific response code.
   * @return responseCode
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_RESPONSE_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getResponseCode() {
    return responseCode;
  }




   /**
   * The [Address Verification System (AVS)](/docs/nvp-soap-api/AVSResponseCodes/) response code.
   * @return avsCode
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_AVS_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getAvsCode() {
    return avsCode;
  }




   /**
   * The [CVV](/docs/nvp-soap-api/AVSResponseCodes/) system response code.
   * @return cvvCode
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_CVV_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCvvCode() {
    return cvvCode;
  }




   /**
   * The merchant advice on how to handle declines for recurring payments.
   * @return adviceCode
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ADVICE_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public AdviceCodeEnum getAdviceCode() {
    return adviceCode;
  }




   /**
   * The processor-provided authorization response.
   * @return eciSubmitted
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ECI_SUBMITTED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getEciSubmitted() {
    return eciSubmitted;
  }




   /**
   * The processor-provided Visa Payer Authentication Service (VPAS) status.
   * @return vpas
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_VPAS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getVpas() {
    return vpas;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProcessorResponse processorResponse = (ProcessorResponse) o;
    return Objects.equals(this.responseCode, processorResponse.responseCode) &&
        Objects.equals(this.avsCode, processorResponse.avsCode) &&
        Objects.equals(this.cvvCode, processorResponse.cvvCode) &&
        Objects.equals(this.adviceCode, processorResponse.adviceCode) &&
        Objects.equals(this.eciSubmitted, processorResponse.eciSubmitted) &&
        Objects.equals(this.vpas, processorResponse.vpas);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseCode, avsCode, cvvCode, adviceCode, eciSubmitted, vpas);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProcessorResponse {\n");
    sb.append("    responseCode: ").append(toIndentedString(responseCode)).append("\n");
    sb.append("    avsCode: ").append(toIndentedString(avsCode)).append("\n");
    sb.append("    cvvCode: ").append(toIndentedString(cvvCode)).append("\n");
    sb.append("    adviceCode: ").append(toIndentedString(adviceCode)).append("\n");
    sb.append("    eciSubmitted: ").append(toIndentedString(eciSubmitted)).append("\n");
    sb.append("    vpas: ").append(toIndentedString(vpas)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  /**
   * Convert the instance into URL query string.
   *
   * @return URL query string
   */
  public String toUrlQueryString() {
    return toUrlQueryString(null);
  }

  /**
   * Convert the instance into URL query string.
   *
   * @param prefix prefix of the query string
   * @return URL query string
   */
  public String toUrlQueryString(String prefix) {
    String suffix = "";
    String containerSuffix = "";
    String containerPrefix = "";
    if (prefix == null) {
      // style=form, explode=true, e.g. /pet?name=cat&type=manx
      prefix = "";
    } else {
      // deepObject style e.g. /pet?id[name]=cat&id[type]=manx
      prefix = prefix + "[";
      suffix = "]";
      containerSuffix = "]";
      containerPrefix = "[";
    }

    StringJoiner joiner = new StringJoiner("&");

    // add `response_code` to the URL query string
    if (getResponseCode() != null) {
      try {
        joiner.add(String.format("%sresponse_code%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getResponseCode()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `avs_code` to the URL query string
    if (getAvsCode() != null) {
      try {
        joiner.add(String.format("%savs_code%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getAvsCode()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `cvv_code` to the URL query string
    if (getCvvCode() != null) {
      try {
        joiner.add(String.format("%scvv_code%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getCvvCode()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `advice_code` to the URL query string
    if (getAdviceCode() != null) {
      try {
        joiner.add(String.format("%sadvice_code%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getAdviceCode()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `eci_submitted` to the URL query string
    if (getEciSubmitted() != null) {
      try {
        joiner.add(String.format("%seci_submitted%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getEciSubmitted()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `vpas` to the URL query string
    if (getVpas() != null) {
      try {
        joiner.add(String.format("%svpas%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getVpas()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    return joiner.toString();
  }

}

