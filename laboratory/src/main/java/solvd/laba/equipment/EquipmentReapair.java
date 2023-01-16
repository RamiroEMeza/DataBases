package solvd.laba.equipment;

import solvd.laba.members.TechnicalSupport;

import java.time.LocalDate;

public class EquipmentReapair {
    private int equipment;
    private int tSupport;
    private String status;
    private LocalDate start;

    public EquipmentReapair(int equipment, int tSupport, String status, LocalDate start) {
        this.equipment = equipment;
        this.tSupport = tSupport;
        this.status = status;
        this.start = start;
    }

    public int getEquipment() {
        return equipment;
    }

    public void setEquipment(int equipment) {
        if (equipment < 0) {
            equipment = 0;
        }
        this.equipment = equipment;
    }

    public int gettSupport() {
        return tSupport;
    }

    public void settSupport(int tSupport) {
        if (tSupport < 0) {
            tSupport = 0;
        }
        this.tSupport = tSupport;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }
}
