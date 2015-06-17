package com.tw.pathashala.menu;

import com.tw.pathashala.models.Library;
import com.tw.pathashala.view.ConsoleInput;
import com.tw.pathashala.view.ConsoleOutputTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.tw.pathashala.constants.Constants.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CheckOutBookTest {

    @Mock
    ConsoleOutputTemplate outputTemplate;

    @Mock
    Library library;

    @Mock
    ConsoleInput consoleInput;

    @Test
    public void shouldReturnContinueOnExecuteMethod() {
        CheckOutBook checkOutBook = new CheckOutBook(outputTemplate, consoleInput, library);

        String actualResult = checkOutBook.execute();

        assertEquals(CONTINUE, actualResult);
    }

    @Test
    public void shouldDisplayListOfBooks() {
        CheckOutBook checkOutBook = new CheckOutBook(outputTemplate, consoleInput, library);

        checkOutBook.execute();

        verify(library).availableItems();
    }

    @Test
    public void shouldAskForBookName() {
        CheckOutBook checkOutBook = new CheckOutBook(outputTemplate, consoleInput, library);

        checkOutBook.execute();

        verify(consoleInput).getUserInput();
    }

    @Test
    public void shouldAddCheckOutFooterMessageToPrompt() {
        CheckOutBook checkOutBook = new CheckOutBook(outputTemplate, consoleInput, library);

        when(library.availableItems()).thenReturn("Items");
        checkOutBook.execute();

        verify(outputTemplate).renderOutput("Items", CHECKOUT_MESSAGE);
    }

    @Test
    public void shouldAbleToCheckOutTheBook() {
        CheckOutBook checkOutBook = new CheckOutBook(outputTemplate, consoleInput, library);

        checkOutBook.execute();

        verify(library).checkOut(anyString());
    }

    @Test
    public void shouldDisplayErrorMessageOnInvalidBookEntry() {
        CheckOutBook checkOutBook = new CheckOutBook(outputTemplate, consoleInput, library);
        when(library.checkOut(anyString())).thenReturn(false);

        checkOutBook.execute();

        verify(outputTemplate, times(1)).renderOutput(CHECKOUT_INVALID_MESSAGE, MAIN_MENU);
    }

    @Test
    public void shouldDisplaySuccessMessageValidBookEntry() {
        CheckOutBook checkOutBook = new CheckOutBook(outputTemplate, consoleInput, library);
        when(library.checkOut(anyString())).thenReturn(true);

        checkOutBook.execute();

        verify(outputTemplate, times(1)).renderOutput(CHECKOUT_SUCCESS_MESSAGE, MAIN_MENU);
    }

    @Test
    public void shouldDisplayToConsoleForBookEntryAndResultMessage() {
        CheckOutBook checkOutBook = new CheckOutBook(outputTemplate, consoleInput, library);

        checkOutBook.execute();

        verify(outputTemplate, times(2)).renderOutput(anyString(), anyString());
    }
}