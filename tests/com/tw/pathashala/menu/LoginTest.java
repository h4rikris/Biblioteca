package com.tw.pathashala.menu;

import com.tw.pathashala.models.Authentication;
import com.tw.pathashala.view.ConsoleInput;
import com.tw.pathashala.view.ConsoleOutputTemplate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

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

        verify(outputTemplate).renderOutput("", "Enter Password");
    }

    @Test
    public void shouldAskForTryAgainPromptIfCredentialsAreWrong() {
        Login login = new Login(consoleInput, outputTemplate, authentication);

        when(authentication.authenticate("admin", "pass")).thenReturn(false);
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
}