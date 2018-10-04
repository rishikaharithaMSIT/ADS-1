import java.util.Scanner;
public class Solution{
	public static void main(String[] args) {
		Linkedlist l = new Linkedlist();

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
class Linkedlist {
	Node first = null;
	Node firstCopy;
	Node prev;
	Node temp;
	int size = 0;
	class Node {		
		Node next;
		int data;
		Node(int data) {
			this.data = data;
		}
	}
	void insertAt(int index, int element) throws Exception {
		Node newnode = new Node(element);
		if (index > size || index < 0) {
			throw new Exception("Can't insert at this position.");
			// return;
		}
		if (index == 1) {
			newnode.next = firstCopy.next;
			firstCopy.next = newnode;
			firstCopy = first;
			size++;
			return;
		}
		if (index == 0) {
			newnode.next = firstCopy;
			first = newnode;
			firstCopy =  first;
			size++;
			return;
		}
		firstCopy = firstCopy.next;
		index--;
		insertAt(index, element);
	}
	void reverse() throws Exception {
		//System.out.println(size + "size");
		if (size == 0) {
			throw new Exception("No elements to reverse.");
		}
		if (firstCopy.next == null) {
			first = firstCopy;
			first.next = prev;
			firstCopy = first;
			prev = null;
			return;
		}
		temp = firstCopy;
		firstCopy = firstCopy.next;
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