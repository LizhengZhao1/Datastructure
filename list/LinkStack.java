package list;

public class LinkStack<E> {
	
	Node<E> top;
	int size;
	
	public LinkStack() {
		this.size = 0;
		this.top = null;
	}
	
	public  boolean push(E data) {
		Node<E> newNode = new Node(data);
		newNode.next = top;
		top = newNode;
		size++;
		return true;
	}
	
	public E pop() {
		E data = top.element;
		if(size == 0) {
			return null;
		}
		
		Node<E> oldTop = top;
		top = top.next;
		oldTop = null;
		size--;
		return data;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
	public void clear() {
		size = 0;
		top = null;	
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		if(size == 0) {
			return "[]";
		}
		else {
			
			for(Node<E> n = top; n != null; n = n.next) {
				sb.append(n.element.toString() + ", ");
			}
			sb.append("]");
		}
		int length = sb.length();
		
		return sb.delete(length-3, length-1).toString();
	}
 class Node<E>{
		Node<E> next;
		E element;
		
		
		public Node(E e) {
			this.element = e;
			this.next = null;
		}
	}
}


