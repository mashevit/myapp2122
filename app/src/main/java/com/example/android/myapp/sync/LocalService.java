package com.example.android.myapp.sync;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.android.myapp.database.AppDB;
import com.example.android.myapp.database.Dish;
import com.example.android.myapp.database.Mitzrahnames;
import com.example.android.myapp.database.ingredients;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class LocalService extends Service {
    // Binder given to clients
    private final IBinder mBinder = new LocalBinder();
    // Random number generator
//    private final Random mGenerator = new Random();

    /**
     * Class used for the client Binder.  Because we know this service always
     * runs in the same process as its clients, we don't need to deal with IPC.
     */
    public class LocalBinder extends Binder {
       public LocalService getService() {
            // Return this instance of LocalService so clients can call public methods
            return LocalService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    /** method for clients */
    public static void insertall(Map[] weatherValues, AppDB mDb) {
        for(int i=0;i<weatherValues.length;i++){
            if(weatherValues[i].get("dishName")!="null") {
                Dish a=(Dish) weatherValues[i].get("dish");
                List<Dish> tmp=mDb.dishDao().loadDishByname(a.getDishname());
                if(tmp.size()==0|tmp==null)
                    mDb.dishDao().insertDish(a);
            }
        }
    }

    public static void insertallcs(Map[] weatherValues, AppDB mDb) throws JSONException {
        for(int i=0;i<weatherValues.length;i++){
            if(weatherValues[i].get("dishName")!="null") {
                Dish a=(Dish) weatherValues[i].get("dish");
                List<Dish> tmp=mDb.dishDao().loadDishByname(a.getDishname());
                if(tmp.size()>0) a=tmp.get(0);
                else  mDb.dishDao().insertDish(a);
                JSONArray ingreds = (JSONArray) weatherValues[i].get("ingreds");

                String id =a.getId();
                for(int j=0;j<ingreds.length();j++){
                    String name = ingreds.getString(j);
                    // dish=mDb.dishDao().loadDishByIdnor(iii);
                    //Dish a=(Dish) weatherValues[i].get("dish");
                    List<Mitzrahnames> tmp1=mDb.mitzrahnamesDao().loadIngrediByname(name);

                    Mitzrahnames mitzrahnames;
                    if(tmp1.size()>0)
                        mitzrahnames=tmp1.get(0);
                    else {mitzrahnames = new Mitzrahnames(name);
                        mDb.mitzrahnamesDao().insertingreds(mitzrahnames);}
                    String idmitzrah=mitzrahnames.getIngredientidglobal();
                    ///String a = mitzrahnames.getIngredientidglobal();
                    ///String b= iii;
                    ingredients ingredients22=new ingredients(id,idmitzrah);
                    mDb.ingredientsDao().insertingredsnr(ingredients22);
                }

            }
        }
    }


    public static void cleanAll(AppDB mDb){

            mDb.clearAllTables();


    }

}