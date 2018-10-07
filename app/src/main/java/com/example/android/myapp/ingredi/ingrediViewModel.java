package com.example.android.myapp.ingredi;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.util.Log;

import com.example.android.myapp.MainViewModel;
import com.example.android.myapp.database.AppDB;
import com.example.android.myapp.database.Dish;
import com.example.android.myapp.database.Mitzrahnames;

import java.util.List;

public class ingrediViewModel extends AndroidViewModel {

    // Constant for logging
    private static final String TAG = MainViewModel.class.getSimpleName();

    private LiveData<List<Mitzrahnames>> tasks;

    public ingrediViewModel(Application application) {
        super(application);
        AppDB database = AppDB.getInstance(this.getApplication());
        Log.d(TAG, "Actively retrieving the tasks from the DataBase");
        tasks = database.mitzrahnamesDao().loadAllingreds();
    }

    public LiveData<List<Mitzrahnames>> getTasks() {
        return tasks;
    }
}


