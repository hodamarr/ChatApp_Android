package com.example.chatapp.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Msg.class, Contacts.class}, version = 1)
public abstract class AppDB extends RoomDatabase{
    public abstract Contacts ContactsDao();
    public abstract Msg MsgDao();

}
