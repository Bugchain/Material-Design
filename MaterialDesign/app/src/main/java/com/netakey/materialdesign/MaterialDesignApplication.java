package com.netakey.materialdesign;

import android.app.Application;

/**
 * Created by POSEIDON on 25/4/2559.
 */
public class MaterialDesignApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        // On application create.
        Contextor.getInstance().init(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        // On application destroy.
    }
}
