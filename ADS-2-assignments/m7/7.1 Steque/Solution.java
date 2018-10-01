import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		//Steque<Integer> st = new Steque<>();
		Scanner scan = new Scanner(System.in);
		int testcases = Integer.parseInt(scan.nextLine());
		Steque<Integer> st = new Steque<>();
		while (scan.hasNext()) {
			String line =  scan.nextLine();
			if (line.equals("")) {
				System.out.println("here");
				st = new Steque<Integer>();

			}
			String[] tokens = line.split(" ");
			switch (tokens[0]) {
			case "push":
				st.push(Integer.parseInt(tokens[1]));
				break;
			case "enqueue":
				st.enqueue(Integer.parseInt(tokens[1]));
				break;
			case "pop":
				st.pop();
				break;
			default:
			}
		}
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
		if (isEmpty()) {
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