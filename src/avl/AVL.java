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
        this.updateHeight(current);
        //TODO Implement AVL-ification with rotations after insert
        boolean unbalanced = false;
        boolean r1 = false;
        boolean r2 = false;
        for(current = current.parent;current != null; current = current.parent) {
            if(current.isUnbalanced()) {
                Node travel = current;
                unbalanced = true;
                if (!travel.hasLeft())
                    r1 = true;
                else if (!travel.hasRight())
                    r1 = false;
                else {
                    r1 = travel.right.height > travel.left.height;
                }

                travel = r1 ? travel.right : travel.left;
                if (!travel.hasLeft())
                    r2 = true;
                else if (!travel.hasRight())
                    r2 = false;
                else {
                    r2 = travel.right.height > travel.left.height;
                }
                break;
            }
        }

        if (unbalanced) {
            if(r1 && r2) {
                leftRotation(current);
            } else if (!r1 && !r2) {
                rightRotation(current);
            } else if (r1 && !r2) {
                rightRotation(current.right);
                leftRotation(current);
            } else {
                leftRotation(current.left);
                rightRotation(current);
            }
        }
    }

    private void leftRotation(Node node) {
        Node r = node.right;
        node.right = r.left;
        if(node.right != null)
            node.right.parent = node;

        if(node == root)
            root = r;
        r.parent = node.parent;
        if(node.parent != null)
            if(node.isRightChild())
                node.parent.right = r;
            else
                node.parent.left = r;

        r.left = node;
        node.parent = r;

        this.updateHeight(node);
    }

    private void rightRotation(Node node) {
        Node l = node.left;
        node.left = l.right;
        if(node.left != null)
            node.left.parent = node;

        if(node == root)
            root = l;
        l.parent = node.parent;
        if(node.parent != null)
            if(node.isRightChild())
                node.parent.right = l;
            else
                node.parent.left = l;

        l.right = node;
        node.parent = l;

        this.updateHeight(node);
    }

    public Vehicle find(String VIN) {
        Node current = root;
        while(true) {
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
                current.height = Math.max(current.left.height, current.right.height) + 1;
            }
        }
    }

    // Useful for debugging prints nodes with [VIN Path ParentVIN]
    public void printPreOrder() {
        printPreOrder(root, "");
        System.out.println();
    }
    private void printPreOrder(Node v, String s) {
        if(v.parent == null)
            System.out.printf("[%s Ø %d root]", v.vehicle.getVIN(), v.height);
        else
            System.out.printf("[%s %s %d %s]", v.vehicle.getVIN(), s, v.height, v.parent.vehicle.getVIN());

        if (v.hasLeft())
            printPreOrder(v.left, s+"L");
        if (v.hasRight())
            printPreOrder(v.right, s+"R");
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

        private boolean isRightChild() {
            return this.parent != null && this.parent.right == this;
        }

        private boolean isLeftChild() {
            return this.parent != null && this.parent.left == this;
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

        private boolean isUnbalanced () {
            int rHeight = this.right == null ? -1 : this.right.height;
            int lHeight = this.left == null ? -1 : this.left.height;
            return Math.abs(rHeight - lHeight) > 1;
        }
    }
}
