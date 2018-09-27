class Stack {
	Node first = null;
	class Node {
		int data;
		Node next;
		Node(int data) {
			this.data = data;
		}
	}

	public void push(int ele) {
		Node newnode = new Node(ele);
		newnode.next = first;
		first = newnode;
	}

	public int pop() {
		int item = first.data;
		first = first.next;
		return item;
	}
	public void printList() {
		Node tnode = first;
		while (tnode != null) {
			System.out.print(tnode.data + " ");
			tnode = tnode.next;
		}
	}
}