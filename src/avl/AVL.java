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
                    current.left = new Node(input, current);
                    break;
                }
            } else if (input.compareTo(current.vehicle.getVIN()) > 0) {
                if(current.hasRight()) {
                    current = current.right;
                } else {
                    current.right = new Node(input, current);
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

    private void updateHeight(Node updatedNodeParent) {
        for (Node current = updatedNodeParent; current != null; current = current.parent) {
            if(!current.hasRight() && !current.hasLeft()) {
                current.height = 0;
            } else if (!current.hasRight()) {
                current.height = current.left.height + 1;
            } else if (!current.hasLeft()){
                current.height = current.right.height + 1;
            } else {
                current.height = Math.max(current.left.height, current.right.height);
            }
        }
    }

    // Useful for debugging prints nodes with [VIN Path ParentVIN]
    public void printInorder() {
        printInorder(root, "");
    }
    private void printInorder(Node v, String s) {
        if (v.hasLeft())
            printInorder(v.left, s+"L");
        if(v.parent == null)
            System.out.printf("[%s Ø %d root]", v.vehicle.getVIN(), v.height, s);
        else
            System.out.printf("[%s %s %d %s]", v.vehicle.getVIN(), s, v.height, v.parent.vehicle.getVIN());
        if (v.hasRight())
            printInorder(v.right, s+"R");
    }

    public boolean isEmpty() {
        return root == null;
    }

    private class Node {
        private Vehicle vehicle;
        private int height;
        private Node parent;
        private Node left;
        private Node right;

        private Node(Vehicle vehicle) {
            this.vehicle = vehicle;
            height = 0;
        }

        private Node(Vehicle vehicle, Node parent) {
            this.parent = parent;
            this.vehicle = vehicle;
            height = 0;
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
