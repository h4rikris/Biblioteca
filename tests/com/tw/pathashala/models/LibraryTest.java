package com.tw.pathashala.models;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LibraryTest {
    @Test
    public void testForEmptyListOfBooksInLibrary(){
        Library library= new Library();

        ArrayList<String> listOfBooks=library.listBooks();
        ArrayList<String> expectedListOfBooks=new ArrayList<String>();

        assertThat(listOfBooks,is(expectedListOfBooks));
    }
}