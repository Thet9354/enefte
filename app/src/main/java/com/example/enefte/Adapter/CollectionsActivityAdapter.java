package com.example.enefte.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.enefte.Model.CollectionsActivityNft;
import com.example.enefte.Model.FavNft;
import com.example.enefte.R;

import java.util.ArrayList;

public class CollectionsActivityAdapter extends RecyclerView.Adapter<CollectionsActivityAdapter.CardViewHolder>{

    private ArrayList<CollectionsActivityNft> activityNftArrayList;
    private Context mcontext;

    public CollectionsActivityAdapter(Context mcontext, ArrayList<CollectionsActivityNft> activityNftArrayList) {
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

        holder.txtView_artist.setText(activityNftArrayList.get(position).getNftArtist());
        holder.txtView_nftName.setText(activityNftArrayList.get(position).getNftName());
        holder.txtView_nftStatus.setText(activityNftArrayList.get(position).getNftStatus());
        holder.txtView_nftPrice.setText(activityNftArrayList.get(position).getNftPrice());
        holder.txtView_duration.setText(activityNftArrayList.get(position).getNftDuration());
        holder.txtView_USDPrice.setText(activityNftArrayList.get(position).getNftUSDPrice());
        holder.txtView_quantity.setText(activityNftArrayList.get(position).getNftQuantity());
        holder.txtView_from.setText(activityNftArrayList.get(position).getNftFrom());
        holder.txtView_to.setText(activityNftArrayList.get(position).getNftTo());

        holder.imgView_nft.setImageResource(activityNftArrayList.get(position).getNftImage());

        String status = holder.txtView_nftStatus.getText().toString();



        if (status.equals("Sale"))
            holder.txtView_nftStatus.setTextColor(Color.parseColor("#00CB6A"));
        else
            holder.txtView_nftStatus.setTextColor(Color.parseColor("#FF7979"));




    }

    @Override
    public int getItemCount() {
        return activityNftArrayList.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        private androidx.cardview.widget.CardView cv_nft;
        private ImageView imgView_nft;
        private TextView txtView_artist, txtView_nftName, txtView_nftStatus, txtView_nftPrice, txtView_duration,
                txtView_USDPrice, txtView_quantity, txtView_from, txtView_to;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            cv_nft = itemView.findViewById(R.id.cv_nft);

            imgView_nft = itemView.findViewById(R.id.imgView_nft);

            txtView_artist = itemView.findViewById(R.id.txtView_artist);
            txtView_nftName = itemView.findViewById(R.id.txtView_nftName);
            txtView_nftStatus = itemView.findViewById(R.id.txtView_nftStatus);
            txtView_nftPrice = itemView.findViewById(R.id.txtView_nftPrice);
            txtView_duration = itemView.findViewById(R.id.txtView_duration);
            txtView_USDPrice = itemView.findViewById(R.id.txtView_USDPrice);
            txtView_quantity = itemView.findViewById(R.id.txtView_quantity);
            txtView_from = itemView.findViewById(R.id.txtView_from);
            txtView_to = itemView.findViewById(R.id.txtView_to);

        }
    }
}
