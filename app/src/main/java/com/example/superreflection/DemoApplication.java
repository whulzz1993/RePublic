package com.example.superreflection;

import android.app.Application;
import android.content.Context;
import android.os.Build;

public class DemoApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public DemoApplication() {
        super();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P
                || (Build.VERSION.SDK_INT == Build.VERSION_CODES.O_MR1 && Build.VERSION.PREVIEW_SDK_INT > 0)) {
            System.loadLibrary("republic");
        }
    }
}
