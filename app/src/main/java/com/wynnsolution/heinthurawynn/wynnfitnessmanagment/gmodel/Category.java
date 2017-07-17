package com.wynnsolution.heinthurawynn.wynnfitnessmanagment.gmodel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hein Thura Wynn on 7/15/2017.
 */

public class Category {
    @SerializedName("id")
    private  int id;
    @SerializedName("name")
    private String name;

    public Category(int id, String name){
        this.id = id;
        this.name = name;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
}
