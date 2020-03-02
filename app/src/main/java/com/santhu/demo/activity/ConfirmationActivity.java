package com.santhu.demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.santhu.demo.R;
import com.santhu.demo.model.FlightDetails;
import com.santhu.demo.utils.Constants;
import com.santhu.demo.utils.DataMarshall;

public class ConfirmationActivity extends AppCompatActivity {

    private String mPassengerDetails;
    private String mFlightDetails;
    private String mHotelDetails;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        if (intent != null){
            mPassengerDetails = intent.getStringExtra(Constants.EXTRA_PASSENGER_DETAILS);
            mFlightDetails = intent.getStringExtra(Constants.EXTRA_FLIGHT_DETAILS);
            mHotelDetails = intent.getStringExtra(Constants.EXTRA_HOTEL_DETAILS);
            if (mPassengerDetails == null || mFlightDetails == null || mHotelDetails == null){
                finish();
                return;
            }
        }

        setContentView(R.layout.confirmation_activity);

        loadDataToUi();

    }

    private void loadDataToUi() {

        TextView flightSelectTextView = findViewById(R.id.flight_selected_name_tv);

        String[] flightDetials = DataMarshall.splitFlightData(mFlightDetails);
        flightSelectTextView.setText(flightDetials[0]);

        TextView flightSelectPriceTextView = findViewById(R.id.flight_selected_price);
        flightSelectPriceTextView.setText(DataMarshall.convertMoney(flightDetials[5], ""));

        String[] hotelDetials = DataMarshall.splitHotelData(mHotelDetails);
        TextView hotelSelectTextView = findViewById(R.id.hotel_selected_name_tv);

        hotelSelectTextView.setText(hotelDetials[0]);

        TextView hotelSelectPriceTextView = findViewById(R.id.hotel_selected_price);
        // since no data from server so we are placing money as static
        hotelSelectPriceTextView.setText(DataMarshall.convertMoney("150", ""));

        findViewById(R.id.pay_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(ConfirmationActivity.this, "Thanks for payment ticket are mailed to registered email id", Toast.LENGTH_SHORT).show();


            }
        });



    }
}
