package com.wolfbit.websql.client;

import com.google.gwt.core.client.JavaScriptObject;

public class SQLResultSetRowList extends JavaScriptObject {
	protected SQLResultSetRowList() {
	}

	public final native SQLRow item(int idx)/*-{
		return this.item(idx);
	}-*/;

	public final native int length()/*-{
		return this.length;
	}-*/;
}
