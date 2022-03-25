package com.dataset.constraints;

import com.dataset.Class;
import com.utils.Event;
import com.utils.Timetable;

import java.util.ArrayList;

/**
 * This abstract class represents a pair distribution constraint as defined in the ITC 2019 dataset. A distribution
 * constraint can either be pair or single. While a pair distribution constraint is applied and check over a pair of
 * events (scheduled classes), a single distribution constraint evaluates and performs the check method over a single
 * event (scheduled class). The necessary check methods for violations are also added here.
 * <p>
 * Created by Sina on 25-Mar-22
 *
 * @author Sina
 * @version 0.1
 */
abstract class PairDistributionConstraint extends DistributionConstraint {

    /**
     * Constructs a pair distribution constraint over the given classes.
     *
     * @param classes The list of classes that this constraint is applied to.
     */
    PairDistributionConstraint(Class[] classes) {
        super(classes);
    }

    /**
     * This is the logic and the primary checking of this constraint. It checks to see whether the requirement of this
     * distribution constraint is satisfied over the given pair of scheduled classes (events).
     * <p>
     * To see the exact procedure of this check method, refer to the JavaDoc of its corresponding class.
     *
     * @param e1 The first scheduled class (event) (Ci).
     * @param e2 The second scheduled class (event) (Cj).
     * @return True if the given event pair satisfy this constraint, and false otherwise.
     * @throws NullPointerException If a given event is not scheduled.
     */
    abstract boolean check(Event e1, Event e2) throws NullPointerException;

    @Override
    boolean isSatisfied(Timetable timetable) {
        Event e1, e2;
        for (int i = 0; i < getClasses().length - 1; i++) {
            e1 = timetable.getEvent(getClasses()[i].getId());
            for (int j = i + 1; j < getClasses().length; j++) {
                e2 = timetable.getEvent(getClasses()[j].getId());
                if (!check(e1, e2)) return false;
            }
        }
        return true;
    }

    @Override
    int violationCount(Timetable timetable) {
        Event e1, e2;
        int count = 0;
        for (int i = 0; i < getClasses().length - 1; i++) {
            e1 = timetable.getEvent(getClasses()[i].getId());
            for (int j = i + 1; j < getClasses().length; j++) {
                e2 = timetable.getEvent(getClasses()[j].getId());
                if (!check(e1, e2)) count++;
            }
        }
        return count;
    }

    @Override
    ArrayList<Violation> getViolations(Timetable timetable) {
        Event e1, e2;
        ArrayList<Violation> violations = new ArrayList<>();
        for (int i = 0; i < getClasses().length - 1; i++) {
            e1 = timetable.getEvent(getClasses()[i].getId());
            for (int j = i + 1; j < getClasses().length; j++) {
                e2 = timetable.getEvent(getClasses()[j].getId());
                if (!check(e1, e2)) violations.add(new Violation(e1, e2, this));
            }
        }
        return violations;
    }
}