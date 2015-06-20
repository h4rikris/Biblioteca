package com.tw.pathashala.menu;

import com.tw.pathashala.view.ConsoleOutputTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.tw.pathashala.constants.Constants.CONTINUE;
import static com.tw.pathashala.constants.Constants.INVALID_OPTION_MESSAGE;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class InvalidOptionTest {

    @Mock
    ConsoleOutputTemplate outputTemplate;

    @Test
    public void shouldCallRenderToPrintOnConsoleWithInvalidOptionAndMainMenu() {
        InvalidOption invalidOption = new InvalidOption(outputTemplate);

        invalidOption.execute();

        verify(outputTemplate).addToBody(INVALID_OPTION_MESSAGE);
    }

    @Test
    public void shouldReturnContinueWhenExecuteInvoked() {
        InvalidOption invalidOption = new InvalidOption(outputTemplate);

        String actual = invalidOption.execute();

        assertEquals(CONTINUE, actual);
    }
}