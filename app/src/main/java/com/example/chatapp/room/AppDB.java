package com.example.chatapp.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ContactList.class}, version = 1)
public abstract class AppDB extends RoomDatabase{
    public abstract ContactLstDao contactLstDao();

}
