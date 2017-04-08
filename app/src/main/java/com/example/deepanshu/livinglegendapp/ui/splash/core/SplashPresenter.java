package com.example.deepanshu.livinglegendapp.ui.splash.core;

import android.util.Log;

import com.example.deepanshu.livinglegendapp.utils.UiUtils;
import com.example.deepanshu.livinglegendapp.utils.rx.RxSchedulers;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by deepanshu on 7/4/17.
 */

public class SplashPresenter {

    private SplashModel model;
    private RxSchedulers rxSchedulers;
    private CompositeSubscription subscription;

    public SplashPresenter(SplashModel model, RxSchedulers rxSchedulers, CompositeSubscription subscription) {
        this.model = model;
        this.rxSchedulers = rxSchedulers;
        this.subscription = subscription;
    }

    public void onCreate() {
        subscription.add(getLegendList());
    }

    public void onDestroy() {
        subscription.clear();
    }

    private Subscription getLegendList() {
        return model.isNetworkAvailable().doOnNext(networkAvailable -> {
            if (!networkAvailable) {
                Log.d("no conn", "no connection");
            }
        })
                .filter(isNetworkAvailable -> true)
                .flatMap(isAvailable -> model.isNetworkAvailable())
                .subscribeOn(rxSchedulers.internet())
                .observeOn(rxSchedulers.androidThread())
                .subscribe(aBoolean -> model.showHeroesListActivity(), UiUtils::handleThrowable);
    }
}
