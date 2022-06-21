package com.example.chatapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.EditText;

import com.example.chatapp.R;
import com.example.chatapp.databinding.ActivityAddChatBinding;
import com.example.chatapp.room.AppDB;
import com.example.chatapp.room.Contact;
import com.example.chatapp.room.ContactDao;

public class AddChat extends AppCompatActivity {
    private ActivityAddChatBinding biding;
    private AppDB db;
    private ContactDao cdao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_chat);

        db = Room.databaseBuilder(getApplicationContext(), AppDB.class,"postsDB").build();
        cdao = (ContactDao) db.contactDao();

        biding.btnAddChat.setOnClickListener(v -> {
            EditText addChatId = findViewById(R.id.edAddChatId);
            EditText addChatname = findViewById(R.id.edAddChatName);
            EditText addChatServer = findViewById(R.id.edAddChatServer);
            Contact c = new Contact(addChatname.toString(), addChatId.toString(),
                    addChatServer.toString());
            cdao.insert(c);

            finish();
        });
    }
}