package com.example.vivek.tablyoutdemo.database;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.util.Log;

import com.example.vivek.tablyoutdemo.model.BabyName;

@android.arch.persistence.room.Database(entities = {BabyName.class}, version = 1, exportSchema = false)
public  abstract  class AppDatabase extends RoomDatabase{

    private static String TAG=AppDatabase.class.getSimpleName();

    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "nameData";

    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    //create AppDatabase
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DATABASE_NAME)
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        Log.d(TAG, "getDatabase instance  ");
        return INSTANCE;
    }

    public abstract BabyDao babyDao();

}
