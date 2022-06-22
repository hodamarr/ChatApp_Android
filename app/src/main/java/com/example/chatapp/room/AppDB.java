package com.example.chatapp.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Contact.class, Msg.class, User.class}, version = 4)
public abstract class AppDB extends RoomDatabase {
    private static volatile AppDB appDB;
    public abstract MsgDao msgDao();
    public abstract ContactDao contactDao();

    public static AppDB getInstance(Context context){
        if(appDB == null){
            appDB = Room.databaseBuilder(context.getApplicationContext(), AppDB.class, "myDB")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return appDB;
    }
}
