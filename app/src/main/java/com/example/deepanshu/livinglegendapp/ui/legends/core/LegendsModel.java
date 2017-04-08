package com.example.deepanshu.livinglegendapp.ui.legends.core;

import com.example.deepanshu.livinglegendapp.api.LegendApi;
import com.example.deepanshu.livinglegendapp.models.Legend;
import com.example.deepanshu.livinglegendapp.models.Legends;
import com.example.deepanshu.livinglegendapp.ui.legends.LegendListActivity;
import com.example.deepanshu.livinglegendapp.utils.NetworkUtils;

import rx.Observable;

/**
 * Created by deepanshu on 7/4/17.
 */

public class LegendsModel {

    private LegendListActivity context;
    private LegendApi api;

    public LegendsModel(LegendListActivity context, LegendApi api) {
        this.context = context;
        this.api = api;
    }

    Observable<Legends> provideListLegends() {
        return api.getLegends();
    }

    Observable<Boolean> isNetworkAvailable() {
        return NetworkUtils.isNetworkAvailableObservable(context);
    }

    void goToDetailActivity(Legend legend) {
        context.startDetailActivity(legend);
    }
}
