package com.example.enefte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class NFT_Item_Activity extends AppCompatActivity {

    private ImageView btn_back, btn_share, btn_filter, imgView_nft, imgView_artist, imgView_owner;

    private TextView txtView_artist, txtView_nftName, txtView_owner, txtView_nftDesc,
            txtView_nftPrice, txtView_endsIn, txtView_bidPrice;

    private Button btn_bid;

    private String nftName, nftArtist;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nft_item);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        intent = getIntent();

        initWidget();

        getIntentData();

        initUI();

        pageDirectories();
    }

    private void pageDirectories() {

    }

    private void initUI() {

    }

    private void getIntentData() {

        nftName = intent.getStringExtra("NFT Name");
        nftArtist = intent.getStringExtra("NFT Artist");
    }

    private void initWidget() {

        //TextView
        txtView_artist = findViewById(R.id.txtView_artist);
        txtView_nftName = findViewById(R.id.txtView_nftName);
        txtView_owner = findViewById(R.id.txtView_owner);
        txtView_nftDesc = findViewById(R.id.txtView_nftDesc);
        txtView_nftPrice = findViewById(R.id.txtView_nftPrice);
        txtView_endsIn = findViewById(R.id.txtView_endsIn);
        txtView_bidPrice = findViewById(R.id.txtView_bidPrice);

        //ImageView
        btn_back = findViewById(R.id.btn_back);
        btn_share = findViewById(R.id.btn_share);
        btn_filter = findViewById(R.id.btn_filter);
        imgView_nft = findViewById(R.id.imgView_nft);
        imgView_artist = findViewById(R.id.imgView_artist);
        imgView_owner = findViewById(R.id.imgView_owner);

        //Button
        btn_bid = findViewById(R.id.btn_bid);

    }


}