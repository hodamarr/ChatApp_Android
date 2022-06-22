package com.example.chatapp.repository;

import com.example.chatapp.MyApplication;
import com.example.chatapp.room.AppDB;
import com.example.chatapp.room.User;
import com.example.chatapp.room.UserDao;
import com.example.chatapp.webServiceAPI.UserAPI;

import java.util.List;

public class UserRepository {
    private UserAPI userAPI;
    private UserDao userDao;

    public UserRepository(){
        userDao = AppDB.getInstance(MyApplication.context).userDao();
        userAPI = new UserAPI(userDao);
    }

    public List<User> getAll(){
        reload();
        return userDao.index();
    }

    public void addUser(User u){
        userAPI.add(u);
    }

    public void reload(){
        userAPI.get();

    }
}
