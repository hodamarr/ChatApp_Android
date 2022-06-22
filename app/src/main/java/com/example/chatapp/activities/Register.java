package com.example.chatapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chatapp.R;
import com.example.chatapp.databinding.ActivityRegisterBinding;
import com.example.chatapp.objects.LoggedInUsr;

public class Register extends AppCompatActivity {
    private ActivityRegisterBinding binding;
    private LoggedInUsr usr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        EditText name = findViewById(R.id.etRegisterUsername);
        EditText nick = findViewById(R.id.etRegisterNick);
        EditText pass = findViewById(R.id.etRegisterPassword);
        EditText server = findViewById(R.id.etRegisterPassValid);

        //regist button
        binding.btnRegsiterNow.setOnClickListener(v -> {
            //Validation
            //Registration
            Intent i = new Intent(this, Chats.class);
            usr = LoggedInUsr.create(name.getText().toString());
            startActivity(i);
        });

        //login button
        binding.btnRegisterLogin.setOnClickListener(v -> {
            Intent iMainActivity = new Intent(this, MainActivity.class);
            startActivity(iMainActivity);
        });

        //image picker
        Button imagePicker = findViewById(R.id.image_picker);
        imagePicker.setOnClickListener(v -> {
            // Launches photo picker in single-select mode.
            // This means that the user can select one photo or video.
//            Intent intent = new Intent(MediaStore.ACTION_PICK_IMAGES);
//            startActivityForResult(intent, PHOTO_PICKER_REQUEST_CODE);
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