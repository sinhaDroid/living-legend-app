package com.example.deepanshu.livinglegendapp.ui.legends.core;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.deepanshu.livinglegendapp.R;
import com.example.deepanshu.livinglegendapp.models.Legend;
import com.example.deepanshu.livinglegendapp.ui.legends.LegendListActivity;
import com.example.deepanshu.livinglegendapp.ui.legends.adapter.LegendAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;

/**
 * Created by deepanshu on 7/4/17.
 */

public class LegendsView {

    @BindView(R.id.activity_legend_list_recycleview)
    RecyclerView recyclerView;

    View view;

    LegendAdapter legendAdapter;

    public LegendsView(LegendListActivity context) {
        FrameLayout parent = new FrameLayout(context);
        parent.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view = LayoutInflater.from(context).inflate(R.layout.activity_legend_list, parent, true);
        ButterKnife.bind(this, view);

        legendAdapter = new LegendAdapter();

        recyclerView.setAdapter(legendAdapter);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(mLayoutManager);
    }

    Observable<Integer> itemClicks() {
        return legendAdapter.observeClicks();
    }

    public View getView() {
        return view;
    }

    public void swapAdapter(ArrayList<Legend> legends) {
        legendAdapter.swapAdapter(legends);
    }
}
