package com.example.enefte.UploadNFT;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.enefte.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Upload_items_Activity extends AppCompatActivity {

    private ImageView btn_back, imgView_uploadNft;
    private EditText editTxt_nftName, editTxt_externalLink, editTxt_nftBio;
    private com.google.android.material.button.MaterialButton btn_next;

    private String nftName, externalLink, nftBio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_items);

        initWidget();

        pageDirectories();
    }

    private void pageDirectories() {

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nftName = editTxt_nftName.getText().toString();
                externalLink = editTxt_externalLink.getText().toString();
                nftBio = editTxt_nftBio.getText().toString();

                validateNftName();
                validateExternalLink();
                validateNftPic();
                validateNftBio();
                validateInput();

            }
        });
    }

    private void validateInput() {

        if (!validateNftName() | !validateExternalLink() | !validateNftPic() | validateNftBio())
            return;
        else
        {
            //Carry over data to the next page
            Intent intent = new Intent(getApplicationContext(), Upload_items_Activity.class);
            intent.putExtra("NFT Name", nftName);
            intent.putExtra("External Link", externalLink);
            intent.putExtra("Nft Bio", nftBio);
            startActivity(intent);
        }
    }

    private boolean validateNftBio() {
        if (externalLink.isEmpty())
        {
            editTxt_nftBio.setError("Required");
            return false;
        }
        else
            return true;
    }

    private boolean validateNftPic() {
        return true;
    }

    private boolean validateExternalLink() {

        String pattern = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(externalLink);

        if (externalLink.isEmpty())
        {
            editTxt_externalLink.setError("Required");
            return false;
        }
        else if (m.matches())
        {
            //Link is valid
            return true;
        }
        else
        {
            editTxt_externalLink.setError("Invalid Link");
            return false;
        }
    }

    private boolean validateNftName() {

        //Regex pattern to allow only alphabets
        Pattern regexName = Pattern.compile("\"^[a-zA-Z0-9#]+$\"");
        Matcher matcher = regexName.matcher(nftName);

        if (nftName.isEmpty())
        {
            editTxt_nftName.setError("Required");
            return false;
        }
        else if (!matcher.matches())
        {
            editTxt_nftName.setError("Invalid input");
            return false;
        }
        else
            return true;
    }

    private void initWidget() {

        //ImageView
        btn_back = findViewById(R.id.btn_back);
        imgView_uploadNft = findViewById(R.id.imgView_uploadNft);

        //EditText
        editTxt_nftName = findViewById(R.id.editTxt_nftName);
        editTxt_externalLink = findViewById(R.id.editTxt_externalLink);
        editTxt_nftBio = findViewById(R.id.editTxt_nftBio);

        //MaterialButton
        btn_next = findViewById(R.id.btn_next);

    }
}