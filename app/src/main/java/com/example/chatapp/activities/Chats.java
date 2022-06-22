package com.example.chatapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.chatapp.R;
import com.example.chatapp.adapters.ContactsAdapter;
import com.example.chatapp.databinding.ActivityChatsBinding;
import com.example.chatapp.room.AppDB;
import com.example.chatapp.room.Contact;
import com.example.chatapp.room.ContactDao;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Chats extends AppCompatActivity {
    private AppDB db;
    private ContactDao cdao;
    private List<Contact> contacts;
    private ContactsAdapter adapter;
    private ActivityChatsBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatsBinding.inflate(getLayoutInflater());

        db = Room.databaseBuilder(getApplicationContext(), AppDB.class,"PostsDB").build();
        cdao = db.contactDao();
        setContentView(R.layout.activity_chats);
        //SET USER NAME
        TextView userName = findViewById(R.id.user_name);
        userName.setText("Hod Amar");
        contacts = new ArrayList<>();
        Contact contact = new Contact("Ofek Avergil", "1", "localhost");
        contact.setLast("hey sup");
        contact.setLastDate("10:00");
        contacts.add(contact);
        contacts.add(contact);
        contacts.add(contact);
        contacts.add(contact);
        contacts.add(contact);
        contacts.add(contact);
        contacts.add(contact);
        contacts.add(contact);
        contacts.add(contact);
        contacts.add(contact);
        contacts.add(contact);
        contacts.add(contact);

        /// Add chat button
        FloatingActionButton btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(v -> {
            Intent i = new Intent(this, AddChat.class);
            startActivity(i);
        });

        //Contacts list
        ListView lvpost = findViewById(R.id.lvpost);
        //contacts = cdao.index();
        adapter = new ContactsAdapter(this, contacts);
        lvpost.setAdapter(adapter);
        lvpost.setClickable(true);
        lvpost.setOnItemClickListener(new AdapterView.OnItemClickListener() {
              @Override
              public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                  Intent intent = new Intent(getApplicationContext(), Chat.class);
                  TextView contactName = findViewById(R.id.contact_name);
                  intent.putExtra("contactName", contactName.getText());
                  startActivity(intent);
              }
        });

        // Settings button
        Button settings = findViewById(R.id.settings_btn);
        settings.setOnClickListener(v -> {
                Intent i = new Intent(this, Settings.class);
                startActivity(i);
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