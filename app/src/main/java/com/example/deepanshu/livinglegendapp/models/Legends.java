package com.example.deepanshu.livinglegendapp.models;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by deepanshu on 7/4/17.
 */

public class Legends {

    @Expose
    private List<Legend> legendList;

    public List<Legend> getLegendList() {
        return legendList;
    }

    public void setLegendList(List<Legend> legendList) {
        this.legendList = legendList;
    }
}
