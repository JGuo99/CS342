import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class QueueTest {
    GenericQueue<Integer> q;

    @BeforeEach
    void init() {
        q = new GenericQueue<>(100);
    }
    //Initialize test, Object and constructor
    @Test
    void testInitGS() {
        assertEquals("GenericQueue", q.getClass().getName(), "did not initialize proper object");
    }
    @Test
    void testInitNode() {
        assertEquals("GenericList$Node", q.head.getClass().getName(), "did not initialize node in constructor");
    }
    //check to see if value is in the node
    @Test
    void testForNodeVal() {
        assertEquals(100, q.head.data, "value not in node");
    }
    //check if dequeue, we should see the init value
    @Test
    void testDequeueListVal() {
        assertEquals(100, q.dequeue(), "value not returned");
    }
    //check to see if enqueue works
    @Test
    void testEnqueueVal() {
        q.enqueue(150);
        assertEquals(150, q.head.data, "Value did not push");
    }
    @Test
    //check to see if enqueue works with 5 values
    void testEnqueueWith5Val() {
        int intArr[] = new int[]{10, 20, 30, 40};
        for (int i = 0; i < intArr.length; i++) {
            q.enqueue(i);
        }
        assertEquals(3, q.head.data, "Value did not enqueue to the 5th node");
        assertEquals(5, q.getLength(), "Length should be 5 after enqueueing 4 elements");
    }
    //dequeue 5 val, see if return null and length 0, this check if it will dequeue empty queue
    @Test
    void testDequeue5Val() {
        int intArr[] = new int[]{10, 20, 30, 40};
        for (int j = intArr.length - 1; j >= 0; j++) {
            q.dequeue();
        }
        q.dequeue();
        assertNull(q.head);
        assertEquals(0, q.getLength(), "Length should be 0 after dequeue all elements");
    }
    //check length of init queue
    @Test
    void testLength() {
        assertEquals(1, q.getLength(), "Length is should be 1");
    }
    //check negative length
    @Test
    void testNegativeLength() {
        for (int i = 0; i < 2; i++) {
            q.dequeue();
        }
        assertNotEquals( q.getLength() < 0, q.getLength(), "Length is NEGATIVE!");
    }
    //test length after enqueue
    @Test
    void testlengthAfterEnqueue() {
        q.enqueue(100);
        assertEquals(2, q.getLength(), "Length did not increase");
    }
    //test if queue is empty after dequeue
    @Test
    void testEmptyList() {
        q.dequeue();
        assertNull(q.head);
    }
    //this will check if if we can dequeue from list of 5
    @ParameterizedTest
    @ValueSource(ints = {10, 20, 30, 40})
    void testDequeue5Val(int elements) {
        for(int i = 0; i < elements; i++) {
            q.dequeue();
            assertEquals(0, q.getLength());
        }
        assertNull(q.head);
        assertEquals(0, q.getLength(), "Length should be 0");
    }
}