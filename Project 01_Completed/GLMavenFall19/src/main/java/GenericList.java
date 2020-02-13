
public abstract class GenericList<I> {
	Node<I> head; //head of the list
	private int length; //length of the list
	
	//constructor
	GenericList(I data) {
		// TODO Auto-generated constructor stub
		this.head = new Node<I>(data);
		this.length = 1;
	}

	//Prints the items of the list
	void print() {
		Node<I> val = head;
		while(val != null) {
			System.out.print(val.data);
			val = val.next;
		}
	}
	
	//adds the value to the list
	abstract void add(I data);
	
	//returns the first value list and deletes the node
	public I delete() {
		if(isEmpty())
			return null;
		else {
			Node<I> dNode = head;
			head = head.next;
			this.length--;	//decrease length by 1 since we deleted a node
			return dNode.data;
		}
	}
	//check if list is empty
	boolean isEmpty() {
		return head == null;
	}
	
	//Getter and setter for length
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = this.length + length;
	}

	public class Node<T> {
		T data;
		Node<T> next;
		//node data
		Node(T data) {
			this.data = data;
		}
		//node next
		Node(Node<T> next) {
			this.next = next;
		}
	}
}
