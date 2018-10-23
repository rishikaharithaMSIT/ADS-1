public class Solution {
	public static void main(String[] args) {
		Key k1 = new Key("Algorithms", "Bob Sedgewick", "6000.0");
		Key k2 = new Key("Python", "eric", "5000.0");
		Key k3 = new Key("Hello", "Ajay", "8000.0");
		Key k4 = new Key("IT", "Viswas", "400.0");
		BinaryST<Key, String> tree = new BinaryST<>();
		tree.put(k1, "1");
		System.out.println();
		tree.put(k2, "3");
		System.out.println();
		tree.put(k3, "2");
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
		Node newnode = new Node(key,value);
		if(isEmpty()){
			newnode.left = null;
			newnode.right = null;			
			newnode.count = count(newnode);
			top = newnode;
			size++;
			printInorder(top);
			return;
		}
		Node start = top;
		while (start.left != null || start.right != null) {
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
		} else if (key.compareTo(start.key) <= 0) {
			start.left = newnode;
			size++;
			printInorder(top);
		}

	}
	public int count(Node start) {
		return 0;
	}
	//+++++++++++++print+++++++++++++++
	void printInorder(Node node) 
    { 
        if (node == null) 
            return; 
  
        /* first recur on left child */
        printInorder(node.left); 
  
        /* then print the data of node */
        System.out.print(node.key + " "); 
  
        /* now recur on right child */
        printInorder(node.right); 
    } 
	//+++++++++++++print+++++++++++++++
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
		if (this.name.compareTo(other.name) > 0) {
			return 1;
		}
		if (this.name.compareTo(other.name) < 0) {
			return -1;
		}
		return 0;
	}
}
