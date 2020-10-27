package seedu.duke.ui;

import seedu.duke.common.Messages;
import seedu.duke.controller.ControlManager;
import seedu.duke.controller.parser.CommandType;
import seedu.duke.model.Model;
import seedu.duke.storage.EventStorageManager;
import seedu.duke.storage.QuizStorageManager;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

//@@author durianpancakes
public class UserInterface {
    private static UserInterface userInterface = null;
    private final Scanner in;
    private final PrintStream out;

    private UserInterface() {
        this.in = new Scanner(System.in);
        this.out = System.out;
    }

    public static UserInterface getInstance() {
        if (userInterface == null) {
            userInterface = new UserInterface();
        }

        return userInterface;
    }

    public void showWelcomeMessage() {
        showToUser(
                Messages.MESSAGE_HELLO_FROM_DUKE,
                Messages.MESSAGE_PROMPT_NAME);

        String userName = getUserCommand();

        showToUser(Messages.MESSAGE_HELLO + userName,
                Messages.MESSAGE_PROMPT_COMMAND);
    }

    public String getUserCommand() {
        return in.nextLine();
    }

    public void showToUser(String... message) {
        for (String m : message) {
            out.println(m);
        }
    }

    //@@author AndreWongZH
    public void printArray(ArrayList<String> stringArrayList) {
        assert stringArrayList != null;
        for (String line : stringArrayList) {
            showToUser(line);
        }
    }

    //@@author AndreWongZH
    public boolean checkIfProgramEnds(CommandType commandType) {
        return commandType != CommandType.BYE;
    }

    //@@author AndreWongZH
    public boolean runUI(Model model,
                         EventStorageManager eventStorageManager,
                         QuizStorageManager quizStorageManager) {
        CommandType commandType = null;
        String line = getUserCommand();

        if (!line.trim().isEmpty()) {
            ControlManager controlManager = new ControlManager(line, model, eventStorageManager, quizStorageManager);
            commandType = controlManager.runLogic();
        }

        return checkIfProgramEnds(commandType);
    }
}
