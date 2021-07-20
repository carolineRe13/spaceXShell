package ui;

/**
 * Contains all possible commands for the Shell for Lantons's Ant that are currently implemented.
 * Furthermore all associated parameter numbers and a help text are stored.
 */
enum ShellCommand {
    SPECIFIC_LAUNCH("specific", "", "Prints all launches in a specific year"),
    CAPSULES("capsules", "The following capsule ids are registered:", "Prints all dragon " +
            "capsules and the latest update of a specific capsule. The command can be quit by entering exit"),
    LAUNCHES("launches", "Total number of launches: ", "Prints the total number of launches"),
    CREW("crew", "Total number of crew members launched into space: ", "Prints the count of " +
            "crew members launched into space"),
    HELP("help", "", "Prints this help text"),
    QUIT("quit", "", "Exits this program"),
    UNKNOWN("unknown", "", "Wrong commands will be ignored");  // for wrong commands

    /**
     * String representation of this command.
     */
    private final String command;

    /**
     * Help description text for the current command.
     */
    private final String description;

    /**
     * Help text for the current command.
     */
    private final String helpText;

    ShellCommand(String command, String description, String helpText) {
        this.command = command;
        this.description = description;
        this.helpText = helpText;
    }

    /**
     * Returns the string representation for the command.
     */
    String getCommandAsString() {
        return command;
    }

    /**
     * Returns the description text for the command.
     */
    String getDescription() {
        return description;
    }

    /**
     * Returns the help text for the command.
     */
    String getHelpText() {
        return helpText;
    }

    /** Helper method to print the help texts for all commands. */
    void helpPrinter() {
        System.out.println("\n=== All possible commands: ===\n");
        for (final ShellCommand cmd : ShellCommand.values()) {
            System.out.println(cmd.getCommandAsString() + ": " + cmd.getHelpText() + "\n");
        }
    }

}