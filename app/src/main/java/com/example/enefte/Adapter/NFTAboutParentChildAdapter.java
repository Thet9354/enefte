package com.example.enefte.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.example.enefte.R;

import java.util.List;

public class NFTAboutParentChildAdapter extends ExpandableRecyclerAdapter<NFTAboutTitleParentViewHolder, NFTAboutTitleChildViewHolder> {

    LayoutInflater inflater;


    public NFTAboutParentChildAdapter(Context context, List<ParentObject> parentItemList) {
        super(context, parentItemList);
        inflater = LayoutInflater.from(context);
//        this.mArrayListSelectedFlight = mArrayListSelectedFlight;
    }

    @Override
    public NFTAboutTitleParentViewHolder onCreateParentViewHolder(ViewGroup viewGroup) {
        View view = inflater.inflate(R.layout.row_aboutcollection, viewGroup, false);
        //TODO: Work on the xml layout
        return new NFTAboutTitleParentViewHolder(view);
    }

    @Override
    public NFTAboutTitleChildViewHolder onCreateChildViewHolder(ViewGroup viewGroup) {
        View view = inflater.inflate(R.layout.activity_childnftabout, viewGroup, false);
        //TODO: Work on the xml layout
        return new NFTAboutTitleChildViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(NFTAboutTitleParentViewHolder nftAboutTitleParentViewHolder, int i, Object o) {

    }

    @Override
    public void onBindChildViewHolder(NFTAboutTitleChildViewHolder nftAboutTitleChildViewHolder, int i, Object o) {

    }
}
