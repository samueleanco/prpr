package datetime;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TextFormatterTest {

    private final DateTimeFormat formal = new FormalDateTimeFormat();
    private final DateTimeFormat casual = new CasualDateTimeFormat();

    // Datum-Platzhalter

    @Test
    void format_singleDate_formal() {
        var formatter = new TextFormatter(formal);
        assertEquals("Am 24.06.2024 findet das Kickoff statt.",
                formatter.format("Am ${ 2024 06 24 } findet das Kickoff statt."));
    }

    @Test
    void format_singleDate_casual() {
        var formatter = new TextFormatter(casual);
        assertEquals("Am 24. Juni '24 findet das Kickoff statt.",
                formatter.format("Am ${ 2024 06 24 } findet das Kickoff statt."));
    }

    // Zeit-Platzhalter

    @Test
    void format_singleTime_formal() {
        var formatter = new TextFormatter(formal);
        assertEquals("Es beginnt um 09:00.",
                formatter.format("Es beginnt um ${ 09 00 }."));
    }

    @Test
    void format_singleTime_casual() {
        var formatter = new TextFormatter(casual);
        assertEquals("Es beginnt um 9 Uhr.",
                formatter.format("Es beginnt um ${ 09 00 }."));
    }

    // Mehrere Platzhalter im selben Text

    @Test
    void format_multipleTokens_formal() {
        var formatter = new TextFormatter(formal);
        var input = "Am ${ 2024 06 24 } beginnt es um ${ 09 00 } und endet um ${ 14 30 }.";
        var expected = "Am 24.06.2024 beginnt es um 09:00 und endet um 14:30.";
        assertEquals(expected, formatter.format(input));
    }

    @Test
    void format_multipleTokens_casual() {
        var formatter = new TextFormatter(casual);
        var input = "Am ${ 2024 06 24 } beginnt es um ${ 09 00 } und endet um ${ 14 30 }.";
        var expected = "Am 24. Juni '24 beginnt es um 9 Uhr und endet um 14 Uhr 30.";
        assertEquals(expected, formatter.format(input));
    }

    // Vollständiger Beispieltext aus der Aufgabe

    @Test
    void format_fullExampleText_formal() {
        var formatter = new TextFormatter(formal);
        var input = "Am ${ 2024 06 24 } findet das Kickoff statt. Es beginnt um ${ 09 00 } und dauert bis ${ 14 30 }. Die Abgabefrist ist am ${ 2024 09 01 }.";
        var expected = "Am 24.06.2024 findet das Kickoff statt. Es beginnt um 09:00 und dauert bis 14:30. Die Abgabefrist ist am 01.09.2024.";
        assertEquals(expected, formatter.format(input));
    }

    @Test
    void format_fullExampleText_casual() {
        var formatter = new TextFormatter(casual);
        var input = "Am ${ 2024 06 24 } findet das Kickoff statt. Es beginnt um ${ 09 00 } und dauert bis ${ 14 30 }. Die Abgabefrist ist am ${ 2024 09 01 }.";
        var expected = "Am 24. Juni '24 findet das Kickoff statt. Es beginnt um 9 Uhr und dauert bis 14 Uhr 30. Die Abgabefrist ist am 1. September '24.";
        assertEquals(expected, formatter.format(input));
    }

    // Text ohne Platzhalter bleibt unverändert

    @Test
    void format_noPlaceholders() {
        var formatter = new TextFormatter(formal);
        assertEquals("Kein Platzhalter hier.", formatter.format("Kein Platzhalter hier."));
    }

    // Leerer Text

    @Test
    void format_emptyString() {
        var formatter = new TextFormatter(formal);
        assertEquals("", formatter.format(""));
    }
}