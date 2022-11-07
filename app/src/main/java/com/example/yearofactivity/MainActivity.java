package com.example.yearofactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.yearofactivity.ui.YearMonthAdapter;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvm1;
    private RecyclerView rvm2;
    private RecyclerView rvm3;
    private RecyclerView rvm4;
    private RecyclerView rvm5;
    private RecyclerView rvm6;
    private RecyclerView rvm7;
    private RecyclerView rvm8;
    private RecyclerView rvm9;
    private RecyclerView rvm10;
    private RecyclerView rvm11;
    private RecyclerView rvm12;
    public RecyclerView[] tableOfRecyclerViews;
    TextView textViewYear;
    TextView textViewActivityName;
    Button buttonYearPrev;
    Button buttonYearNext;
    Button buttonActivityPrev;
    Button buttonActivityNext;
    public static LocalDate selectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectedDate = LocalDate.now();
        selectedDate =  selectedDate.minusMonths(selectedDate.getMonthValue() - 1);
        //System.out.println(selectedDate);
        rvm1 = findViewById(R.id.recyclerViewYearMonth1);
        rvm2 = findViewById(R.id.recyclerViewYearMonth2);
        rvm3 = findViewById(R.id.recyclerViewYearMonth3);
        rvm4 = findViewById(R.id.recyclerViewYearMonth4);
        rvm5 = findViewById(R.id.recyclerViewYearMonth5);
        rvm6 = findViewById(R.id.recyclerViewYearMonth6);
        rvm7 = findViewById(R.id.recyclerViewYearMonth7);
        rvm8 = findViewById(R.id.recyclerViewYearMonth8);
        rvm9 = findViewById(R.id.recyclerViewYearMonth9);
        rvm10 = findViewById(R.id.recyclerViewYearMonth10);
        rvm11 = findViewById(R.id.recyclerViewYearMonth11);
        rvm12 = findViewById(R.id.recyclerViewYearMonth12);
        textViewYear = findViewById(R.id.textViewYear);
        textViewActivityName = findViewById(R.id.textViewActivityName);
        buttonYearPrev = findViewById(R.id.buttonYearPrev);
        buttonYearNext = findViewById(R.id.buttonYearNext);
        buttonActivityPrev = findViewById(R.id.buttonActivityPrev);
        buttonActivityNext = findViewById(R.id.buttonActivityNext);

        buttonYearPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //System.out.println(selectedDate);
                selectedDate = selectedDate.minusYears(1);
                selectedDate =  selectedDate.minusMonths(selectedDate.getMonthValue() - 1);
                //System.out.println(selectedDate);
                setMonths();
            }
        });

        buttonYearNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(selectedDate);
                selectedDate = selectedDate.plusYears(1);
                selectedDate =  selectedDate.minusMonths(selectedDate.getMonthValue() - 1);
                System.out.println(selectedDate);
                setMonths();
            }
        });

        tableOfRecyclerViews = new RecyclerView[]{rvm1, rvm2, rvm3, rvm4, rvm5, rvm6, rvm7, rvm8, rvm9, rvm10, rvm11, rvm12};

        setMonths();
    }

    private void setMonths() {
        for(int i = 0; i < 12; i++) {
            textViewYear.setText(String.valueOf(selectedDate.getYear()));
            ArrayList<LocalDate> daysInMonth = daysInMonthArray(selectedDate);
            if(selectedDate.getMonthValue() < 12) {
                selectedDate = selectedDate.plusMonths(1);
            }
            YearMonthAdapter yearMonthAdapter = new YearMonthAdapter(daysInMonth, i + 1, selectedDate.getYear(), this::onItemClick);
            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
            tableOfRecyclerViews[i].setLayoutManager(layoutManager);
            tableOfRecyclerViews[i].setAdapter(yearMonthAdapter);
        }
    }

    public void onItemClick(int i, String s) {
        System.out.println("Klikło: " + i + " :: " + s);
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
}