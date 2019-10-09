import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

public class IteratorTest {
    GenericStack<Integer> c = new GenericStack<Integer>(310);
    Iterator<Integer> i = c.createIterator();
    //see if there is next value
    @Test
    void testHasNext() {
        assertTrue(i.hasNext(),"No next Value");
    }
    //check if hasNext works after Iterating
    @Test
    void testHasNextIterOnce() {
        i.next();
        assertFalse(i.hasNext(), "hasNext did NOT work after iterating");
    }
    //check if next is able to move to the end of the stack
    @Test
    void testHasNextIterateWithPush() {
        c.push(110);
        i.next();
        assertFalse(i.hasNext(), "Next did NOT move");
    }
    //checks the value next is point to
    @Test
    void testNext() {
        assertEquals(310, i.next(), "Should point to the first value");
    }
    //Check if next() will stop, means we can still push value to stack
    @Test
    void testHasNextPush() {
        i.hasNext();
        c.push(210);
        assertTrue(i.hasNext(), "Next did not stop, fail to push");
    }
    //Test hasNext with Pop
    @Test
    void testHasNextPop() {
        i.next();
        c.pop();
        assertFalse(i.hasNext(), "hasNext did fail to work with pop");
    }
    //Test null with next
    @Test
    void testNextPush() {
        c.push(null);
        i.next();
        assertFalse(i.hasNext());
    }
    //Test null with next
    @Test
    void testNextNull() {
        c.push(null);
        assertNull(i.next(), "Fail to see Null Nodes");
    }
    //test if hasNext work with push values
    @Test
    void testHasNextVal() {
        c.push(21);
        c.push(12);
        assertEquals(i.hasNext(), true, "hasNext fail to work with push");

    }
    //Test by adding value to stack and check by using hasNext and Next
    @Test
    void testNextIterator() {
        for (int j = 0; j <= 4 ; j++) {
            c.push(j);
        }
        assertEquals(6, c.getLength(), "length is wrong: should be 6");
        Iterator<Integer> it = c.createIterator();
        int x = 1;
        while (it.hasNext()) {
            assertEquals(x, (int) it.next(), "X and Next does not equal");
            x++;
        }
        assertEquals(5, x, "Failed: X is not 5");
        assertEquals(4, c.getLength(), "Length does not match, should be 4");
    }
}
