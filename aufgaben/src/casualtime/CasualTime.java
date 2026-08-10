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
            if (hour == 0) {
                return 12 + " o'clock";
            }
            if(hour > 12) {
                return hour-12 + " o'clock";
            }
            return hour + " o'clock";
        } else if (minutes == 30) {
            if (hour == 0) {
                return "half past " + hour;
            }
            if(hour > 12) {
                hour -=12;
                return "half past " + hour;
            }
            return "half past " + hour;

        }
        return "";
    }
}
