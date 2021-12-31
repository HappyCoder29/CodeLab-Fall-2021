package edu.northeastern.ashish;

import java.util.Date;

public class Employee {
    private String name;
    private  Integer age;
    private Date startDate;
    private float salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Employee(String name, int age){
        this.name = name;
        this.age = age;
        this.startDate = new Date();
    }

}