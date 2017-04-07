package com.example.deepanshu.livinglegendapp.utils.rx;

import rx.Scheduler;

/**
 * Created by deepanshu on 7/4/17.
 */

public interface RxSchedulers {

    Scheduler runOnBackground();

    Scheduler io();

    Scheduler compute();

    Scheduler androidThread();

    Scheduler internet();
}
