package com.wolfbit.websql.client;

import com.google.gwt.core.client.JavaScriptObject;

public class Database extends JavaScriptObject {

	protected Database() {
	}

	public static native Database openDatabase(String name, String version,
			String description, int estimatedSize)/*-{
		return openDatabase(
				name,
				version,
				description,
				estimatedSize);
	}-*/;

	public final native void transaction(SQLTransactionCallback callback)/*-{
		this
				.transaction(
						function(tx) {
							callback.@com.wolfbit.websql.client.SQLTransactionCallback::transaction(Lcom/wolfbit/websql/client/SQLTransaction;)(tx);
						},
						function(error) {
							callback.@com.wolfbit.websql.client.SQLTransactionCallback::onError(Lcom/wolfbit/websql/client/SQLError;)(error);
						},
						function() {
							callback.@com.wolfbit.websql.client.SQLTransactionCallback::onSuccess()();
						});
	}-*/;

	public final native void readTransaction(SQLTransactionCallback callback)/*-{
		if (this.readTransaction) {
			this
					.readTransaction(
							function(transaction) {
								callback.@com.wolfbit.websql.client.SQLTransactionCallback::transaction(Lcom/wolfbit/websql/client/SQLTransaction;)(transaction);
							},
							function(error) {
								callback.@com.wolfbit.websql.client.SQLTransactionCallback::onError(Lcom/wolfbit/websql/client/SQLError;)(error);
							},
							function() {
								callback.@com.wolfbit.websql.client.SQLTransactionCallback::onSuccess()();
							});
		} else {
			this
					.transaction(
							function(transaction) {
								callback.@com.wolfbit.websql.client.SQLTransactionCallback::transaction(Lcom/wolfbit/websql/client/SQLTransaction;)(transaction);
							},
							function(error) {
								callback.@com.wolfbit.websql.client.SQLTransactionCallback::onError(Lcom/wolfbit/websql/client/SQLError;)(error);
							},
							function() {
								callback.@com.wolfbit.websql.client.SQLTransactionCallback::onSuccess()();
							});
		}
	}-*/;

	public final native void changeVersion(String oldVersion,
			String newVersion, SQLTransactionCallback callback)/*-{
		this
				.changeVersion(
						oldVersion,
						newVersion,
						function(transaction) {
							callback.@com.wolfbit.websql.client.SQLTransactionCallback::transaction(Lcom/wolfbit/websql/client/SQLTransaction;)(transaction);
						},
						function(error) {
							callback.@com.wolfbit.websql.client.SQLTransactionCallback::onError(Lcom/wolfbit/websql/client/SQLError;)(error);
						},
						function() {
							callback.@com.wolfbit.websql.client.SQLTransactionCallback::onSuccess()();
						});
	}-*/;

	public final native String getVersion()/*-{
		return this.version;
	}-*/;

}
