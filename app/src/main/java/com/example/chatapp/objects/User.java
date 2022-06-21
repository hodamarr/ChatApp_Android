package com.example.chatapp.objects;

import androidx.room.Entity;

@Entity
public class User {

    private final String name;

    private final String nick;

    private final String password;

    private String pic;

    private final String server;

    public User(String name, String nickname, String password, String pic, String server) {
        this.name = name;
        this.nick = nickname;
        this.password = password;
        this.pic = pic;
        this.server = server;
    }

    public User(String name, String nickname, String password, String server) {
        this.name = name;
        this.nick = nickname;
        this.password = password;
        this.server = server;
    }

    public String getServer() {
        return server;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nick;
    }

    public String getPassword() {
        return password;
    }

    public String getPic() {
        return pic;
    }
}
