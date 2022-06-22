package com.example.chatapp.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.chatapp.R;
import com.example.chatapp.databinding.ActivityAddChatBinding;
import com.example.chatapp.room.Contact;
import com.example.chatapp.viewModels.ContactViewModel;

public class AddChat extends AppCompatActivity {
    private ActivityAddChatBinding biding;
    private ContactViewModel vm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_chat);
        vm = new ViewModelProvider(this).get(ContactViewModel.class);


        EditText addChatId = findViewById(R.id.edAddChatId);
        EditText addChatname = findViewById(R.id.edAddChatName);
        EditText addChatServer = findViewById(R.id.edAddChatServer);

        //Add chat
        Button add = findViewById(R.id.btnAddChat);
        add.setOnClickListener(v -> {
            Contact c = new Contact(addChatname.getText().toString(), addChatId.getText().toString(),
                    addChatServer.getText().toString());
            vm.add(c);
            finish();
        });
    }
}