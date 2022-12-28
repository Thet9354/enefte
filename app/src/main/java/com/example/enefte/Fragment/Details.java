package com.example.enefte.Fragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.enefte.R;


public class Details extends Fragment {

    private TextView txtView_favourite, txtView_owners, txtView_edition;

    private CardView cv_aboutCollection, cv_properties, cv_details, cv_priceHistory;

    private TextView txtView_aboutCollection, txtView_bgColor, txtView_backgroundPercent, txtView_clothes,
            txtView_clothesPercent, txtView_ear, txtView_earPercent, txtView_eye, txtView_eyePercent,
            txtView_face, txtView_facePercent, txtView_hair, txtView_hairPercent;

    private TextView txtView_contractAddress, txtView_tokenID, txtView_tokenStandard, txtView_blockchain;

    private LinearLayout ll_aboutCollection, ll_properties, ll_details, ll_priceHistory;

    private Context mContext;

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


        initUI();
    }

    private void initUI() {

        expand();
    }

    private void expand() {

        int v1 = (cv_details.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(ll_aboutCollection, new AutoTransition());
        txtView_aboutCollection.setVisibility(v1);
    }


}