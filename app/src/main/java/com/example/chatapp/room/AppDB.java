package com.example.chatapp.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.chatapp.objects.Contact;

@Database(entities = {Msg.class, Contact.class}, version = 3)
public abstract class AppDB extends RoomDatabase{
    public abstract ContactsDao ContactsDao();
    public abstract MsgDao MsgDao();

}
