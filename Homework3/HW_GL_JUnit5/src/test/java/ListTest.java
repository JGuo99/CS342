import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;

class ListTest {

	GenericStack<Integer> s;
		
	@BeforeEach
	void init() {
		s = new GenericStack<Integer>(200);
	}
	//Initialize test, Object and constructor
	@Test
	void testInitGS() {
		assertEquals("GenericStack", s.getClass().getName(), "did not initialize proper object");
	}
	
	@Test
	void testInitNode() {
		assertEquals("GenericList$Node", s.head.getClass().getName(), "did not initialize node in constructor");
	}
	//check to see if value is in the node
	@Test
	void testForNodeVal() {
		assertEquals(200, s.head.data, "value not in node");
	}
	//check if we are popping the right value
	@Test
	void testPopListVal() {
		assertEquals(200, s.pop(), "value not returned");
	}
	//push value into the stack
	@Test
	void testPushVal() {
		s.push(100);
		assertEquals(100, s.head.data, "Value did not push");
	}
	//push 4 values into stack, checks length and head
	@Test
	void testPushWith5Val() {
		int intArr[] = new int[]{10, 20, 30, 40};
		for (int i = 0; i < intArr.length; i++) {
			s.push(i);
		}
		assertEquals(3, s.head.data, "Value did not push to the 5th node");
		assertEquals(5, s.getLength(), "Length should be 5 after pushing 4 elements");
	}
	//push 4 elements, then pop 4 elements. Checks if pop works
	@Test
	void testPopWith5Val() {
		int intArr[] = new int[]{10, 20, 30, 40};
		for (int i = 0; i < intArr.length; i++) {
			s.push(i);
		}
		assertEquals(3, s.head.data, "Value did not push to the 5th node");
		assertEquals(5, s.getLength(), "Length should be 5 after pushing 4 elements");
		for (int j = intArr.length - 1; j >= 0; j++) {
			s.pop();
		}
		s.pop();
		assertNull(s.head);
		assertEquals(0, s.getLength(), "Length should be 0 after popping all elements");
	}
	//check the length of the init stack
	@Test
	void testLength() {
		assertEquals(1, s.getLength(), "Length is should be 1");
	}
	//check if we can get a negative length
	@Test
	void testNegativeLength() {
		for (int i = 0; i < 2; i++) {
			s.pop();
		}
		assertNotEquals( s.getLength() < 0, s.getLength(), "Length is NEGATIVE!");
	}
	//check length after pushing a element onto the stack
	@Test
	void testlengthAfterPush() {
		s.push(100);
		assertEquals(2, s.getLength(), "Length did not increase");
	}
	//check if we get empty stack after popping off the init value
	@Test
	void testEmptyList() {
		s.pop();
		assertNull(s.head);
	}
	//check if we can pop off value on a empty stack
	@AfterEach
	void setup() {
		s = new GenericStack<>(null);
	}
	@Test
	void testPopWithNullHead() {
		s.pop();
		assertNull(s.head);
	}

}
