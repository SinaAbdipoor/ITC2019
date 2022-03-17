package com.utils;

/**
 * This class implements some basic logical operators.
 * <p>
 * Created by Sina on 17-Mar-22
 *
 * @author Sina
 * @version 0.2
 */
public class LogicalOperators {

    /**
     * Checks if boolean[] a and boolean[] b are in a mutual subset relationship. a and b are subsets if and only if
     * ((a or b) == a) or ((a or b) == b).
     *
     * @param a The first boolean array, boolean[] a.
     * @param b b The second boolean array, boolean[] b.
     * @return (a or b) == a or (a or b) == b
     * @throws IllegalArgumentException If a.length != b.length.
     */
    public static boolean areSubsets(boolean[] a, boolean[] b) throws IllegalArgumentException {
        //TODO OPTIMIZATION: For faster running time, comment the following if. However, doing so will result in
        // incorrect operation of this method. Make sure that the given boolean arrays ALWAYS have same lengths before
        // removing this check.
        if (a.length != b.length)
            throw new IllegalArgumentException("The two provided boolean arrays are of different lengths.");
        // COMMENT UNTIL HERE

        // Check if (a or b) == a or (a or b) == b
        boolean[] superSet = null;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i]) continue;
            if (superSet == null) {
                if (a[i]) superSet = a;
                else superSet = b;
            } else if (!superSet[i]) return false;
        }
        return true;
    }

    /**
     * Checks if the resulting boolean array after performing logical and operation on the two given boolean arrays
     * DOES NOT include a true value.
     *
     * @param a The first boolean array, boolean[] a.
     * @param b The second boolean array, boolean[] b.
     * @return False if a&b.contains(true), and true otherwise.
     * @throws IllegalArgumentException If a.length != b.length.
     */
    public static boolean andIsFalse(boolean[] a, boolean[] b) throws IllegalArgumentException {
        //TODO OPTIMIZATION: For faster running time, comment the following if. However, doing so will result in
        // incorrect operation of this method. Make sure that the given boolean arrays ALWAYS have same lengths before
        // removing this check.
        if (a.length != b.length)
            throw new IllegalArgumentException("The two provided boolean arrays are of different lengths.");
        // COMMENT UNTIL HERE

        for (int i = 0; i < a.length; i++)
            if (a[i] && b[i]) return false;
        return true;
    }
}