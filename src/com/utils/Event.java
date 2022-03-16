package com.utils;

import com.dataset.RoomAssignment;
import com.dataset.Student;
import com.dataset.TimeAssignment;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class represents an event, which is a class with an assigned time, room, and a list of students. In other
 * words, an event is a scheduled class and the building block of the timetable. An assignment of a room to a class is
 * not necessary for those classes that do not require a room (as defined in the problem instance).
 * <p>
 * Created by Sina on 19-Feb-22
 *
 * @author Sina
 * @version 0.4
 */
public class Event {

    //TODO: Add addStudent method with its checks (class has capacity, parent class taken, student wanted this course,
    // one class from each subpart of a single configuration taken) here or in the Timetable class.

    private final com.dataset.Class theClass;
    private final ArrayList<Student> students = new ArrayList<>();
    private TimeAssignment timeAssignment;
    private RoomAssignment roomAssignment;

    /**
     * Constructs an event (scheduled class) object.
     *
     * @param theClass The corresponding class for this event.
     */
    Event(com.dataset.Class theClass) {
        this.theClass = theClass;
    }

    /**
     * Returns the class this event is trying to schedule.
     *
     * @return This event's class.
     */
    com.dataset.Class getTheClass() {
        return theClass;
    }

    /**
     * Returns the current time assigned to this event's class.
     *
     * @return Current time assignment.
     * @throws NullPointerException If no time has been assigned to this event's class yet.
     */
    public TimeAssignment getTimeAssignment() throws NullPointerException {
        return timeAssignment;
    }

    /**
     * Returns the current room assigned to this event's class.
     * <p>
     * IMPORTANT: Some classes do not require a room. In which case, this getter simply returns null.
     *
     * @return Current room assignment.
     * @throws NullPointerException If this event's class does not require a room or if no room has been assigned to
     *                              this event's class yet.
     */
    public RoomAssignment getRoomAssignment() throws NullPointerException {
        return roomAssignment;
    }

    /**
     * Returns the list of students assigned to this event.
     *
     * @return Students.
     */
    ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * Assigns a time to this event's class and returns the penalty associated with this time assignment.
     * <p>
     * Running time = O(n), where n is the number of possible time assignments for this event's class. To reduce the
     * running time to O(1), comment the first if in the method. However, doing so will allow invalid (not included in
     * the possible time assignments of this event's class) time assignments.
     *
     * @param timeAssignment The time to be assigned to this event's class.
     * @return The penalty for this time assignment. If no previous time assignment -> penalty = the penalty of this
     * assignment, otherwise -> penalty = the penalty of this assignment - the penalty of the previous assignment.
     * @throws IllegalArgumentException If the given time assignment is in the possible time assignments of this
     *                                  event's class (only when the first if in this method is performed -> increasing
     *                                  the running time from O(1) to O(n)).
     * @throws NullPointerException     If this event's class or the given time assignment is null.
     */
    int setTimeAssignment(TimeAssignment timeAssignment) throws IllegalArgumentException {
        //TODO OPTIMIZATION: For faster running time, comment the following if. However, doing so will allow invalid
        // (not included in the possible time assignments of this event's class) time assignments.
        if (!Arrays.asList(theClass.getPossibleTimeAssignments()).contains(timeAssignment))
            throw new IllegalArgumentException("The given time assignment does not exist in the possible time "
                    + "assignments of this event's class.");
        // COMMENT UNTIL HERE

        //If no previous time assignment -> penalty = the penalty of this assignment,
        // otherwise -> penalty = the penalty of this assignment - the penalty of the previous assignment.
        int penalty = this.timeAssignment == null ? timeAssignment.getPenalty() : timeAssignment.getPenalty()
                - this.timeAssignment.getPenalty();
        this.timeAssignment = timeAssignment;
        return penalty;
    }

    /**
     * Assigns a room to this event's class and returns the penalty associated with this room assignment.
     * IMPORTANT: Some classes might not require a room to be assigned.
     * <p>
     * Running time = O(n), where n is the number of possible room assignments for this event's class. To reduce the
     * running time to O(1), comment the first if in the method. However, doing so will allow invalid (not included in
     * the possible room assignments of this event's class) room assignments.
     *
     * @param roomAssignment The room to be assigned to this event's class.
     * @return The penalty for this room assignment. If no previous room assignment -> penalty = the penalty of this
     * assignment, otherwise -> penalty = the penalty of this assignment - the penalty of the previous assignment.
     * @throws IllegalArgumentException If the given room assignment is in the possible room assignments of this
     *                                  event's class (only when the first if in this method is performed -> increasing
     *                                  the running time from O(1) to O(n)).
     * @throws NullPointerException     If this event's class or the given room assignment is null.
     */
    int setRoomAssignment(RoomAssignment roomAssignment) throws IllegalArgumentException, NullPointerException {
        //TODO OPTIMIZATION: For faster running time, comment the following if. However, doing so will allow invalid
        // (not included in the possible room assignments of this event's class) room assignments.
        if (!Arrays.asList(theClass.getPossibleRoomAssignments()).contains(roomAssignment))
            throw new IllegalArgumentException("The given room assignment does not exist in the possible room "
                    + "assignments of this event's class.");
        // COMMENT UNTIL HERE

        //If no previous room assignment -> penalty = the penalty of this assignment,
        // otherwise -> penalty = the penalty of this assignment - the penalty of the previous assignment.
        int penalty = this.roomAssignment == null ? roomAssignment.getPenalty() : roomAssignment.getPenalty()
                - this.roomAssignment.getPenalty();
        this.roomAssignment = roomAssignment;
        return penalty;
    }

    @Override
    public String toString() {
        return "Event{" + "theClass=" + theClass + ", timeAssignment=" + timeAssignment + ", roomAssignment="
                + roomAssignment + ", students=" + students + '}';
    }

    /**
     * Checks if this event is scheduled (the class of this event is assigned a time and a room (if it needs a room)).
     *
     * @return True if this event is scheduled and false otherwise.
     */
    boolean isScheduled() {
        return (timeAssignment != null) && (!theClass.requiresRoom() || roomAssignment != null);
    }
}