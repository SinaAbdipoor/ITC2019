package com.dataset.constraints;

import com.dataset.Class;
import com.utils.Timetable;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This abstract class represents a distribution constraint as defined in the ITC 2019 dataset. A distribution
 * constraint can be placed between any two or more classes. Any of these constraints can be either hard or soft. Hard
 * constraints cannot be violated and are marked as required. Soft constraints may not be satisfied and there is a
 * penalty for each violation.
 * <p>
 * Created by Sina on 10-Mar-22
 *
 * @author Sina
 * @version 0.5
 */
abstract class DistributionConstraint {
    private final Class[] classes;

    /**
     * Constructs a distribution constraint over the given classes.
     *
     * @param classes The list of classes that this constraint is applied to.
     */
    DistributionConstraint(Class[] classes) {
        this.classes = classes;
    }

    /**
     * Returns the list of classes that this distribution constraint is applied to.
     *
     * @return The list of classes of this constraint.
     */
    Class[] getClasses() {
        return classes;
    }

    @Override
    public String toString() {
        return "DistributionConstraint{type=" + this.getClass().getSimpleName() + ", classes="
                + Arrays.toString(classes) + '}';
    }

    /**
     * Checks if the given candidate solution (timetable) satisfies this distribution constraint over all the classes
     * defined in this constraint. As soon as there's a violation, it stops and returns false.
     *
     * @param timetable A candidate, or possible, solution.
     * @return True if the input timetable satisfies this constraint for all its classes, and false otherwise.
     * @throws NullPointerException If a given timetable is not fully scheduled.
     */
    abstract boolean isSatisfied(Timetable timetable) throws NullPointerException;

    /**
     * Counts the number of times that the given timetable violates this constraint over its classes.
     *
     * @param timetable A candidate, or possible, solution.
     * @return Violations count of the input timetable.
     * @throws NullPointerException If a given timetable is not fully scheduled.
     */
    abstract int violationCount(Timetable timetable) throws NullPointerException;

    /**
     * Returns the list of all violations of the given timetable for this distribution constraint.
     *
     * @param timetable A candidate, or possible, solution.
     * @return Violations list.
     * @throws NullPointerException If a given timetable is not fully scheduled.
     */
    ArrayList<Violation> getViolations(Timetable timetable) throws NullPointerException {
        ArrayList<Violation> violations = new ArrayList<>();
        if (!isSatisfied(timetable)) violations.add(new Violation(null, null, this));
        return violations;
    }
}