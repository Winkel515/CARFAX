package accident;

import java.util.Date;

/**
 * AccidentHistory will work as a priority queue storing the history of accidents of a specific car
 */
public class AccidentHistory {
    Node head;

    AccidentHistory(){};

    private static class Node {
        Node next;
        Accident content;
    }

    public void addAccident(String description, Date date) {

    }
}
