package com.dataset.constraints;

import com.utils.Event;

/**
 * This class represents a violation (a pair of events (scheduled classes) or a single event) that do/does not satisfy
 * a distribution constraint according to its logic and list of applied classes. Keeping track of violations helps in
 * determining which constraints are causing issues for a method.
 * <p>
 * Created by Sina on 10-Mar-22
 *
 * @author Sina
 * @version 0.4
 */
class Violation {
    private final Event event1, event2;
    private final DistributionConstraint distributionConstraint;

    /**
     * Constructs a violation object.
     *
     * @param event1                 The first event (scheduled class) of the event pair of the given candidate
     *                               solution (timetable) that caused this violation. IN CASE OF LIST DISTRIBUTION
     *                               CONSTRAINTS, THIS IS NULL.
     * @param event2                 The second event (scheduled class) of the event pair of the given candidate
     *                               solution (timetable) that caused this violation. IN CASE OF LIST DISTRIBUTION
     *                               CONSTRAINTS, THIS IS NULL.
     * @param distributionConstraint The distribution constraint that the given event pair violated.
     */
    Violation(Event event1, Event event2, DistributionConstraint distributionConstraint) {
        this.event1 = event1;
        this.event2 = event2;
        this.distributionConstraint = distributionConstraint;
    }

    /**
     * Returns The first event (scheduled class) of the event pair of the given candidate solution (timetable) that
     * caused this violation. Returns null in case of list distribution constraints.
     *
     * @return Event 1.
     */
    Event getEvent1() {
        return event1;
    }

    /**
     * Returns The first event (scheduled class) of the event pair of the given candidate solution (timetable) that
     * caused this violation. Returns null in case of list distribution constraints.
     *
     * @return Event 2.
     */
    Event getEvent2() {
        return event2;
    }

    /**
     * Returns the distribution constraint that this event pair has violated.
     *
     * @return Violated distribution constraint.
     */
    DistributionConstraint getDistributionConstraint() {
        return distributionConstraint;
    }

    @Override
    public String toString() {
        return "Violation{" + "event1=" + event1 + ", event2=" + event2 + ", distributionConstraint="
                + distributionConstraint;
    }
}