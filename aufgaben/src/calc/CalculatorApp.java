package calc;

import java.util.Scanner;

public class CalculatorApp {

    public static void main(String[] args) {
        System.out.println("""
                Enter simple arithmetic expressions to calculate the result.
                
                Examples:
                    1 + 2
                    25 * 3.1415
                    -42.1 - -0.2
                """);

        var scanner = new Scanner(System.in);

        System.out.print("calc> ");
        var line = scanner.nextLine();
        while (!line.equals("exit")) {
            var result = Calculator.evaluate(line);
            System.out.println(result);

            System.out.print("\ncalc> ");
            line = scanner.nextLine();
        }
    }
}
