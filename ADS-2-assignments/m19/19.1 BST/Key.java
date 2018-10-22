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
