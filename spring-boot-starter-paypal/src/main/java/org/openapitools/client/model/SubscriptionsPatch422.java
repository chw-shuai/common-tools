/*
 * Subscriptions
 * You can use billing plans and subscriptions to create subscriptions that process recurring PayPal payments for physical or digital goods, or services. A plan includes pricing and billing cycle information that defines the amount and frequency of charge for a subscription. You can also define a fixed plan, such as a $5 basic plan or a volume- or graduated-based plan with pricing tiers based on the quantity purchased. For more information, see <a href=\"/docs/subscriptions/\">Subscriptions Overview</a>.
 *
 * The version of the OpenAPI document: 1.6
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
import java.util.ArrayList;
import java.util.List;
import org.openapitools.client.model.SubscriptionsPatch422DetailsInner;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.StringJoiner;

/**
 * SubscriptionsPatch422
 */
@JsonPropertyOrder({
  SubscriptionsPatch422.JSON_PROPERTY_DETAILS
})
@JsonTypeName("subscriptions.patch-422")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-05-08T11:30:41.643502082Z[Atlantic/Reykjavik]")
public class SubscriptionsPatch422 {
  public static final String JSON_PROPERTY_DETAILS = "details";
  private List<SubscriptionsPatch422DetailsInner> details;

  public SubscriptionsPatch422() {
  }

  public SubscriptionsPatch422 details(List<SubscriptionsPatch422DetailsInner> details) {
    
    this.details = details;
    return this;
  }

  public SubscriptionsPatch422 addDetailsItem(SubscriptionsPatch422DetailsInner detailsItem) {
    if (this.details == null) {
      this.details = new ArrayList<>();
    }
    this.details.add(detailsItem);
    return this;
  }

   /**
   * Get details
   * @return details
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DETAILS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<SubscriptionsPatch422DetailsInner> getDetails() {
    return details;
  }


  @JsonProperty(JSON_PROPERTY_DETAILS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDetails(List<SubscriptionsPatch422DetailsInner> details) {
    this.details = details;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubscriptionsPatch422 subscriptionsPatch422 = (SubscriptionsPatch422) o;
    return Objects.equals(this.details, subscriptionsPatch422.details);
  }

  @Override
  public int hashCode() {
    return Objects.hash(details);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubscriptionsPatch422 {\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
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

    // add `details` to the URL query string
    if (getDetails() != null) {
      for (int i = 0; i < getDetails().size(); i++) {
        if (getDetails().get(i) != null) {
          joiner.add(getDetails().get(i).toUrlQueryString(String.format("%sdetails%s%s", prefix, suffix,
              "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix))));
        }
      }
    }

    return joiner.toString();
  }

}

