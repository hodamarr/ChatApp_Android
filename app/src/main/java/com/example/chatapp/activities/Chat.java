package com.example.chatapp.activities;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chatapp.R;
import com.example.chatapp.adapters.MsgsAdapter;
import com.example.chatapp.objects.LoggedInUsr;
import com.example.chatapp.room.Msg;

import java.util.ArrayList;
import java.util.List;

public class Chat extends AppCompatActivity {
    private MsgsAdapter adapter;
    private List<Msg> msgs;
    private String contact;
    private LoggedInUsr usr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        usr = LoggedInUsr.getLoggedInUsr();
        //contact's Name
        TextView contactName = findViewById(R.id.contact_name);
        contactName.setText(usr.getChatWith());

        msgs = new ArrayList<>();
        //msgs.add(new Msg("hey", true, 1));
        //msgs.add(new Msg("hey1", true, 1));
        //msgs.add(new Msg("hey2", true, 1));
        //msgs.add(new Msg("hey3", true, 1));

//        MsgAPI msgAPI = new MsgAPI();
//        msgAPI.get("1", "1");

        //Messages list
        ListView lstChats = findViewById(R.id.chatRecyclerView);
        adapter = new MsgsAdapter(this, msgs);
        lstChats.setAdapter(adapter);
    }
}