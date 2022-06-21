package com.example.chatapp.webServiceAPI;

import com.example.chatapp.MyApplication;
import com.example.chatapp.R;
import com.example.chatapp.room.Msg;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MsgAPI {
    WebServiceAPI webServiceAPI;
    Retrofit retrofit;

    public MsgAPI(){
        retrofit = new Retrofit.Builder()
                .baseUrl(MyApplication.context.getString(R.string.BaseUrl))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        webServiceAPI = retrofit.create(WebServiceAPI.class);
    }

    public void get(String userId, String contactId){
        //set user id and contact id !!!
        Call<List<Msg>> call = webServiceAPI.getMessages(userId,contactId);
        call.enqueue(new Callback<List<Msg>>() {
            @Override
            public void onResponse(Call<List<Msg>> call, Response<List<Msg>> response) {
                List<Msg> msgs = response.body();
            }

            @Override
            public void onFailure(Call<List<Msg>> call, Throwable t) {

            }
        });
    }
}
