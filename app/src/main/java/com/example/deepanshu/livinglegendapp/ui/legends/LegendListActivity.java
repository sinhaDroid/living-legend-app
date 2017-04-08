package com.example.deepanshu.livinglegendapp.ui.legends;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.deepanshu.livinglegendapp.application.AppController;
import com.example.deepanshu.livinglegendapp.models.Legend;
import com.example.deepanshu.livinglegendapp.ui.details.DetailsActivity;
import com.example.deepanshu.livinglegendapp.ui.legends.core.LegendsPresenter;
import com.example.deepanshu.livinglegendapp.ui.legends.core.LegendsView;
import com.example.deepanshu.livinglegendapp.ui.legends.dagger.DaggerLegendsComponent;
import com.example.deepanshu.livinglegendapp.ui.legends.dagger.LegendsModule;

import javax.inject.Inject;

/**
 * Created by deepanshu on 7/4/17.
 */

public class LegendListActivity extends AppCompatActivity {

    @Inject
    LegendsView view;

    @Inject
    LegendsPresenter legendsPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerLegendsComponent.builder()
                .appComponent(AppController.getNetComponent())
                .legendsModule(new LegendsModule(this))
                .build()
                .inject(this);

        setContentView(view.getView());
        legendsPresenter.onCreate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        legendsPresenter.onDestroy();
    }

    public void startDetailActivity(Legend legend) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("Legend", legend);
        startActivity(intent);
    }
}
