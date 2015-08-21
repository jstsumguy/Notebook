package com.example.willredington.notebook;

import android.app.Activity;
import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.willredington.db.NoteBookDataSource;
import com.example.willredington.list.NoteListAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends Activity {

    private ListView list;
    private Button newNote;

    private static NoteBookDataSource nds;
    private static NoteListAdapter adapter;
    private static ArrayList<NoteBook> books = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.notelist);
        newNote = (Button) findViewById(R.id.newbtn);


        if(nds == null)
            nds = new NoteBookDataSource(this);
        books = nds.getAllNoteBooks();

        if(books != null)
        {
            adapter = new NoteListAdapter(this, books);
            list.setAdapter(adapter);
        }

        newNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nds.createNoteBook("Add a title here"))
                    books = nds.getAllNoteBooks();
                list.invalidateViews();
            }
        });
    }
}
