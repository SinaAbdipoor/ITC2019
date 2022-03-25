package com.dataset.constraints;

import com.dataset.Class;
import com.utils.Event;
import com.utils.LogicalOperators;

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
 * @version 0.2
 */
class SameWeeks extends PairDistributionConstraint {

    /**
     * Constructs a SameWeeks constraint object over the given classes.
     *
     * @param classes The list of classes that this constraint is applied to.
     */
    SameWeeks(Class[] classes) {
        super(classes);
    }

    @Override
    boolean check(Event e1, Event e2) throws NullPointerException {
        // (Ci.weeks or Cj.weeks) = Ci.weeks) ∨ (Ci.weeks or Cj.weeks) = Cj.weeks)
        return LogicalOperators.areSubsets(e1.getTimeAssignment().getTime().getWeeks()
                , e2.getTimeAssignment().getTime().getWeeks());
    }
}