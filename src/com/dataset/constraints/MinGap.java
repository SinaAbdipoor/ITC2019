package com.dataset.constraints;

import com.dataset.Class;
import com.utils.Event;
import com.utils.LogicalOperators;

/**
 * This class represents the Distribution Constraint (C15): MinGap(G): Any two classes that are taught on the same day
 * (they are placed on overlapping days and weeks) must be at least G slots apart. This means that there must be at
 * least G slots between the end of the earlier class and the start of the later class. That is
 * ((Ci.days and Cj.days) = 0) ∨ ((Ci.weeks and Cj.weeks) = 0) ∨ (Ci.end + G ≤ Cj.start) ∨ (Cj.end + G ≤ Ci.start)
 * for any two classes Ci and Cj from the constraint.
 * <p>
 * Created by Sina on 17-Mar-22
 *
 * @author Sina
 * @version 0.1
 */
class MinGap extends DistributionConstraint {
    private final int minGap;

    /**
     * Constructs a MinGap constraint object over the given classes.
     *
     * @param classes The list of classes that this constraint is applied to.
     * @param minGap  The minimum number of timeslots needed between any two classes that are taught on the same day.
     */
    MinGap(Class[] classes, int minGap) {
        super(classes);
        this.minGap = minGap;
    }

    @Override
    boolean check(Event e1, Event e2) throws NullPointerException {
        // ((Ci.days and Cj.days) = 0) ∨ ((Ci.weeks and Cj.weeks) = 0) ∨ (Ci.end + G ≤ Cj.start)
        // ∨ (Cj.end + G ≤ Ci.start)
        return LogicalOperators.andIsFalse(e1.getTimeAssignment().getTime().getDays(),
                e2.getTimeAssignment().getTime().getDays())
                || LogicalOperators.andIsFalse(e1.getTimeAssignment().getTime().getWeeks()
                , e2.getTimeAssignment().getTime().getWeeks())
                || (e1.getTimeAssignment().getTime().getEnd() + minGap <= e2.getTimeAssignment().getTime().getStart());
    }
}