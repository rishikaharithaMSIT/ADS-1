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
		q.printList();

	}
}
class Deque {
	Node right = null;
	Node left = null;
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
		Node oldleft = left;
		left = new Node(element);
		if(isEmpty()) {
			right = left;
			left.next = null;
			size++;
			return;
		}
		left.next = null;
		oldleft.next = left;
		size++;
	}
	public void pushLeft(int element) {
		Node oldright = right;
		right = new Node(element);
		if(isEmpty()){
			left = right;
			
			size++;
			return;

		}
		right.next = oldright;
		size++;
	}

	public void printList() {
		Node tnode = right;
		while (tnode != null) {
			System.out.print(tnode.data + " ");
			tnode = tnode.next;
		}
	}

}
