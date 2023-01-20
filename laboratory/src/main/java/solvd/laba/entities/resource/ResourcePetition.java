package solvd.laba.entities.resource;

import solvd.laba.entities.members.Scientist;

public class ResourcePetition {
    private int id;
    private Scientist scientist;
    private Resource resource;
    private String unit;
    private double quantity;

    public ResourcePetition(Scientist scientist, Resource resource, String unit, double quantity) {
        this.scientist = scientist;
        this.resource = resource;
        this.unit = unit;
        this.quantity = quantity;
    }

    public Scientist getScientist() {
        return scientist;
    }

    public void setScientist(Scientist scientist) {
        this.scientist = scientist;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        if (quantity < 0) {
            quantity = 0;
        }
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
