package com.dataset;

import java.util.Arrays;

/**
 * This class represents the travel time between the rooms of the ITC 2019 dataset, which expresses the number of
 * timeslots needed to get from one room to other rooms.
 * <p>
 * Created by Sina on 17-Dec-21
 *
 * @author Sina
 * @version 0.5
 */
class TravelTime {
    private static TravelTime travelTimeInstance = null;
    private final int[][] travelTime;

    private TravelTime(int roomNo) {
        travelTime = new int[roomNo][roomNo];
    }

    /**
     * Initializes (creates an instance for) the static constructor of this singleton class. This method has to be
     * performed FIRST (only once) to have the object of this class.
     *
     * @param roomNo The total number of rooms in the problem instance.
     * @return The object or instance of this singleton class.
     * @throws ExceptionInInitializerError If this class has been initialized before.
     */
    static TravelTime createInstance(int roomNo) throws ExceptionInInitializerError {
        if (travelTimeInstance != null)
            throw new ExceptionInInitializerError("An object of this singleton class has already been created.");
        travelTimeInstance = new TravelTime(roomNo);
        return travelTimeInstance;
    }

    /**
     * Returns the singleton instance of travel time.
     *
     * @return The travel time instance
     * @throws NullPointerException If this singleton class has not yet been initialized or created.
     */
    static TravelTime getInstance() throws NullPointerException {
        if (travelTimeInstance == null)
            throw new NullPointerException("An object of this singleton class must be created first (using the "
                    + "createInstance method).");
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