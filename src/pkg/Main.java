package pkg;

import accident.AccidentHistory;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        AccidentHistory history = new AccidentHistory();
        history.addAccident("Shit went wrong", LocalDate.of(1999, 11, 25));
        history.addAccident("Car went boom", LocalDate.of(2000, 10, 11));
        history.addAccident("Big crash", LocalDate.of(2000, 10, 10));
        history.addAccident("Very old accident", LocalDate.of(0, 1, 1));
        history.printHistory();
    }
}
