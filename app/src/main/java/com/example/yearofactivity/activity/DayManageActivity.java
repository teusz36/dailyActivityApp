package com.example.yearofactivity.activity;

import androidx.appcompat.app.AppCompatActivity;
import com.example.yearofactivity.R;
import com.example.yearofactivity.ui.day.ChosenDay;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DayManageActivity extends AppCompatActivity {

    private TextView textViewDate;
    private TextView textViewDayActivity;
    private EditText editTextActivityAdd;
    private EditText editTextActivitySet;
    private Button buttonActivityAdd;
    private Button buttonActivitySet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_manage);

        textViewDate = findViewById(R.id.textViewDate);
        textViewDayActivity = findViewById(R.id.textViewDayActivity);
        editTextActivityAdd = findViewById(R.id.editTextActivityAdd);
        editTextActivitySet = findViewById(R.id.editTextActivitySet);
        buttonActivityAdd = findViewById(R.id.buttonActivityAdd);
        buttonActivitySet = findViewById(R.id.buttonActivitySet);

        textViewDate.setText(ChosenDay.getDayNr() + " " + ChosenDay.getMonthName() + " " + ChosenDay.getYearNr());

        buttonActivityAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!editTextActivityAdd.getText().toString().equals("")) {
                    float currentNumber = Float.parseFloat(textViewDayActivity.getText().toString());
                    float numberToAdd = Float.parseFloat(editTextActivityAdd.getText().toString());
                    float newNumber = currentNumber + numberToAdd;
                    textViewDayActivity.setText(String.valueOf(newNumber));
                }
            }
        });

        buttonActivitySet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTextActivitySet.getText().toString().equals("")) {
                    textViewDayActivity.setText("0");
                } else {
                    textViewDayActivity.setText(editTextActivitySet.getText().toString());
                }
            }
        });
    }
}