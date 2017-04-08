package com.example.deepanshu.livinglegendapp.ui.details.dagger;

import com.example.deepanshu.livinglegendapp.models.Legend;
import com.example.deepanshu.livinglegendapp.ui.details.DetailsActivity;
import com.example.deepanshu.livinglegendapp.ui.details.core.DetailsView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by deepanshu on 8/4/17.
 */

@Module
public class DetailsModule {

    private DetailsActivity detailsActivity;
    private Legend legend;

    public DetailsModule(DetailsActivity detailsActivity, Legend legend) {
        this.detailsActivity = detailsActivity;
        this.legend = legend;
    }

    @Provides
    DetailsView provideView() {
        return new DetailsView(detailsActivity, legend);
    }
}
