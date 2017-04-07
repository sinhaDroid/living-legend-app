package com.example.deepanshu.livinglegendapp.application.builder;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by deepanshu on 7/4/17.
 */

@Module
public class AppContextModule {

    private final Context context;

    public AppContextModule(Context context) {
        this.context = context;
    }

    @AppScope
    @Provides
    Context provideAppContext() {
        return context;
    }
}
