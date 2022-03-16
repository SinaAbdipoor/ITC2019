package com.dataset.constraints;

import com.dataset.Class;
import com.utils.Event;

/**
 * This class represent the Distribution Constraint (C1): SameStart: Given classes must start at the same time slot,
 * regardless of their days of week or weeks. This means that Ci.start = Cj.start for any two classes Ci and Cj from
 * the constraint; Ci.start is the assigned start time slot of a class Ci.
 * <p>
 * Created by Sina on 11-Mar-22
 *
 * @author Sina
 * @version 0.2
 */
class SameStart extends DistributionConstraint {
    /**
     * Constructs a SameStart constraint object over the given classes.
     *
     * @param classes The list of classes that this constraint is applied to.
     */
    SameStart(Class[] classes) {
        super(classes);
    }

    @Override
    boolean check(Event e1, Event e2) throws NullPointerException {
        // Ci.start = Cj.start
        return e1.getTimeAssignment().getTime().getStart() == e2.getTimeAssignment().getTime().getStart();
    }
}