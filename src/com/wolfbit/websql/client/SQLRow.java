package com.wolfbit.websql.client;

import com.google.gwt.core.client.JavaScriptObject;

public class SQLRow extends JavaScriptObject {
	protected SQLRow() {
	}
	
	public final native int getInt(String name)/*-{
		return this[name];
	}-*/;

	public final native boolean getBoolean(String name)/*-{
		return this[name];
	}-*/;

	public final native float getFloat(String name)/*-{
		return this[name];
	}-*/;

	public final native JavaScriptObject get(String name)/*-{
		return this[name];
	}-*/;

	public final native String getString(String name)/*-{
		return this[name];
	}-*/;
}
