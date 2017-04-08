package com.example.deepanshu.livinglegendapp.ui.splash.dagger;

import com.example.deepanshu.livinglegendapp.api.LegendApi;
import com.example.deepanshu.livinglegendapp.ui.splash.SplashScreenActivity;
import com.example.deepanshu.livinglegendapp.ui.splash.core.SplashModel;
import com.example.deepanshu.livinglegendapp.ui.splash.core.SplashPresenter;
import com.example.deepanshu.livinglegendapp.ui.splash.core.SplashView;
import com.example.deepanshu.livinglegendapp.utils.rx.RxSchedulers;

import dagger.Module;
import dagger.Provides;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by deepanshu on 7/4/17.
 */

@Module
class SplashModule {

    @SplashScope
    @Provides
    SplashPresenter providePresenter(RxSchedulers schedulers, SplashModel model) {
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        return new SplashPresenter(model, schedulers, compositeSubscription);
    }


    @SplashScope
    @Provides
    SplashView provideSplashView(SplashScreenActivity context) {
        return new SplashView(context);
    }


    @SplashScope
    @Provides
    SplashModel provideSplashModel(LegendApi api, SplashScreenActivity ctx) {
        return new SplashModel(api, ctx);
    }
}
