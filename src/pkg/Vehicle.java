package pkg;

import accident.AccidentHistory;

import java.time.LocalDate;

public class Vehicle implements Comparable<Vehicle> {
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
    public int compareTo(Vehicle o) {
        return this.VIN.compareTo(o.VIN);
    }

    public String getVIN() {
        return VIN;
    }
}
