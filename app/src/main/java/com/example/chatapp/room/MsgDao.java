package com.example.chatapp.room;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public interface MsgDao {
    @Query("SELECT * FROM Msg")
List<Contacts> index();

    @Query("SELECT * FROM Msg WHERE who=who")
    Contacts get(String who);

    @Insert
    void insert (Msg... m);

    @Update
    default void update(Msg... m) {

    }
    @Delete
    void delete (Msg... m);
}
