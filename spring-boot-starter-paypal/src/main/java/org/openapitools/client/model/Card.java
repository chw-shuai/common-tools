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
import org.openapitools.client.model.AddressPortable;
import org.openapitools.client.model.CardBrand;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.StringJoiner;

/**
 * The payment card to use to fund a payment. Can be a credit or debit card.
 */
@JsonPropertyOrder({
  Card.JSON_PROPERTY_ID,
  Card.JSON_PROPERTY_NAME,
  Card.JSON_PROPERTY_NUMBER,
  Card.JSON_PROPERTY_EXPIRY,
  Card.JSON_PROPERTY_SECURITY_CODE,
  Card.JSON_PROPERTY_LAST_DIGITS,
  Card.JSON_PROPERTY_CARD_TYPE,
  Card.JSON_PROPERTY_BILLING_ADDRESS
})
@JsonTypeName("card")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-05-08T11:30:41.643502082Z[Atlantic/Reykjavik]")
public class Card {
  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_NUMBER = "number";
  private String number;

  public static final String JSON_PROPERTY_EXPIRY = "expiry";
  private String expiry;

  public static final String JSON_PROPERTY_SECURITY_CODE = "security_code";
  private String securityCode;

  public static final String JSON_PROPERTY_LAST_DIGITS = "last_digits";
  private String lastDigits;

  public static final String JSON_PROPERTY_CARD_TYPE = "card_type";
  private CardBrand cardType;

  public static final String JSON_PROPERTY_BILLING_ADDRESS = "billing_address";
  private AddressPortable billingAddress;

  public Card() {
  }

  @JsonCreator
  public Card(
    @JsonProperty(JSON_PROPERTY_ID) String id, 
    @JsonProperty(JSON_PROPERTY_LAST_DIGITS) String lastDigits
  ) {
    this();
    this.id = id;
    this.lastDigits = lastDigits;
  }

   /**
   * The PayPal-generated ID for the card.
   * @return id
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }




  public Card name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * The card holder&#39;s name as it appears on the card.
   * @return name
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getName() {
    return name;
  }


  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setName(String name) {
    this.name = name;
  }


  public Card number(String number) {
    
    this.number = number;
    return this;
  }

   /**
   * The primary account number (PAN) for the payment card.
   * @return number
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_NUMBER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getNumber() {
    return number;
  }


  @JsonProperty(JSON_PROPERTY_NUMBER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setNumber(String number) {
    this.number = number;
  }


  public Card expiry(String expiry) {
    
    this.expiry = expiry;
    return this;
  }

   /**
   * The year and month, in ISO-8601 &#x60;YYYY-MM&#x60; date format. See [Internet date and time format](https://tools.ietf.org/html/rfc3339#section-5.6).
   * @return expiry
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_EXPIRY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getExpiry() {
    return expiry;
  }


  @JsonProperty(JSON_PROPERTY_EXPIRY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setExpiry(String expiry) {
    this.expiry = expiry;
  }


  public Card securityCode(String securityCode) {
    
    this.securityCode = securityCode;
    return this;
  }

   /**
   * The three- or four-digit security code of the card. Also known as the CVV, CVC, CVN, CVE, or CID. This parameter cannot be present in the request when &#x60;payment_initiator&#x3D;MERCHANT&#x60;.
   * @return securityCode
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SECURITY_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSecurityCode() {
    return securityCode;
  }


  @JsonProperty(JSON_PROPERTY_SECURITY_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSecurityCode(String securityCode) {
    this.securityCode = securityCode;
  }


   /**
   * The last digits of the payment card.
   * @return lastDigits
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_LAST_DIGITS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getLastDigits() {
    return lastDigits;
  }




  public Card cardType(CardBrand cardType) {
    
    this.cardType = cardType;
    return this;
  }

   /**
   * Get cardType
   * @return cardType
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_CARD_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public CardBrand getCardType() {
    return cardType;
  }


  @JsonProperty(JSON_PROPERTY_CARD_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCardType(CardBrand cardType) {
    this.cardType = cardType;
  }


  public Card billingAddress(AddressPortable billingAddress) {
    
    this.billingAddress = billingAddress;
    return this;
  }

   /**
   * Get billingAddress
   * @return billingAddress
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_BILLING_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public AddressPortable getBillingAddress() {
    return billingAddress;
  }


  @JsonProperty(JSON_PROPERTY_BILLING_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBillingAddress(AddressPortable billingAddress) {
    this.billingAddress = billingAddress;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Card card = (Card) o;
    return Objects.equals(this.id, card.id) &&
        Objects.equals(this.name, card.name) &&
        Objects.equals(this.number, card.number) &&
        Objects.equals(this.expiry, card.expiry) &&
        Objects.equals(this.securityCode, card.securityCode) &&
        Objects.equals(this.lastDigits, card.lastDigits) &&
        Objects.equals(this.cardType, card.cardType) &&
        Objects.equals(this.billingAddress, card.billingAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, number, expiry, securityCode, lastDigits, cardType, billingAddress);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Card {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    expiry: ").append(toIndentedString(expiry)).append("\n");
    sb.append("    securityCode: ").append(toIndentedString(securityCode)).append("\n");
    sb.append("    lastDigits: ").append(toIndentedString(lastDigits)).append("\n");
    sb.append("    cardType: ").append(toIndentedString(cardType)).append("\n");
    sb.append("    billingAddress: ").append(toIndentedString(billingAddress)).append("\n");
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

    // add `id` to the URL query string
    if (getId() != null) {
      try {
        joiner.add(String.format("%sid%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getId()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `name` to the URL query string
    if (getName() != null) {
      try {
        joiner.add(String.format("%sname%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getName()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `number` to the URL query string
    if (getNumber() != null) {
      try {
        joiner.add(String.format("%snumber%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getNumber()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `expiry` to the URL query string
    if (getExpiry() != null) {
      try {
        joiner.add(String.format("%sexpiry%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getExpiry()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `security_code` to the URL query string
    if (getSecurityCode() != null) {
      try {
        joiner.add(String.format("%ssecurity_code%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getSecurityCode()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `last_digits` to the URL query string
    if (getLastDigits() != null) {
      try {
        joiner.add(String.format("%slast_digits%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getLastDigits()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `card_type` to the URL query string
    if (getCardType() != null) {
      try {
        joiner.add(String.format("%scard_type%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getCardType()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `billing_address` to the URL query string
    if (getBillingAddress() != null) {
      joiner.add(getBillingAddress().toUrlQueryString(prefix + "billing_address" + suffix));
    }

    return joiner.toString();
  }

}

