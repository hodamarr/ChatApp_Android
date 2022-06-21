package com.example.chatapp.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chatapp.R;
import com.example.chatapp.adapters.MsgsListAdapter;
import com.example.chatapp.objects.Msg;

import java.util.ArrayList;
import java.util.List;

public class Chat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        RecyclerView lstChats = findViewById(R.id.chatRecyclerView);
        final MsgsListAdapter adapter = new MsgsListAdapter(this);
        lstChats.setAdapter(adapter);
        lstChats.setLayoutManager(new LinearLayoutManager(this));

        List<Msg> msgs = new ArrayList<>();
        msgs.add(new Msg("hey", true, 10));
        msgs.add(new Msg("hey1", true, 10));
        msgs.add(new Msg("hey2", true, 10));
        msgs.add(new Msg("hey3", true, 10));

        adapter.setMsgs(msgs);
    }
}