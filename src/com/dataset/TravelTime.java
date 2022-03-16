package com.dataset;

import java.util.Arrays;

/**
 * This class represents the travel time between the rooms of the ITC 2019 dataset, which expresses the number of
 * timeslots needed to get from one room to other rooms.
 * <p>
 * Created by Sina on 17-Dec-21
 *
 * @author Sina
 * @version 0.4
 */
class TravelTime {
    private static TravelTime travelTimeInstance = null;
    private final int[][] travelTime;

    private TravelTime(int roomNo) {
        travelTime = new int[roomNo][roomNo];
    }

    /**
     * Constructs a SINGLETON travel time object.
     *
     * @param roomNo The number of all rooms.
     * @return The travel time object.
     */
    static TravelTime getInstance(int roomNo) {
        if (travelTimeInstance == null) travelTimeInstance = new TravelTime(roomNo);
        return travelTimeInstance;
    }

    /**
     * Returns the number of timeslots needed to go from room 1 (id1) to room 2 (id2).
     *
     * @param id1 The id of room 1 (starting point).
     * @param id2 The id of room 2 (destination).
     * @return The number of timeslots needed to go from room 1 to room 2.
     * @throws ArrayIndexOutOfBoundsException If the given index is < 0 or >= size.
     */
    int getTravelTime(int id1, int id2) throws ArrayIndexOutOfBoundsException {
        return travelTime[id1 - 1][id2 - 1];
    }

    /**
     * Sets the value (timeslots) of travel time between room 1 (id1) and room 2 (id2).
     *
     * @param id1   The id of room 1 (starting point).
     * @param id2   The id of room 2 (destination).
     * @param value The number of timeslots needed to go from room 1 to room 2.
     * @throws ArrayIndexOutOfBoundsException If the given index is < 0 or >= size.
     */
    void setTravelTime(int id1, int id2, int value) throws ArrayIndexOutOfBoundsException {
        travelTime[id1 - 1][id2 - 1] = value;
        travelTime[id2 - 1][id1 - 1] = value;
    }

    @Override
    public String toString() {
        return "TravelTime{" + "travelTime=" + Arrays.toString(travelTime) + '}';
    }
}