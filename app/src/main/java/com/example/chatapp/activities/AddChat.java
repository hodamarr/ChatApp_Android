package com.example.chatapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.EditText;

import com.example.chatapp.R;
import com.example.chatapp.databinding.ActivityAddChatBinding;
import com.example.chatapp.room.AppDB;

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
            EditText addChatId = findViewById(R.id.edAddChatId);
            EditText addChatname = findViewById(R.id.edAddChatName);
            EditText addChatServer = findViewById(R.id.edAddChatServer);
            //// work on server here
            /// then add to local db
//            Post post = new Post(0, )
        });
    }
}