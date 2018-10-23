public class Solution {
	public static void main(String[] args) {
		Key k1 = new Key("Algorithms", "Bob Sedgewick", "6000.0");
		Key k2 = new Key("Python", "eric", "5000.0");
		Key k3 = new Key("Hello", "Ajay", "8000.0");
		Key k4 = new Key("IT", "Viswas", "400.0");
		BinaryST<Key, String> tree = new BinaryST<>();
		tree.put(k1, "Algorithms");
		System.out.println();
		tree.put(k2, "Python");
		System.out.println();
		tree.put(k3, "Hello");
		System.out.println();
		tree.put(k4, "IT");
		// Key m = tree.max();
		// System.out.println(m.author);
		// System.out.println();
		// Key min = tree.min();
		// System.out.println(min.author);
		// Key k5 = new Key("Qn", "eric", "5000.0");
		// //System.out.println(tree.get(k5));
		// tree.put(k4, "2");
		// Key floor = tree.floor(k5);
		// System.out.println(floor.name);
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
		int count;
		Node(Key data, Value value) {
			this.key = data;
			this.value = value;
		}
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public void put(Key key, Value value) {
		Node newnode = new Node(key, value);
		if (isEmpty()) {
			newnode.left = null;
			newnode.right = null;
			newnode.count = 1;
			top = newnode;
			size++;
			printInorder(top);
			System.out.println("--------");
			return;
		}
		Node start = top;
		while (start.left != null || start.right != null) {
			start.count = count(start.left) + count(start.right) + 1;
			if (key.compareTo(start.key) > 0) {
				start = start.right;
			} else if (key.compareTo(start.key) <= 0) {
				start = start.left;
			}
		}
		if (key.compareTo(start.key) > 0) {
			start.right = newnode;
			size++;
			printInorder(top);
			System.out.println("--------");
		} else if (key.compareTo(start.key) <= 0) {
			start.left = newnode;
			size++;
			printInorder(top);
			System.out.println("--------");
		}

	}
		// if (key.compareTo(start.key) > 0) {
		// 	start.right = newnode;
		// 	start.right.count = count(start.right.left)+count(start.right.right) +1;
		// 	size++;
		// 	//printInorder(top);
		// } else if (key.compareTo(start.key) <= 0) {
		// 	start.left = newnode;
		// 	start.left.count = count(start.left.left) + count(start.left.right) +1;
		// 	size++;

		// }
		//count();
		//printInorder(top);

	
	public void count() {
		Node start = top;
		while (start != null) {
			start.count = count(start) + 1;
			start = start.right;
		}
		start = top.left;
		while (start != null) {
			start.count = count(start) + 1;
			start = start.left;
		}
	}
	public int count(Node node) {
		if (node == null) return 0;
		return node.count;
		// int c = 0;
		// Node start = node;
		// while (start.left != null) {
		// 	if (start.left != null) {
		// 		start = start.left;
		// 		c++;
		// 	}
		// }
		// start = node;
		// while (start.right != null) {
		// 	if (start.right != null) {
		// 		start = start.right;
		// 		c++;
		// 	}
		// }
		// return c;
	}
	//+++++++++++++print+++++++++++++++
	void printInorder(Node node) {
		if (node == null)
			return;

		/* first recur on left child */
		printInorder(node.left);

		/* then print the data of node */
		node.count = count(node);
		System.out.println("- right :"+node.left+" + " + node + " " + node.count +" + "+node.right+ " -");

		/* now recur on right child */
		printInorder(node.right);
	}
	//+++++++++++++print+++++++++++++++
}
class Key implements Comparable<Key> {
	public String name;
	public String author;
	public double price;
	Key(String name, String author, String price) {
		this.name = name;
		this.author = author;
		this.price = Double.parseDouble(price);
	}
	public int compareTo(Key other) {
		if (this.name.compareTo(other.name) > 0) {
			return 1;
		}
		if (this.name.compareTo(other.name) < 0) {
			return -1;
		}
		return 0;
	}
}
