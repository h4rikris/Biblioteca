package com.tw.pathashala.models;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MenuTest {

    @Test
    public void testForMenuAddItemEntry() {
        Menu m = new Menu();

        Integer menuSizeBeforeEntry = m.getMenuList().size();
        m.addOption("Checkout");
        Integer menuSizeAfterEntry = m.getMenuList().size();

        assertThat(menuSizeAfterEntry, is(equalTo(menuSizeBeforeEntry + 1)));
    }

    @Test
    public void testForMenuOptionToExistsInMenuList() {
        Menu m = new Menu();

        boolean actual = m.isValidOption("List Books");

        assertEquals(true, actual);
    }

    @Test
    public void testForMenuOptionToDoesNotExistsInMenuList() {
        Menu m = new Menu();

        boolean actual = m.isValidOption("CheckOut");

        assertEquals(false, actual);
    }

    @Test
    public void testForQuitOptionAtEndOfMenuList(){
        Menu m = new Menu();

        m.addOption("Checkout");
        m.addOption("CheckIn");
        Integer indexOfQuit = m.getMenuList().indexOf("Quit");
        Integer expectedIndex = m.getMenuList().size()-1;

        assertThat(indexOfQuit, is(expectedIndex));
    }
}