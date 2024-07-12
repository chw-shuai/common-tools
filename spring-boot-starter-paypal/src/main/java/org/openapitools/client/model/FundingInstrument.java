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
import org.openapitools.client.model.CreditCardToken;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.StringJoiner;

/**
 * The funding instrument details. An instance of this schema is valid if and only if it validates against exactly one of these supported properties.
 */
@JsonPropertyOrder({
  FundingInstrument.JSON_PROPERTY_CREDIT_CARD_TOKEN
})
@JsonTypeName("funding_instrument")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-06-11T03:56:12.691299337Z[Atlantic/Reykjavik]")
public class FundingInstrument {
  public static final String JSON_PROPERTY_CREDIT_CARD_TOKEN = "credit_card_token";
  private CreditCardToken creditCardToken;

  public FundingInstrument() {
  }

  public FundingInstrument creditCardToken(CreditCardToken creditCardToken) {
    
    this.creditCardToken = creditCardToken;
    return this;
  }

   /**
   * Get creditCardToken
   * @return creditCardToken
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_CREDIT_CARD_TOKEN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public CreditCardToken getCreditCardToken() {
    return creditCardToken;
  }


  @JsonProperty(JSON_PROPERTY_CREDIT_CARD_TOKEN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCreditCardToken(CreditCardToken creditCardToken) {
    this.creditCardToken = creditCardToken;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FundingInstrument fundingInstrument = (FundingInstrument) o;
    return Objects.equals(this.creditCardToken, fundingInstrument.creditCardToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(creditCardToken);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FundingInstrument {\n");
    sb.append("    creditCardToken: ").append(toIndentedString(creditCardToken)).append("\n");
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

    // add `credit_card_token` to the URL query string
    if (getCreditCardToken() != null) {
      joiner.add(getCreditCardToken().toUrlQueryString(prefix + "credit_card_token" + suffix));
    }

    return joiner.toString();
  }

}
