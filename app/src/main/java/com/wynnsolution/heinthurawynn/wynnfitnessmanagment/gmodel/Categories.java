package com.wynnsolution.heinthurawynn.wynnfitnessmanagment.gmodel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Hein Thura Wynn on 7/15/2017.
 */

public class Categories {
    @SerializedName("categories")
    private List<Category> categories;
    public List<Category> getCategories(){
        return categories;
    }
}
