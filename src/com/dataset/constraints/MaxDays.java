package com.dataset.constraints;

import com.dataset.Class;
import com.utils.Timetable;

/**
 * This class represents the Distribution Constraint (C16): MaxDays(D): Given classes cannot spread over more than D
 * days of the week, regardless whether they are in the same week of semester or not. This means that the total number
 * of days of the week that have at least one class of this distribution constraint C1, …, Cn is not greater than D,
 * countNonzeroBits(C1.days or C2.days or ⋅ ⋅ ⋅ Cn.days) ≤ D
 * where countNonzeroBits(x) returns the number of non-zero bits in the bit string x. When the constraint is soft, the
 * penalty is multiplied by the number of days that exceed the given constant D.
 * <p>
 * Created by Sina on 29-Mar-22
 *
 * @author Sina
 * @version 0.3
 */
class MaxDays extends DistributionConstraint {
    private final int maxDays;

    /**
     * Constructs a MaxDays constraint object over the given classes and maxDays.
     *
     * @param classes The list of classes that this constraint is applied to.
     * @param maxDays The maximum number of days the given classes are allowed to spread over.
     */
    MaxDays(Class[] classes, int maxDays) {
        super(classes);
        this.maxDays = maxDays;
    }

    @Override
    boolean isSatisfied(Timetable timetable) {
        int trueCounter = 0;
        for (int i = 0; i < timetable.getDaysLength(); i++) {
            if (trueCounter > maxDays) return false;
            for (Class aClass : getClasses())
                if (timetable.getEvent(aClass.getId()).getTimeAssignment().getTime().getDays()[i]) {
                    trueCounter++;
                    break;
                }
        }
        return true;
    }

    @Override
    int violationCount(Timetable timetable) {
        int trueCounter = 0;
        for (int i = 0; i < timetable.getDaysLength(); i++) {
            for (Class aClass : getClasses())
                if (timetable.getEvent(aClass.getId()).getTimeAssignment().getTime().getDays()[i]) {
                    trueCounter++;
                    break;
                }
        }
        return (trueCounter <= maxDays) ? 0 : (trueCounter - maxDays);
    }
}