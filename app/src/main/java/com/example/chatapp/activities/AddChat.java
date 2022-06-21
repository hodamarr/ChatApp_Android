package com.example.chatapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.EditText;

import com.example.chatapp.R;
import com.example.chatapp.databinding.ActivityAddChatBinding;
import com.example.chatapp.room.AppDB;
import com.example.chatapp.room.Contacts;
import com.example.chatapp.room.ContactsDao;

public class AddChat extends AppCompatActivity {
    private ActivityAddChatBinding biding;
    private AppDB db;
    private ContactsDao cdao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_chat);

        db = Room.databaseBuilder(getApplicationContext(), AppDB.class,"postsDB").build();
        cdao = (ContactsDao) db.ContactsDao();

        biding.btnAddChat.setOnClickListener(v -> {
            EditText addChatId = findViewById(R.id.edAddChatId);
            EditText addChatname = findViewById(R.id.edAddChatName);
            EditText addChatServer = findViewById(R.id.edAddChatServer);
            Contacts contact = new Contacts(addChatname.toString(), addChatId.toString(),
                    addChatServer.toString());
            cdao.insert(contact);

            finish();
        });
    }
}