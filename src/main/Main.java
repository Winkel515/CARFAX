package main;

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
        avl.insert(new Vehicle("c"));
        avl.insert(new Vehicle("a"));
        avl.insert(new Vehicle("e"));
        avl.insert(new Vehicle("d"));
        avl.insert(new Vehicle("b"));
        avl.insert(new Vehicle("f"));
        avl.insert(new Vehicle("g"));
        avl.printPreOrder();
        avl.delete("e");
        avl.printPreOrder();
    }
}
