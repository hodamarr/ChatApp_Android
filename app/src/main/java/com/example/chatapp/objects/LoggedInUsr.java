package com.example.chatapp.objects;

import com.example.chatapp.room.Contact;

public class LoggedInUsr {
    private String loggedin;
    private String server;
    private Contact chatWith;
    private static LoggedInUsr loggedInUsr;

    public static LoggedInUsr create(String l, String s){
        if (loggedInUsr == null) {
            loggedInUsr = new LoggedInUsr(l, s);
        }
        return loggedInUsr;
    }

    private LoggedInUsr(String loggedin, String server) {
            this.loggedin = loggedin;
            this.server = server;

    }

    public String getLoggedin() {
        return loggedin;
    }

    public String getServer() {
        return server;
    }

    public Contact getChatWith() {
        return chatWith;
    }

    public void setLoggedin(String loggedin) {
        this.loggedin = loggedin;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public void setChatWith(Contact chatWith) {
        this.chatWith = chatWith;
    }
}
