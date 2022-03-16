package com.dataset;

import java.util.Arrays;

/**
 * This class represents a class as a part of a subpart of a config of a course. Each class has a unique id, a limit
 * (capacity),  and a list of available rooms and times, each with a penalty. Only rooms that are big enough and meet
 * all the requirements(room type, required equipment, etc.) are listed. Each class needs to be assigned to one room and
 * one time from these. It is possible for a class to only need a time assignment and no room. In this case, there are
 * no rooms listed and the room attribute of the class is set to false.
 * <p>
 * Created by Sina on 15-Dec-21
 *
 * @author Sina
 * @version 0.6
 */
public class Class {
    private final int id;
    private final int limit;
    private final RoomAssignment[] possibleRoomAssignments;
    private final TimeAssignment[] possibleTimeAssignments;
    private final Class parent;

    /**
     * Creates a class object.
     *
     * @param id                      The unique id of the class.
     * @param limit                   The class limit (capacity).
     * @param possibleRoomAssignments All the possible rooms that can be assigned to this class while complying with all
     *                                the constraints. IF THE ROOM IS "FALSE", PASS NULL.
     * @param possibleTimeAssignments All the possible times that can be assigned to this class while complying with all
     *                                the constraints.
     * @param parent                  The parent class of this class. A student who attends this class must also attend
     *                                its parent class. IF THERE IS NO PARENT CLASS, PASS NULL.
     * @throws IllegalArgumentException If the class id < 1 or the class limit (capacity) < 0.
     */
    Class(int id, int limit, RoomAssignment[] possibleRoomAssignments, TimeAssignment[] possibleTimeAssignments,
          Class parent) throws IllegalArgumentException {
        if (id < 1) throw new IllegalArgumentException("Class id cannot be less than 1.");
        this.id = id;
        if (limit < 0) throw new IllegalArgumentException("Class limit (capacity) cannot be negative.");
        this.limit = limit;
        this.possibleRoomAssignments = possibleRoomAssignments;
        this.possibleTimeAssignments = possibleTimeAssignments;
        this.parent = parent;
    }

    /**
     * Returns the unique id of this class.
     *
     * @return Class id.
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the limit (capacity) of this class.
     *
     * @return Class limit.
     */
    int getLimit() {
        return limit;
    }

    /**
     * Returns all the possible rooms that can be assigned to this class. Returns null if this class has no rooms.
     *
     * @return All possible rooms assignments.
     */
    public RoomAssignment[] getPossibleRoomAssignments() {
        return possibleRoomAssignments;
    }

    /**
     * Returns all the possible times that can be assigned to this class.
     *
     * @return All possible time assignments.
     */
    public TimeAssignment[] getPossibleTimeAssignments() {
        return possibleTimeAssignments;
    }

    /**
     * Returns the parent class of this class. Returns null if there is no parent-child relationship for this class.
     *
     * @return Parent class.
     */
    Class getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return "Class{" + "id=" + id + ", limit=" + limit + ", possibleRoomAssignments="
                + Arrays.toString(possibleRoomAssignments) + ", possibleTimeAssignments="
                + Arrays.toString(possibleTimeAssignments) + ", parent=" + parent + '}';
    }

    /**
     * Checks if this class requires a room to be assigned.
     *
     * @return True if this class requires a room and false otherwise.
     */
    public boolean requiresRoom() {
        return possibleRoomAssignments != null;
    }
}