package com.example.chatapp.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.chatapp.MyApplication;
import com.example.chatapp.room.AppDB;
import com.example.chatapp.room.Msg;
import com.example.chatapp.room.MsgDao;
import com.example.chatapp.webServiceAPI.MsgAPI;

import java.util.LinkedList;
import java.util.List;

public class MsgRepository {
    private MsgDao msgDao;
    private AppDB appDB;
    private MsgListData msgListData;
    private MsgAPI msgAPI;
    private String userId;

    public MsgRepository(String userId) {
        AppDB appDB = AppDB.getInstance(MyApplication.context);
        this.msgDao = appDB.msgDao();
        this.userId = userId;
        this.msgAPI = new MsgAPI(msgDao);
        this.msgListData = new MsgListData();
    }

    public class MsgListData extends MutableLiveData<List<Msg>> {
        public MsgListData() {
            super();
            msgDao.insert(new Msg("hey", true, "Amar"));
            setValue(new LinkedList<>());
        }

        @Override
        protected void onActive() {
            super.onActive();
        }
    }

    public LiveData<List<Msg>> getChatByContactId(String contactId){
        reload(contactId);
        msgListData.postValue(msgDao.getByID(contactId));
        return msgListData;
    }

    public void addMsgByContactId(String contactId, Msg m){
        msgAPI.addMsg(userId, m);
        msgListData.postValue(msgDao.getByID(contactId));
    }

    public void reload(String contactId){
        msgAPI.getAllChats(userId, contactId);
    }

    public void DeleteAll(){
        msgDao.deleteAll();
    }
}
