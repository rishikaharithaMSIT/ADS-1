import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String testcases = scan.nextLine();
		while (scan.hasNext()) {
			String[] line = scan.nextLine().split(" ");
			int people = Integer.parseInt(line[0]);
			int gap = Integer.parseInt(line[1]);
			Deque<Integer> q = new Deque<>();
			createCircle(q, people);
			q.printList();
			q.pop(0);

		}
	}
	public static void createCircle(Deque<Integer> q, int people) {
		for(int i = 0;i < people;i++) {
			q.push(i);
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
	public int getSize() {
		return size;
	}
	public void push(Item element) {
		Node oldleft = last;
		last = new Node(element);
		if (isEmpty()) {
			first = last;
			last.next = null;
			size++;
			printList();
			return;
		}
		last.next = null;
		oldleft.next = last;
		size++;
		printList();
	}
	
	public Item pop(Item person) {
		Item d = first.data;
		if (isEmpty()) {
			return null;
		}
		int s =0;
		Node get = first;
		Node prev = null;
		while(s < size){
			if(get.data == person) {
				System.out.println(get.data);
				break;

			}

			get = get.next;
			s++;
		}
		
		return d;

	}
	public void printList() {
		Node tnode = first;
		while (tnode != null) {
			System.out.print(tnode.data + " ");
			tnode = tnode.next;
		}
		System.out.println();
	}

}
