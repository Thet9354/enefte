package com.example.enefte;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class ConnectWithWallet_Activity extends AppCompatActivity {

    private ImageView btn_back, btn_metamask, btn_trustWallet, btn_ethAddress;

    private Button btn_continue;

    private String walletAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_with_wallet);

        initWidget();

        pageDirectories();
    }

    private void pageDirectories() {
        btn_ethAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDialog();
            }
        });
    }

    private void showDialog() {

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomsheetlayout);

        EditText editTxt_address = dialog.findViewById(R.id.editTxt_address);
        Button btn_continue = dialog.findViewById(R.id.btn_continue);

        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //validate address
                walletAddress = editTxt_address.getText().toString();

                Intent intent = new Intent(getApplicationContext(), SetUpProfile_Activity.class);
                intent.putExtra("Wallet Address", walletAddress);
                startActivity(intent);
            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }



    private void initWidget() {

        //ImageView
        btn_back = findViewById(R.id.btn_back);
        btn_metamask = findViewById(R.id.btn_metamask);
        btn_trustWallet = findViewById(R.id.btn_trustWallet);
        btn_ethAddress = findViewById(R.id.btn_ethAddress);

        //Button
        btn_continue = findViewById(R.id.btn_continue);

    }


}