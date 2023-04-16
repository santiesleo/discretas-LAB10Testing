package DataStructures;

public class HNode <K, V>{
    private V value;
    private K key;

    private HNode<K, V> prev;
    private HNode<K, V> next;

    public HNode(K key, V value) {
        this.value = value;
        this.key = key;
    }

    public HNode<K, V> getPrev() {
        return prev;
    }

    public void setPrev(HNode<K, V> prev) {
        this.prev = prev;
    }

    public HNode<K, V> getNext() {
        return next;
    }

    public void setNext(HNode<K, V> next) {
        this.next = next;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }
}
