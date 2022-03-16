package com.dataset;

import java.util.Arrays;

/**
 * This class represents a course in the ITC 2019 dataset. Each course has a unique id and consists of one or more
 * configurations named config in the XML (Lec-Rec and Lec-Rec-Lab) and identified by their unique ids such that each
 * student attends (some) classes in one configuration only. Each configuration consists of one or more subparts with
 * their unique ids (Lec-Rec-Lab configuration has three subparts: 3 Lecture, 4 Recitation and 5 Laboratory). Each
 * student must attend one class from each subpart of a single configuration. All students in the course configuration
 * must be sectioned into classes of each subpart such that their limit is not exceeded (one student attending
 * configuration Lec-Rec must take one class from each of its subparts 1 Lecture and 2 Recitation, e.g., Lec1 and Rec3).
 * Each class has a unique id and belongs to one subpart (classes Rec5, Rec6, Rec7, and Rec8 belong to subpart 4
 * Recitation). In the described problem, the imposed course structure is needed only for student sectioning, to be able
 * to evaluate the possible combinations of classes that a student needs to take. All the other constraints that could
 * be derived from the structure are already included in the distribution constraints given in the problem.
 * <p>
 * Created by Sina on 16-Dec-21
 *
 * @author Sina
 * @version 0.3
 */
class Course {
    private final int id;
    private final Config[] configurations;

    /**
     * Constructs a course object.
     * <p>
     * IMPORTANT: This constructor does not check the validity of the passed configs.
     *
     * @param id             The unique id of this course.
     * @param configurations The list of all configurations in this course.
     * @throws IllegalArgumentException If the id < 1.
     */
    Course(int id, Config[] configurations) throws IllegalArgumentException {
        if (id < 1) throw new IllegalArgumentException("Course id cannot be less than 1.");
        this.id = id;
        this.configurations = configurations;
    }

    /**
     * Returns the unique id of this course.
     *
     * @return Course id.
     */
    int getId() {
        return id;
    }

    /**
     * Returns the list of all configurations in this course.
     *
     * @return Configurations.
     */
    Config[] getConfigurations() {
        return configurations;
    }

    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", configurations=" + Arrays.toString(configurations) + '}';
    }
}