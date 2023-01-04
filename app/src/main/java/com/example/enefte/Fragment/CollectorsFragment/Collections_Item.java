package com.example.enefte.Fragment.CollectorsFragment;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.example.enefte.Adapter.CollectionsItemAdapter;
import com.example.enefte.Adapter.NFTAdapter;
import com.example.enefte.Fragment.Home;
import com.example.enefte.Model.CollectionsItemNft;
import com.example.enefte.Model.FavNft;
import com.example.enefte.Model.NFTCollector;
import com.example.enefte.MySpansizeLookup;
import com.example.enefte.R;

import java.util.ArrayList;

public class Collections_Item extends Fragment {

    private androidx.recyclerview.widget.RecyclerView rv_collectionItems;

    private Context mContext;

    private CollectionsItemAdapter collectionsItemAdapter;

    private final ArrayList<CollectionsItemNft> collectionsItemNftArrayList = new ArrayList<>();

    int[] nftPics = {R.drawable.mosu_nft, R.drawable.clonex_1172, R.drawable.samurai_kid, R.drawable.legend_of_cockpunch,
            R.drawable.valhalla_1724, R.drawable.mindblown_by_lsd_219, R.drawable.cyber_thug_216};



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_collections__item, container, false);

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

        rv_collectionItems = v.findViewById(R.id.rv_collectionItems);

        initUI();
    }

    private void initUI() {

        //Init RecyclerView
        //for better performance of recyclerview.

        rv_collectionItems.setHasFixedSize(true);

        collectionsItemAdapter = new CollectionsItemAdapter(getContext(), collectionsItemNftArrayList);
        rv_collectionItems.setAdapter(collectionsItemAdapter);

        //layout to contain recyclerview
        GridLayoutManager llm = new GridLayoutManager(mContext, 2);
        llm.setSmoothScrollbarEnabled(true);
//        llm.setSpanSizeLookup(new MySpansizeLookup(5,1,2));
        // orientation of linearlayoutmanager.
//        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        llm.setAutoMeasureEnabled(true);

        //set layoutmanager for recyclerview.
        rv_collectionItems.setLayoutManager(llm);

        new LoadCollectionsItem().execute();
    }

    CollectionsItemNft collectionsItemNft;

    class LoadCollectionsItem extends AsyncTask<String, String, String> {

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
                    collectionsItemNft = new CollectionsItemNft();
//                    favNft.setNftID(i);
                    collectionsItemNft.setNftImage(nftPics[i]);
//                    favNft.setNftCategory(destinationID[i]);
                    collectionsItemNft.setNftName(nftName[i]);
                    collectionsItemNft.setNftArtist(nftArtist[i]);
                    collectionsItemNftArrayList.add(collectionsItemNft);
                    collectionsItemNft = null;
                }


            } catch (Exception e) {
                e.printStackTrace();

            }

            return null;
        }

        protected void onPostExecute(String file_url) {

//            pgbPopulardestination.setVisibility(View.GONE);

            if (collectionsItemNftArrayList != null && collectionsItemNftArrayList.size() > 0) {
                collectionsItemAdapter = new CollectionsItemAdapter(mContext, collectionsItemNftArrayList);
                rv_collectionItems.setAdapter(collectionsItemAdapter);
                collectionsItemAdapter.notifyDataSetChanged();
            }
        }
    }



}