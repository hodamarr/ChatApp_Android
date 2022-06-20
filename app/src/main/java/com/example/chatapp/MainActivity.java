package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.chatapp.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    /// for navigation
    private ActivityMainBinding binding;


    //// USE LOG.I for info and debug

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        /// log in button button (On click Logic)
        /// TODO: check if correct -> true: go to chat, false -> show msg on screen
        Button btnLogin = findViewById(R.id.btnLogin);
        binding.btnLogin.setOnClickListener(v -> {
            Intent i = new Intent(this, Chats.class);
            startActivity(i);
        });

        /// register button (On click Logic)
        binding.btnRegister.setOnClickListener(v -> {
            Intent iRegister = new Intent(this, Register.class);
            startActivity(iRegister);
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