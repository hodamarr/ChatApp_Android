package com.example.chatapp.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey (autoGenerate = true) long id;

    private final String name;

    private final String nick;

    private final String password;

    private String pic;

    private final String server;

    public String getName() {
        return name;
    }

    public String getNick() {
        return nick;
    }

    public String getPassword() {
        return password;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getServer() {
        return server;
    }

    public User(String name, String nick, String password, String server) {
        this.name = name;
        this.nick = nick;
        this.password = password;
        this.server = server;
    }
}
