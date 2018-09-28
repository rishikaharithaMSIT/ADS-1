import java.util.*;
// public class Deque<Item> implements Iterable<Item>
// 	Deque() 				create an empty deque
// 	boolean isEmpty() 		is the deque empty?
// 	int size() 				number of items in the deque
// 	void pushLeft(Item item) 	add an item to the left end
// 	void pushRight(Item item) 	add an item to the right end
// 	Item popLeft() 			remove an item from the left end
// 	Item popRight() 		remove an item from the right end
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Deque q = new Deque();
		q.pushRight(1);
		q.pushRight(2);
		q.pushRight(3);
		q.pushLeft(-3);
		q.pushLeft(-2);
		q.pushLeft(-1);
		q.popLeft();
		q.popLeft();
		//q.popRight();
		q.printList();

	}
}
class Deque {
	Node first = null;
	Node last = null;
	int size = 0;
	class Node {
		int data;
		Node next;
		Node(int data) {
			this.data = data;
		}
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public void pushRight(int element) {
		Node oldleft = last;
		last = new Node(element);
		if(isEmpty()) {
			first = last;
			last.next = null;
			size++;
			return;
		}
		last.next = null;
		oldleft.next = last;
		size++;
	}
	public void pushLeft(int element) {
		Node oldright = first;
		first = new Node(element);
		if(isEmpty()){
			last = first;
			
			size++;
			return;

		}
		first.next = oldright;
		size++;
	}
	public int popLeft() {
		int d = first.data;
		if(isEmpty()) {
			return -1;
		}
		first= first.next;
		size--;
		return d;

	}
	public int popRight() {
		int d  =  last.data;
		if(isEmpty()) {
			return -1;
		}
		int s = 0;
		Node get = first;
		while(s < size-1) {
			get = get.next;
			s++;
		}
		get.next = null;
		size--;
		return d;

	}
	public void printList() {
		Node tnode = first;
		while (tnode != null) {
			System.out.print(tnode.data + " ");
			tnode = tnode.next;
		}
	}

}
