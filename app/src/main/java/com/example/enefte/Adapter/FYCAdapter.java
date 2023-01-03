package com.example.enefte.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.enefte.Model.ForYouNFT;
import com.example.enefte.Model.NFTs;
import com.example.enefte.R;

import java.util.ArrayList;

public class FYCAdapter extends RecyclerView.Adapter<FYCAdapter.CardViewHolder>{

    private ArrayList<ForYouNFT> forYouNFTArrayList;
    private Context mcontext;

    public FYCAdapter(Context mcontext, ArrayList<ForYouNFT> forYouNFTArrayList) {
        this.forYouNFTArrayList = forYouNFTArrayList;
        this.mcontext = mcontext;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    private FYCAdapter.OnItemClickListener mItemClickListener;

    public void setOnItemClickListener(FYCAdapter.OnItemClickListener listener) {
        this.mItemClickListener = listener;
    }

    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mcontext;
    }

    @NonNull
    @Override
    public FYCAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View itemView = LayoutInflater.from(context).
                inflate(R.layout.row_fyc, parent, false);

        return new FYCAdapter.CardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FYCAdapter.CardViewHolder holder, int position) {

        holder.txtView_artist.setText(forYouNFTArrayList.get(position).getNftArtist());
//        holder.txtView_nftName.setText(forYouNFTArrayList.get(position).getNftName());
        holder.imgView_nft.setImageResource(forYouNFTArrayList.get(position).getNftImage());
    }

    @Override
    public int getItemCount() {
        return forYouNFTArrayList.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        private androidx.cardview.widget.CardView cv_nft;
        private ImageView imgView_nft;
        private TextView txtView_artist, txtView_nftName;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            cv_nft = itemView.findViewById(R.id.cv_nft);
            imgView_nft = itemView.findViewById(R.id.imgView_nft);
            txtView_artist = itemView.findViewById(R.id.txtView_artist);
            txtView_nftName = itemView.findViewById(R.id.txtView_nftName);
        }
    }
}
