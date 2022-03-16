package com.dataset.constraints;

/**
 * This class represents a distribution constraint that is soft (required="false"). Soft constraints may not be
 * satisfied and there is a penalty for each violation. When any of the constraints that can be validated on pairs of
 * classes is soft, the provided penalty is incurred for every pair of classes of the constraint that are in a
 * violation. In other words, if M pairs of classes do not satisfy the distribution constraint, the total penalty for
 * violation of this constraint is M × penalty.
 * <p>
 * Created by Sina on 10-Mar-22
 *
 * @author Sina
 * @version 0.4
 */
class SoftConstraint {
    private final DistributionConstraint constraint;
    private final int penalty;

    /**
     * Construct a soft distribution constraint object.
     *
     * @param constraint A distribution constraint.
     * @param penalty    The penalty of each violation.
     * @throws IllegalArgumentException If the given penalty is < 1.
     */
    SoftConstraint(DistributionConstraint constraint, int penalty) throws IllegalArgumentException {
        this.constraint = constraint;
        if (penalty < 1)
            throw new IllegalArgumentException("Soft constraint violation penalty for a distribution constraint must "
                    + "be > 0");
        this.penalty = penalty;
    }

    /**
     * Returns the constraint object of this hard constraint.
     *
     * @return Distribution Constraint.
     */
    DistributionConstraint getConstraint() {
        return constraint;
    }

    /**
     * Returns the penalty of this soft constraint for each violation.
     *
     * @return Penalty.
     */
    int getPenalty() {
        return penalty;
    }

    @Override
    public String toString() {
        return "SoftConstraint{" + "constraint=" + constraint + ", penalty=" + penalty + '}';
    }

    /**
     * Calculates the total penalty of violations (total penalty = penalty * count(violations)).
     *
     * @param violationsCount The number of occurred violations.
     * @return Total penalty.
     */
    final int calcPenalty(int violationsCount) {
        return penalty * violationsCount;
    }
}