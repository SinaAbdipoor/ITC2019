package com.dataset;

import java.util.Arrays;

/**
 * This class represents a subpart as a component of a config of a course of the ITC 2019 dataset. Each student must
 * attend one class from each subpart of a single configuration. All students in the course configuration must be
 * sectioned into classes of each subpart such that their limit is not exceeded.
 * <p>
 * Created by Sina on 16-Dec-21
 *
 * @author Sina
 * @version 0.2
 */
class Subpart {
    private final int id;
    private final Class[] classes;

    /**
     * Constructs a subpart object.
     * <p>
     * IMPORTANT: This constructor does not check the validity of the passed classes.
     *
     * @param id      The unique subpart id.
     * @param classes The list of classes in this subpart.
     * @throws IllegalArgumentException If the subpart id < 1.
     */
    Subpart(int id, Class[] classes) throws IllegalArgumentException {
        if (id < 1) throw new IllegalArgumentException("Subpart id cannot be less than 1.");
        this.id = id;
        this.classes = classes;
    }

    /**
     * Returns the unique id of this subpart.
     *
     * @return Subpart id.
     */
    int getId() {
        return id;
    }

    /**
     * Returns the list of all classes in this subpart.
     *
     * @return Subpart classes.
     */
    Class[] getClasses() {
        return classes;
    }

    @Override
    public String toString() {
        return "Subpart{" + "id=" + id + ", classes=" + Arrays.toString(classes) + '}';
    }
}