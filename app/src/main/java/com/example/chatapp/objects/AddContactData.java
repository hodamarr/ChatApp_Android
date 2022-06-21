package com.example.chatapp.objects;

public class AddContactData {

    private String id;
    private String name;
    private String Server;

    public AddContactData(String id, String name, String server) {
        this.id = id;
        this.name = name;
        Server = server;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServer() {
        return Server;
    }

    public void setServer(String server) {
        Server = server;
    }
}
