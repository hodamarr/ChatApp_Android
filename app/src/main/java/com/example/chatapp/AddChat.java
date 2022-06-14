package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.chatapp.databinding.ActivityAddChatBinding;

public class AddChat extends AppCompatActivity {
    private ActivityAddChatBinding biding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_chat);

        biding.btnAddChat.setOnClickListener(v -> {
            /// call database
        });
    }
}