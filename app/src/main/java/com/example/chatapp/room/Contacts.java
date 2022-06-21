package com.example.chatapp.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Contacts {


    @PrimaryKey(autoGenerate=true) public long contactsId;
    private String name;
    private String id;
    private String server;

    public Contacts(String name, String id, String server) {
        this.name = name;
        this.id = id;
        this.server = server;
    }

    public Contacts(){}


    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getServer() {
        return server;
    }

    public String toStr(){
        return this.id;
    }

    public long getContactsId() {
        return contactsId;
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
}
