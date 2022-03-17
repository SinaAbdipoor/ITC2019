package com.dataset.constraints;

import com.dataset.Class;
import com.utils.Event;
import com.utils.LogicalOperators;

/**
 * This class represents the Distribution Constraint (C13): Precedence: Given classes must be one after the other in
 * the order provided in the constraint definition. For classes that have multiple meetings in a week or that are on
 * different weeks, the constraint only cares about the first meeting of the class. That is,
 * the first class starts on an earlier week or
 * they start on the same week and the first class starts on an earlier day of the week or
 * they start on the same week and day of the week and the first class is earlier in the day.
 * This means that
 * (first(Ci.weeks) < first(Cj.weeks)) ∨
 * [ (first(Ci.weeks) = first(Cj.weeks)) ∧
 * [ (first(Ci .days) < first(Cj .days)) ∨
 * ((first(Ci.days) = first(Cj.days)) ∧ (Ci.end ≤ Cj.start))
 * ]
 * ]
 * for any two classes Ci and Cj from the constraint where i < j and first(x) is the index of the first non-zero bit in
 * the binary string x.
 * <p>
 * Created by Sina on 17-Mar-22
 *
 * @author Sina
 * @version 0.2
 */
class Precedence extends DistributionConstraint {

    /**
     * Constructs a Precedence constraint object over the given classes.
     *
     * @param classes The list of classes that this constraint is applied to.
     */
    Precedence(Class[] classes) {
        super(classes);
    }

    @Override
    boolean check(Event e1, Event e2) throws NullPointerException {
        // (first(Ci.weeks) < first(Cj.weeks)) ∨ [ (first(Ci.weeks) = first(Cj.weeks)) ∧
        // [ (first(Ci .days) < first(Cj .days)) ∨ ((first(Ci.days) = first(Cj.days)) ∧ (Ci.end ≤ Cj.start)) ] ]
        return LogicalOperators.firstTrueIndex(e1.getTimeAssignment().getTime().getWeeks())
                < LogicalOperators.firstTrueIndex(e2.getTimeAssignment().getTime().getWeeks())
                || (LogicalOperators.firstTrueIndex(e1.getTimeAssignment().getTime().getWeeks())
                == LogicalOperators.firstTrueIndex(e2.getTimeAssignment().getTime().getWeeks())
                && (LogicalOperators.firstTrueIndex(e1.getTimeAssignment().getTime().getDays())
                < LogicalOperators.firstTrueIndex(e2.getTimeAssignment().getTime().getDays())
                || LogicalOperators.firstTrueIndex(e1.getTimeAssignment().getTime().getDays())
                == LogicalOperators.firstTrueIndex(e2.getTimeAssignment().getTime().getDays())
                && e1.getTimeAssignment().getTime().getEnd() <= e2.getTimeAssignment().getTime().getStart()));
    }
}