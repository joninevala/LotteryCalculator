package fi.tuni.tamk.tiko.nevalajoni.util;

/**
* The class Arrays contains methods for performing basic tasks with arrays
*
* @author Joni Nevala
*/
public class Arrays {

    /**
    * Converts a string array into an integer array.
    * 
    * @param array the original string array.
    * @return an integer array with values copied from the string array given as a parameter.
    */
    public static int [] toIntArray(String [] array) {
        int[] intArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            intArray[i] = Integer.parseInt(array[i]);
        }

        return intArray;
    }

    /**
    * Checks if an integer array contains a given value and returns it as boolean.
    * 
    * @param value the value the array is checked for.
    * @param array the array the check is performed on.
    * @return returns whether the value is found within the array.
    */
    public static boolean contains(int value, int [] array) {
        boolean contains = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                contains = true;
            }
        }

        return contains;
    }

    /**
    * Checks how many identical entries the two given arrays contain.
    * 
    * @param array1 one of the arrays checked.
    * @param array2 the other array.
    * @return the number of identical entries between the two arrays.
    */
    public static int containsSameValues(int [] array1, int [] array2) {
        int sameValues = 0;

        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]) {
                    sameValues++;
                }
            }
        }

        return sameValues;
    }

    /**
    * Removes an item from an array at the specified index. Returns another array, with one less item.
    * 
    * @param index the index the item should be removed from.
    * @param array the original array.
    * @return array with one less item.
    */
    public static int [] removeIndex(int index, int [] array) {
        int[] newArray = new int[array.length - 1];
        int currentIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (i != index) {
                newArray[currentIndex] = array[i];
                currentIndex++;
            }
        }

        return newArray;
    }

    /**
    * Prints the length and the contents of an integer array. Mainly for testing purposes.
    * 
    * @param array the array to be printed.
    */
    public static void printArray(int [] array) {
        System.out.print(array.length + " items: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}