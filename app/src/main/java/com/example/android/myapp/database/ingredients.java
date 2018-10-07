package com.example.android.myapp.database;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;
import static android.arch.persistence.room.ForeignKey.SET_NULL;

@Entity(tableName = "mitzrahim",foreignKeys = {@ForeignKey(entity = Mitzrahnames.class,
        parentColumns = "ingredientidglobal",
        childColumns = "ingredientname1",onDelete = CASCADE,onUpdate = SET_NULL),
        @ForeignKey(entity = Dish.class,
        parentColumns = "id",
        childColumns = "dishId",onDelete = CASCADE,onUpdate = SET_NULL)},indices = {@Index("ingredientname1"),@Index("dishId")} )
public class ingredients {
    @PrimaryKey(autoGenerate = true)
    private int pk;

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    private String dishId;
    private String ingredientname1;

    public ingredients(int pk, String dishId, String ingredientname1) {
        this.pk = pk;
        this.dishId = dishId;
        this.ingredientname1 = ingredientname1;
    }
@Ignore
    public ingredients(String dishId, String ingredientname1) {
        this.dishId = dishId;
        this.ingredientname1 = ingredientname1;
    }

    public String getDishId() {
        return dishId;
    }

    public void setDishId(String ingrediantid) {
        this.dishId = ingrediantid;
    }

    public String getIngredientname1() {
        return ingredientname1;
    }

    public void setIngredientname1(String ingredientname) {
        this.ingredientname1 = ingredientname;
    }
}
