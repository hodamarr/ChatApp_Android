package com.example.chatapp.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Msg {
    @PrimaryKey (autoGenerate = true) long i;
    private String content;

    //object type? time
    private String  created;
    private boolean sent;
    private String contactId;

    public Msg(String content, boolean sent, String contactId) {
        this.content = content;
        this.sent = sent;
        this.contactId = contactId;
        SimpleDateFormat formatter = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());
        String str = formatter.format(curDate);
        this.created = str;

    }

    public Msg() {
    }

    public String getContent() {
        return content;
    }

    public String  getCreated() {
        return created;
    }

    public boolean isSent() {
        return sent;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreated(String  created) {
        this.created = created;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }
}
