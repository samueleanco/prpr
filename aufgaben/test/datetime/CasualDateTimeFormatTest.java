package datetime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CasualDateTimeFormatTest {

    private CasualDateTimeFormat formatter;

    @BeforeEach
    void setUp() {
        formatter = new CasualDateTimeFormat();
    }

    // formatDate — Jahr 2000–2099: zweistellig mit '

    @Test
    void formatDate_yearIn21stCentury() {
        assertEquals("24. Juni '24", formatter.formatDate(2024, 6, 24));
    }

    @Test
    void formatDate_yearExactly2000() {
        assertEquals("1. Januar '00", formatter.formatDate(2000, 1, 1));
    }

    @Test
    void formatDate_yearExactly2099() {
        assertEquals("31. Dezember '99", formatter.formatDate(2099, 12, 31));
    }

    @Test
    void formatDate_yearBefore2000_allDigits() {
        assertEquals("1. September 1999", formatter.formatDate(1999, 9, 1));
    }

    @Test
    void formatDate_yearAfter2099_allDigits() {
        assertEquals("1. Januar 2100", formatter.formatDate(2100, 1, 1));
    }

    @Test
    void formatDate_ancientYear() {
        assertEquals("1. März 925", formatter.formatDate(925, 3, 1));
    }

    @Test
    void formatDate_dayWithoutLeadingZero() {
        assertEquals("3. Juli '24", formatter.formatDate(2024, 7, 3));
    }

    // formatTime

    @Test
    void formatTime_fullHour() {
        assertEquals("9 Uhr", formatter.formatTime(9, 0));
    }

    @Test
    void formatTime_withMinutes() {
        assertEquals("14 Uhr 30", formatter.formatTime(14, 30));
    }

    @Test
    void formatTime_midnight() {
        assertEquals("0 Uhr", formatter.formatTime(0, 0));
    }

    @Test
    void formatTime_minutesFive() {
        assertEquals("8 Uhr 05", formatter.formatTime(8, 5));
    }
}