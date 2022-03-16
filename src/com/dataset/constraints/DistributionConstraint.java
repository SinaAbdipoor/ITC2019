package com.dataset.constraints;

import com.dataset.Class;
import com.utils.Event;
import com.utils.Timetable;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This abstract class represents a distribution constraint as defined in the ITC 2019 dataset. A distribution
 * constraint can be placed between any two or more classes. Any of these constraints can be either hard or soft. Hard
 * constraints cannot be violated and are marked as required. Soft constraints may not be satisfied and there is a
 * penalty for each violation. The necessary check methods for violations are also added here.
 * <p>
 * Created by Sina on 10-Mar-22
 *
 * @author Sina
 * @version 0.3
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
     * This is the logic and the primary checking of this constraint. It checks to see whether the requirement of this
     * distribution constraint is satisfied over the given pair of scheduled classes (events).
     * <p>
     * To see the exact procedure of this check method, refer to the JavaDoc of its corresponding class.
     * <p>
     * IMPORTANT: If this constraint is not defined over a pair of classes, this method, isSatisfied method,
     * violationCount method , and getViolations method should all be overwritten.
     *
     * @param e1 The first scheduled class (event) (Ci).
     * @param e2 The second scheduled class (event) (Cj).
     * @return True if the given event pair satisfy this constraint, and false otherwise.
     * @throws NullPointerException If a given event is not scheduled.
     */
    abstract boolean check(Event e1, Event e2) throws NullPointerException;

    /**
     * Checks if the given candidate solution (timetable) satisfies this distribution constraint over all the classes
     * defined in this constraint. As soon as there's a violation, it stops and returns false.
     *
     * @param timetable A candidate, or possible, solution.
     * @return True if the input timetable satisfies this constraint for all its classes, and false otherwise.
     */
    boolean isSatisfied(Timetable timetable) {
        Event e1, e2;
        for (int i = 0; i < classes.length - 1; i++) {
            e1 = timetable.getEvent(classes[i].getId());
            for (int j = i + 1; j < classes.length; j++) {
                e2 = timetable.getEvent(classes[j].getId());
                if (!check(e1, e2)) return false;
            }
        }
        return true;
    }

    /**
     * Counts the number of times that the given timetable violates this constraint over its classes.
     *
     * @param timetable A candidate, or possible, solution.
     * @return Violations count of the input timetable.
     */
    int violationCount(Timetable timetable) {
        Event e1, e2;
        int count = 0;
        for (int i = 0; i < classes.length - 1; i++) {
            e1 = timetable.getEvent(classes[i].getId());
            for (int j = i + 1; j < classes.length; j++) {
                e2 = timetable.getEvent(classes[j].getId());
                if (!check(e1, e2)) count++;
            }
        }
        return count;
    }

    /**
     * Returns the list of all violations of the given timetable for this distribution constraint.
     *
     * @param timetable A candidate, or possible, solution.
     * @return Violations list.
     */
    ArrayList<Violation> getViolations(Timetable timetable) {
        Event e1, e2;
        ArrayList<Violation> violations = new ArrayList<>();
        for (int i = 0; i < classes.length - 1; i++) {
            e1 = timetable.getEvent(classes[i].getId());
            for (int j = i + 1; j < classes.length; j++) {
                e2 = timetable.getEvent(classes[j].getId());
                if (!check(e1, e2)) violations.add(new Violation(e1, e2, this));
            }
        }
        return violations;
    }
}