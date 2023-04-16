package DataStructures;


public class Hash<K extends Comparable<K>, V> implements IHash<K, V> {

    private final HNode<K, V>[] bucketArray;
    private final HNode<K, V> deleted;

    private int size;
    private int capacity;

    public Hash(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.bucketArray = new HNode[capacity];
        this.deleted = new HNode<>(null, null);
    }

    @Override
    public void insert(K key, V value) throws HashTableException {
        for (int i = 0; i < bucketArray.length; i++) {
            int index = hash(key, i);
            if (bucketArray[index] == null) {
                bucketArray[index] = new HNode<>(key, value);
                size++;
                return;
            } else if (bucketArray[index].getKey().equals(key)) {
                throw new HashTableException("HashTableException: Key already exists in hash table");
            }
        }
        throw new HashTableException("HashTableException: Hash table overflow");
    }

    public V search(K key) {
        boolean stop = false;
        for (int i = 0; i < bucketArray.length && !stop; i++) {
            int index = Math.abs(hash(key, i)); // Utilizar valor absoluto del hash
            HNode<K, V> node = bucketArray[index];
            if (node == null) {
                stop = true;
            } else if (node != deleted && node.getKey() != null && node.getKey().equals(key)) {
                return node.getValue();
            }
        }
        return null;
    }


    @Override
    public void delete(K key) {
        boolean stop = false;
        for (int i = 0; i < bucketArray.length && !stop; i++) {
            int index = hash(key, i);
            HNode<K, V> node = bucketArray[index];
            if (node == null) {
                stop = true;
            } else if (node != deleted && node.getKey().equals(key)) {
                bucketArray[index] = deleted;
                size--;
                stop = true;
            }
        }
    }

    public int hash(K key, int i) {
        return (h1(key) + i * h2(key)) % bucketArray.length;
    }

    private int h1(K key) {
        return key.hashCode() % bucketArray.length;
    }

    private int h2(K key) {
        return 1 + (key.hashCode() % (bucketArray.length - 1));
    }

    public int getSize() {
        return size;
    }
}
