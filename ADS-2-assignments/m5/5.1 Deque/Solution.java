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
		Deque<Integer> q = new Deque<>();
		while(scan.hasNext()) {
			String[] line = scan.nextLine().split(" ");
			switch(line[0]) {
				case "pushLeft":
					q.pushLeft(Integer.parseInt(line[1]));
					q.printList();
					break;
				case "pushRight":
					q.pushRight(Integer.parseInt(line[1]));
					q.printList();
					break;
				case "popRight":
					q.popRight();
					q.printList();
					break;
				case "popLeft":
					q.popLeft();
					q.printList();
					break;
				case "size":
					System.out.println(q.getSize());
					break;
				default :
			}
		}

	}
}
class Deque<Item> {
	Node first = null;
	Node last = null;
	int size = 0;
	class Node {
		Item data;
		Node next;
		Node(Item data) {
			this.data = data;
		}
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public int getSize(){
		return size;
	}
	public void pushRight(Item element) {
		Node oldleft = last;
		last = new Node(element);
		if (isEmpty()) {
			first = last;
			last.next = null;
			size++;
			return;
		}
		last.next = null;
		oldleft.next = last;
		size++;
	}
	public void pushLeft(Item element) {
		Node oldright = first;
		first = new Node(element);
		if (isEmpty()) {
			last = first;

			size++;
			return;

		}
		first.next = oldright;
		size++;
	}
	public Item popLeft() {
		Item d = first.data;
		if (isEmpty()) {
			return null;
		}
		first = first.next;
		size--;
		return d;

	}
	public Item popRight() {
		Item d  =  last.data;
		if (isEmpty()) {
			return null;
		}
		int s = 0;
		Node get = first;

		while (s < size - 2) {
			//System.out.println("herre" + size);
			get = get.next;
			//System.out.println(get.data);

			s++;
		}
		last = get;
		get.next = null;
		size--;
		return d;

	}
	public void printList() {
		Node tnode = first;
		String s = "";
		while (tnode != null) {
			s += tnode.data + "";
			tnode = tnode.next;
		}
		String[] str = s.split("");
		System.out.println(Arrays.toString(str));
	}

}
