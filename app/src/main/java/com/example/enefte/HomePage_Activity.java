package com.example.enefte;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.example.enefte.Fragment.Home;
import com.example.enefte.Fragment.MarketPlace;
import com.example.enefte.Fragment.Profile;
import com.example.enefte.Fragment.Search;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class HomePage_Activity extends AppCompatActivity {

    private RelativeLayout fragment_container;
    private ChipNavigationBar bottom_nav_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //for fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home_page);

        initWidget();
    }

    private void initWidget() {
        fragment_container = findViewById(R.id.fragment_container);
        bottom_nav_bar = findViewById(R.id.bottom_nav_bar);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Home()).commit();
        bottom_nav_bar.setItemSelected(R.id.navigation_home, true);
        bottomMenu();
    }

    private void bottomMenu() {
        bottom_nav_bar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment = null;
                switch(i)
                {
                    case R.id.navigation_home:
                        fragment = new Home();
                        break;

                    case R.id.navigation_search:
                        fragment = new Search();
                        break;

                    case R.id.navigation_marketPlace:
                        fragment = new MarketPlace();
                        break;

                    case R.id.navigation_myprofile:
                        fragment = new Profile();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            }
        });
    }
}