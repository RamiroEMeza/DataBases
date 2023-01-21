package solvd.laba.entities.facilities;

public class Lab {
    private int id;
    private int capacity;
    private int complexity;

    public Lab() {
        this.id = 0;
        this.capacity = 0;
        this.complexity = 0;
    }

    public Lab(int id) {
        this.id = id;
    }

    public Lab(int capacity, int complexity) {
        this.capacity = capacity;
        this.complexity = complexity;
    }

    public Lab(int id, int capacity, int complexity) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Lab{" +
                "id=" + id +
                ", capacity=" + capacity +
                ", complexity=" + complexity +
                '}';
    }
}
