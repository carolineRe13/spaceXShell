package ui;

import controller.Controller;
import model.DragonCapsule;
import model.Launch;
import org.apache.commons.collections4.MultiValuedMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Command line interface for getting some information about SpaceX.
 */
public class Shell {

    private Shell() {
        // prevent instantiation
        throw new AssertionError();
    }

    /**
     * Starts a new shell that waits for user input.
     *
     * @param args command line arguments.
     * @throws IOException if an I/O exception occurs.
     */
    public static void main(String[] args) throws IOException {
        final BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        run(stdin);
    }

    private static void run(final BufferedReader stdin) throws IOException {
        boolean run = true;

        System.out.println("=============================================================");
        System.out.println("|             ++++++++++++++++++++++++++++++++              |");
        System.out.println("|             +  Welcome to the spaceX shell +              |");
        System.out.println("|             + Enter help to see the manual +              |");
        System.out.println("|             ++++++++++++++++++++++++++++++++              |");
        System.out.println("=============================================================\n");

        while (run) {
            System.out.print("spacex> ");

            final String input = stdin.readLine();
            if (input == null) {
                break;
            }

            final String[] tokens = input.trim().split("\\s+");
            final String firstInput = tokens[0];
            final ShellCommand command = identifyCommand(firstInput);

            switch (command) {
                case HELP:
                    command.helpPrinter();
                    break;
                case SPECIFIC_LAUNCH:
                    launchesPerYear(stdin);
                    break;
                case CAPSULES:
                    capsulesByIndex(stdin);
                    break;
                case LAUNCHES:
                    System.out.println(command.getDescription() + Controller.getNumberOfLaunches());
                    break;
                case CREW:
                    System.out.println(command.getDescription() + Controller.getNumberOfCrewInSpace());
                    break;
                case QUIT:
                    run = false;
                    break;
                default:
                    break;
            }
        }
    }

    private static void launchesPerYear(BufferedReader stdin) throws IOException {
        System.out.println("Please enter the year:");
        // data structure similar to HashMap allowing duplicates
        final MultiValuedMap<Integer, Launch> launches = Controller.getLaunches();
        String input = stdin.readLine();
        input = input.replaceAll("[^0-9]", "");
        final int year = Integer.parseInt(input);

        if (launches.containsKey(year)) {
            final Launch[] launchesInOneYear = launches.get(year).toArray(new Launch[0]);
            for (final Launch launch : launchesInOneYear) {
                System.out.println(launch.getMissionName() + " Date: " + launch.getDateUtc());
            }
        } else {
            System.out.println("No launch in that specific year.");
        }
    }

    private static void capsulesByIndex(final BufferedReader stdin) throws IOException {
        String input;
        final DragonCapsule[] dragonCapsules = Controller.getDragonCapsules();

        for (int i = 0; i < dragonCapsules.length; i++) {
            System.out.println("number: " + i + " with serial:" + dragonCapsules[i].getSerial() + "\n");
        }

        while (true) {
            System.out.println("Enter the id of the dragon capsule you want to get the latest update or " +
                    "quit by typing exit");
            input = stdin.readLine();
            if (!input.equals("exit")) {
                input = input.replaceAll("[^0-9]", "");
                if (!input.isEmpty()) {
                    int id = Integer.parseInt(input);
                    if (id > -1 && id < dragonCapsules.length) {
                        System.out.println(dragonCapsules[id].getCurrentStatus());
                    } else {
                        System.out.println("Number is invalid. Please enter a number between 0 and " + (dragonCapsules.length - 1));
                    }
                }
            } else {
                break;
            }
        }
    }

    private static ShellCommand identifyCommand(final String possibleCommand) {
        final String commandInLowerCase = possibleCommand.toLowerCase();

        if (commandInLowerCase.trim().isEmpty()) {
            // catch empty input
            return ShellCommand.UNKNOWN;
        }

        for (final ShellCommand command : ShellCommand.values()) {
            final boolean commandIsCorrect = command.getCommandAsString().equals(commandInLowerCase);

            if (commandIsCorrect) {
                return command;
            }
        }
        // command does not exist
        return ShellCommand.UNKNOWN;
    }

}
