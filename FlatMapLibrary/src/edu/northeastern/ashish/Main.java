package edu.northeastern.ashish;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {
        Library library = new Library("Bellevue Public Library");
        library.setSections(generateSections());
        Section fiction = library.getSection("Fiction");
        addFictionBooks(fiction);
        Section science = library.getSection("Science");
        addScienceBooks(science);
        System.out.println();

        // Print all Books
        library.sections.stream().flatMap(section -> section.getBooks().stream())
                .forEach(book -> System.out.println(book.title) );

        //print all books by Writer 1
        library.sections.stream().flatMap(section -> section.getBooks().stream())
                .filter(book -> book.writer.equalsIgnoreCase("Writer 1"))
                .forEach(book -> System.out.println(book.title + " Writer : " + book.writer));



        // find cheapest book
        library.sections.stream().flatMap(section -> section.getBooks().stream())
                .reduce((book1, book2)-> book1.price < book2.price? book1 : book2)
                .ifPresent(book -> System.out.println(book.title + " Writer : " + book.writer + " Price : " + book.price ) );
    }

    private  static ArrayList<Section> generateSections(){
        Section fiction = new Section("Fiction");
        Section nonFiction = new Section("Non Fiction");
        Section science = new Section("Science");
        Section computer = new Section("Computer");
        Section poetry = new Section("poetry");
        ArrayList<Section> list = new ArrayList<>();
        list.add(fiction);
        list.add(nonFiction);
        list.add(science);
        list.add(computer);
        list.add(poetry);
        return list;
    }

    private static  void addFictionBooks(Section fiction){
        GregorianCalendar date =  new GregorianCalendar(1851, 2, 11);
        fiction.addBook(new Book("Moby Dick", "Synopsis", date, "Writer 1", 9.05f));
        date = new GregorianCalendar(1852, 2, 11);
        fiction.addBook(new Book("War and peace", "Synopsis", date, "Writer 4", 7.05f));
        date = new GregorianCalendar(1853, 2, 11);
        fiction.addBook(new Book("Hamlet", "Synopsis", date, "Writer 7", 5.05f));
        date = new GregorianCalendar(1854, 2, 11);
        fiction.addBook(new Book("The great Gatsby", "Synopsis", date, "Writer 9", 12.05f));

    }
    private static  void addScienceBooks(Section fiction){
        GregorianCalendar date =  new GregorianCalendar(1951, 2, 11);
        fiction.addBook(new Book("Science1", "Synopsis", date, "Writer 1", 25.05f));
        date = new GregorianCalendar(1952, 2, 11);
        fiction.addBook(new Book("Science2", "Synopsis", date, "Writer 5", 6.05f));
        date = new GregorianCalendar(1953, 2, 11);
        fiction.addBook(new Book("Science3", "Synopsis", date, "Writer 7", 3.05f));
        date = new GregorianCalendar(1954, 2, 11);
        fiction.addBook(new Book("Science4", "Synopsis", date, "Writer 9", 16.05f));

    }
}
