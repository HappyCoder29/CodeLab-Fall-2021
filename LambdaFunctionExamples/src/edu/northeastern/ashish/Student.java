package edu.northeastern.ashish;

import java.util.Date;

public class Student {
    String name;
    Integer age;
    Date startDate;
    Date graduationDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
    }

    public Student(String name, int age){
        this.name = name;
        this.age = age;
        this.startDate = new Date();
        this.graduationDate = null;
    }



}
