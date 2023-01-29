package com.example.enefte.Fragment.ProfileFragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.enefte.R;
import com.example.enefte.UploadNFT.Upload_items_Activity;

public class Collected extends Fragment {

    private Context mContext;

    private AutoCompleteTextView filled_exposed;
    private androidx.appcompat.widget.AppCompatButton btn_upload;

    private androidx.recyclerview.widget.RecyclerView rv_collected;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_collected, container, false);

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

        filled_exposed = v.findViewById(R.id.filled_exposed);
        btn_upload = v.findViewById(R.id.btn_upload);
        rv_collected = v.findViewById(R.id.rv_collected);

        initUI();

        pageDirectories();
    }

    private void pageDirectories() {

        btn_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(mContext, Upload_items_Activity.class));
            }
        });

    }

    private void initUI() {
        String[] type = new String[] {"Art", "Collectibles", "Domain Names", "Music", "Photography", "Sports", "Trading Cards", "Utility", "Virtual Worlds"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                mContext,
                R.layout.drop_down_item,
                type
        );

        filled_exposed.setAdapter(adapter);
    }
}