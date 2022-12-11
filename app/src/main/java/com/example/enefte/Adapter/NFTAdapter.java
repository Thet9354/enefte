package com.example.enefte.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.enefte.DataBase.NftFavDB;
import com.example.enefte.Model.FavNft;
import com.example.enefte.Model.NFTs;
import com.example.enefte.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;

import java.util.ArrayList;

public class NFTAdapter extends RecyclerView.Adapter<NFTAdapter.CardViewHolder>{

    private ArrayList<NFTs> mArrayListNFT;
    private ArrayList<FavNft> mArrayListFavNft;
    private NftFavDB nftFavDB;
    private Context mcontext;

    public NFTAdapter(Context mcontext, ArrayList<FavNft> mArrayListFavNft) {
        this.mArrayListFavNft = mArrayListFavNft;
        this.mcontext = mcontext;
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
    public void onBindViewHolder(@NonNull NFTAdapter.CardViewHolder holder, int position) {

        holder.txtView_nftName.setText(mArrayListFavNft.get(position).getNftName());
        holder.txtView_artist.setText(mArrayListFavNft.get(position).getNftArtist());
        holder.imgView_nft.setImageResource(mArrayListFavNft.get(position).getNftImage());
        holder.imgView_artist.setImageResource(mArrayListFavNft.get(position).getNftArtistImage());
    }

    @Override
    public int getItemCount() {
        return mArrayListFavNft.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        private androidx.cardview.widget.CardView cv_nft;
        private ImageView imgView_nft, imgView_artist;
        private Button btn_favNft;
        private TextView txtView_nftName, txtView_durationLeft, txtView_artist, txtView_nftPrice;

        public CardViewHolder(@NonNull View itemView) {
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

//                    upvotesRefLike.runTransaction(new Transaction.Handler() {
//                        @NonNull
//                        @Override
//                        public Transaction.Result doTransaction(@NonNull final MutableData mutableData) {
//                            try {
//                                Integer currentValue = mutableData.getValue(Integer.class);
//                                if (currentValue == null) {
//                                    mutableData.setValue(1);
//                                } else {
//                                    mutableData.setValue(currentValue - 1);
//                                }
//                            } catch (Exception e) {
//                                throw e;
//                            }
//                            return Transaction.success(mutableData);
//                        }
//
//                        @Override
//                        public void onComplete(@Nullable DatabaseError databaseError, boolean b, @Nullable DataSnapshot dataSnapshot) {
//                            System.out.println("Transaction completed");
//                        }
//                    });
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
