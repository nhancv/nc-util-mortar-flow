package com.nhancv.mortarflow;

import android.app.Application;

import mortar.MortarScope;

/**
 * Created by nhancao on 6/11/16.
 */
public class MyApp extends Application {
    private MortarScope rootScope;

    @Override public Object getSystemService(String name) {
        if (rootScope == null) rootScope = MortarScope.buildRootScope().build("Root");

        return rootScope.hasService(name) ? rootScope.getService(name) : super.getSystemService(name);
    }
}