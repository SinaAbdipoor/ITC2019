package com.dataset.constraints;

import com.dataset.Class;
import com.utils.Event;

/**
 * This class represent the Distribution Constraint (C3): DifferentTime: Given classes must be taught during different
 * times of day, regardless of their days of week or weeks. This means that no two classes of this constraint can
 * overlap at a time of the day. This means that (Ci.end ≤ Cj.start) ∨ (Cj.end ≤ Ci.start) for any two classes Ci and
 * Cj from the constraint.
 * <p>
 * Created by Sina on 11-Mar-22
 *
 * @author Sina
 * @version 0.1
 */
class DifferentTime extends PairDistributionConstraint {

    /**
     * Constructs a DifferentTime constraint object over the given classes.
     *
     * @param classes The list of classes that this constraint is applied to.
     */
    DifferentTime(Class[] classes) {
        super(classes);
    }

    @Override
    boolean check(Event e1, Event e2) throws NullPointerException {
        // (Ci.end ≤ Cj.start) ∨ (Cj.end ≤ Ci.start)
        return e1.getTimeAssignment().getTime().getEnd() <= e2.getTimeAssignment().getTime().getStart()
                || e2.getTimeAssignment().getTime().getEnd() <= e1.getTimeAssignment().getTime().getStart();
    }
}