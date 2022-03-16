package com.dataset;

import java.util.Arrays;

/**
 * This class represents a room in a problem instance of the ITC 2019 dataset. Each room is specified by its id and
 * capacity. A room may not be available at certain times, which are defined by unavailable elements using the days of
 * the week, the start time slot, and a length in slots for a set of weeks during the semester.
 * <p>
 * Created by Sina on 13-Dec-21
 *
 * @author Sina
 * @version 0.6
 */
class Room {
    private final int id;
    private final int capacity;
    private final Time[] unavailable;

    /**
     * Constructs a room object.
     *
     * @param id          The unique room id.
     * @param capacity    The room capacity.
     * @param unavailable The room unavailable times.
     * @throws IllegalArgumentException When the room id < 1 or the room capacity < 0.
     */
    Room(int id, int capacity, Time[] unavailable) throws IllegalArgumentException {
        if (id < 1) throw new IllegalArgumentException("Room id cannot be less than 1.");
        this.id = id;
        if (capacity < 0) throw new IllegalArgumentException("Room capacity cannot be less than 0.");
        this.capacity = capacity;
        this.unavailable = unavailable;
    }

    /**
     * Returns the room id.
     *
     * @return Room id.
     */
    int getId() {
        return id;
    }

    /**
     * Returns the room capacity.
     *
     * @return Room capacity.
     */
    int getCapacity() {
        return capacity;
    }

    /**
     * Returns all the unavailable times of this room.
     *
     * @return Unavailable times.
     */
    Time[] getUnavailable() {
        return unavailable;
    }

    @Override
    public String toString() {
        return "Room{" + "id=" + id + ", capacity=" + capacity + ", unavailable=" + Arrays.toString(unavailable) + '}';
    }
}