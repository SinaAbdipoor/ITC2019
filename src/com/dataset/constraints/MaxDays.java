package com.dataset.constraints;

import com.dataset.Class;
import com.utils.Event;
import com.utils.LogicalOperators;

/**
 * This class represents the Distribution Constraint (C16): MaxDays(D): Given classes cannot spread over more than D
 * days of the week, regardless whether they are in the same week of semester or not. This means that the total number
 * of days of the week that have at least one class of this distribution constraint C1, …, Cn is not greater than D,
 * countNonzeroBits(C1.days or C2.days or ⋅ ⋅ ⋅ Cn.days) ≤ D
 * where countNonzeroBits(x) returns the number of non-zero bits in the bit string x. When the constraint is soft, the
 * penalty is multiplied by the number of days that exceed the given constant D.
 * <p>
 * Created by Sina on 28-Mar-22
 *
 * @author Sina
 * @version 0.1
 */
class MaxDays extends SingleDistributionConstraint {
    private final int maxDays;

    /**
     * Constructs a MaxDays object over the given classes and MaxDays.
     *
     * @param classes The list of classes that this constraint is applied to.
     * @param maxDays The maximum number of days of the week the given classes are allowed to be spread over.
     */
    MaxDays(Class[] classes, int maxDays) {
        super(classes);
        this.maxDays = maxDays;
    }

    @Override
    int check(Event event) throws NullPointerException {
        int daysCount = LogicalOperators.countTrueValues(event.getTimeAssignment().getTime().getDays());
        if (daysCount <= maxDays) return 0;
        return (daysCount - maxDays);
    }
}