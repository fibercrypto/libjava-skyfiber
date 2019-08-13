package org.openapitools.client.api.rxjava;

import org.openapitools.client.model.Address;
import org.openapitools.client.model.BlockSchema;
import org.openapitools.client.model.InlineResponse200;
import org.openapitools.client.model.InlineResponse2001;
import org.openapitools.client.model.InlineResponse20010;
import org.openapitools.client.model.InlineResponse2002;
import org.openapitools.client.model.InlineResponse2003;
import org.openapitools.client.model.InlineResponse2004;
import org.openapitools.client.model.InlineResponse2005;
import org.openapitools.client.model.InlineResponse2006;
import org.openapitools.client.model.InlineResponse2007;
import org.openapitools.client.model.InlineResponse2008;
import org.openapitools.client.model.InlineResponse2009;
import org.openapitools.client.model.InlineResponseDefault;
import org.openapitools.client.model.NetworkConnectionSchema;
import org.openapitools.client.model.Transaction;
import org.openapitools.client.model.TransactionV2ParamsAddress;
import org.openapitools.client.model.TransactionV2ParamsUnspent;
import org.openapitools.client.model.TransactionVerifyRequest;
import org.openapitools.client.model.WalletTransactionRequest;
import org.openapitools.client.model.WalletTransactionSignRequest;

import java.util.*;

import rx.Single;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-08-06T00:35:41.357-04:00[America/Havana]")
public class DefaultApi {

	private final org.openapitools.client.api.DefaultApi delegate;

	public DefaultApi(org.openapitools.client.api.DefaultApi delegate) {
	    this.delegate = delegate;
    }

	public org.openapitools.client.api.DefaultApi getDelegate() {
	    return delegate;
	}

    /**
     * Returns the total number of unique address that have coins.
     * 
     * @param resultHandler Asynchronous result handler
     */
    public void addressCount(Handler<AsyncResult<InlineResponse200>> resultHandler) {
        delegate.addressCount(resultHandler);
    }

    /**
     * Returns the total number of unique address that have coins.
     * 
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<InlineResponse200> rxAddressCount() {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.addressCount(fut);
        }));
    }
    /**
     * 
     * Returns the historical, spent outputs associated with an address
     * @param address address to filter by (required)
     * @param resultHandler Asynchronous result handler
     */
    public void addressUxouts(String address, Handler<AsyncResult<List<Object>>> resultHandler) {
        delegate.addressUxouts(address, resultHandler);
    }

    /**
     * 
     * Returns the historical, spent outputs associated with an address
     * @param address address to filter by (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<List<Object>> rxAddressUxouts(String address) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.addressUxouts(address, fut);
        }));
    }
    /**
     * 
     * 
     * @param resultHandler Asynchronous result handler
     */
    public void apiV1RawtxGet(Handler<AsyncResult<String>> resultHandler) {
        delegate.apiV1RawtxGet(resultHandler);
    }

    /**
     * 
     * 
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<String> rxApiV1RawtxGet() {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV1RawtxGet(fut);
        }));
    }
    /**
     * 
     * 
     * @param resultHandler Asynchronous result handler
     */
    public void apiV2MetricsGet(Handler<AsyncResult<String>> resultHandler) {
        delegate.apiV2MetricsGet(resultHandler);
    }

    /**
     * 
     * 
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<String> rxApiV2MetricsGet() {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.apiV2MetricsGet(fut);
        }));
    }
    /**
     * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
     * 
     * @param addrs command separated list of addresses (required)
     * @param resultHandler Asynchronous result handler
     */
    public void balanceGet(String addrs, Handler<AsyncResult<Object>> resultHandler) {
        delegate.balanceGet(addrs, resultHandler);
    }

    /**
     * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
     * 
     * @param addrs command separated list of addresses (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Object> rxBalanceGet(String addrs) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.balanceGet(addrs, fut);
        }));
    }
    /**
     * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
     * 
     * @param addrs command separated list of addresses (required)
     * @param resultHandler Asynchronous result handler
     */
    public void balancePost(String addrs, Handler<AsyncResult<Object>> resultHandler) {
        delegate.balancePost(addrs, resultHandler);
    }

    /**
     * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
     * 
     * @param addrs command separated list of addresses (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Object> rxBalancePost(String addrs) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.balancePost(addrs, fut);
        }));
    }
    /**
     * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
     * 
     * @param hash get block by hash (optional)
     * @param seq get block by sequence number (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void block(String hash, Integer seq, Handler<AsyncResult<List<BlockSchema>>> resultHandler) {
        delegate.block(hash, seq, resultHandler);
    }

    /**
     * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
     * 
     * @param hash get block by hash (optional)
     * @param seq get block by sequence number (optional)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<List<BlockSchema>> rxBlock(String hash, Integer seq) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.block(hash, seq, fut);
        }));
    }
    /**
     * Returns the blockchain metadata.
     * 
     * @param resultHandler Asynchronous result handler
     */
    public void blockchainMetadata(Handler<AsyncResult<Object>> resultHandler) {
        delegate.blockchainMetadata(resultHandler);
    }

    /**
     * Returns the blockchain metadata.
     * 
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Object> rxBlockchainMetadata() {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.blockchainMetadata(fut);
        }));
    }
    /**
     * Returns the blockchain sync progress.
     * 
     * @param resultHandler Asynchronous result handler
     */
    public void blockchainProgress(Handler<AsyncResult<Object>> resultHandler) {
        delegate.blockchainProgress(resultHandler);
    }

    /**
     * Returns the blockchain sync progress.
     * 
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Object> rxBlockchainProgress() {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.blockchainProgress(fut);
        }));
    }
    /**
     * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
     * 
     * @param start start seq (optional)
     * @param end end seq (optional)
     * @param seq comma-separated list of block seqs (optional, default to new ArrayList&lt;&gt;())
     * @param resultHandler Asynchronous result handler
     */
    public void blocks(Integer start, Integer end, List<Integer> seq, Handler<AsyncResult<InlineResponse2001>> resultHandler) {
        delegate.blocks(start, end, seq, resultHandler);
    }

    /**
     * Returns the balance of one or more addresses, both confirmed and predicted. The predicted balance is the confirmed balance minus the pending spends.
     * 
     * @param start start seq (optional)
     * @param end end seq (optional)
     * @param seq comma-separated list of block seqs (optional, default to new ArrayList&lt;&gt;())
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<InlineResponse2001> rxBlocks(Integer start, Integer end, List<Integer> seq) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.blocks(start, end, seq, fut);
        }));
    }
    /**
     * 
     * coinSupplyHandler returns coin distribution supply stats
     * @param resultHandler Asynchronous result handler
     */
    public void coinSupply(Handler<AsyncResult<InlineResponse2002>> resultHandler) {
        delegate.coinSupply(resultHandler);
    }

    /**
     * 
     * coinSupplyHandler returns coin distribution supply stats
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<InlineResponse2002> rxCoinSupply() {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.coinSupply(fut);
        }));
    }
    /**
     * Creates a new CSRF token. Previous CSRF tokens are invalidated by this call.
     * 
     * @param resultHandler Asynchronous result handler
     */
    public void csrf(Handler<AsyncResult<InlineResponse2003>> resultHandler) {
        delegate.csrf(resultHandler);
    }

    /**
     * Creates a new CSRF token. Previous CSRF tokens are invalidated by this call.
     * 
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<InlineResponse2003> rxCsrf() {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.csrf(fut);
        }));
    }
    /**
     * 
     * 
     * @param type storage type. (optional)
     * @param key key of the specific value to get. (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void dataDELETE(String type, String key, Handler<AsyncResult<Void>> resultHandler) {
        delegate.dataDELETE(type, key, resultHandler);
    }

    /**
     * 
     * 
     * @param type storage type. (optional)
     * @param key key of the specific value to get. (optional)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxDataDELETE(String type, String key) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.dataDELETE(type, key, fut);
        }));
    }
    /**
     * 
     * 
     * @param type storage type. (optional)
     * @param key key of the specific value to get. (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void dataGET(String type, String key, Handler<AsyncResult<Object>> resultHandler) {
        delegate.dataGET(type, key, resultHandler);
    }

    /**
     * 
     * 
     * @param type storage type. (optional)
     * @param key key of the specific value to get. (optional)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Object> rxDataGET(String type, String key) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.dataGET(type, key, fut);
        }));
    }
    /**
     * 
     * 
     * @param type storage type. (optional)
     * @param key key of the specific value to get. (optional)
     * @param val additional value. (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void dataPOST(String type, String key, String val, Handler<AsyncResult<Void>> resultHandler) {
        delegate.dataPOST(type, key, val, resultHandler);
    }

    /**
     * 
     * 
     * @param type storage type. (optional)
     * @param key key of the specific value to get. (optional)
     * @param val additional value. (optional)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxDataPOST(String type, String key, String val) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.dataPOST(type, key, val, fut);
        }));
    }
    /**
     * defaultConnectionsHandler returns the list of default hardcoded bootstrap addresses.\\n They are not necessarily connected to.
     * 
     * @param resultHandler Asynchronous result handler
     */
    public void defaultConnections(Handler<AsyncResult<List<String>>> resultHandler) {
        delegate.defaultConnections(resultHandler);
    }

    /**
     * defaultConnectionsHandler returns the list of default hardcoded bootstrap addresses.\\n They are not necessarily connected to.
     * 
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<List<String>> rxDefaultConnections() {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.defaultConnections(fut);
        }));
    }
    /**
     * Returns node health data.
     * 
     * @param resultHandler Asynchronous result handler
     */
    public void health(Handler<AsyncResult<Object>> resultHandler) {
        delegate.health(resultHandler);
    }

    /**
     * Returns node health data.
     * 
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Object> rxHealth() {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.health(fut);
        }));
    }
    /**
     * 
     * Returns the most recent N blocks on the blockchain
     * @param num Num of blockss (required)
     * @param resultHandler Asynchronous result handler
     */
    public void lastBlocks(Integer num, Handler<AsyncResult<Object>> resultHandler) {
        delegate.lastBlocks(num, resultHandler);
    }

    /**
     * 
     * Returns the most recent N blocks on the blockchain
     * @param num Num of blockss (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Object> rxLastBlocks(Integer num) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.lastBlocks(num, fut);
        }));
    }
    /**
     * This endpoint returns a specific connection.
     * 
     * @param addr Address port (required)
     * @param resultHandler Asynchronous result handler
     */
    public void networkConnection(String addr, Handler<AsyncResult<NetworkConnectionSchema>> resultHandler) {
        delegate.networkConnection(addr, resultHandler);
    }

    /**
     * This endpoint returns a specific connection.
     * 
     * @param addr Address port (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<NetworkConnectionSchema> rxNetworkConnection(String addr) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.networkConnection(addr, fut);
        }));
    }
    /**
     * This endpoint returns all outgoings connections.
     * 
     * @param states Connection status. (optional)
     * @param direction Direction of the connection. (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void networkConnections(String states, String direction, Handler<AsyncResult<InlineResponse2004>> resultHandler) {
        delegate.networkConnections(states, direction, resultHandler);
    }

    /**
     * This endpoint returns all outgoings connections.
     * 
     * @param states Connection status. (optional)
     * @param direction Direction of the connection. (optional)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<InlineResponse2004> rxNetworkConnections(String states, String direction) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.networkConnections(states, direction, fut);
        }));
    }
    /**
     * 
     * This endpoint disconnects a connection by ID or address
     * @param id Address id. (required)
     * @param resultHandler Asynchronous result handler
     */
    public void networkConnectionsDisconnect(String id, Handler<AsyncResult<Void>> resultHandler) {
        delegate.networkConnectionsDisconnect(id, resultHandler);
    }

    /**
     * 
     * This endpoint disconnects a connection by ID or address
     * @param id Address id. (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxNetworkConnectionsDisconnect(String id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.networkConnectionsDisconnect(id, fut);
        }));
    }
    /**
     * 
     * This endpoint returns all connections found through peer exchange
     * @param resultHandler Asynchronous result handler
     */
    public void networkConnectionsExchange(Handler<AsyncResult<List<String>>> resultHandler) {
        delegate.networkConnectionsExchange(resultHandler);
    }

    /**
     * 
     * This endpoint returns all connections found through peer exchange
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<List<String>> rxNetworkConnectionsExchange() {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.networkConnectionsExchange(fut);
        }));
    }
    /**
     * trustConnectionsHandler returns all trusted connections.\\n They are not necessarily connected to. In the default configuration, these will be a subset of the default hardcoded bootstrap addresses.
     * 
     * @param resultHandler Asynchronous result handler
     */
    public void networkConnectionsTrust(Handler<AsyncResult<List<String>>> resultHandler) {
        delegate.networkConnectionsTrust(resultHandler);
    }

    /**
     * trustConnectionsHandler returns all trusted connections.\\n They are not necessarily connected to. In the default configuration, these will be a subset of the default hardcoded bootstrap addresses.
     * 
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<List<String>> rxNetworkConnectionsTrust() {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.networkConnectionsTrust(fut);
        }));
    }
    /**
     * If neither addrs nor hashes are specificed, return all unspent outputs. If only one filter is specified, then return outputs match the filter. Both filters cannot be specified.
     * 
     * @param address  (optional, default to new ArrayList&lt;&gt;())
     * @param hash  (optional, default to new ArrayList&lt;&gt;())
     * @param resultHandler Asynchronous result handler
     */
    public void outputsGet(List<String> address, List<String> hash, Handler<AsyncResult<Object>> resultHandler) {
        delegate.outputsGet(address, hash, resultHandler);
    }

    /**
     * If neither addrs nor hashes are specificed, return all unspent outputs. If only one filter is specified, then return outputs match the filter. Both filters cannot be specified.
     * 
     * @param address  (optional, default to new ArrayList&lt;&gt;())
     * @param hash  (optional, default to new ArrayList&lt;&gt;())
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Object> rxOutputsGet(List<String> address, List<String> hash) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.outputsGet(address, hash, fut);
        }));
    }
    /**
     * If neither addrs nor hashes are specificed, return all unspent outputs. If only one filter is specified, then return outputs match the filter. Both filters cannot be specified.
     * 
     * @param address  (optional)
     * @param hash  (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void outputsPost(String address, String hash, Handler<AsyncResult<Object>> resultHandler) {
        delegate.outputsPost(address, hash, resultHandler);
    }

    /**
     * If neither addrs nor hashes are specificed, return all unspent outputs. If only one filter is specified, then return outputs match the filter. Both filters cannot be specified.
     * 
     * @param address  (optional)
     * @param hash  (optional)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Object> rxOutputsPost(String address, String hash) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.outputsPost(address, hash, fut);
        }));
    }
    /**
     * 
     * 
     * @param resultHandler Asynchronous result handler
     */
    public void pendingTxs(Handler<AsyncResult<List<InlineResponse20010>>> resultHandler) {
        delegate.pendingTxs(resultHandler);
    }

    /**
     * 
     * 
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<List<InlineResponse20010>> rxPendingTxs() {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.pendingTxs(fut);
        }));
    }
    /**
     * 
     * Broadcasts all unconfirmed transactions from the unconfirmed transaction pool
     * @param resultHandler Asynchronous result handler
     */
    public void resendUnconfirmedTxns(Handler<AsyncResult<Object>> resultHandler) {
        delegate.resendUnconfirmedTxns(resultHandler);
    }

    /**
     * 
     * Broadcasts all unconfirmed transactions from the unconfirmed transaction pool
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Object> rxResendUnconfirmedTxns() {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.resendUnconfirmedTxns(fut);
        }));
    }
    /**
     * Returns the top skycoin holders.
     * 
     * @param includeDistribution include distribution addresses or not, default value false (optional)
     * @param n include distribution addresses or not, default value false (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void richlist(Boolean includeDistribution, String n, Handler<AsyncResult<Object>> resultHandler) {
        delegate.richlist(includeDistribution, n, resultHandler);
    }

    /**
     * Returns the top skycoin holders.
     * 
     * @param includeDistribution include distribution addresses or not, default value false (optional)
     * @param n include distribution addresses or not, default value false (optional)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Object> rxRichlist(Boolean includeDistribution, String n) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.richlist(includeDistribution, n, fut);
        }));
    }
    /**
     * 
     * Returns a transaction identified by its txid hash with just id
     * @param txid transaction Id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void transaction(String txid, Handler<AsyncResult<Transaction>> resultHandler) {
        delegate.transaction(txid, resultHandler);
    }

    /**
     * 
     * Returns a transaction identified by its txid hash with just id
     * @param txid transaction Id (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Transaction> rxTransaction(String txid) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.transaction(txid, fut);
        }));
    }
    /**
     * Broadcast a hex-encoded, serialized transaction to the network.
     * 
     * @param rawtx hex-encoded serialized transaction string. (required)
     * @param noBroadcast Disable the network broadcast (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void transactionInject(String rawtx, Boolean noBroadcast, Handler<AsyncResult<String>> resultHandler) {
        delegate.transactionInject(rawtx, noBroadcast, resultHandler);
    }

    /**
     * Broadcast a hex-encoded, serialized transaction to the network.
     * 
     * @param rawtx hex-encoded serialized transaction string. (required)
     * @param noBroadcast Disable the network broadcast (optional)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<String> rxTransactionInject(String rawtx, Boolean noBroadcast) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.transactionInject(rawtx, noBroadcast, fut);
        }));
    }
    /**
     * 
     * 
     * @param transactionV2ParamsAddress  (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void transactionPost(TransactionV2ParamsAddress transactionV2ParamsAddress, Handler<AsyncResult<InlineResponse2008>> resultHandler) {
        delegate.transactionPost(transactionV2ParamsAddress, resultHandler);
    }

    /**
     * 
     * 
     * @param transactionV2ParamsAddress  (optional)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<InlineResponse2008> rxTransactionPost(TransactionV2ParamsAddress transactionV2ParamsAddress) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.transactionPost(transactionV2ParamsAddress, fut);
        }));
    }
    /**
     * 
     * 
     * @param transactionV2ParamsUnspent Unspent parameters (required)
     * @param resultHandler Asynchronous result handler
     */
    public void transactionPostUnspent(TransactionV2ParamsUnspent transactionV2ParamsUnspent, Handler<AsyncResult<InlineResponse2008>> resultHandler) {
        delegate.transactionPostUnspent(transactionV2ParamsUnspent, resultHandler);
    }

    /**
     * 
     * 
     * @param transactionV2ParamsUnspent Unspent parameters (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<InlineResponse2008> rxTransactionPostUnspent(TransactionV2ParamsUnspent transactionV2ParamsUnspent) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.transactionPostUnspent(transactionV2ParamsUnspent, fut);
        }));
    }
    /**
     * Returns the hex-encoded byte serialization of a transaction. The transaction may be confirmed or unconfirmed.
     * 
     * @param txid Transaction id hash (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void transactionRaw(String txid, Handler<AsyncResult<Object>> resultHandler) {
        delegate.transactionRaw(txid, resultHandler);
    }

    /**
     * Returns the hex-encoded byte serialization of a transaction. The transaction may be confirmed or unconfirmed.
     * 
     * @param txid Transaction id hash (optional)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Object> rxTransactionRaw(String txid) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.transactionRaw(txid, fut);
        }));
    }
    /**
     * 
     * Decode and verify an encoded transaction
     * @param transactionVerifyRequest  (required)
     * @param resultHandler Asynchronous result handler
     */
    public void transactionVerify(TransactionVerifyRequest transactionVerifyRequest, Handler<AsyncResult<Object>> resultHandler) {
        delegate.transactionVerify(transactionVerifyRequest, resultHandler);
    }

    /**
     * 
     * Decode and verify an encoded transaction
     * @param transactionVerifyRequest  (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Object> rxTransactionVerify(TransactionVerifyRequest transactionVerifyRequest) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.transactionVerify(transactionVerifyRequest, fut);
        }));
    }
    /**
     * Returns transactions that match the filters.
     * 
     * @param addrs command separated list of addresses (optional)
     * @param confirmed Whether the transactions should be confirmed [optional, must be 0 or 1; if not provided, returns all] (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void transactionsGet(String addrs, String confirmed, Handler<AsyncResult<Object>> resultHandler) {
        delegate.transactionsGet(addrs, confirmed, resultHandler);
    }

    /**
     * Returns transactions that match the filters.
     * 
     * @param addrs command separated list of addresses (optional)
     * @param confirmed Whether the transactions should be confirmed [optional, must be 0 or 1; if not provided, returns all] (optional)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Object> rxTransactionsGet(String addrs, String confirmed) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.transactionsGet(addrs, confirmed, fut);
        }));
    }
    /**
     * Returns transactions that match the filters.
     * 
     * @param addrs command separated list of addresses (optional)
     * @param confirmed Whether the transactions should be confirmed [optional, must be 0 or 1; if not provided, returns all] (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void transactionsPost(String addrs, String confirmed, Handler<AsyncResult<Object>> resultHandler) {
        delegate.transactionsPost(addrs, confirmed, resultHandler);
    }

    /**
     * Returns transactions that match the filters.
     * 
     * @param addrs command separated list of addresses (optional)
     * @param confirmed Whether the transactions should be confirmed [optional, must be 0 or 1; if not provided, returns all] (optional)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Object> rxTransactionsPost(String addrs, String confirmed) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.transactionsPost(addrs, confirmed, fut);
        }));
    }
    /**
     * Returns an unspent output by ID.
     * 
     * @param uxid uxid to filter by (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void uxout(String uxid, Handler<AsyncResult<Object>> resultHandler) {
        delegate.uxout(uxid, resultHandler);
    }

    /**
     * Returns an unspent output by ID.
     * 
     * @param uxid uxid to filter by (optional)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Object> rxUxout(String uxid) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.uxout(uxid, fut);
        }));
    }
    /**
     * Verifies a Skycoin address.
     * 
     * @param address Address id. (required)
     * @param resultHandler Asynchronous result handler
     */
    public void verifyAddress(Address address, Handler<AsyncResult<Object>> resultHandler) {
        delegate.verifyAddress(address, resultHandler);
    }

    /**
     * Verifies a Skycoin address.
     * 
     * @param address Address id. (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Object> rxVerifyAddress(Address address) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.verifyAddress(address, fut);
        }));
    }
    /**
     * 
     * versionHandler returns the application version info
     * @param resultHandler Asynchronous result handler
     */
    public void version(Handler<AsyncResult<InlineResponse2005>> resultHandler) {
        delegate.version(resultHandler);
    }

    /**
     * 
     * versionHandler returns the application version info
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<InlineResponse2005> rxVersion() {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.version(fut);
        }));
    }
    /**
     * Returns a wallet by id.
     * 
     * @param id tags to filter by (required)
     * @param resultHandler Asynchronous result handler
     */
    public void wallet(String id, Handler<AsyncResult<Object>> resultHandler) {
        delegate.wallet(id, resultHandler);
    }

    /**
     * Returns a wallet by id.
     * 
     * @param id tags to filter by (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Object> rxWallet(String id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.wallet(id, fut);
        }));
    }
    /**
     * Returns the wallet&#39;s balance, both confirmed and predicted.  The predicted balance is the confirmed balance minus the pending spends.
     * 
     * @param id tags to filter by (required)
     * @param resultHandler Asynchronous result handler
     */
    public void walletBalance(String id, Handler<AsyncResult<Object>> resultHandler) {
        delegate.walletBalance(id, resultHandler);
    }

    /**
     * Returns the wallet&#39;s balance, both confirmed and predicted.  The predicted balance is the confirmed balance minus the pending spends.
     * 
     * @param id tags to filter by (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Object> rxWalletBalance(String id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.walletBalance(id, fut);
        }));
    }
    /**
     * 
     * Create a wallet
     * @param type wallet seed passphrase [optional, bip44 type wallet only] (required)
     * @param seed Wallet seed. (required)
     * @param label Wallet label. (required)
     * @param seedPassphrase wallet seed passphrase [optional, bip44 type wallet only] (optional)
     * @param bip44Coin BIP44 coin type [optional, defaults to 8000 (skycoin&#39;s coin type), only valid if type is \&quot;bip44\&quot;] (optional)
     * @param xpub xpub key [required for xpub wallets] (optional)
     * @param scan The number of addresses to scan ahead for balances. (optional)
     * @param encrypt Encrypt wallet. (optional)
     * @param password Wallet Password (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void walletCreate(String type, String seed, String label, String seedPassphrase, String bip44Coin, String xpub, Integer scan, Boolean encrypt, String password, Handler<AsyncResult<Object>> resultHandler) {
        delegate.walletCreate(type, seed, label, seedPassphrase, bip44Coin, xpub, scan, encrypt, password, resultHandler);
    }

    /**
     * 
     * Create a wallet
     * @param type wallet seed passphrase [optional, bip44 type wallet only] (required)
     * @param seed Wallet seed. (required)
     * @param label Wallet label. (required)
     * @param seedPassphrase wallet seed passphrase [optional, bip44 type wallet only] (optional)
     * @param bip44Coin BIP44 coin type [optional, defaults to 8000 (skycoin&#39;s coin type), only valid if type is \&quot;bip44\&quot;] (optional)
     * @param xpub xpub key [required for xpub wallets] (optional)
     * @param scan The number of addresses to scan ahead for balances. (optional)
     * @param encrypt Encrypt wallet. (optional)
     * @param password Wallet Password (optional)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Object> rxWalletCreate(String type, String seed, String label, String seedPassphrase, String bip44Coin, String xpub, Integer scan, Boolean encrypt, String password) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.walletCreate(type, seed, label, seedPassphrase, bip44Coin, xpub, scan, encrypt, password, fut);
        }));
    }
    /**
     * Decrypts wallet.
     * 
     * @param id Wallet id. (required)
     * @param password Wallet password. (required)
     * @param resultHandler Asynchronous result handler
     */
    public void walletDecrypt(String id, String password, Handler<AsyncResult<Object>> resultHandler) {
        delegate.walletDecrypt(id, password, resultHandler);
    }

    /**
     * Decrypts wallet.
     * 
     * @param id Wallet id. (required)
     * @param password Wallet password. (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Object> rxWalletDecrypt(String id, String password) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.walletDecrypt(id, password, fut);
        }));
    }
    /**
     * Encrypt wallet.
     * 
     * @param id Wallet id. (required)
     * @param password Wallet password. (required)
     * @param resultHandler Asynchronous result handler
     */
    public void walletEncrypt(String id, String password, Handler<AsyncResult<Object>> resultHandler) {
        delegate.walletEncrypt(id, password, resultHandler);
    }

    /**
     * Encrypt wallet.
     * 
     * @param id Wallet id. (required)
     * @param password Wallet password. (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Object> rxWalletEncrypt(String id, String password) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.walletEncrypt(id, password, fut);
        }));
    }
    /**
     * 
     * Returns the wallet directory path
     * @param addr Address port (required)
     * @param resultHandler Asynchronous result handler
     */
    public void walletFolder(String addr, Handler<AsyncResult<InlineResponse2007>> resultHandler) {
        delegate.walletFolder(addr, resultHandler);
    }

    /**
     * 
     * Returns the wallet directory path
     * @param addr Address port (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<InlineResponse2007> rxWalletFolder(String addr) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.walletFolder(addr, fut);
        }));
    }
    /**
     * 
     * Generates new addresses
     * @param id Wallet Id (required)
     * @param num The number you want to generate (optional)
     * @param password Wallet Password (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void walletNewAddress(String id, String num, String password, Handler<AsyncResult<Object>> resultHandler) {
        delegate.walletNewAddress(id, num, password, resultHandler);
    }

    /**
     * 
     * Generates new addresses
     * @param id Wallet Id (required)
     * @param num The number you want to generate (optional)
     * @param password Wallet Password (optional)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Object> rxWalletNewAddress(String id, String num, String password) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.walletNewAddress(id, num, password, fut);
        }));
    }
    /**
     * 
     * Returns the wallet directory path
     * @param entropy Entropy bitSize. (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void walletNewSeed(String entropy, Handler<AsyncResult<Object>> resultHandler) {
        delegate.walletNewSeed(entropy, resultHandler);
    }

    /**
     * 
     * Returns the wallet directory path
     * @param entropy Entropy bitSize. (optional)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Object> rxWalletNewSeed(String entropy) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.walletNewSeed(entropy, fut);
        }));
    }
    /**
     * Recovers an encrypted wallet by providing the seed. The first address will be generated from seed and compared to the first address of the specified wallet. If they match, the wallet will be regenerated with an optional password. If the wallet is not encrypted, an error is returned.
     * Recovers an encrypted wallet by providing the wallet seed and optional seed passphrase
     * @param id Wallet id. (required)
     * @param seed Wallet seed. (required)
     * @param seedPassphrase Wallet seed-passphrase. (optional)
     * @param password Wallet password. (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void walletRecover(String id, String seed, String seedPassphrase, String password, Handler<AsyncResult<Object>> resultHandler) {
        delegate.walletRecover(id, seed, seedPassphrase, password, resultHandler);
    }

    /**
     * Recovers an encrypted wallet by providing the seed. The first address will be generated from seed and compared to the first address of the specified wallet. If they match, the wallet will be regenerated with an optional password. If the wallet is not encrypted, an error is returned.
     * Recovers an encrypted wallet by providing the wallet seed and optional seed passphrase
     * @param id Wallet id. (required)
     * @param seed Wallet seed. (required)
     * @param seedPassphrase Wallet seed-passphrase. (optional)
     * @param password Wallet password. (optional)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Object> rxWalletRecover(String id, String seed, String seedPassphrase, String password) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.walletRecover(id, seed, seedPassphrase, password, fut);
        }));
    }
    /**
     * This endpoint only works for encrypted wallets. If the wallet is unencrypted, The seed will be not returned.
     * 
     * @param id Wallet Id. (required)
     * @param password Wallet password. (required)
     * @param resultHandler Asynchronous result handler
     */
    public void walletSeed(String id, String password, Handler<AsyncResult<Object>> resultHandler) {
        delegate.walletSeed(id, password, resultHandler);
    }

    /**
     * This endpoint only works for encrypted wallets. If the wallet is unencrypted, The seed will be not returned.
     * 
     * @param id Wallet Id. (required)
     * @param password Wallet password. (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Object> rxWalletSeed(String id, String password) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.walletSeed(id, password, fut);
        }));
    }
    /**
     * Verifies a wallet seed.
     * 
     * @param seed Seed to be verified. (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void walletSeedVerify(String seed, Handler<AsyncResult<Object>> resultHandler) {
        delegate.walletSeedVerify(seed, resultHandler);
    }

    /**
     * Verifies a wallet seed.
     * 
     * @param seed Seed to be verified. (optional)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Object> rxWalletSeedVerify(String seed) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.walletSeedVerify(seed, fut);
        }));
    }
    /**
     * Creates a signed transaction
     * 
     * @param walletTransactionRequest  (required)
     * @param resultHandler Asynchronous result handler
     */
    public void walletTransaction(WalletTransactionRequest walletTransactionRequest, Handler<AsyncResult<Object>> resultHandler) {
        delegate.walletTransaction(walletTransactionRequest, resultHandler);
    }

    /**
     * Creates a signed transaction
     * 
     * @param walletTransactionRequest  (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Object> rxWalletTransaction(WalletTransactionRequest walletTransactionRequest) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.walletTransaction(walletTransactionRequest, fut);
        }));
    }
    /**
     * Creates a signed transaction
     * 
     * @param walletTransactionSignRequest  (required)
     * @param resultHandler Asynchronous result handler
     */
    public void walletTransactionSign(WalletTransactionSignRequest walletTransactionSignRequest, Handler<AsyncResult<InlineResponse2009>> resultHandler) {
        delegate.walletTransactionSign(walletTransactionSignRequest, resultHandler);
    }

    /**
     * Creates a signed transaction
     * 
     * @param walletTransactionSignRequest  (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<InlineResponse2009> rxWalletTransactionSign(WalletTransactionSignRequest walletTransactionSignRequest) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.walletTransactionSign(walletTransactionSignRequest, fut);
        }));
    }
    /**
     * 
     * 
     * @param id Wallet Id. (required)
     * @param resultHandler Asynchronous result handler
     */
    public void walletTransactions(String id, Handler<AsyncResult<InlineResponse2006>> resultHandler) {
        delegate.walletTransactions(id, resultHandler);
    }

    /**
     * 
     * 
     * @param id Wallet Id. (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<InlineResponse2006> rxWalletTransactions(String id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.walletTransactions(id, fut);
        }));
    }
    /**
     * Unloads wallet from the wallet service.
     * 
     * @param id Wallet Id. (required)
     * @param resultHandler Asynchronous result handler
     */
    public void walletUnload(String id, Handler<AsyncResult<Void>> resultHandler) {
        delegate.walletUnload(id, resultHandler);
    }

    /**
     * Unloads wallet from the wallet service.
     * 
     * @param id Wallet Id. (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<Void> rxWalletUnload(String id) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.walletUnload(id, fut);
        }));
    }
    /**
     * Update the wallet.
     * 
     * @param id Wallet Id. (required)
     * @param label The label the wallet will be updated to. (required)
     * @param resultHandler Asynchronous result handler
     */
    public void walletUpdate(String id, String label, Handler<AsyncResult<String>> resultHandler) {
        delegate.walletUpdate(id, label, resultHandler);
    }

    /**
     * Update the wallet.
     * 
     * @param id Wallet Id. (required)
     * @param label The label the wallet will be updated to. (required)
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<String> rxWalletUpdate(String id, String label) {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.walletUpdate(id, label, fut);
        }));
    }
    /**
     * 
     * Returns all loaded wallets
     * @param resultHandler Asynchronous result handler
     */
    public void wallets(Handler<AsyncResult<List<Object>>> resultHandler) {
        delegate.wallets(resultHandler);
    }

    /**
     * 
     * Returns all loaded wallets
     * @return Asynchronous result handler (RxJava Single)
     */
    public Single<List<Object>> rxWallets() {
        return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
            delegate.wallets(fut);
        }));
    }

    public static DefaultApi newInstance(org.openapitools.client.api.DefaultApi arg) {
        return arg != null ? new DefaultApi(arg) : null;
    }
}
