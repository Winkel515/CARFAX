package pkg;

import accident.AccidentHistory;

import java.time.LocalDate;

public class Vehicle {
    private final String VIN;
    private AccidentHistory accidentHistory;

    public Vehicle(String VIN) {
        this.VIN = VIN;
        accidentHistory = new AccidentHistory();
    }

    public void addAccident(String description, LocalDate date) {
        accidentHistory.addAccident(description, date);
    }
}
