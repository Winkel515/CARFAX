package pkg;

import accident.AccidentHistory;
import avl.KeyValuePair;

import java.time.LocalDate;

public class Vehicle implements KeyValuePair<String, Vehicle> {
    private final String VIN;
    private AccidentHistory accidentHistory;

    public Vehicle(String VIN) {
        this.VIN = VIN;
        accidentHistory = new AccidentHistory();
    }

    public void addAccident(String description, LocalDate date) {
        accidentHistory.addAccident(description, date);
    }

    @Override
    public String getKey() {
        return VIN;
    }

    @Override
    public Vehicle getValue() {
        return this;
    }
}
