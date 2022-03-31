package com.dataset;

import java.util.Arrays;

/**
 * This class represents time as described in the ITC 2019 dataset. A time is represented with a certain number of weeks
 * (nrWeeks), a number of days (nrDays) in each week, and a number of time slots per day (slotsPerDay). One timeslot
 * equals 5 minutes, which allows us to model travel times as well as classes that meet at irregular times.
 * There are 288 time slots covering the whole day, from midnight to midnight.
 * <p>
 * When talking about the time taken (in timeslots), regardless of the day or week, an int containing the number of
 * timeslots is used rather than an object of this class for simplification.
 * <p>
 * Created by Sina on 13-Dec-21
 *
 * @author Sina
 * @version 0.6
 */
public class Time {
    private final boolean[] weeks;
    private final boolean[] days;
    private final int start;
    private final int length;

    /**
     * Constructs a time object.
     *
     * @param weeks  A boolean string that indicates on which week(s) this time takes place. A true (1) value indicates
     *               the inclusion of that week and 0 otherwise.
     * @param days   A boolean string that indicates on which day(s) this time takes place. A true (1) value indicates
     *               the inclusion of that week and 0 otherwise.
     * @param start  An int indicating on which timeslot does this time start.
     * @param length An int indicating for how many timeslots does this time last.
     * @throws IllegalArgumentException When start < 0, start > 288, length < 0, start + length > 288, or if the size
     *                                  of boolean[] days > 7.
     */
    Time(boolean[] weeks, boolean[] days, int start, int length) throws IllegalArgumentException {
        this.weeks = weeks;
        if (days.length > 7) throw new IllegalArgumentException("There cannot be more than 7 days in a week.");
        this.days = days;
        if (start < 0 || start > 288) throw new IllegalArgumentException("The start time should be between 0 and 288.");
        this.start = start;
        if (length < 0) throw new IllegalArgumentException("The length (duration) of time cannot below 0 (timeslots).");
        if (start + length > 288)
            throw new IllegalArgumentException("The start time + length passes the maximum 288 timeslots.");
        this.length = length;
    }

    /**
     * Returns a boolean string indicating the inclusion or exclusion of each week.
     *
     * @return weeks.
     */
    public boolean[] getWeeks() {
        return weeks;
    }

    /**
     * Returns a boolean string indicating the inclusion or exclusion of each day in the week.
     *
     * @return days.
     */
    public boolean[] getDays() {
        return days;
    }

    /**
     * Returns the starting timeslot of this time.
     *
     * @return start time.
     */
    public int getStart() {
        return start;
    }

    /**
     * Returns the duration of this time (in number of timeslots).
     *
     * @return length.
     */
    public int getLength() {
        return length;
    }

    /**
     * Returns the end of this time, which is: start + length.
     *
     * @return time end.
     */
    public int getEnd() {
        return (start + length);
    }

    @Override
    public String toString() {
        return "Time{" + "weeks=" + Arrays.toString(weeks) + ", days=" + Arrays.toString(days) + ", start=" + start
                + ", length=" + length + '}';
    }
}