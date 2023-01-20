package solvd.laba.entities.test.subjects;

import solvd.laba.entities.research.Research;

public class Subject {
    private String species;
    private int age;
    private boolean sex;
    private double weight;
    private Research research;

    public Subject(String species, int age, boolean sex, double weight) {
        this.species = species;
        this.age = age;
        this.sex = sex;
        this.weight = weight;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
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

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight < 1) {
            weight = 1;
        }
        this.weight = weight;
    }

    public Research getResearch() {
        return research;
    }

    public void setResearch(Research research) {
        this.research = research;
    }
}
