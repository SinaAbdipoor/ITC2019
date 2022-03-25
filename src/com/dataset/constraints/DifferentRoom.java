package com.dataset.constraints;

import com.dataset.Class;
import com.utils.Event;

/**
 * This class represents the Distribution Constraint (C9): DifferentRoom: Given classes should be placed in different
 * rooms. This means that (Ci.room ≠ Cj.room) for any two classes Ci and Cj from the constraint.
 * <p>
 * Created by Sina on 15-Mar-22
 *
 * @author Sina
 * @version 0.1
 */
class DifferentRoom extends PairDistributionConstraint {

    /**
     * Constructs a DifferentRoom constraint object over the given classes.
     *
     * @param classes The list of classes that this constraint is applied to.
     */
    DifferentRoom(Class[] classes) {
        super(classes);
    }

    @Override
    boolean check(Event e1, Event e2) throws NullPointerException {
        // Ci.room ≠ Cj.room
        return e1.getRoomAssignment().getRoom() != e2.getRoomAssignment().getRoom();
    }
}