package controller;

import model.CrewMember;
import model.DragonCapsule;
import model.Launch;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.HashSetValuedHashMap;

import java.io.IOException;

/**
 * Controller class to parse server requests and responses between the UI and Service.
 */
public class Controller {

    private Controller() {
        // prevent instantiation
        throw new AssertionError();
    }

    /**
     * Returns the number of crew members that were sent to space by SpaceX.
     *
     * @return the number of persons SpaceX sent into space.
     * @throws IOException if an I/O exception occurs.
     */
    public static int getNumberOfCrewInSpace() throws IOException {
        final CrewMember[] crewMembers = Service.parseCrewMembers();
        int crewInSpace = 0;

        for (CrewMember crewMember : crewMembers) {
            final String[] launches = crewMember.getLaunches();
            if (launches.length != 0) {
                // check if the crew member had a launch yet
                crewInSpace++;
            }
        }

        return crewInSpace;
    }

    /**
     * Returns the dragon capsules used by SpaceX.
     *
     * @return the dragon capsules of SpaceX.
     * @throws IOException if an I/O exception occurs.
     */
    public static DragonCapsule[] getDragonCapsules() throws IOException {
        return Service.parseDragonCapsules();
    }

    /**
     * Returns the launches sorted per year by SpaceX.
     *
     * @return the launches of SpaceX per year.
     * @throws IOException if an I/O exception occurs.
     */
    public static MultiValuedMap<Integer, Launch> getLaunches() throws IOException {
        Launch[] launches = Service.parseLaunches();
        return sortLaunchesPerYear(launches);
    }

    private static MultiValuedMap<Integer, Launch> sortLaunchesPerYear(Launch[] launches) {
        MultiValuedMap<Integer, Launch> launchesPerYear = new HashSetValuedHashMap<>();
        for (Launch launch : launches) {
            launchesPerYear.put(launch.getYear(), launch);
        }
        return launchesPerYear;
    }

    /**
     * Returns the number launches performed by SpaceX.
     *
     * @return the number of launches of SpaceX.
     * @throws IOException if an I/O exception occurs.
     */
    public static int getNumberOfLaunches() throws IOException {
        Launch[] pastLaunches = Service.parsePastLaunches();
        return pastLaunches.length;
    }

}
