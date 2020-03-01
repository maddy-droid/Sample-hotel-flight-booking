package com.santhu.demo.communicator;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.santhu.demo.BuildConfig;
import com.santhu.demo.model.HotelDetails;

import java.lang.reflect.Type;
import java.util.Collections;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface TransporterService {


    @Headers("Content-Type: application/json")
    @POST("raw/f0Tm6bfy")
    Call<HotelDetails> getHotelDetails();

    /********
     * Helper class that sets up a new services
     *******/
    class Creator {

        public static TransporterService newService(String baseUrl) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            // Forcing http 1.1
            builder.protocols(Collections.singletonList(Protocol.HTTP_1_1));
            OkHttpClient okHttpClient = builder.build();

            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                    .excludeFieldsWithoutExposeAnnotation()
                    .setLenient()
                    .registerTypeAdapter(HotelDetailsDeserializer.class, new HotelDetailsDeserializer())
                    .create();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(okHttpClient)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
            return retrofit.create(TransporterService.class);
        }


    }

    public class HotelDetailsDeserializer implements JsonDeserializer<HotelDetails> {

        static Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        @Override
        public HotelDetails deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            HotelDetails botResponseWrapper = gson.fromJson(json, HotelDetails.class);
            return botResponseWrapper;
        }
    }

}
