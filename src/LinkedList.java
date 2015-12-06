/**
 * @author onatbas
 * LinkedList implementation for integer.
 */
public class LinkedList {

	/**
	 * Node of linkedlist, holds value in "i"
	 */
	private class Node {
		/**
		 * Holds value stored in this node.
		 */
		int i;
		
		/**
		 * next attribute is null if this is last node.
		 */
		Node next = null;
	}

	/**
	 * first element of our linked list
	 */
	Node first = null;
	
	/**
	 * last element of our linked list. next attribute in last is guaranteed to be null.
	 */
	Node last = null;

	/**
	 * adds a new value at the end of our linked list
	 * @param i The value you want to add
	 */
	public void push_back(int i) {
		Node node = new Node();
		node.i = i;
		if (first == null)
			first = node;
		else
			last.next = node;

		last = node;
	}
	
	/**
	 * Get size of the linked list
	 * @return size of linked list
	 */
	public int getSize() {
		int size = 0;
		if (first == null)
			return 0;

		Node current = first;
		while (current.next != null) {
			size++;
			current = current.next;
		}
		return size + 1;
	}
	
	/**
	 * Sorts this linkedlist using bubble sort algorithm.
	 */
	public void sort() {
		int size = getSize();
		if (first == null)
			return;

		Node current = null;
		for (int i = 0; i < size; i++) {
			current = first; //Going back and forth "size" times.
			for (int j = 0; j < size - 1; j++) {
				if (current.i > current.next.i) {
					int temp = current.i;
					current.i = current.next.i;
					current.next.i = temp;
				}

				current = current.next;
			}
		}
	}

	/**
	 * Get the value at nth location.
	 * 
	 * @param count location "n"
	 * @return Value in node at nth place.
	 * @throws Exception When size is exceeded, an Exception is thrown.
	 */
	public int getNth(int count) throws Exception {
		Node current = first;
		if (current != null)
			for (int i = 0; i <= count; i++) {
				if (i == count)
					return current.i;

				if (current.next != null)
					current = current.next;
				else
					break;
			}
		throw new Exception("Exceeds the limits");
	}

	/**
	 * Adds values from a standard array.
	 * This methods appends all the values at the end of the list. Doesn't override previous values.
	 * 
	 * @param array Array of integers we want to add.
	 */
	public void appendAll(int[] array) {
		for (int i : array) {
			push_back(i);
		}
	}
}
