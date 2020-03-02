package com.santhu.demo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.santhu.demo.R;
import com.santhu.demo.communicator.MyTransporter;
import com.santhu.demo.utils.Constants;
import com.santhu.demo.utils.DataMarshall;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText mEdittextFrom, mEdittextTo;
    DatePickerDialog mDatePickerDialogFrom, mDatePickerDialogTo;
    Spinner mSpinnerDep, mSpinnerDest;
    String mDeprature, mDestination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyTransporter.initialize();
        mSpinnerDep = (Spinner) findViewById(R.id.spinnerDep);
        mSpinnerDest = (Spinner) findViewById(R.id.spinnerDest);

        // initiate the date picker and a button

        mEdittextFrom = (EditText) findViewById(R.id.dateStart);
        // perform click event on edit text
        mEdittextFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                // date picker dialog
                mDatePickerDialogFrom = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                mEdittextFrom.setText(dayOfMonth + "-"
                                        + (monthOfYear + 1) + "-" + year);

                            }
                        }, year, month, day);
                mDatePickerDialogFrom.show();
            }
        });

        mEdittextTo = (EditText) findViewById(R.id.dateAnd);
        // perform click event on edit text
        mEdittextTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar c1 = Calendar.getInstance();
                int year1 = c1.get(Calendar.YEAR);
                int month1 = c1.get(Calendar.MONTH);
                int day1 = c1.get(Calendar.DAY_OF_MONTH);
                // date picker dialog
                mDatePickerDialogTo = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                mEdittextTo.setText(dayOfMonth + "-"
                                        + (monthOfYear + 1) + "-" + year);


                            }
                        }, year1, month1,day1);
                mDatePickerDialogTo.show();
            }
        });


        findViewById(R.id.bBook).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mDeprature = String.valueOf(mSpinnerDep.getSelectedItem());
                mDestination = String.valueOf(mSpinnerDest.getSelectedItem());

                //DAtePicker


                String dateDest = mEdittextFrom.getText().toString();
                String dateDep = mEdittextTo.getText().toString();

                //test
                if (mDeprature.length() == 0 || mDestination.length() == 0 || dateDep.length() == 0 || dateDest.length() == 0) {
                    //AlertDialog
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                    builder1.setMessage("Fill all the informations !");
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    builder1.show();
                } else {

                    // strings with delimter
                    String data = DataMarshall.combinePassengerData(mDeprature, mDestination,dateDep, dateDest);
                    Intent intent = new Intent(MainActivity.this, ShowFlightsActivity.class);
                    intent.putExtra(Constants.EXTRA_PASSENGER_DETAILS, data);
                    startActivity(intent);

                }

            }
            });

    }
}
