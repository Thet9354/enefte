package com.example.enefte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.enefte.Collections.MainCollection;

import java.util.Locale;

public class NFT_Item_Activity extends AppCompatActivity {

    private ImageView btn_back, btn_share, btn_detail, imgView_nft, imgView_artist, imgView_owner;

    private TextView txtView_artist, txtView_nftName, txtView_owner, txtView_nftDesc,
            txtView_nftPrice, txtView_endsIn, txtView_bidPrice;

    private Button btn_bid;

    private String nftName, nftArtist;

    private String nftImgName, nftImgArtist, aboutCollection;

    private Intent intent;

    private RelativeLayout rel_creator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nft_item);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        intent = getIntent();

        initWidget();

        getIntentData();

        pageDirectories();
    }

    private void pageDirectories() {

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btn_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Brings user to a detail page of the selected nft

                Intent intent = new Intent(getApplicationContext(), NFT_Item_Details_Activity.class);
                intent.putExtra("Nft Name", nftName);
                intent.putExtra("Nft Artist", nftArtist);
                intent.putExtra("About Collection", aboutCollection);
                startActivity(intent);
            }
        });

        btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Check out this cool ass NFT");
                intent.putExtra(Intent.EXTRA_TEXT, "Your application link here");
                startActivity(Intent.createChooser(intent, "Share Via"));
            }
        });

        btn_bid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Lead user to a bidding detail page for this piece of art
            }
        });

        rel_creator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainCollection.class);
                startActivity(intent);
            }
        });
    }

    private void initUI() {

        switch (nftName)
        {
            case "Mosu #1930":
                nftImgName = "mosu_nft";
                nftImgArtist = "karafuru";
                imgView_owner.setImageResource(R.drawable.owner);
                txtView_owner.setText("537C47");
                txtView_nftDesc.setText(R.string.karafuru_desc);
                break;

            case "CloneX #1172":
                nftImgName = "clonex_1172";
                nftImgArtist = "rtfktlonextm";
                imgView_owner.setImageResource(R.drawable.hruso);
                txtView_owner.setText("537C47");
                txtView_nftDesc.setText(R.string.clonex_desc);
                break;

            case "Samurai #103":
                nftImgName = "samurai_kid";
                nftImgArtist = "roselia";
                imgView_owner.setImageResource(R.drawable.selldrugsandbuynfts);
                txtView_owner.setText("selldrugsandbuynft");
                txtView_nftDesc.setText(R.string.roselia_desc);
                break;

            case "COCKPUNCH™ #1182":
                nftImgName = "legend_of_cockpunch";
                nftImgArtist = "cockpunch";
                imgView_owner.setImageResource(R.drawable.moonowls);
                txtView_owner.setText("moonowls");
                txtView_nftDesc.setText(R.string.cockpunch_desc);
                break;

            case "Valhalla #1724":
                nftImgName = "valhalla_1724";
                nftImgArtist = "stackedstudio";
                imgView_owner.setImageResource(R.drawable.hruso);
                txtView_owner.setText("Hruso");
                txtView_nftDesc.setText(R.string.valhalla_desc);
                break;

            case "Mindblown #219":
                nftImgName = "mindblown_by_lsd_219";
                nftImgArtist = "mindblown";
                imgView_owner.setImageResource(R.drawable.unnamed);
                txtView_owner.setText("Unnamed");
                txtView_nftDesc.setText(R.string.mindblown_lsd_desc);
                break;

            case "Cyber Thug #216":
                nftImgName = "cyber_thug_216";
                nftImgArtist = "disruptor";
                imgView_owner.setImageResource(R.drawable.denied);
                txtView_owner.setText("DENI134");
                txtView_nftDesc.setText(R.string.cyber_thug_desc);
                break;

        }

        aboutCollection = txtView_nftDesc.getText().toString();

        txtView_nftName.setText(nftName);

        txtView_artist.setText(nftArtist);

        int nameID = getResources().getIdentifier(nftImgName.toLowerCase(Locale.ROOT), "drawable", getPackageName());
        imgView_nft.setImageResource(nameID);

        int artistID = getResources().getIdentifier(nftImgArtist.toLowerCase(Locale.ROOT), "drawable", getPackageName());
        imgView_artist.setImageResource(artistID);


    }

    private void getIntentData() {

        nftName = intent.getStringExtra("NFT Name");
        nftArtist = intent.getStringExtra("NFT Artist");

        initUI();
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
        btn_detail = findViewById(R.id.btn_detail);
        imgView_nft = findViewById(R.id.imgView_nft);
        imgView_artist = findViewById(R.id.imgView_artist);
        imgView_owner = findViewById(R.id.imgView_owner);

        //Button
        btn_bid = findViewById(R.id.btn_bid);

        //RelativeLayout
        rel_creator = findViewById(R.id.rel_creator);


    }


}