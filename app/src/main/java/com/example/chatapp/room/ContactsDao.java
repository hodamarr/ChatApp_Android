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
    @Query("SELECT * FROM contacts")
    List<Contacts> index();

    @Query("SELECT * FROM contacts WHERE id=id")
    Contacts get();

    @Insert
    void insert (Contacts... contacts);

    @Update
    default void update(Contacts... contacts) {

    }
    @Delete
    void delete (Contacts... contacts);
}
