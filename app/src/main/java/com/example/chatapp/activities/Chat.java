package com.example.chatapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.chatapp.R;
import com.example.chatapp.room.AppDB;
import com.example.chatapp.room.ContactsDao;
import com.example.chatapp.room.MsgDao;

public class Chat extends AppCompatActivity {
    private AppDB db;
    private MsgDao mdao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
    }
}