package calc;

import static java.lang.Character.isDigit;

public class Calculator {
    //

//    public static final int MAX_DIGITS= 15; // maximum number of digits in a number
//    public static final int  MAX_DECIMALS = 10;

    public Calculator() {

     }

    /**
     Parses and evaluates a simple expression of the form "x" or "x op y", where "x" and "y" are decimal numbers
     and "op" is "+", "-", "*", or "/". Spaces between or around "x", "y" and "op" are ignored.
     * <p>
     * If "x" or "y" is not a valid number (see {@link #num(String, int)}), the string "invalid number" is returned. If "op" is not one of the operators listed above, the string
     * "invalid operator" is returned.
     */
    public static String evaluate(String expr) {
        // declare variables
        int index;
        int end;
//        int space; // have spacings
//        int d;
        double x;
        double y;
        char op; // operator

        // evaluate
        index= 0;
        end = num(expr,index);
        if(end < 0) return "invalid number";
        x=Double.parseDouble(expr.substring(index, end)  );
        index = fast_forward(expr ,end);

        // index = findSpace(expr, index);
        // a =evaluate(expr,index,a);
        // return a
        if (index == expr.length())     return Double.toString(x);
        op = expr.charAt(index) ;
        index++; // increment index
        index = fast_forward(expr, index);
        end = num(expr, index);;
        if(end < 0)
            return "invalid number";
        y = Double.parseDouble(expr.substring(index,end));
        switch (op) {
        case '+' -> {
                return Double.toString(x + y);
            }
        case'-' -> {
                return Double.toString(x - y);
            }
        case'*' -> {
            return Double.toString(x * y);
        }
            case '/' ->
             {
                    return "" + y / x;
             }
            default -> { return
                         "invalid operator"; }
        }
    }


//    private static int findSpace(String s) {
//        int i = 0;
//        while (true) {
//          char c;
//          if(i<s.length()) {
//              c = s.charAt(i);
//          }else
//              c=0;
//
//            if (!(c == 32)) break;
//            i++;
//        }
//        ;
//        return i;
//    }


    /**
     * @return The index of the first character in 's' that comes after the 'start' index and is not a space.
     */
    private static int fast_forward(String s,int start) {
        int index=start;
        while(charfinder(s,index)==32){
           index ++;
        }

        return index;       // return resulting index
    }
    /**
     * Finds the end of a number in 's', starting at
     * the index 'start'. A number may (in this order) contain: a single minus, zero or more digits, a
     * decimal point, and again zero or more digits. There must be at least one
     * digit, before or after the decimal point.
     * @return The index right after the end of the found number (so it can be used for {@link String#substring(int, int)})
     */
    private static int num(String s, int start) {


        int index = start;
//        int end = 0;

        boolean check = false; // initialize
        if(charfinder(s, index) == '-') index++;
        while(isDigit(charfinder(s, index))) {
            index++;
                check = false; // set check to false
        }
        if (charfinder(s, index) == 46) {
            index++;
            while (isDigit(charfinder(s, index)))
               index++;
              check = false;
        }
        // if check is false, return index, otherwize -1
        if (!check)
            return index;

        else return -1;
    }




    private static char charfinder(String s, int index) {
        // check, if index is smaller then length
        if(index <s.length()) {
            return  s.charAt(index);
            } else
            return '\0';


     }


}
