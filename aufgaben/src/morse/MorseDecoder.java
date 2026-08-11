package morse;

public class MorseDecoder {
    public MorseDecoder () {
        // Buchstaben
        insert(".-", "A");
        insert("-...", "B");
        insert("-.-.", "C");
        insert("-..", "D");
        insert(".", "E");
        insert("..-.", "F");
        insert("--.", "G");
        insert("....", "H");
        insert("..", "I");
        insert(".---", "J");
        insert("-.-", "K");
        insert(".-..", "L");
        insert("--", "M");
        insert("-.", "N");
        insert("---", "O");
        insert(".--.", "P");
        insert("--.-", "Q");
        insert(".-.", "R");
        insert("...", "S");
        insert("-", "T");
        insert("..-", "U");
        insert("...-", "V");
        insert(".--", "W");
        insert("-..-", "X");
        insert("-.--", "Y");
        insert("--..", "Z");

        // Zahlen
        insert("-----", "0");
        insert(".----", "1");
        insert("..---", "2");
        insert("...--", "3");
        insert("....-", "4");
        insert(".....", "5");
        insert("-....", "6");
        insert("--...", "7");
        insert("---..", "8");
        insert("----.", "9");

        // Spezialfall: CH als eigener Digraph
        insert("----", "CH");
        // Sonderzeichen
        insert(".-.-", "Ä");
        insert("---.", "Ö");
        insert("..--", "Ü");
    }

    node root = new node();



    public String decode(String code) {
        String[] parts = code.split(" ");
        StringBuilder result = new StringBuilder();

        for (String part : parts) {
            if (part.isEmpty()) result.append(" ");
            else {


                node current = root;
                for (int i = 0; i < part.length(); i++) {
                    char c = part.charAt(i);
                    if (c == ' ') result.append(" ");
                    else if (c == '.') {
                        current = current.dot;

                    } else {
                        current = current.dash;
                    }


                }
                result.append(current.letter);
            }
        }
        return result.toString();
    }

    public void insert (String code, String letter) {
        node current = root;
        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);
            if (c == '.') {
                if (current.dot == null) {
                    current.dot = new node();
                }
                current = current.dot;
            } else  {
                if(current.dash == null) {
                    current.dash = new node();
                }
                current = current.dash;

            }


        }
        current.letter = letter;
    }

//    public String decodeRec(String code, int position) {
//        if ()
//    }
}
