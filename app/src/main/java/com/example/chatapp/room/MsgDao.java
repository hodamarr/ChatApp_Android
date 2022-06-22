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

    @Query("SELECT * FROM Msg WHERE contactId=:contactId")
    List<Msg> getByID(String contactId);

    @Insert
    void insert(Msg m);

    @Update
    void update(Msg... m);

    @Delete
    void delete(Msg... m);

    @Query("DELETE FROM msg WHERE contactId=:contactId")
    void deleteAllByID(String contactId);

    @Insert
    void insertList(List<Msg> msg);

    @Query("DELETE FROM msg")
    void deleteAll();
}
