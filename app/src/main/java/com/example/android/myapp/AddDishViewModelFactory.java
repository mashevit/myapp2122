
package com.example.android.myapp;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.example.android.myapp.database.AppDB;

public class AddDishViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    // COMPLETED (2) Add two member variables. One for the database and one for the taskId
    private final AppDB mDb;
    private final String mTaskId;

    // COMPLETED (3) Initialize the member variables in the constructor with the parameters received
    public AddDishViewModelFactory(AppDB database, String taskId) {
        mDb = database;
        mTaskId = taskId;
    }

    // COMPLETED (4) Uncomment the following method
    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        //noinspection unchecked
        return (T) new AddDishViewModel(mDb, mTaskId);
    }
}
