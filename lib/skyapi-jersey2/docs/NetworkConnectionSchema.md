

# NetworkConnectionSchema

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**address** | **String** |  |  [optional]
**connectedAt** | **Long** |  |  [optional]
**height** | **Long** |  |  [optional]
**id** | **Long** |  |  [optional]
**isTrustedPeer** | **Boolean** |  |  [optional]
**lastReceived** | **Long** |  |  [optional]
**lastSent** | **Long** |  |  [optional]
**listenPort** | **Integer** |  |  [optional]
**mirror** | **Integer** |  |  [optional]
**outgoing** | **Boolean** |  |  [optional]
**state** | [**StateEnum**](#StateEnum) |  |  [optional]
**unconfirmedVerifyTransaction** | [**NetworkConnectionSchemaUnconfirmedVerifyTransaction**](NetworkConnectionSchemaUnconfirmedVerifyTransaction.md) |  |  [optional]
**userAgent** | **String** |  |  [optional]



## Enum: StateEnum

Name | Value
---- | -----
PENDING | &quot;pending&quot;
CONNECTED | &quot;connected&quot;
INTRODUCED | &quot;introduced&quot;



