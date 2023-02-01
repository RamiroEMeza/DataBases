package solvd.laba.entities.members;

public class TechnicalSupport extends Person {
    TechnicalSupport(String name, String lastName) {
        super(name, lastName);
    }

    public TechnicalSupport(int id, String name, String lastname) {
        super(id, name, lastname);
    }
}
