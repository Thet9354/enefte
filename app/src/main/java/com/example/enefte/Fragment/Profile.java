package com.example.enefte.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.enefte.Adapter.NFTItemDetailAdapter;
import com.example.enefte.Adapter.ProfileDetailAdapter;
import com.example.enefte.EditProfile_Activity;
import com.example.enefte.R;
import com.google.android.material.tabs.TabLayout;


public class Profile extends Fragment {

    private ImageView imgView_profileBg, imgView_myProfile, btn_back, btn_share, btn_copy, btn_website, btn_instagram, btn_twitter;

    private TextView txtView_walletAddress, txtView_items_total, txtView_views, txtView_liked;

    private RelativeLayout rel_editProfile;

    private Context mContext;

    private com.google.android.material.tabs.TabLayout tab_layout;

    private androidx.viewpager2.widget.ViewPager2 view_pager;

    private ProfileDetailAdapter profileDetailAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        mContext = getActivity();

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews(view);
    }

    private void findViews(View v) {

        //ImageView
        imgView_profileBg = v.findViewById(R.id.imgView_profileBg);
        imgView_myProfile = v.findViewById(R.id.imgView_myProfile);
        btn_back = v.findViewById(R.id.btn_back);
        btn_share = v.findViewById(R.id.btn_share);
        btn_copy = v.findViewById(R.id.btn_copy);
        btn_website = v.findViewById(R.id.btn_website);
        btn_instagram = v.findViewById(R.id.btn_instagram);
        btn_twitter = v.findViewById(R.id.btn_twitter);

        //TextView
        txtView_walletAddress = v.findViewById(R.id.txtView_walletAddress);
        txtView_items_total = v.findViewById(R.id.txtView_items_total);
        txtView_views = v.findViewById(R.id.txtView_views);
        txtView_liked = v.findViewById(R.id.txtView_liked);

        //RelativeLayout
        rel_editProfile = v.findViewById(R.id.rel_editProfile);

        //TabLayout
        tab_layout = v.findViewById(R.id.tab_layout);

        //ViewPager
        view_pager = v.findViewById(R.id.view_pager);

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

        btn_website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String url = "https://www.linkedin.com/in/thetpine/";
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(browserIntent);
            }
        });

        btn_instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String url = "https://www.instagram.com/thetpine_/";
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(browserIntent);
            }
        });

        rel_editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, EditProfile_Activity.class);
                startActivity(intent);
            }
        });
    }

    private void initUI() {

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        profileDetailAdapter = new ProfileDetailAdapter(fragmentManager, getLifecycle());
        view_pager.setAdapter(profileDetailAdapter);
        tab_layout.addTab(tab_layout.newTab().setText("Collected"));
        tab_layout.addTab(tab_layout.newTab().setText("Created"));
        tab_layout.addTab(tab_layout.newTab().setText("Activity"));
        tab_layout.addTab(tab_layout.newTab().setText("Favourite"));
        tab_layout.addTab(tab_layout.newTab().setText("Offers Made"));
        tab_layout.addTab(tab_layout.newTab().setText("Offers Received"));


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