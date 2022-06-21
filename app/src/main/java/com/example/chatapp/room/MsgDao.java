package com.example.chatapp.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface MsgDao {
    @Query("SELECT * FROM Msg")
    List<Msg> index();

    @Query("SELECT * FROM Msg WHERE contactId=contactId")
    Msg get();

    @Insert
    void insert (Msg... m);

    @Update
    default void update(Msg... m) {

    }
    @Delete
    void delete (Msg... m);
}
