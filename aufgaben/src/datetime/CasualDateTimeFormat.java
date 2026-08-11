package datetime;

import datetime.DateTimeFormat;

public class CasualDateTimeFormat implements DateTimeFormat {

    String[] monatsnamen = {"Januar", "Februar", "März", "April", "Mai", "Juni",
            "Juli", "August", "September", "Oktober", "November", "Dezember"};

    @Override
    public String formatDate(int year, int month, int day) {
        String name = monatsnamen[month - 1];
        if (year <= 2099 && year >=2000) {
            return day + ". " + name + " "+  "'" + String.format("%02d", year % 100);
        }
        return day + ". " + name + " " + year;
    }

    @Override
    public String formatTime(int hour, int minute) {
        if (minute == 0) return hour + " Uhr";
        else if (minute < 10) return hour + " Uhr 0" + minute;
        return hour + " Uhr " + minute;
    }
}