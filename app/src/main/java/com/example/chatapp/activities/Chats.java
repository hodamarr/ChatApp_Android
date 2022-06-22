package com.example.chatapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chatapp.R;
import com.example.chatapp.adapters.ContactsListAdapter;
import com.example.chatapp.databinding.ActivityChatsBinding;
import com.example.chatapp.objects.LoggedInUsr;
import com.example.chatapp.room.Contact;
import com.example.chatapp.viewModels.ContactViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class Chats extends AppCompatActivity {
    private ContactViewModel vm;
    private List<Contact> contacts;
    private ContactsListAdapter adapter;
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
        RecyclerView lvpost = findViewById(R.id.lvpost);
        adapter = new ContactsListAdapter(this, new ContactsListAdapter.ItemClickListener() {
            @Override
            public void onItemClick(Contact contact) {
                TextView contactName = findViewById(R.id.contact_name);
//                Contact c = vm.getContactByName(contactName.getText().toString());
//                usr.setChatWith(c);
                Intent intent = new Intent(getApplicationContext(), Chat.class);
                intent.putExtra("contactName", contactName.getText());
                startActivity(intent);
            }
        });
        lvpost.setAdapter(adapter);
        lvpost.setLayoutManager(new LinearLayoutManager(this));
        //get contacts
        vm.getAll().observe(this, cList -> {
            adapter.setContacts(cList);
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

    private void showToast(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
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