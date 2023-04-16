package DataStructures;

import Model.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HashTest {


    @Test
    public void testInsertingElementIntoEmptyTable() throws HashTableException {
        // Arrange
        Hash<String, Person> hash = new Hash<>(10);
        Person firstPerson = new Person("Santiago", "1112", 19);

        // Act
        hash.insert(firstPerson.getName(), firstPerson);

        // Assert
        assertEquals(hash.getSize(), 1);
    }


    @Test
    public void testInsertDuplicateKey() throws HashTableException {
        // Arrange
        Hash<String, Person> hash = new Hash<>(10);
        Person firstPerson = new Person("Santiago", "1112", 19);
        Person secondPerson = new Person("Andres", "1112", 25);

        // Act
        hash.insert(firstPerson.getId(), firstPerson);

        // Assert
        assertThrows(HashTableException.class, () -> hash.insert(secondPerson.getId(), secondPerson));
    }


    @Test
    public void testInsertMaxCapacity() throws HashTableException {
        // Arrange
        Hash<String, Person> hash = new Hash<>(5);
        Person firstPerson = new Person("Santiago", "1112", 19);
        Person secondPerson = new Person("Andres", "2223", 25);
        Person thirdPerson = new Person("Maria", "3334", 30);
        Person fourthPerson = new Person("Juan", "4445", 35);
        Person fifthPerson = new Person("Carlos", "5556", 40);
        Person sixthPerson = new Person("Pedro", "6667", 45);

        // Act
        hash.insert(firstPerson.getName(), firstPerson);
        hash.insert(secondPerson.getName(), secondPerson);
        hash.insert(thirdPerson.getName(), thirdPerson);
        hash.insert(fourthPerson.getName(), fourthPerson);
        hash.insert(fifthPerson.getName(), fifthPerson);

        // Assert
        assertThrows(HashTableException.class, () -> hash.insert(sixthPerson.getName(), sixthPerson));
    }

    @Test
    public void testSearchExistingElement() throws HashTableException {
        // Arrange
        Hash<Integer, String> hashTable = new Hash<>(10);
        hashTable.insert(1, "uno");
        hashTable.insert(2, "dos");
        hashTable.insert(3, "tres");

        // Act
        String result = hashTable.search(2);

        // Assert
        assertEquals("dos", result);
    }

    @Test
    public void testSearchNonExistingElement() throws HashTableException {
        // Arrange
        Hash<String, Integer> hashTable = new Hash<>(5);
        hashTable.insert("uno", 1);
        hashTable.insert("dos", 2);
        hashTable.insert("tres", 3);

        // Act
        Integer result = hashTable.search("cuatro");

        // Assert
        assertNull(result);
    }

    @Test
    public void testSearchDeletedElement() throws HashTableException {
        // Arrange
        Hash<String, Integer> hashTable = new Hash<>(5);
        hashTable.insert("uno", 1);
        hashTable.insert("dos", 2);
        hashTable.insert("tres", 3);
        hashTable.delete("dos");

        // Act
        Integer result = hashTable.search("dos");

        // Assert
        assertNull(result);
    }

    @Test
    public void testDeleteExistingKey() throws HashTableException {
        // Arrange
        Hash<String, Person> hash = new Hash<>(10);
        Person firstPerson = new Person("Santiago", "1112", 19);
        hash.insert(firstPerson.getName(), firstPerson);

        // Act
        hash.delete(firstPerson.getName());

        // Assert
        assertNull(hash.search(firstPerson.getName()));
        assertEquals(hash.getSize(), 0);
    }

    @Test
    public void testDeleteNonExistingKey() throws HashTableException {
        // Arrange
        Hash<String, Person> hash = new Hash<>(10);
        Person firstPerson = new Person("Santiago", "1112", 19);
        hash.insert(firstPerson.getName(), firstPerson);

        // Act
        hash.delete("NonExistingKey");

        // Assert
        assertEquals(hash.getSize(), 1);
    }

    @Test
    public void testDeleteKeyWithCollision() throws HashTableException {
        // Arrange
        Hash<String, Person> hash = new Hash<>(10);
        Person firstPerson = new Person("Santiago", "1112", 19);
        Person secondPerson = new Person("Andres", "2223", 25);
        hash.insert(firstPerson.getName(), firstPerson);
        hash.insert(secondPerson.getName(), secondPerson);

        // Act
        hash.delete(firstPerson.getName());

        // Assert
        assertNull(hash.search(firstPerson.getName()));
        assertNotNull(hash.search(secondPerson.getName()));
        assertEquals(hash.getSize(), 1);
    }


    @Test
    public void testHashWithPositiveResult() {
        // Arrange
        Hash<String, Person> hash = new Hash<>(10);
        String key = "Santiago";

        // Act
        int result = hash.hash(key, 0);

        // Assert
        assertTrue(result >= 0 && result < 10);
    }

    @Test
    public void testHashWithNegativeResult() {
        // Arrange
        Hash<String, Person> hash = new Hash<>(10);
        String key = "Andres";

        // Act
        int result = hash.hash(key, 1);

        // Assert
        assertTrue(result >= 0 && result < 10);
    }



}
