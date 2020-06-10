package main;

import avl.AVL;
import avl.DuplicateVINException;
import avl.Vehicle;
import sequence.Sequence;

import java.util.ArrayList;

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
        System.out.println();
        avl.delete("e");
        avl.printPreOrder();

        Sequence test = new Sequence();
        test.addKeys("a", new Vehicle("a"));
        test.addKeys("b", new Vehicle("b"));
        test.addKeys("c", new Vehicle("c"));
        test.addKeys("d", new Vehicle("d"));
        test.addKeys("e", new Vehicle("e"));
        test.addKeys("f", new Vehicle("f"));
        test.addKeys("g", new Vehicle("g"));
        System.out.println(test.prevKey("c"));
        ArrayList<String> list = test.allKeys();
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }
}
