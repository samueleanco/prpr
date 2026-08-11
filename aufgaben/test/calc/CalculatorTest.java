package calc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    @Test
    void nonNegativeInt() {
        assertEquals("0.0", Calculator.evaluate("0"));
        assertEquals("1.0", Calculator.evaluate("1"));
        assertEquals("42.0", Calculator.evaluate("42"));
    }

    @Test
    void nonNegativeDecimal() {
        assertEquals("0.0", Calculator.evaluate("0.0"));
        assertEquals("0.0", Calculator.evaluate("0."));
        assertEquals("0.0", Calculator.evaluate(".0"));
        assertEquals("1.0", Calculator.evaluate("1.0"));
        assertEquals("42.5", Calculator.evaluate("42.5"));
    }

    @Test
    void negativeNumbers() {
        assertEquals("-0.0", Calculator.evaluate("-0"));
        assertEquals("-0.0", Calculator.evaluate("-0.0"));
        assertEquals("-3.0", Calculator.evaluate("-3"));
        assertEquals("-378.12", Calculator.evaluate("-378.12"));
    }

    @Test
    void addition() {
        assertEquals("2.0", Calculator.evaluate("1+1"));
        assertEquals("0.0", Calculator.evaluate("-1.0+1.0"));
        assertEquals("-1.0", Calculator.evaluate("-2.0+1"));
        assertEquals("1.5", Calculator.evaluate("2.0+-0.5"));
        assertEquals("-4.0", Calculator.evaluate("-2+-2") );
    }

    @Test
    void subtraction() {
        assertEquals("-1.0", Calculator.evaluate("1-2"));
        assertEquals("-3.0", Calculator.evaluate("-2.0-1.0"));
        assertEquals("-1.5", Calculator.evaluate("-0.5-1"));
        assertEquals("2.5", Calculator.evaluate("2.0--0.5"));
    }

    @Test
    void multiplication() {
        assertEquals("15.0", Calculator.evaluate("3*5"));
        assertEquals("-2.25", Calculator.evaluate("-4.5*0.5"));
    }

    @Test
    void division() {
        assertEquals("1.0", Calculator.evaluate("5/5"));
        assertEquals("-1.0", Calculator.evaluate("2.5/-2.5"));
    }

    @Test
    void spaces() {
        assertEquals("13.0", Calculator.evaluate("13  "));
        assertEquals("8.0", Calculator.evaluate("3 + 5"));
        assertEquals("4.0", Calculator.evaluate("1- -3"));
        assertEquals("-0.625", Calculator.evaluate("1.25  *-0.5"));
    }

    @Test
    void invalidOperator() {
        assertEquals("invalid operator", Calculator.evaluate("1 # 2"));
    }
}
