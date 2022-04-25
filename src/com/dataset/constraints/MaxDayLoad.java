package com.dataset.constraints;

import com.dataset.Class;
import com.utils.Timetable;

/**
 * This class represents the Distribution Constraint (C17): MaxDayLoad(S): Given classes must be spread over the days
 * of the week (and weeks) in a way that there is no more than a given number of S time slots on every day. This means
 * that for each week w ∈ {0, 1, …, nrWeeks − 1} of the semester and each day of the week d ∈ {0, 1, …, nrDays − 1},
 * the total number of slots assigned to classes C that overlap with the selected day d and week w is not more than S,
 * DayLoad(d,w) ≤ S DayLoad(d,w) = ∑i {Ci.length | (Ci.days and 2d) ≠ 0 ∧ (Ci.weeks and 2w) ≠ 0)}
 * where 2d is a bit string with the only non-zero bit on position d and 2w is a bit string with the only non-zero bit
 * on position w. When the constraint is soft (it is not required and there is a penalty), its penalty is multiplied by
 * the number of slots that exceed the given constant S over all days of the semester and divided by the number of
 * weeks of the semester (using integer division). Importantly the integer division is computed at the very end.
 * That is (penalty × ∑w,dmax(DayLoad(d,w) − S, 0)) / nrWeeks
 * <p>
 * Created by Sina on 29-Mar-22
 *
 * @author Sina
 * @version 0.2
 */
class MaxDayLoad extends DistributionConstraint {

    //TODO: Fix the soft constraint penalty calculation for this constraint.

    private final int maxTimeslots;

    /**
     * Constructs a maxDayLoad constraint object over the given classes.
     *
     * @param classes      The list of classes that this constraint is applied to.
     * @param maxTimeslots The maximum number of timeslots allowed for the given classes over the entire term.
     */
    MaxDayLoad(Class[] classes, int maxTimeslots) {
        super(classes);
        this.maxTimeslots = maxTimeslots;
    }

    @Override
    boolean isSatisfied(Timetable timetable) throws NullPointerException {
        int dayLoad;
        for (int w = 0; w < timetable.getWeeksLength(); w++)
            for (int d = 0; d < timetable.getDaysLength(); d++) {
                dayLoad = 0;
                for (Class aClass : getClasses()) {
                    if (dayLoad > maxTimeslots) return false;
                    if (timetable.getEvent(aClass.getId()).getTimeAssignment().getTime().getWeeks()[w]
                            && timetable.getEvent(aClass.getId()).getTimeAssignment().getTime().getDays()[d])
                        dayLoad += timetable.getEvent(aClass.getId()).getTimeAssignment().getTime().getLength();
                }
            }
        return true;
    }

    @Override
    int violationCount(Timetable timetable) throws NullPointerException {
        int total = 0, dayLoad;
        for (int w = 0; w < timetable.getWeeksLength(); w++)
            for (int d = 0; d < timetable.getDaysLength(); d++) {
                dayLoad = 0;
                for (Class aClass : getClasses())
                    if (timetable.getEvent(aClass.getId()).getTimeAssignment().getTime().getWeeks()[w]
                            && timetable.getEvent(aClass.getId()).getTimeAssignment().getTime().getDays()[d])
                        dayLoad += timetable.getEvent(aClass.getId()).getTimeAssignment().getTime().getLength();
                total += Math.max(dayLoad - maxTimeslots, 0);
            }
        return total;
    }
}