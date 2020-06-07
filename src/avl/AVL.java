package avl;

public class AVL {
    private Node root;

    public AVL() {};

    public void insert(Vehicle input) throws DuplicateVINException {
        if(isEmpty()) {
            root = new Node(input);
            return;
        }

        // BST Insertion
        Node current = root;
        while(true) {
            if (input.compareTo(current.vehicle.getVIN()) < 0) {
                if(current.hasLeft()) {
                    current = current.left;
                } else {
                    current.left = new Node(input);
                    break;
                }
            } else if (input.compareTo(current.vehicle.getVIN()) > 0) {
                if(current.hasRight()) {
                    current = current.right;
                } else {
                    current.right = new Node(input);
                    break;
                }
            } else {
                throw new DuplicateVINException(input.getVIN());
            }
        }

        //TODO Implement AVL-ification with rotations after insert
    }

    public Vehicle find(String VIN) {
        Node current = root;
        while(true) {
            System.out.println(current.vehicle.getVIN());
            if (current.vehicle.compareTo(VIN) > 0) {
                if(current.hasLeft()) {
                    current = current.left;
                } else {
                    return null;
                }
            } else if (current.vehicle.compareTo(VIN) < 0) {
                if(current.hasRight()) {
                    current = current.right;
                } else {
                    return null;
                }
            } else {
                return current.vehicle;
            }
        }
    }

    public void printInorder() {
        printInorder(root, "");
    }
    private void printInorder(Node v, String s) {
        if (v.hasLeft())
            printInorder(v.left, s+"L");
        System.out.printf("[%s %s]", v.vehicle.getVIN(), s);
        if (v.hasRight())
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
