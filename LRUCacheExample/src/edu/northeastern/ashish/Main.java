package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args) {

        Person per1 = new Person("Person 1", "person1", "Header 1", "Description 1");
        Person per2 = new Person("Person 2", "person2", "Header 1", "Description 1");
        Person per3 = new Person("Person 3", "person3", "Header 1", "Description 1");
        Person per4 = new Person("Person 4", "person4", "Header 1", "Description 1");
        Person per5 = new Person("Person 5", "person5", "Header 1", "Description 1");
        Person per6 = new Person("Person 6", "person6", "Header 1", "Description 1");
        Person per7 = new Person("Person 7", "person7", "Header 1", "Description 1");
        Person per8 = new Person("Person 8", "person8", "Header 1", "Description 1");
        Person per9 = new Person("Person 9", "person9", "Header 1", "Description 1");
        Person per10 = new Person("Person 10", "person10", "Header 1", "Description 1");

        LRUCache< String, Person> cache = new LRUCache<>(5);
        cache.addValue(per1.loginID, per1);
        cache.addValue(per2.loginID, per2);
        cache.addValue(per3.loginID, per3);
        cache.addValue(per4.loginID, per4);
        cache.addValue(per5.loginID, per5);
        cache.addValue(per6.loginID, per6);


        Person per =  cache.getValue(per1.loginID);



    }
}
