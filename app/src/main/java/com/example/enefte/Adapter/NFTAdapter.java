package com.example.enefte.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.enefte.DataBase.NftFavDB;
import com.example.enefte.Model.FavNft;
import com.example.enefte.Model.NFTs;
import com.example.enefte.NFT_Item_Activity;
import com.example.enefte.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;

import java.util.ArrayList;

public class NFTAdapter extends RecyclerView.Adapter<NFTAdapter.CardViewHolder>{

    private ArrayList<NFTs> mArrayListNFT;
    private final ArrayList<FavNft> mArrayListFavNft;
    private NftFavDB nftFavDB;
    private Context mcontext;

    public NFTAdapter(Context mcontext, ArrayList<FavNft> mArrayListFavNft) {
        this.mcontext = mcontext;
        this.mArrayListFavNft = mArrayListFavNft;

    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    private NFTAdapter.OnItemClickListener mItemClickListener;

    public void setOnItemClickListener(NFTAdapter.OnItemClickListener listener) {
        this.mItemClickListener = listener;
    }

    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mcontext;
    }

    @NonNull
    @Override
    public NFTAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View itemView = LayoutInflater.from(context).
                inflate(R.layout.row_nft, parent, false);

        return new NFTAdapter.CardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {

        holder.txtView_nftName.setText(mArrayListFavNft.get(position).getNftName());
        holder.txtView_artist.setText(mArrayListFavNft.get(position).getNftArtist());
        holder.imgView_nft.setImageResource(mArrayListFavNft.get(position).getNftImage());
        holder.imgView_artist.setImageResource(mArrayListFavNft.get(position).getNftArtistImage());

        holder.cv_nft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mcontext, NFT_Item_Activity.class);
                int pos = holder.getAdapterPosition();
                i.putExtra("NFT Name", mArrayListFavNft.get(pos).getNftName());
                i.putExtra("NFT Artist", mArrayListFavNft.get(pos).getNftArtist());
                i.putExtra("NFT ID", mArrayListFavNft.get(pos).getNftID());

                System.out.println(mArrayListFavNft.get(pos).getNftName());
                System.out.println(mArrayListFavNft.get(pos).getNftArtist());
                System.out.println(mArrayListFavNft.get(pos).getNftID());

                mcontext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mArrayListFavNft.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        private final CardView cv_nft;
        private final ImageView imgView_nft;
        private final ImageView imgView_artist;
        private final Button btn_favNft;
        private final TextView txtView_nftName;
        private final TextView txtView_durationLeft;
        private final TextView txtView_artist;
        private final TextView txtView_nftPrice;

        public CardViewHolder(View itemView) {
            super(itemView);

            //CardView
            cv_nft = itemView.findViewById(R.id.cv_nft);

            //Button
            btn_favNft = itemView.findViewById(R.id.btn_favNft);

            //ImageView
            imgView_nft = itemView.findViewById(R.id.imgView_nft);

            //TextView
            txtView_nftName = itemView.findViewById(R.id.txtView_nftName);
            txtView_durationLeft = itemView.findViewById(R.id.txtView_durationLeft);
            imgView_artist = itemView.findViewById(R.id.imgView_artist);
            txtView_artist = itemView.findViewById(R.id.txtView_artist);
            txtView_nftPrice = itemView.findViewById(R.id.txtView_nftPrice);

            //remove from fav after click
            btn_favNft.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    final FavNft favNft = mArrayListFavNft.get(position);
//                    final DatabaseReference upvotesRefLike = refLike.child(favItemList.get(position).getKey_id());
                    nftFavDB.remove_fav(favNft.getNftID());
                    removeItem(position);

                }
            });

        }
    }

    private void removeItem(int position) {
        mArrayListFavNft.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,mArrayListFavNft.size());
    }
}
