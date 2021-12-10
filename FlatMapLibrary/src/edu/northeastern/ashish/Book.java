package edu.northeastern.ashish;

import java.util.Date;
import java.util.GregorianCalendar;

public class Book {
    String title;
    String synopsis;
    GregorianCalendar publishedDate;
    String writer;
    float price;
    int rating;

    public Book(String title, String synopsis, GregorianCalendar publishedDate, String writer, float price ){
        this.title = title;
        this.synopsis = synopsis;
        this.publishedDate = publishedDate;
        this.writer = writer;
        this.price = price;
        this.rating = -1;
    }
}
