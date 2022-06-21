package com.example.chatapp.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Msg {
    @PrimaryKey (autoGenerate = true) long i;
    private String content;

    //object type? time
    private String created;

    private boolean sent;
    private int contactId;

    public Msg(String content, boolean sent, int contactId) {
        this.content = content;
        this.sent = sent;
        this.contactId = contactId;
    }

    public Msg(String content, String created, boolean sent, int contactId) {
        this.content = content;
        this.created = created;
        this.sent = sent;
        this.contactId = contactId;
    }

    public Msg() {
    }

    public String getContent() {
        return content;
    }

    public String getCreated() {
        return created;
    }

    public boolean isSent() {
        return sent;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }
}
