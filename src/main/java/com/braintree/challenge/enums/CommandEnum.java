package com.braintree.challenge.enums;

/**
 *
 * <code>CommandEnum</code> an enum for commands to be executed.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 25, 2019   Braintree Code Challenge.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 25, 2019
 */
public enum CommandEnum {
    ADD("Add"),
    CHARGE("Charge"),
    CREDIT("Credit");

    private String command;

    /**
     * Contructor for enum.
     * @param command String
     */
    CommandEnum(String command) {
        this.command = command;
    }

    /**
     * getCommand - given a String return the correct CommandEnum
     * @param command String
     * @return CommandEnum
     */
    public static CommandEnum getCommand(String command) {
        if (command == null) {
            return null;
        }

        if (command.isEmpty()) {
            return null;
        }
        for (CommandEnum commandEnum: CommandEnum.values()) {
            if (commandEnum.getCommand().equals(command)) {
                return commandEnum;
            }
        }
        return null;
    }
    /**
     * Get the command.
     * @return String
     */
    public String getCommand() {
        return this.command;
    }
}
