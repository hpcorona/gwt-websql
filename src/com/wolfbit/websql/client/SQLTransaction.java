package com.wolfbit.websql.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayMixed;

public class SQLTransaction extends JavaScriptObject {
	protected SQLTransaction() {}

	public final void executeSql(String statement, Object[] params, SQLStatementCallback callback) {
		JsArrayMixed jsarr = JavaScriptObject.createArray().cast();

		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				if (params[i] instanceof Boolean) {
					jsarr.push((Boolean)params[i]);
				} else if (params[i] instanceof Double) {
					jsarr.push((Double)params[i]);
				} else if (params[i] instanceof JavaScriptObject) {
					jsarr.push((JavaScriptObject)params[i]);
				} else if (params[i] instanceof String) {
					jsarr.push((String)params[i]);
				} else {
					jsarr.push(params[i].toString());
				}
			}
		}
		
		jsExecuteSql(statement, jsarr, callback);
	}
		
	public final native void jsExecuteSql(String statement, JsArrayMixed params, SQLStatementCallback callback)/*-{
		this.executeSql(statement, params, function(transaction, result) {
				callback.@com.wolfbit.websql.client.SQLStatementCallback::onSuccess(Lcom/wolfbit/websql/client/SQLTransaction;Lcom/wolfbit/websql/client/SQLResultSet;)(transaction, result);
			}, function(transaction, error) {
				return callback.@com.wolfbit.websql.client.SQLStatementCallback::onError(Lcom/wolfbit/websql/client/SQLTransaction;Lcom/wolfbit/websql/client/SQLError;)(transaction, error);
			});
	}-*/;

}
