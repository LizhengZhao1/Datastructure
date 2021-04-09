package list;
import list.NODE;
import list.LinkStack.Node;
public class MySingleLinkedList<E> {
	NODE<E> head;
	NODE<E> tail;
	int size;
	
	public MySingleLinkedList() {
		this.head = new NODE<E>(null);
		size = 0;
	}
	
	public boolean add(E element) {
		NODE<E>  newNode = new NODE(element);
		if(size == 0) {
			head = tail = newNode;
		}
		else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
		return true;
	}
	
	public int size() {
		return size;
	}
	
	public boolean addFirst(E e) {
		NODE<E>  newNode = new NODE(e);
		newNode.next = head;
		head = newNode;
		size++;
		return true;
	}
	
	public boolean add(int index, E e) {
		
		if(index == 0) {
			return addFirst(e);
		}
		else if(index == size-1) {
			return add(e);
		}
		else {
		NODE<E>  newNode = new NODE(e);
		NODE<E> current = findIndex(index);
		NODE<E> previous = findIndex(index-1);
		previous.next = newNode;
		newNode.next = current;
		size++;
		}

		return true;
	}
	
	public E removeFirst() {
		if(size == 0) {
			return null;
		}
		else {
		NODE<E> temp = head;
		E data = temp.data;
		head = head.next;
		temp = null;
		size--;
		
		if(size == 0) {head = tail = null;}
		return data;
		}
	}
	
	public E removeLast() {
		if(size == 0) {
			return null;
		}
		else if(size == 1) {
			NODE<E> temp = head;
			head = tail = null;
			size--;
			return temp.data;
		}
		else {
		NODE<E> last2 = findIndex(size-2);
		NODE<E> temp = tail;
		E data = temp.data;
		tail = last2;
		last2.next = null;
		size--;
		
		return data;
		}
	}
	
	public E remove(int index) {
		if(index == 0) {
			return removeFirst();
		}
		else if(index == size -1) {
			return removeLast();
		}
		else {
		NODE<E> current = findIndex(index);
		NODE<E> prev = findIndex(index-1);
		NODE<E> next = current.next;
		prev.next = next;
		current.next = null;
		size--;
		
		return current.data;
		}
	}
	
	public E get(int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Check index!");
		}
		E data = findIndex(index).data;
		return data;
	}
	
	public void clear() {
		size = 0;
		head = tail = null;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		
		for(NODE<E> current = head; current != null; current = current.next) {
			sb.append(current.data.toString()+", ");
		}
		sb.append("]");
		int length = sb.length();
		
		return sb.delete(length-3, length-1).toString();
	}
	
	private NODE<E> findIndex(int index){
		NODE<E> currentNode = head;
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Check index!");
		}
		for(int i = 0; i < index; i++) {
			currentNode = currentNode.next;
		}
		return currentNode;
	}
}
