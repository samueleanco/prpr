package morse;

import java.util.Scanner;

public class MorseDecoderApp {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var decoder = new MorseDecoder();

        System.out.print("Enter Morse code (using '.', '-', and ' '): ");
        var code = scanner.nextLine();

        if (!code.matches("[ .-]+")) {
            System.out.println("\nInvalid Morse code");
        } else {
            var text = decoder.decode(code);
            System.out.println("\n" + text);
        }
    }
}
