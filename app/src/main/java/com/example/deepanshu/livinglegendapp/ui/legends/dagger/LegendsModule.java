package com.example.deepanshu.livinglegendapp.ui.legends.dagger;

import com.example.deepanshu.livinglegendapp.api.LegendApi;
import com.example.deepanshu.livinglegendapp.ui.legends.LegendListActivity;
import com.example.deepanshu.livinglegendapp.ui.legends.core.LegendsModel;
import com.example.deepanshu.livinglegendapp.ui.legends.core.LegendsPresenter;
import com.example.deepanshu.livinglegendapp.ui.legends.core.LegendsView;
import com.example.deepanshu.livinglegendapp.utils.rx.RxSchedulers;

import dagger.Module;
import dagger.Provides;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by deepanshu on 7/4/17.
 */

@Module
public class LegendsModule {

    LegendListActivity context;

    public LegendsModule(LegendListActivity context) {
        this.context = context;
    }

    @LegendScope
    @Provides
    LegendsView provideView() {
        return new LegendsView(context);
    }

    @LegendScope
    @Provides
    LegendsPresenter providePresenter(RxSchedulers schedulers, LegendsView view, LegendsModel model) {
        CompositeSubscription subscriptions = new CompositeSubscription();
        return new LegendsPresenter(view, model, schedulers, subscriptions);
    }

    @LegendScope
    @Provides
    LegendsModel provideModel(LegendApi api) {
        return new LegendsModel(context, api);
    }
}
