package com.example.willredington.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.example.willredington.authentication.PasswordHelper;
import com.example.willredington.authentication.User;

/**
 * Created by willredington on 8/15/15.
 */
public class UserDataSource {

    private SQLiteDatabase database;
    private SqliteHelper helper;

    public UserDataSource(Context c)
    {
        helper = new SqliteHelper(c);
    }

    public void open()
    {
        database = helper.getWritableDatabase();
    }

    public void close()
    {
        if(database.isOpen())
        { database.close();}
    }

    public void createUser(String username, String password) throws SQLiteException
    {
        //password = PasswordHelper.hash(password);
        User user = new User(username, password);
        ContentValues values = new ContentValues();
        values.put("USERNAME", username);
        values.put("PASSWORD", password);
        long row = database.insert("USER", null, values);
        if(row == -1) throw new SQLiteException();
    }

    /* Validates the user's password */
    public boolean validate(String input)
    {
        if(User.isLoggedIn()) return true;
        String[] cols = {"USERNAME", "PASSWORD"};
        Cursor c = database.query("USER", cols, null, null, null, null, null);
        c.moveToFirst();
        if(c != null)
        {
            String password = c.getString(1);
            if(PasswordHelper.compare(password, input))
            {
                User.setIsLoggedIn(true);
                return true;
            }
        }
        return false;
    }


}
