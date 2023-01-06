package com.example.enefte;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.enefte.Adapter.BidHistoryAdapter;
import com.example.enefte.Adapter.FYCAdapter;
import com.example.enefte.Fragment.Details;
import com.example.enefte.Model.BidHistory;
import com.example.enefte.Model.ForYouNFT;

import java.util.ArrayList;

public class Bid_Details_Activity extends AppCompatActivity {

    private ImageView imgView_nft, btn_minus, btn_plus;

    private TextView txtView_nftName, txtView_nftDesc, txtView_nftPrice, txtView_bidExpDate, txtView_bidExpTime;

    private Button btn_submit;

    private RecyclerView rv_bidHistory;

    private BidHistoryAdapter bidHistoryAdapter;
    private final ArrayList<BidHistory> bidHistoryArrayList = new ArrayList<>();

    int[] nftPics = {R.drawable.curiousjoe, R.drawable.moonowls, R.drawable.owner, R.drawable.rektguy, R.drawable.roselia};

    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bid_details);

        intent = getIntent();

        initWidget();

        getTransferredData();

        initUI();

        pageDirectories();
    }

    private void getTransferredData() {

        //TODO: Get the transferred data from the page before
    }

    private void initUI() {

        initRecView();

    }

    private void initRecView() {
        //Init recyclerView
        //for better performance of recyclerview.

        rv_bidHistory.setHasFixedSize(true);

        bidHistoryAdapter = new BidHistoryAdapter(getApplicationContext(), bidHistoryArrayList);
        rv_bidHistory.setAdapter(bidHistoryAdapter);

        //layout to contain recyclerview
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        llm.setSmoothScrollbarEnabled(true);
        // orientation of linearlayoutmanager.
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        llm.setAutoMeasureEnabled(true);

        //set layoutmanager for recyclerview.
        rv_bidHistory.setLayoutManager(llm);

        new LoadBidHistory().execute();
    }

    BidHistory bidHistory;

    class LoadBidHistory extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected String doInBackground(String... args) {
            try {

                String[] accName = getResources().getStringArray(R.array.bidHistory_accName);
                String[] ethPrice = getResources().getStringArray(R.array.bidHistory_ethPrice);
                String[] duration = getResources().getStringArray(R.array.bidHistory_duration);
                String[] usdPrice = getResources().getStringArray(R.array.bidHistory_usdPrice);
                String[] expiration = getResources().getStringArray(R.array.bidHistory_expiration);
                String[] floorDiff = getResources().getStringArray(R.array.bidHistory_floorDiff);


                for (int i = 0 ; i < accName.length; i++)
                {
                    bidHistory = new BidHistory();

                    bidHistory.setBidAccImage(nftPics[i]);
                    bidHistory.setAccName(accName[i]);
                    bidHistory.setBidEthPrice(ethPrice[i]);
                    bidHistory.setDuration(duration[i]);
                    bidHistory.setBidUsdPrice(usdPrice[i]);
                    bidHistory.setExpiration(expiration[i]);
                    bidHistory.setFloorDiff(floorDiff[i]);

                    bidHistoryArrayList.add(bidHistory);
                    bidHistory = null;
                }


            } catch (Exception e) {
                e.printStackTrace();

            }

            return null;
        }

        protected void onPostExecute(String file_url) {

//            pgbPopulardestination.setVisibility(View.GONE);

            if (bidHistoryArrayList != null && bidHistoryArrayList.size() > 0) {
                bidHistoryAdapter = new BidHistoryAdapter(getApplicationContext(), bidHistoryArrayList);
                rv_bidHistory.setAdapter(bidHistoryAdapter);
                bidHistoryAdapter.notifyDataSetChanged();
            }
        }
    }


    private void pageDirectories() {


    }

    private void initWidget() {

        //ImageView
        imgView_nft = findViewById(R.id.imgView_nft);
        btn_minus = findViewById(R.id.btn_minus);
        btn_plus = findViewById(R.id.btn_plus);

        //TextView
        txtView_nftName = findViewById(R.id.txtView_nftName);
        txtView_nftDesc = findViewById(R.id.txtView_nftDesc);
        txtView_nftPrice = findViewById(R.id.txtView_nftPrice);
        txtView_bidExpDate = findViewById(R.id.txtView_bidExpDate);
        txtView_bidExpTime = findViewById(R.id.txtView_bidExpTime);

        //Button
        btn_submit = findViewById(R.id.btn_submit);

        //RecyclerView
        rv_bidHistory = findViewById(R.id.rv_bidHistory);
    }
}