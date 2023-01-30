package solvd.laba.entities.members;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "scientist")
public class Scientist extends Person {
    @JsonProperty("nationality")
    private String nationality;
    @JsonProperty("age")
    private int age;
    @JsonProperty("assistants")
    private ArrayList<Assistant> assistants = new ArrayList<Assistant>();

    public Scientist(String name, String lastName, String nationality, int age) {
        super(name, lastName);
        this.nationality = nationality;
        this.age = age;
    }

    public Scientist(String name, String lastName, String nationality, int age, int id) {
        super(name, lastName);
        this.nationality = nationality;
        this.age = age;
        this.setId(id);
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

    public ArrayList<Assistant> getAssistants() {
        return new ArrayList<Assistant>(this.assistants);
    }

    public void addAssistants(Assistant assistant) {
        if (this.assistants.isEmpty() && assistant != null) {
            this.assistants = new ArrayList<>();
        }
        if (assistant != null) {
            this.assistants.add(assistant);
        }
    }

    public void deleteAssistant(Assistant a) {
        this.assistants.remove(a);
    }

    public void setAssistants(ArrayList<Assistant> assistants) {
        this.assistants = assistants;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Scientist{" +
                "\nid=" + id +
                "\nname='" + name + '\'' +
                "\nlastName='" + lastname + '\'' +
                "\nnationality='" + nationality + '\'' +
                "\nage=" + age +
                "\nAssistants=[");
        for (Assistant a : this.assistants) {
            result.append("\n");
            result.append(a.toString()).append(", ");
        }
        result.append("]}");
        return result.toString();
    }
}
