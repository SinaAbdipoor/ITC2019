package com.dataset.constraints;

import com.dataset.Class;
import com.dataset.TravelTime;
import com.utils.Event;
import com.utils.LogicalOperators;

/**
 * This class represents the Distribution Constraint (C12): SameAttendees: Given classes cannot overlap in time, and
 * if they are placed on overlapping days of week and weeks, they must be placed close enough so that the attendees
 * can travel between the two classes. This means that
 * (Ci.end + Ci.room.travel[Cj.room] ≤ Cj.start) ∨
 * (Cj.end + Cj.room.travel[Ci.room] ≤ Ci.start) ∨
 * ((Ci.days and Cj.days) = 0) ∨ ((Ci.weeks and Cj.weeks) = 0)
 * for any two classes Ci and Cj from the constraint; Ci.room.travel[Cj.room] is the travel time between the assigned
 * rooms of Ci and Cj.
 * <p>
 * Created by Sina on 17-Mar-22
 *
 * @author Sina
 * @version 0.1
 */
class SameAttendees extends DistributionConstraint {
    /**
     * Constructs a distribution constraint over the given classes.
     *
     * @param classes The list of classes that this constraint is applied to.
     */
    SameAttendees(Class[] classes) {
        super(classes);
    }

    @Override
    boolean check(Event e1, Event e2) throws NullPointerException {
        // (Ci.end + Ci.room.travel[Cj.room] ≤ Cj.start) ∨ (Cj.end + Cj.room.travel[Ci.room] ≤ Ci.start)
        // ∨ ((Ci.days and Cj.days) = 0) ∨ ((Ci.weeks and Cj.weeks) = 0)
        int travelTime = TravelTime.getInstance().getTravelTime(e1.getRoomAssignment().getRoom().getId()
                , e2.getRoomAssignment().getRoom().getId());
        return e1.getTimeAssignment().getTime().getEnd() + travelTime <= e2.getTimeAssignment().getTime().getStart()
                || e2.getTimeAssignment().getTime().getEnd() + travelTime <= e1.getTimeAssignment().getTime().getStart()
                || LogicalOperators.andIsFalse(e1.getTimeAssignment().getTime().getDays()
                , e2.getTimeAssignment().getTime().getDays())
                || LogicalOperators.andIsFalse(e1.getTimeAssignment().getTime().getWeeks()
                , e2.getTimeAssignment().getTime().getWeeks());
    }
}