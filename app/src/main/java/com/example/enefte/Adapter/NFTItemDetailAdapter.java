package com.example.enefte.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.enefte.Fragment.Details;
import com.example.enefte.Fragment.Item_Activity;
import com.example.enefte.Fragment.Listings;
import com.example.enefte.Fragment.Offers;

import java.util.ArrayList;

public class NFTItemDetailAdapter extends FragmentStateAdapter {


    public NFTItemDetailAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position)
        {
            case 1:
                return new Offers();
            case 2:
                return new Listings();
            case 3:
                return new Item_Activity();

        }

        return new Details();
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
