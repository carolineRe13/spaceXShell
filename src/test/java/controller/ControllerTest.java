package controller;

import model.DragonCapsule;
import model.Launch;
import org.apache.commons.collections4.MultiValuedMap;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

class ControllerTest {

    @org.junit.jupiter.api.Test
    void getNumberOfCrewInSpace() throws IOException {
        int crewInSpace = Controller.getNumberOfCrewInSpace();
        Assertions.assertTrue(crewInSpace >= 0);
    }

    @org.junit.jupiter.api.Test
    void getDragonCapsules() throws IOException {
        DragonCapsule[] dragonCapsules = Controller.getDragonCapsules();
        Assertions.assertNotNull(dragonCapsules);
    }

    @org.junit.jupiter.api.Test
    void getLaunches() throws IOException {
        MultiValuedMap<Integer, Launch> crewInSpace = Controller.getLaunches();
        Assertions.assertNotNull(crewInSpace);
    }

    @org.junit.jupiter.api.Test
    void getNumberOfLaunches() throws IOException {
        int launches = Controller.getNumberOfLaunches();
        Assertions.assertTrue(launches >= 0);
    }

}
