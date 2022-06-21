package com.example.chatapp.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.chatapp.objects.Contact;
import com.example.chatapp.objects.Msg;

import java.util.List;

@Dao
public interface MsgDao {
    @Query("SELECT * FROM Msg")
    List<Contact> index();

    @Query("SELECT * FROM Msg WHERE contactId=contactId")
    Contact get(String who);

    @Insert
    void insert (Msg... m);

    @Update
    default void update(Msg... m) {
    }

    @Delete
    void delete (Msg... m);
}
