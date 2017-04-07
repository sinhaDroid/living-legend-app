package com.example.deepanshu.livinglegendapp.application.builder;

import com.example.deepanshu.livinglegendapp.utils.rx.AppRxSchedulers;
import com.example.deepanshu.livinglegendapp.utils.rx.RxSchedulers;

import dagger.Module;
import dagger.Provides;

/**
 * Created by deepanshu on 7/4/17.
 */

@Module
public class RxModule {

    @Provides
    RxSchedulers provideRxSchedulers() {
        return new AppRxSchedulers();
    }
}
