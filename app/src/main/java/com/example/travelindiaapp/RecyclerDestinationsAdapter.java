package com.example.travelindiaapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerDestinationsAdapter extends RecyclerView.Adapter<RecyclerDestinationsAdapter.ViewHolder>{

    private ArrayList<DestinationsModel> arrDest;

    RecyclerDestinationsAdapter(ArrayList<DestinationsModel> arrDest){
        this.arrDest=arrDest;
    }

    @NonNull
    @Override
    public RecyclerDestinationsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for each item and return a new ViewHolder object
        View cardView = LayoutInflater.from(parent.getContext()).inflate(R.layout.destination_card, parent, false);
        return new ViewHolder(cardView);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private final ImageView img;
        private final TextView name,shortDesc;
        public ViewHolder(@NonNull View cardView) {
            super(cardView);
            img=cardView.findViewById(R.id.destinationImage);
            name=cardView.findViewById(R.id.destinationName);
            shortDesc=cardView.findViewById(R.id.destinationShortDesc);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerDestinationsAdapter.ViewHolder holder, final int position) {
        DestinationsModel destinationsModel = arrDest.get(position);
        holder.name.setText(destinationsModel.name);
        holder.shortDesc.setText(destinationsModel.shortDesc);
        holder.img.setImageResource(destinationsModel.img);
    }






    @Override
    public int getItemCount() {
        return arrDest.size();
    }
}
