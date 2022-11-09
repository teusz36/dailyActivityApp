package com.example.yearofactivity.ui.year;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.yearofactivity.R;

public class YearViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


    public final View parentView;
    public final TextView dayOfMonth;
    private final YearAdapter.OnItemListener onItemListener;
    private int monthNumber;

    public YearViewHolder(@NonNull View itemView, YearAdapter.OnItemListener onItemListener, int monthNumber) {
        super(itemView);
        parentView = itemView.findViewById(R.id.callendarCellParentView_year);
        dayOfMonth = itemView.findViewById(R.id.cellDayText_year);
        this.monthNumber = monthNumber;
        this.onItemListener = onItemListener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        onItemListener.onItemClick(getAdapterPosition(), (String) dayOfMonth.getText(), monthNumber);
    }
}
