package com.example.chatapp.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ContactDao {

    @Query("SELECT * FROM contact")
    List<Contact> index();

    @Query("SELECT * FROM contact WHERE id=id")
    Contact get();

    @Insert
    void insert(Contact contacts);

    @Update
    void update(Contact... contacts);

    @Delete
    void delete(Contact... contacts);


}
