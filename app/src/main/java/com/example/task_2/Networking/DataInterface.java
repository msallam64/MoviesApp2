package com.example.task_2.Networking;


import com.example.task_2.Model.DataModelDto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DataInterface {


    @GET("now_playing/")
    Call<DataModelDto> getUsers(@Query("api_key") String userkey);


}
