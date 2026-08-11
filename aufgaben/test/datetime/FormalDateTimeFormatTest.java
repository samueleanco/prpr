package datetime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FormalDateTimeFormatTest {

    private FormalDateTimeFormat formatter;

    @BeforeEach
    void setUp() {
        formatter = new FormalDateTimeFormat();
    }

    // formatDate

    @Test
    void formatDate_standard() {
        assertEquals("24.06.2024", formatter.formatDate(2024, 6, 24));
    }

    @Test
    void formatDate_paddingDayAndMonth() {
        assertEquals("01.09.2024", formatter.formatDate(2024, 9, 1));
    }

    @Test
    void formatDate_january() {
        assertEquals("01.01.2000", formatter.formatDate(2000, 1, 1));
    }

    @Test
    void formatDate_december() {
        assertEquals("31.12.1999", formatter.formatDate(1999, 12, 31));
    }

    // formatTime

    @Test
    void formatTime_standard() {
        assertEquals("09:00", formatter.formatTime(9, 0));
    }

    @Test
    void formatTime_afternoon() {
        assertEquals("14:30", formatter.formatTime(14, 30));
    }

    @Test
    void formatTime_midnight() {
        assertEquals("00:00", formatter.formatTime(0, 0));
    }

    @Test
    void formatTime_paddingMinutes() {
        assertEquals("08:05", formatter.formatTime(8, 5));
    }
}