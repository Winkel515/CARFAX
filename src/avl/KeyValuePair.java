package avl;

interface KeyValuePair<K extends Comparable<K>, V> {
    public K getKey();
    public V getValue();
}
