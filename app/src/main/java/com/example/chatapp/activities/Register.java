package com.example.chatapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

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
        EditText server = findViewById(R.id.etRegisterPassValid);

        binding.btnRegsiterNow.setOnClickListener(v -> {
                //Validation
                //Registration
                Intent i = new Intent(this, Chats.class);
                //save in settings db the connected user.
                startActivity(i);
        });

        binding.btnRegisterLogin.setOnClickListener(v -> {
            Intent iMainActivity = new Intent(this, MainActivity.class);
            startActivity(iMainActivity);
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