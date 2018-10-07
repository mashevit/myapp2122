package com.example.android.myapp.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.UUID;

@Entity(tableName = "mitzrahimnames")
public class Mitzrahnames {

    @PrimaryKey @NonNull /*(autoGenerate = true)*/
    private String ingredientidglobal;
    private String ingredientname;
@Ignore
    public Mitzrahnames(String ingredientname) {

    this(UUID.randomUUID().toString(), ingredientname);

   // this.ingredientname = ingredientname;
    }

/*    @Ignore
    public Mitzrahnames(String ingredientname) {
        this.ingredientname = ingredientname;


    }*/



    public Mitzrahnames(String ingredientidglobal, String ingredientname) {
        this.ingredientidglobal = ingredientidglobal;
        this.ingredientname = ingredientname;

    }

    public String getIngredientidglobal() {
        return ingredientidglobal;
    }

    public void setIngredientidglobal(String ingredientidglobal) {
        this.ingredientidglobal = ingredientidglobal;
    }

    public String getIngredientname() {
        return ingredientname;
    }

    public void setIngredientname(String ingredientname) {
        this.ingredientname = ingredientname;
    }
}
