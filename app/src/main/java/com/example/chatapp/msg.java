package com.example.chatapp;

public class msg {
    private String who;
    private String me;
    private String msg;
    private String time;

    public msg(String me,String who,String time,String msg){
        this.me = me;
        this.who = who;
        this.time = time;
        this.msg = msg;
    }

    public String getMe() {
        return me;
    }

    public String getMsg() {
        return msg;
    }

    public String getTime() {
        return time;
    }

    public String getWho() {
        return who;
    }
}

