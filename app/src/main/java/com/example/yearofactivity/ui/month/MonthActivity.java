package com.example.yearofactivity.ui.month;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yearofactivity.R;
import com.example.yearofactivity.ui.day.ChosenDay;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MonthActivity extends AppCompatActivity {

    private RecyclerView recyclerViewMonth;
    public static LocalDate selectedDate;
    private TextView textViewMonthName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month);

        recyclerViewMonth = findViewById(R.id.recyclerViewMonth);
        textViewMonthName = findViewById(R.id.textViewMonthName);
        selectedDate = ChosenDay.getDate();

        setMonthView();
    }

    private void setMonthView() {
        textViewMonthName.setText(ChosenDay.getMonthName());
        ArrayList<LocalDate> daysInMonth = daysInMonthArray(selectedDate);

        MonthAdapter monthAdapter = new MonthAdapter(daysInMonth, this::onItemClick);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager( getApplicationContext(), 7);
        recyclerViewMonth.setLayoutManager(layoutManager);
        recyclerViewMonth.setAdapter(monthAdapter);
    }

    private ArrayList<LocalDate> daysInMonthArray(LocalDate date) {
        ArrayList<LocalDate> daysInMonthArray = new ArrayList<>();
        YearMonth yearMonth = YearMonth.from(date);
        int daysInMonth = yearMonth.lengthOfMonth();
        LocalDate firstDayOfMonth = selectedDate.withDayOfMonth(1);
        int dayOfWeek = firstDayOfMonth.getDayOfWeek().getValue() - 1;

        for(int i = 1; i <= 42; i++) {
            if(i <= dayOfWeek || i > daysInMonth + dayOfWeek) {
                daysInMonthArray.add(null); //poza miesiącem
            } else {
                daysInMonthArray.add(LocalDate.of(selectedDate.getYear(), selectedDate.getMonth(), i - dayOfWeek));
            }
        }

        return daysInMonthArray;
    }

    private String monthFromDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM");
        return date.format(formatter);
    }
    private String yearFromDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
        return date.format(formatter);
    }

    public void onItemClick(int position, String dayText) {
        if(!dayText.equals("")) {
            String message = "Selected date: " + dayText + " " + monthFromDate(selectedDate) + " " + yearFromDate(selectedDate);
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
            ChosenDay.setChosenDay(Integer.parseInt(dayText), selectedDate.getMonthValue(), selectedDate.getYear());
            System.out.println(dayText + " " + selectedDate.getMonthValue() + " " + selectedDate.getYear());
            setMonthView();
        }
    }


}
