package com.example.deepanshu.livinglegendapp.ui.splash.dagger;

import com.example.deepanshu.livinglegendapp.application.builder.AppComponent;
import com.example.deepanshu.livinglegendapp.ui.splash.SplashScreenActivity;

import dagger.Component;

/**
 * Created by deepanshu on 7/4/17.
 */

@SplashScope
@Component(modules = {SplashContextModule.class, SplashModule.class}, dependencies = {AppComponent.class})
public interface SplashComponent {
    void inject(SplashScreenActivity activity);
}
