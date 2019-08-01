package com.example.task_2.Model;

import androidx.lifecycle.MutableLiveData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataModelDto {

    @SerializedName("results")
    @Expose
    private List<DataModel> results = null;

    public List<DataModel> getResults() {
        return results;
    }

}
