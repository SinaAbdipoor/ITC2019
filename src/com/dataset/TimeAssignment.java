package com.dataset;

/**
 * This class represents a possible assignment of a certain time to a certain event with its given penalty as predefined
 * in the ITC 2019 dataset.
 * <p>
 * Created by Sina on 15-Dec-21
 *
 * @author Sina
 * @version 0.5
 */
public class TimeAssignment {
    private final Time time;
    private final int penalty;

    /**
     * Constructs a time assignment object.
     *
     * @param time    The time to be assigned to the event.
     * @param penalty The penalty of assigning this time to the event as defined in the ITC 2019 dataset.
     * @throws IllegalArgumentException If the penalty is below 0.
     */
    TimeAssignment(Time time, int penalty) throws IllegalArgumentException {
        this.time = time;
        if (penalty < 0) throw new IllegalArgumentException("Time assignment penalty cannot be negative.");
        this.penalty = penalty;
    }

    /**
     * Returns the time to assigned.
     *
     * @return Time assignment.
     */
    public Time getTime() {
        return time;
    }

    /**
     * Returns the penalty of assigning this time to the event.
     *
     * @return Time assignment penalty.
     */
    public int getPenalty() {
        return penalty;
    }

    @Override
    public String toString() {
        return "TimeAssignment{" + "time=" + time + ", penalty=" + penalty + '}';
    }
}