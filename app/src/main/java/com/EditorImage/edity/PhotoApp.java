package com.EditorImage.edity;

import android.app.Application;
import android.content.Context;

public class PhotoApp extends Application {
    private static final String TAG = PhotoApp.class.getSimpleName();
    private static PhotoApp sPhotoApp;

    public static PhotoApp getPhotoApp() {
        return sPhotoApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sPhotoApp = this;
    }

    public Context getContext() {
        return sPhotoApp.getContext();
    }
}
