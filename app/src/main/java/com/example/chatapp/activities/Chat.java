package com.example.chatapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;

import com.example.chatapp.R;
import com.example.chatapp.room.AppDB;
import com.example.chatapp.room.ContactsDao;
import com.example.chatapp.room.MsgDao;
import com.example.chatapp.room.msg;

import java.util.List;

public class Chat extends AppCompatActivity {
    private AppDB db;
    private MsgDao mdao;
    private List<msg> msgList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        db = Room.databaseBuilder(getApplicationContext(), AppDB.class,"PostsDB").build();
        mdao = (MsgDao) db.ContactsDao();
        msgList = mdao.index();


    }
}