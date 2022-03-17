package com.dataset.constraints;

import com.dataset.Class;
import com.utils.Event;
import com.utils.LogicalOperators;

/**
 * This class represents the Distribution Constraint (C10): Overlap: Given classes overlap in time. Two classes overlap
 * in time when they overlap in time of day, days of the week, as well as weeks. This means that
 * (Cj.start < Ci.end) ∧ (Ci.start < Cj.end) ∧ ((Ci.days and Cj.days) ≠ 0) ∧ ((Ci.weeks and Cj.weeks) ≠ 0) for any two
 * classes Ci and Cj from the constraint, doing binary "and" between days and weeks of Ci and Cj.
 * <p>
 * Created by Sina on 15-Mar-22
 *
 * @author Sina
 * @version 0.2
 */
class Overlap extends DistributionConstraint {
    /**
     * Constructs a distribution constraint over the given classes.
     *
     * @param classes The list of classes that this constraint is applied to.
     */
    Overlap(Class[] classes) {
        super(classes);
    }

    @Override
    boolean check(Event e1, Event e2) throws NullPointerException {
        // (Cj.start < Ci.end) ∧ (Ci.start < Cj.end) ∧ ((Ci.days and Cj.days) ≠ 0) ∧ ((Ci.weeks and Cj.weeks) ≠ 0)
        return e2.getTimeAssignment().getTime().getStart() < e1.getTimeAssignment().getTime().getEnd()
                && e1.getTimeAssignment().getTime().getStart() < e2.getTimeAssignment().getTime().getEnd()
                && !LogicalOperators.andIsFalse(e1.getTimeAssignment().getTime().getDays()
                , e2.getTimeAssignment().getTime().getDays())
                && !LogicalOperators.andIsFalse(e1.getTimeAssignment().getTime().getWeeks()
                , e2.getTimeAssignment().getTime().getWeeks());
    }
}