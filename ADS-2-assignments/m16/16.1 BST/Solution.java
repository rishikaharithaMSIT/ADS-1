public class Solution {
	public static void main(String[] args) {
		Key k1 = new Key("Harry","JK","600.0,1");
		Key k2 = new Key("IT","Viswas","400.0");
		Key k3 = new Key("Street","Kiran","800.0");
		Key k4 = new Key("Hello","Ajay","200.0");

		BinaryST<Key, Integer> bst = new BinaryST<>();
		bst.put(k1, 1);
		bst.put(k2, 2);
		bst.put(k3, 6);
		Key g1 = new Key("Hello","Ajay","200.0");
		bst.get(g1);
		bst.put(k4,5);
		bst.put(k4,7);
		bst.get(g1);

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
		System.out.println("++++");
		System.out.println(k + " - k");
		System.out.println(parent + " - parent");
		System.out.println("+++");
		if (k.compareTo(parent.key) == 0) {
			System.out.println("same");
			parent = newnode;
		} else if (k.compareTo(parent.key) < 0) {
			System.out.println("less");			
			newnode.left = null;
			newnode.right = null;
			parent.left = newnode;
			size++;
			return;
		} else if (k.compareTo(parent.key) > 0) {
			System.out.println("great");				
			newnode.left = null;
			newnode.right = null;
			parent.right = newnode;
			size++;
			return;
		}

	}

	public Node getParent(Keys k) {
		Node top = root;
		while (!(top.left == null || top.right == null)) {
			if (k.compareTo(top.key) < 0) {
				//System.out.println("left - " + k + " - " + top.key);
				top = top.left;
			} else if (k.compareTo(top.key) > 0) {
				//System.out.println("right - " + k + " - " + top.key);
				top = top.right;
			} else {
				//System.out.println("equal - " + k + " - " + top.key);
				return top;
			}
		}
		return top;
	}
	// public void get(String name, String author, String price) {

	// }
	public Value get(Keys k) {
		Node top = root;
		// System.out.println("---");
		// System.out.println(top.key);
		// System.out.println(top.left);
		// System.out.println(top.right.key);
		// System.out.println(top.right.right);
		// System.out.println("--");
		while (top.left != null && top.right != null) {
			if (k.compareTo(top.key) > 0) {
				top = top.left;
			} else if (k.compareTo(top.key) < 0) {
				top = top.right;
			} else {
				System.out.println(top.value);
				return top.value;
			}
		}
		return null;

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
		// if (this.name.compareTo(other.name) > 1) return 1;
		// if (this.name.compareTo(other.name) < 1) return -1;
		// return 0;
		return this.name.compareTo(other.name);
	}
	public String toString() {
		return name;
	}
}
