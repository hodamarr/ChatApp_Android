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

    public Contact(String name, String id, String server) {
        this.name = name;
        this.id = id;
        this.server = server;
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

    public String toStr(){
        return this.id;
    }
}
