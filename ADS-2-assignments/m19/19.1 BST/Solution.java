import java.util.Scanner;
/**
 * Class for key.
 */
class Key implements Comparable<Key> {
	/**
	 * { bookname }.
	 */
	private String bookname;
	/**
	 * { bookauthor }.
	 */
	private String bookauthor;
	/**
	 * { bookprice }.
	 */
	private float bookprice;
	/**
	 * Constructs the object.
	 *
	 * @param      name    The name
	 * @param      author  The author
	 * @param      price   The price
	 */
	Key(String name, String author, float price) {
		this.bookname = name;
		this.bookauthor = author;
		this.bookprice = price;
	}
	/**
	 * { getname function }.
	 * Complexities:
	 *              Best case: O(1)
	 *              Worst case: O(1)
	 *              Average case: O(1)
	 * @return     { String type }
	 */
	public String getname() {
		return this.bookname;
	}
	/**
	 * { getauthor function }.
	 * Complexities:
	 *              Best case: O(1)
	 *              Worst case: O(1)
	 *              Average case: O(1)
	 * @return     { String type }
	 */
	public String getauthor() {
		return this.bookauthor;
	}
	/**
	 * { getprice function }.
	 * Complexities:
	 *              Best case: O(1)
	 *              Worst case: O(1)
	 *              Average case: O(1)
	 *
	 * @return     { float type }
	 */
	public float getprice() {
		return this.bookprice;
	}
	/**
	 * { CompareTo function }.
	 * Complexities:
	 *              Best case: O(1)
	 *              Worst case: O(1)
	 *              Average case: O(1)
	 * @param      other  The other
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int compareTo(Key other) {
		if (this.getname().compareTo(other.getname()) > 0) {
			return 1;
		}
		if (this.getname().compareTo(other.getname()) < 0) {
			return -1;
		}
		return 0;
	}
	/**
	 * Returns a string representation of the object.
	 *Complexities:
	 *              Best case: O(1)
	 *              Worst case: O(1)
	 *              Average case: O(1)
	 * @return     String representation of the object.
	 */
	public String toString() {
		String str = "";
		str = str + this.bookname + ", " + this.bookauthor + ", " + this.bookprice;
		return str;
	}
}

class BinarySearchTree<Key extends Comparable<Key>, Value> {
	private Node head;
	private int size;
	class Node {		
		Key key;
		
		Value value;
		
		Node left;
		
		Node right;

		Node(Key keyval, Value val) {
			this.key = keyval;
			this.value = val;
		}
	}
	public boolean isEmpty() {
		return size == 0;
	}
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
	public Key min() {
		Node test = head;
		while (test.left != null) {
			test = test.left;
		}
		return test.key;
	}
	public Key max() {
		Node test = head;
		while (test.right != null) {
			test = test.right;
		}
		return test.key;
	}
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
/**
 * Class for solution.
 */
class Solution {
	/**
	 * Constructs the object.
	 */
	Solution() {
		//unused
	}
	/**
	 * { Main function }.
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BinarySearchTree<Key, Integer> bstobj = new BinarySearchTree<>();
		while (scan.hasNext()) {
			String[] tokens = scan.nextLine().split(",");
			switch (tokens[0]) {
			case "put":
				Key newkey = new Key(tokens[1], tokens[2], Float.parseFloat(tokens[3]));
				bstobj.put(newkey, Integer.parseInt(tokens[4]));
				break;
			case "get":
				newkey = new Key(tokens[1], tokens[2], Float.parseFloat(tokens[3]));
				System.out.println(bstobj.get(newkey));
				break;
			case "min":
				System.out.println(bstobj.min());
				break;
			case "max":
				System.out.println(bstobj.max());
				break;
			case "floor":
				newkey = new Key(tokens[1], tokens[2], Float.parseFloat(tokens[3]));
				System.out.println(bstobj.floor(newkey));
				break;
			case "ceiling":
				newkey = new Key(tokens[1], tokens[2], Float.parseFloat(tokens[3]));
				System.out.println(bstobj.ceiling(newkey));
				break;
			case "select":
				System.out.println(bstobj.select(Integer.parseInt(tokens[1])));
				break;
			default:
			}
		}
	}
}