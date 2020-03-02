package com.santhu.demo.adapter;

import com.santhu.demo.model.Flight;
import com.santhu.demo.model.HotelDetails;

public interface ClickListener {

    void onClickedItem(final Flight flight);
    void onClickedItem(final HotelDetails hotelDetails);
}
