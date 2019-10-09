import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListTest {

	GenericStack<Integer> x;
	GenericQueue<Integer> y;

	@BeforeEach
	void setup() {
		x = new GenericStack<Integer>(5);
		y = new GenericQueue<Integer>(10);
	}
	
	@Test
	void InitSTest() {
		assertEquals("GenericStack", x.getClass().getName(), "Did not initialize");
	}
	
	@Test
	void InitQTest() {
		assertEquals("GenericQueue", y.getClass().getName(), "Did not initialize");
	}
	
	@Test
	void NodeSTest() {
		assertEquals(5, x.head.data, "Value not in node");
	}
	
	@Test
	void NodeQTest() {
		assertEquals(10, y.head.data, "Value not in node");
	}
	
	@Test
	void PushSTest() {
		x.push(13);
		assertEquals(13, x.head.data, "Wrong value");
	}

	@Test
	void PushQTest() {
		y.push(26);
		assertEquals(26, y.head.data, "Wrong value");
	}

	@Test
	void DeleteSTest() {
		assertEquals(5, x.pop(), "Value did not pop");
	}

	@Test
	void DeleteQTest() {
		assertEquals(10, y.pop(), "Value did not pop");
	}
	
	@Test
	void EmptySTest() {
		x.pop();
		assertNull(x.head);
	}
	
	@Test
	void EmptyQTest() {
		y.pop();
		assertNull(y.head);
	}

}
