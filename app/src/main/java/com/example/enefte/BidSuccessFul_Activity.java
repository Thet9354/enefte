package com.example.enefte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class BidSuccessFul_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bid_success_ful);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(BidSuccessFul_Activity.this, HomePage_Activity.class);
                startActivity(intent);
                finish();
            }
        }, 3000); // 3 seconds delay
    }
}