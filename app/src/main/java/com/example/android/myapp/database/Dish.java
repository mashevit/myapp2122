package com.example.android.myapp.database;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.UUID;

import static android.arch.persistence.room.ForeignKey.CASCADE;
import static android.arch.persistence.room.ForeignKey.SET_NULL;

@Entity(tableName = "dishent"/*,foreignKeys = @ForeignKey(entity = ingredients.class,
        parentColumns = "ingredientid",
        childColumns = "ingredient_fk",onDelete = CASCADE,onUpdate = SET_NULL),indices = {@Index("ingredient_fk")}*/)
public class Dish {


    @PrimaryKey @NonNull/*(autoGenerate = true)*/
    private String id;
    private String dishname;
    private boolean isChecked;
  //  private int ingredient_fk;
    

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    @Ignore
    public Dish(String dishname) {
       // this.dishname = dishname;
        this(UUID.randomUUID().toString(), dishname,false);
    }

    public Dish(String id, String dishname,boolean isChecked) {
        this.id = id;
        this.dishname = dishname;
        this.isChecked=isChecked;
    //    this.ingredient_fk = 0; //ingredient_fk;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDishname() {
        return dishname;
    }

    public void setDishname(String dishname) {
        this.dishname = dishname;
    }

}
