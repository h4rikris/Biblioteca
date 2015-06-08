package com.tw.pathashala.models;

import com.tw.pathashala.menu.BooksList;
import com.tw.pathashala.menu.MenuAction;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MenuTest {

    @Test
    public void testForMenuAddItemEntry() {
        Menu m = new Menu();

        Integer menuSizeBeforeEntry = m.menuList().size();
        m.addOption("Checkout", new BooksList());
        Integer menuSizeAfterEntry = m.menuList().size();

        assertThat(menuSizeAfterEntry, is(equalTo(menuSizeBeforeEntry + 1)));
    }

    @Test
    public void testForMenuOptionToReturnMenuAction() {
        Menu m = new Menu();

        MenuAction actual = m.chooseOption("List Books");

        assertEquals(new BooksList(), actual);
    }

}