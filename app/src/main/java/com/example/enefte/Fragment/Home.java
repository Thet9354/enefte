package com.example.enefte.Fragment;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.enefte.Adapter.CollectorAdapter;
import com.example.enefte.Adapter.NFTAdapter;
import com.example.enefte.Model.FavNft;
import com.example.enefte.Model.NFTCollector;
import com.example.enefte.R;

import java.util.ArrayList;


public class Home extends Fragment {

    private TextView txtView_ethereumBalance;
    private ImageView imgView_profile;
    private androidx.recyclerview.widget.RecyclerView rv_nftMarketPlace, rv_trendingCollector;

    private NFTAdapter nftAdapter;
    private CollectorAdapter collectorAdapter;

    private final ArrayList<FavNft> favNftArrayList = new ArrayList<>();
    private final ArrayList<NFTCollector> nftCollectorArrayList = new ArrayList<>();

    int[] nftPics = {R.drawable.mosu_nft, R.drawable.clonex_1172, R.drawable.samurai_kid, R.drawable.legend_of_cockpunch,
    R.drawable.valhalla_1724, R.drawable.mindblown_by_lsd_219, R.drawable.cyber_thug_216};

    int[] nftArtistPic = {R.drawable.karafuru, R.drawable.rtfktlonextm, R.drawable.roselia, R.drawable.cockpunch,
            R.drawable.stackedstudio, R.drawable.mindblown, R.drawable.disruptor};

    int[] collectorPic = {R.drawable.ghozali_everyday, R.drawable.cryptopunk, R.drawable.skull, R.drawable.shikibuworld,
    R.drawable.beanzofficials, R.drawable.rektguy, R.drawable.metabatch};

    private Context mContext;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        // Inflate the layout for this fragment
        return rootView;
    }

    private void initUI() {

        //------------rvpopular destination----------
        //for better performance of recyclerview.

        rv_nftMarketPlace.setHasFixedSize(true);

        nftAdapter = new NFTAdapter(getContext(), favNftArrayList);
        rv_nftMarketPlace.setAdapter(nftAdapter);

        //layout to contain recyclerview
        LinearLayoutManager llm = new LinearLayoutManager(mContext);
        llm.setSmoothScrollbarEnabled(true);
        // orientation of linearlayoutmanager.
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        llm.setAutoMeasureEnabled(true);

        //set layoutmanager for recyclerview.
        rv_nftMarketPlace.setLayoutManager(llm);

        new LoadAllPopularDestination().execute();



        //------------rvpopular trendingCollector----------
        //for better performance of recyclerview.

        rv_trendingCollector.setHasFixedSize(true);

        collectorAdapter = new CollectorAdapter(getContext(), nftCollectorArrayList);
        rv_trendingCollector.setAdapter(collectorAdapter);

        //layout to contain recyclerview
        LinearLayoutManager llml = new LinearLayoutManager(mContext);
        llml.setSmoothScrollbarEnabled(true);
        // orientation of linearlayoutmanager.
        llml.setOrientation(LinearLayoutManager.VERTICAL);
        llml.setAutoMeasureEnabled(true);

        //set layoutmanager for recyclerview.
        rv_trendingCollector.setLayoutManager(llml);

        new LoadAllTrendingCollector().execute();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews(view);
    }

    private void findViews(View v) {

        //TextView
        txtView_ethereumBalance = v.findViewById(R.id.txtView_ethereumBalance);

        //Imageview
        imgView_profile = v.findViewById(R.id.imgView_profile);

        //RecyclerView
        rv_nftMarketPlace = v.findViewById(R.id.rv_nftMarketPlace);
        rv_trendingCollector = v.findViewById(R.id.rv_trendingCollector);

        initUI();
    }

    FavNft favNft;
    NFTCollector nftCollector;

    class LoadAllPopularDestination extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected String doInBackground(String... args) {
            try {

                String[] nftName = getResources().getStringArray(R.array.nft_name);
                String[] nftArtist = getResources().getStringArray(R.array.nft_artist);

                for (int i = 0 ; i < nftName.length; i++)
                {
                    favNft = new FavNft();
//                    favNft.setNftID(i);
                    favNft.setNftImage(nftPics[i]);
//                    favNft.setNftCategory(destinationID[i]);
                    favNft.setNftName(nftName[i]);
                    favNft.setNftArtist(nftArtist[i]);
                    favNft.setNftArtistImage(nftArtistPic[i]);
                    favNftArrayList.add(favNft);
                    favNft = null;
                }


            } catch (Exception e) {
                e.printStackTrace();

            }

            return null;
        }

        protected void onPostExecute(String file_url) {

//            pgbPopulardestination.setVisibility(View.GONE);

            if (favNftArrayList != null && favNftArrayList.size() > 0) {
                nftAdapter = new NFTAdapter(mContext, favNftArrayList);
                rv_nftMarketPlace.setAdapter(nftAdapter);
                nftAdapter.notifyDataSetChanged();
            }
        }
    }

    class LoadAllTrendingCollector extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected String doInBackground(String... args) {
            try {

                String[] collectorName = getResources().getStringArray(R.array.trending_collector_name);
                String[] collectorUserName = getResources().getStringArray(R.array.trending_collector_username);
                String[] collectorBalance = getResources().getStringArray(R.array.trending_collector_ethereum);
                String[] collectorProfit = getResources().getStringArray(R.array.trending_collector_profit);


                for (int i = 0 ; i < collectorName.length; i++)
                {
                    nftCollector = new NFTCollector();
                    nftCollector.setCollectorImage(collectorPic[i]);
                    nftCollector.setCollectorName(collectorName[i]);
                    nftCollector.setCollectorUserName(collectorUserName[i]);
                    nftCollector.setEthereumBalance(collectorBalance[i]);
                    nftCollector.setEthereumChange(collectorProfit[i]);
                    nftCollectorArrayList.add(nftCollector);
                    nftCollector = null;
                }


            } catch (Exception e) {
                e.printStackTrace();

            }

            return null;
        }

        protected void onPostExecute(String file_url) {

//            pgbPopulardestination.setVisibility(View.GONE);

            if (favNftArrayList != null && favNftArrayList.size() > 0) {
                nftAdapter = new NFTAdapter(mContext, favNftArrayList);
                rv_nftMarketPlace.setAdapter(nftAdapter);
                nftAdapter.notifyDataSetChanged();
            }
        }
    }
}