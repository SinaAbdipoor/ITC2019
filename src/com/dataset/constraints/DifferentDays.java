package com.dataset.constraints;

import com.dataset.Class;
import com.utils.Event;
import com.utils.LogicalOperators;

/**
 * This class represents the Distribution Constraint (C5): DifferentDays: Given classes must be taught on different
 * days of the week, regardless of their start time slots and weeks. This means that (Ci.days and Cj.days) = 0 for any
 * two classes Ci and Cj from the constraint; doing binary "and" between the bit strings representing the assigned days.
 * <p>
 * Created by Sina on 14-Mar-22
 *
 * @author Sina
 * @version 0.2
 */
class DifferentDays extends DistributionConstraint {
    DifferentDays(Class[] classes) {
        super(classes);
    }

    @Override
    boolean check(Event e1, Event e2) throws NullPointerException {
        // (Ci.days and Cj.days) = 0
        return LogicalOperators.andIsFalse(e1.getTimeAssignment().getTime().getDays()
                , e2.getTimeAssignment().getTime().getDays());
    }
}