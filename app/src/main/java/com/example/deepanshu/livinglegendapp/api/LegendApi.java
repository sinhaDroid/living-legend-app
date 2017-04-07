package com.example.deepanshu.livinglegendapp.api;

import com.example.deepanshu.livinglegendapp.models.Legends;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by deepanshu on 7/4/17.
 */

public interface LegendApi {

    // TODO: Replace json url here
    @GET("test-mobile/ios/json/test.json")
    Observable<Legends> getLegends();
}
