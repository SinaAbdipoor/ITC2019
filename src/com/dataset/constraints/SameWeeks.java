package com.dataset.constraints;

import com.dataset.Class;
import com.utils.Event;

import java.util.Arrays;

/**
 * This class represents the Distribution Constraint (C6): SameWeeks: Given classes must be taught in the same weeks,
 * regardless of their time slots or days of the week. In case of classes of different weeks, a class with fewer weeks
 * must meet on a subset of the weeks used by the class with more weeks. This means that
 * (Ci.weeks or Cj.weeks) = Ci.weeks) ∨ (Ci.weeks or Cj.weeks) = Cj.weeks) for any two classes Ci and Cj from the
 * constraint; doing binary "or" between the bit strings representing the assigned weeks.
 * <p>
 * Created by Sina on 15-Mar-22
 *
 * @author Sina
 * @version 0.1
 */
class SameWeeks extends DistributionConstraint {
    /**
     * Constructs a distribution constraint over the given classes.
     *
     * @param classes The list of classes that this constraint is applied to.
     */
    SameWeeks(Class[] classes) {
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
     * @throws IllegalArgumentException If the lengths of weeks[] for the time assignment of event 1 and 2 are not
     *                                  equal.
     */
    @Override
    boolean check(Event e1, Event e2) throws NullPointerException, IllegalArgumentException {
        //TODO OPTIMIZATION: For faster running time, comment the following if. However, doing so will result in
        // incorrect operation of this method. Make sure that the given e1 and e2 have boolean[] weeks of same lengths
        // before removing this check.
        if (e1.getTimeAssignment().getTime().getWeeks().length != e2.getTimeAssignment().getTime().getWeeks().length)
            throw new IllegalArgumentException("The two given events have boolean[] weeks of different lengths.");
        // COMMENT UNTIL HERE

        // (Ci.weeks or Cj.weeks) = Ci.weeks) ∨ (Ci.weeks or Cj.weeks) = Cj.weeks)
        boolean[] orWeeks = new boolean[e1.getTimeAssignment().getTime().getWeeks().length];
        for (int i = 0; i < orWeeks.length; i++)
            orWeeks[i] = e1.getTimeAssignment().getTime().getWeeks()[i]
                    || e2.getTimeAssignment().getTime().getWeeks()[i];
        return Arrays.equals(orWeeks, e1.getTimeAssignment().getTime().getWeeks())
                || Arrays.equals(orWeeks, e2.getTimeAssignment().getTime().getWeeks());
    }
}