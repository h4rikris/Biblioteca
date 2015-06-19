package com.tw.pathashala.menu;

import com.tw.pathashala.models.Authentication;
import com.tw.pathashala.view.ConsoleInput;
import com.tw.pathashala.view.ConsoleOutputTemplate;

import static com.tw.pathashala.constants.Constants.*;

public class Login implements MenuAction{
    ConsoleInput input;
    ConsoleOutputTemplate outputTemplate;
    Authentication authentication;

    public Login(ConsoleInput input, ConsoleOutputTemplate outputTemplate, Authentication authentication) {
        this.input = input;
        this.outputTemplate = outputTemplate;
        this.authentication = authentication;
    }

    @Override
    public String execute() {
        boolean result = askForCredentials();
        if (result) {
            outputTemplate.renderOutput("Successfully Logged in", LOGGEDIN_MAIN_MENU);
        }
        else {
            askToEnterAgain();
        }
        return CONTINUE;
    }

    private boolean askForCredentials() {
        String userName = askForUsername();
        String password = askForPassword();
        return authentication.authenticate(userName, password);
    }

    private String askForPassword() {
        outputTemplate.prompt("Enter Password:");
        return input.getUserInput();
    }

    private String askForUsername() {
        outputTemplate.renderOutput("Authentication Required", "Enter user name:");
        return input.getUserInput();
    }

    private void askToEnterAgain() {
        outputTemplate.renderOutput("Invalid credentials", "Do you want to Enter Again:y/n?");
        String choice = input.getUserInput();
        if (choice.equals("y")){
            execute();
        }
        else {
            outputTemplate.renderOutput(WELCOME_MESSAGE, LOGGEDOUT_MAIN_MENU);
        }
    }
}
