package com.example.enefte;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.widget.ImageView;

import com.example.enefte.Adapter.NFTItemDetailAdapter;
import com.example.enefte.Fragment.Details;
import com.example.enefte.Fragment.Item_Activity;
import com.example.enefte.Fragment.Listings;
import com.example.enefte.Fragment.Offers;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class NFT_Item_Details_Activity extends AppCompatActivity {

    private ImageView btn_back, imgView_nft, btn_share, btn_detail;

    private TabLayout tab_layout;

    private ViewPager2 view_pager;

    NFTItemDetailAdapter nftItemDetailAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nft_item_details);

        initWidget();

        initUI();

        pageDirectories();
    }

    private void pageDirectories() {

        btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Check out this cool ass NFT");
                intent.putExtra(Intent.EXTRA_TEXT, "Your application link here");
                startActivity(Intent.createChooser(intent, "Share Via"));

            }
        });

        imgView_nft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void initWidget() {

        //ImageView
        btn_back = findViewById(R.id.btn_back);
        imgView_nft = findViewById(R.id.imgView_nft);
        btn_share = findViewById(R.id.btn_share);
        btn_detail = findViewById(R.id.btn_detail);

        //TabLayout
        tab_layout = findViewById(R.id.tab_layout);

        //ViewPager
        view_pager = findViewById(R.id.view_pager);

    }

    private void initUI() {

        FragmentManager fragmentManager = getSupportFragmentManager();
        nftItemDetailAdapter = new NFTItemDetailAdapter(fragmentManager, getLifecycle());
        view_pager.setAdapter(nftItemDetailAdapter);
        tab_layout.addTab(tab_layout.newTab().setText("Details"));
        tab_layout.addTab(tab_layout.newTab().setText("Offers"));
        tab_layout.addTab(tab_layout.newTab().setText("Listings"));
        tab_layout.addTab(tab_layout.newTab().setText("Item Activity"));

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

}