package com.dataset.constraints;

import com.dataset.Class;
import com.utils.Event;
import com.utils.LogicalOperators;

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
 * @version 0.3
 */
class SameDays extends PairDistributionConstraint {

    /**
     * Constructs a SameDays constraint object over the given classes.
     *
     * @param classes The list of classes that this constraint is applied to.
     */
    SameDays(Class[] classes) {
        super(classes);
    }

    @Override
    boolean check(Event e1, Event e2) throws NullPointerException {
        // ((Ci.days or Cj.days) = Ci.days) ∨ ((Ci.days or Cj.days) = Cj.days)
        return LogicalOperators.areSubsets(e1.getTimeAssignment().getTime().getDays()
                , e2.getTimeAssignment().getTime().getDays());
    }
}