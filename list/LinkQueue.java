package list;

import list.LinkStack.Node;

public class LinkQueue<E> {
	NODE<E> front;
	NODE<E> rear;
	int size;
	
	public LinkQueue() {
		front = null;
		rear = null;
		size = 0;
	}
	
	public boolean enQueue(E element) {
		NODE<E> newNode= new NODE(element);
		if(size == 0 ) {
			front = rear = newNode;
			
		}
		else {
			rear.next = newNode;
			rear = newNode;
			
		}
		size++;
		return true;
	}
	
	public E deQueue() {
		E data = front.data;
		if(size == 0) {
			return null;
		}
		NODE<E> oldFront = front;
		front = front.next;
		oldFront = null;
		size--;
		
		if(size == 0) {
			rear = front;
		}
		return data;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void clear() {
		front = rear = null;
		size = 0;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		if(isEmpty()) {
			return "[]";
		}
		else {
			for(NODE<E> n = front; n != null; n = n.next) {
				sb.append(n.data.toString()+", ");
			}
			
			sb.append("]");
			int length = sb.length();
			
			return sb.delete(length-3, length-1).toString();
		}
	}
}
class NODE<E> {
	NODE<E> next;
	E data;
	
	public NODE(E e) {
		this.data = null;
		this.data = e;
	}
}
