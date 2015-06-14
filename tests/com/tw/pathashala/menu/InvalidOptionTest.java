package com.tw.pathashala.menu;

import com.tw.pathashala.view.ConsoleOutputTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.tw.pathashala.constants.Constants.CONTINUE;
import static com.tw.pathashala.constants.Constants.INVALID_OPTION_MESSAGE;
import static com.tw.pathashala.constants.Constants.MAIN_MENU;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class InvalidOptionTest {

    @Mock
    ConsoleOutputTemplate outputTemplate;

    @Test
    public void shouldAddInvalidMessageToTemplateBody() {
        InvalidOption invalidOption = new InvalidOption(outputTemplate);

        invalidOption.execute();

        verify(outputTemplate).addToBody(INVALID_OPTION_MESSAGE);
    }

    @Test
    public void shouldAddMenuToTemplateFooter() {
        InvalidOption invalidOption = new InvalidOption(outputTemplate);

        invalidOption.execute();

        verify(outputTemplate).addToFooter(MAIN_MENU);
    }

    @Test
    public void shouldCallRenderToPrintOnConsole() {
        InvalidOption invalidOption = new InvalidOption(outputTemplate);

        invalidOption.execute();

        verify(outputTemplate).renderOutput();
    }

}