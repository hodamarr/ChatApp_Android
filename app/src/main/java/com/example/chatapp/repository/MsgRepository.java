package com.example.chatapp.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.chatapp.room.Msg;
import com.example.chatapp.room.MsgDao;
import com.example.chatapp.webServiceAPI.ContactsAPI;
import com.example.chatapp.webServiceAPI.MsgAPI;

import java.util.LinkedList;
import java.util.List;

public class MsgRepository {
    private MsgDao msgDao;
    private MsgListData msgListData;
    private MsgAPI msgAPI;

    public MsgRepository(String userId) {
        this.msgDao = null;
        this.msgAPI = null;
        this.msgListData = null;
    }

    public class MsgListData extends MutableLiveData<List<Msg>> {
        public MsgListData() {
            super();
            setValue(new LinkedList<>());
        }

        @Override
        protected void onActive() {
            super.onActive();

            new Thread(() -> {

            });
        }


    }
}
