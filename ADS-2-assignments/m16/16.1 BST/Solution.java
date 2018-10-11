public class Solution {
	public static void main(String[] args) {
		Key k = new Key("Algorithms", "Bob Sedgewick", "6000.0");
		Key k1 = new Key("Python","eric","5000");

		BinaryST<Key, Integer> bst = new BinaryST<>();
		bst.put(k, 1);
		bst.put(k1, 2);
	}
}
class BinaryST<Keys extends Comparable<Keys>, Value> {
	Node root;
	int size = 0;
	class Node {
		Keys key;
		Value value;
		Node left;
		Node right;
		Node(Keys key, Value value) {
			this.key = key;
			this.value = value;
		}
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public void put(Keys k, Value v) {
		Node newnode = new Node(k, v);
		if (isEmpty()) {
			newnode.left = null;
			newnode.right = null;
			root = newnode;
			size++;
			System.out.println(root.value);
			return;
		}
		Node parent = getParent(k);
		if(k.compareTo(parent.key) == 0) {
			parent = newnode;
		} else if(k.compareTo(parent.key) < 0) {
			parent.left = newnode;
			newnode.left = null;
			newnode.right = null;
			size++;
			return;
		} else if(k.compareTo(parent.key) > 0) {
			parent.right = newnode;
			newnode.left = null;
			newnode.right = null;
			size++;
			return;
		}

	}

	public Node getParent(Keys k) {
		Node top = root;
		while (top.left != null && top.right != null) {
			if (k.compareTo(top.key) < 0) {
				top = top.left;
			} else if (k.compareTo(top.key) > 0) {
				top = top.right;
			} else {
				return top;
			}
		}
		return top;
	}

}
class Key implements Comparable<Key> {
	String name;
	String author;
	String price;
	Key(String name, String author, String price) {
		this.name = name;
		this.author = author;
		this.price = price;
	}
	public int compareTo(Key other) {
		if (this.name.compareTo(other.name) > 1) return 1;
		if (this.name.compareTo(other.name) < 1) return -1;
		return 0;
	}
	public String toString() {
		return name + " " + author;
	}
}
