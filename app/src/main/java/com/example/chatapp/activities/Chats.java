package com.example.chatapp.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.chatapp.R;
import com.example.chatapp.adapters.CustomAdapter;
import com.example.chatapp.room.AppDB;
import com.example.chatapp.room.Contact;
import com.example.chatapp.room.ContactDao;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class Chats extends AppCompatActivity {
    private AppDB db;
    private ContactDao cdao;
    private List<Contact> contacts;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db = Room.databaseBuilder(getApplicationContext(), AppDB.class,"PostsDB").build();
        cdao = db.contactDao();
        setContentView(R.layout.activity_chats);

        /// Add buttun
        FloatingActionButton btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(v -> {
            Intent i = new Intent(this, AddChat.class);
            startActivity(i);
            RecyclerView lvpost = findViewById(R.id.lvpost);

           // contacts = cdao.index(userId);
            Contact hod = new Contact("hod", "hodi", "1234", "hodik");
            hod.setLast("I hate HEMI");
            contacts.add(hod);

            adapter = new CustomAdapter(this, contacts);
            lvpost.setAdapter(adapter);
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}