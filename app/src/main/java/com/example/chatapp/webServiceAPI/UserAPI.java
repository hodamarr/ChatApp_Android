package com.example.chatapp.webServiceAPI;

import com.example.chatapp.MyApplication;
import com.example.chatapp.R;
import com.example.chatapp.room.AppDB;
import com.example.chatapp.room.User;
import com.example.chatapp.room.UserDao;

import java.util.List;

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
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        webServiceAPI = retrofit.create(WebServiceAPI.class);
        this.userDao = userDao;
    }

    public void get(){
        Call<List<User>> call = webServiceAPI.getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                List<User> users = response.body();
                new Thread(() -> {
                    userDao.deleteAll();
                    userDao.addListUser(users);
                });
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
    }

    public void add(User u){
        Call<Void> call = webServiceAPI.createUser(u);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                userDao.addUser(u);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

}
