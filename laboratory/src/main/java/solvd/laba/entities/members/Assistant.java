package solvd.laba.entities.members;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "assistant")
public class Assistant extends Person {
    @JsonProperty("nationality")
    private String nationality;
    @JsonProperty("age")
    private int age;

    public Assistant(String name, String lastName, String nationality, int age) {
        super(name, lastName);
        this.nationality = nationality;
        this.age = age;
    }

    public Assistant(int id, String name, String lastName, String nationality, int age) {
        super(id, name, lastName);
        this.nationality = nationality;
        this.age = age;
    }

    public Assistant() {
        super(null, null);
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

    @Override
    public String toString() {
        return "Assistant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastname + '\'' +
                ", nationality='" + nationality + '\'' +
                ", age=" + age +
                '}';
    }
}
