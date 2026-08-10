package casualtime;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CasualTimeTest {

    @Test
    void sharpSimple() {
        assertEquals("1 o'clock", CasualTime.convertToCasual("01:00"));
        assertEquals("2 o'clock", CasualTime.convertToCasual("02:00"));
        assertEquals("9 o'clock", CasualTime.convertToCasual("09:00"));
        assertEquals("11 o'clock", CasualTime.convertToCasual("11:00"));
        assertEquals("12 o'clock", CasualTime.convertToCasual("12:00"));
    }

    @Test
    void sharp() {
        assertEquals("1 o'clock", CasualTime.convertToCasual("13:00"));
        assertEquals("2 o'clock", CasualTime.convertToCasual("14:00"));
        assertEquals("6 o'clock", CasualTime.convertToCasual("18:00"));
        assertEquals("11 o'clock", CasualTime.convertToCasual("23:00"));
        assertEquals("12 o'clock", CasualTime.convertToCasual("00:00"));
    }

    @Test
    void half() {
        assertEquals("half past 1", CasualTime.convertToCasual("13:30"));
        assertEquals("half past 3", CasualTime.convertToCasual("03:30"));
        assertEquals("half past 5", CasualTime.convertToCasual("17:30"));
    }


}
