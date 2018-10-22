import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		// Key k1 = new Key("Algorithms", "Bob Sedgewick", "6000.0");
		// Key k2 = new Key("Python", "eric", "5000.0");
		// Key k3 = new Key("Hello", "Ajay", "8000.0");
		// Key k4 = new Key("IT", "Viswas", "400.0");
		// BinaryST<Key, String> tree = new BinaryST<>();
		// tree.put(k1, "1");
		// System.out.println();
		// tree.put(k2, "3");
		// System.out.println();
		// tree.put(k3, "2");
		// Key m = tree.max();
		// System.out.println(m.author);
		// System.out.println();
		// Key min = tree.min();
		// System.out.println(min.author);
		// Key k5 = new Key("Algorithms", "eric", "5000.0");
		// //System.out.println(tree.get(k5));
		// tree.put(k4, "2");
		// Key floor = tree.floor(k5);
		// System.out.println(floor.name);
		Scanner scan = new Scanner(System.in);
		BinaryST<Key, String> tree = new BinaryST<>();
		while(scan.hasNext()) {
			String[] tokens = scan.nextLine().split(",");
			switch(tokens[0]) {
				case "put":
					Key k1 = new Key(tokens[1],tokens[2],tokens[3]);
					tree.put(k1,tokens[4]);
					break;
				case "get":
					Key getKey = new Key(tokens[1],tokens[2],tokens[3]);
					System.out.println(tree.get(getKey));
					break;
				case "max":
					Key max = tree.max();
					System.out.println(max.name +", "+max.author+", "+max.price);
					break;
				case "min":
					Key min = tree.min();
					System.out.println(min.name +", "+min.author+", "+min.price);
					break;
				case "floor":
					Key floorKey = new Key(tokens[1],tokens[2],tokens[3]);
					Key floor = tree.floor(floorKey);
					System.out.println(floor.name +", "+floor.author+", "+floor.price);
					break;
				case "ceiling":
					Key ceilKey = new Key(tokens[1],tokens[2],tokens[3]);
					Key ceil = tree.floor(ceilKey);
					if(ceil != null) {
						System.out.println(ceil.name +", "+ceil.author+", "+ceil.price);
					}					
					break;
				case "select":
					int kth = Integer.parseInt(tokens[1]);
					Key sel = tree.select(kth);
					System.out.println(sel.name +", "+sel.author+", "+sel.price);
					break;
				default:
			}
		}
	}
}
class BinaryST<Key extends Comparable<Key>, Value> {
	private Node head;
	/**
	 * { size value }.
	 */
	private int size;
	/**
	 * Class for node.
	 */
	class Node {
		/**
		 * { key }.
		 */
		Key key;
		/**
		 * { value }.
		 */
		Value value;
		/**
		 * { left }.
		 */
		Node left;
		/**
		 * { right }.
		 */
		Node right;
		/**
		 * Constructs the object.
		 *
		 * @param      keyval  The keyval
		 * @param      val     The value
		 */
		Node(Key keyval, Value val) {
			this.key = keyval;
			this.value = val;
		}
	}
	/**
	 * Determines if empty.
	 *
	 * @return     True if empty, False otherwise.
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	/**
	 * { get function }.
	 * Complexities:
	 *              Best case: O(logN)
	 *              Worst case: O(N)
	 *              Average case: O(logN)
	 * @param      item  The item
	 *
	 * @return     { Value }
	 */
	public Value get(Key item) {
		if (isEmpty()) {
			return null;
		}
		Node test = head;
		while (test != null) {
			if (item.compareTo(test.key) == 0) {
				return test.value;
			} else if (item.compareTo(test.key) > 0) {
				if (test.right == null) {
					return null;
				}
				test = test.right;
			} else {
				if (test.left == null) {
					return null;
				}
				test = test.left;
			}
		}
		return null;
	}
	/**
	 * { put function }.
	 * Complexities:
	 *              Best case: O(logN)
	 *              Worst case: O(N)
	 *              Average case: O(logN)
	 * @param      item     The item
	 * @param      itemval  The itemval
	 */
	public void put(Key item, Value itemval) {
		Node newnode = new Node(item, itemval);
		if (isEmpty()) {
			head = newnode;
			size++;
			return;
		}
		Node test = head;
		while (!(test.left == null && test.right == null)) {
			if (item.compareTo(test.key) > 0) {
				if (test.right == null) {
					break;
				}
				test = test.right;
			} else if (item.compareTo(test.key) < 0) {
				if (test.left == null) {
					break;
				}
				test = test.left;
			} else {
				test.value = newnode.value;
				return;
			}
		}
		if (item.compareTo(test.key) > 0) {
			test.right = newnode;
			size++;
		} else if (item.compareTo(test.key) < 0) {
			test.left = newnode;
			size++;
		} else {
			test.value = newnode.value;
		}
	}
	/**
	 * { min function }.
	 * Complexities:
	 *              Best case: O(1)
	 *              Worst case: O(N)
	 *              Average case: O(logN)
	 *
	 * @return     { Key }
	 */
	public Key min() {
		Node test = head;
		while (test.left != null) {
			test = test.left;
		}
		return test.key;
	}
	/**
	 * { max function }.
	 * Complexities:
	 *              Best case: O(1)
	 *              Worst case: O(N)
	 *              Average case: O(logN)
	 * @return     { Key }
	 */
	public Key max() {
		Node test = head;
		while (test.right != null) {
			test = test.right;
		}
		return test.key;
	}
	/**
	 * { floor }.
	 *Complexities:
	 *              Best case: O(logN)
	 *              Worst case: O(logN)
	 *              Average case: O(logN)
	 * @param      item  The item
	 *
	 * @return     { Key }
	 */
	public Key floor(Key item) {
		Node test = head;
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
	/**
	 * { ceiling function }.
	 * Complexities:
	 *              Best case: O(logN)
	 *              Worst case: O(logN)
	 *              Average case: O(logN)
	 * @param      item  The item
	 *
	 * @return     { Key }
	 */
	public Key ceiling(Key item) {
		Node test = head;
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
	/**
	 * { select function }.
	 * Complexities:
	 *              Best case: O(logN)
	 *              Worst case: O(logN)
	 *              Average case: O(logN)
	 * @param      val   The value
	 *
	 * @return     { Key value }
	 */
	public Key select(int val) {
		int count = 0;
		int index = 0;
		Key[] keyarr = (Key[])new Comparable[100];
		Node test = head;
		Node temp = null;
		while (count != val + 1) {
			if (test.left == null) {
				++count;
				if (count == val + 1) {
					return test.key;
				}
				if (index != 0) {
					int req = val + 1 - count;
					if (req <= index) {
						return keyarr[index - req];
					}
					index = 0;
					test =  temp.right;
				} else {
					if (test.right == null) {
						break;
					}
					test = test.right;
				}
			} else {
				if (index == 0) {
					temp = test;
				}
				keyarr[index++] = test.key;
				test = test.left;
			}
		}
		return test.key;
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