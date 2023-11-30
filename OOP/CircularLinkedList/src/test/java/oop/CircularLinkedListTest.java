package oop;

import java.util.Optional;

import org.javagrader.Grade;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@Grade
public class CircularLinkedListTest {
    
    @Test
    @Grade(value = 1)
    public void testSimple1() {
        CircularLinkedList list = new CircularLinkedList();
        assertTrue(list.isEmpty());

        list.enqueue(0);

        assertFalse(list.isEmpty());
        Optional<CircularLinkedList.Node> first = list.getFirst();
        assertTrue(first.isPresent());
        assertEquals(0, first.get().value);
        
        Optional<CircularLinkedList.Node> last = list.getLast();
        // Here we compare the references since last and first must be the same object
        assertTrue(last.isPresent());
        assertTrue(first.get() == last.get());

        list.enqueue(1);
        list.enqueue(2);

        first = list.getFirst();
        assertTrue(first.isPresent());
        assertEquals(0, first.get().value);

        assertEquals(3, list.size);
        int[] array = new int[]{0, 1, 2};
        CircularLinkedList.Node current = list.first.get();
        for (int i = 0; i < array.length; i++) {
            assertEquals(array[i], current.value);
            current = current.next.get();
        }            
    }

    @Test
    @Grade(value = 1)
    public void testSimple2() {
        CircularLinkedList list = new CircularLinkedList();

        list.enqueue(0);
        list.enqueue(1);
        list.enqueue(2);

        assertEquals(-1,list.remove(4));
        list.remove(1);

        int[] array = new int[]{0, 2};
        CircularLinkedList.Node current = list.first.get();
        for (int i = 0; i < array.length; i++) {
            assertEquals(array[i], current.value);
            current = current.next.get();
        }
    }

    @Test
    @Grade(value = 1)
    public void testSimple3() {
        CircularLinkedList list = new CircularLinkedList();

        assertEquals(-1, list.remove(0));

        list.enqueue(0);
        assertEquals(0, list.remove(0));

        list.enqueue(1);
        list.enqueue(2);
        list.enqueue(3);

        assertEquals(-1, list.remove(3));
        list.remove(0);

        int[] array = new int[]{2, 3};
        CircularLinkedList.Node current = list.first.get();
        for (int i = 0; i < array.length; i++) {
            assertEquals(array[i], current.value);
            current = current.next.get();
        }
    }
    
}
