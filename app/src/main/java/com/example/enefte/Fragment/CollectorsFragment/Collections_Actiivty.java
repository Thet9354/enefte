package com.example.enefte.Fragment.CollectorsFragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.example.enefte.Adapter.CollectionsItemAdapter;
import com.example.enefte.Model.CollectionsItemNft;
import com.example.enefte.R;

import java.util.ArrayList;

public class Collections_Actiivty extends Fragment {

    private RecyclerView rv_collectionActivity;

    private Context mContext;

    private CollectionsActivityAdapter collectionsActivityAdapter;

    private final ArrayList<CollectionsActivityNft> collectionsActivityNftArrayList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_collections__actiivty, container, false);

        mContext = getActivity();

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Inflate the layout for this fragment
        return rootView;
    }
}