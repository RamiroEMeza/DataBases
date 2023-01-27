package solvd.laba.entities.test.subjects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import solvd.laba.entities.research.Research;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "subject")
@JsonIgnoreProperties
public class Subject {
    @JsonProperty("species")
    private String species;
    @JsonProperty("age")
    private int age;
    @JsonProperty("sex")
    private boolean sex;
    @JsonProperty("weight")
    private double weight;
    @JsonIgnore
    private Research research; //MUST refactor this field, same as AssistantDAO

    public Subject(String species, int age, boolean sex, double weight) {
        this.species = species;
        this.age = age;
        this.sex = sex;
        this.weight = weight;
    }

    public Subject() {
        this.species = null;
        this.age = 0;
        this.sex = false;
        this.weight = 0;
        this.research = null;
    }

    public String getSpecies() {
        return species;
    }

    @XmlElement(name = "species")
    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    @XmlElement(name = "age")
    public void setAge(int age) {
        if (age < 0) {
            age = 0;
        }
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    @XmlElement(name = "sex")
    public void setSex(boolean sex) {
        this.sex = sex;
    }

//    public void setSex(int sex) {
//        this.sex = (sex == 1);
//    }

    public double getWeight() {
        return weight;
    }

    @XmlElement(name = "weight")
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

    @Override
    public String toString() {
        return "Subject{" +
                "species='" + species + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", weight=" + weight +
                '}';
    }
}
