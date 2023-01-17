package solvd.laba.equipment;

public class Equipment {
    private int id;
    private String name;
    private boolean working;

    public Equipment(String name, boolean working) {
        this.name = name;
        this.working = working;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
