package edu.northeastern.ashish;

public class Dog extends Pet implements iBoardable{

    private String size;
    private int startDay;
    private int endDay;

    public String getSize() {
        return size;
    }

    public Dog(String name, String ownerName, String color, String size) {
        super(name, ownerName, color);
        this.size = size;
    }

    @Override
    public String eat() {
        return this.getName() + " will eat Pedigree";
    }

    @Override
    public String sound() {
        return this.getName() + " will make a woof sound";
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
