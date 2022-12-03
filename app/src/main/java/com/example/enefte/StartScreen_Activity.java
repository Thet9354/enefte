package com.example.enefte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class StartScreen_Activity extends AppCompatActivity {

    private Button btn_connectWallet;
    private ImageView btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        initWidget();

        pageDirectories();
    }

    private void pageDirectories() {

        btn_connectWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ConnectWithWallet_Activity.class));
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ConnectWithWallet_Activity.class));
            }
        });
    }

    private void initWidget() {

        //Button
        btn_connectWallet = findViewById(R.id.btn_connectWallet);

        //ImageView
        btn_next = findViewById(R.id.btn_next);
    }
}