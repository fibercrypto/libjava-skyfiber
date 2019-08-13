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
 * ApiV1PendingTxsTransactionOutputs
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-08-06T00:13:07.983-04:00[America/Havana]")
public class ApiV1PendingTxsTransactionOutputs {
  @JsonProperty("uxid")
  private String uxid;

  @JsonProperty("dst")
  private String dst;

  @JsonProperty("coins")
  private String coins;

  @JsonProperty("hours")
  private Long hours;

  public ApiV1PendingTxsTransactionOutputs uxid(String uxid) {
    this.uxid = uxid;
    return this;
  }

   /**
   * Get uxid
   * @return uxid
  **/
  @ApiModelProperty(value = "")
  public String getUxid() {
    return uxid;
  }

  public void setUxid(String uxid) {
    this.uxid = uxid;
  }

  public ApiV1PendingTxsTransactionOutputs dst(String dst) {
    this.dst = dst;
    return this;
  }

   /**
   * Get dst
   * @return dst
  **/
  @ApiModelProperty(value = "")
  public String getDst() {
    return dst;
  }

  public void setDst(String dst) {
    this.dst = dst;
  }

  public ApiV1PendingTxsTransactionOutputs coins(String coins) {
    this.coins = coins;
    return this;
  }

   /**
   * Get coins
   * @return coins
  **/
  @ApiModelProperty(value = "")
  public String getCoins() {
    return coins;
  }

  public void setCoins(String coins) {
    this.coins = coins;
  }

  public ApiV1PendingTxsTransactionOutputs hours(Long hours) {
    this.hours = hours;
    return this;
  }

   /**
   * Get hours
   * @return hours
  **/
  @ApiModelProperty(value = "")
  public Long getHours() {
    return hours;
  }

  public void setHours(Long hours) {
    this.hours = hours;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiV1PendingTxsTransactionOutputs apiV1PendingTxsTransactionOutputs = (ApiV1PendingTxsTransactionOutputs) o;
    return Objects.equals(this.uxid, apiV1PendingTxsTransactionOutputs.uxid) &&
        Objects.equals(this.dst, apiV1PendingTxsTransactionOutputs.dst) &&
        Objects.equals(this.coins, apiV1PendingTxsTransactionOutputs.coins) &&
        Objects.equals(this.hours, apiV1PendingTxsTransactionOutputs.hours);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uxid, dst, coins, hours);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiV1PendingTxsTransactionOutputs {\n");
    sb.append("    uxid: ").append(toIndentedString(uxid)).append("\n");
    sb.append("    dst: ").append(toIndentedString(dst)).append("\n");
    sb.append("    coins: ").append(toIndentedString(coins)).append("\n");
    sb.append("    hours: ").append(toIndentedString(hours)).append("\n");
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

