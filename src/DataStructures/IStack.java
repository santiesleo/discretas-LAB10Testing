package DataStructures;

public interface IStack<T> {
    public boolean isEmpty();
    void push(T value);

    public T top() throws StackException;
    public T pop() throws StackException;

    public int size();

    public String print();
}
