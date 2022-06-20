package com.example.chatapp.room;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public interface MsgDao {
    @Query("SELECT * FROM msg")
List<Contacts> index();

    @Query("SELECT * FROM msg WHERE who=who")
    Contacts get(String who);

    @Insert
    void insert (msg... m);

    @Update
    default void update(msg... m) {

    }
    @Delete
    void delete (msg... m);
}
