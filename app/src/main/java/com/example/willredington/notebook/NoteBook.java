package com.example.willredington.notebook;

import java.util.Date;
import java.util.UUID;

/**
 * Created by willredington on 8/15/15.
 */
public class NoteBook {

    private String uuid;
    private String name;
    private String text;
    private Date created;

    public NoteBook()
    {}

    public NoteBook(String n, String t, Date c)
    {
        name = n;
        text = t;
        created = c;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
