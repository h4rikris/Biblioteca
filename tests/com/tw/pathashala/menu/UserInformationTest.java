package com.tw.pathashala.menu;

import com.tw.pathashala.models.Authentication;
import com.tw.pathashala.models.User;
import com.tw.pathashala.view.ConsoleOutputTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserInformationTest {

    @Mock
    Authentication authentication;

    @Mock
    ConsoleOutputTemplate consoleOutputTemplate;

    @Mock
    User user;

    @Test
    public void shouldGetCurrentLoggedInUser() {
        UserInformation userInformation = new UserInformation(authentication, consoleOutputTemplate);

        when(authentication.getCurrentLoggedInUser()).thenReturn(user);
        userInformation.execute();

        verify(authentication).getCurrentLoggedInUser();
    }

    @Test
    public void shouldAddUserInformationToOutputTemplate() {
        UserInformation userInformation = new UserInformation(authentication, consoleOutputTemplate);

        when(authentication.getCurrentLoggedInUser()).thenReturn(user);
        userInformation.execute();

        verify(consoleOutputTemplate).addToBody(anyString());
    }
}