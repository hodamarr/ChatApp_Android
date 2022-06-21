package com.example.chatapp.objects;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Contact {
    @PrimaryKey(autoGenerate=true)
    private int num;

    private String name;

    private String id;

    private String server;

    private String last;

    //type???
    private String lastDate;


    //@ForeignKey(User)
    private String userName;

    public Contact(String name, String id, String server, String user) {
        this.name = name;
        this.id = id;
        this.server = server;
        this.userName = user;
        this.last = null;
        this.lastDate = null;
    }

    public Contact(String name, String id, String server) {
        this.name = name;
        this.id = id;
        this.server = server;
        this.last = null;
        this.lastDate = null;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
