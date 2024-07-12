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
import java.util.ArrayList;
import java.util.List;
import org.openapitools.client.model.Item;
import org.openapitools.client.model.ShippingAddress;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.StringJoiner;

/**
 * An array of items that are being purchased.
 */
@JsonPropertyOrder({
  ItemList.JSON_PROPERTY_ITEMS,
  ItemList.JSON_PROPERTY_SHIPPING_ADDRESS,
  ItemList.JSON_PROPERTY_SHIPPING_METHOD,
  ItemList.JSON_PROPERTY_SHIPPING_PHONE_NUMBER
})
@JsonTypeName("Item_List")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-06-11T03:56:12.691299337Z[Atlantic/Reykjavik]")
public class ItemList {
  public static final String JSON_PROPERTY_ITEMS = "items";
  private List<Item> items;

  public static final String JSON_PROPERTY_SHIPPING_ADDRESS = "shipping_address";
  private ShippingAddress shippingAddress;

  public static final String JSON_PROPERTY_SHIPPING_METHOD = "shipping_method";
  private String shippingMethod;

  public static final String JSON_PROPERTY_SHIPPING_PHONE_NUMBER = "shipping_phone_number";
  private String shippingPhoneNumber;

  public ItemList() {
  }

  public ItemList items(List<Item> items) {
    
    this.items = items;
    return this;
  }

  public ItemList addItemsItem(Item itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<>();
    }
    this.items.add(itemsItem);
    return this;
  }

   /**
   * An array of items that are being purchased.
   * @return items
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ITEMS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Item> getItems() {
    return items;
  }


  @JsonProperty(JSON_PROPERTY_ITEMS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setItems(List<Item> items) {
    this.items = items;
  }


  public ItemList shippingAddress(ShippingAddress shippingAddress) {
    
    this.shippingAddress = shippingAddress;
    return this;
  }

   /**
   * Get shippingAddress
   * @return shippingAddress
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SHIPPING_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ShippingAddress getShippingAddress() {
    return shippingAddress;
  }


  @JsonProperty(JSON_PROPERTY_SHIPPING_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setShippingAddress(ShippingAddress shippingAddress) {
    this.shippingAddress = shippingAddress;
  }


  public ItemList shippingMethod(String shippingMethod) {
    
    this.shippingMethod = shippingMethod;
    return this;
  }

   /**
   * The shipping method used for this payment, such as USPS Parcel.
   * @return shippingMethod
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SHIPPING_METHOD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getShippingMethod() {
    return shippingMethod;
  }


  @JsonProperty(JSON_PROPERTY_SHIPPING_METHOD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setShippingMethod(String shippingMethod) {
    this.shippingMethod = shippingMethod;
  }


  public ItemList shippingPhoneNumber(String shippingPhoneNumber) {
    
    this.shippingPhoneNumber = shippingPhoneNumber;
    return this;
  }

   /**
   * The shipping phone number, in its canonical international format as defined by the [E.164](https://en.wikipedia.org/wiki/E.164) numbering plan. Enables merchants to share payer’s contact number with PayPal for the current payment. The final contact number for the payer who is associated with the transaction might be the same as or different from the &#x60;shipping_phone_number&#x60; based on the payer’s action on PayPal.
   * @return shippingPhoneNumber
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SHIPPING_PHONE_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getShippingPhoneNumber() {
    return shippingPhoneNumber;
  }


  @JsonProperty(JSON_PROPERTY_SHIPPING_PHONE_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setShippingPhoneNumber(String shippingPhoneNumber) {
    this.shippingPhoneNumber = shippingPhoneNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ItemList itemList = (ItemList) o;
    return Objects.equals(this.items, itemList.items) &&
        Objects.equals(this.shippingAddress, itemList.shippingAddress) &&
        Objects.equals(this.shippingMethod, itemList.shippingMethod) &&
        Objects.equals(this.shippingPhoneNumber, itemList.shippingPhoneNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(items, shippingAddress, shippingMethod, shippingPhoneNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ItemList {\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    shippingAddress: ").append(toIndentedString(shippingAddress)).append("\n");
    sb.append("    shippingMethod: ").append(toIndentedString(shippingMethod)).append("\n");
    sb.append("    shippingPhoneNumber: ").append(toIndentedString(shippingPhoneNumber)).append("\n");
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

    // add `items` to the URL query string
    if (getItems() != null) {
      for (int i = 0; i < getItems().size(); i++) {
        if (getItems().get(i) != null) {
          joiner.add(getItems().get(i).toUrlQueryString(String.format("%sitems%s%s", prefix, suffix,
              "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix))));
        }
      }
    }

    // add `shipping_address` to the URL query string
    if (getShippingAddress() != null) {
      joiner.add(getShippingAddress().toUrlQueryString(prefix + "shipping_address" + suffix));
    }

    // add `shipping_method` to the URL query string
    if (getShippingMethod() != null) {
      try {
        joiner.add(String.format("%sshipping_method%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getShippingMethod()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `shipping_phone_number` to the URL query string
    if (getShippingPhoneNumber() != null) {
      try {
        joiner.add(String.format("%sshipping_phone_number%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getShippingPhoneNumber()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    return joiner.toString();
  }

}

