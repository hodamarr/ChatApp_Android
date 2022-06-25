package com.example.chatapp.objects;

public class tokenData {
    private String userId;
    private String Token;

    public tokenData(String userId, String token) {
        this.userId = userId;
        Token = token;
    }

    public String getUserId() {
        return userId;
    }

    public String getToken() {
        return Token;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setToken(String token) {
        Token = token;
    }
}
