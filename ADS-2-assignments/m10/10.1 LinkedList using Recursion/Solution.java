public class Solution{
	public static void main(String[] args) {
		LinkedList<Integer> l = new LinkedList<>();

		l.insertAt(0,2);
		System.out.println(l.size + " size");
		l.printList();
		l.insertAt(0,3);
		System.out.println(l.size + " size");
		l.printList();
		l.insertAt(2,4);
		System.out.println(l.size + " size");
		l.printList();
	}
}
class LinkedList<Gen> {
	Node first = null;
	Node last = null;
	int size = 0;
	class Node{
		Node previous;
		Node next;
		Gen data;
		Node(Gen data){
			this.data = data;
		}
	}
	public boolean isEmpty(){
		return size == 0;
	}
	public void insertAt(int index, Gen element) {
		Node newnode = new Node(element);
		if(isEmpty()) {
			first = newnode;
			last = newnode;
			newnode.previous = null;
			newnode.next = null;
			size++;
			return;
		}
		if(index == 0) {
			Node oldfirst = first;
			first = newnode;
			first.previous = null;
			first.next = oldfirst;
			size++;
			return;
		}
		if(index == size) {
			Node oldlast = last;
			last = newnode;
			last.previous = oldlast;
			last.next = null;
			size++;
			return;
		}

	}
	public void printList() {
		Node tnode = first;
		while(tnode != last) {
			System.out.print(tnode.data + " ");
			tnode = tnode.next;
		}
		System.out.print(tnode.data);
		System.out.println();
	}
}