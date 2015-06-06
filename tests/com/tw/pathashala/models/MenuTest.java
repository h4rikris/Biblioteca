package com.tw.pathashala.models;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MenuTest {

    @Test
    public void testForMenuAddItemEntry(){
        Menu m= new Menu();

        Integer menuSizeBeforeEntry = m.getMenuList().size();
        m.addItem("Checkout");
        Integer menuSizeAfterEntry = m.getMenuList().size();

        assertThat(menuSizeAfterEntry, is(equalTo(menuSizeBeforeEntry+1)));
    }

}