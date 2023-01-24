package solvd.laba.entities.research;

import solvd.laba.entities.members.Scientist;
import solvd.laba.entities.facilities.Lab;
import solvd.laba.entities.test.subjects.Subject;
import solvd.laba.extensibles.reader.DateAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.ArrayList;

@XmlRootElement(name = "research")
public class Research {
    private int id;
    private String name;
    private LocalDate start;
    private int budget;
    private boolean complete;
    private Lab lab;
    private Scientist scientist;

    @XmlElementWrapper(name = "subjects")
    private ArrayList<Subject> testSubjects = new ArrayList<Subject>();

    public Research(String name, LocalDate start, int budget, boolean complete) {
        this.name = name;
        this.start = start;
        this.budget = budget;
        this.complete = complete;
    }

    public Research() {
        this.id = 0;
        this.name = null;
        this.start = null;
        this.budget = 0;
        this.complete = false;
        this.lab = null;
    }

    public String getName() {
        return name;
    }

    @XmlElement(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStart() {
        return start;
    }

    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setStart(LocalDate start) {
        this.start = start;
    }

    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setStart(String start) {
        this.start = LocalDate.parse(start);
    }

    public int getBudget() {
        return budget;
    }

    @XmlElement(name = "budget")
    public void setBudget(int budget) {
        if (budget < 0) {
            budget = 0;
        }
        this.budget = budget;
    }

    public boolean isComplete() {
        return complete;
    }

    @XmlElement(name = "complete")
    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    @XmlElement(name = "complete")
    public void setComplete(String complete) {
        this.complete = complete.equals("1");
    }

    public Lab getLab() {
        return lab;
    }

    public void setLab(Lab lab) {
        if (lab != null) {
            this.lab = lab;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Scientist getScientist() {
        return scientist;
    }

    public void setScientist(Scientist scientist) {
        this.scientist = scientist;
    }

    public ArrayList<Subject> getTestSubjects() {
        return new ArrayList<Subject>(this.testSubjects);
    }

    public void addTestSubjects(Subject testSubjects) {
        if (testSubjects != null) {
            this.testSubjects.add(testSubjects);
        }
    }

    @Override
    public String toString() {
        return "Research{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", start=" + start +
                ", budget=" + budget +
                ", complete=" + complete +
                ", lab=" + lab +
                ", scientist=" + scientist +
                '}';
    }
}