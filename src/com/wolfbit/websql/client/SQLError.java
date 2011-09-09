package com.wolfbit.websql.client;

import com.google.gwt.core.client.JavaScriptObject;

public class SQLError extends JavaScriptObject {
	
	public static final int UNKNOWN_ERR = 0;
	public static final int DATABASE_ERR = 1;
	public static final int VERSION_ERR = 2;
	public static final int TOO_LARGE_ERR = 3;
	public static final int QUOTA_ERR = 4;
	public static final int SYNTAX_ERR = 5;
	public static final int CONSTRAINT_ERR = 6;
	public static final int TIMEOUT_ERR = 7;
	
	protected SQLError() {}
	
	public final native int getCode() /*-{
		return this.code;
	}-*/;
	
	public final native String getMessage() /*-{
		return this.message;
	}-*/;
	
}
