package com.example.enefte.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.enefte.Model.BidHistory;
import com.example.enefte.Model.FavNft;
import com.example.enefte.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class BidHistoryAdapter extends RecyclerView.Adapter<BidHistoryAdapter.CardViewHolder>{

    private ArrayList<BidHistory> maArrayListBidHistory;
    private Context mcontext;

    public BidHistoryAdapter(Context mcontext, ArrayList<BidHistory> maArrayListBidHistory) {
        this.maArrayListBidHistory = maArrayListBidHistory;
        this.mcontext = mcontext;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    private BidHistoryAdapter.OnItemClickListener mItemClickListener;

    public void setOnItemClickListener(BidHistoryAdapter.OnItemClickListener listener) {
        this.mItemClickListener = listener;
    }

    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mcontext;
    }

    @NonNull
    @Override
    public BidHistoryAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View itemView = LayoutInflater.from(context).
                inflate(R.layout.row_bidhistory, parent, false);

        return new BidHistoryAdapter.CardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BidHistoryAdapter.CardViewHolder holder, int position) {

        holder.txtView_accName.setText(maArrayListBidHistory.get(position).getAccName());
        holder.txtView_nftPrice.setText(maArrayListBidHistory.get(position).getBidEthPrice());
        holder.txtView_duration.setText(maArrayListBidHistory.get(position).getDuration());
        holder.txtView_USDPrice.setText(maArrayListBidHistory.get(position).getBidUsdPrice());
        holder.txtView_floorDiff.setText(maArrayListBidHistory.get(position).getFloorDiff());
        holder.txtView_expiration.setText(maArrayListBidHistory.get(position).getExpiration());

        holder.imgView_acc.setImageResource(maArrayListBidHistory.get(position).getBidAccImage());


    }

    @Override
    public int getItemCount() {
        return maArrayListBidHistory.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        private CardView cv_bidHistory;
        private ImageView imgView_acc;
        private TextView txtView_accName, txtView_nftPrice, txtView_duration, txtView_USDPrice,
                txtView_floorDiff, txtView_expiration;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            //CardView
            cv_bidHistory = itemView.findViewById(R.id.cv_bidHistory);

            //ImageView
            imgView_acc = itemView.findViewById(R.id.imgView_acc);

            //TextView
            txtView_accName = itemView.findViewById(R.id.txtView_accName);
            txtView_nftPrice = itemView.findViewById(R.id.txtView_nftPrice);
            txtView_duration = itemView.findViewById(R.id.txtView_duration);
            txtView_USDPrice = itemView.findViewById(R.id.txtView_USDPrice);
            txtView_floorDiff = itemView.findViewById(R.id.txtView_floorDiff);
            txtView_expiration = itemView.findViewById(R.id.txtView_expiration);

        }
    }
}
