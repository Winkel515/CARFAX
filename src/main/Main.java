package main;

import accident.AccidentHistory;
import avl.AVL;
import avl.DuplicateVINException;
import avl.Vehicle;
import cvr.CVR;
import cvr.InvalidKeyException;
import cvr.KeyLengthOutOfBoundsException;
import cvr.ThresholdOutOfBoundsException;
import sequence.NonexistantVINException;
import sequence.Sequence;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws DuplicateVINException, ThresholdOutOfBoundsException, KeyLengthOutOfBoundsException, InvalidKeyException, NonexistantVINException {

        CVR structure = new CVR(1000, 11);
        ArrayList<String> keys = structure.generate(999);

        for (int i = 0; i < 999; i++) {
            structure.add(keys.get(i), new Vehicle(keys.get(i)));
            structure.getValues(keys.get(i)).addAccident("Shit went wrong", LocalDate.of(1999, 11, 25));
            structure.getValues(keys.get(i)).addAccident("Car went boom", LocalDate.of(2000, 10, 11));
            structure.getValues(keys.get(i)).addAccident("Big crash", LocalDate.of(2000, 10, 10));
            structure.getValues(keys.get(i)).addAccident("Very old accident", LocalDate.of(0, 1, 1));
        }

        System.out.println("The current structure has " + structure.getSize() + " vehicules and is a " + structure.isWhat());

        keys.add(structure.generate(1).get(0));
        structure.add(keys.get(999), new Vehicle(keys.get(999)));

        System.out.println("The current structure has " + structure.getSize() + " vehicules and is an " + structure.isWhat());

        structure.getValues(keys.get(750)).printVehicle();

        String testkey = structure.prevKey(keys.get(750));
        System.out.println(testkey);

        System.out.println(structure.nextKey(testkey));

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




    }
}
