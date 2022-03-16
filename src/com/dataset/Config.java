package com.dataset;

import java.util.Arrays;

/**
 * This class represents a configuration of a course of the ITC 2019 dataset. Each course has a unique id and consists
 * of one or more configurations named config in the XML (Lec-Rec and Lec-Rec-Lab) and identified by their unique ids
 * such that each student attends (some) classes in one configuration only. Each configuration consists of one or more
 * subparts with their unique ids (Lec-Rec-Lab configuration has three subparts: 3 Lecture, 4 Recitation and
 * 5 Laboratory). Each student must attend one class from each subpart of a single configuration. All students in the
 * course configuration must be sectioned into classes of each subpart such that their limit is not exceeded (one
 * student attending configuration Lec-Rec must take one class from each of its subparts 1 Lecture and 2 Recitation,
 * e.g., Lec1 and Rec3). Each class has a unique id and belongs to one subpart (classes Rec5, Rec6, Rec7, and Rec8
 * belong to subpart 4 Recitation).
 * <p>
 * Created by Sina on 16-Dec-21
 *
 * @author Sina
 * @version 0.2
 */
class Config {
    private final int id;
    private final Subpart[] subparts;

    /**
     * Constructs a config object.
     * <p>
     * IMPORTANT: This constructor does not check the validity of the passed subparts.
     *
     * @param id       The unique config id.
     * @param subparts The list of subparts in this config.
     * @throws IllegalArgumentException If the config id < 1.
     */
    Config(int id, Subpart[] subparts) throws IllegalArgumentException {
        if (id < 1) throw new IllegalArgumentException("Config id cannot be less than 1.");
        this.id = id;
        this.subparts = subparts;
    }

    /**
     * Returns the unique id of this config.
     *
     * @return Config id.
     */
    int getId() {
        return id;
    }

    /**
     * Returns the list of all subparts in this config.
     *
     * @return Subparts.
     */
    Subpart[] getSubparts() {
        return subparts;
    }

    @Override
    public String toString() {
        return "Config{" + "id=" + id + ", subparts=" + Arrays.toString(subparts) + '}';
    }
}