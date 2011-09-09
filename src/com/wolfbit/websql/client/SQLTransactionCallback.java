package com.wolfbit.websql.client;

public interface SQLTransactionCallback {
	public void transaction(SQLTransaction transaction);

	public void onError(SQLError error);

	public void onSuccess();
}
