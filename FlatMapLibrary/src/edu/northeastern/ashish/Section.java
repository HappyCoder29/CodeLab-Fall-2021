package edu.northeastern.ashish;

import java.util.ArrayList;

public class Section {
    String name;
    ArrayList<Book> books;
    public Section(String name){
        this.name = name;
        this.books = new ArrayList<Book>();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void addBook(Book book){
        this.books.add(book);
    }
}
