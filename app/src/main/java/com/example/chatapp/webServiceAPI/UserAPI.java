package com.example.chatapp.webServiceAPI;

import android.util.Log;

import com.example.chatapp.MyApplication;
import com.example.chatapp.R;
import com.example.chatapp.room.User;

import java.util.List;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserAPI {
    private WebServiceAPI webServiceAPI;
    private Retrofit retrofit;
    private UserDao userDao;



    public UserAPI(UserDao userDao){
        retrofit = new Retrofit.Builder()
                .baseUrl(MyApplication.context.getString(R.string.BaseUrl))
                .callbackExecutor(Executors.newSingleThreadExecutor())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        webServiceAPI = retrofit.create(WebServiceAPI.class);
        this.userDao = userDao;
        //userDao.addUser(new User("Hod","Hodi", "1234" , "1.2.3.4"));
    }

    public void get(){
        Call<List<User>> call = webServiceAPI.getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                Log.d("on response", "aaaaa");
                List<User> users = response.body();
                new Thread(() -> {
                    userDao.deleteAll();
                    userDao.addListUser(users);
                });
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.d("on fail","aaaa");
            }
        });
    }

    public void add(User u){

    }

}
