package com.example.chatapp.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class msg {
    @PrimaryKey(autoGenerate=true)
    private String who;
    private String content;

    public msg(String who, String content) {
        this.who = who;
        this.content = content;
    }

    public String getWho() {
        return who;
    }

    public String getContent() {
        return content;
    }
}

