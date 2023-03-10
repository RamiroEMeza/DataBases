package solvd.laba.entities.equipment;

import solvd.laba.entities.members.Scientist;

import java.time.LocalDate;

public class EquipmentAsign {
    private int id;
    private Scientist scientist;
    private Equipment equipment;
    private LocalDate expires;

    public EquipmentAsign(Scientist scientist, Equipment equipment, LocalDate expires) {
        this.scientist = scientist;
        this.equipment = equipment;
        this.expires = expires;
    }

    public Scientist getScientist() {
        return scientist;
    }

    public void setScientist(Scientist scientist) {
        this.scientist = scientist;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public LocalDate getExpires() {
        return expires;
    }

    public void setExpires(LocalDate expires) {
        this.expires = expires;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
