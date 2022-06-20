package com.example.chatapp.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.chatapp.objects.msg;

@Entity
public class Chat {

    @PrimaryKey(autoGenerate=true)
    private com.example.chatapp.objects.msg msg;
    private String who;


    /// make getters and setters
    public Chat(com.example.chatapp.objects.msg m){
        this.msg = m;
        this.who = msg.getWho();
    }

    public Chat(String me, String who, String time, String msg){
        this.msg = new msg(me, who, time, msg);
        this.who = who;
    }

    public com.example.chatapp.objects.msg getMsg() {
        return msg;
    }
}
