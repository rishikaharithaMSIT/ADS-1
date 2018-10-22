public class Solution {
	public static void main(String[] args) {
		Key k1 = new Key("Algorithms", "Bob Sedgewick", "6000.0");
		Key k2 = new Key("Python","eric","5000");
		Key k3 = new Key("Hello", "Ajay", "200.0");
		BinaryST<Key, String> tree = new BinaryST<>();
		tree.put(k1, "1");
		System.out.println();
		tree.put(k2,"2");
		System.out.println();
		tree.put(k3,"3");
	}
}
class BinaryST<Key extends Comparable<Key>, Value> {
	Node top;
	int size;
	class Node {
		Node left;
		Node right;
		Key key;
		Value value;
		Node(Key data, Value value) {
			this.key = data;
			this.value = value;
		}
	}
	public void put(Key key, Value value) {
		Node newnode = new Node(key, value);
		if (isEmpty()) {
			newnode.left = null;
			newnode.right = null;
			top = newnode;
			size++;
			System.out.println();
			printInorder(top);
			return;
		}
		Node start = top;
		while (start.left != null && start.right != null) {
			if (key.compareTo(start.key) > 0) {
				start = start.right;
			} else if (key.compareTo(start.key) <= 0) {
				start = start.left;
			}
		}
		if (key.compareTo(start.key) > 0) {
			start.right = newnode;
			size++;
			System.out.println();
			printInorder(top);
		} else if (key.compareTo(start.key) <= 0) {
			start.left = newnode;
			size++;
			System.out.println();
			printInorder(top);
		}

	}
	void printInorder(Node node) {
		if (node == null)
			return;

		/* first recur on left child */
		printInorder(node.left);

		/* then print the data of node */
		System.out.print(node.value + " ");

		/* now recur on right child */
		printInorder(node.right);
	}


	public boolean isEmpty() {
		return size == 0;
	}

}
class Key implements Comparable<Key> {
	String name;
	String author;
	double price;
	Key(String name, String author, String price) {
		this.name = name;
		this.author = author;
		this.price = Double.parseDouble(price);
	}
	public int compareTo(Key other) {
		if (this.name.compareTo(other.name) > 0) return 1;
		if (this.name.compareTo(other.name) < 0) return -1;
		return 0;
	}

}