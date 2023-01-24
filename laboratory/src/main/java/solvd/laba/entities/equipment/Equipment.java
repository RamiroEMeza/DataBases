package solvd.laba.entities.equipment;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "equipment")
@XmlType(propOrder = {"id", "name", "working"})
public class Equipment {

    private int id;

    private String name;

    private boolean working;

    public Equipment(int id, String name, boolean working) {
        this.id = id;
        this.name = name;
        this.working = working;
    }

    public Equipment(String name, boolean working) {
        this.name = name;
        this.working = working;
    }

    public Equipment() {
        this.id = 0;
        this.name = null;
        this.working = false;
    }

    public String getName() {
        return name;
    }

    @XmlElement(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    public boolean isWorking() {
        return working;
    }

    public int getIsWorking() {
        return working ? 1 : 0;
    }

    @XmlElement(name = "working")
    public void setWorking(boolean working) {
        this.working = working;
    }

    @XmlElement(name = "working")
    public void setWorking(int working) {
        this.working = (working == 1);
    }

    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", working=" + working +
                '}';
    }
}
