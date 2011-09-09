package com.wolfbit.websql.client;

import com.google.gwt.core.client.JavaScriptObject;

public class SQLResultSet extends JavaScriptObject {

	protected SQLResultSet() {}
	
	public final native int getInsertId()/*-{
		return this.insertId;
	}-*/;
	
	public final native int getRowsAffected()/*-{
		return this.rowsAffected;
	}-*/;
	
	public final native SQLResultSetRowList getRows()/*-{
		return this.rows;
	}-*/;
	
}
