package com.example.chatapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.chatapp.R;
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

        EditText username = findViewById(R.id.etLoginUsername);
        EditText password = findViewById(R.id.etLoginPassword);
//        EditText server = findViewById(R.id.etLo);

        /// log in button button (On click Logic)
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