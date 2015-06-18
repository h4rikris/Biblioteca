package com.tw.pathashala.menu;

import com.tw.pathashala.models.Authentication;
import com.tw.pathashala.view.ConsoleInput;
import com.tw.pathashala.view.ConsoleOutputTemplate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        when(consoleInput.getUserInput()).thenReturn("admin","pass");
    }

    @Test
    public void shouldAskForUserNameInput() {
        Login login = new Login(consoleInput, outputTemplate, authentication);

        login.execute();

        verify(outputTemplate).renderOutput("Authentication Required", "Enter user name:");
    }

    @Test
    public void shouldAskForPasswordInput() {
        Login login = new Login(consoleInput, outputTemplate, authentication);

        login.execute();

        outputTemplate.renderOutput("", "Enter Password");
    }

}