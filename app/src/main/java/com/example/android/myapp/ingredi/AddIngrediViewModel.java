package com.example.android.myapp.ingredi;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.android.myapp.database.AppDB;
import com.example.android.myapp.database.Dish;
import com.example.android.myapp.database.Mitzrahnames;

public class AddIngrediViewModel extends ViewModel {

    // COMPLETED (6) Add a task member variable for the TaskEntry object wrapped in a LiveData
    private LiveData<Mitzrahnames> task;

    // COMPLETED (8) Create a constructor where you call loadTaskById of the taskDao to initialize the tasks variable
    // Note: The constructor should receive the database and the taskId
    public AddIngrediViewModel(AppDB database, String taskId) {
        task = database.mitzrahnamesDao().loadingredsById(taskId);
    }

    // COMPLETED (7) Create a getter for the task variable
    public LiveData<Mitzrahnames> getIngredi() {
        return task;
    }
}

