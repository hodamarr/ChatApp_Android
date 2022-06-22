package com.example.chatapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.chatapp.R;
import com.example.chatapp.adapters.CustomAdapter;
import com.example.chatapp.databinding.ActivityChatsBinding;
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
    private ActivityChatsBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatsBinding.inflate(getLayoutInflater());

        db = Room.databaseBuilder(getApplicationContext(), AppDB.class,"PostsDB").build();
        cdao = db.contactDao();
        setContentView(R.layout.activity_chats);

        /// Add chat button
        FloatingActionButton btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(v -> {
            Intent i = new Intent(this, AddChat.class);
            startActivity(i);
        });

        //Contacts list
        RecyclerView lvpost = findViewById(R.id.lvpost);
        contacts = cdao.index();
        adapter = new CustomAdapter(this, contacts);
        lvpost.setAdapter(adapter);
        lvpost.setClickable(true);
        lvpost.setOnItemClickListener()


        // Settings button
        ImageView settings = findViewById(R.id.settings_btn);
        settings.setClickable(true);
        settings.setOnItemClickListener(new AdapterView.onItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), Settings.class);
                //save in settings db the connected user.
                startActivity(intent);
            }
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