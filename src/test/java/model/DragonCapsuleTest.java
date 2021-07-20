package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DragonCapsuleTest {

    @Test
    void getCurrentStatus() {
        String currentStatus = "update";
        DragonCapsule dragonCapsule = new DragonCapsule(currentStatus, "");
        Assertions.assertEquals(currentStatus, dragonCapsule.getCurrentStatus());
    }

    @Test
    void getSerial() {
        String serial = "serial";
        DragonCapsule dragonCapsule = new DragonCapsule("", serial);
        Assertions.assertEquals(serial, dragonCapsule.getSerial());
    }

}
