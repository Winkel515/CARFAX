package avl;

import accident.AccidentHistory;

import java.time.LocalDate;

public class Vehicle implements Comparable<String>{
    private final String VIN;
    private AccidentHistory accidentHistory;

    public Vehicle(String VIN) {
        this.VIN = VIN.toUpperCase();
        accidentHistory = new AccidentHistory();
    }

    public void addAccident(String description, LocalDate date) {
        accidentHistory.addAccident(description, date);
    }

    @Override
    public int compareTo(String VIN) {
        return this.VIN.compareTo(VIN);
    }

    public String getVIN() {
        return VIN;
    }
}
