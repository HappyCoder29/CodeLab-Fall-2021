package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args) {
        Cat cat = new Cat("Spot", "Tom", "Black");
        Dog dog = new Dog("Bruno", "Ashish", "White", "Medium");

        System.out.println(cat.toString());
        System.out.println(cat.eat());
        System.out.println(cat.sound());


        System.out.println(dog.toString());
        System.out.println(dog.eat());
        System.out.println(dog.sound());

        cat.setBoardStart(5);
        cat.setBoardEnd(10);

        System.out.println(cat.boarding(7));
        System.out.println(cat.boarding(15));



    }
}
