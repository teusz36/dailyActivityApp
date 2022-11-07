package com.example.yearofactivity.ui;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.yearofactivity.R;

public class YearMonthViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


    public final View parentView;
    public final TextView dayOfMonth;
    private final YearMonthAdapter.OnItemListener onItemListener;

    public YearMonthViewHolder(@NonNull View itemView, YearMonthAdapter.OnItemListener onItemListener) {
        super(itemView);
        parentView = itemView.findViewById(R.id.callendarCellParentView_year);
        dayOfMonth = itemView.findViewById(R.id.cellDayText_year);
        this.onItemListener = onItemListener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        onItemListener.onItemClick(getAdapterPosition(), (String) dayOfMonth.getText());
    }
}
