package org.openapitools.client.api;

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
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

import java.util.*;

public interface DefaultApi {

    void addressCount(Handler<AsyncResult<InlineResponse200>> handler);

    void addressUxouts(String address, Handler<AsyncResult<List<Object>>> handler);

    void apiV1RawtxGet(Handler<AsyncResult<String>> handler);

    void apiV2MetricsGet(Handler<AsyncResult<String>> handler);

    void balanceGet(String addrs, Handler<AsyncResult<Object>> handler);

    void balancePost(String addrs, Handler<AsyncResult<Object>> handler);

    void block(String hash, Integer seq, Handler<AsyncResult<List<BlockSchema>>> handler);

    void blockchainMetadata(Handler<AsyncResult<Object>> handler);

    void blockchainProgress(Handler<AsyncResult<Object>> handler);

    void blocks(Integer start, Integer end, List<Integer> seq, Handler<AsyncResult<InlineResponse2001>> handler);

    void coinSupply(Handler<AsyncResult<InlineResponse2002>> handler);

    void csrf(Handler<AsyncResult<InlineResponse2003>> handler);

    void dataDELETE(String type, String key, Handler<AsyncResult<Void>> handler);

    void dataGET(String type, String key, Handler<AsyncResult<Object>> handler);

    void dataPOST(String type, String key, String val, Handler<AsyncResult<Void>> handler);

    void defaultConnections(Handler<AsyncResult<List<String>>> handler);

    void health(Handler<AsyncResult<Object>> handler);

    void lastBlocks(Integer num, Handler<AsyncResult<Object>> handler);

    void networkConnection(String addr, Handler<AsyncResult<NetworkConnectionSchema>> handler);

    void networkConnections(String states, String direction, Handler<AsyncResult<InlineResponse2004>> handler);

    void networkConnectionsDisconnect(String id, Handler<AsyncResult<Void>> handler);

    void networkConnectionsExchange(Handler<AsyncResult<List<String>>> handler);

    void networkConnectionsTrust(Handler<AsyncResult<List<String>>> handler);

    void outputsGet(List<String> address, List<String> hash, Handler<AsyncResult<Object>> handler);

    void outputsPost(String address, String hash, Handler<AsyncResult<Object>> handler);

    void pendingTxs(Handler<AsyncResult<List<InlineResponse20010>>> handler);

    void resendUnconfirmedTxns(Handler<AsyncResult<Object>> handler);

    void richlist(Boolean includeDistribution, String n, Handler<AsyncResult<Object>> handler);

    void transaction(String txid, Handler<AsyncResult<Transaction>> handler);

    void transactionInject(String rawtx, Boolean noBroadcast, Handler<AsyncResult<String>> handler);

    void transactionPost(TransactionV2ParamsAddress transactionV2ParamsAddress, Handler<AsyncResult<InlineResponse2008>> handler);

    void transactionPostUnspent(TransactionV2ParamsUnspent transactionV2ParamsUnspent, Handler<AsyncResult<InlineResponse2008>> handler);

    void transactionRaw(String txid, Handler<AsyncResult<Object>> handler);

    void transactionVerify(TransactionVerifyRequest transactionVerifyRequest, Handler<AsyncResult<Object>> handler);

    void transactionsGet(String addrs, String confirmed, Handler<AsyncResult<Object>> handler);

    void transactionsPost(String addrs, String confirmed, Handler<AsyncResult<Object>> handler);

    void uxout(String uxid, Handler<AsyncResult<Object>> handler);

    void verifyAddress(Address address, Handler<AsyncResult<Object>> handler);

    void version(Handler<AsyncResult<InlineResponse2005>> handler);

    void wallet(String id, Handler<AsyncResult<Object>> handler);

    void walletBalance(String id, Handler<AsyncResult<Object>> handler);

    void walletCreate(String type, String seed, String label, String seedPassphrase, String bip44Coin, String xpub, Integer scan, Boolean encrypt, String password, Handler<AsyncResult<Object>> handler);

    void walletDecrypt(String id, String password, Handler<AsyncResult<Object>> handler);

    void walletEncrypt(String id, String password, Handler<AsyncResult<Object>> handler);

    void walletFolder(String addr, Handler<AsyncResult<InlineResponse2007>> handler);

    void walletNewAddress(String id, String num, String password, Handler<AsyncResult<Object>> handler);

    void walletNewSeed(String entropy, Handler<AsyncResult<Object>> handler);

    void walletRecover(String id, String seed, String seedPassphrase, String password, Handler<AsyncResult<Object>> handler);

    void walletSeed(String id, String password, Handler<AsyncResult<Object>> handler);

    void walletSeedVerify(String seed, Handler<AsyncResult<Object>> handler);

    void walletTransaction(WalletTransactionRequest walletTransactionRequest, Handler<AsyncResult<Object>> handler);

    void walletTransactionSign(WalletTransactionSignRequest walletTransactionSignRequest, Handler<AsyncResult<InlineResponse2009>> handler);

    void walletTransactions(String id, Handler<AsyncResult<InlineResponse2006>> handler);

    void walletUnload(String id, Handler<AsyncResult<Void>> handler);

    void walletUpdate(String id, String label, Handler<AsyncResult<String>> handler);

    void wallets(Handler<AsyncResult<List<Object>>> handler);

}
