package com.example.abora.moviesmvp.services.application;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

public class myApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(getApplicationContext());
    }
}
