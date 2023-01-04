package com.example.enefte.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.enefte.Model.CollectionsItemNft;
import com.example.enefte.Model.FavNft;
import com.example.enefte.R;

import java.util.ArrayList;

public class CollectionsItemAdapter extends RecyclerView.Adapter<CollectionsItemAdapter.CardViewHolder> {

    private ArrayList<CollectionsItemNft> collectionsItemNftArrayList;
    private Context mcontext;

    public CollectionsItemAdapter(Context mcontext, ArrayList<CollectionsItemNft> collectionsItemNftArrayList) {
        this.collectionsItemNftArrayList = collectionsItemNftArrayList;
        this.mcontext = mcontext;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    private CollectionsItemAdapter.OnItemClickListener mItemClickListener;

    public void setOnItemClickListener(CollectionsItemAdapter.OnItemClickListener listener) {
        this.mItemClickListener = listener;
    }

    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mcontext;
    }

    @NonNull
    @Override
    public CollectionsItemAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View itemView = LayoutInflater.from(context).
                inflate(R.layout.row_items, parent, false);

        return new CollectionsItemAdapter.CardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CollectionsItemAdapter.CardViewHolder holder, int position) {

        holder.txtView_nftName.setText(collectionsItemNftArrayList.get(position).getNftName());
        holder.txtView_artist.setText(collectionsItemNftArrayList.get(position).getNftArtist());
        holder.imgView_nft.setImageResource(collectionsItemNftArrayList.get(position).getNftImage());

    }

    @Override
    public int getItemCount() {
        return collectionsItemNftArrayList.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        private CardView cv_nft;
        private ImageView imgView_nft;
        private ImageView imgView_artist;
        private Button btn_favNft;
        private TextView txtView_nftName;
        private TextView txtView_artist;
        private TextView txtView_nftPrice;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            cv_nft = itemView.findViewById(R.id.cv_nft);

            imgView_nft = itemView.findViewById(R.id.imgView_nft);
            imgView_artist = itemView.findViewById(R.id.imgView_artist);

            btn_favNft = itemView.findViewById(R.id.btn_favNft);

            txtView_nftName = itemView.findViewById(R.id.txtView_nftName);
            txtView_artist = itemView.findViewById(R.id.txtView_artist);
            txtView_nftPrice = itemView.findViewById(R.id.txtView_nftPrice);

        }
    }
}
