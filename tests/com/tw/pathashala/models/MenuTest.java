package com.tw.pathashala.models;

import com.tw.pathashala.menu.BooksList;
import com.tw.pathashala.menu.MenuAction;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MenuTest {
    Books books;

    @Before
    public void setUp() throws Exception {
        books = new Books();
    }

    @Test
    public void testForMenuAddItemEntry() {
        Menu m = new Menu(books);

        Integer menuSizeBeforeEntry = m.menuList().size();
        m.addOption("Checkout", new BooksList(books));
        Integer menuSizeAfterEntry = m.menuList().size();

        assertThat(menuSizeAfterEntry, is(equalTo(menuSizeBeforeEntry + 1)));
    }

    @Test
    public void testForMenuOptionToReturnMenuAction() {
        Menu m = new Menu(books);

        MenuAction actual = m.chooseOption("List Books");

        //assertEquals(new BooksList().toString(), actual);
    }

}