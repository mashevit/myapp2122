
package com.example.android.myapp;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.android.myapp.database.AppDB;
import com.example.android.myapp.database.Dish;

// COMPLETED (5) Make this class extend ViewModel
public class AddDishViewModel extends ViewModel {

    // COMPLETED (6) Add a task member variable for the TaskEntry object wrapped in a LiveData
    private LiveData<Dish> task;

    // COMPLETED (8) Create a constructor where you call loadTaskById of the taskDao to initialize the tasks variable
    // Note: The constructor should receive the database and the taskId
    public AddDishViewModel(AppDB database, String taskId) {
        task = database.dishDao().loadDishById(taskId);
    }

    // COMPLETED (7) Create a getter for the task variable
    public LiveData<Dish> getDish() {
        return task;
    }
}

