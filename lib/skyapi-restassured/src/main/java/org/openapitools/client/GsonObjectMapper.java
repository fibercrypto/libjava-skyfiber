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


package org.openapitools.client;

import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;

public class GsonObjectMapper implements ObjectMapper {

    private JSON json;

    private GsonObjectMapper() {
        this.json = new JSON();
    }

    public static GsonObjectMapper gson() {
        return new GsonObjectMapper();
    }

    @Override
    public Object deserialize(ObjectMapperDeserializationContext context) {
        return json.deserialize(context.getDataToDeserialize().asString(), context.getType());
    }

    @Override
    public Object serialize(ObjectMapperSerializationContext context) {
        return json.serialize(context.getObjectToSerialize());
    }
}