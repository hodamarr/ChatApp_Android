package com.example.chatapp.objects;

public class LoggedInUsr {
    private String loggedin;
    private String server;
    private String chatWith;
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

    public String getChatWith() {
        return chatWith;
    }

    public void setLoggedin(String loggedin) {
        this.loggedin = loggedin;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public void setChatWith(String chatWith) {
        this.chatWith = chatWith;
    }
}
