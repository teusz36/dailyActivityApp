package com.example.yearofactivity.ui.year;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.util.ArrayList;

import com.example.yearofactivity.R;
import com.example.yearofactivity.ui.day.ChosenDay;

public class YearAdapter extends RecyclerView.Adapter<YearViewHolder> {

    private final ArrayList<LocalDate> days;
    private final OnItemListener onItemListener;
    private final int monthNumber;
    private final int yearNumber;

    public YearAdapter(ArrayList<LocalDate> days, int monthNumber, int yearNumber, OnItemListener onItemListener) {
        this.days = days;
        this.onItemListener = onItemListener;
        this.monthNumber = monthNumber;
        this.yearNumber = yearNumber;
    }

    @NonNull
    @Override
    public YearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.callendar_cell, parent, false);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = (int) (parent.getHeight() * 0.166666666);
        return new YearViewHolder(view, onItemListener, monthNumber);
    }

    @Override
    public void onBindViewHolder(@NonNull YearViewHolder holder, int position) {
        final LocalDate date = days.get(position);
        if(date == null) {
            holder.dayOfMonth.setText("");
        } else if(date.getDayOfMonth() < 10) {
            holder.dayOfMonth.setText(" " + String.valueOf(date.getDayOfMonth()) + " ");
        } else {
            holder.dayOfMonth.setText(String.valueOf(date.getDayOfMonth()));
        }
        //TODO oznaczenia tła dni
        /*
        if(position % 7 == 6) {
            holder.dayOfMonth.setTextColor(Color.RED);
        }*/
        try {
            if (days.get(position).getDayOfMonth() == ChosenDay.getDayNr() &&
                    monthNumber == ChosenDay.getMonthNr() &&
                    yearNumber == ChosenDay.getYearNr()) {
                holder.dayOfMonth.setBackgroundColor(Color.YELLOW);
            }
            //holder.dayOfMonth.setBackgroundColor(Color.parseColor("#49eb74"));
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
        void onItemClick(int position, String date, int monthNumber);
    }

}
