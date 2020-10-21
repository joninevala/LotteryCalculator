package fi.tuni.tamk.tiko.nevalajoni.util;

import java.io.Console;  

/**
* The class MyConsole contains methods that use the Console.
*
* @author Joni Nevala
*/
public class MyConsole {

    /**
    * Asks the user for an integer within the specified range. Repeats if an invalid input is given.
    * 
    * @param min minimum acceptable value (inclusive).
    * @param max maximum acceptable value (inclusive).
    * @param errorMessageNonNumeric error message shown if user inputs a non-numeric entry.
    * @param errorMessageNonMinAndMax error message shown if user inputs a number outside the specified range.
    * @return the integer entered by the user.
    */
    public static int readIntWithinRange(int min, int max, String errorMessageNonNumeric, String errorMessageNonMinAndMax) {
        Console c = System.console();
        boolean exception = true;
        int input = 0;

        while (exception) {
            exception = false;
            try {
                input = Integer.parseInt(c.readLine());
            } catch(NumberFormatException e) {
                System.out.println(errorMessageNonNumeric);
                exception = true;
            }
            if (!exception && (input < min || input > max)) {
                System.out.println(errorMessageNonMinAndMax);
                exception = true;
            }
        }

        return input;
    }

    /**
    * Asks the user for an integer and repeats if an invalid input is given.
    * @param errorMessageNonNumeric error message shown if user inputs a non-numeric entry.
    * @return the integer entered by the user.
    */
    public static int readInt(String errorMessageNonNumeric) {
        Console c = System.console();
        boolean exception = true;
        int input = 0;

        while (exception) {
            exception = false;
            try {
                input = Integer.parseInt(c.readLine());
            } catch(NumberFormatException e) {
                System.out.println(errorMessageNonNumeric);
                exception = true;
            }
        }

        return input;
    }
}