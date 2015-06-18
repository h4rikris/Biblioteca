package com.tw.pathashala.menu;

import com.tw.pathashala.models.Authentication;
import com.tw.pathashala.view.ConsoleInput;
import com.tw.pathashala.view.ConsoleOutputTemplate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.tw.pathashala.constants.Constants.MAIN_MENU;
import static com.tw.pathashala.constants.Constants.WELCOME_MESSAGE;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LoginTest {
    @Mock
    ConsoleOutputTemplate outputTemplate;

    @Mock
    ConsoleInput consoleInput;

    @Mock
    Authentication authentication;

    @Before
    public void setUp() throws Exception {
        when(consoleInput.getUserInput()).thenReturn("admin", "pass", "y");
    }

    @Test
    public void shouldAskForUserNameInput() {
        Login login = new Login(consoleInput, outputTemplate, authentication);

        when(authentication.authenticate("admin", "pass")).thenReturn(true);
        login.execute();

        verify(outputTemplate).renderOutput("Authentication Required", "Enter user name:");
    }

    @Test
    public void shouldAskForPasswordInput() {
        Login login = new Login(consoleInput, outputTemplate, authentication);

        when(authentication.authenticate("admin", "pass")).thenReturn(true);
        login.execute();

        verify(outputTemplate).prompt("Enter Password:");
    }

    @Test
    public void shouldAskForTryAgainPromptIfCredentialsAreWrong() {
        Login login = new Login(consoleInput, outputTemplate, authentication);

        when(authentication.authenticate(anyString(), anyString())).thenReturn(false, true);
        login.execute();

        verify(outputTemplate).renderOutput("Invalid credentials", "Do you want to Enter Again:y/n?");
    }

    @Test
    public void shouldAskCredentialsAgainIfUserWantsToEnterAgain() {
        Login login = new Login(consoleInput, outputTemplate, authentication);

        when(authentication.authenticate(anyString(), anyString())).thenReturn(false, true, false);
        login.execute();

        verify(outputTemplate, times(2)).renderOutput("Authentication Required", "Enter user name:");
    }

    @Test
    public void shouldDisplayMainMenuIfUserDontWantToEnterCredentialsAgain() {
        Login login = new Login(consoleInput, outputTemplate, authentication);

        when(consoleInput.getUserInput()).thenReturn("admin", "pass", "n");
        when(authentication.authenticate(anyString(), anyString())).thenReturn(false);
        login.execute();

        verify(outputTemplate, times(1)).renderOutput(WELCOME_MESSAGE, MAIN_MENU);
    }

    @Test
    public void shouldDisplaySuccessMessageIfCredentialsAreCorrect() {
        Login login = new Login(consoleInput, outputTemplate, authentication);

        when(authentication.authenticate(anyString(), anyString())).thenReturn(true);
        login.execute();

        verify(outputTemplate, times(1)).renderOutput("Successfully Logged in", MAIN_MENU);
    }
}