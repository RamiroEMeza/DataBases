package solvd.laba.entities.research;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import solvd.laba.entities.members.Scientist;
import solvd.laba.entities.facilities.Lab;
import solvd.laba.entities.test.subjects.Subject;
import solvd.laba.extensibles.reader.DateAdapter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.ArrayList;

@XmlRootElement(name = "research")
public class Research {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate start;
    @JsonProperty("budget")
    private int budget;
    @JsonProperty("complete")
    private boolean complete;
    @JsonProperty("lab")
    private Lab lab;
    @JsonProperty("scientist")
    private Scientist scientist;

    @XmlElementWrapper(name = "subjects")
    @XmlElement(name = "subject")
    @JsonProperty("testSubjects")
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

    @XmlAttribute(name = "id")
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

    public void setTestSubjects(ArrayList<Subject> testSubjects) {
        this.testSubjects = testSubjects;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Research{" +
                "\nid=" + id +
                "\nname='" + name + '\'' +
                "\nstart=" + start +
                "\nbudget=" + budget +
                "\ncomplete=" + complete +
                "\nlab=" + lab +
                "\nscientist=" + scientist +
                "\ntestSubjects=[");
        for (Subject s : this.testSubjects) {
            result.append("\n");
            result.append(s.toString()).append(", ");
        }

        result.append("]}");

        return result.toString();
    }
}
