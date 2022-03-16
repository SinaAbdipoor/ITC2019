package com.dataset.constraints;

import com.dataset.Class;
import com.utils.Event;

import java.util.Arrays;

/**
 * This class represents the Distribution Constraint (C4): SameDays: Given classes must be taught on the same days,
 * regardless of their start time slots and weeks. In case of classes of different days of the week, a class with fewer
 * meetings must meet on a subset of the days used by the class with more meetings. For example, if the class with the
 * most meetings meets on Monday–Tuesday–Wednesday, all others classes in the constraint can only be taught on Monday,
 * Wednesday, and/or Friday. This means that ((Ci.days or Cj.days) = Ci.days) ∨ ((Ci.days or Cj.days) = Cj.days) for
 * any two classes Ci and Cj from the constraint; Ci.days are the assigned days of the week of a class Ci, doing binary
 * "or" between the bit strings.
 * <p>
 * Created by Sina on 11-Mar-22
 *
 * @author Sina
 * @version 0.1
 */
class SameDays extends DistributionConstraint {
    /**
     * Constructs a SameDays constraint object over the given classes.
     *
     * @param classes The list of classes that this constraint is applied to.
     */
    SameDays(Class[] classes) {
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

        // ((Ci.days or Cj.days) = Ci.days) ∨ ((Ci.days or Cj.days) = Cj.days)
        boolean[] orDays = new boolean[e1.getTimeAssignment().getTime().getDays().length];
        for (int i = 0; i < orDays.length; i++)
            orDays[i] = e1.getTimeAssignment().getTime().getDays()[i] || e2.getTimeAssignment().getTime().getDays()[i];
        return Arrays.equals(orDays, e1.getTimeAssignment().getTime().getDays())
                || Arrays.equals(orDays, e2.getTimeAssignment().getTime().getDays());
    }
}