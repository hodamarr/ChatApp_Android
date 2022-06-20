package com.example.chatapp.objects;

public class Contact {
    private String name;
    private String ID;
    private String server;

    public Contact(String name, String ID, String server) {
        this.name = name;
        this.ID = ID;
        this.server = server;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public String getServer() {
        return server;
    }
}
