package fi.tuni.tamk.tiko.nevalajoni;

import fi.tuni.tamk.tiko.nevalajoni.util.Math;
import fi.tuni.tamk.tiko.nevalajoni.util.Arrays;
import fi.tuni.tamk.tiko.nevalajoni.util.MyConsole;


/**
* The class Main contains the lotto app
*
* @author Joni Nevala
*/
public class Main {
    
    static int timeElapsed = 0;
    static int[] winTimes;

    public static void main(String [] args) {

        int min = 1;
        int max = 40;
        int amount = 7;

        amount = chooseSettings("ticket");
        max = chooseSettings("range");
        winTimes = new int[amount+1];

        boolean win = false;
        int[] userNumbers = getUserNumbers(min, max, amount);

        while (!win) {
            int[] lottoNumbers = calculateLotto(min, max, amount);
            win = calculateWin(Arrays.containsSameValues(userNumbers, lottoNumbers), amount);
        }
    }

    /**
    * Sets the number of winning numbers and the range of numbers to draw from.
    * 
    * @param setting the setting that is to be modified.
    * @return the value chosen by the user.
    */
    public static int chooseSettings(String setting) {
        boolean ok = false;
        int value = 0;
        while (!ok) {
            if (setting == "ticket") {
                System.out.print("Choose the number of winning numbers (7 or 9): ");
                value = MyConsole.readInt("Error: Non-number entered.");

                if (value == 7 || value == 9) {
                    ok = true;
                }
            }
            if (setting == "range") {
                System.out.print("Choose the range of numbers to draw the winning numbers from (40 or 80): ");
                value = MyConsole.readInt("Error: Non-number entered.");

                if (value == 40 || value == 80) {
                    ok = true;
                }
            }
        }

        return value;
    }

    /**
    * Asks the user to input a specified amount of numbers, between the minimum and maximum parameters. The numbers submitted are added into an array, which is returned.
    * 
    * @param minimum minimum value for the numbers submitted (inclusive).
    * @param maximum maximum value for the numbers submitted (inclusive).
    * @param nums how many numbers the user has to submit.
    * @return array of the numbers submitted.
    */
    public static int[] getUserNumbers(int minimum, int maximum, int nums) {
        int[] userNumbers = new int[nums];
        int numbersEntered = 0;
        while (numbersEntered < nums) {
            System.out.print("Please give a unique number between " + minimum + " and " + maximum + ": ");
            int input = MyConsole.readIntWithinRange(minimum, maximum, "Error: Non-number entered.", "Error: Value entered out of range.");
            if (!Arrays.contains(input, userNumbers)) {
                userNumbers[numbersEntered] = input;
                numbersEntered++;
            }
            else {
                System.out.println("Error: Number already entered.");
            }
        }

        return userNumbers;
    }

    /**
    * Calculates a specified amount of random numbers between the minimum and maximum parameters and returns them in an array.
    * 
    * @param minimum minimum value for the numbers submitted (inclusive).
    * @param maximum maximum value for the numbers submitted (inclusive).
    * @param nums how many numbers the user has to submit.
    * @return array containing the random numbers.
    */
    public static int[] calculateLotto(int minimum, int maximum, int nums) {
        int[] numbers = new int[maximum];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        
        int[] lottoNumbers = new int[nums];

        for (int i = 0; i < nums; i++) {
            int randomNumber = Math.getRandom(minimum - 1, maximum - i - 1);
            lottoNumbers[i] = numbers[randomNumber];
            numbers = Arrays.removeIndex(randomNumber, numbers);
        }

        return lottoNumbers;
    }

    /**
    * Checks how many numbers the user has entered correctly this round. The time elapsed for each amount of correct numbers is placed into an array and printed.
    * If all of the numbers are correct, returns true and allows the program to stop repeating.
    * 
    * @param correctNumbers the amount of correct numbers.
    * @param nums the amount of numbers the game is played with, i.e. the amount of correct numbers required for a jackpot.
    * @return returns true if the user has a jackpot. Otherwise, returns false.
    */
    public static boolean calculateWin(int correctNumbers, int nums) {
        timeElapsed++;
        boolean jackpot = false;
        for (int i = 0; i <= nums; i++) {
            if (correctNumbers == i && winTimes[i] == 0) {
                for (int j = 0; j <= correctNumbers; j++) {
                    if (winTimes[j] == 0) {
                        winTimes[j] = timeElapsed;
                        System.out.println("Got " + j + " right! It took you " + timeElapsed / 52 + " years and " + timeElapsed % 52 + " weeks.");
                    }
                }
            }
            if (winTimes[nums] != 0) {
                jackpot = true;
            }
        }
        return jackpot;
    }
}