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
		Key m = tree.max();
		System.out.println(m.author);
		System.out.println();
		Key min = tree.min();
		System.out.println(min.author);
		Key k5 = new Key("Algorithms", "eric", "5000.0");
		//System.out.println(tree.get(k5));
		tree.put(k4, "2");
		Key floor = tree.floor(k5);
		System.out.println(floor.name);
	}
}
class BinaryST<Key extends Comparable<Key>, Value> {
	Node top;
	int size;
	Key kthLarge;
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
			printLevelOrder();
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
			printLevelOrder();
		} else if (key.compareTo(start.key) <= 0) {
			start.left = newnode;
			size++;
			printLevelOrder();
		}

	}
	public Value get(Key key) {
		// if (isEmpty()) {

		// }
		Node start = top;
		while (start.left != null || start.right != null) {
			if (key.compareTo(start.key) > 0) {
				start = start.right;
			} else if (key.compareTo(start.key) < 0) {
				start = start.left;
			} else {
				break;
			}
		}
		return start.value;

	}
	//========================================to check op ==================
	void printLevelOrder() {
		int h = height(top);
		int i;
		for (i = 1; i <= h; i++)
			printGivenLevel(top, i);
	}

	/* Compute the "height" of a tree -- the number of
	nodes along the longest path from the root node
	down to the farthest leaf node.*/
	int height(Node root) {
		if (root == null)
			return 0;
		else {
			/* compute  height of each subtree */
			int lheight = height(root.left);
			int rheight = height(root.right);

			/* use the larger one */
			if (lheight > rheight)
				return (lheight + 1);
			else return (rheight + 1);
		}
	}
	void printGivenLevel (Node root , int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.value + " ");
		else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}
	//========================================to check op ==================
	public Key max() {
		Node start = top;
		while (start.right != null) {
			start = start.right;
		}
		return start.key;
	}
	public Key min() {
		Node start = top;
		while (start.left != null) {
			start = start.left;
		}
		return start.key;

	}
	public Key floor(Key item) {
		Node test = top;
		while (true) {
			if (item.compareTo(test.key) > 0) {
				if (test.right == null) {
					break;
				}
				test = test.right;
			} else if (item.compareTo(test.key) < 0) {
				if (test.left == null) {
					return null;
				}
				test = test.left;
			} else {
				return item;
			}
		}
		return test.key;
	}
	public Key ceiling(Key item) {
		Node test = top;
		while (true) {
			if (item.compareTo(test.key) > 0) {
				if (test.right == null) {
					return null;
				}
				test = test.right;
			} else if (item.compareTo(test.key) < 0) {
				if (test.left == null) {
					break;
				}
				test = test.left;
			} else {
				return item;
			}
		}
		return test.key;
	}
	public class count { 
        int c = 0; 
    } 
  
    // utility function to find kth largest no in  
    // a given tree 
    void kthLargestUtil(Node node, int k, count C) 
    { 
        // Base cases, the second condition is important to 
        // avoid unnecessary recursive calls 
        if (node == null || C.c >= k) 
            return; 
          
        // Follow reverse inorder traversal so that the 
        // largest element is visited first 
        this.kthLargestUtil(node.right, k, C);  
          
        // Increment count of visited nodes 
        C.c++; 
          
        // If c becomes k now, then this is the k'th largest  
        if (C.c == k) { 
            kthLarge = node.key; 
            return; 
        } 
          
        // Recur for left subtree 
        this.kthLargestUtil(node.left, k, C);  
    } 
  
    // Method to find the kth largest no in given BST 
    Key select(int k) 
    { 
        count c = new count(); // object of class count 
        this.kthLargestUtil(this.top, k, c);
        return kthLarge; 
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