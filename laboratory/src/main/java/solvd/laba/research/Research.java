package solvd.laba.research;

import solvd.laba.facilities.Lab;

import java.time.LocalDate;

public class Research {
    private String name;
    private LocalDate start;
    private int budget;
    private boolean complete;
    private Lab lab;

    public Research(String name, LocalDate start, int budget, boolean complete) {
        this.name = name;
        this.start = start;
        this.budget = budget;
        this.complete = complete;
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
        if(lab != null){
            this.lab = lab;
        }
    }
}
