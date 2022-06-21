package com.example.chatapp.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.chatapp.objects.Contact;

import java.util.List;

@Dao
public interface ContactsDao {

    @Query("SELECT * FROM Contact")
    List<Contact> index();


    @Query("SELECT * FROM Contact WHERE id=id")
    Contact get(String id);

    @Insert
    void insert (Contact... contacts);

    @Update
    default void update(Contact... contacts) {

    }
    @Delete
    void delete (Contact... contacts);
}
