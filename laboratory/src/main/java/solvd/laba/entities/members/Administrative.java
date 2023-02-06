package solvd.laba.entities.members;

import solvd.laba.entities.resource.Resource;

public class Administrative extends Person {
    private Resource resource;

    public Administrative(int id, String name, String lastname, Resource resource) {
        super(id, name, lastname);
        this.resource = resource;
    }

    public Administrative(int id, String name, String lastname) {
        super(id, name, lastname);
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public String toString() {
        return "Administrative{" +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
