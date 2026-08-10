package wordwrap;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WordWrapperTest {

    @Test
    void wrapEmptyStringReturnsEmptyString() {
        WordWrapper wordWrapper = new WordWrapper(20);
        var wrapped = wordWrapper.wrap("");
        assertEquals("", wrapped);

    }

    @Test
    void wrapShortTextReturnsTextUnchanged() {
        var wordWrapper = new WordWrapper(20);
        var wrapped = wordWrapper.wrap("Kurzer Text");
        assertEquals("Kurzer Text", wrapped);
    }
    @Test
    void wrapLongTextBreaksAtLineLimit() {
        var wordWrapper = new WordWrapper(20);
        var text = "Dies ist ein Text, der umgebrochen werden soll.";
        var wrapped = wordWrapper.wrap(text);
        var expected = """
            Dies ist ein Text,
            der umgebrochen
            werden soll.""";
        assertEquals(expected, wrapped);
    }

    @Test
    void wrapEliminatesExtraWhitespaceAndNewlines() {
        var wordWrapper = new WordWrapper(20);
        var text = "Ein     kurzer\n Text mit nur    einem\nUmbruch";
        var wrapped = wordWrapper.wrap(text);
        var expected = """
            Ein kurzer Text mit
            nur einem Umbruch""";
        assertEquals(expected, wrapped);
    }
    @Test
    void wrapRespectsDifferentLineLimit() {
        var wordWrapper = new WordWrapper(15);
        var text = "Dies ist ein Text, der umgebrochen werden soll.";
        var wrapped = wordWrapper.wrap(text);
        var expected = """
            Dies ist ein
            Text, der
            umgebrochen
            werden soll.""";
        assertEquals(expected, wrapped);
    }
}
