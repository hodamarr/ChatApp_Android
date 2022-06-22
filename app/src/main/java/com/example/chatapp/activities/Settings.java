package com.example.chatapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chatapp.R;
import com.example.chatapp.objects.LoggedInUsr;

public class Settings extends AppCompatActivity {
    private LoggedInUsr usr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        usr = LoggedInUsr.getLoggedInUsr();

        EditText server = findViewById(R.id.etServer);
        server.setText(usr.getServer());

        // Settings button
        Button update = findViewById(R.id.btnUpdate);
        update.setOnClickListener(v -> {
            usr.setServer(server.getText().toString());
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        });
    }
}