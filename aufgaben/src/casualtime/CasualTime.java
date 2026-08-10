package casualtime;

import java.util.Scanner;

public class CasualTime {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.println("Enter a time in HH:MM format (or 'quit'):");

        System.out.print("> ");
        var input = scanner.nextLine();

        while (!input.equals("quit")) {
            var casual = convertToCasual(input);
            System.out.println("It's " + casual + ".");

            System.out.print("> ");
            input = scanner.nextLine();
        }
    }

    public static String convertToCasual(String formal) {
        // TODO: Zeitangabe in Parameter 'formal' in Stunde und Minute
        //  aufteilen und anschliessend in Umgangssprache umwandeln.
        //  Tipp: Methoden 'split' von String und 'Integer.parseInt'.
        String[] time = formal.split(":");
        int hour = Integer.parseInt(time[0]);
        int minutes = Integer.parseInt(time[1]);
        if (minutes == 0) {
            return hourFormat(hour) + " o'clock";
        } else if (minutes == 30) {
            return "half past " + hourFormat(hour);
        } else if (minutes == 20) {
            return "20 past "+ hourFormat(hour);
        }
        return 60-minutes + " minutes to " + (hourFormat(hour)+1);
    }
    public static Integer hourFormat (int hour) {
        if (hour == 0) return 12;
        else if (hour > 12) return hour-12;
        return hour;
    }

}
