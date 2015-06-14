package com.tw.pathashala.menu;

import com.tw.pathashala.constants.Constants;
import com.tw.pathashala.models.Library;
import com.tw.pathashala.view.ConsoleInput;
import com.tw.pathashala.view.ConsoleOutputTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.tw.pathashala.constants.Constants.CHECKOUT_INVALID_MESSAGE;
import static com.tw.pathashala.constants.Constants.CHECKOUT_MESSAGE;
import static com.tw.pathashala.constants.Constants.CONTINUE;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CheckOutTest {

    @Mock
    ConsoleOutputTemplate outputTemplate;

    @Mock
    Library library;

    @Mock
    ConsoleInput consoleInput;

    @Test
    public void shouldReturnContinueOnExecuteMethod() {
        CheckOut checkOut = new CheckOut(outputTemplate, consoleInput, library);

        String actualResult = checkOut.execute();

        assertEquals(CONTINUE, actualResult);
    }

    @Test
    public void shouldDisplayListOfBooks() {
        CheckOut checkOut = new CheckOut(outputTemplate, consoleInput, library);

        checkOut.execute();

        verify(library).availableBooks();
    }

    @Test
    public void shouldAskForBookName() {
        CheckOut checkOut = new CheckOut(outputTemplate, consoleInput, library);

        checkOut.execute();

        verify(consoleInput).getUserInput();
    }

    @Test
    public void shouldAddCheckOutFooterMessageToPrompt() {
        CheckOut checkOut = new CheckOut(outputTemplate, consoleInput, library);

        checkOut.execute();

        verify(outputTemplate).addToFooter(CHECKOUT_MESSAGE);
    }

    @Test
    public void shouldAbleToCheckOutTheBook() {
        CheckOut checkOut = new CheckOut(outputTemplate, consoleInput, library);

        checkOut.execute();

        verify(library).checkOut(anyString());
    }

    @Test
    public void shouldDisplayErrorMessageOnInvalidBookEntry() {
        CheckOut checkOut = new CheckOut(outputTemplate, consoleInput, library);
        when(library.checkOut("some")).thenReturn(false);
        checkOut.execute();

        verify(outputTemplate).addToBody(CHECKOUT_INVALID_MESSAGE);
    }
}