/**
 * List of linkeds.
 */
class LinkedList {
	Node first = null;
	Node firstCopy;
	Node prev;
	Node temp;
	int size = 0;
	/**
	 * Class for node.
	 */
	class Node {		
		Node next;
		int data;
		Node(int data) {
			this.data = data;
		}
	}
	/**
	 * to insert at given index.
	 * Time Complexity :
	 * Best : O(1)
	 * Worst : O(N)
	 * Average : O(N)
	 *
	 * @param      index      The index
	 * @param      element    The element
	 *
	 * @throws     Exception  { exception_description }
	 */
	void insertAt(int index, int element) throws Exception {
		Node newnode = new Node(element);
		if (index > size || index < 0) {
			throw new Exception("Can't insert at this position.");
		}
		if (index == 1) {
			newnode.next = firstCopy.next;
			firstCopy.next = newnode;
			firstCopy = first;
			size++;
			return;
		}
		if (index == 0) {
			newnode.next = firstCopy;
			first = newnode;
			firstCopy =  first;
			size++;
			return;
		}
		firstCopy = firstCopy.next;
		index--;
		insertAt(index, element);
	}
	/**
	 * to reverse Linked list.
	 *Time Complexity :
	 * Best : O(1)
	 * Worst : O(N)
	 * Average : O(N) 
	 *
	 * @throws     Exception  { exception_description }
	 */
	void reverse() throws Exception {
		//System.out.println(size + "size");
		if (size == 0) {
			throw new Exception("No elements to reverse.");
		}
		if (firstCopy.next == null) {
			first = firstCopy;
			first.next = prev;
			firstCopy = first;
			prev = null;
			return;
		}
		temp = firstCopy;
		firstCopy = firstCopy.next;
		temp.next = prev;
		prev = temp;
		reverse();
	}

	public void printList() {
		String str = "";
		Node tnode = first;
		while (tnode.next != null) {
			str = str + tnode.data + ", ";
			tnode = tnode.next;
		}
		str = str + tnode.data;
		System.out.println(str);
	}

}