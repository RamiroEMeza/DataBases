package solvd.laba.members;

import solvd.laba.research.Research;

public class Scientist extends Person{
    private String nationality;
    private int age;
    private Research research;


    Scientist(String name, String lastName, String nationality, int age) {
        super(name, lastName);
        this.nationality = nationality;
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            age = 0;
        }
        this.age = age;
    }

    public Research getResearch() {
        return research;
    }

    public void setResearch(Research research) {
        if (research != null) {
            this.research = research;
        }
    }
}
