package datetime;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextFormatter {
    private final DateTimeFormat format;

    public TextFormatter(DateTimeFormat format) {
        this.format = format;
    }

    public String format(String text) {
        Scanner scanner = new Scanner(text);
        StringBuilder result = new StringBuilder();

        while (scanner.hasNext()) {
            String token = scanner.next();
            if (token.equals("${")) {
                List<Integer> numbers = new ArrayList<>();
                while (scanner.hasNextInt()) {
                    numbers.add(scanner.nextInt());
                }
                String closing = scanner.next();
                if (numbers.size() == 3) {
                    result.append(format.formatDate(numbers.get(0),numbers.get(1), numbers.get(2)));
                } else {
                    result.append(format.formatTime(numbers.get(0), numbers.get(1)));
                }
                result.append(closing.substring(1));

            } else {
                result.append(token);
            }
            result.append(" ");
        }

        return result.toString().trim();
    }
}

