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
public class ReturnBookTest {
    @Mock
    ConsoleOutputTemplate outputTemplate;

    @Mock
    ConsoleInput consoleInput;

    @Mock
    Library library;

    @Test
    public void shouldReturnContinueOnExecuteMethod() {
        ReturnBook returnBook = new ReturnBook(outputTemplate, consoleInput, library);

        String actualResult = returnBook.execute();

        assertEquals(CONTINUE, actualResult);
    }

    @Test
    public void shouldDisplayListOfBooks() {
        ReturnBook returnBook = new ReturnBook(outputTemplate, consoleInput, library);

        returnBook.execute();

        verify(library).checkedOutItems();
    }

    @Test
    public void shouldAskForBookName() {
        ReturnBook returnBook = new ReturnBook(outputTemplate, consoleInput, library);

        returnBook.execute();

        verify(consoleInput).getUserInput();
    }

    @Test
    public void shouldAddReturnFooterMessageToPrompt() {
        ReturnBook returnBook = new ReturnBook(outputTemplate, consoleInput, library);

        returnBook.execute();

        verify(outputTemplate).addToFooter(RETURN_MESSAGE);
    }

    @Test
    public void shouldAbleToReturnTheBook() {
        ReturnBook returnBook = new ReturnBook(outputTemplate, consoleInput, library);

        returnBook.execute();

        verify(library).returnItem(anyString());
    }

    @Test
    public void shouldDisplayErrorMessageOnInvalidBookEntry() {
        ReturnBook returnBook = new ReturnBook(outputTemplate, consoleInput, library);
        when(library.returnItem(anyString())).thenReturn(false);

        returnBook.execute();

        verify(outputTemplate, times(1)).addToBody(RETURN_FAIL_MESSAGE);
    }

    @Test
    public void shouldDisplaySuccessMessageValidBookEntry() {
        ReturnBook returnBook = new ReturnBook(outputTemplate, consoleInput, library);
        when(library.returnItem(anyString())).thenReturn(true);

        returnBook.execute();

        verify(outputTemplate, times(1)).addToBody(RETURN_SUCCESS_MESSAGE);
    }

    @Test
    public void shouldDisplayToConsoleForBookEntryAndResultMessage() {
        ReturnBook returnBook = new ReturnBook(outputTemplate, consoleInput, library);

        returnBook.execute();

        verify(outputTemplate, times(2)).renderOutput();
    }
}