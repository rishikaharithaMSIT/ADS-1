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
		l.insertAt(1,7);
		l.printList();
		l.insertAt(2,9);
		l.printList();
		l.insertAt(4,11);
		l.printList();
	}
}
class LinkedList<Gen> {
	Node first = null;
	Node last = null;
	int size = 0;

	Node old = null;
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
			this.tnode = first;			
			size++;
			return;
		}
		if(index == size) {
			System.out.println("size");
			Node oldlast = last;
			last = newnode;
			oldlast.next = last;
			last.next = null;
			this.tnode = first;
			size++;
			return;
		}
		// if(index == 1) {
		// 	Node oldprev = old;
		// 	System.out.println(old.data + " in old");
		// 	System.out.println(tnode.data + " in oldprev");
		// 	//Node oldnext = tnode.next;
		// 	//System.out.println(oldnext.data + " in oldnext");
		// 	//oldprev.next = newnode;
		// 	//newnode.next = oldnext;
			
		// 	size++;
		// 	return;
		// }
		if(index == 0) {
			
			Node oldfirst = first;
			System.out.println(oldfirst.data + " zero");
			first = newnode;
			first.next = oldfirst;
			this.tnode = first;
			this.old = tnode;
			size++;
			return;
		}
		Node inNode = getNode(first, index);
		Node n = inNode.next;
		inNode.next=newnode;
		newnode.next = n;
		return;

		
	}
	public Node getNode(Node first, int index){
		if(index == 1) return first;
		index--;
		first = first.next;
		return getNode(first,index);
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