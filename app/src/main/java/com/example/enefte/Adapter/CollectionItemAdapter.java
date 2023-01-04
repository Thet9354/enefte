package com.example.enefte.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.enefte.Fragment.CollectorsFragment.Collections_Actiivty;
import com.example.enefte.Fragment.CollectorsFragment.Collections_Item;

public class CollectionItemAdapter extends FragmentStateAdapter  {

    public CollectionItemAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position)
        {
            case 1:
                return new Collections_Actiivty();

        }

        return new Collections_Item();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
