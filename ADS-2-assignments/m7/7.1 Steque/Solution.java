public class Solution {
	public static void main(String[] args) {
		Steque<Integer> st = new Steque<>();
		st.push(1);
		st.push(2);
		st.printList();
	}
}

class Steque<Item> {
	Node first = null;
	Node last = null;
	int size = 0;
	class Node {
		Node previous;
		Node next;
		Item data;
		Node(Item data) {
			this.data = data;
		}
	}
	public Boolean isEmpty() {
		return size == 0;
	}
	public void push(Item element) {
		Node newnode = new Node(element);
		if (isEmpty()) {
			newnode.previous = null;
			newnode.next = null;
			first = newnode;
			last = first;
			size++;
			return;
		}
		Node oldfirst = first;
		first = newnode;
		oldfirst.previous = first;
		first.next = oldfirst;
		first.previous = null;
		size++;
	}
	public void printList() {
		Node tnode =  first;
		while (tnode != null) {
			System.out.print(tnode.data + " ");
			tnode = tnode.next;
		}
	}
}