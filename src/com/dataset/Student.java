package com.dataset;

import java.util.Arrays;

/**
 * This class represents a student with a unique id and a list of desired courses of the ITC 2019 dataset.
 * <p>
 * Created by Sina on 15-Dec-21
 *
 * @author Sina
 * @version 0.4
 */
public class Student {
    private final int id;
    private final Course[] courses;

    /**
     * Constructs a student object.
     * <p>
     * IMPORTANT: This constructor does not check the validity of the passed courses.
     *
     * @param id      The unique student id.
     * @param courses The list of courses that this student needs to attend.
     * @throws IllegalArgumentException If the student id < 1.
     */
    Student(int id, Course[] courses) throws IllegalArgumentException {
        if (id < 1) throw new IllegalArgumentException("Student id cannot be less than 1.");
        this.id = id;
        this.courses = courses;
    }

    /**
     * Returns the unique id of this student.
     *
     * @return Student id.
     */
    int getId() {
        return id;
    }

    /**
     * Returns the list of courses that this student needs to attend.
     *
     * @return Courses
     */
    Course[] getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", courses=" + Arrays.toString(courses) + '}';
    }
}