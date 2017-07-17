package com.wynnsolution.heinthurawynn.wynnfitnessmanagment;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.facebook.stetho.Stetho;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;
import com.wynnsolution.heinthurawynn.wynnfitnessmanagment.utilities.Constant;
import com.wynnsolution.heinthurawynn.wynnfitnessmanagment.utilities.TypefaceManager;
import com.wynnsolution.heinthurawynn.wynnfitnessmanagment.utilities.TypefaceSetter;

import io.realm.Realm;

/**
 * Created by Hein Thura Wynn on 6/28/2017.
 */

public class MainApplication extends Application {
    public static Realm realm;
    public static TypefaceManager typefaceManager;
    public static TypefaceSetter typefaceSetter;
    public static MainApplication instance;
    public static boolean isZawgyiForced;

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        typefaceManager = new TypefaceManager(getAssets());
        typefaceSetter = new TypefaceSetter(this.isZawgyiForced());
        isZawgyiForced = this.isZawgyiForced();
        realm = Realm.getDefaultInstance();
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                .build());

    }
    public MainApplication(){
        instance = this;
    }
    public static MainApplication get() {
        return instance;
    }

    public SharedPreferences getDefaultSharedPreferences(){
        return PreferenceManager.getDefaultSharedPreferences(this);
    }
    private boolean isZawgyiForced(){
        return PreferenceManager.getDefaultSharedPreferences(this).getBoolean(Constant.IS_ZG_FORCE, false);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }


}
