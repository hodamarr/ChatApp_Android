package com.example.chatapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Post {

    @PrimaryKey(autoGenerate=true)
    private msg msg;
    private String who;


    /// make getters and setters
    public Post(msg m){
    this.msg = m;
    this.who = msg.getWho();
    }

    public Post(String me, String who, String time, String msg){
        this.msg = new msg(me, who, time, msg);
        this.who = who;
    }

    public com.example.chatapp.msg getMsg() {
        return msg;
    }

}
