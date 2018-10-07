package com.example.android.myapp.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ingredientsDao {


    @Query("SELECT * FROM mitzrahim")
    List<ingredients> loadAllingredsnr();

    @Insert
    void insertingredsnr(ingredients dish);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateingredsnr(ingredients dish);

    @Delete
    void deleteingredsnr(ingredients dish);

    @Query("SELECT * FROM mitzrahim WHERE pk = :id")
    LiveData<ingredients> loadingredsByIdnr(int id);

    @Query("DELETE FROM MITZRAHIM WHERE MITZRAHIM.dishId LIKE :a")
    void DelParams(String a);

    @Query("DELETE FROM MITZRAHIM WHERE MITZRAHIM.ingredientname1 LIKE :a")
    void DelParamsname(String a);



}
