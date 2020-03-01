package com.santhu.demo;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.santhu.demo.utils.Constants;

public class ShowFlightsActivity extends AppCompatActivity {

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

        //Now you can delimit the string and get flight detials

        

    }
}
