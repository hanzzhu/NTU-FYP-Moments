package com.fyp.moments;

import android.app.Application;
import android.content.Context;



public class MomentsApp extends Application {
    private static MomentsApp sMomentsApp;
    private static final String TAG = MomentsApp.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        sMomentsApp = this;
     
    }

    public static MomentsApp getPhotoApp() {
        return sMomentsApp;
    }

    public Context getContext() {
        return sMomentsApp.getContext();
    }
}
