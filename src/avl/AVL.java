package avl;

import pkg.Vehicle;

public class AVL {
    private Node root;

    public AVL() {};

    public void insert(Vehicle input) throws DuplicateVINException {
        if(isEmpty()) {
            root = new Node(input);
            return;
        }

        //TODO Implement binary tree insertion
        Node current = root;
        while(current != null) {
            if (input.compareTo(current.vehicle) < 0) {
                if(current.left != null) {
                    current = current.left;
                } else {
                    current.left = new Node(input);
                    break;
                }
            } else if (input.compareTo(current.vehicle) > 0) {
                if(current.right != null) {
                    current = current.right;
                } else {
                    current.right = new Node(input);
                    break;
                }
            } else {
                System.out.println(current.vehicle.getVIN());
                System.out.println(input.getVIN());
                throw new DuplicateVINException(input.getVIN());
            }
        }

        //TODO Implement AVL fixing with rotations after insert
    }

    public void printInorder() {
        printInorder(root, "");
    }
    private void printInorder(Node v, String s) {
        if (v.left != null)
            printInorder(v.left, s+"L");
        System.out.printf("[%s %s]", v.vehicle.getVIN(), s);
        if (v.right != null)
            printInorder(v.right, s+"R");
    }

    public boolean isEmpty() {
        return root == null;
    }

    private class Node {
        private Vehicle vehicle;
        private long height;
        private Node left;
        private Node right;

        private Node(Vehicle vehicle) {
            this.vehicle = vehicle;
        }

        private boolean hasLeft() {
            return left != null;
        }

        private boolean hasRight() {
            return right != null;
        }

        private Node getRight() {
            return right;
        }
        private Node getLeft() {
            return left;
        }
        private Vehicle getVehicle() {
            return vehicle;
        }
    }
}
