package com.example.chatapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.chatapp.R;
import com.example.chatapp.adapters.ContactsAdapter;
import com.example.chatapp.databinding.ActivityChatsBinding;
import com.example.chatapp.objects.LoggedInUsr;
import com.example.chatapp.room.Contact;
import com.example.chatapp.viewModels.ContactViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class Chats extends AppCompatActivity {
    private ContactViewModel vm;
    private List<Contact> contacts;
    private ContactsAdapter adapter;
    private ActivityChatsBinding binding;
    private LoggedInUsr usr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatsBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_chats);
        vm = new ViewModelProvider(this).get(ContactViewModel.class);

        //set user's name
        usr = LoggedInUsr.getLoggedInUsr();
        TextView userName = findViewById(R.id.user_name);
        userName.setText(usr.getLoggedin());


        //Contacts list
        ListView lvpost = findViewById(R.id.lvpost);
        adapter = new ContactsAdapter(this);
        lvpost.setAdapter(adapter);
        //get contacts
        vm.getAll().observe(this, cList -> {
            adapter.setContacts(cList);
        });
        lvpost.setClickable(true);
        lvpost.setOnItemClickListener(new AdapterView.OnItemClickListener() {
              @Override
              public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                  TextView contactName = findViewById(R.id.contact_name);
                  usr.setChatWith(contactName.getText().toString());
                  Intent intent = new Intent(getApplicationContext(), Chat.class);
                  intent.putExtra("contactName", contactName.getText());
                  startActivity(intent);
              }
        });

        /// Add chat button
        FloatingActionButton btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(v -> {
            Intent i = new Intent(this, AddChat.class);
            startActivity(i);
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