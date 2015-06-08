package com.tw.pathashala.menu;

import com.tw.pathashala.models.Books;

public class BooksList implements MenuAction {
    private Books books;

    @Override
    public String display() {
        return books.toString();
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BooksList booksList = (BooksList) o;

        return !(books != null ? !books.equals(booksList.books) : booksList.books != null);

    }

    @Override
    public int hashCode() {
        return books != null ? books.hashCode() : 0;
    }
}
