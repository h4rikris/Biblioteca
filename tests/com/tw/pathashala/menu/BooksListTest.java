package com.tw.pathashala.menu;

import com.tw.pathashala.constants.Constants;
import com.tw.pathashala.models.Book;
import com.tw.pathashala.models.Library;
import com.tw.pathashala.view.ConsoleInput;
import com.tw.pathashala.view.ConsoleOutputTemplate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static com.tw.pathashala.constants.Constants.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BooksListTest {
    @Mock
    Library library;

    @Mock
    ConsoleOutputTemplate outputTemplate;

    @Test
    public void shouldCallListOfAvailableBooksInLibrary() {
        BooksList booklist = new BooksList(library, outputTemplate);

        booklist.execute();

        verify(library).availableBooks();

    }

    @Test
    public void shouldAddListOfBooksToTemplateBody() {
        BooksList booksList = new BooksList(library, outputTemplate);

        booksList.execute();

        verify(outputTemplate).addToBody(anyString());
    }

    @Test
    public void shouldAddMenuToTemplateFooter() {
        BooksList booksList = new BooksList(library, outputTemplate);

        booksList.execute();

        verify(outputTemplate).addToFooter(anyString());
    }

    @Test
    public void shouldCallRenderToPrintOnConsole() {
        BooksList booksList = new BooksList(library, outputTemplate);

        booksList.execute();

        verify(outputTemplate).renderOutput();
    }

    @Test
    public void shouldReturnContinueWhenExecuteInvoked() {
        BooksList booksList = new BooksList(library, outputTemplate);

        String actual = booksList.execute();

        assertEquals(CONTINUE, actual);
    }
}