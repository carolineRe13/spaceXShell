package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CrewMemberTest {

    @Test
    void getLaunches() {
        String[] launches = new String[]{""};
        CrewMember crewMember = new CrewMember(launches);
        Assertions.assertArrayEquals(launches, crewMember.getLaunches());
    }

}
