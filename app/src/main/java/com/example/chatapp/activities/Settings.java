package com.example.chatapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chatapp.R;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        EditText server = findViewById(R.id.etServer);
        server.setText("getServerFromDB");

        // Settings button
        Button update = findViewById(R.id.btnUpdate);
        update.setOnClickListener(v -> {
            //CHANGE DB!!
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        });
    }
}