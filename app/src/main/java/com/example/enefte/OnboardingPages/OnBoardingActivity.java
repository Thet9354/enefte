package com.example.enefte.OnboardingPages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.enefte.Adapter.SliderAdapter;
import com.example.enefte.R;
import com.example.enefte.StartScreen_Activity;

import org.w3c.dom.EntityReference;

public class OnBoardingActivity extends AppCompatActivity {

    private LinearLayout parent, mDotLayout;
    private ViewPager viewPager;
    private Button btn_next;

    private TextView[] mDots;

    private SliderAdapter sliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        initWidget();

        initAdapter();

        addDotsIndicator();

        pageDirectories();

    }

    private void pageDirectories() {

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), StartScreen_Activity.class));
            }
        });
    }

    private void addDotsIndicator() {
        mDots = new TextView[3];

        for (int i = 0; i < mDots.length; i++)
        {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.white));

            mDotLayout.addView(mDots[i]);
        }


    }

    private void initAdapter() {

        sliderAdapter = new SliderAdapter(this);

        viewPager.setAdapter(sliderAdapter);
    }

    private void initWidget() {

        mDotLayout = findViewById(R.id.mDotLayout);
        parent = findViewById(R.id.parent);
        viewPager = findViewById(R.id.viewPager);
        btn_next = findViewById(R.id.btn_next);

    }
}