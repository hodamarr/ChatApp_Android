package com.example.chatapp.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ContactDao {

    @Query("SELECT * FROM contact WHERE userName=userName")
    List<Contact> index(String userId);

    @Query("SELECT * FROM contact WHERE id=id")
    List<Contact> get(String userId);

    @Insert
    void insert(Contact contacts);

    @Update
    void update(Contact... contacts);

    @Delete
    void delete(Contact... contacts);



}
