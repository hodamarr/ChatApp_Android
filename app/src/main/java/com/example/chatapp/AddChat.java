package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.EditText;

import com.example.chatapp.databinding.ActivityAddChatBinding;

public class AddChat extends AppCompatActivity {
    private ActivityAddChatBinding biding;
    private AppDB db;
    private PostDao postDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_chat);

        db = Room.databaseBuilder(getApplicationContext(), AppDB.class,"postsDB").build();
        postDao = db.postDao();

        biding.btnAddChat.setOnClickListener(v -> {
            EditText editText = findViewById(R.id.edAddChatId);
            //// work on server here
            /// then add to local db
            Post post = new Post()
        });
    }
}