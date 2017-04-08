package com.example.deepanshu.livinglegendapp.ui.details.dagger;

import com.example.deepanshu.livinglegendapp.ui.details.DetailsActivity;

import dagger.Component;

/**
 * Created by deepanshu on 8/4/17.
 */

@Component(modules = {DetailsModule.class})
public interface DetailsComponent {
    void inject(DetailsActivity activity);
}
