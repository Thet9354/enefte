package com.example.enefte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.regex.Pattern;

public class SetUpProfile_Activity extends AppCompatActivity {

    private ImageView btn_back, btn_upload;
    private de.hdodenhof.circleimageview.CircleImageView img_PFP;
    private EditText editTxt_username, editTxt_email, editTxt_bio;
    private Button btn_submit;

    //Storing value for input
    private String mUserName, mEmail, mBio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up_profile);

        initWidget();

        pageDirectories();
    }

    private void pageDirectories() {

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Store values
                mUserName = editTxt_username.getText().toString();
                mEmail = editTxt_email.getText().toString();
                mBio = editTxt_bio.getText().toString();

                validateUsername();
                validateEmail();
                validateBio();
                validateInput();
                addData();
            }
        });

        img_PFP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), WelcomePage_Activity.class));
            }
        });
    }

    private void addData() {
        if (!validateInput())
            return;
        else
        {
            startActivity(new Intent(getApplicationContext(), WelcomePage_Activity.class));
        }
    }

    private boolean validateInput() {
        return !(!validateUsername() | !validateEmail() | !validateBio());
    }

    private boolean validateBio() {
        if (mBio.isEmpty())
        {
            editTxt_bio.setError("We highly recommend you write something here");
            return false;
        }
        else
        {
            editTxt_bio.setError(null);
            return true;
        }
    }

    private boolean validateEmail() {
        if (mEmail.isEmpty())
        {
            editTxt_email.setError("Field can not be empty");
            return false;
        }

        // Matching the input email to a predefined email pattern
        else if (!Patterns.EMAIL_ADDRESS.matcher(mEmail).matches())
        {
            editTxt_email.setError("Please enter a valid email address");
            return false;
        }
        else
        {
            editTxt_email.setError(null);
            return true;
        }
    }

    private boolean validateUsername() {
        // defining our own username pattern
        final Pattern USERNAME_PATTERN =
                Pattern.compile("^" +
                        "(?=.*[@#$%^&+=])" +     // at least 1 special character
                        "(?=\\S+$)" +            // no white spaces
                        ".{5,}" +                // at least 4 characters
                        "$");

        if (mUserName.isEmpty())
        {
            editTxt_username.setError("Field cannot be empty to proceed");
            return false;
        }
        else if (!USERNAME_PATTERN.matcher(mUserName).matches())
        {
            editTxt_username.setError("Please enter a valid username");
            return false;
        }
        else
        {
          editTxt_username.setError(null);
          return true;
        }
    }

    private void initWidget() {

        //ImageView
        btn_back = findViewById(R.id.btn_back);
        btn_back = findViewById(R.id.btn_back);

        //CircleImageView
        img_PFP = findViewById(R.id.img_PFP);

        //EditText
        editTxt_username = findViewById(R.id.editTxt_username);
        editTxt_email = findViewById(R.id.editTxt_email);
        editTxt_bio = findViewById(R.id.editTxt_bio);

        //Button
        btn_submit = findViewById(R.id.btn_submit);

    }
}