package main;

import avl.AVL;
import avl.DuplicateVINException;
import avl.Vehicle;
import sequence.NonexistantVINException;

public class Testing {
    public static void main(String[] args) throws DuplicateVINException, NonexistantVINException {
        AVL avl = new AVL();
        avl.insert(new Vehicle("a"));
        avl.insert(new Vehicle("b"));
        avl.insert(new Vehicle("c"));
        avl.insert(new Vehicle("d"));
        avl.insert(new Vehicle("e"));
        avl.insert(new Vehicle("f"));
        avl.insert(new Vehicle("g"));
        avl.insert(new Vehicle("h"));
        avl.insert(new Vehicle("i"));
        avl.insert(new Vehicle("j"));
        avl.insert(new Vehicle("k"));
        avl.insert(new Vehicle("l"));
        avl.insert(new Vehicle("m"));
        avl.insert(new Vehicle("n"));
        avl.insert(new Vehicle("o"));
        avl.insert(new Vehicle("p"));
        avl.insert(new Vehicle("q"));
        avl.insert(new Vehicle("r"));
        avl.insert(new Vehicle("s"));
        avl.insert(new Vehicle("t"));
        avl.insert(new Vehicle("u"));
        avl.insert(new Vehicle("v"));
        avl.insert(new Vehicle("w"));
        avl.insert(new Vehicle("x"));
        avl.insert(new Vehicle("y"));
        avl.insert(new Vehicle("z"));
        avl.printPreOrder();
        for(int i = 0; i < 26; i++) {
            String s = (char)('A' + i) + "";
            System.out.print(s + " --> ");
            System.out.println(avl.nextKey(s));
        }
    }
}
