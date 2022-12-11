package com.example.enefte.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.enefte.Model.NFTCollector;
import com.example.enefte.R;

import java.util.ArrayList;

public class CollectorAdapter extends RecyclerView.Adapter<CollectorAdapter.CardViewHolder>{

    private ArrayList<NFTCollector> nftCollectorArrayList;

    private Context mcontext;

    public CollectorAdapter(Context mcontext, ArrayList<NFTCollector> nftCollectorArrayList) {
        this.nftCollectorArrayList = nftCollectorArrayList;
        this.mcontext = mcontext;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    private CollectorAdapter.OnItemClickListener mItemClickListener;

    public void setOnItemClickListener(CollectorAdapter.OnItemClickListener listener) {
        this.mItemClickListener = listener;
    }

    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mcontext;
    }

    @NonNull
    @Override
    public CollectorAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View itemView = LayoutInflater.from(context).
                inflate(R.layout.row_collector, parent, false);

        return new CollectorAdapter.CardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CollectorAdapter.CardViewHolder holder, int position) {

        holder.imgView_trendingCollector.setImageResource(nftCollectorArrayList.get(position).getCollectorImage());
        holder.txtView_collectorBalance.setText(nftCollectorArrayList.get(position).getEthereumBalance());
        holder.txtView_collectorName.setText(nftCollectorArrayList.get(position).getCollectorName());
        holder.txtView_collectorUserName.setText(nftCollectorArrayList.get(position).getCollectorUserName());
        holder.txtView_profit.setText(nftCollectorArrayList.get(position).getEthereumChange());



    }

    @Override
    public int getItemCount() {
        return nftCollectorArrayList.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        private androidx.cardview.widget.CardView cv_trendingCollector;

        private ImageView imgView_trendingCollector;

        private TextView txtView_collectorName, txtView_collectorUserName, txtView_collectorBalance, txtView_profit;

        public CardViewHolder(@NonNull View v) {
            super(v);

            //CardView
            cv_trendingCollector = v.findViewById(R.id.cv_trendingCollector);

            //ImageView
            imgView_trendingCollector = v.findViewById(R.id.imgView_trendingCollector);

            //TextView
            txtView_collectorName = v.findViewById(R.id.txtView_collectorName);
            txtView_collectorUserName = v.findViewById(R.id.txtView_collectorUserName);
            txtView_collectorBalance = v.findViewById(R.id.txtView_collectorBalance);
            txtView_profit = v.findViewById(R.id.txtView_profit);

        }
    }
}
