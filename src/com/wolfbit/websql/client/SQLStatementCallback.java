package com.wolfbit.websql.client;

public interface SQLStatementCallback {
	public void onSuccess(SQLTransaction transaction, SQLResultSet resultSet);

	public boolean onError(SQLTransaction transaction, SQLError error);
}
