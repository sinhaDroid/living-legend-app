package com.example.deepanshu.livinglegendapp.ui.legends.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.deepanshu.livinglegendapp.R;
import com.example.deepanshu.livinglegendapp.models.Legend;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.subjects.PublishSubject;

/**
 * Created by deepanshu on 7/4/17.
 */

class LegendViewHolder extends RecyclerView.ViewHolder {

    View view;

    @BindView(R.id.item_hero_image)
    ImageView imageHero;
    @BindView(R.id.item_hero_name)
    TextView nameHero;
    @BindView(R.id.item_hero_year)
    TextView dateReleaseHero;
    @BindView(R.id.item_hero_separator)
    View separatorHero;
    @BindView(R.id.item_hero_text)
    TextView descriptionHero;

    LegendViewHolder(View itemView, PublishSubject<Integer> itemClicks) {
        super(itemView);
        this.view = itemView;
        ButterKnife.bind(this, itemView);
        view.setOnClickListener(v -> itemClicks.onNext(getAdapterPosition()));
    }

    void bind(Legend legend) {
        Glide.with(view.getContext()).load(legend.getImage()).into(imageHero);

        nameHero.setText(TextUtils.isEmpty(legend.getTitle()) ? "missing title" : legend.getTitle());
        dateReleaseHero.setText(TextUtils.isEmpty(legend.getYear()) ? "missing year" : legend.getYear());
        descriptionHero.setText(TextUtils.isEmpty(legend.getIntro()) ? "missing text" : legend.getIntro());
        separatorHero.setBackgroundColor(Color.parseColor(legend.getColor()));
    }
}
