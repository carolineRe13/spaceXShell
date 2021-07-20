package controller;

import com.google.gson.Gson;
import model.CrewMember;
import model.DragonCapsule;
import model.Launch;
import org.json.JSONArray;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Service class to perform http requests and convert them into the respective classes.
 */
public class Service {

    /**
     * The base URL for http requests to query SpaceX information.
     */
    private static final String BASE_URL = "https://api.spacexdata.com/v4/";

    private Service() {
        // prevent instantiation
        throw new AssertionError();
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    private static JSONArray readJsonFromUrl(String url) throws IOException {
        try (InputStream is = new URL(url).openStream()) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String jsonText = readAll(rd);
            return new JSONArray(jsonText);
        }
    }

    static CrewMember[] parseCrewMembers() throws IOException {
        final JSONArray parsedCrewMembers = readJsonFromUrl(BASE_URL + "crew");
        final CrewMember[] crewMembers = new CrewMember[parsedCrewMembers.length()];
        final Gson g = new Gson();

        for (int i = 0; i < parsedCrewMembers.length(); i++) {
            crewMembers[i] = g.fromJson(String.valueOf(parsedCrewMembers.get(i)), CrewMember.class);
        }

        return crewMembers;
    }

    static DragonCapsule[] parseDragonCapsules() throws IOException {
        final JSONArray parsedDragonCapsules = readJsonFromUrl(BASE_URL + "capsules");
        final DragonCapsule[] dragonCapsules = new DragonCapsule[parsedDragonCapsules.length()];
        final Gson g = new Gson();

        for (int i = 0; i < parsedDragonCapsules.length(); i++) {
            dragonCapsules[i] = g.fromJson(String.valueOf(parsedDragonCapsules.get(i)), DragonCapsule.class);
        }

        return dragonCapsules;
    }

    static Launch[] parseLaunches() throws IOException {
        final JSONArray parsedLaunches = readJsonFromUrl(BASE_URL + "launches");
        final Launch[] launches = new Launch[parsedLaunches.length()];
        final Gson g = new Gson();

        for (int i = 0; i < parsedLaunches.length(); i++) {
            launches[i] = g.fromJson(String.valueOf(parsedLaunches.get(i)), Launch.class);
        }

        return launches;
    }

    static Launch[] parsePastLaunches() throws IOException {
        JSONArray parsedPastLaunches = readJsonFromUrl(BASE_URL + "launches/past");
        final Launch[] pastLaunches = new Launch[parsedPastLaunches.length()];
        final Gson g = new Gson();

        for (int i = 0; i < parsedPastLaunches.length(); i++) {
            pastLaunches[i] = g.fromJson(String.valueOf(parsedPastLaunches.get(i)), Launch.class);
        }

        return pastLaunches;
    }

}
