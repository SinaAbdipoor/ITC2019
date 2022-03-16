package com.dataset.constraints;

/**
 * This class represents a distribution constraint that is hard (required="true"). A candidate solution (timetable)
 * which does not satisfy ALL hard constraints is deemed infeasible and worthless in the ITC 2019 dataset.
 * <p>
 * Created by Sina on 10-Mar-22
 *
 * @author Sina
 * @version 0.2
 */
class HardConstraint {
    private final DistributionConstraint constraint;

    /**
     * Construct a hard distribution constraint object.
     *
     * @param constraint A distribution constraint.
     */
    HardConstraint(DistributionConstraint constraint) {
        this.constraint = constraint;
    }

    /**
     * Returns the constraint object of this hard constraint.
     *
     * @return Distribution constraint.
     */
    DistributionConstraint getConstraint() {
        return constraint;
    }

    @Override
    public String toString() {
        return "HardConstraint{" + "constraint=" + constraint + '}';
    }
}