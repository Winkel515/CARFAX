package avl;

public class AVL<T extends KeyValuePair> {
    private Node root;

    public AVL() {};

    public void insert(T input) {
        if(isEmpty()) {
            root = new Node(input);
            return;
        }
        //TODO Implement binary tree insertion
//        Node current = root;
//        while(current != null) {
//
//        }

        //TODO Implement AVL fixing with rotations after insert
    }

    public boolean isEmpty() {
        return root == null;
    }

    private class Node {
        private T content;
        private long height;
        private Node left;
        private Node right;

        private Node(T content) {
            this.content = content;
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
        private T getContent() {
            return content;
        }
    }
}
