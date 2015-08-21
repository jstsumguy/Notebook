package com.example.willredington.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import com.example.willredington.notebook.NoteBook;

import java.util.ArrayList;
import java.util.Date;


/**
 * Created by willredington on 8/15/15.
 */
public class NoteBookDataSource {

    private static SqliteHelper helper;
    private static SQLiteDatabase db;

    public NoteBookDataSource(Context c)
    {
        helper = new SqliteHelper(c);
        db = helper.getWritableDatabase();
    }

    public boolean createNoteBook(String title)
    {
        ContentValues cv = new ContentValues();
        cv.put("TITLE", title);
        long result = db.insert(SqliteHelper.TABLE, null, cv);
        Log.i("SQL", Long.toString(result));

        if(result > 0)
            return true;
        return false;
    }

    public boolean deleteNoteBook(int uuid)
    {
        long result = db.delete(SqliteHelper.TABLE, "_ID = " + uuid, null);
        if(result > 0)
            return true;
        return false;
    }

    public ArrayList<NoteBook> getAllNoteBooks()
    {
        Cursor cursor = db.query(SqliteHelper.TABLE, SqliteHelper.ALL_COLS, null, null, null, null, null);
        cursor.moveToFirst();

        ArrayList<NoteBook> books = new ArrayList<>();

        while(!cursor.isAfterLast())
        {
            NoteBook book = cursorToNoteBook(cursor);
            books.add(book);
            cursor.moveToNext();
        }
        return books;
    }

    private static NoteBook cursorToNoteBook(Cursor c)
    {
        Integer id = c.getInt(0);
        String title = c.getString(1);
        String created = c.getString(2);
        String text = c.getString(3);

        Log.i("SQL", title + " " + text + " " + Integer.toString(id));

        NoteBook book = new NoteBook(title, text, null);
        book.setUuid(Integer.toString(id));

        return book;
    }


}
