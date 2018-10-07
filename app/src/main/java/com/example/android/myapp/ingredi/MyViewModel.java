package com.example.android.myapp.ingredi;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;


import com.example.android.myapp.database.AppDB;
import com.example.android.myapp.database.Mitzrahnames;
//import streams
import java.util.List;

//import java8.util.stream.StreamSupport;

//import java.util.stream.Collectors;
//import com.annimon.stream.*;
public class MyViewModel extends ViewModel {
    private final LiveData<List<Mitzrahnames>> myObjectList1;
    private AppDB appDatabase;

    public MyViewModel(AppDB appDatabase, String[] param) {
       // super(application);
      //  appDatabase = AppDatabase.getDatabase(this.getApplication());

        LiveData<List<Mitzrahnames>> myObjectList = appDatabase.mitzrahnamesDao().loadAllingredswithp(param);
        LiveData<List<Mitzrahnames>> myObjectL=Transformations.map(myObjectList, user -> {
         for(int i=0;i<user.size();i++){
             if(i+1<user.size()&&user.get(i+1).getIngredientidglobal()==user.get(i).getIngredientidglobal())
                 user.remove(i);
         }
         return user;
        });
        myObjectList1=myObjectL;
    }
    public LiveData<List<Mitzrahnames>> getIngrediwithparam() {
        return myObjectList1;
    }
}