package com.example.chatapp.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Msg {
    @PrimaryKey (autoGenerate = true) long i;
    private String Content;

    //object type? time
    private String Created;
    private boolean Sent;
    private String ContactId;

    public Msg(String content, boolean sent, String contactId) {
        this.Content = content;
        this.Sent = sent;
        this.ContactId = contactId;
        SimpleDateFormat formatter = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());
        String str = formatter.format(curDate);
        this.Created = str;

    }

    public Msg() {
    }

    public String getContent() {
        return Content;
    }

    public String  getCreated() {
        return Created;
    }

    public boolean isSent() {
        return Sent;
    }

    public String getContactId() {
        return ContactId;
    }

    public void setContent(String content) {
        this.Content = content;
    }

    public void setCreated(String  created) {
        this.Created = created;
    }

    public void setSent(boolean sent) {
        this.Sent = sent;
    }

    public void setContactId(String contactId) {
        this.ContactId = contactId;
    }
}
