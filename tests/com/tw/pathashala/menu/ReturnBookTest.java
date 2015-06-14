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
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

        verify(library).checkedOutBooks();
    }

    @Test
    public void shouldAskForBookName() {
        ReturnBook returnBook = new ReturnBook(outputTemplate, consoleInput, library);

        returnBook.execute();

        verify(consoleInput).getUserInput();
    }

    @Test
    public void shouldAddCheckOutFooterMessageToPrompt() {
        ReturnBook returnBook = new ReturnBook(outputTemplate, consoleInput, library);

        returnBook.execute();

        verify(outputTemplate).addToFooter(RETURN_MESSAGE);
    }

    @Test
    public void shouldAbleToCheckOutTheBook() {
        ReturnBook returnBook = new ReturnBook(outputTemplate, consoleInput, library);

        returnBook.execute();

        verify(library).checkOut(anyString());
    }
    
}