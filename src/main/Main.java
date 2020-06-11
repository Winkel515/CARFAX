package main;

import avl.AVL;
import avl.DuplicateVINException;
import avl.Vehicle;
import cvr.CVR;
import cvr.InvalidKeyException;
import sequence.Sequence;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws DuplicateVINException, InvalidKeyException {
//        AccidentHistory history = new AccidentHistory();
//        history.addAccident("Shit went wrong", LocalDate.of(1999, 11, 25));
//        history.addAccident("Car went boom", LocalDate.of(2000, 10, 11));
//        history.addAccident("Big crash", LocalDate.of(2000, 10, 10));
//        history.addAccident("Very old accident", LocalDate.of(0, 1, 1));
//        history.printHistory();


//        AVL avl = new AVL();
//        avl.insert(new Vehicle("a"));
//        avl.insert(new Vehicle("b"));
//        avl.insert(new Vehicle("c"));
//        avl.insert(new Vehicle("d"));
//        avl.insert(new Vehicle("e"));
//        avl.insert(new Vehicle("f"));
//        avl.insert(new Vehicle("g"));
//        avl.insert(new Vehicle("h"));
//        avl.insert(new Vehicle("i"));
//        avl.insert(new Vehicle("j"));
//        avl.insert(new Vehicle("k"));
//        avl.insert(new Vehicle("l"));
//        avl.insert(new Vehicle("m"));
//        avl.insert(new Vehicle("n"));
//        avl.insert(new Vehicle("o"));
//        avl.insert(new Vehicle("p"));
//        avl.insert(new Vehicle("q"));
//        avl.insert(new Vehicle("r"));
//        avl.insert(new Vehicle("s"));
//        avl.insert(new Vehicle("t"));
//        avl.insert(new Vehicle("u"));
//        avl.insert(new Vehicle("v"));
//        avl.insert(new Vehicle("w"));
//        avl.insert(new Vehicle("x"));
//        avl.insert(new Vehicle("y"));
//        avl.insert(new Vehicle("z"));
//        avl.printPreOrder();
//        System.out.println();
//
//        Sequence test = new Sequence();
//        test.addKeys("a", new Vehicle("a"));
//        test.addKeys("b", new Vehicle("b"));
//        test.addKeys("c", new Vehicle("c"));
//        test.addKeys("d", new Vehicle("d"));
//        test.addKeys("e", new Vehicle("e"));
//        test.addKeys("f", new Vehicle("f"));
//        test.addKeys("g", new Vehicle("g"));
//        System.out.println(test.prevKey("c"));
//        ArrayList<String> list = test.allKeys();
//        for (int i = 0; i < list.size(); i++)
//            System.out.println(list.get(i));
//
//        CVR testcvr = new CVR();
//        ArrayList<String> keys = testcvr.generate(3);
//        for (int i = 0; i < keys.size(); i++)
//            System.out.println(keys.get(i));
        CVR cvr = new CVR();
        cvr.printADT();
        ArrayList<String> keys = cvr.generate(1000);
        for(String key: keys) {
            cvr.add(key, new Vehicle(key));
        }
        cvr.printADT();
    }
}
