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
			//System.out.println(root.value);
			return;
		}
		Node parent = getParent(k);
		// System.out.println("++++");
		// System.out.println(k + " - k");
		// System.out.println(parent.key + " - parent");
		// System.out.println("+++");
		if (k.compareTo(parent.key) == 0) {
			//System.out.println("same");
			//System.out.println(parent.value + " " + newnode.value);
			parent.value = newnode.value;
		} else if (k.compareTo(parent.key) < 0) {
			//System.out.println("less");			
			newnode.left = null;
			newnode.right = null;
			parent.left = newnode;
			size++;
			return;
		} else if (k.compareTo(parent.key) > 0) {
			//System.out.println("great");				
			newnode.left = null;
			newnode.right = null;
			parent.right = newnode;
			size++;
			return;
		}

	}

	public Node getParent(Keys k) {
		Node top = root;
		while (!(top.left == null && top.right == null)) {
			if (k.compareTo(top.key) < 0) {
				//System.out.println("left - " + k + " - " + top.key);
				if(top.left == null) break;
				top = top.left;
			} else if (k.compareTo(top.key) > 0) {
				//System.out.println("right - " + k + " - " + top.key);
				if(top.right == null) break;
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
		while (!(top.left == null && top.right == null)) {
			if (k.compareTo(top.key) < 0) {
				//System.out.println("left - " + k + " - " + top.key);
				if(top.left == null) return null;
				top = top.left;
			} else if (k.compareTo(top.key) > 0) {
				//System.out.println("right - " + k + " - " + top.key);
				if(top.right == null) return null;
				top = top.right;
			} else {
				//System.out.println("equal - " + k + " - " + top.key);
				return top.value;
			}
		}
		return top.value;

	}
}
