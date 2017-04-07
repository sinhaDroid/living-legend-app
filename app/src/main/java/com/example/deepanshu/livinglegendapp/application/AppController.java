package com.example.deepanshu.livinglegendapp.application;

import android.app.Application;

import com.example.deepanshu.livinglegendapp.BuildConfig;
import com.example.deepanshu.livinglegendapp.application.builder.AppComponent;
import com.example.deepanshu.livinglegendapp.application.builder.AppContextModule;
import com.example.deepanshu.livinglegendapp.application.builder.DaggerAppComponent;

import timber.log.Timber;

/**
 * Created by deepanshu on 7/4/17.
 */

public class AppController extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initialiseLogger();
        initAppComponent();
    }

    private void initAppComponent() {
        appComponent = DaggerAppComponent.builder().appContextModule(new AppContextModule(this)).build();
    }

    private void initialiseLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new Timber.Tree() {
                @Override
                protected void log(int priority, String tag, String message, Throwable t) {
                    //TODO  decide what to log in release version
                }
            });
        }
    }

    public static AppComponent getNetComponent() {
        return appComponent;
    }
}
