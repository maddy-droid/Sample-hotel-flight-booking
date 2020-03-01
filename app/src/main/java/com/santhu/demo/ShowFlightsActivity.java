package com.santhu.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.santhu.demo.adapter.FlightsAdapter;
import com.santhu.demo.communicator.MyTransporter;
import com.santhu.demo.communicator.TransporterCommunication;
import com.santhu.demo.model.BaseModel;
import com.santhu.demo.model.Flight;
import com.santhu.demo.model.FlightDetails;
import com.santhu.demo.utils.Constants;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ShowFlightsActivity extends AppCompatActivity implements TransporterCommunication {

    private ProgressBar mProgressBar;
    private RecyclerView mRecyclerView;
    private FlightsAdapter mFlightsAdapter;
    private TextView mErrorTextview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String fDetails = null;
        Intent intent = getIntent();
        if (intent != null){
            fDetails = intent.getStringExtra(Constants.EXTRA_FLIGHT_DETAILS);
            if (fDetails == null){
                finish();
                return;
            }
        }

        setContentView(R.layout.show_flight_activity);
        mProgressBar = findViewById(R.id.progressBar);
        mErrorTextview = findViewById(R.id.error_state_tv);
        mRecyclerView = findViewById(R.id.flights_recycler_view);

        showProgressBar();

        //Now you can delimit the string and get flight detials
        MyTransporter.getInstance().getFlightDetails(this);

    }

    @Override
    public void onResponse(BaseModel baseModel) {
        if (baseModel.getType() == Constants.MODEL_TYPE_FLIGHT){
            FlightDetails flightDetails = (FlightDetails) baseModel;
            showServerFetechedFlightData(flightDetails.getFlights());
        }else{
            showErrorScreen("something went wrong! model type was wrong");
        }

    }

    @Override
    public void onError(String error) {
        showErrorScreen(error);
    }

    private void showProgressBar(){
        mProgressBar.bringToFront();
        mProgressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar(){
        mProgressBar.bringToFront();
        mProgressBar.setVisibility(View.GONE);
    }

    private void showServerFetechedFlightData(final ArrayList<Flight> flightDetails){
        hideProgressBar();
        mErrorTextview.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ShowFlightsActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL); // set Horizontal Orientation
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mFlightsAdapter = new FlightsAdapter(flightDetails);
        mRecyclerView.setAdapter(mFlightsAdapter);

    }


    private void showErrorScreen(final String errorText){

        hideProgressBar();
        mRecyclerView.setVisibility(View.GONE);
        mErrorTextview.setVisibility(View.VISIBLE);
        mErrorTextview.setText(errorText);

    }

}
