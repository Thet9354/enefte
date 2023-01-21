package com.example.enefte;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.enefte.Fragment.Profile;

import java.util.regex.Pattern;

public class EditProfile_Activity extends AppCompatActivity {

    private ImageView btn_back, imgView_editProfilebg, imgView_editProfilePic;

    private androidx.appcompat.widget.AppCompatButton btn_save;

    private EditText editTxt_username, editTxt_email, editTxt_bio, editTxt_twitter, editTxt_instagram;

    private String mUsername, mEmail, mBio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        initWidget();

        initUI();

        pageDirectories();
    }

    private void pageDirectories() {

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mUsername = editTxt_username.getText().toString();
                mEmail = editTxt_email.getText().toString();
                mBio = editTxt_bio.getText().toString();

                validateUsername();
                validateEmail();
                validateBio();
                validateInput();
            }
        });
    }

    private void validateInput() {

        if (!validateUsername() | !validateEmail() | !validateBio())
            return;
        else
        {
            updateProfile();
        }
    }

    private void updateProfile() {
        //TODO: Create the code to update the profile in firebase
//        Profile profile = new Profile();
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.navigation_myprofile, profile);
//        transaction.addToBackStack(null);
//        transaction.commit();
        startActivity(new Intent(getApplicationContext(), HomePage_Activity.class));
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

        if (mUsername.isEmpty())
        {
            editTxt_username.setError("Field cannot be empty to proceed");
            return false;
        }
        else if (!USERNAME_PATTERN.matcher(mUsername).matches())
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

    private void initUI() {


    }

    private void initWidget() {

        //Imageview
        btn_back = findViewById(R.id.btn_back);
        imgView_editProfilebg = findViewById(R.id.imgView_editProfilebg);
        imgView_editProfilePic = findViewById(R.id.imgView_editProfilePic);

        //Button
        btn_save = findViewById(R.id.btn_save);

        //EditText
        editTxt_username = findViewById(R.id.editTxt_username);
        editTxt_email = findViewById(R.id.editTxt_email);
        editTxt_bio = findViewById(R.id.editTxt_bio);
        editTxt_twitter = findViewById(R.id.editTxt_twitter);
        editTxt_instagram = findViewById(R.id.editTxt_instagram);

    }
}