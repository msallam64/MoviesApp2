package com.example.task_2.RoomData;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.task_2.Model.DataModel;


@Database(entities = {DataModel.class}, version = 1,exportSchema = false)
public abstract class MovieDb extends RoomDatabase {
    private static final String DB_NAME = "repoDatabase.db";
    private static volatile MovieDb instance;

    public static  MovieDb getInstance(Context context) {
        if (instance == null) {
            instance =
                    Room.databaseBuilder(context.getApplicationContext(),
                            MovieDb.class,DB_NAME).allowMainThreadQueries().build();
        }
        return instance;
    }




    public abstract DbDao getRepoDao();
}