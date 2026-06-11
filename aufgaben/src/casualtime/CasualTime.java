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

        return "TODO";
    }
}
