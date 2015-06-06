package com.tw.pathashala.models;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MenuTest {

    @Test
    public void testForMenuAddItemEntry(){
        Menu m= new Menu();

        Integer menuSizeBeforeEntry = m.menuList.size();
        m.addItem("List Books");
        Integer menuSizeAfterEntry = m.menuList.size();

        assertThat(menuSizeAfterEntry, is(menuSizeBeforeEntry+1));
    }

}