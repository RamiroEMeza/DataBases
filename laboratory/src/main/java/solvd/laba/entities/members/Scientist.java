package solvd.laba.entities.members;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "scientist")
public class Scientist extends Person {
    private String nationality;
    private int age;


    public Scientist(String name, String lastName, String nationality, int age) {
        super(name, lastName);
        this.nationality = nationality;
        this.age = age;
    }

    public Scientist() {
        super(null, null);
        this.nationality = null;
        this.age = 0;
    }

    public Scientist(int scientistsId) {
        super(null, null);
        this.id = scientistsId;
    }

    public String getNationality() {
        return nationality;
    }

    @XmlElement(name = "nationality")
    public void setNationality(String nationality) {
        this.nationality = nationality;
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

    @Override
    public String toString() {
        return "Scientist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", age=" + age +
                '}';
    }
}
