package com.santhu.demo.communicator;

import com.santhu.demo.model.HotelDetails;
import com.santhu.demo.utils.Constants;

import java.lang.ref.WeakReference;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyTransporter {
    private static MyTransporter INSTANCE = null;
    private static final TransporterService mMyTransporterService ;

    static {
        mMyTransporterService = TransporterService.Creator.newService("http://pastebin.com");
    }

    public static void initialize(){
        if (INSTANCE == null) {
            synchronized (MyTransporter.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MyTransporter();
                }
            }
        }
    }

    public static MyTransporter getInstance() {
        return INSTANCE;
    }


    public void getHotelDetails(TransporterCommunication transporterCommunication) {
        final WeakReference<TransporterCommunication> weakReference = new WeakReference<>(transporterCommunication);
        Call<HotelDetails> hotelResponseCall = mMyTransporterService.getHotelDetails();

        hotelResponseCall.enqueue(new Callback<HotelDetails>() {
            @Override
            public void onResponse(Call<HotelDetails> call, Response<HotelDetails> response) {
                HotelDetails hotelDetails = response.body();
                if (hotelDetails != null){
                    if (weakReference.get() != null){
                        hotelDetails.setType(Constants.MODEL_TYPE_HOTEL);
                        weakReference.get().onResponse(hotelDetails);
                    }
                }else{
                    // show the error Response ERROR code
                    if (weakReference.get() != null){
                        weakReference.get().onError("Something went wrong!!!");
                    }
                }
            }

            @Override
            public void onFailure(Call<HotelDetails> call, Throwable t) {
                if (weakReference.get() != null){
                    weakReference.get().onError(t.getMessage());
                }
            }
        });


    }




}
