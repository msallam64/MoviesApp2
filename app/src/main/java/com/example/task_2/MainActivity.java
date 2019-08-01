package com.example.task_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;

import com.example.task_2.Model.CustomeAdapter;
import com.example.task_2.Model.DataModel;
import com.example.task_2.Model.DataModelDto;
import com.example.task_2.viewmodel.MyViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MyViewModel viewModel;
    private CustomeAdapter recyclerViewAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.list);
        recyclerViewAdapter = new CustomeAdapter(new ArrayList<DataModel>());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
        viewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        viewModel.getData().observe(MainActivity.this, new Observer<List<DataModel>>() {
            @Override
            public void onChanged(List<DataModel> dataModels) {
                recyclerViewAdapter.addItems(dataModels);

            }
        });

    }


}
