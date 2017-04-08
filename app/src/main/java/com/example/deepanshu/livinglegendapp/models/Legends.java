package com.example.deepanshu.livinglegendapp.models;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by deepanshu on 7/4/17.
 */

public class Legends {

    @Expose
    private List<Legend> elements;

    public List<Legend> getElements() {
        return elements;
    }

    public void setElements(List<Legend> elements) {
        this.elements = elements;
    }
}
