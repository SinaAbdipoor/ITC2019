package com.dataset;

/**
 * This class represents a possible assignment of a certain room to a certain event with its given penalty as predefined
 * in the ITC 2019 dataset.
 * <p>
 * Created by Sina on 15-Dec-21
 *
 * @author Sina
 * @version 0.3
 */
public class RoomAssignment {
    private final Room room;
    private final int penalty;

    /**
     * Constructs a room assignment object.
     *
     * @param room    The room to be assigned to the event.
     * @param penalty The penalty of assigning this room to the event as defined in the ITC 2019 dataset.
     * @throws IllegalArgumentException If the penalty is below 0.
     */
    RoomAssignment(Room room, int penalty) throws IllegalArgumentException {
        this.room = room;
        if (penalty < 0) throw new IllegalArgumentException("Room assignment penalty cannot be negative.");
        this.penalty = penalty;
    }

    /**
     * Returns the room to be assigned.
     *
     * @return Room.
     */
    public Room getRoom() {
        return room;
    }

    /**
     * Returns the penalty of assigning this room to the event.
     *
     * @return Room assignment penalty.
     */
    public int getPenalty() {
        return penalty;
    }

    @Override
    public String toString() {
        return "RoomAssignment{" + "room=" + room + ", penalty=" + penalty + '}';
    }
}