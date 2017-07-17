package com.wynnsolution.heinthurawynn.wynnfitnessmanagment.utilities;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.LruCache;

/**
 * Created by Hein Thura Wynn on 6/29/2017.
 */

public class TypefaceManager {
    public static final String PYIDAUNGSU = "pyidaungsu.ttf";
    public static final String ZAWGYIONE ="zawgyi_one.ttf";
    public static final String PASSCODEFONT = "Font-Regular.ttf";

    private final AssetManager manager;

    private final LruCache<String, Typeface> mCache;

    public TypefaceManager(AssetManager manager) {
        this.manager = manager;
        int cacheSize = 4 * 1024 * 1024;
        mCache = new LruCache<>(cacheSize);
    }

    public Typeface getUnicode()
    {return getTypeface(PYIDAUNGSU);}
    public Typeface getZawgyi()
    {return getTypeface(ZAWGYIONE);}
    public Typeface getPasscodeFont(){
        return getTypeface(PASSCODEFONT);
    }
    public Typeface getTypeface(final String filename){
        Typeface typeface = mCache.get(filename);
        if(typeface == null){
            typeface = Typeface.createFromAsset(manager, filename);
        }
        return typeface;
    }
}
