/**
 * Class for steque.
 *
 * @param      <Item>  Generic Type Item.
 */
class Steque<Item> {
	Node first = null;
	Node last = null;
	int size = 0;
	/**
	 * Inner Class for node.
	 */
	class Node {
		Node previous;
		Node next;
		Item data;
		/**
		 * Constructor for Node class.
		 *
		 * @param      data  The data
		 */
		Node(Item data) {
			this.data = data;
		}
	}
	/**
	 * Private method to Determine if List is empty.
	 * Time Complexity : 1 (checks if size is 0)
	 *
	 * @return     True if empty, False otherwise.
	 */
	private Boolean isEmpty() {
		return size == 0;
	}
	/**
	 * push element into stack.
	 * Time Complexity : 1 
	 *
	 * @param      element  The element to be pushed into stack
	 */
	public void push(Item element) {
		Node newnode = new Node(element);
		if (isEmpty()) {
			newnode.previous = first;
			newnode.next = first;
			first = newnode;
			last = first;
			size++;
			return;
		}
		Node oldfirst = first;
		first = newnode;
		oldfirst.previous = first;
		first.next = oldfirst;
		// first.previous = null;
		size++;
	}
	/**
	 * Add element to queue.
	 * Time complexity : 1
	 *
	 * @param      element  The element
	 */
	public void enqueue(Item element) {
		Node newnode = new Node(element);
		if (isEmpty()) {
			newnode.previous = last;
			newnode.next = last;
			last = newnode;
			first = last;
			size++;
			return;
		}
		Node oldlast = last;
		last = newnode;
		oldlast.next = last;
		last.previous = oldlast;
		// last.next = null;
		size++;
	}
	/**
	 * pops elements from steque.
	 * Time Complexity :  1.
	 *
	 * @return     returns the item popped from steque.
	 */
	public Item pop() {
		if (isEmpty()) {
			return null;
		}

		Item data = first.data;
		first = first.next;
		size--;
		return data;
	}
	/**
	 * Prints the elements in the Steque.
	 * Time Complexity : N (loop to access elements)
	 */
	public void printList() {
		if (isEmpty()) {
			System.out.println("Steque is empty.");
			return;
		}
		Node tnode =  first;
		while (tnode != last) {
			System.out.print(tnode.data + ", ");
			tnode = tnode.next;
		}
		System.out.print(tnode.data);
		System.out.println();
	}
}