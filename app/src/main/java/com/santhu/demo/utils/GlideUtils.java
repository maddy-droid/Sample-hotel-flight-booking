package com.santhu.demo.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GlideUtils {


    public static void loadImageFromServer(Context context, ImageView imageView, String url){
        Glide.with(context)
                .as(Drawable .class)
                .load(url)
                .centerCrop()
                .into(imageView);

    }


}
