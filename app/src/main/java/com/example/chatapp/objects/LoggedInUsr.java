package com.example.chatapp.objects;

import com.example.chatapp.room.Contact;

public class LoggedInUsr {
    private String loggedin = null;
    private String server;
    private Contact chatWith;

    public LoggedInUsr(String loggedin, String server) {
        if (loggedin == null) {
            this.loggedin = loggedin;
            this.server = server;
        }
        else {
            setLoggedin(loggedin);
            setServer(server);
        }
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
