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
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.client.model.TransactionV2ParamsUnspentHoursSelection;
import org.openapitools.client.model.TransactionV2ParamsUnspentTo;

/**
 * TransactionV2ParamsUnspent
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-08-05T23:05:01.558-04:00[America/Havana]")
public class TransactionV2ParamsUnspent {
  public static final String SERIALIZED_NAME_HOURS_SELECTION = "hours_selection";
  @SerializedName(SERIALIZED_NAME_HOURS_SELECTION)
  private TransactionV2ParamsUnspentHoursSelection hoursSelection = null;

  public static final String SERIALIZED_NAME_UNSPENTS = "unspents";
  @SerializedName(SERIALIZED_NAME_UNSPENTS)
  private List<String> unspents = new ArrayList<String>();

  public static final String SERIALIZED_NAME_CHANGE_ADDRESS = "change_address";
  @SerializedName(SERIALIZED_NAME_CHANGE_ADDRESS)
  private String changeAddress;

  public static final String SERIALIZED_NAME_TO = "to";
  @SerializedName(SERIALIZED_NAME_TO)
  private List<TransactionV2ParamsUnspentTo> to = new ArrayList<TransactionV2ParamsUnspentTo>();

  public TransactionV2ParamsUnspent hoursSelection(TransactionV2ParamsUnspentHoursSelection hoursSelection) {
    this.hoursSelection = hoursSelection;
    return this;
  }

   /**
   * Get hoursSelection
   * @return hoursSelection
  **/
  @ApiModelProperty(value = "")
  public TransactionV2ParamsUnspentHoursSelection getHoursSelection() {
    return hoursSelection;
  }

  public void setHoursSelection(TransactionV2ParamsUnspentHoursSelection hoursSelection) {
    this.hoursSelection = hoursSelection;
  }

  public TransactionV2ParamsUnspent unspents(List<String> unspents) {
    this.unspents = unspents;
    return this;
  }

  public TransactionV2ParamsUnspent addUnspentsItem(String unspentsItem) {
    if (this.unspents == null) {
      this.unspents = new ArrayList<String>();
    }
    this.unspents.add(unspentsItem);
    return this;
  }

   /**
   * Get unspents
   * @return unspents
  **/
  @ApiModelProperty(value = "")
  public List<String> getUnspents() {
    return unspents;
  }

  public void setUnspents(List<String> unspents) {
    this.unspents = unspents;
  }

  public TransactionV2ParamsUnspent changeAddress(String changeAddress) {
    this.changeAddress = changeAddress;
    return this;
  }

   /**
   * Get changeAddress
   * @return changeAddress
  **/
  @ApiModelProperty(value = "")
  public String getChangeAddress() {
    return changeAddress;
  }

  public void setChangeAddress(String changeAddress) {
    this.changeAddress = changeAddress;
  }

  public TransactionV2ParamsUnspent to(List<TransactionV2ParamsUnspentTo> to) {
    this.to = to;
    return this;
  }

  public TransactionV2ParamsUnspent addToItem(TransactionV2ParamsUnspentTo toItem) {
    if (this.to == null) {
      this.to = new ArrayList<TransactionV2ParamsUnspentTo>();
    }
    this.to.add(toItem);
    return this;
  }

   /**
   * Get to
   * @return to
  **/
  @ApiModelProperty(value = "")
  public List<TransactionV2ParamsUnspentTo> getTo() {
    return to;
  }

  public void setTo(List<TransactionV2ParamsUnspentTo> to) {
    this.to = to;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionV2ParamsUnspent transactionV2ParamsUnspent = (TransactionV2ParamsUnspent) o;
    return Objects.equals(this.hoursSelection, transactionV2ParamsUnspent.hoursSelection) &&
        Objects.equals(this.unspents, transactionV2ParamsUnspent.unspents) &&
        Objects.equals(this.changeAddress, transactionV2ParamsUnspent.changeAddress) &&
        Objects.equals(this.to, transactionV2ParamsUnspent.to);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hoursSelection, unspents, changeAddress, to);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionV2ParamsUnspent {\n");
    sb.append("    hoursSelection: ").append(toIndentedString(hoursSelection)).append("\n");
    sb.append("    unspents: ").append(toIndentedString(unspents)).append("\n");
    sb.append("    changeAddress: ").append(toIndentedString(changeAddress)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
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

