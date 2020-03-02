package com.santhu.demo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.PagerAdapter;

import com.santhu.demo.R;
import com.santhu.demo.utils.GlideUtils;

import java.net.URI;
import java.util.ArrayList;

public class HotelImageViewPagerAdapter extends PagerAdapter {

    private ArrayList<String> mImagesList;

    public HotelImageViewPagerAdapter(ArrayList<String> images){
        mImagesList = images;
    }

    @Override
    public int getCount() {
        return mImagesList.size();
    }

    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        CardView layout = (CardView) inflater.inflate(R.layout.hotel_image_page_adapter, container, false);
        ImageView imageView = layout.findViewById(R.id.hotel_image_view);
        loadHotelImage(imageView, mImagesList.get(position));
        container.addView(layout);
        return layout;

    }

    public void loadHotelImage(ImageView imageView, String mImagesUrl){
        GlideUtils.loadImageFromServer(imageView.getContext(), imageView, mImagesUrl);
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

}
