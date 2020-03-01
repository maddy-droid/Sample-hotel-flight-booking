package com.santhu.demo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.santhu.demo.R;
import com.santhu.demo.model.Flight;
import com.santhu.demo.model.FlightDetails;

import java.util.ArrayList;

public class FlightsAdapter extends RecyclerView.Adapter<FlightsAdapter.FlightsViewHolder>{

    private final ArrayList<Flight> mFlightList;

    public FlightsAdapter(ArrayList<Flight> flightDetails) {
        mFlightList = flightDetails;
    }

    @NonNull
    @Override
    public FlightsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.flights_adapter,parent,false);
        return new FlightsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FlightsViewHolder holder, int position) {

        Flight flight = mFlightList.get(position);
        holder.airLineNameTextView.setText(flight.getAirline());

    }

    @Override
    public int getItemCount() {
        return mFlightList.size();
    }

    public void updateList(final ArrayList<Flight> flights){
        if (mFlightList != null){
            mFlightList.addAll(flights);
        }
    }


    public class FlightsViewHolder extends RecyclerView.ViewHolder{

        TextView airLineNameTextView;

        public FlightsViewHolder(@NonNull View itemView) {
            super(itemView);
            airLineNameTextView =itemView.findViewById(R.id.airline_name_tv);
        }


    }

}
