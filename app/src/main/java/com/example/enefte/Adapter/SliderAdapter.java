package com.example.enefte.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.enefte.R;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    public  int[] slide_images = {

            R.drawable.onboardinglogo1,
            R.drawable.onnboardinglogo2,
            R.drawable.onboardinglogo3
    };

    public String[] slide_headings = {

            "Discover largest NFT marketplace",
            "Start your own NFT gallery now",
            "Discovering the world of crypto art"
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (LinearLayout) o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        TextView txtView_heading = (TextView) view.findViewById(R.id.txtView_heading);
        TextView txtView_heading2 = (TextView) view.findViewById(R.id.txtView_heading2);
        ImageView imgView_onBoarding = (ImageView) view.findViewById(R.id.imgView_onBoarding);

        txtView_heading.setText(slide_headings[position]);
        imgView_onBoarding.setImageResource(slide_images[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((LinearLayout)object);
    }
}
