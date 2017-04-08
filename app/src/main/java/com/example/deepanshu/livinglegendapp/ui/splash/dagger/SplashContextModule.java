package com.example.deepanshu.livinglegendapp.ui.splash.dagger;

import com.example.deepanshu.livinglegendapp.ui.splash.SplashScreenActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by deepanshu on 7/4/17.
 */

@Module
public class SplashContextModule {

    SplashScreenActivity splashContext;

    public SplashContextModule(SplashScreenActivity splashContext) {
        this.splashContext = splashContext;
    }

    @SplashScope
    @Provides
    SplashScreenActivity provideSplashActivity() {
        return splashContext;
    }
}
