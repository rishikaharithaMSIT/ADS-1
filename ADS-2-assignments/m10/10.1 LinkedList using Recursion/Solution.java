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
		l.insertAt(1,6);
		System.out.println(l.size + " size");
		l.printList();
	}
}
class LinkedList<Gen> {
	Node first = null;
	Node last = null;
	int size = 0;

	Node oldprev = null;
	Node oldnext = null;
	int start = 0;
	Node tnode = first;

	class Node{
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
		if(index < 0) {
			System.out.println("return");
			return;
		}
		if(isEmpty()) {
			newnode.next = null;
			first = newnode;
			last = newnode;			
			size++;
			return;
		}
		if(index == size) {
			System.out.println("size");
			Node oldlast = last;
			last = newnode;
			oldlast.next = last;
			last.next = null;
			size++;
			return;
		}
		// if(index == 1) {
			
		// 	Node oldprev = tnode;

		// 	Node oldnext = tnode.next;
		// 	oldprev.next = newnode;
		// 	newnode.next = oldnext;
		// 	size++;
		// 	return;
		// }
		if(index == 0) {
			System.out.println("zero");
			Node oldfirst = first;
			first = newnode;
			first.next = oldfirst;
			size++;
			return;
		}
		

		tnode = tnode.next;
		index--;
		insertAt(index, element);
		
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