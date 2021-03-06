package com.netakey.materialdesign;

import android.content.Context;

/**
 * Created by POSEIDON on 25/4/2559.
 */
public class Contextor {

    private static Contextor instance;

    public static Contextor getInstance(){
        if(instance == null){
            instance = new Contextor();
        }
        return instance;
    }

    private Context mContext;

    private Contextor(){}

    public void init(Context context){
        mContext = context;
    }
    public Context getContext(){
        return mContext;
    }
}
