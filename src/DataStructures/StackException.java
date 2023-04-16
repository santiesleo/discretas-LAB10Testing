package DataStructures;

public class StackException extends Exception {
    public StackException(String empty_stack) {
        super("Stack is empty");
    }
}
