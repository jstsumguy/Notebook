package com.example.willredington.list;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.willredington.notebook.NoteBook;
import com.example.willredington.notebook.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by willredington on 8/21/15.
 */
public class NoteListAdapter extends BaseAdapter {

    private ArrayList<NoteBook> books;
    private LayoutInflater inflater;

    public NoteListAdapter(Context c, ArrayList<NoteBook> list)
    {
        inflater = LayoutInflater.from(c);
        books = list;
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int position) {
        return books.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder holder;
        NoteBook book = null;

        if(convertView == null) {
            view = inflater.inflate(R.layout.notebook_row_layout, parent, false);
            holder = new ViewHolder();

            book = books.get(position);
            holder.datestr = (TextView)view.findViewById(R.id.datetimetxt);
            holder.title = (TextView)view.findViewById(R.id.titletxt);
            view.setTag(holder);

        } else {
            view = convertView;
            holder = (ViewHolder)view.getTag();
        }

        if(book != null)
        {
            if(book.getCreated() != null)
                holder.datestr.setText((CharSequence) book.getCreated().toString());
            else
                holder.datestr.setText((CharSequence) "Default Date");
            holder.title.setText((CharSequence) book.getName());
        }

        return view;
    }

    private class ViewHolder {
        public TextView datestr, title;
    }
}
