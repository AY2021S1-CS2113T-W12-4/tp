package seedu.duke.controller.parser;

/**
 * Represents all possible commands available to the user.
 */
public enum CommandType {
    ADD_CLASS, ADD_CCA, ADD_TEST, ADD_QUIZ, ADD_CONTACT, ADD_TUITION,
    DELETE_CLASS, DELETE_CCA, DELETE_TEST, DELETE_QUIZ, DELETE_TUITION, DELETE_CONTACT,
    DONE_TEST, DONE_CLASS, DONE_CCA, DONE_TUITION,
    LIST_QUIZ, LIST_CONTACT, BYE, LIST, HELP
}