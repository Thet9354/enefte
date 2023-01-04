package com.example.enefte.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.enefte.Model.CollectionsActivityNft;
import com.example.enefte.Model.FavNft;
import com.example.enefte.R;

import java.util.ArrayList;

public class CollectionsActivityAdapter extends RecyclerView.Adapter<CollectionsActivityAdapter.CardViewHolder>{

    private ArrayList<CollectionsActivityNft> activityNftArrayList;
    private Context mcontext;

    public CollectionsActivityAdapter(ArrayList<CollectionsActivityNft> activityNftArrayList, Context mcontext) {
        this.activityNftArrayList = activityNftArrayList;
        this.mcontext = mcontext;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    private CollectionsActivityAdapter.OnItemClickListener mItemClickListener;

    public void setOnItemClickListener(CollectionsActivityAdapter.OnItemClickListener listener) {
        this.mItemClickListener = listener;
    }

    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mcontext;
    }

    @NonNull
    @Override
    public CollectionsActivityAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View itemView = LayoutInflater.from(context).
                inflate(R.layout.activity_nft_row, parent, false);

        return new CollectionsActivityAdapter.CardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CollectionsActivityAdapter.CardViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
