package solvd.laba.entities.members;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "assistant")
public class Assistant extends Person {
    private String nationality;
    private int age;
    private Scientist scientist;

    public Assistant(String name, String lastName, String nationality, int age) {
        super(name, lastName);
        this.nationality = nationality;
        this.age = age;
    }

    public Assistant() {
        super(null, null);
        this.scientist = null;
        this.age = 0;
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
        this.age = age;
    }


    public Scientist getScientist() {
        return scientist;
    }

    @XmlElement(name = "scientist")
    public void setScientist(Scientist scientist) {
        this.scientist = scientist;
    }

    @Override
    public String toString() {
        return "Assistant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", age=" + age +
                ", scientist=" + scientist +
                '}';
    }
}
