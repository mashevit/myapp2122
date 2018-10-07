package com.example.android.myapp;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.util.Log;

import com.example.android.myapp.database.AppDB;
import com.example.android.myapp.database.Dish;


import java.util.List;

public class MainViewModel extends AndroidViewModel {

    // Constant for logging
    private static final String TAG = MainViewModel.class.getSimpleName();

    private LiveData<List<Dish>> tasks;

    public MainViewModel(Application application) {
        super(application);
        AppDB database = AppDB.getInstance(this.getApplication());
        Log.d(TAG, "Actively retrieving the tasks from the DataBase");
        tasks = database.dishDao().loadAllDishes();
    }

    public LiveData<List<Dish>> getTasks() {
        return tasks;
    }
}
