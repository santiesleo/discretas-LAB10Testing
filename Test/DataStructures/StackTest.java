package DataStructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    @Test
    void testPushOneElement() throws StackException {
        // Arrange
        Stack<Integer> stack = new Stack<>();

        // Act
        stack.push(1);

        // Assert
        assertEquals(1, stack.size());
        assertEquals(1, stack.top());
    }

    @Test
    void testPushMultipleElements() {
        // Arrange
        Stack<Integer> stack = new Stack<>();

        // Act
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Assert
        assertEquals(3, stack.size());
    }

    @Test
    void testVerifyReturnPop() throws StackException {

        // Arrange
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Act
        int expectedValue = 3;
        int actualValue = stack.pop();

        // Assert
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void testPopMultiplesElements() throws StackException {
        // Arrange
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Act
        int expectedValue = 3;
        int actualValue = stack.pop();
        int expectedSize = 2;

        // Arrange
        assertEquals(expectedValue, actualValue);
        assertEquals(expectedSize, stack.size());
    }

    @Test
    void testPopEmptyStack() {
        // Arrange
        Stack<Integer> stack = new Stack<>();

        // Assert
        assertThrows(StackException.class, () -> {
            stack.pop();
        });
    }

    @Test
    public void testTopNotEmptyStack() throws StackException {
        // Arrange
        Stack<Integer> stack = new Stack<>();
        stack.push(1);

        // Act
        int result = stack.top();

        // Assert
        assertEquals(1, result);
    }

    @Test
    public void testTopEmptyStack() {
        // Arrange
        Stack<Integer> stack = new Stack<>();

        // Act & Assert
        assertThrows(StackException.class, () -> {
            stack.top();
        });
    }

    @Test
    public void testTopMultipleElements() throws StackException {
        // Arrange
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Act
        int result = stack.top();

        // Assert
        assertEquals(3, result);
    }

    @Test
    public void testIsEmptyWithEmptyStack() {
        // Arrange
        Stack<Integer> stack = new Stack<>();

        // Act
        boolean result = stack.isEmpty();

        // Assert
        assertTrue(result);
    }


    @Test
    public void testIsEmptyWithNonEmptyStack() {
        // Arrange
        Stack<Integer> stack = new Stack<>();
        stack.push(1);

        // Act
        boolean result = stack.isEmpty();

        // Assert
        assertFalse(result);
    }


    @Test
    public void testIsEmptyAfterPopAllElements() throws StackException {
        // Arrange
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Act
        stack.pop();
        stack.pop();
        stack.pop();

        boolean result = stack.isEmpty();

        // Assert
        assertTrue(result);
    }

    @Test
    public void testSizeWithEmptyStack() {
        // Arrange
        Stack<Integer> stack = new Stack<>();

        // Act
        int result = stack.size();

        // Assert
        assertEquals(0, result);
    }


    @Test
    public void testSizeWithNonEmptyStack() {
        // Arrange
        Stack<Integer> stack = new Stack<>();
        stack.push(1);

        // Act
        int result = stack.size();

        // Assert
        assertEquals(1, result);
    }

    @Test
    public void testSizeAfterPushAndPopOperations() throws StackException {
        // Arrange
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();

        // Act
        int result = stack.size();

        // Assert
        assertEquals(2, result);
    }

    @Test
    public void testPrintWithEmptyStack() {
        // Arrange
        Stack<Integer> stack = new Stack<>();

        // Act
        String result = stack.print();

        // Assert
        assertEquals("", result);
    }

    @Test
    public void testPrintWithNonEmptyStack() {
        // Arrange
        Stack<Integer> stack = new Stack<>();
        stack.push(1);

        // Act
        String result = stack.print();

        // Assert
        assertEquals("1", result);
    }

    @Test
    public void testPrintWithMultipleElementsInStack() {
        // Arrange
            Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Act
        String result = stack.print();

        // Assert
        assertEquals("321", result);
    }


}
