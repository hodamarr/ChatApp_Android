package com.example.chatapp.webServiceAPI;

import android.telephony.SignalThresholdInfo;
import android.util.Log;

import com.example.chatapp.MyApplication;
import com.example.chatapp.R;
import com.example.chatapp.objects.TransferData;
import com.example.chatapp.room.Msg;
import com.example.chatapp.room.MsgDao;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MsgAPI {
    private WebServiceAPI webServiceAPI;
    private Retrofit retrofit;
    private MsgDao msgDao;

    public MsgAPI(MsgDao msgDao){
        retrofit = new Retrofit.Builder()
                .baseUrl(MyApplication.context.getString(R.string.BaseUrl))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        webServiceAPI = retrofit.create(WebServiceAPI.class);
        this.msgDao = msgDao;

    }

    public void getAllChats(String userId, String contactId){
        Call<List<Msg>> call = webServiceAPI.getMessages(userId,contactId);
        call.enqueue(new Callback<List<Msg>>() {
            @Override
            public void onResponse(Call<List<Msg>> call, Response<List<Msg>> response) {
                List<Msg> msgs = response.body();
                new Thread(() -> {
                    msgDao.deleteAllByID(contactId);
                    msgDao.insertList(msgs);
                }).start();
            }

            @Override
            public void onFailure(Call<List<Msg>> call, Throwable t) {

            }
        });
    }

    public void addMsg(String userId, Msg msg){
        Call<Void> call = webServiceAPI.addMsg(userId, msg.getContactId(), msg.getContent());
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                new Thread(() -> {
                    TransferData data = new TransferData(userId, msg.getContactId(), msg.getContent());
                    Call<Void> call1 = webServiceAPI.transferMsg(data);
                    call1.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                        }
                    });

                }).start();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }
}
