package com.example.chatapp.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Contact.class, Msg.class}, version = 2)
public abstract class AppDB extends RoomDatabase {
    public abstract MsgDao msgDao();
    public abstract ContactDao contactDao();
}
