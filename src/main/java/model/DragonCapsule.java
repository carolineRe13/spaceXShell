package model;

/**
 * Java bean to store specific information about a SpaceX dragon capsule.
 */
public class DragonCapsule {

    /**
     * The current status.
     */
    private final String last_update;

    /**
     * The serial version.
     */
    private final String serial;

    /**
     * Initializes a new {@code DragonCapsule} instance.
     *
     * @param lastUpdate The current status of the capsule.
     * @param serial     The serial version of the capsule.
     */
    public DragonCapsule(final String lastUpdate, final String serial) {
        this.last_update = lastUpdate;
        this.serial = serial;
    }

    /**
     * Returns the current status of this {@code DragonCapsule}.
     *
     * @return the current status.
     */
    public String getCurrentStatus() {
        return last_update;
    }

    /**
     * Returns the serial version of this {@code DragonCapsule}.
     *
     * @return the serial version.
     */
    public String getSerial() {
        return serial;
    }

}
