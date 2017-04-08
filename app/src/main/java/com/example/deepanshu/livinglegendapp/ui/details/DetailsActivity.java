package com.example.deepanshu.livinglegendapp.ui.details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.deepanshu.livinglegendapp.models.Legend;
import com.example.deepanshu.livinglegendapp.ui.details.core.DetailsView;
import com.example.deepanshu.livinglegendapp.ui.details.dagger.DaggerDetailsComponent;
import com.example.deepanshu.livinglegendapp.ui.details.dagger.DetailsModule;

import javax.inject.Inject;

/**
 * Created by deepanshu on 7/4/17.
 */

public class DetailsActivity extends AppCompatActivity {

    @Inject
    DetailsView detailsView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Legend legend = (Legend) getIntent().getExtras().get("Legend");

        DaggerDetailsComponent.builder()
                .detailsModule(new DetailsModule(this, legend))
                .build()
                .inject(this);

        setContentView(detailsView.getView());
    }
}
