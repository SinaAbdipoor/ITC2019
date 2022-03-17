package com.dataset.constraints;

import com.dataset.Class;
import com.utils.Event;
import com.utils.LogicalOperators;

/**
 * This class represents the Distribution Constraint (C11): NotOverlap: Given classes do not overlap in time. Two
 * classes do not overlap in time when they do not overlap in time of day, or in days of the week, or in weeks. This
 * means that (Ci.end ≤ Cj.start) ∨ (Cj.end ≤ Ci.start) ∨ ((Ci.days and Cj.days) = 0) ∨ ((Ci.weeks and Cj.weeks) = 0)
 * for any two classes Ci and Cj from the constraint, doing binary "and" between days and weeks of Ci and Cj.
 * <p>
 * Created by Sina on 15-Mar-22
 *
 * @author Sina
 * @version 0.2
 */
class NotOverlap extends DistributionConstraint {

    /**
     * Constructs a NotOverlap constraint object over the given classes.
     *
     * @param classes The list of classes that this constraint is applied to.
     */
    NotOverlap(Class[] classes) {
        super(classes);
    }

    @Override
    boolean check(Event e1, Event e2) throws NullPointerException {
        // (Ci.end ≤ Cj.start) ∨ (Cj.end ≤ Ci.start) ∨ ((Ci.days and Cj.days) = 0) ∨ ((Ci.weeks and Cj.weeks) = 0)
        return e1.getTimeAssignment().getTime().getEnd() <= e2.getTimeAssignment().getTime().getStart()
                || e2.getTimeAssignment().getTime().getEnd() <= e1.getTimeAssignment().getTime().getStart()
                || LogicalOperators.andIsFalse(e1.getTimeAssignment().getTime().getDays()
                , e2.getTimeAssignment().getTime().getDays())
                || LogicalOperators.andIsFalse(e1.getTimeAssignment().getTime().getWeeks()
                , e2.getTimeAssignment().getTime().getWeeks());
    }
}