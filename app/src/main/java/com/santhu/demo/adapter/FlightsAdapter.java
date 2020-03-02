package com.santhu.demo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.santhu.demo.R;
import com.santhu.demo.model.Flight;
import com.santhu.demo.utils.DateUtils;

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
        holder.departureDateTextView.setText(DateUtils.getDate(flight.getDeparture_date()));
        holder.departureAirportTextView.setText(flight.getDeparture_airport());

        holder.arrivalDateTextView.setText(DateUtils.getDate(flight.getArrival_date()));
        holder.arrivalAirportTextView.setText(flight.getArrival_airport());

        holder.airwaysTextView.setText(flight.getAirline());
        holder.priceTextView.setText(flight.getPrice());

        holder.totalTravelTimeTextView.setText(DateUtils.getTravelTime(flight.getDeparture_date(), flight.getArrival_date()));

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

        TextView departureDateTextView;
        TextView departureAirportTextView;
        TextView arrivalDateTextView;
        TextView arrivalAirportTextView;
        TextView airwaysTextView;
        Button priceTextView;
        TextView totalTravelTimeTextView;



        public FlightsViewHolder(@NonNull View itemView) {
            super(itemView);
            departureDateTextView =itemView.findViewById(R.id.departure_date_name_tv);
            departureAirportTextView =itemView.findViewById(R.id.departure_airport_name_tv);

            arrivalDateTextView =itemView.findViewById(R.id.arrival_date_name_tv);
            arrivalAirportTextView =itemView.findViewById(R.id.arrival_airport_name_tv);

            airwaysTextView =itemView.findViewById(R.id.airway_name_tv);
           priceTextView =itemView.findViewById(R.id.price_name_tv);

            totalTravelTimeTextView =itemView.findViewById(R.id.total_travel_time);

        }


    }

}
