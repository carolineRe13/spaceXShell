package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

/**
 * Java bean to store specific information about a SpaceX launch.
 */
public class Launch {

    /**
     * The launch date in coordinated universal time.
     */
    private final Date date_utc;

    /**
     * The name of the launched mission.
     */
    private final String name;

    /**
     * Initializes a new {@code Launch} instance.
     *
     * @param date_utc The launch date.
     * @param name     The name of the launched mission.
     * @throws ParseException if {@code date_utc} is not in UTC format.
     */
    public Launch(final String date_utc, final String name) throws ParseException {
        final DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.ENGLISH);
        this.date_utc = format.parse(date_utc);
        this.name = name;
    }

    /**
     * Returns the launch date of this {@code Launch} in UTC format.
     *
     * @return the launch date.
     */
    public Date getDateUtc() {
        return date_utc;
    }

    /**
     * Returns the launch year of this {@code Launch}.
     *
     * @return the launch year.
     */
    public int getYear() {
        final LocalDate localDate = this.date_utc.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate.getYear();
    }

    /**
     * Returns the mission name of this {@code Launch}.
     *
     * @return the mission name.
     */
    public String getMissionName() {
        return name;
    }

}
