package com.example.deepanshu.livinglegendapp.application.builder;

import android.content.Context;

import com.example.deepanshu.livinglegendapp.api.LegendApi;
import com.example.deepanshu.livinglegendapp.utils.rx.RxSchedulers;

import dagger.Component;

/**
 * Created by deepanshu on 7/4/17.
 */

@AppScope
@Component(modules = {NetworkModule.class, AppContextModule.class, RxModule.class, LegendApiServiceModule.class})
public interface AppComponent {

    Context getAppContext();

    RxSchedulers rxSchedulers();

    LegendApi apiService();
}
