package edu.northeastern.ashish;

public class Cat extends Pet implements iBoardable{

    private int startDay;
    private int endDay;

    public Cat(String name, String ownerName, String color) {
        super(name, ownerName, color);
    }

    @Override
    public String eat() {
        return this.getName() + " will eat Tuna";
    }

    @Override
    public String sound() {
        return this.getName() + " will make a meow sound ";
    }

    @Override
    public void setBoardStart(int startDay) {
        this.startDay = startDay;
    }

    @Override
    public void setBoardEnd(int endDay) {
        this.endDay = endDay;
    }

    @Override
    public boolean boarding(int day) {
        return day >= startDay && day <= endDay;
    }
}
