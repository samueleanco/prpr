package wordwrap;

import java.util.Scanner;

public class WordWrapper {
    int limit;

    public WordWrapper(int limit) {
        this.limit = limit;
    }

    public String wrap(String text) {
        Scanner scanner = new Scanner(text);
        StringBuilder result = new StringBuilder();
        StringBuilder currentLine = new StringBuilder();

        while (scanner.hasNext()) {
            String word = scanner.next();
            int extra = !currentLine.isEmpty() ? 1 : 0;

            if (currentLine.length() + extra + word.length() <= limit) {
                if (extra == 1) {
                    currentLine.append(" ");
                }
                currentLine.append(word);
            } else {
                if (!result.isEmpty()) {
                    result.append("\n");
                }
                result.append(currentLine);
                currentLine = new StringBuilder(word);
            }
        }

        if (!currentLine.isEmpty()) {
            if (!result.isEmpty()) {
                result.append("\n");
            }
            result.append(currentLine);
        }

        return result.toString();
    }

}
