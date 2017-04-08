package com.example.deepanshu.livinglegendapp.ui.splash.core;

import com.example.deepanshu.livinglegendapp.api.LegendApi;
import com.example.deepanshu.livinglegendapp.models.Legends;
import com.example.deepanshu.livinglegendapp.ui.splash.SplashScreenActivity;
import com.example.deepanshu.livinglegendapp.utils.NetworkUtils;

import rx.Observable;

/**
 * Created by deepanshu on 7/4/17.
 */

public class SplashModel {

    private LegendApi legendApi;
    private SplashScreenActivity splashContext;

    public SplashModel(LegendApi legendApi, SplashScreenActivity splashContext) {
        this.legendApi = legendApi;
        this.splashContext = splashContext;
    }

    Observable<Legends> provideListHeroes() {
        return legendApi.getLegends();
    }

    Observable<Boolean> isNetworkAvailable() {
        return NetworkUtils.isNetworkAvailableObservable(splashContext);
    }

    public void showHeroesListActivity() {
        splashContext.showList();
    }
}
