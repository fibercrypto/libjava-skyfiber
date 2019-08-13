/*
 * Skycoin REST API.
 * Skycoin is a next-generation cryptocurrency.
 *
 * The version of the OpenAPI document: 0.27.0
 * Contact: contact@skycoin.net
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Represent unconfirmed transactions
 */
@ApiModel(description = "Represent unconfirmed transactions")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-08-06T00:13:07.983-04:00[America/Havana]")
public class NetworkConnectionSchemaUnconfirmedVerifyTransaction {
  @JsonProperty("burn_factor")
  private Integer burnFactor;

  @JsonProperty("max_decimals")
  private Integer maxDecimals;

  @JsonProperty("max_transaction_size")
  private Integer maxTransactionSize;

  public NetworkConnectionSchemaUnconfirmedVerifyTransaction burnFactor(Integer burnFactor) {
    this.burnFactor = burnFactor;
    return this;
  }

   /**
   * Get burnFactor
   * @return burnFactor
  **/
  @ApiModelProperty(value = "")
  public Integer getBurnFactor() {
    return burnFactor;
  }

  public void setBurnFactor(Integer burnFactor) {
    this.burnFactor = burnFactor;
  }

  public NetworkConnectionSchemaUnconfirmedVerifyTransaction maxDecimals(Integer maxDecimals) {
    this.maxDecimals = maxDecimals;
    return this;
  }

   /**
   * Get maxDecimals
   * @return maxDecimals
  **/
  @ApiModelProperty(value = "")
  public Integer getMaxDecimals() {
    return maxDecimals;
  }

  public void setMaxDecimals(Integer maxDecimals) {
    this.maxDecimals = maxDecimals;
  }

  public NetworkConnectionSchemaUnconfirmedVerifyTransaction maxTransactionSize(Integer maxTransactionSize) {
    this.maxTransactionSize = maxTransactionSize;
    return this;
  }

   /**
   * Get maxTransactionSize
   * @return maxTransactionSize
  **/
  @ApiModelProperty(value = "")
  public Integer getMaxTransactionSize() {
    return maxTransactionSize;
  }

  public void setMaxTransactionSize(Integer maxTransactionSize) {
    this.maxTransactionSize = maxTransactionSize;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NetworkConnectionSchemaUnconfirmedVerifyTransaction networkConnectionSchemaUnconfirmedVerifyTransaction = (NetworkConnectionSchemaUnconfirmedVerifyTransaction) o;
    return Objects.equals(this.burnFactor, networkConnectionSchemaUnconfirmedVerifyTransaction.burnFactor) &&
        Objects.equals(this.maxDecimals, networkConnectionSchemaUnconfirmedVerifyTransaction.maxDecimals) &&
        Objects.equals(this.maxTransactionSize, networkConnectionSchemaUnconfirmedVerifyTransaction.maxTransactionSize);
  }

  @Override
  public int hashCode() {
    return Objects.hash(burnFactor, maxDecimals, maxTransactionSize);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NetworkConnectionSchemaUnconfirmedVerifyTransaction {\n");
    sb.append("    burnFactor: ").append(toIndentedString(burnFactor)).append("\n");
    sb.append("    maxDecimals: ").append(toIndentedString(maxDecimals)).append("\n");
    sb.append("    maxTransactionSize: ").append(toIndentedString(maxTransactionSize)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

