import java.util.Iterator;

public class GenericQueue<I> extends GenericList<I> implements CreateIterator<I> {
	GenericQueue(I data) {
		super(data);
		// TODO Auto-generated constructor stub
	}
	
	void push(I data) {
		add(data);
	}
	//Enqueue, add to the back of the list
	@Override
	void add(I data) {
		// TODO Auto-generated method stub
		Node<I> node = new Node<I>(data);
		//if it's empty then set head node else set the next element to node
		if(isEmpty()) {
			this.head = node;
		}else {
			this.head.next = node; //set next head to node
			this.setLength(1); //increase length
		}
		this.head = node;
	}
	void pop() {
		super.delete();
	}
	//checks if the head is empty
	boolean isEmpty() {
		return head == null;
	}

	@Override
	public Iterator<I> createIterator() {
		// TODO Auto-generated method stub
		GLIterator<I> iterator = new GLIterator<I>(super.head);
		return iterator;
	}
}
