package edu.northeastern.ashish;

import java.util.ArrayList;

public class Person {
    public String name;
    public String loginID;
    public String header;
    public String description;
    public ArrayList<String> feed;

    public String getName() {
        return name;
    }

    public String getLoginID() {
        return loginID;
    }

    public String getHeader() {
        return header;
    }

    public String getDescription() {
        return description;
    }

    public Person(String name, String loginID, String header, String description){
        this.name = name;
        this.loginID = loginID;
        this.header = header;
        this.description = description;
        this.feed = new ArrayList<>();
    }
}
