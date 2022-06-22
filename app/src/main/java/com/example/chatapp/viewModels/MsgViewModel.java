package com.example.chatapp.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.chatapp.objects.LoggedInUsr;
import com.example.chatapp.repository.MsgRepository;
import com.example.chatapp.room.Msg;

import java.util.List;

public class MsgViewModel extends ViewModel {
    private LiveData<List<Msg>> msgLiveData;
    private MsgRepository mRepository;
    private String userId;


    public MsgViewModel(){
        LoggedInUsr lgu = LoggedInUsr.getLoggedInUsr();
        userId = lgu.getLoggedin();
        mRepository = new MsgRepository(userId);
    }

    public LiveData<List<Msg>> get(String contactId) {
        msgLiveData = mRepository.getChatByContactId(contactId);
        return msgLiveData;
    }

    public void add(Msg msg, String contactID) {
        mRepository.addMsgByContactId(contactID, msg);
    }

    public void reload(String contactId) {
        mRepository.reload(contactId);
    }

    public void DeleteAll(){
        mRepository.DeleteAll();
    }

}
