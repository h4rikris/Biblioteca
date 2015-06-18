package com.tw.pathashala.menu;

import com.tw.pathashala.models.Library;
import com.tw.pathashala.view.ConsoleOutputTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.tw.pathashala.constants.Constants.CONTINUE;
import static com.tw.pathashala.constants.Constants.LOGGEDIN_MAIN_MENU;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

        verify(library).availableItems();

    }

    @Test
    public void shouldHaveListOfBooksAndMainMenuInDisplay() {
        BooksList booksList = new BooksList(library, outputTemplate);

        when(library.availableItems()).thenReturn("List Items");
        booksList.execute();

        verify(outputTemplate).renderOutput("List Items", LOGGEDIN_MAIN_MENU);
    }

    @Test
    public void shouldReturnContinueWhenExecuteInvoked() {
        BooksList booksList = new BooksList(library, outputTemplate);

        String actual = booksList.execute();

        assertEquals(CONTINUE, actual);
    }
}