public class Solution {
	public static void main(String[] args) {
		Steque<Integer> st = new Steque<>();
		st.push(1);
		st.push(2);
		st.enqueue(0);
		st.enqueue(1);
		st.printList();
		st.pop();
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
	public void enqueue(Item element) {
		Node newnode = new Node(element);
		if (isEmpty()) {
			newnode.previous = null;
			newnode.next = null;
			first = newnode;
			last = first;
			size++;
			return;
		}
		Node oldlast = last;
		last = newnode;
		oldlast.next = last;
		last.previous = oldlast;
		last.next = null;
		size++;
	}
	public Item pop() {
		if(isEmpty()){
			System.out.println("Steque is empty.");
			return null;
		}
		Item data = first.data;
		first = first.next;
		first.previous = null;
		size--;
		return data;
	}
	public void printList() {
		Node tnode =  first;
		while (tnode != null) {
			System.out.print(tnode.data + " ");
			tnode = tnode.next;
		}
	}
}