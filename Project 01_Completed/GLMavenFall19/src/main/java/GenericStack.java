import java.util.Iterator;

public class GenericStack<I> extends GenericList<I> implements CreateIterator<I> {
	//constructor
	GenericStack(I data) {
		super(data);
	}
	
	//add data into the linkedlist
	void push(I data) {
		add(data);
	}
	
	void add(I data) {
		Node<I> node = new Node<I>(data);
		if(isEmpty()) {
			this.head = node;
		}
		head.next = node; //set next head to node
		head = head.next;	
		this.setLength(1);//increase length
	}
	
	//checks if the head is empty
		boolean isEmpty() {
			return head == null;
		}
	
	//Delete data "First Out" same as Queue
	public I pop() {
		return super.delete();
	}

	@Override
	public Iterator<I> createIterator() {
		// TODO Auto-generated method stub
		GLIterator<I> iterator = new GLIterator<I>(super.head);
		return iterator;
	}
	
}
