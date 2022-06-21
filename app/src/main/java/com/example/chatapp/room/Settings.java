package com.example.chatapp.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Settings {
    @PrimaryKey(autoGenerate = true) long id;
    private String connected;
    private String server;

    public Settings(String connected, String server) {
        this.connected = connected;
        this.server = server;
    }

    public Settings() {
    }
}
