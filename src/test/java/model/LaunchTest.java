package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

class LaunchTest {

    @Test
    void getDateUtc() throws ParseException {
        String date = "2020-08-13T12:00:00.000";
        String expected = "Thu Aug 13 12:00:00 CEST 2020";
        Launch launch = new Launch(date, "");
        Assertions.assertEquals(expected, launch.getDateUtc().toString());
    }

    @Test
    void getYear() throws ParseException {
        String date = "2020-08-13T12:00:00.000";
        Launch launch = new Launch(date, "");
        Assertions.assertEquals(2020, launch.getYear());
    }

    @Test
    void getMissionName() throws ParseException {
        String date = "2020-08-13T12:00:00.000";
        String name = "name";
        Launch launch = new Launch(date, name);
        Assertions.assertEquals(name, launch.getMissionName());
    }

}
