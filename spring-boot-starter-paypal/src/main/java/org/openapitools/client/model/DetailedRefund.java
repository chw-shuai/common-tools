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
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.client.model.Amount;
import org.openapitools.client.model.Currency;
import org.openapitools.client.model.LinkDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.StringJoiner;

/**
 * The refund transaction details.
 */
@JsonPropertyOrder({
  DetailedRefund.JSON_PROPERTY_ID,
  DetailedRefund.JSON_PROPERTY_AMOUNT,
  DetailedRefund.JSON_PROPERTY_STATE,
  DetailedRefund.JSON_PROPERTY_REASON,
  DetailedRefund.JSON_PROPERTY_INVOICE_NUMBER,
  DetailedRefund.JSON_PROPERTY_SALE_ID,
  DetailedRefund.JSON_PROPERTY_CAPTURE_ID,
  DetailedRefund.JSON_PROPERTY_PARENT_PAYMENT,
  DetailedRefund.JSON_PROPERTY_DESCRIPTION,
  DetailedRefund.JSON_PROPERTY_CREATE_TIME,
  DetailedRefund.JSON_PROPERTY_UPDATE_TIME,
  DetailedRefund.JSON_PROPERTY_LINKS,
  DetailedRefund.JSON_PROPERTY_CUSTOM,
  DetailedRefund.JSON_PROPERTY_REFUND_FROM_TRANSACTION_FEE,
  DetailedRefund.JSON_PROPERTY_REFUND_FROM_RECEIVED_AMOUNT,
  DetailedRefund.JSON_PROPERTY_TOTAL_REFUNDED_AMOUNT
})
@JsonTypeName("detailed_refund")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-06-11T03:56:12.691299337Z[Atlantic/Reykjavik]")
public class DetailedRefund {
  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_AMOUNT = "amount";
  private Amount amount;

  /**
   * The state of the refund.
   */
  public enum StateEnum {
    PENDING("pending"),
    
    COMPLETED("completed"),
    
    CANCELLED("cancelled"),
    
    FAILED("failed");

    private String value;

    StateEnum(String value) {
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
    public static StateEnum fromValue(String value) {
      for (StateEnum b : StateEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_STATE = "state";
  private StateEnum state;

  public static final String JSON_PROPERTY_REASON = "reason";
  private String reason;

  public static final String JSON_PROPERTY_INVOICE_NUMBER = "invoice_number";
  private String invoiceNumber;

  public static final String JSON_PROPERTY_SALE_ID = "sale_id";
  private String saleId;

  public static final String JSON_PROPERTY_CAPTURE_ID = "capture_id";
  private String captureId;

  public static final String JSON_PROPERTY_PARENT_PAYMENT = "parent_payment";
  private String parentPayment;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;

  public static final String JSON_PROPERTY_CREATE_TIME = "create_time";
  private OffsetDateTime createTime;

  public static final String JSON_PROPERTY_UPDATE_TIME = "update_time";
  private OffsetDateTime updateTime;

  public static final String JSON_PROPERTY_LINKS = "links";
  private List<LinkDescription> links;

  public static final String JSON_PROPERTY_CUSTOM = "custom";
  private String custom;

  public static final String JSON_PROPERTY_REFUND_FROM_TRANSACTION_FEE = "refund_from_transaction_fee";
  private Currency refundFromTransactionFee;

  public static final String JSON_PROPERTY_REFUND_FROM_RECEIVED_AMOUNT = "refund_from_received_amount";
  private Currency refundFromReceivedAmount;

  public static final String JSON_PROPERTY_TOTAL_REFUNDED_AMOUNT = "total_refunded_amount";
  private Currency totalRefundedAmount;

  public DetailedRefund() {
  }

  @JsonCreator
  public DetailedRefund(
    @JsonProperty(JSON_PROPERTY_ID) String id, 
    @JsonProperty(JSON_PROPERTY_STATE) StateEnum state, 
    @JsonProperty(JSON_PROPERTY_SALE_ID) String saleId, 
    @JsonProperty(JSON_PROPERTY_CAPTURE_ID) String captureId, 
    @JsonProperty(JSON_PROPERTY_PARENT_PAYMENT) String parentPayment, 
    @JsonProperty(JSON_PROPERTY_CREATE_TIME) OffsetDateTime createTime, 
    @JsonProperty(JSON_PROPERTY_UPDATE_TIME) OffsetDateTime updateTime, 
    @JsonProperty(JSON_PROPERTY_LINKS) List<LinkDescription> links
  ) {
    this();
    this.id = id;
    this.state = state;
    this.saleId = saleId;
    this.captureId = captureId;
    this.parentPayment = parentPayment;
    this.createTime = createTime;
    this.updateTime = updateTime;
    this.links = links;
  }

   /**
   * The ID of the refund transaction.
   * @return id
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }




  public DetailedRefund amount(Amount amount) {
    
    this.amount = amount;
    return this;
  }

   /**
   * Get amount
   * @return amount
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Amount getAmount() {
    return amount;
  }


  @JsonProperty(JSON_PROPERTY_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAmount(Amount amount) {
    this.amount = amount;
  }


   /**
   * The state of the refund.
   * @return state
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public StateEnum getState() {
    return state;
  }




  public DetailedRefund reason(String reason) {
    
    this.reason = reason;
    return this;
  }

   /**
   * The reason that the transaction is being refunded.
   * @return reason
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_REASON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getReason() {
    return reason;
  }


  @JsonProperty(JSON_PROPERTY_REASON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setReason(String reason) {
    this.reason = reason;
  }


  public DetailedRefund invoiceNumber(String invoiceNumber) {
    
    this.invoiceNumber = invoiceNumber;
    return this;
  }

   /**
   * The invoice number to track this payment.
   * @return invoiceNumber
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_INVOICE_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getInvoiceNumber() {
    return invoiceNumber;
  }


  @JsonProperty(JSON_PROPERTY_INVOICE_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInvoiceNumber(String invoiceNumber) {
    this.invoiceNumber = invoiceNumber;
  }


   /**
   * The ID of the sale transaction being refunded.
   * @return saleId
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SALE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSaleId() {
    return saleId;
  }




   /**
   * The ID of the sale transaction being refunded.
   * @return captureId
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_CAPTURE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCaptureId() {
    return captureId;
  }




   /**
   * The ID of the payment on which this transaction is based.
   * @return parentPayment
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PARENT_PAYMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getParentPayment() {
    return parentPayment;
  }




  public DetailedRefund description(String description) {
    
    this.description = description;
    return this;
  }

   /**
   * The refund description.
   * @return description
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDescription() {
    return description;
  }


  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDescription(String description) {
    this.description = description;
  }


   /**
   * The date and time when the refund was created, in [Internet date and time format](https://tools.ietf.org/html/rfc3339#section-5.6).
   * @return createTime
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_CREATE_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getCreateTime() {
    return createTime;
  }




   /**
   * The date and time when the resource was last updated, in [Internet date and time format](https://tools.ietf.org/html/rfc3339#section-5.6).
   * @return updateTime
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_UPDATE_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getUpdateTime() {
    return updateTime;
  }




   /**
   * An array of request-related [HATEOAS links](/docs/api/reference/api-responses/#hateoas-links).
   * @return links
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_LINKS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<LinkDescription> getLinks() {
    return links;
  }




  public DetailedRefund custom(String custom) {
    
    this.custom = custom;
    return this;
  }

   /**
   * The note to the payer in this transaction.
   * @return custom
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_CUSTOM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCustom() {
    return custom;
  }


  @JsonProperty(JSON_PROPERTY_CUSTOM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCustom(String custom) {
    this.custom = custom;
  }


  public DetailedRefund refundFromTransactionFee(Currency refundFromTransactionFee) {
    
    this.refundFromTransactionFee = refundFromTransactionFee;
    return this;
  }

   /**
   * Get refundFromTransactionFee
   * @return refundFromTransactionFee
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_REFUND_FROM_TRANSACTION_FEE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Currency getRefundFromTransactionFee() {
    return refundFromTransactionFee;
  }


  @JsonProperty(JSON_PROPERTY_REFUND_FROM_TRANSACTION_FEE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRefundFromTransactionFee(Currency refundFromTransactionFee) {
    this.refundFromTransactionFee = refundFromTransactionFee;
  }


  public DetailedRefund refundFromReceivedAmount(Currency refundFromReceivedAmount) {
    
    this.refundFromReceivedAmount = refundFromReceivedAmount;
    return this;
  }

   /**
   * Get refundFromReceivedAmount
   * @return refundFromReceivedAmount
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_REFUND_FROM_RECEIVED_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Currency getRefundFromReceivedAmount() {
    return refundFromReceivedAmount;
  }


  @JsonProperty(JSON_PROPERTY_REFUND_FROM_RECEIVED_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRefundFromReceivedAmount(Currency refundFromReceivedAmount) {
    this.refundFromReceivedAmount = refundFromReceivedAmount;
  }


  public DetailedRefund totalRefundedAmount(Currency totalRefundedAmount) {
    
    this.totalRefundedAmount = totalRefundedAmount;
    return this;
  }

   /**
   * Get totalRefundedAmount
   * @return totalRefundedAmount
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TOTAL_REFUNDED_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Currency getTotalRefundedAmount() {
    return totalRefundedAmount;
  }


  @JsonProperty(JSON_PROPERTY_TOTAL_REFUNDED_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTotalRefundedAmount(Currency totalRefundedAmount) {
    this.totalRefundedAmount = totalRefundedAmount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DetailedRefund detailedRefund = (DetailedRefund) o;
    return Objects.equals(this.id, detailedRefund.id) &&
        Objects.equals(this.amount, detailedRefund.amount) &&
        Objects.equals(this.state, detailedRefund.state) &&
        Objects.equals(this.reason, detailedRefund.reason) &&
        Objects.equals(this.invoiceNumber, detailedRefund.invoiceNumber) &&
        Objects.equals(this.saleId, detailedRefund.saleId) &&
        Objects.equals(this.captureId, detailedRefund.captureId) &&
        Objects.equals(this.parentPayment, detailedRefund.parentPayment) &&
        Objects.equals(this.description, detailedRefund.description) &&
        Objects.equals(this.createTime, detailedRefund.createTime) &&
        Objects.equals(this.updateTime, detailedRefund.updateTime) &&
        Objects.equals(this.links, detailedRefund.links) &&
        Objects.equals(this.custom, detailedRefund.custom) &&
        Objects.equals(this.refundFromTransactionFee, detailedRefund.refundFromTransactionFee) &&
        Objects.equals(this.refundFromReceivedAmount, detailedRefund.refundFromReceivedAmount) &&
        Objects.equals(this.totalRefundedAmount, detailedRefund.totalRefundedAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, amount, state, reason, invoiceNumber, saleId, captureId, parentPayment, description, createTime, updateTime, links, custom, refundFromTransactionFee, refundFromReceivedAmount, totalRefundedAmount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DetailedRefund {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    invoiceNumber: ").append(toIndentedString(invoiceNumber)).append("\n");
    sb.append("    saleId: ").append(toIndentedString(saleId)).append("\n");
    sb.append("    captureId: ").append(toIndentedString(captureId)).append("\n");
    sb.append("    parentPayment: ").append(toIndentedString(parentPayment)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
    sb.append("    updateTime: ").append(toIndentedString(updateTime)).append("\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
    sb.append("    custom: ").append(toIndentedString(custom)).append("\n");
    sb.append("    refundFromTransactionFee: ").append(toIndentedString(refundFromTransactionFee)).append("\n");
    sb.append("    refundFromReceivedAmount: ").append(toIndentedString(refundFromReceivedAmount)).append("\n");
    sb.append("    totalRefundedAmount: ").append(toIndentedString(totalRefundedAmount)).append("\n");
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

    // add `amount` to the URL query string
    if (getAmount() != null) {
      joiner.add(getAmount().toUrlQueryString(prefix + "amount" + suffix));
    }

    // add `state` to the URL query string
    if (getState() != null) {
      try {
        joiner.add(String.format("%sstate%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getState()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `reason` to the URL query string
    if (getReason() != null) {
      try {
        joiner.add(String.format("%sreason%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getReason()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `invoice_number` to the URL query string
    if (getInvoiceNumber() != null) {
      try {
        joiner.add(String.format("%sinvoice_number%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getInvoiceNumber()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `sale_id` to the URL query string
    if (getSaleId() != null) {
      try {
        joiner.add(String.format("%ssale_id%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getSaleId()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `capture_id` to the URL query string
    if (getCaptureId() != null) {
      try {
        joiner.add(String.format("%scapture_id%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getCaptureId()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `parent_payment` to the URL query string
    if (getParentPayment() != null) {
      try {
        joiner.add(String.format("%sparent_payment%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getParentPayment()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `description` to the URL query string
    if (getDescription() != null) {
      try {
        joiner.add(String.format("%sdescription%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getDescription()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `create_time` to the URL query string
    if (getCreateTime() != null) {
      try {
        joiner.add(String.format("%screate_time%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getCreateTime()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `update_time` to the URL query string
    if (getUpdateTime() != null) {
      try {
        joiner.add(String.format("%supdate_time%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getUpdateTime()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `links` to the URL query string
    if (getLinks() != null) {
      for (int i = 0; i < getLinks().size(); i++) {
        if (getLinks().get(i) != null) {
          joiner.add(getLinks().get(i).toUrlQueryString(String.format("%slinks%s%s", prefix, suffix,
              "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix))));
        }
      }
    }

    // add `custom` to the URL query string
    if (getCustom() != null) {
      try {
        joiner.add(String.format("%scustom%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getCustom()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `refund_from_transaction_fee` to the URL query string
    if (getRefundFromTransactionFee() != null) {
      joiner.add(getRefundFromTransactionFee().toUrlQueryString(prefix + "refund_from_transaction_fee" + suffix));
    }

    // add `refund_from_received_amount` to the URL query string
    if (getRefundFromReceivedAmount() != null) {
      joiner.add(getRefundFromReceivedAmount().toUrlQueryString(prefix + "refund_from_received_amount" + suffix));
    }

    // add `total_refunded_amount` to the URL query string
    if (getTotalRefundedAmount() != null) {
      joiner.add(getTotalRefundedAmount().toUrlQueryString(prefix + "total_refunded_amount" + suffix));
    }

    return joiner.toString();
  }

}

