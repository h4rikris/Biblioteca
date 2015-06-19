package com.tw.pathashala.menu;

import com.tw.pathashala.models.Authentication;
import com.tw.pathashala.view.ConsoleOutputTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LogoutTest {

    @Mock
    Authentication authentication;

    @Mock
    ConsoleOutputTemplate consoleOutputTemplate;

    @Test
    public void shouldSetCurrentLoggedInUserToNull () {
        Logout logout = new Logout(authentication, consoleOutputTemplate);
        logout.execute();
        verify(authentication).setCurrentLoggedInUser(null);
    }
}