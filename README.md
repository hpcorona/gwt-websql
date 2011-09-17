gwt-websql
======

THIS PROJECT IS DEPRECATED. Why? Because i've found a better one, here:
http://code.google.com/p/gwt-mobile-webkit/wiki/DatabaseApi


This project is an implementation of HTML5's WebSQL for GWT.

It is as identical to Javascript's native implementation as possible.

Including it in your project
---

Include the websql.jar library in your project and inherit your module with:

```xml
<inherits name="com.wolfbit.websql.WebSql" />
```

Everything is on the package:

```java
com.wolfbit.websql.client
```

Opening a Database
---

```java
// Open a 5 MB database...
Database database = Database.openDatabase("mydb", "1.0", "My Database", 5 * 1024 * 1024);
```

Running a Transaction
---

```java
database.transaction(new SQLTransactionCallback() {
  public void transaction(SQLTransaction tx) {
    tx.executeSql("INSERT INTO users (name) VALUES (?)",
        new Object[] { "Hilario" },
        new SQLStatementCallback() {
          public void onSuccess(SQLTransaction tx, SQLResultSet result) {
            Window.alert("Inserted ID: " + result.getInsertId());
          }

          public boolean onError(SQLTransaction tx, SQLError error) {
            return false;
          }
        });
  }

  public void onError(SQLError error) {
    Window.alert("Error: " + error.getMessage());
  }

  public void onSuccess() {
    Window.alert("Huge Success!");
  }
});
```

And to read a resultset...

```java
database.transaction(new SQLTransactionCallback() {
  public void transaction(SQLTransaction tx) {
    tx.executeSql("SELECT id, name, is_active FROM users WHERE is_active = ?",
        new Object[] { true },
        new SQLStatementCallback() {
          public void onSuccess(SQLTransaction tx, SQLResultSet result) {
            SQLResultSetRowList rows = result.getRows();
            int total = rows.length();

            for (int i = 0; i < total; i++) {
              SQLRow row = rows.item(i);

              Window.alert("ID: " + row.getInt("id") +
                            " Name: " + row.getString("name") +
                            " Active: " + row.getBoolean("is_active"));
            }
          }

          public boolean onError(SQLTransaction tx, SQLError error) {
            return false;
          }
        });
  }

  public void onError(SQLError error) {
    Window.alert("Error: " + error.getMessage());
  }

  public void onSuccess() {
    Window.alert("Huge Success!");
  }
});
```

As you can see, it's pretty much like using traditional Javascript's HTML5's WebSQL.


## License

(The MIT License)

Copyright (c) 2011 Hilario P&eacute;rez Corona &lt;hpcorona@gmail.com&gt;

Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
'Software'), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED 'AS IS', WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

