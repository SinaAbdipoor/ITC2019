package com.utils;

/**
 * This class implements some basic logical operators.
 * <p>
 * Created by Sina on 17-Mar-22
 *
 * @author Sina
 * @version 0.1
 */
class LogicalOperators {

    /**
     * Performs logical and operation on the two given boolean arrays.
     *
     * @param a The first boolean array, boolean[] a.
     * @param b The second boolean array, boolean[] b.
     * @return The resulting boolean array, a and b.
     * @throws IllegalArgumentException If a.length != b.length.
     */
    static boolean[] logicalAnd(boolean[] a, boolean[] b) throws IllegalArgumentException {
        //TODO OPTIMIZATION: For faster running time, comment the following if. However, doing so will result in
        // incorrect operation of this method. Make sure that the two given boolean arrays ALWAYS have same lengths
        // before removing this check.
        if (a.length != b.length)
            throw new IllegalArgumentException("The two provided boolean arrays are of different lengths.");
        // COMMENT UNTIL HERE

        boolean[] and = new boolean[a.length];
        for (int i = 0; i < and.length; i++)
            and[i] = a[i] && b[i];
        return and;
    }

    /**
     * Performs logical or operation on the two given boolean arrays.
     *
     * @param a The first boolean array, boolean[] a.
     * @param b The second boolean array, boolean[] b.
     * @return The resulting boolean array, a or b.
     * @throws IllegalArgumentException If a.length != b.length.
     */
    static boolean[] logicalOr(boolean[] a, boolean[] b) throws IllegalArgumentException {
        //TODO OPTIMIZATION: For faster running time, comment the following if. However, doing so will result in
        // incorrect operation of this method. Make sure that the two given boolean arrays ALWAYS have same lengths
        // before removing this check.
        if (a.length != b.length)
            throw new IllegalArgumentException("The two provided boolean arrays are of different lengths.");
        // COMMENT UNTIL HERE

        boolean[] or = new boolean[a.length];
        for (int i = 0; i < or.length; i++)
            or[i] = a[i] || b[i];
        return or;
    }

    /**
     * Checks if the resulting boolean array after performing logical and operation on the two given boolean arrays
     * DOES NOT include a true value.
     *
     * @param a The first boolean array, boolean[] a.
     * @param b The second boolean array, boolean[] b.
     * @return False if a&b.containt(true), and true otherwise.
     * @throws IllegalArgumentException
     */
    static boolean andIsFalse(boolean[] a, boolean[] b) throws IllegalArgumentException {
        //TODO OPTIMIZATION: For faster running time, comment the following if. However, doing so will result in
        // incorrect operation of this method. Make sure that the two given boolean arrays ALWAYS have same lengths
        // before removing this check.
        if (a.length != b.length)
            throw new IllegalArgumentException("The two provided boolean arrays are of different lengths.");
        // COMMENT UNTIL HERE

        for (int i = 0; i < a.length; i++)
            if (a[i] && b[i]) return false;
        return true;
    }
}