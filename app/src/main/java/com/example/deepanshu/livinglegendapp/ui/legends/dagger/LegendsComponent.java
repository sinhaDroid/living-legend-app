package com.example.deepanshu.livinglegendapp.ui.legends.dagger;

import com.example.deepanshu.livinglegendapp.application.builder.AppComponent;
import com.example.deepanshu.livinglegendapp.ui.legends.LegendListActivity;

import dagger.Component;

/**
 * Created by deepanshu on 7/4/17.
 */

@LegendScope
@Component(dependencies = {AppComponent.class}, modules = {LegendsModule.class})
public interface LegendsComponent {
    void inject(LegendListActivity activity);
}
