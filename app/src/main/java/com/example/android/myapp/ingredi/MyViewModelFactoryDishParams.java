package com.example.android.myapp.ingredi;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.example.android.myapp.database.AppDB;

import java.util.List;

public class MyViewModelFactoryDishParams extends ViewModelProvider.NewInstanceFactory {
    private AppDB mApplication;
    private String[] mParam;


    public MyViewModelFactoryDishParams(AppDB application, String[] param) {
        mApplication = application;
        mParam = param;
    }


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new MyViewModel(mApplication, mParam);
    }
}