package DataStructures;

public class Stack <T> implements IStack<T> {
    private Node<T> top;
    private int size;

    public Stack() {
        top = null;
        size = 0;
    }

    @Override
    public void push(T value) {
        Node<T> node = new Node<>(value);
        if (!isEmpty()) {
            node.setNext(top);
        }
        top = node;
        size++;
    }

    @Override
    public T pop() throws StackException {
        if (!isEmpty()) {
            T aux = top.getValue();
            top = top.getNext();
            size--;
            return aux;
        } else {
            throw new StackException("Empty stack");
        }
    }

    @Override
    public T top() throws StackException {
        if (!isEmpty()) {
            return top.getValue();
        } else {
            throw new StackException("Empty stack");
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }


    public String print() {
        StringBuilder s = new StringBuilder();
        Node<T> aux = top;
        while (aux != null) {
            s.append(aux.getValue().toString());
            aux = aux.getNext();
        }
        return s.toString();
    }
}
