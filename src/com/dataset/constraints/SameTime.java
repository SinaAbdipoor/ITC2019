package com.dataset.constraints;

import com.dataset.Class;
import com.utils.Event;

/**
 * This class represents the Distribution Constraint (C2): SameTime: Given classes must be taught at the same time of
 * day, regardless of their days of week or weeks. For the classes of the same length, this is the same constraint as
 * SameStart (classes must start at the same time slot). For the classes of different lengths, the shorter class can
 * start after the longer class but must end before or at the same time as the longer class. This means that
 * (Ci.start ≤ Cj.start ∧ Cj.end ≤ Ci.end) ∨ (Cj.start ≤ Ci.start ∧ Ci.end ≤ Cj.end) for any two classes Ci and Cj from
 * the constraint; Ci.end = Ci.start + Ci.length is the assigned end time slot of a class Ci.
 * <p>
 * Created by Sina on 11-Mar-22
 *
 * @author Sina
 * @version 0.1
 */
class SameTime extends DistributionConstraint {

    /**
     * Constructs a SameTime constraint object over the given classes.
     *
     * @param classes The list of classes that this constraint is applied to.
     */
    SameTime(Class[] classes) {
        super(classes);
    }

    @Override
    boolean check(Event e1, Event e2) throws NullPointerException {
        // (Ci.start ≤ Cj.start ∧ Cj.end ≤ Ci.end) ∨ (Cj.start ≤ Ci.start ∧ Ci.end ≤ Cj.end)
        return (e1.getTimeAssignment().getTime().getStart() <= e2.getTimeAssignment().getTime().getStart()
                && e2.getTimeAssignment().getTime().getEnd() <= e1.getTimeAssignment().getTime().getEnd())
                || (e2.getTimeAssignment().getTime().getStart() <= e1.getTimeAssignment().getTime().getStart()
                && e1.getTimeAssignment().getTime().getEnd() <= e2.getTimeAssignment().getTime().getEnd());
    }
}