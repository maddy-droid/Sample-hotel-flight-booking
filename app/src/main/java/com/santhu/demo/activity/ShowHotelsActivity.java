package com.santhu.demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.santhu.demo.R;
import com.santhu.demo.adapter.ClickListener;
import com.santhu.demo.adapter.FlightsAdapter;
import com.santhu.demo.adapter.HotelsAdapter;
import com.santhu.demo.communicator.MyTransporter;
import com.santhu.demo.communicator.TransporterCommunication;
import com.santhu.demo.model.BaseModel;
import com.santhu.demo.model.Flight;
import com.santhu.demo.model.FlightDetails;
import com.santhu.demo.model.HotelDetails;
import com.santhu.demo.utils.Constants;

import java.util.ArrayList;

public class ShowHotelsActivity extends AppCompatActivity implements TransporterCommunication, ClickListener {

    private String mPassengerDetails;
    private String mFlightDetails;

    private ProgressBar mProgressBar;
    private RecyclerView mRecyclerView;
    private TextView mErrorTextview;

    private HotelsAdapter mHotelsAdapter;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        if (intent != null){
            mPassengerDetails = intent.getStringExtra(Constants.EXTRA_PASSENGER_DETAILS);
            mFlightDetails = intent.getStringExtra(Constants.EXTRA_FLIGHT_DETAILS);
            if (mPassengerDetails == null || mFlightDetails == null){
                finish();
                return;
            }
        }

        setContentView(R.layout.show_flight_activity);

        mProgressBar = findViewById(R.id.progressBar);
        mErrorTextview = findViewById(R.id.error_state_tv);
        mRecyclerView = findViewById(R.id.flights_recycler_view);

        MyTransporter.getInstance().getHotelDetails(this);

    }

    private void showProgressBar(){
        mProgressBar.bringToFront();
        mProgressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar(){
        mProgressBar.bringToFront();
        mProgressBar.setVisibility(View.GONE);
    }

    private void showErrorScreen(final String errorText){

        hideProgressBar();
        mRecyclerView.setVisibility(View.GONE);
        mErrorTextview.setVisibility(View.VISIBLE);
        mErrorTextview.setText(errorText);

    }

    private void showServerFetechedFlightData(final ArrayList<HotelDetails> hotelDetails){
        hideProgressBar();
        mErrorTextview.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ShowHotelsActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL); // set Horizontal Orientation
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mHotelsAdapter = new HotelsAdapter(hotelDetails, this);
        mRecyclerView.setAdapter(mHotelsAdapter);

    }


    @Override
    public void onResponse(BaseModel baseModel) {

        if (baseModel.getType() == Constants.MODEL_TYPE_HOTEL){
            HotelDetails hotelDetails = (HotelDetails) baseModel;
            ArrayList<HotelDetails> hotelDetailsArrayList = new ArrayList<HotelDetails>();
            hotelDetailsArrayList.add(hotelDetails);

            showServerFetechedFlightData(hotelDetailsArrayList);
        }else{
            showErrorScreen("something went wrong! model type was wrong");
        }
    }

    @Override
    public void onError(String error) {
        showErrorScreen(error);
    }

    @Override
    public void onClickedItem(Flight flight) {

    }
}
