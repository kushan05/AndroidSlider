package com.example.kushan.sliderview;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by kushan on 5/5/2018.
 */

public class PreferenceManager {
    private Context context;
    private SharedPreferences sharedPreferences;

    public PreferenceManager(Context context) {
        this.context = context;
        getSharedpreferences();
    }

    private void getSharedpreferences(){
        sharedPreferences = context.getSharedPreferences("kushan",0);
    }
}
