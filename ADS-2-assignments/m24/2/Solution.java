import java.util.Scanner;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int datalen = Integer.parseInt(scan.nextLine());
		RedBlackBST<Student, Integer> student = new RedBlackBST<>();
		Student s = null;
		while (datalen > 0) {
			String[] line = scan.nextLine().split(",");
			s = new Student(line[1], line[2], line[0]);
			student.put(s, Integer.parseInt(line[0]));

			datalen--;
		}
		
		int testcases = Integer.parseInt(scan.nextLine());
		while (testcases > 0) {
			String[] tokens = scan.nextLine().split(" ");
			if (tokens[0].equals("BE")) {
				//int key = Integer.parseInt(tokens[1]);
				double lower = Double.parseDouble(tokens[1]);
				double upper = Double.parseDouble(tokens[2]);
				//System.out.println("here");
				for (Student each : student.keys()) {
					//System.out.println("hi");
					//System.out.println(each);
					if (each.marks >= lower && each.marks <= upper) {
						System.out.println(each.name);
					}
				}
				//System.out.println("----");

			} else if (tokens[0].equals("LE")) {
				double limit = Double.parseDouble(tokens[1]);
				for (Student each : student.keys()) {
					if (each.marks <= limit) {
						System.out.println(each.name);
					}
				}
				//System.out.println("----");
			} else if (tokens[0].equals("GE")) {
				double limit = Double.parseDouble(tokens[1]);
				for (Student each : student.keys()) {
					if (each.marks >= limit) {
						System.out.println(each.name);
					}
				}
				//System.out.println("----");
			}

			testcases--;
		}

	}
}
class Student implements Comparable<Student>{
	String name;
	double marks;
	int roll;
	Student(String n, String m, String r) {
		this.name  = n;
		this.marks = Double.parseDouble(m);
		this.roll = Integer.parseInt(r);
	}
	public int compareTo(Student other) {
		if (this.marks > other.marks) return 1;
		if (this.marks < other.marks) return -1;		
		if (this.roll > other.roll) return 1;
		if (this.roll < other.roll) return -1;

		return 0;
	}
}

class Queue<Item> implements Iterable<Item> {
	private Node<Item> first;    // beginning of queue
	private Node<Item> last;     // end of queue
	private int n;               // number of elements on queue

	// helper linked list class
	private static class Node<Item> {
		private Item item;
		private Node<Item> next;
	}

	/**
	 * Initializes an empty queue.
	 */
	public Queue() {
		first = null;
		last  = null;
		n = 0;
	}

	/**
	 * Returns true if this queue is empty.
	 *
	 * @return {@code true} if this queue is empty; {@code false} otherwise
	 */
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * Returns the number of items in this queue.
	 *
	 * @return the number of items in this queue
	 */
	public int size() {
		return n;
	}

	/**
	 * Returns the item least recently added to this queue.
	 *
	 * @return the item least recently added to this queue
	 * @throws NoSuchElementException if this queue is empty
	 */
	public Item peek() {
		if (isEmpty()) throw new NoSuchElementException("Queue underflow");
		return first.item;
	}

	/**
	 * Adds the item to this queue.
	 *
	 * @param  item the item to add
	 */
	public void enqueue(Item item) {
		Node<Item> oldlast = last;
		last = new Node<Item>();
		last.item = item;
		last.next = null;
		if (isEmpty()) first = last;
		else           oldlast.next = last;
		n++;
	}

	/**
	 * Removes and returns the item on this queue that was least recently added.
	 *
	 * @return the item on this queue that was least recently added
	 * @throws NoSuchElementException if this queue is empty
	 */
	public Item dequeue() {
		if (isEmpty()) throw new NoSuchElementException("Queue underflow");
		Item item = first.item;
		first = first.next;
		n--;
		if (isEmpty()) last = null;   // to avoid loitering
		return item;
	}

	/**
	 * Returns a string representation of this queue.
	 *
	 * @return the sequence of items in FIFO order, separated by spaces
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (Item item : this) {
			s.append(item);
			s.append(' ');
		}
		return s.toString();
	}

	/**
	 * Returns an iterator that iterates over the items in this queue in FIFO order.
	 *
	 * @return an iterator that iterates over the items in this queue in FIFO order
	 */
	public Iterator<Item> iterator()  {
		return new ListIterator<Item>(first);
	}

	// an iterator, doesn't implement remove() since it's optional
	private class ListIterator<Item> implements Iterator<Item> {
		private Node<Item> current;

		public ListIterator(Node<Item> first) {
			current = first;
		}

		public boolean hasNext()  { return current != null;                     }
		public void remove()      { throw new UnsupportedOperationException();  }

		public Item next() {
			if (!hasNext()) throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}
	}



}