package com.example.chatapp.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chatapp.R;
import com.example.chatapp.adapters.MsgsListAdapter;
import com.example.chatapp.objects.LoggedInUsr;
import com.example.chatapp.room.Contact;
import com.example.chatapp.room.Msg;
import com.example.chatapp.viewModels.MsgViewModel;

import java.util.List;

public class Chat extends AppCompatActivity {
    private MsgsListAdapter adapter;
    private List<Msg> msgs;
    private String contact;
    private LoggedInUsr usr;
    private MsgViewModel vm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        vm = new ViewModelProvider(this).get(MsgViewModel.class);

        //contact's Name
        usr = LoggedInUsr.getLoggedInUsr();
        Contact c = usr.getChatWith();
        TextView contactName = findViewById(R.id.contact_name);
        contactName.setText(c.getName());

        //Messages list
        RecyclerView lstChats = findViewById(R.id.chatRecyclerView);
        adapter = new MsgsListAdapter(this);
        lstChats.setAdapter(adapter);
        lstChats.setLayoutManager(new LinearLayoutManager(this));
        //get messages
        vm.get(c.getId()).observe(this, mList -> {
            adapter.setMsgs(mList);
        });
    }
}