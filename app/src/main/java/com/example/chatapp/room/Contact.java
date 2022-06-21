package com.example.chatapp.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Contact {
    @PrimaryKey (autoGenerate = true) long i;

    private String name;

    private String id;

    private String server;

    private String last;

    //type???
    private String lastDate;
    //@ForeignKey(User)
    private String userName;

    public Contact(String name, String id, String server, String userName) {
        this.name = name;
        this.id = id;
        this.server = server;
        this.userName = userName;
    }

    public Contact() {
    }

    public Contact(String name, String id, String server) {
        this.name = name;
        this.id = id;
        this.server = server;
    }

    public long getI() {
        return i;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getServer() {
        return server;
    }

    public String getLast() {
        return last;
    }

    public String getLastDate() {
        return lastDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String toStr() {
        return this.name;
    }
}
