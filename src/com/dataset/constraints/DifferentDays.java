package com.dataset.constraints;

import com.dataset.Class;
import com.utils.Event;

/**
 * This class represents the Distribution Constraint (C5): DifferentDays: Given classes must be taught on different
 * days of the week, regardless of their start time slots and weeks. This means that (Ci.days and Cj.days) = 0 for any
 * two classes Ci and Cj from the constraint; doing binary "and" between the bit strings representing the assigned days.
 * <p>
 * Created by Sina on 14-Mar-22
 *
 * @author Sina
 * @version 0.1
 */
class DifferentDays extends DistributionConstraint {
    DifferentDays(Class[] classes) {
        super(classes);
    }

    /**
     * This is the logic and the primary checking of this constraint. It checks to see whether the requirement of this
     * distribution constraint is satisfied over the given pair of scheduled classes (events).
     * <p>
     * To see the exact procedure of this check method, refer to the JavaDoc of its corresponding class.
     * <p>
     * IMPORTANT: If this constraint is not defined over a pair of classes, this method, isSatisfied method,
     * violationCount method , and getViolations method should all be overwritten.
     *
     * @param e1 The first scheduled class (event) (Ci).
     * @param e2 The second scheduled class (event) (Cj).
     * @return True if the given event pair satisfy this constraint, and false otherwise.
     * @throws NullPointerException     If a given event is not scheduled.
     * @throws IllegalArgumentException If the lengths of days[] for the time assignment of event 1 and 2 are not equal.
     */
    @Override
    boolean check(Event e1, Event e2) throws NullPointerException, IllegalArgumentException {
        //TODO OPTIMIZATION: For faster running time, comment the following if. However, doing so will result in
        // incorrect operation of this method. Make sure that the given e1 and e2 have boolean[] days of same lengths
        // before removing this check.
        if (e1.getTimeAssignment().getTime().getDays().length != e2.getTimeAssignment().getTime().getDays().length)
            throw new IllegalArgumentException("The two given events have boolean[] days of different lengths.");
        // COMMENT UNTIL HERE

        // (Ci.days and Cj.days) = 0
        for (int i = 0; i < e1.getTimeAssignment().getTime().getDays().length; i++)
            if (e1.getTimeAssignment().getTime().getDays()[i] && e2.getTimeAssignment().getTime().getDays()[i])
                return false;
        return true;
    }
}