package com.example.enefte;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.enefte.Adapter.BidHistoryAdapter;
import com.example.enefte.Adapter.FYCAdapter;
import com.example.enefte.Fragment.Details;
import com.example.enefte.Model.BidHistory;
import com.example.enefte.Model.ForYouNFT;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class Bid_Details_Activity extends AppCompatActivity {

    private ImageView imgView_nft, btn_minus, btn_plus;

    private TextView txtView_nftName, txtView_nftDesc, txtView_nftPrice, txtView_bidExpDate, txtView_bidExpTime;

    private Button btn_submit;

    private RecyclerView rv_bidHistory;

    private String nftName, nftPrice, nftArtistDesc;

    private Bitmap bmp;

    Calendar myCalendar;

    DatePickerDialog.OnDateSetListener date;

    private BidHistoryAdapter bidHistoryAdapter;
    private final ArrayList<BidHistory> bidHistoryArrayList = new ArrayList<>();

    int[] nftPics = {R.drawable.curiousjoe, R.drawable.moonowls, R.drawable.owner, R.drawable.rektguy, R.drawable.roselia};

    private int counter;

    Intent intent;

    private String bidPrice, bidExpDate, bidExpTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bid_details);

        intent = getIntent();

        myCalendar = Calendar.getInstance();

        initWidget();

        getTransferredData();

        initUI();

        pageDirectories();
    }

    private void getTransferredData() {

        //TODO: Get the transferred data from the page before

        nftName = intent.getStringExtra("Nft Name");
        nftPrice = intent.getStringExtra("Nft Price");
        nftArtistDesc = intent.getStringExtra("Artist Desc");

        Bundle extras = getIntent().getBundleExtra("Nft Image");
        byte[] byteArray = extras.getByteArray("image");
        bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

    }

    private void initUI() {

        imgView_nft.setImageBitmap(bmp);
        txtView_nftName.setText(nftName);
        txtView_nftDesc.setText(nftArtistDesc);;
        txtView_nftPrice.setText(nftPrice);

        counter = Integer.parseInt(txtView_nftPrice.getText().toString());

        initRecView();
    }

    private void initRecView() {
        //Init recyclerView
        //for better performance of recyclerview.

        rv_bidHistory.setHasFixedSize(true);

        bidHistoryAdapter = new BidHistoryAdapter(getApplicationContext(), bidHistoryArrayList);
        rv_bidHistory.setAdapter(bidHistoryAdapter);

        //layout to contain recyclerview
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        llm.setSmoothScrollbarEnabled(true);
        // orientation of linearlayoutmanager.
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        llm.setAutoMeasureEnabled(true);

        //set layoutmanager for recyclerview.
        rv_bidHistory.setLayoutManager(llm);

        new LoadBidHistory().execute();
    }

    BidHistory bidHistory;

    class LoadBidHistory extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected String doInBackground(String... args) {
            try {

                String[] accName = getResources().getStringArray(R.array.bidHistory_accName);
                String[] ethPrice = getResources().getStringArray(R.array.bidHistory_ethPrice);
                String[] duration = getResources().getStringArray(R.array.bidHistory_duration);
                String[] usdPrice = getResources().getStringArray(R.array.bidHistory_usdPrice);
                String[] expiration = getResources().getStringArray(R.array.bidHistory_expiration);
                String[] floorDiff = getResources().getStringArray(R.array.bidHistory_floorDiff);


                for (int i = 0 ; i < accName.length; i++)
                {
                    bidHistory = new BidHistory();

                    bidHistory.setBidAccImage(nftPics[i]);
                    bidHistory.setAccName(accName[i]);
                    bidHistory.setBidEthPrice(ethPrice[i]);
                    bidHistory.setDuration(duration[i]);
                    bidHistory.setBidUsdPrice(usdPrice[i]);
                    bidHistory.setExpiration(expiration[i]);
                    bidHistory.setFloorDiff(floorDiff[i]);

                    bidHistoryArrayList.add(bidHistory);
                    bidHistory = null;
                }


            } catch (Exception e) {
                e.printStackTrace();

            }

            return null;
        }

        protected void onPostExecute(String file_url) {

//            pgbPopulardestination.setVisibility(View.GONE);

            if (bidHistoryArrayList != null && bidHistoryArrayList.size() > 0) {
                bidHistoryAdapter = new BidHistoryAdapter(getApplicationContext(), bidHistoryArrayList);
                rv_bidHistory.setAdapter(bidHistoryAdapter);
                bidHistoryAdapter.notifyDataSetChanged();
            }
        }
    }


    private void pageDirectories() {

        txtView_bidExpDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(Bid_Details_Activity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                decreaseCounter(view);
            }
        });

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                increaseCounter(view);
            }
        });

        txtView_bidExpTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(Bid_Details_Activity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                txtView_bidExpTime.setText(hourOfDay + ":" + minute);
                            }
                        }, hour, minute, false);

                timePickerDialog.show();
            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bidPrice = txtView_nftPrice.getText().toString();
                bidExpDate = txtView_bidExpDate.getText().toString();
                bidExpTime = txtView_bidExpTime.getText().toString();

                validateDate();
                validateTime();
                validateInput();

            }
        });
    }

    private void validateInput() {

        if (!validateDate() | !validateTime())
            return;
        else
        {
            //TODO: Create code for storing it in a db
            startActivity(new Intent(getApplicationContext(), BidSuccessFul_Activity.class));
        }
    }

    private boolean validateTime() {

        if (bidExpTime.isEmpty())
        {
            txtView_bidExpTime.setError("Please input the Bid Expiration Time");
            return false;
        }
        else if (bidExpTime.equals("Time"))
        {
            txtView_bidExpTime.setError("Invalid Bid Expiration Time");
            return false;
        }
        else
            return true;
    }

    private boolean validateDate() {

        if (bidExpDate.isEmpty())
        {
            txtView_bidExpDate.setError("Please input the Bid Expiration Date");
            return false;
        }
        else if (bidExpDate.equals("Date"))
        {
            txtView_bidExpDate.setError("Invalid Bid Expiration Date");
            return false;
        }
        else
            return true;

    }

    private void increaseCounter(View view) {
        counter = counter + 1;
        display(counter);
    }

    private void decreaseCounter(View view) {
        if (counter > 0) {
            counter -= 1;
        }
        display(counter);
    }

    private void display(int number) {
        txtView_nftPrice.setText("" + number);
    }

    private void updateLabel() {

        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        txtView_bidExpDate.setText(sdf.format(myCalendar.getTime()));
    }

    private void initWidget() {

        //ImageView
        imgView_nft = findViewById(R.id.imgView_nft);
        btn_minus = findViewById(R.id.btn_minus);
        btn_plus = findViewById(R.id.btn_plus);

        //TextView
        txtView_nftName = findViewById(R.id.txtView_nftName);
        txtView_nftDesc = findViewById(R.id.txtView_nftDesc);
        txtView_nftPrice = findViewById(R.id.txtView_nftPrice);
        txtView_bidExpDate = findViewById(R.id.txtView_bidExpDate);
        txtView_bidExpTime = findViewById(R.id.txtView_bidExpTime);

        //Button
        btn_submit = findViewById(R.id.btn_submit);

        //RecyclerView
        rv_bidHistory = findViewById(R.id.rv_bidHistory);
    }
}