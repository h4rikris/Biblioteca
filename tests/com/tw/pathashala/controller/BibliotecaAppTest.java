package com.tw.pathashala.controller;

import com.tw.pathashala.menu.MenuAction;
import com.tw.pathashala.models.InputParser;
import com.tw.pathashala.models.Library;
import com.tw.pathashala.models.UserMenuMapper;
import com.tw.pathashala.view.ConsoleInput;
import com.tw.pathashala.view.ConsoleOutputTemplate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.tw.pathashala.constants.Constants.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BibliotecaAppTest {

    @Mock
    ConsoleInput consoleInput;

    @Mock
    UserMenuMapper userMenuMapper;

    @Mock
    Library library;

    @Mock
    InputParser inputParser;

    @Mock
    MenuAction action;

    @Mock
    ConsoleOutputTemplate outputTemplate;

    @Before
    public void setUp() throws Exception {
        when(userMenuMapper.getMenu()).thenReturn(inputParser);
        when(consoleInput.getUserInput()).thenReturn("List Books", "Quit");
        when(inputParser.chooseOption("List Books")).thenReturn(action);
        when(inputParser.chooseOption("Quit")).thenReturn(action);
        when(action.execute()).thenReturn(CONTINUE, STOP);
    }

    @Test
    public void shouldIncludeMainMenuAndWelcomeMessageOnStart() {
        BibliotecaApp app = new BibliotecaApp(outputTemplate, consoleInput, userMenuMapper);

        app.start();

        verify(outputTemplate).renderOutput(WELCOME_MESSAGE, LOGGEDOUT_MAIN_MENU);
    }

    @Test
    public void shouldTakeUserInput() {
        BibliotecaApp app = new BibliotecaApp(outputTemplate, consoleInput, userMenuMapper);

        app.start();

        verify(consoleInput, times(2)).getUserInput();
    }

    @Test
    public void shouldAbleToStopApplicationOnQuitInput() {
        BibliotecaApp app = new BibliotecaApp(outputTemplate, consoleInput, userMenuMapper);

        app.start();

        verify(action, times(2)).execute();

    }
}