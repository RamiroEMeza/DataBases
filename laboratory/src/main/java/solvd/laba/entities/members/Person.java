package solvd.laba.entities.members;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Person {
    @JsonProperty("id")
    protected int id;
    @JsonProperty("name")
    protected String name;
    @JsonProperty("lastName")
    protected String lastname;

    Person(String name, String lastName) {
        this.name = name;
        this.lastname = lastName;
    }

    public Person(int id, String name, String lastname) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    @XmlElement(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastname;
    }

    @XmlElement(name = "lastname")
    public void setLastName(String lastName) {
        this.lastname = lastName;
    }

    public int getId() {
        return id;
    }

    @XmlAttribute(name = "id")
    public void setId(int id) {
        this.id = id;
    }
}
