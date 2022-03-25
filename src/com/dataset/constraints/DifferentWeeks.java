package com.dataset.constraints;

import com.dataset.Class;
import com.utils.Event;
import com.utils.LogicalOperators;

/**
 * This class represents the Distribution Constraint (C7): DifferentWeeks: Given classes must be taught on different
 * weeks, regardless of their time slots or days of the week. This means that (Ci.weeks and Cj.weeks) = 0 for any two
 * classes Ci and Cj from the constraint; doing binary "and" between the bit strings representing the assigned weeks.
 * <p>
 * Created by Sina on 15-Mar-22
 *
 * @author Sina
 * @version 0.2
 */
class DifferentWeeks extends PairDistributionConstraint {

    /**
     * Constructs a DifferentWeeks constraint object over the given classes.
     *
     * @param classes The list of classes that this constraint is applied to.
     */
    DifferentWeeks(Class[] classes) {
        super(classes);
    }

    @Override
    boolean check(Event e1, Event e2) throws NullPointerException {
        // (Ci.weeks and Cj.weeks) = 0
        return LogicalOperators.andIsFalse(e1.getTimeAssignment().getTime().getWeeks()
                , e2.getTimeAssignment().getTime().getWeeks());
    }
}