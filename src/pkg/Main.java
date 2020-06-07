package pkg;

import avl.AVL;
import avl.DuplicateVINException;
import avl.Vehicle;

public class Main {

    public static void main(String[] args) throws DuplicateVINException {
//        AccidentHistory history = new AccidentHistory();
//        history.addAccident("Shit went wrong", LocalDate.of(1999, 11, 25));
//        history.addAccident("Car went boom", LocalDate.of(2000, 10, 11));
//        history.addAccident("Big crash", LocalDate.of(2000, 10, 10));
//        history.addAccident("Very old accident", LocalDate.of(0, 1, 1));
//        history.printHistory();

        AVL avl = new AVL();
        avl.insert(new Vehicle("E"));
        avl.insert(new Vehicle("H"));
        avl.insert(new Vehicle("A"));
        avl.insert(new Vehicle("F"));
        avl.insert(new Vehicle("P"));
        avl.insert(new Vehicle("Z"));
        avl.insert(new Vehicle("B"));
        avl.insert(new Vehicle("X"));
        avl.insert(new Vehicle("D"));
        avl.insert(new Vehicle("W"));
        avl.printInorder();
        System.out.println();
        avl.find("W");

        //hello
        //hello2
    }
}
