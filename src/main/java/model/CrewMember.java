package model;

/**
 * Java bean to store specific information about a SpaceX crew member.
 */
public class CrewMember {

    /**
     * The launches of this crew member (encoded in hexadecimal format).
     */
    private final String[] launches;

    /**
     * Initializes a new {@code CrewMember} instance.
     *
     * @param launches the launches of the crew member.
     */
    public CrewMember(final String[] launches) {
        this.launches = launches;
    }

    /**
     * Returns the launches of this {@code CrewMember} encoded in hexadecimals.
     *
     * @return the launches.
     */
    public String[] getLaunches() {
        return launches;
    }

}
