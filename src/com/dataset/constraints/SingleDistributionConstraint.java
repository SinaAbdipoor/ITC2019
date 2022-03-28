package com.dataset.constraints;

import com.dataset.Class;
import com.utils.Event;
import com.utils.Timetable;

import java.util.ArrayList;

/**
 * This abstract class represents a single distribution constraint as defined in the ITC 2019 dataset. A distribution
 * constraint can either be pair or single. While a pair distribution constraint is applied and check over a pair of
 * events (scheduled classes), a single distribution constraint evaluates and performs the check method over a single
 * event (scheduled class). The necessary check methods for violations are also added here.
 * <p>
 * Created by Sina on 28-Mar-22
 *
 * @author Sina
 * @version 0.1
 */
abstract class SingleDistributionConstraint extends DistributionConstraint {

    /**
     * Constructs a single distribution constraint over the given classes.
     *
     * @param classes The list of classes that this constraint is applied to.
     */
    SingleDistributionConstraint(Class[] classes) {
        super(classes);
    }

    /**
     * This is the logic and the primary checking of this constraint. It checks to see whether the requirement of this
     * distribution constraint is satisfied over the given scheduled class (event) and returns its penalty.
     * <p>
     * To see the exact procedure of this check method, refer to the JavaDoc of its corresponding class.
     *
     * @param event The scheduled class (event) (Ci).
     * @return 0 if this constraint is satisfied, otherwise its respective penalty.
     * @throws NullPointerException If a given event is not scheduled.
     */
    abstract int check(Event event) throws NullPointerException;

    @Override
    boolean isSatisfied(Timetable timetable) {
        for (Class aClass : getClasses())
            if (check(timetable.getEvent(aClass.getId())) != 0) return false;
        return true;
    }

    @Override
    int violationCount(Timetable timetable) {
        int counter = 0;
        for (Class aClass : getClasses())
            counter += check(timetable.getEvent(aClass.getId()));
        return counter;
    }

    @Override
    ArrayList<Violation> getViolations(Timetable timetable) {
        ArrayList<Violation> violations = new ArrayList<>();
        for (Class aClass : getClasses())
            if (check(timetable.getEvent(aClass.getId())) != 0)
                violations.add(new Violation(timetable.getEvent(aClass.getId()), null, this));
        return violations;
    }
}