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
 * The error details. Required for client-side &#x60;4XX&#x60; errors.
 */
@JsonPropertyOrder({
  ErrorDetails2.JSON_PROPERTY_FIELD,
  ErrorDetails2.JSON_PROPERTY_VALUE,
  ErrorDetails2.JSON_PROPERTY_LOCATION,
  ErrorDetails2.JSON_PROPERTY_ISSUE,
  ErrorDetails2.JSON_PROPERTY_DESCRIPTION
})
@JsonTypeName("error_details-2")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-06-11T03:56:12.691299337Z[Atlantic/Reykjavik]")
public class ErrorDetails2 {
  public static final String JSON_PROPERTY_FIELD = "field";
  private String field;

  public static final String JSON_PROPERTY_VALUE = "value";
  private String value;

  public static final String JSON_PROPERTY_LOCATION = "location";
  private String location = "body";

  public static final String JSON_PROPERTY_ISSUE = "issue";
  private String issue;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;

  public ErrorDetails2() {
  }

  public ErrorDetails2 field(String field) {
    
    this.field = field;
    return this;
  }

   /**
   * The field that caused the error. If this field is in the body, set this value to the field&#39;s JSON pointer value. Required for client-side errors.
   * @return field
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_FIELD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getField() {
    return field;
  }


  @JsonProperty(JSON_PROPERTY_FIELD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setField(String field) {
    this.field = field;
  }


  public ErrorDetails2 value(String value) {
    
    this.value = value;
    return this;
  }

   /**
   * The value of the field that caused the error.
   * @return value
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getValue() {
    return value;
  }


  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setValue(String value) {
    this.value = value;
  }


  public ErrorDetails2 location(String location) {
    
    this.location = location;
    return this;
  }

   /**
   * The location of the field that caused the error. Value is &#x60;body&#x60;, &#x60;path&#x60;, or &#x60;query&#x60;.
   * @return location
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_LOCATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getLocation() {
    return location;
  }


  @JsonProperty(JSON_PROPERTY_LOCATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLocation(String location) {
    this.location = location;
  }


  public ErrorDetails2 issue(String issue) {
    
    this.issue = issue;
    return this;
  }

   /**
   * The unique, fine-grained application-level error code.
   * @return issue
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_ISSUE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getIssue() {
    return issue;
  }


  @JsonProperty(JSON_PROPERTY_ISSUE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setIssue(String issue) {
    this.issue = issue;
  }


  public ErrorDetails2 description(String description) {
    
    this.description = description;
    return this;
  }

   /**
   * The human-readable description for an issue. The description can change over the lifetime of an API, so clients must not depend on this value.
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorDetails2 errorDetails2 = (ErrorDetails2) o;
    return Objects.equals(this.field, errorDetails2.field) &&
        Objects.equals(this.value, errorDetails2.value) &&
        Objects.equals(this.location, errorDetails2.location) &&
        Objects.equals(this.issue, errorDetails2.issue) &&
        Objects.equals(this.description, errorDetails2.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(field, value, location, issue, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorDetails2 {\n");
    sb.append("    field: ").append(toIndentedString(field)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    issue: ").append(toIndentedString(issue)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

    // add `field` to the URL query string
    if (getField() != null) {
      try {
        joiner.add(String.format("%sfield%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getField()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `value` to the URL query string
    if (getValue() != null) {
      try {
        joiner.add(String.format("%svalue%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getValue()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `location` to the URL query string
    if (getLocation() != null) {
      try {
        joiner.add(String.format("%slocation%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getLocation()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `issue` to the URL query string
    if (getIssue() != null) {
      try {
        joiner.add(String.format("%sissue%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getIssue()), "UTF-8").replaceAll("\\+", "%20")));
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

    return joiner.toString();
  }

}
