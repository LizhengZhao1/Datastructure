package list;

import java.util.AbstractList;

import list.node;

public class DoubleLinkedList<E> extends AbstractList<E>{
	node<E> head;
	node<E> tail;
	int size;
	
	public DoubleLinkedList(){
		size = 0;
		head = new node<E>(null);
		tail = new node<E>(null); 
		head.next = tail;
		tail.prev = head;
	}
	
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException("Element cannot be null!");
		}
		
		node<E> currentNode = new node(element);
		currentNode.prev = tail.prev;
		currentNode.next = tail;
		tail.prev.next = currentNode;
		tail.prev = currentNode;
		size ++;
		return true;
		
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Check index!");
		
		E data = getNode(index).element;
		return data;
	}
	
	private node<E> getNode (int index){
		node<E> currentNode = head.next;
		for(int i = 0; i < index; i ++) {
			currentNode = currentNode.next;
		}
		return  currentNode;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("Check index!");

		if (element == null)
			throw new NullPointerException("Element cannot be null!");
		node<E> currentNode = new node(element);
		node<E> nextNode = getNode(index);
		currentNode.prev = nextNode.prev;
		nextNode.prev.next = currentNode;
		currentNode.next = nextNode;
		nextNode.prev = currentNode;
		size++;
		
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Check index!");
		
		node<E> targetNode = getNode(index);
		node<E> prevNode = targetNode.prev;
		node<E> nextNode = targetNode.next;
		targetNode.prev = null;
		targetNode.next = null;
		prevNode.next = nextNode;
		nextNode.prev = prevNode;
		size--;
		return targetNode.element;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Check index!");
		if (element == null)
			throw new NullPointerException("Element cannot be null!");
		node<E> targetNode = getNode(index);
		E data = targetNode.element;
		targetNode.element = element;
		return data;
	}
	
	
}


class node<E>{
	E element;
	node<E> prev;
	node<E> next;
	
	public node(E e) {
		this.element = e;
		this.prev = null;
		this.next = null;
	}
}
