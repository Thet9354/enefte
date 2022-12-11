package com.example.enefte.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.enefte.Collectors_Item_Activity;
import com.example.enefte.Model.NFTCollector;
import com.example.enefte.R;

import java.util.ArrayList;

public class CollectorAdapter extends RecyclerView.Adapter<CollectorAdapter.CardViewHolder>{

    private final ArrayList<NFTCollector> nftCollectorArrayList;

    private final Context mcontext;

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

        holder.cv_trendingCollector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext, Collectors_Item_Activity.class);
                int pos = holder.getAdapterPosition();
                intent.putExtra("Collector Name", nftCollectorArrayList.get(pos).getCollectorName());
                intent.putExtra("Collector Username", nftCollectorArrayList.get(pos).getCollectorUserName());
                intent.putExtra("Collector Balance", nftCollectorArrayList.get(pos).getEthereumBalance());
                intent.putExtra("Collector Profit", nftCollectorArrayList.get(pos).getEthereumChange());

                System.out.println(nftCollectorArrayList.get(pos).getCollectorName());
                System.out.println(nftCollectorArrayList.get(pos).getCollectorUserName());
                System.out.println(nftCollectorArrayList.get(pos).getEthereumBalance());
                System.out.println(nftCollectorArrayList.get(pos).getEthereumChange());

                mcontext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return nftCollectorArrayList.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        private final androidx.cardview.widget.CardView cv_trendingCollector;

        private final ImageView imgView_trendingCollector;

        private final TextView txtView_collectorName;
        private final TextView txtView_collectorUserName;
        private final TextView txtView_collectorBalance;
        private final TextView txtView_profit;

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
