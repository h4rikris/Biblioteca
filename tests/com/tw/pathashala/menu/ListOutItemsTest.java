package com.tw.pathashala.menu;

import com.tw.pathashala.models.Library;
import com.tw.pathashala.view.ConsoleOutputTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.tw.pathashala.constants.Constants.CONTINUE;
import static com.tw.pathashala.constants.Constants.LOGGEDOUT_MAIN_MENU;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ListOutItemsTest {
    @Mock
    Library library;

    @Mock
    ConsoleOutputTemplate outputTemplate;

    @Test
    public void shouldCallListOfAvailableBooksInLibrary() {
        ListOutItems booklist = new ListOutItems(library, outputTemplate);

        booklist.execute();

        verify(library).availableItems();

    }

    @Test
    public void shouldHaveListOfBooksAndMainMenuInDisplay() {
        ListOutItems listOutItems = new ListOutItems(library, outputTemplate);

        when(library.availableItems()).thenReturn("List Items");
        listOutItems.execute();

        verify(outputTemplate).renderOutput("List Items", LOGGEDOUT_MAIN_MENU);
    }

    @Test
    public void shouldReturnContinueWhenExecuteInvoked() {
        ListOutItems listOutItems = new ListOutItems(library, outputTemplate);

        String actual = listOutItems.execute();

        assertEquals(CONTINUE, actual);
    }
}