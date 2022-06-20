package com.example.chatapp.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.chatapp.objects.msg;
import java.util.List;

@Dao
public interface ChatDao {

    @Query("SELECT * FROM chat")
    List<ContactList> index();

    @Query("SELECT * FROM chat WHERE msg=msg")
    ContactList get(msg msg);

    @Insert
    void insert (Chat... chats);

    @Update
    default void update(Chat... chats) {

    }
    @Delete
    void delete (Chat... chats);
}
