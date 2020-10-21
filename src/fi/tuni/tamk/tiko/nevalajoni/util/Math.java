package fi.tuni.tamk.tiko.nevalajoni.util;

/**
* The class Math contains methods for performing basic math functions
*
* @author Joni Nevala
*/
public class Math {

    /**
    * Returns a random integer between the minimum and maximum parameters.
    * 
    * @param min the minimum value returned.
    * @param max the maximum value returned.
    * @return a random value between the min and max parameters.
    */
    public static int getRandom(int min, int max) {
        return min + (int) (java.lang.Math.random() * ((max - min) + 1));
    }
}