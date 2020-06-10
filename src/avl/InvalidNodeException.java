package avl;

public class InvalidNodeException extends Exception{
    public InvalidNodeException() {
        super("The node does not belong to the AVL Tree");
    }
}
