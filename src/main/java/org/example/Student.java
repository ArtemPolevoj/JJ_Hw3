package org.example;

import java.io.Serializable;
public class Student implements Serializable {
    //region field
    private String name;
    private int age;
   private transient double GPA;
    //endregion

    //region constructor
    public Student(String name, int age, double GPA) {
        setName(name);
        setAge(age);
        setGPA(GPA);
    }
    public Student() {
    }
    //endregion

    //region methods

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.isEmpty()) {
            throw new RuntimeException("Имя не может быть пустым.");
        } else {
            this.name = name;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 10 || age > 100) {
            throw new RuntimeException("Не корректный возраст.");
        } else {
            this.age = age;
        }
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        if (GPA < 0 || GPA > 5) {
            throw new RuntimeException("Не корректный средний бал.");
        } else {
            this.GPA = GPA;
        }
    }

    public void info(){
        System.out.printf("""
                        Имя - %s
                        Возраст  -  %s
                        Средний бал - %s
                        """,
                getName(), getAge(), getGPA());
    }
    //endregion
}
