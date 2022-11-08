package com.example.yearofactivity.ui.day;

import java.time.LocalDate;
import java.util.ArrayList;

public class ChosenDay {

    private static int dayNr = 1;
    private static int monthNr = 1;
    private static int yearNr = 2000;
    private static final ChosenDay chosenDay = new ChosenDay();
    private static ArrayList<String> months;
    private static LocalDate date;
    private static String dayName;

    public ChosenDay() {
        ChosenDay.months = new ArrayList<>();
        ChosenDay.months.add("Styczeń");
        ChosenDay.months.add("Luty");
        ChosenDay.months.add("Marzec");
        ChosenDay.months.add("Kwiecień");
        ChosenDay.months.add("Maj");
        ChosenDay.months.add("Czerwiec");
        ChosenDay.months.add("Lipiec");
        ChosenDay.months.add("Sierpień");
        ChosenDay.months.add("Wrzesień");
        ChosenDay.months.add("Październik");
        ChosenDay.months.add("Listopad");
        ChosenDay.months.add("Grudzień");
    }

    public static int getDayNr() {
        return ChosenDay.dayNr;
    }

    public static int getMonthNr() {
        return ChosenDay.monthNr;
    }

    public static int getYearNr() {
        return ChosenDay.yearNr;
    }

    public static String getMonthName() {
        return months.get(monthNr - 1);
    }


    public static ChosenDay getChosenDay() {
        return ChosenDay.chosenDay;
    }

    public static void setChosenDay(int dayNr, int monthNr, int yearNr) {
        ChosenDay.dayNr = dayNr;
        ChosenDay.monthNr = monthNr;
        ChosenDay.yearNr = yearNr;
        date = LocalDate.of(yearNr, monthNr, dayNr);
        switch (date.getDayOfWeek()) {
            case MONDAY:
                ChosenDay.dayName = "Poniedziałek";
                break;
            case TUESDAY:
                ChosenDay.dayName = "Wtorek";
                break;
            case WEDNESDAY:
                ChosenDay.dayName = "Środa";
                break;
            case THURSDAY:
                ChosenDay.dayName = "Czwartek";
                break;
            case FRIDAY:
                ChosenDay.dayName = "Piątek";
                break;
            case SATURDAY:
                ChosenDay.dayName = "Sobota";
                break;
            case SUNDAY:
                ChosenDay.dayName = "Niedziela";
                break;
        }
    }

    public static void setChosenDayMonth(int monthNr) {
        setChosenDay(ChosenDay.getDayNr(), monthNr, ChosenDay.getYearNr());
        System.out.println(ChosenDay.getMonthName());
    }

    public static String getDayName() {
        return dayName;
    }

    public static LocalDate getDate() {
        return ChosenDay.date;
    }
}
