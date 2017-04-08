package com.example.deepanshu.livinglegendapp.ui.details.core;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.deepanshu.livinglegendapp.R;
import com.example.deepanshu.livinglegendapp.models.Legend;
import com.example.deepanshu.livinglegendapp.ui.details.DetailsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by deepanshu on 7/4/17.
 */

public class DetailsView {

    @BindView(R.id.legend_details_activity_image)
    ImageView imageHero;
    @BindView(R.id.legend_details_activity_intro)
    TextView introduction;
    @BindView(R.id.legend_details_activity_text)
    TextView text;

    View view;

    public DetailsView(DetailsActivity activity, Legend legend) {

        FrameLayout layout = new FrameLayout(activity);
        layout.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        view = LayoutInflater.from(activity).inflate(R.layout.activity_details, layout, true);
        ButterKnife.bind(this, view);

        Glide.with(activity).load(legend.getImage()).into(imageHero);
        introduction.setText(TextUtils.isEmpty(legend.getIntro()) ? "no intro" : legend.getIntro());
        text.setText(TextUtils.isEmpty(legend.getText()) ? "no text" : legend.getText());
    }

    public View getView() {
        return view;
    }
}
