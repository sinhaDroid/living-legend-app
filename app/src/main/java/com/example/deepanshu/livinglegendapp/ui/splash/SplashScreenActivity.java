package com.example.deepanshu.livinglegendapp.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.deepanshu.livinglegendapp.application.AppController;
import com.example.deepanshu.livinglegendapp.ui.legends.LegendListActivity;
import com.example.deepanshu.livinglegendapp.ui.splash.core.SplashPresenter;
import com.example.deepanshu.livinglegendapp.ui.splash.core.SplashView;
import com.example.deepanshu.livinglegendapp.ui.splash.dagger.DaggerSplashComponent;
import com.example.deepanshu.livinglegendapp.ui.splash.dagger.SplashContextModule;

import javax.inject.Inject;

public class SplashScreenActivity extends AppCompatActivity {

    @Inject
    SplashView splashView;
    @Inject
    SplashPresenter splashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerSplashComponent.builder()
                .appComponent(AppController.getNetComponent())
                .splashContextModule(new SplashContextModule(this))
                .build()
                .inject(this);

        setContentView(splashView.constructView());
        splashPresenter.onCreate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        splashPresenter.onDestroy();
    }

    public void showList() {
        startActivity(new Intent(this, LegendListActivity.class));
    }
}
