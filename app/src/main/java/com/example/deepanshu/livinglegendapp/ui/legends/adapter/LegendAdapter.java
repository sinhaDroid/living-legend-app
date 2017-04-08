package com.example.deepanshu.livinglegendapp.ui.legends.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.deepanshu.livinglegendapp.R;
import com.example.deepanshu.livinglegendapp.models.Legend;

import java.util.ArrayList;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by deepanshu on 7/4/17.
 */

public class LegendAdapter extends RecyclerView.Adapter<LegendViewHolder> {

    private final PublishSubject<Integer> itemClicks = PublishSubject.create();

    private ArrayList<Legend> legendist = new ArrayList<>();

    @Override
    public LegendViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_legend, parent, false);
        return new LegendViewHolder(view, itemClicks);
    }

    @Override
    public void onBindViewHolder(LegendViewHolder holder, int position) {
        holder.bind(legendist.get(position));
    }

    @Override
    public int getItemCount() {
        if (null != legendist && legendist.size() > 0) {
            return legendist.size();
        } else {
            return 0;
        }
    }

    public void swapAdapter(ArrayList<Legend> legends) {
        this.legendist.clear();
        this.legendist.addAll(legends);
        notifyDataSetChanged();
    }

    public Observable<Integer> observeClicks() {
        return itemClicks;
    }
}
