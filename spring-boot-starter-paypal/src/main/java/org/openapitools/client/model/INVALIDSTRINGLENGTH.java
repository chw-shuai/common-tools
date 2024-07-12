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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.StringJoiner;

/**
 * INVALIDSTRINGLENGTH
 */
@JsonPropertyOrder({
  INVALIDSTRINGLENGTH.JSON_PROPERTY_ISSUE,
  INVALIDSTRINGLENGTH.JSON_PROPERTY_DESCRIPTION
})
@JsonTypeName("INVALID_STRING_LENGTH")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-06-11T03:52:37.374153451Z[Atlantic/Reykjavik]")
public class INVALIDSTRINGLENGTH {
  /**
   * Gets or Sets issue
   */
  public enum IssueEnum {
    INVALID_STRING_LENGTH("INVALID_STRING_LENGTH");

    private String value;

    IssueEnum(String value) {
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
    public static IssueEnum fromValue(String value) {
      for (IssueEnum b : IssueEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_ISSUE = "issue";
  private IssueEnum issue;

  /**
   * Gets or Sets description
   */
  public enum DescriptionEnum {
    THE_VALUE_OF_A_FIELD_IS_EITHER_TOO_SHORT_OR_TOO_LONG_("The value of a field is either too short or too long.");

    private String value;

    DescriptionEnum(String value) {
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
    public static DescriptionEnum fromValue(String value) {
      for (DescriptionEnum b : DescriptionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private DescriptionEnum description;

  public INVALIDSTRINGLENGTH() {
  }

  public INVALIDSTRINGLENGTH issue(IssueEnum issue) {
    
    this.issue = issue;
    return this;
  }

   /**
   * Get issue
   * @return issue
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ISSUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public IssueEnum getIssue() {
    return issue;
  }


  @JsonProperty(JSON_PROPERTY_ISSUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIssue(IssueEnum issue) {
    this.issue = issue;
  }


  public INVALIDSTRINGLENGTH description(DescriptionEnum description) {
    
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public DescriptionEnum getDescription() {
    return description;
  }


  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDescription(DescriptionEnum description) {
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
    INVALIDSTRINGLENGTH INVALID_STRING_LENGTH = (INVALIDSTRINGLENGTH) o;
    return Objects.equals(this.issue, INVALID_STRING_LENGTH.issue) &&
        Objects.equals(this.description, INVALID_STRING_LENGTH.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(issue, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class INVALIDSTRINGLENGTH {\n");
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

