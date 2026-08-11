package datetime;

public class FormalDateTimeFormat implements DateTimeFormat{
    @Override
    public String formatDate(int year, int month, int day) {
        if (day <10) {
            if (month < 10) {
                return "0"+ day + "." + "0"+ month +"." + year;
            }
            return "0"+ day + "." + month +"." + year;
        } else if (month < 10) return day + "." + "0" + month +"." + year;
        return day + "." + month +"." + year;
    }

    @Override
    public String formatTime(int hour, int minute) {
        if (hour < 10) {
            if (minute < 10) {
                return "0"+ hour + ":" + "0"+ minute;
            }
            return "0"+ hour + ":" + minute;
        }
        return hour + ":" + minute;
    }
}
