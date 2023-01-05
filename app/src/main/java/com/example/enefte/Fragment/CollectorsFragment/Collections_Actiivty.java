package com.example.enefte.Fragment.CollectorsFragment;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.example.enefte.Adapter.CollectionsActivityAdapter;
import com.example.enefte.Adapter.CollectionsItemAdapter;
import com.example.enefte.Adapter.NFTAdapter;
import com.example.enefte.Fragment.Home;
import com.example.enefte.Model.CollectionsActivityNft;
import com.example.enefte.Model.CollectionsItemNft;
import com.example.enefte.Model.FavNft;
import com.example.enefte.R;

import java.util.ArrayList;

public class Collections_Actiivty extends Fragment {

    private RecyclerView rv_collectionActivity;

    private Context mContext;

    private CollectionsActivityAdapter collectionsActivityAdapter;

    private final ArrayList<CollectionsActivityNft> collectionsActivityNftArrayList = new ArrayList<>();

    int[] nftPics = {R.drawable.uzachi_3330, R.drawable.torao_4345, R.drawable.torao_4345};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_collections__actiivty, container, false);

        mContext = getActivity();

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews(view);
    }

    private void findViews(View v) {

        //RecyclerView
        rv_collectionActivity = v.findViewById(R.id.rv_collectionActivity);

        initUI();
    }

    private void initUI() {

        //Init RecyclerView
        //for better performance of recyclerview.

        rv_collectionActivity.setHasFixedSize(true);

        collectionsActivityAdapter = new CollectionsActivityAdapter(getContext(), collectionsActivityNftArrayList);
        rv_collectionActivity.setAdapter(collectionsActivityAdapter);

        //layout to contain recyclerview
        LinearLayoutManager llm = new LinearLayoutManager(mContext);
        llm.setSmoothScrollbarEnabled(true);
        // orientation of linearlayoutmanager.
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        llm.setAutoMeasureEnabled(true);

        //set layoutmanager for recyclerview.
        rv_collectionActivity.setLayoutManager(llm);

        new LoadActivityNFT().execute();
    }

    CollectionsActivityNft collectionsActivityNft;

    class LoadActivityNFT extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected String doInBackground(String... args) {
            try {

                String[] nftName = getResources().getStringArray(R.array.nft_name);
                String[] nftArtist = getResources().getStringArray(R.array.nft_artist);
                String[] nftStatus = getResources().getStringArray(R.array.Collection_Items_Activity_Status);
                String[] nftPrice = getResources().getStringArray(R.array.Collection_Items_Activity_NftPrice);
                String[] nftDuration = getResources().getStringArray(R.array.Collection_Items_Activity_Duration);
                String[] nftUsdPrice = getResources().getStringArray(R.array.Collection_Items_Activity_UsdPrice);
                String[] nftQuantity = getResources().getStringArray(R.array.Collection_Items_Activity_quantity);
                String[] nftFrom = getResources().getStringArray(R.array.Collection_Items_Activity_from);
                String[] nftTo = getResources().getStringArray(R.array.Collection_Items_Activity_to);



                for (int i = 0 ; i < nftName.length; i++)
                {
                    collectionsActivityNft = new CollectionsActivityNft();
//                    favNft.setNftID(i);

                    collectionsActivityNft.setNftArtist(nftArtist[i]);
                    collectionsActivityNft.setNftName(nftName[i]);
                    collectionsActivityNft.setNftStatus(nftStatus[i]);
                    collectionsActivityNft.setNftPrice(nftPrice[i]);
                    collectionsActivityNft.setNftUSDPrice(nftUsdPrice[i]);
                    collectionsActivityNft.setNftDuration(nftDuration[i]);
                    collectionsActivityNft.setNftQuantity(nftQuantity[i]);
                    collectionsActivityNft.setNftFrom(nftFrom[i]);
                    collectionsActivityNft.setNftTo(nftTo[i]);

                    collectionsActivityNft.setNftImage(nftPics[i]);


                    collectionsActivityNftArrayList.add(collectionsActivityNft);
                    collectionsActivityNft = null;
                }


            } catch (Exception e) {
                e.printStackTrace();

            }

            return null;
        }

        protected void onPostExecute(String file_url) {

//            pgbPopulardestination.setVisibility(View.GONE);

            if (collectionsActivityNftArrayList != null && collectionsActivityNftArrayList.size() > 0) {
                collectionsActivityAdapter = new CollectionsActivityAdapter(mContext, collectionsActivityNftArrayList);
                rv_collectionActivity.setAdapter(collectionsActivityAdapter);
                collectionsActivityAdapter.notifyDataSetChanged();
            }
        }
    }
}