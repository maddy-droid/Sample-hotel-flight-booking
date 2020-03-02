package com.santhu.demo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.santhu.demo.R;
import com.santhu.demo.model.HotelDetails;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.ArrayList;

public class HotelsAdapter extends RecyclerView.Adapter<HotelsAdapter.HotelsViewHolder>{

    private final ArrayList<HotelDetails> mHotelDetailsList;
    private final ClickListener mClickListner;

    public HotelsAdapter(ArrayList<HotelDetails> hotelDetails, ClickListener clickListener) {
        mHotelDetailsList = hotelDetails;
        mClickListner = clickListener;
    }

    @NonNull
    @Override
    public HotelsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_details_adapter,parent,false);
        return new HotelsAdapter.HotelsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelsViewHolder holder, int position) {

        HotelDetails hotelDetails = mHotelDetailsList.get(position);
        holder.hotelNameTextView.setText(hotelDetails.getName());
        holder.hotelLocationTextView.setText(hotelDetails.getHotel_location());
        //holder.hotelRatingView.setRating(Integer.parseInt(hotelDetails.getRating()));
        HotelImageViewPagerAdapter hotelImageViewPagerAdapter = new HotelImageViewPagerAdapter(hotelDetails.getImages());
        holder.dotsIndicator.setViewPager(holder.hotelViewPager);
        holder.hotelViewPager.setAdapter(hotelImageViewPagerAdapter);



    }

    @Override
    public int getItemCount() {
        return mHotelDetailsList.size();
    }

    public class HotelsViewHolder extends RecyclerView.ViewHolder{

        TextView hotelNameTextView;
        RatingBar hotelRatingView;
        TextView hotelLocationTextView;
        ViewPager hotelViewPager;
        DotsIndicator dotsIndicator;

        TextView arrivalAirportTextView;
        TextView airwaysTextView;
        Button priceTextView;
        TextView totalTravelTimeTextView;
        View itemViewMain;



        public HotelsViewHolder(@NonNull View itemView) {
            super(itemView);
            itemViewMain = itemView;
            hotelNameTextView =itemView.findViewById(R.id.hotel_name_tv);
          //  hotelRatingView =itemView.findViewById(R.id.hotel_rating);
            hotelLocationTextView =itemView.findViewById(R.id.hotel_location_tv);

            hotelViewPager = itemView.findViewById(R.id.hotel_view_pager);
            dotsIndicator = (DotsIndicator) itemView.findViewById(R.id.dots_indicator);

            arrivalAirportTextView =itemView.findViewById(R.id.arrival_airport_name_tv);

            airwaysTextView =itemView.findViewById(R.id.airway_name_tv);
            priceTextView =itemView.findViewById(R.id.price_name_tv);

            totalTravelTimeTextView =itemView.findViewById(R.id.total_travel_time);

        }


    }

}
