package com.example.enefte.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.enefte.Fragment.Details;
import com.example.enefte.Fragment.Item_Activity;
import com.example.enefte.Fragment.Listings;
import com.example.enefte.Fragment.Offers;
import com.example.enefte.Fragment.ProfileFragment.Activities;
import com.example.enefte.Fragment.ProfileFragment.Collected;
import com.example.enefte.Fragment.ProfileFragment.Created;
import com.example.enefte.Fragment.ProfileFragment.Favourite;
import com.example.enefte.Fragment.ProfileFragment.OffersMade;
import com.example.enefte.Fragment.ProfileFragment.OffersReceived;

public class ProfileDetailAdapter extends FragmentStateAdapter  {

    public ProfileDetailAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position)
        {
            case 1:
                return new Created();
            case 2:
                return new Activities();
            case 3:
                return new Favourite();
            case 4:
                return new OffersMade();
            case 5:
                return new OffersReceived();

        }

        return new Collected();
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
