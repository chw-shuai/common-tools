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
import org.openapitools.client.model.Money;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.StringJoiner;

/**
 * The pricing tier details.
 */
@JsonPropertyOrder({
  PricingTier.JSON_PROPERTY_STARTING_QUANTITY,
  PricingTier.JSON_PROPERTY_ENDING_QUANTITY,
  PricingTier.JSON_PROPERTY_AMOUNT
})
@JsonTypeName("pricing_tier")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-05-08T11:30:41.643502082Z[Atlantic/Reykjavik]")
public class PricingTier {
  public static final String JSON_PROPERTY_STARTING_QUANTITY = "starting_quantity";
  private String startingQuantity;

  public static final String JSON_PROPERTY_ENDING_QUANTITY = "ending_quantity";
  private String endingQuantity;

  public static final String JSON_PROPERTY_AMOUNT = "amount";
  private Money amount;

  public PricingTier() {
  }

  public PricingTier startingQuantity(String startingQuantity) {
    
    this.startingQuantity = startingQuantity;
    return this;
  }

   /**
   * The starting quantity for the tier.
   * @return startingQuantity
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_STARTING_QUANTITY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getStartingQuantity() {
    return startingQuantity;
  }


  @JsonProperty(JSON_PROPERTY_STARTING_QUANTITY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setStartingQuantity(String startingQuantity) {
    this.startingQuantity = startingQuantity;
  }


  public PricingTier endingQuantity(String endingQuantity) {
    
    this.endingQuantity = endingQuantity;
    return this;
  }

   /**
   * The ending quantity for the tier. Optional for the last tier.
   * @return endingQuantity
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ENDING_QUANTITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getEndingQuantity() {
    return endingQuantity;
  }


  @JsonProperty(JSON_PROPERTY_ENDING_QUANTITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEndingQuantity(String endingQuantity) {
    this.endingQuantity = endingQuantity;
  }


  public PricingTier amount(Money amount) {
    
    this.amount = amount;
    return this;
  }

   /**
   * Get amount
   * @return amount
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Money getAmount() {
    return amount;
  }


  @JsonProperty(JSON_PROPERTY_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAmount(Money amount) {
    this.amount = amount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PricingTier pricingTier = (PricingTier) o;
    return Objects.equals(this.startingQuantity, pricingTier.startingQuantity) &&
        Objects.equals(this.endingQuantity, pricingTier.endingQuantity) &&
        Objects.equals(this.amount, pricingTier.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(startingQuantity, endingQuantity, amount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PricingTier {\n");
    sb.append("    startingQuantity: ").append(toIndentedString(startingQuantity)).append("\n");
    sb.append("    endingQuantity: ").append(toIndentedString(endingQuantity)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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

    // add `starting_quantity` to the URL query string
    if (getStartingQuantity() != null) {
      try {
        joiner.add(String.format("%sstarting_quantity%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getStartingQuantity()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `ending_quantity` to the URL query string
    if (getEndingQuantity() != null) {
      try {
        joiner.add(String.format("%sending_quantity%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getEndingQuantity()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `amount` to the URL query string
    if (getAmount() != null) {
      joiner.add(getAmount().toUrlQueryString(prefix + "amount" + suffix));
    }

    return joiner.toString();
  }

}

