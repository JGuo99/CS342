import java.util.Iterator;

public class GLIterator<I> implements Iterator<I> {
	GenericList<I>.Node<I> theList;
	//GLIterator<I> linkedList = new GLIterator<I>(next);
	//Constructor, start at the head
	GLIterator(GenericList<I>.Node<I> head) {
		super();
		theList = head;
	}
	
	public boolean hasNext() {
		if(null == theList)
			return false;
		else
			return true;
	}
	//Get the data of the head(theList) then point to the next data
	public I next() {
		if(this.hasNext() == true) {
			I val = theList.data;
			theList = theList.next;
			return val;
		}
		return null; 
	}
}
