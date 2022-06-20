package com.example.chatapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.chatapp.R;
import com.example.chatapp.databinding.ActivityRegisterBinding;

public class Register extends AppCompatActivity {
    private ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        EditText name = findViewById(R.id.etRegisterUsername);
        EditText nick = findViewById(R.id.etRegisterNick);
        EditText pass = findViewById(R.id.etRegisterPassword);
        EditText server = findViewById(R.id.etRegisterServer);

        binding.btnRegsiterNow.setOnClickListener(v -> {
        });

        binding.btnRegisterLogin.setOnClickListener(v -> {

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