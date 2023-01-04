package com.example.enefte.Collections;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.enefte.Adapter.CollectionItemAdapter;
import com.example.enefte.Adapter.NFTItemDetailAdapter;
import com.example.enefte.R;
import com.google.android.material.tabs.TabLayout;

public class MainCollection extends AppCompatActivity {

    private ImageView imgView_collection, imgView_collectionPic, btn_back, btn_share, btn_website, btn_instagram,
            btn_twitter, btn_discord;

    private TextView txtView_collector, txtView_collectorBio, txtView_items, txtView_owners, txtView_floorPrice,
            txtView_volumeTrade ;

    private com.google.android.material.tabs.TabLayout tab_layout;

    private androidx.viewpager2.widget.ViewPager2 view_pager;

    CollectionItemAdapter collectionItemAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_collection);

        initWidget();

        initUI();
    }

    private void initUI() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        collectionItemAdapter = new CollectionItemAdapter(fragmentManager, getLifecycle());
        view_pager.setAdapter(collectionItemAdapter);
        tab_layout.addTab(tab_layout.newTab().setText("Items"));
        tab_layout.addTab(tab_layout.newTab().setText("Activity"));


        tab_layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                view_pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        view_pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tab_layout.selectTab(tab_layout.getTabAt(position));
            }
        });
    }

    private void initWidget() {

        //ImageView
        imgView_collection = findViewById(R.id.imgView_collection);
        imgView_collectionPic = findViewById(R.id.imgView_collectionPic);
        btn_back = findViewById(R.id.btn_back);
        btn_share = findViewById(R.id.btn_share);
        btn_website = findViewById(R.id.btn_website);
        btn_instagram = findViewById(R.id.btn_instagram);
        btn_twitter = findViewById(R.id.btn_twitter);
        btn_discord = findViewById(R.id.btn_discord);

        txtView_collector = findViewById(R.id.txtView_collector);
        txtView_collectorBio = findViewById(R.id.txtView_collectorBio);
        txtView_items = findViewById(R.id.txtView_items);
        txtView_owners = findViewById(R.id.txtView_owners);
        txtView_floorPrice = findViewById(R.id.txtView_floorPrice);
        txtView_volumeTrade = findViewById(R.id.txtView_volumeTrade);

        tab_layout = findViewById(R.id.tab_layout);

        view_pager = findViewById(R.id.view_pager);

    }
}