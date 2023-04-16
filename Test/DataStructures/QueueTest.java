package DataStructures;

import Model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {

    private Queue<Person> queue;

    @BeforeEach
    void setUp() {
        queue = new Queue<>();
    }

    @Test
    void testQueueIsEmpty(){
        assertTrue(queue.isEmpty());
    }

    @Test
    void testQueueIsNotEmpty(){
        // Arrange
        Person person = new Person("Santiago", "1112", 19);

        // Act
        queue.enqueue(person);

        // Assert
        assertFalse(queue.isEmpty());
    }

    @Test
    void testQueueIsEmptyAfterRemove() throws QueueException {
        // Arrange
        Person person = new Person("Santiago", "1112", 19);
        queue.enqueue(person);

        // Act
        queue.dequeue();

        // Assert
        assertTrue(queue.isEmpty());
    }

    @Test
    void testVerifyFrontQueueIsEmpty() {
        // Assert
        assertThrows(QueueException.class, () ->{
            queue.front();
        });
    }

    @Test
    void testUniqueElementInQueueIsFront() throws QueueException {
        // Arrange
        Person person = new Person("Santiago", "1112", 19);

        // Act
        queue.enqueue(person);

        // Assert
        assertEquals(queue.front(), person);
    }

    @Test
    void testFirstElementToEnqueueIsFrontAfterPutMoreElements() throws QueueException {
        // Arrange
        Person firstPerson = new Person("Santiago", "1112", 19);
        Person secondPerson = new Person("Juan", "1113", 21);

        // Act
        queue.enqueue(firstPerson);
        queue.enqueue(secondPerson);


        // Assert
        assertEquals(queue.front(), firstPerson);
    }

    @Test
    void testVerifyFrontAfterDequeue() throws QueueException {
        // Arrange
        Person firstPerson = new Person("Santiago", "1112", 19);
        Person secondPerson = new Person("Juan", "1113", 21);
        Person thirdPerson = new Person("Sebastian", "1114", 22);
        queue.enqueue(firstPerson);
        queue.enqueue(secondPerson);
        queue.enqueue(thirdPerson);

        // Act
        queue.dequeue();


        // Assert
        assertEquals(queue.front(), secondPerson);
    }

    @Test
    void testVerifyBackQueueIsEmpty(){
        // Assert
        assertThrows(QueueException.class, () -> {
            queue.back();
        });
    }

    @Test
    void testUniqueElementInQueueIsBack() throws QueueException{
        // Arrange
        Person person = new Person("Santiago", "1112", 19);

        // Act
        queue.enqueue(person);

        // Assert
        assertEquals(queue.back(), person);
    }

    @Test
    void testLastElementToEnqueueIsBackAfterPutMoreElements() throws QueueException {
        // Arrange
        Person firstPerson = new Person("Santiago", "1112", 19);
        Person secondPerson = new Person("Juan", "1113", 21);

        // Act
        queue.enqueue(firstPerson);
        queue.enqueue(secondPerson);

        // Assert
        assertEquals(queue.back(), secondPerson);
    }

    @Test
    void testInsertOneElement() throws QueueException {
        // Arrange
        Person person = new Person("Santiago", "1112", 19);

        // Act
        queue.enqueue(person);

        // Assert
        assertEquals(queue.front(), person);
        assertEquals(queue.back(), person);
        assertFalse(queue.isEmpty());
        assertEquals(queue.getSize(), 1);
    }

    @Test
    void testInsertThreeElements() throws QueueException {
        // Arrange
        Person firstPerson = new Person("Santiago", "1112", 19);
        Person secondPerson = new Person("Juan", "1113", 21);
        Person thirdPerson = new Person("Sebastian", "1114", 22);

        // Act
        queue.enqueue(firstPerson);
        queue.enqueue(secondPerson);
        queue.enqueue(thirdPerson);

        // Assert
        assertEquals(queue.front(), firstPerson);
        assertEquals(queue.back(), thirdPerson);
        assertFalse(queue.isEmpty());
        assertEquals(queue.getSize(), 3);
    }

    @Test
    void testDeleteUniqueElement() throws QueueException {
        // Arrange
        Person person = new Person("Santiago", "1112", 19);
        queue.enqueue(person);

        // Act
        queue.dequeue();

        // Assert
        assertEquals(queue.size(), 0);
        assertTrue(queue.isEmpty());
    }

    @Test
    void testDeleteQueueIsEmpty(){
        // Assert
        assertThrows(QueueException.class, () ->{
            queue.dequeue();
        });
        assertTrue(queue.isEmpty());
    }

    @Test
    void testDeleteMultipleElements() throws QueueException {
        // Arrange
        Person firstPerson = new Person("Santiago", "1112", 19);
        Person secondPerson = new Person("Juan", "1113", 21);
        Person thirdPerson = new Person("Sebastian", "1114", 22);
        queue.enqueue(firstPerson);
        queue.enqueue(secondPerson);
        queue.enqueue(thirdPerson);

        // Act
        queue.dequeue();
        queue.dequeue();

        // Assert
        assertFalse(queue.isEmpty());
        assertEquals(queue.back(), thirdPerson);
        assertEquals(queue.size(), 1);
    }

    @Test
    public void testPrintEmptyList() {
        // Act
        String result = queue.print();

        // Assert
        assertEquals("", result);
    }

    @Test
    public void testPrintListWithOneElement() {
        // Arrange
        Person person = new Person("Santiago", "1112", 19);
        queue.enqueue(person);

        // Act
        String result = queue.print();

        // Assert
        assertEquals("Santiago 1112 19", result);
    }

    @Test
    public void testPrintListWithMultipleElements() {
        // Arrange
        Queue<Character>  queue2 = new Queue<>();
        queue2.enqueue('H');
        queue2.enqueue('O');
        queue2.enqueue('L');
        queue2.enqueue('A');

        // Act
        String result = queue2.print();

        // Assert
        assertEquals("HOLA", result);
    }

}
