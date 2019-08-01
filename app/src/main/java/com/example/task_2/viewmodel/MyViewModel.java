package com.example.task_2.viewmodel;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.task_2.Model.DataModel;
import com.example.task_2.Model.DataModelDto;
import com.example.task_2.Networking.DataInterface;
import com.example.task_2.Networking.MyRetrofit;
import com.example.task_2.RoomData.MovieDb;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyViewModel extends AndroidViewModel {
    public String apiKey = "31521ab741626851b73c684539c33b5a";
    private MutableLiveData<List<DataModel>> data=new MutableLiveData<>();
    DataModelDto dataModelDto=new DataModelDto();
    static MovieDb movieDb;
    List<DataModel> roomdata=new ArrayList<>();




    public MyViewModel(@NonNull Application application) {
        super(application);
        DataInterface dataInterface = MyRetrofit.getRetrofitInstance().create(DataInterface.class);
        Call<DataModelDto> dataModelCall = dataInterface.getUsers(apiKey);
        dataModelCall.enqueue(new Callback<DataModelDto>() {
            @Override
            public void onResponse(Call<DataModelDto> call, Response<DataModelDto> response) {
                movieDb=MovieDb.getInstance(getApplication());
                dataModelDto=response.body();
                data.setValue(dataModelDto.getResults());
                roomdata=dataModelDto.getResults();
                movieDb.getRepoDao().insertAll(roomdata);
                Toast.makeText(getApplication(),"Done ",Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<DataModelDto> call, Throwable t) {
                movieDb=MovieDb.getInstance(getApplication());
                roomdata=movieDb.getRepoDao().getAll();
                data.setValue(roomdata);
                Toast.makeText(getApplication(),"From DB",Toast.LENGTH_LONG).show();

            }
        });


    }

    public MutableLiveData<List<DataModel>> getData() {
        return data;
    }


}
