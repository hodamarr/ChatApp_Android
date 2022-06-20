package com.example.chatapp.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ContactLstDao {

    @Query("SELECT * FROM contactlist")
    List<ContactList> index();

    @Query("SELECT * FROM contactlist WHERE c=c")
    ContactList get(String c);

    @Insert
    void insert (ContactList... cl);

    @Update
    default void update(ContactList... cl) {

    }
    @Delete
    void delete (ContactList... cl);
}
