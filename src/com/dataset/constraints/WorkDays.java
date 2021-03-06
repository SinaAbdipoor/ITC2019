package com.dataset.constraints;

import com.dataset.Class;
import com.utils.Event;
import com.utils.LogicalOperators;

/**
 * This class represents the Distribution Constraint (C14): WorkDays(S): There should not be more than S time slots
 * between the start of the first class and the end of the last class on any given day. This means that classes that are
 * placed on the overlapping days and weeks that have more than S time slots between the start of the earlier class and
 * the end of the later class are violating the constraint. That is
 * ((Ci.days and Cj.days) = 0) ∨ ((Ci.weeks and Cj.weeks) = 0) ∨ (max(Ci.end,Cj.end)−min(Ci.start,Cj.start) ≤ S)
 * for any two classes Ci and Cj from the constraint.
 * <p>
 * Created by Sina on 17-Mar-22
 *
 * @author Sina
 * @version 0.2
 */
class WorkDays extends PairDistributionConstraint {
    private final int maxGap;                                                                                           // S

    /**
     * Constructs a WorkDays constraint object over the given classes and maxGap.
     *
     * @param classes The list of classes that this constraint is applied to.
     * @param maxGap  The maximum number of timeslots allowed between the start of the first class and the end of the
     *                last class on any given day.
     */
    WorkDays(Class[] classes, int maxGap) {
        super(classes);
        this.maxGap = maxGap;
    }

    @Override
    boolean check(Event e1, Event e2) throws NullPointerException {
        // ((Ci.days and Cj.days) = 0) ∨ ((Ci.weeks and Cj.weeks) = 0) ∨ (max(Ci.end,Cj.end)−min(Ci.start,Cj.start) ≤ S)
        return LogicalOperators.andIsFalse(e1.getTimeAssignment().getTime().getDays()
                , e2.getTimeAssignment().getTime().getDays())
                || LogicalOperators.andIsFalse(e1.getTimeAssignment().getTime().getWeeks()
                , e2.getTimeAssignment().getTime().getWeeks())
                || (Math.max(e1.getTimeAssignment().getTime().getEnd(), e2.getTimeAssignment().getTime().getEnd())
                - Math.min(e1.getTimeAssignment().getTime().getStart(), e2.getTimeAssignment().getTime().getStart())
                <= maxGap);
    }
}