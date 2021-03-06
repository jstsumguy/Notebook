package com.example.willredington.db;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.util.Log;

/**
 * Created by willredington on 8/15/15.
 */
public class SqliteHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "notebook.db";
    private static final int DB_VERSION = 1;

    public static final String TABLE = "NOTEBOOK";
    public static final String[] ALL_COLS = {"_ID", "TITLE", "CREATED", "NOTE"};

    public SqliteHelper(Context c)
    {
        super(c, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("SQL", "Creating database...");
        db.execSQL("CREATE TABLE NOTEBOOK " + "(_ID INTEGER PRIMARY KEY AUTOINCREMENT, " + "TITLE TEXT NULL, " + "CREATED DATETIME NULL, " + " NOTE TEXT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("SQL", "Upgrading database...");
        db.execSQL("DROP TABLE IF EXISTS NOTEBOOK;");
    }
}
