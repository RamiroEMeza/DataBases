package solvd.laba.research;

import solvd.laba.facilities.Lab;
import solvd.laba.members.Scientist;

import java.time.LocalDate;

public class Research {
    private int id;
    private String name;
    private LocalDate start;
    private int budget;
    private boolean complete;
    private Lab lab;
    private Scientist scientist;

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

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        if (budget < 0) {
            budget = 0;
        }
        this.budget = budget;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
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
