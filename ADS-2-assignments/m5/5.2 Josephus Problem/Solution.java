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
			q.josephus(people, gap);
			//q.printList();
			

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
			last.next = first;
			size++;
			//printList();
			return;
		}
		last.next = first;
		oldleft.next = last;
		size++;
		//printList();
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
				if(first.data == person) {
					//System.out.println("\n here " +first.data + " " +first.next.data);
					first = first.next;
					int g =0;
					Node l = first;
					while(g < size-2){
						l = l.next;

						g++;
					}
					last = l;
					last.next = first;
					//printList();
					//prev = null;
					//System.out.println("here");
					//prev = first;
					//System.out.println("after");
				} else {
					prev.next = get.next;
				}

				size--;
				break;
			}
			prev = get;
			get = get.next;
			//System.out.println(get.data +  " after");
			s++;
		}
		//printList();
		return d;

	}
	public void josephus(int people,int gap) {
		
		Node head = first;
		while(!isEmpty()) {
			
			int c = 0;
			while (c < gap - 1) {
			head = head.next;
			c++;
			}

			System.out.print(head.data + " ");
			//System.out.println("removing: " + head.data);
			pop(head.data);
			//printList();
			head = head.next;

		}
		System.out.println();
		
	}
	public void printList() {
		Node n = first;
		Node tnode = first.next;
		String s = "";
		s += n.data + " ";
		while (tnode != first) {
			s += tnode.data + " ";
			tnode = tnode.next;
		}
		s.trim();
		System.out.println(s);
	}

}
