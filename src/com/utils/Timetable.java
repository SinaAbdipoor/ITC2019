package com.utils;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class represents a possible solution or timetable (a set of events, scheduled classes) in the ITC 2019 dataset.
 * It also includes the quality (fitness/cost) of this possible timetable according to the constraints and violations
 * defined in the problem instance.
 * <p>
 * IMPORTANT: For optimization purposes, a timetable is defined complete. In other words, a timetable consists of n
 * events (scheduled classes), where event [0], event [1], event [2], ..., event [n-1] corresponds to class with
 * id = 1, class with id = 2, class with id = 3, ..., class with id = n. Therefore, it is assumed that all classes have
 * unique and consequent ids.
 * <p>
 * Created by Sina on 28-Feb-22
 *
 * @author Sina
 * @version 0.3
 */
public class Timetable {

    //TODO: Add timetable performance assessment fields (feasibility, time penalty, room penalty, student conflicts,
    // distribution constraints).

    private final Event[] events;

    /**
     * Constructs a timetable (a possible solution) object and initiates an empty timetable (an array of events
     * (scheduled events) of size n, where n is the number of classes in the problem instance and corresponds to the
     * unique id of the class (events [0] includes the class with id = 1, events [1] includes the class with id = 2,
     * ..., and events [n - 1] includes the class with id = n)).
     *
     * @param classNo The number of classes in the problem instance.
     */
    Timetable(int classNo) {
        events = new Event[classNo];
    }

    /**
     * Returns all the events in the timetable.
     *
     * @return Events.
     */
    Event[] getEvents() {
        return events;
    }

    /**
     * Returns the event containing the class with the given id.
     *
     * @param classId The class id of the desired id.
     * @return The event with the given class id.
     */
    public Event getEvent(int classId) {
        return events[classId - 1];
    }

    /**
     * Adds the input event to the timetable.
     *
     * @param event The event (scheduled class with unique id) to be added to the timetable.
     * @throws IllegalArgumentException If an event with the same class id already exists in the timetable.
     */
    void setEvent(Event event) throws IllegalArgumentException {
        if (events[event.getTheClass().getId() - 1] != null)
            throw new IllegalArgumentException("An event with this class id already exists.");
        events[event.getTheClass().getId() - 1] = event;
    }

    @Override
    public String toString() {
        return "Timetable{" + "events=" + Arrays.toString(events) + '}';
    }

    /**
     * Returns the class ids of the events that are not added to this timetable yet.
     *
     * @return Missing class ids.
     */
    ArrayList<Integer> getMissingEvents() {
        ArrayList<Integer> missingIds = new ArrayList<>();
        for (Event event : events)
            if (event == null) missingIds.add(event.getTheClass().getId());
        return missingIds;
    }

    /**
     * Returns the list of all events in this timetable that have not been scheduled (their class has not been assigned
     * a time and a room (if needed)) yet.
     *
     * @return The list of unscheduled events in this timetable. Returns null if all events in this timetable are not
     * set (added).
     */
    ArrayList<Event> getUnscheduledEvents() {
        ArrayList<Event> unScheduledEvents = new ArrayList<>();
        for (Event event : events)
            if (!event.isScheduled()) unScheduledEvents.add(event);
        return unScheduledEvents;
    }
}