package avl;

import pkg.Vehicle;

public interface KeyValuePair<K extends Comparable<K>, V> {
    public K getKey();
    public V getValue();
}
