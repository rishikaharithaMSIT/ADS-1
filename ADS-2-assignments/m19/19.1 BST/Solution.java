public class Solution {
	public static void main(String[] args) {
		Key k1 = new Key("Algorithms", "Bob Sedgewick", "6000.0");
		Key k2 = new Key("Python","eric","5000");
		Key k3 = new Key("Hello", "Ajay", "8000.0");
		BinaryST<Key, String> tree = new BinaryST<>();
		tree.put(k1, "1");
		System.out.println();
		tree.put(k2,"3");
		System.out.println();
		tree.put(k3,"2");
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
	//========================================to check op ==================
	void printLevelOrder() 
    { 
        int h = height(top); 
        int i; 
        for (i=1; i<=h; i++) 
            printGivenLevel(top, i); 
    } 
  
    /* Compute the "height" of a tree -- the number of 
    nodes along the longest path from the root node 
    down to the farthest leaf node.*/
    int height(Node root) 
    { 
        if (root == null) 
           return 0; 
        else
        { 
            /* compute  height of each subtree */
            int lheight = height(root.left); 
            int rheight = height(root.right); 
              
            /* use the larger one */
            if (lheight > rheight) 
                return(lheight+1); 
            else return(rheight+1);  
        } 
    } 
    void printGivenLevel (Node root ,int level) 
    { 
        if (root == null) 
            return; 
        if (level == 1) 
            System.out.print(root.value + " "); 
        else if (level > 1) 
        { 
            printGivenLevel(root.left, level-1); 
            printGivenLevel(root.right, level-1); 
        } 
    } 
    //========================================to check op ==================
    public Key max() {
    	Node start = top;
    	while(start.right != null) {
    		start = start.right;
    	}
    	return start.key;
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