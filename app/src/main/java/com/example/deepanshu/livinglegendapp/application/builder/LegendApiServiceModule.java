package com.example.deepanshu.livinglegendapp.application.builder;

import com.example.deepanshu.livinglegendapp.api.LegendApi;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by deepanshu on 7/4/17.
 */

@Module
class LegendApiServiceModule {

    // TODO: replace api
    private static final String BASE_URL = "http://coemygroup.fr/";

    @AppScope
    @Provides
    LegendApi provideApiService(OkHttpClient client, GsonConverterFactory gson, RxJavaCallAdapterFactory rxAdapter) {
        Retrofit retrofit = new Retrofit.Builder().client(client)
                .baseUrl(BASE_URL).addConverterFactory(gson)
                .addCallAdapterFactory(rxAdapter).build();

        return retrofit.create(LegendApi.class);
    }
}
