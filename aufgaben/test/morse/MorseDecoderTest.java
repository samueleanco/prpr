package morse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MorseDecoderTest {

    @Test
    void letters() {
        MorseDecoder decoder = new MorseDecoder();
        assertEquals("E", decoder.decode("."));
        assertEquals("T", decoder.decode("-"));
        assertEquals("I", decoder.decode(".."));
        assertEquals("A", decoder.decode(".-"));
        assertEquals("N", decoder.decode("-."));
        assertEquals("M", decoder.decode("--"));
        assertEquals("S", decoder.decode("..."));
        assertEquals("U", decoder.decode("..-"));
        assertEquals("R", decoder.decode(".-."));
        assertEquals("W", decoder.decode(".--"));
        assertEquals("D", decoder.decode("-.."));
        assertEquals("K", decoder.decode("-.-"));
        assertEquals("G", decoder.decode("--."));
        assertEquals("O", decoder.decode("---"));
        assertEquals("H", decoder.decode("...."));
        assertEquals("V", decoder.decode("...-"));
        assertEquals("F", decoder.decode("..-."));
        assertEquals("L", decoder.decode(".-.."));
        assertEquals("P", decoder.decode(".--."));
        assertEquals("J", decoder.decode(".---"));
        assertEquals("B", decoder.decode("-..."));
        assertEquals("X", decoder.decode("-..-"));
        assertEquals("C", decoder.decode("-.-."));
        assertEquals("Y", decoder.decode("-.--"));
        assertEquals("Z", decoder.decode("--.."));
        assertEquals("Q", decoder.decode("--.-"));
    }

    @Test
    void numbers() {
        MorseDecoder decoder = new MorseDecoder();
        assertEquals("1", decoder.decode(".----"));
        assertEquals("2", decoder.decode("..---"));
        assertEquals("3", decoder.decode("...--"));
        assertEquals("4", decoder.decode("....-"));
        assertEquals("5", decoder.decode("....."));
        assertEquals("6", decoder.decode("-...."));
        assertEquals("7", decoder.decode("--..."));
        assertEquals("8", decoder.decode("---.."));
        assertEquals("9", decoder.decode("----."));
        assertEquals("0", decoder.decode("-----"));
    }

    @Test
    void specialLetters() {
        MorseDecoder decoder = new MorseDecoder();
        assertEquals("Ä", decoder.decode(".-.-"));
        assertEquals("Ö", decoder.decode("---."));
        assertEquals("Ü", decoder.decode("..--"));
        assertEquals("CH", decoder.decode("----"));
    }

    @Test
    void singleWords() {
        MorseDecoder decoder = new MorseDecoder();
        assertEquals("JAVA", decoder.decode(".--- .- ...- .-"));
        assertEquals("PRPR", decoder.decode(".--. .-. .--. .-."));
        assertEquals("FHNW", decoder.decode("..-. .... -. .--"));
        assertEquals("WINDISCH", decoder.decode(".-- .. -. -.. .. ... -.-. ...."));
        assertEquals("WINDISCH", decoder.decode(".-- .. -. -.. .. ... ----"));
    }

    @Test
    void multipleWords() {
        MorseDecoder decoder = new MorseDecoder();
        assertEquals("GUTEN MORGEN",
                decoder.decode("--. ..- - . -.  -- --- .-. --. . -."));
        assertEquals("ICH MAG JAVA",
                decoder.decode(".. -.-. ....  -- .- --.  .--- .- ...- .-"));
        assertEquals("DAS IST EIN TEST",
                decoder.decode("-.. .- ...  .. ... -  . .. -.  - . ... -"));
    }
}
