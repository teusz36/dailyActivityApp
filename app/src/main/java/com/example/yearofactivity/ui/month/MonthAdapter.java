package com.example.yearofactivity.ui.month;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yearofactivity.R;
import com.example.yearofactivity.ui.day.ChosenDay;


import java.time.LocalDate;
import java.util.ArrayList;

public class MonthAdapter extends RecyclerView.Adapter<MonthViewHolder> {

    private final ArrayList<LocalDate> days;
    private final OnItemListener onItemListener;

    public MonthAdapter(ArrayList<LocalDate> days, OnItemListener onItemListener) {
        this.days = days;
        this.onItemListener = onItemListener;
    }

    @NonNull
    @Override
    public MonthViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.callendar_cell, parent, false);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = (int) (parent.getHeight() * 0.166666666);
        return new MonthViewHolder(view, onItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MonthViewHolder holder, int position) {
        final LocalDate date = days.get(position);
        if(date == null) {
            holder.dayOfMonth.setText("");
        } else {
            holder.dayOfMonth.setText(String.valueOf(date.getDayOfMonth()));
        }
        try {
            //TODO tła dni z aktywnością
            if(date.getDayOfMonth() == ChosenDay.getDayNr()) {
                holder.parentView.setBackgroundColor(Color.parseColor("#49eb74"));

            }
        }
        catch (NullPointerException nullPointerException){
            //dzień z innego miesiaca
        }
    }

    @Override
    public int getItemCount() {
        return days.size();
    }

    public interface OnItemListener {
        void onItemClick(int position, String date);
    }
}
