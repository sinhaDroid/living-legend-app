package com.example.deepanshu.livinglegendapp.ui.legends.core;

import android.util.Log;

import com.example.deepanshu.livinglegendapp.models.Legend;
import com.example.deepanshu.livinglegendapp.utils.UiUtils;
import com.example.deepanshu.livinglegendapp.utils.rx.RxSchedulers;

import java.util.ArrayList;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by deepanshu on 7/4/17.
 */

public class LegendsPresenter {

    private LegendsView legendsView;
    private LegendsModel legendsModel;
    private RxSchedulers rxSchedulers;
    private CompositeSubscription subscription;
    private ArrayList<Legend> legend;

    public LegendsPresenter(LegendsView legendsView, LegendsModel legendsModel, RxSchedulers rxSchedulers, CompositeSubscription subscription) {
        this.legendsView = legendsView;
        this.legendsModel = legendsModel;
        this.rxSchedulers = rxSchedulers;
        this.subscription = subscription;
    }

    public void onCreate() {
        subscription.add(getLegendList());
        subscription.add(respondToClick());
    }

    public void onDestroy() {
        subscription.clear();
    }

    private Subscription getLegendList() {
        return legendsModel.isNetworkAvailable().doOnNext(networkAvailable -> {
            if (!networkAvailable) {
                Log.d("no conn", "no connexion");
            }
        })
                .filter(isNetworkAvailable -> true)
                .flatMap(isAvailable -> legendsModel.provideListLegends())
                .subscribeOn(rxSchedulers.internet())
                .observeOn(rxSchedulers.androidThread())
                .subscribe(legends -> legendsView.swapAdapter(legend = (ArrayList<Legend>) legends.getElements()), UiUtils::handleThrowable);
    }

    private Subscription respondToClick() {
        return legendsView.itemClicks()
                .subscribe(integer -> legendsModel.goToDetailActivity(legend.get(integer)));
    }
}
