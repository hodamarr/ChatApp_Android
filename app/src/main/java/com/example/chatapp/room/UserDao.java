package com.example.chatapp.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> index();

    @Query("SELECT * FROM user WHERE name= :id")
    User get(String id);

    @Insert
    void addUser(User... u);

    @Insert
    void addListUser(List<User> users);

    @Query("DELETE FROM user")
    void deleteAll();

}
