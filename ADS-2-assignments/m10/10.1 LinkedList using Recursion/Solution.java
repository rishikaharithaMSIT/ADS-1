import java.util.Scanner;
public class Solution{
	public static void main(String[] args) {
		LinkedList<Integer> l = new LinkedList<>();

		Scanner scan = new Scanner(System.in);
		
		while (scan.hasNext()) {
			String line = scan.nextLine();
			String[] tokens = line.split(" ");
			switch (tokens[0]) {
			case "insertAt":
				try {
					l.insertAt(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
					l.printList();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				break;
			case "reverse":
				try {
					l.reverse();
					l.printList();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			default:
			    break;	
			}
		}
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
	Node prev;
	Node temp;
	Node head;
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
	public void insertAt(int index, Gen element) throws Exception {
		Node newnode = new Node(element);
		if (index > size || index < 0) {
			throw new Exception("Can't insert at this position.");
			// return;
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
			//System.out.println("size");
			Node oldlast = last;
			last = newnode;
			oldlast.next = last;
			last.next = null;
			this.tnode = first;
			size++;
			return;
		}
		if(index == 0) {
			
			Node oldfirst = first;
			//System.out.println(oldfirst.data + " zero");
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
	public Node getNode(Node first, int index) {
		if(index == 1) return first;
		index--;
		first = first.next;
		return getNode(first,index);
	}
	void reverse() throws Exception {
		if (size == 0) {
			throw new Exception("No elements to reverse.");
		}
		if (tnode.next == null) {
			first = tnode;
			first.next = prev;
			tnode = head;
			prev = null;
			return;
		}
		temp = tnode;
		tnode = tnode.next;
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