package com.example.chatapp.objects;

import com.example.chatapp.room.Contact;

public class LoggedInUsr {
    private String loggedin;
    private String server;
    private Contact chatWith;
    private String pic;
    private static LoggedInUsr loggedInUsr;

    public static LoggedInUsr create(String l){
        if (loggedInUsr == null) {
            loggedInUsr = new LoggedInUsr(l);
        }
        return loggedInUsr;
    }

    public static LoggedInUsr getLoggedInUsr() {
        return loggedInUsr;
    }

    private LoggedInUsr(String loggedin) {
            this.loggedin = loggedin;
            this.server = "localhost:4179";
            this.pic = loggedin + ".png";

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
