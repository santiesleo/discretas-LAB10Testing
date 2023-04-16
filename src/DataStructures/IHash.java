package DataStructures;

public interface IHash<K, V> {
    public void insert(K key, V value) throws Exception, HashTableException;
    public V search(K key);
    public void delete(K key);
}
