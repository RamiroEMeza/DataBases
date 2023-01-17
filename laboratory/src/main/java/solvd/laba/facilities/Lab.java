package solvd.laba.facilities;

public class Lab {
    private int id;
    private int capacity;
    private int complexity;

    public Lab(int capacity, int complexity) {
        this.capacity = capacity;
        this.complexity = complexity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if (capacity < 0) {
            capacity = 0;
        }
        this.capacity = capacity;
    }

    public int getComplexity() {
        return complexity;
    }

    public void setComplexity(int complexity) {
        if (capacity <= 0) {
            capacity = 1;
        }
        this.complexity = complexity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
