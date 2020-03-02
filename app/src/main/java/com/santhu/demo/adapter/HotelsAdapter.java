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

import me.zhanghai.android.materialratingbar.MaterialRatingBar;

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

        final HotelDetails hotelDetails = mHotelDetailsList.get(position);
        holder.hotelNameTextView.setText(hotelDetails.getName());
        holder.hotelLocationTextView.setText(hotelDetails.getHotel_location());
        holder.hotelRatingView.setRating(Integer.parseInt(hotelDetails.getRating()));
        HotelImageViewPagerAdapter hotelImageViewPagerAdapter = new HotelImageViewPagerAdapter(hotelDetails.getImages());
        holder.dotsIndicator.setViewPager(holder.hotelViewPager);
        holder.hotelViewPager.setAdapter(hotelImageViewPagerAdapter);

        holder.hotelDescriptionTextView.setText(hotelDetails.getDescription());
        holder.itemViewMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickListner.onClickedItem(hotelDetails);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mHotelDetailsList.size();
    }

    public class HotelsViewHolder extends RecyclerView.ViewHolder{

        TextView hotelNameTextView;
        TextView hotelLocationTextView;
        ViewPager hotelViewPager;
        DotsIndicator dotsIndicator;

        TextView animitiesTextView;
        TextView hotelDescriptionTextView;
        MaterialRatingBar hotelRatingView;

        View itemViewMain;



        public HotelsViewHolder(@NonNull View itemView) {
            super(itemView);
            itemViewMain = itemView;
            hotelNameTextView =itemView.findViewById(R.id.hotel_name_tv);
            hotelLocationTextView =itemView.findViewById(R.id.hotel_location_tv);

            hotelViewPager = itemView.findViewById(R.id.hotel_view_pager);
            dotsIndicator = (DotsIndicator) itemView.findViewById(R.id.dots_indicator);

            animitiesTextView =itemView.findViewById(R.id.hotel_aminities_text_view);
            hotelDescriptionTextView =itemView.findViewById(R.id.hotel_description_text_view);
            hotelRatingView =itemView.findViewById(R.id.hotel_rating_views);


        }


    }

}
