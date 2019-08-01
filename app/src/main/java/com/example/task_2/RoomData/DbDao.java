package com.example.task_2.RoomData;

import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import com.example.task_2.Model.DataModel;

import java.util.List;

@Dao
public interface DbDao {
    @Query("SELECT * FROM movielist")
    List<DataModel> getAll();


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<DataModel> users);


}
