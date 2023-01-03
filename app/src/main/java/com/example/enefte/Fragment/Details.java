package com.example.enefte.Fragment;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.enefte.Adapter.FYCAdapter;
import com.example.enefte.Adapter.NFTAdapter;
import com.example.enefte.Model.FavNft;
import com.example.enefte.Model.ForYouNFT;
import com.example.enefte.R;

import java.util.ArrayList;


public class Details extends Fragment {

    private TextView txtView_favourite, txtView_owners, txtView_edition;

    private CardView cv_aboutCollection, cv_properties, cv_details, cv_priceHistory;

    private TextView txtView_aboutCollection, txtView_bgColor, txtView_backgroundPercent, txtView_clothes,
            txtView_clothesPercent, txtView_ear, txtView_earPercent, txtView_eye, txtView_eyePercent,
            txtView_face, txtView_facePercent, txtView_hair, txtView_hairPercent;

    private TextView txtView_contractAddress, txtView_tokenID, txtView_tokenStandard, txtView_blockchain;

    private LinearLayout ll_aboutCollection, ll_property, ll_properties, ll_detail, ll_details, ll_price, ll_priceHistory;

    private RecyclerView rv_moreRec;

    private Context mContext;

    private FYCAdapter fycAdapter;
    private final ArrayList<ForYouNFT> forYouNFTArrayList = new ArrayList<>();

    int[] nftPics = {R.drawable.otan_2622, R.drawable.kuyaku_315, R.drawable.kiba_5395};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_details, container, false);
        mContext = getActivity();

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        // Inflate the layout for this fragment
        return rootView;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews(view);
    }

    private void findViews(View v) {

        //TextView
        txtView_favourite = v.findViewById(R.id.txtView_favourite);
        txtView_owners = v.findViewById(R.id.txtView_owners);
        txtView_edition = v.findViewById(R.id.txtView_edition);
        txtView_aboutCollection = v.findViewById(R.id.txtView_aboutCollection);
        txtView_bgColor = v.findViewById(R.id.txtView_bgColor);
        txtView_backgroundPercent = v.findViewById(R.id.txtView_backgroundPercent);
        txtView_clothes = v.findViewById(R.id.txtView_clothes);

        txtView_clothesPercent = v.findViewById(R.id.txtView_clothesPercent);
        txtView_ear = v.findViewById(R.id.txtView_ear);
        txtView_earPercent = v.findViewById(R.id.txtView_earPercent);
        txtView_eye = v.findViewById(R.id.txtView_eye);
        txtView_eyePercent = v.findViewById(R.id.txtView_eyePercent);
        txtView_face = v.findViewById(R.id.txtView_face);
        txtView_facePercent = v.findViewById(R.id.txtView_facePercent);

        txtView_hair = v.findViewById(R.id.txtView_hair);
        txtView_hairPercent = v.findViewById(R.id.txtView_hairPercent);
        txtView_contractAddress = v.findViewById(R.id.txtView_contractAddress);
        txtView_tokenID = v.findViewById(R.id.txtView_tokenID);
        txtView_tokenStandard = v.findViewById(R.id.txtView_tokenStandard);
        txtView_blockchain = v.findViewById(R.id.txtView_blockchain);

        //CardView
        cv_aboutCollection = v.findViewById(R.id.cv_aboutCollection);
        cv_properties = v.findViewById(R.id.cv_properties);
        cv_details = v.findViewById(R.id.cv_details);
        cv_priceHistory = v.findViewById(R.id.cv_priceHistory);

        //LinearLayout
        ll_aboutCollection = v.findViewById(R.id.ll_aboutCollection);
        ll_properties = v.findViewById(R.id.ll_properties);
        ll_details = v.findViewById(R.id.ll_details);
        ll_priceHistory = v.findViewById(R.id.ll_priceHistory);
        ll_property = v.findViewById(R.id.ll_property);
        ll_detail = v.findViewById(R.id.ll_detail);
        ll_price = v.findViewById(R.id.ll_price);

        //RecyclerView
        rv_moreRec = v.findViewById(R.id.rv_moreRec);

        initUI();

        pageDirectories();
    }

    private void pageDirectories() {

        ll_aboutCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expandCollection();

            }
        });

        cv_properties.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expandProperties();
            }
        });

        cv_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expandDetails();
            }
        });

        cv_priceHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expandHistory();
            }
        });


    }

    private void expandHistory() {
        int v1 = (ll_priceHistory.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(ll_detail, new AutoTransition());
        ll_priceHistory.setVisibility(v1);
    }

    private void expandDetails() {

        int v1 = (ll_details.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(ll_detail, new AutoTransition());
        ll_details.setVisibility(v1);
    }

    private void expandProperties() {

        int v1 = (ll_properties.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(ll_property, new AutoTransition());
        ll_properties.setVisibility(v1);
    }

    private void initUI() {

        //Init Recyclerview
        //for better performance of recyclerview.

        rv_moreRec.setHasFixedSize(true);

        fycAdapter = new FYCAdapter(getContext(), forYouNFTArrayList);
        rv_moreRec.setAdapter(fycAdapter);

        //layout to contain recyclerview
        LinearLayoutManager llm = new LinearLayoutManager(mContext);
        llm.setSmoothScrollbarEnabled(true);
        // orientation of linearlayoutmanager.
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        llm.setAutoMeasureEnabled(true);

        //set layoutmanager for recyclerview.
        rv_moreRec.setLayoutManager(llm);

         new LoadForYouNFT().execute();
    }

    ForYouNFT forYouNFT;

    class LoadForYouNFT extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected String doInBackground(String... args) {
            try {

                String[] nftName = getResources().getStringArray(R.array.moreFromThisNFT);

                for (int i = 0 ; i < nftName.length; i++)
                {
                    forYouNFT = new ForYouNFT();
//                    favNft.setNftID(i);
                    forYouNFT.setNftImage(nftPics[i]);
//                    favNft.setNftCategory(destinationID[i]);
                    forYouNFT.setNftName(nftName[i]);
                    forYouNFT.setNftImage(nftPics[i]);
                    forYouNFTArrayList.add(forYouNFT);
                    forYouNFT = null;
                }


            } catch (Exception e) {
                e.printStackTrace();

            }

            return null;
        }

        protected void onPostExecute(String file_url) {

//            pgbPopulardestination.setVisibility(View.GONE);

            if (forYouNFTArrayList != null && forYouNFTArrayList.size() > 0) {
                fycAdapter = new FYCAdapter(mContext, forYouNFTArrayList);
                rv_moreRec.setAdapter(fycAdapter);
                fycAdapter.notifyDataSetChanged();
            }
        }
    }

    private void expandCollection() {

        int v1 = (txtView_aboutCollection.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(ll_aboutCollection, new AutoTransition());
        txtView_aboutCollection.setVisibility(v1);
    }


}