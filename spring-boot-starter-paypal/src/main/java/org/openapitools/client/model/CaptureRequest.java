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


package org.openapitools.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.client.model.Money;
import org.openapitools.client.model.PaymentInstruction;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.StringJoiner;

/**
 * Captures either a portion or the full authorized amount of an authorized payment.
 */
@JsonPropertyOrder({
  CaptureRequest.JSON_PROPERTY_INVOICE_ID,
  CaptureRequest.JSON_PROPERTY_NOTE_TO_PAYER,
  CaptureRequest.JSON_PROPERTY_AMOUNT,
  CaptureRequest.JSON_PROPERTY_FINAL_CAPTURE,
  CaptureRequest.JSON_PROPERTY_PAYMENT_INSTRUCTION,
  CaptureRequest.JSON_PROPERTY_SOFT_DESCRIPTOR
})
@JsonTypeName("capture_request")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-06-11T03:52:37.374153451Z[Atlantic/Reykjavik]")
public class CaptureRequest {
  public static final String JSON_PROPERTY_INVOICE_ID = "invoice_id";
  private String invoiceId;

  public static final String JSON_PROPERTY_NOTE_TO_PAYER = "note_to_payer";
  private String noteToPayer;

  public static final String JSON_PROPERTY_AMOUNT = "amount";
  private Money amount;

  public static final String JSON_PROPERTY_FINAL_CAPTURE = "final_capture";
  private Boolean finalCapture = false;

  public static final String JSON_PROPERTY_PAYMENT_INSTRUCTION = "payment_instruction";
  private PaymentInstruction paymentInstruction;

  public static final String JSON_PROPERTY_SOFT_DESCRIPTOR = "soft_descriptor";
  private String softDescriptor;

  public CaptureRequest() {
  }

  public CaptureRequest invoiceId(String invoiceId) {
    
    this.invoiceId = invoiceId;
    return this;
  }

   /**
   * The API caller-provided external invoice number for this order. Appears in both the payer&#39;s transaction history and the emails that the payer receives.
   * @return invoiceId
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_INVOICE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getInvoiceId() {
    return invoiceId;
  }


  @JsonProperty(JSON_PROPERTY_INVOICE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInvoiceId(String invoiceId) {
    this.invoiceId = invoiceId;
  }


  public CaptureRequest noteToPayer(String noteToPayer) {
    
    this.noteToPayer = noteToPayer;
    return this;
  }

   /**
   * An informational note about this settlement. Appears in both the payer&#39;s transaction history and the emails that the payer receives.
   * @return noteToPayer
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_NOTE_TO_PAYER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getNoteToPayer() {
    return noteToPayer;
  }


  @JsonProperty(JSON_PROPERTY_NOTE_TO_PAYER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNoteToPayer(String noteToPayer) {
    this.noteToPayer = noteToPayer;
  }


  public CaptureRequest amount(Money amount) {
    
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

  public Money getAmount() {
    return amount;
  }


  @JsonProperty(JSON_PROPERTY_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAmount(Money amount) {
    this.amount = amount;
  }


  public CaptureRequest finalCapture(Boolean finalCapture) {
    
    this.finalCapture = finalCapture;
    return this;
  }

   /**
   * Indicates whether you can make additional captures against the authorized payment. Set to &#x60;true&#x60; if you do not intend to capture additional payments against the authorization. Set to &#x60;false&#x60; if you intend to capture additional payments against the authorization.
   * @return finalCapture
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_FINAL_CAPTURE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getFinalCapture() {
    return finalCapture;
  }


  @JsonProperty(JSON_PROPERTY_FINAL_CAPTURE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFinalCapture(Boolean finalCapture) {
    this.finalCapture = finalCapture;
  }


  public CaptureRequest paymentInstruction(PaymentInstruction paymentInstruction) {
    
    this.paymentInstruction = paymentInstruction;
    return this;
  }

   /**
   * Get paymentInstruction
   * @return paymentInstruction
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PAYMENT_INSTRUCTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public PaymentInstruction getPaymentInstruction() {
    return paymentInstruction;
  }


  @JsonProperty(JSON_PROPERTY_PAYMENT_INSTRUCTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPaymentInstruction(PaymentInstruction paymentInstruction) {
    this.paymentInstruction = paymentInstruction;
  }


  public CaptureRequest softDescriptor(String softDescriptor) {
    
    this.softDescriptor = softDescriptor;
    return this;
  }

   /**
   * The payment descriptor on the payer&#39;s account statement.
   * @return softDescriptor
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SOFT_DESCRIPTOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSoftDescriptor() {
    return softDescriptor;
  }


  @JsonProperty(JSON_PROPERTY_SOFT_DESCRIPTOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSoftDescriptor(String softDescriptor) {
    this.softDescriptor = softDescriptor;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CaptureRequest captureRequest = (CaptureRequest) o;
    return Objects.equals(this.invoiceId, captureRequest.invoiceId) &&
        Objects.equals(this.noteToPayer, captureRequest.noteToPayer) &&
        Objects.equals(this.amount, captureRequest.amount) &&
        Objects.equals(this.finalCapture, captureRequest.finalCapture) &&
        Objects.equals(this.paymentInstruction, captureRequest.paymentInstruction) &&
        Objects.equals(this.softDescriptor, captureRequest.softDescriptor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(invoiceId, noteToPayer, amount, finalCapture, paymentInstruction, softDescriptor);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CaptureRequest {\n");
    sb.append("    invoiceId: ").append(toIndentedString(invoiceId)).append("\n");
    sb.append("    noteToPayer: ").append(toIndentedString(noteToPayer)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    finalCapture: ").append(toIndentedString(finalCapture)).append("\n");
    sb.append("    paymentInstruction: ").append(toIndentedString(paymentInstruction)).append("\n");
    sb.append("    softDescriptor: ").append(toIndentedString(softDescriptor)).append("\n");
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

    // add `invoice_id` to the URL query string
    if (getInvoiceId() != null) {
      try {
        joiner.add(String.format("%sinvoice_id%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getInvoiceId()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `note_to_payer` to the URL query string
    if (getNoteToPayer() != null) {
      try {
        joiner.add(String.format("%snote_to_payer%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getNoteToPayer()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `amount` to the URL query string
    if (getAmount() != null) {
      joiner.add(getAmount().toUrlQueryString(prefix + "amount" + suffix));
    }

    // add `final_capture` to the URL query string
    if (getFinalCapture() != null) {
      try {
        joiner.add(String.format("%sfinal_capture%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getFinalCapture()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `payment_instruction` to the URL query string
    if (getPaymentInstruction() != null) {
      joiner.add(getPaymentInstruction().toUrlQueryString(prefix + "payment_instruction" + suffix));
    }

    // add `soft_descriptor` to the URL query string
    if (getSoftDescriptor() != null) {
      try {
        joiner.add(String.format("%ssoft_descriptor%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getSoftDescriptor()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    return joiner.toString();
  }

}

