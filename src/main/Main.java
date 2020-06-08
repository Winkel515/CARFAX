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
        avl.insert(new Vehicle("E"));
        avl.printPreOrder();
        avl.insert(new Vehicle("H"));
        avl.printPreOrder();
        avl.insert(new Vehicle("A"));
        avl.printPreOrder();
        avl.insert(new Vehicle("F"));
        avl.printPreOrder();
        avl.insert(new Vehicle("P"));
        avl.printPreOrder();
        avl.insert(new Vehicle("Z"));
        avl.printPreOrder();
        avl.insert(new Vehicle("B"));
        avl.printPreOrder();
        avl.insert(new Vehicle("X"));
        avl.printPreOrder();
        avl.insert(new Vehicle("D"));
        avl.printPreOrder();
        avl.insert(new Vehicle("W"));
        avl.printPreOrder();
        System.out.println();

        //hello
        //hello2
    }
}
