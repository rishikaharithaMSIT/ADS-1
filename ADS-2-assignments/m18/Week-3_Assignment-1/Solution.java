import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		BinarySearchST<String, Integer> maxs = new BinarySearchST<>();
		BinarySearchST<String, Integer> mins = new BinarySearchST<>();
		String[] line;
		int hours = 6;
		while (hours > 0) {
			int k = n;
			MinPQ<Stock> onemin = new MinPQ<Stock>();
			MaxPQ<Stock> onemax = new MaxPQ<Stock>();
			while (k > 0) {
				line = scan.nextLine().split(",");
				onemin.insert(new Stock(line[0], line[1]));
				onemax.insert(new Stock(line[0], line[1]));
				k--;
			}
			int top = 5;
			while (top > 0) {
				Stock s = onemax.delMax();
				if (maxs.contains(s.name)) {
					maxs.put(s.name, maxs.get(s.name) + 1);
				} else {
					maxs.put(s.name, 1);
				}
				System.out.println(s.name + " " + s.val);
				top--;
			}
			System.out.println();
			int low = 5;
			while (low > 0) {
				Stock s = onemin.delMin();
				if (mins.contains(s.name)) {
					mins.put(s.name, mins.get(s.name) + 1);
				} else {
					mins.put(s.name, 1);
				}
				System.out.println(s.name + " " + s.val);
				low--;
			}
			System.out.println();
			hours--;

		}
		int comms = Integer.parseInt(scan.nextLine());
		while (comms > 0) {
			String[] tokens = scan.nextLine().split(",");
			switch(tokens[0]) {
				case "get" :
					if(tokens[1].equals("maxST")) {
						if(maxs.contains(tokens[2])) {
							System.out.println(maxs.get(tokens[2]));
						}else {
							System.out.println("0");
						}
						
					} else {
						if(mins.contains(tokens[2])) {
							System.out.println(mins.get(tokens[2]));
						}else {
							System.out.println("0");
						}
					}
					
				break;
			}
			// for (String word : maxs.keys()) {
			// 	System.out.println(word + " - " + maxs.get(word));
			// }
			comms--;		
		}
		// String max = "";
		// maxs.put(max, 0);
		// for (String word : maxs.keys()) {
		// 	if (st.get(word) > st.get(max))
		// 		max = word;
		// }
		// System.out.println(max + "max");

	}
}

class Stock implements Comparable<Stock> {
	String name;
	double val;
	Stock(String name, String val) {
		this.name = name;
		this.val = Double.parseDouble(val);
	}
	public int compareTo(Stock that) {
		//System.out.println("greater : " + this.val + " - " + that.val);
		if (this.val < that.val) return -1;
		if (this.val > that.val) return 1;
		if (this.name.compareTo(that.name) > 0) return 1;
		if (this.name.compareTo(that.name) < 0) return -1;

		return 0;
	}
}

class BinarySearchST<Key extends Comparable<Key>, Value> {
	private static final int INIT_CAPACITY = 2;
	private Key[] keys;
	private Value[] vals;
	private int n = 0;

	/**
	 * Initializes an empty symbol table.
	 */
	public BinarySearchST() {
		this(INIT_CAPACITY);
	}

	/**
	 * Initializes an empty symbol table with the specified initial capacity.
	 * @param capacity the maximum capacity
	 */
	public BinarySearchST(int capacity) {
		keys = (Key[]) new Comparable[capacity];
		vals = (Value[]) new Object[capacity];
	}

	// resize the underlying arrays
	private void resize(int capacity) {
		assert capacity >= n;
		Key[]   tempk = (Key[])   new Comparable[capacity];
		Value[] tempv = (Value[]) new Object[capacity];
		for (int i = 0; i < n; i++) {
			tempk[i] = keys[i];
			tempv[i] = vals[i];
		}
		vals = tempv;
		keys = tempk;
	}

	/**
	 * Returns the number of key-value pairs in this symbol table.
	 *
	 * @return the number of key-value pairs in this symbol table
	 */
	public int size() {
		return n;
	}

	/**
	 * Returns true if this symbol table is empty.
	 *
	 * @return {@code true} if this symbol table is empty;
	 *         {@code false} otherwise
	 */
	public boolean isEmpty() {
		return size() == 0;
	}


	/**
	 * Does this symbol table contain the given key?
	 *
	 * @param  key the key
	 * @return {@code true} if this symbol table contains {@code key} and
	 *         {@code false} otherwise
	 * @throws IllegalArgumentException if {@code key} is {@code null}
	 */
	public boolean contains(Key key) {
		if (key == null) throw new IllegalArgumentException("argument to contains() is null");
		return get(key) != null;
	}

	/**
	 * Returns the value associated with the given key in this symbol table.
	 *
	 * @param  key the key
	 * @return the value associated with the given key if the key is in the symbol table
	 *         and {@code null} if the key is not in the symbol table
	 * @throws IllegalArgumentException if {@code key} is {@code null}
	 */
	public Value get(Key key) {
		if (key == null) throw new IllegalArgumentException("argument to get() is null");
		if (isEmpty()) return null;
		int i = rank(key);
		if (i < n && keys[i].compareTo(key) == 0) return vals[i];
		return null;
	}

	/**
	 * Returns the number of keys in this symbol table strictly less than {@code key}.
	 *
	 * @param  key the key
	 * @return the number of keys in the symbol table strictly less than {@code key}
	 * @throws IllegalArgumentException if {@code key} is {@code null}
	 */
	public int rank(Key key) {
		if (key == null) throw new IllegalArgumentException("argument to rank() is null");

		int lo = 0, hi = n - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(keys[mid]);
			if      (cmp < 0) hi = mid - 1;
			else if (cmp > 0) lo = mid + 1;
			else return mid;
		}
		return lo;
	}



	/**
	 * Inserts the specified key-value pair into the symbol table, overwriting the old
	 * value with the new value if the symbol table already contains the specified key.
	 * Deletes the specified key (and its associated value) from this symbol table
	 * if the specified value is {@code null}.
	 *
	 * @param  key the key
	 * @param  val the value
	 * @throws IllegalArgumentException if {@code key} is {@code null}
	 */
	public void put(Key key, Value val)  {
		if (key == null) throw new IllegalArgumentException("first argument to put() is null");

		if (val == null) {
			delete(key);
			return;
		}

		int i = rank(key);

		// key is already in table
		if (i < n && keys[i].compareTo(key) == 0) {
			vals[i] = val;
			return;
		}

		// insert new key-value pair
		if (n == keys.length) resize(2 * keys.length);

		for (int j = n; j > i; j--)  {
			keys[j] = keys[j - 1];
			vals[j] = vals[j - 1];
		}
		keys[i] = key;
		vals[i] = val;
		n++;

		assert check();
	}

	/**
	 * Removes the specified key and associated value from this symbol table
	 * (if the key is in the symbol table).
	 *
	 * @param  key the key
	 * @throws IllegalArgumentException if {@code key} is {@code null}
	 */
	public void delete(Key key) {
		if (key == null) throw new IllegalArgumentException("argument to delete() is null");
		if (isEmpty()) return;

		// compute rank
		int i = rank(key);

		// key not in table
		if (i == n || keys[i].compareTo(key) != 0) {
			return;
		}

		for (int j = i; j < n - 1; j++)  {
			keys[j] = keys[j + 1];
			vals[j] = vals[j + 1];
		}

		n--;
		keys[n] = null;  // to avoid loitering
		vals[n] = null;

		// resize if 1/4 full
		if (n > 0 && n == keys.length / 4) resize(keys.length / 2);

		assert check();
	}

	/**
	 * Removes the smallest key and associated value from this symbol table.
	 *
	 * @throws NoSuchElementException if the symbol table is empty
	 */
	public void deleteMin() {
		if (isEmpty()) throw new NoSuchElementException("Symbol table underflow error");
		delete(min());
	}

	/**
	 * Removes the largest key and associated value from this symbol table.
	 *
	 * @throws NoSuchElementException if the symbol table is empty
	 */
	public void deleteMax() {
		if (isEmpty()) throw new NoSuchElementException("Symbol table underflow error");
		delete(max());
	}


	/***************************************************************************
	 *  Ordered symbol table methods.
	 ***************************************************************************/

	/**
	  * Returns the smallest key in this symbol table.
	  *
	  * @return the smallest key in this symbol table
	  * @throws NoSuchElementException if this symbol table is empty
	  */
	public Key min() {
		if (isEmpty()) throw new NoSuchElementException("called min() with empty symbol table");
		return keys[0];
	}

	/**
	 * Returns the largest key in this symbol table.
	 *
	 * @return the largest key in this symbol table
	 * @throws NoSuchElementException if this symbol table is empty
	 */
	public Key max() {
		if (isEmpty()) throw new NoSuchElementException("called max() with empty symbol table");
		return keys[n - 1];
	}

	/**
	 * Return the kth smallest key in this symbol table.
	 *
	 * @param  k the order statistic
	 * @return the {@code k}th smallest key in this symbol table
	 * @throws IllegalArgumentException unless {@code k} is between 0 and
	 *        <em>n</em>–1
	 */
	public Key select(int k) {
		if (k < 0 || k >= size()) {
			throw new IllegalArgumentException("called select() with invalid argument: " + k);
		}
		return keys[k];
	}

	/**
	 * Returns the largest key in this symbol table less than or equal to {@code key}.
	 *
	 * @param  key the key
	 * @return the largest key in this symbol table less than or equal to {@code key}
	 * @throws NoSuchElementException if there is no such key
	 * @throws IllegalArgumentException if {@code key} is {@code null}
	 */
	public Key floor(Key key) {
		if (key == null) throw new IllegalArgumentException("argument to floor() is null");
		int i = rank(key);
		if (i < n && key.compareTo(keys[i]) == 0) return keys[i];
		if (i == 0) return null;
		else return keys[i - 1];
	}

	/**
	 * Returns the smallest key in this symbol table greater than or equal to {@code key}.
	 *
	 * @param  key the key
	 * @return the smallest key in this symbol table greater than or equal to {@code key}
	 * @throws NoSuchElementException if there is no such key
	 * @throws IllegalArgumentException if {@code key} is {@code null}
	 */
	public Key ceiling(Key key) {
		if (key == null) throw new IllegalArgumentException("argument to ceiling() is null");
		int i = rank(key);
		if (i == n) return null;
		else return keys[i];
	}

	/**
	 * Returns the number of keys in this symbol table in the specified range.
	 *
	 * @param lo minimum endpoint
	 * @param hi maximum endpoint
	 * @return the number of keys in this symbol table between {@code lo}
	 *         (inclusive) and {@code hi} (inclusive)
	 * @throws IllegalArgumentException if either {@code lo} or {@code hi}
	 *         is {@code null}
	 */
	public int size(Key lo, Key hi) {
		if (lo == null) throw new IllegalArgumentException("first argument to size() is null");
		if (hi == null) throw new IllegalArgumentException("second argument to size() is null");

		if (lo.compareTo(hi) > 0) return 0;
		if (contains(hi)) return rank(hi) - rank(lo) + 1;
		else              return rank(hi) - rank(lo);
	}

	/**
	 * Returns all keys in this symbol table as an {@code Iterable}.
	 * To iterate over all of the keys in the symbol table named {@code st},
	 * use the foreach notation: {@code for (Key key : st.keys())}.
	 *
	 * @return all keys in this symbol table
	 */
	public Iterable<Key> keys() {
		return keys(min(), max());
	}

	/**
	 * Returns all keys in this symbol table in the given range,
	 * as an {@code Iterable}.
	 *
	 * @param lo minimum endpoint
	 * @param hi maximum endpoint
	 * @return all keys in this symbol table between {@code lo}
	 *         (inclusive) and {@code hi} (inclusive)
	 * @throws IllegalArgumentException if either {@code lo} or {@code hi}
	 *         is {@code null}
	 */
	public Iterable<Key> keys(Key lo, Key hi) {
		if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
		if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");

		Queue<Key> queue = new Queue<Key>();
		if (lo.compareTo(hi) > 0) return queue;
		for (int i = rank(lo); i < rank(hi); i++)
			queue.enqueue(keys[i]);
		if (contains(hi)) queue.enqueue(keys[rank(hi)]);
		return queue;
	}


	/***************************************************************************
	 *  Check internal invariants.
	 ***************************************************************************/

	private boolean check() {
		return isSorted() && rankCheck();
	}

	// are the items in the array in ascending order?
	private boolean isSorted() {
		for (int i = 1; i < size(); i++)
			if (keys[i].compareTo(keys[i - 1]) < 0) return false;
		return true;
	}

	// check that rank(select(i)) = i
	private boolean rankCheck() {
		for (int i = 0; i < size(); i++)
			if (i != rank(select(i))) return false;
		for (int i = 0; i < size(); i++)
			if (keys[i].compareTo(select(rank(keys[i]))) != 0) return false;
		return true;
	}


	/**
	 * Unit tests the {@code BinarySearchST} data type.
	 *
	 * @param args the command-line arguments
	 */

}
class MaxPQ<Key> implements Iterable<Key> {
	private Key[] pq;                    // store items at indices 1 to n
	private int n;                       // number of items on priority queue
	private Comparator<Key> comparator;  // optional comparator

	/**
	 * Initializes an empty priority queue with the given initial capacity.
	 *
	 * @param  initCapacity the initial capacity of this priority queue
	 */
	public MaxPQ(int initCapacity) {
		pq = (Key[]) new Object[initCapacity + 1];
		n = 0;
	}

	/**
	 * Initializes an empty priority queue.
	 */
	public MaxPQ() {
		this(1);
	}

	/**
	 * Initializes an empty priority queue with the given initial capacity,
	 * using the given comparator.
	 *
	 * @param  initCapacity the initial capacity of this priority queue
	 * @param  comparator the order in which to compare the keys
	 */
	public MaxPQ(int initCapacity, Comparator<Key> comparator) {
		this.comparator = comparator;
		pq = (Key[]) new Object[initCapacity + 1];
		n = 0;
	}

	/**
	 * Initializes an empty priority queue using the given comparator.
	 *
	 * @param  comparator the order in which to compare the keys
	 */
	public MaxPQ(Comparator<Key> comparator) {
		this(1, comparator);
	}

	/**
	 * Initializes a priority queue from the array of keys.
	 * Takes time proportional to the number of keys, using sink-based heap construction.
	 *
	 * @param  keys the array of keys
	 */
	public MaxPQ(Key[] keys) {
		n = keys.length;
		pq = (Key[]) new Object[keys.length + 1];
		for (int i = 0; i < n; i++)
			pq[i + 1] = keys[i];
		for (int k = n / 2; k >= 1; k--)
			sink(k);
		assert isMaxHeap();
	}



	/**
	 * Returns true if this priority queue is empty.
	 *
	 * @return {@code true} if this priority queue is empty;
	 *         {@code false} otherwise
	 */
	public boolean isEmpty() {
		return n == 0;
	}

	/**
	 * Returns the number of keys on this priority queue.
	 *
	 * @return the number of keys on this priority queue
	 */
	public int size() {
		return n;
	}

	/**
	 * Returns a largest key on this priority queue.
	 *
	 * @return a largest key on this priority queue
	 * @throws NoSuchElementException if this priority queue is empty
	 */
	public Key max() {
		if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
		return pq[1];
	}

	// helper function to double the size of the heap array
	private void resize(int capacity) {
		assert capacity > n;
		Key[] temp = (Key[]) new Object[capacity];
		for (int i = 1; i <= n; i++) {
			temp[i] = pq[i];
		}
		pq = temp;
	}


	/**
	 * Adds a new key to this priority queue.
	 *
	 * @param  x the new key to add to this priority queue
	 */
	public void insert(Key x) {

		// double size of array if necessary
		if (n == pq.length - 1) resize(2 * pq.length);

		// add x, and percolate it up to maintain heap invariant
		pq[++n] = x;
		swim(n);
		assert isMaxHeap();
	}

	/**
	 * Removes and returns a largest key on this priority queue.
	 *
	 * @return a largest key on this priority queue
	 * @throws NoSuchElementException if this priority queue is empty
	 */
	public Key delMax() {
		if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
		Key max = pq[1];
		exch(1, n--);
		sink(1);
		pq[n + 1] = null;   // to avoid loiterig and help with garbage collection
		if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length / 2);
		assert isMaxHeap();
		return max;
	}


	/***************************************************************************
	 * Helper functions to restore the heap invariant.
	 ***************************************************************************/

	private void swim(int k) {
		while (k > 1 && less(k / 2, k)) {
			exch(k, k / 2);
			k = k / 2;
		}
	}

	private void sink(int k) {
		while (2 * k <= n) {
			int j = 2 * k;
			if (j < n && less(j, j + 1)) j++;
			if (!less(k, j)) break;
			exch(k, j);
			k = j;
		}
	}

	/***************************************************************************
	 * Helper functions for compares and swaps.
	 ***************************************************************************/
	private boolean less(int i, int j) {
		if (comparator == null) {
			return ((Comparable<Key>) pq[i]).compareTo(pq[j]) < 0;
		} else {
			return comparator.compare(pq[i], pq[j]) < 0;
		}
	}

	private void exch(int i, int j) {
		Key swap = pq[i];
		pq[i] = pq[j];
		pq[j] = swap;
	}

	// is pq[1..N] a max heap?
	private boolean isMaxHeap() {
		return isMaxHeap(1);
	}

	// is subtree of pq[1..n] rooted at k a max heap?
	private boolean isMaxHeap(int k) {
		if (k > n) return true;
		int left = 2 * k;
		int right = 2 * k + 1;
		if (left  <= n && less(k, left))  return false;
		if (right <= n && less(k, right)) return false;
		return isMaxHeap(left) && isMaxHeap(right);
	}


	/***************************************************************************
	 * Iterator.
	 ***************************************************************************/

	/**
	 * Returns an iterator that iterates over the keys on this priority queue
	 * in descending order.
	 * The iterator doesn't implement {@code remove()} since it's optional.
	 *
	 * @return an iterator that iterates over the keys in descending order
	 */
	public Iterator<Key> iterator() {
		return new HeapIterator();
	}

	private class HeapIterator implements Iterator<Key> {

		// create a new pq
		private MaxPQ<Key> copy;

		// add all items to copy of heap
		// takes linear time since already in heap order so no keys move
		public HeapIterator() {
			if (comparator == null) copy = new MaxPQ<Key>(size());
			else                    copy = new MaxPQ<Key>(size(), comparator);
			for (int i = 1; i <= n; i++)
				copy.insert(pq[i]);
		}

		public boolean hasNext()  { return !copy.isEmpty();                     }
		public void remove()      { throw new UnsupportedOperationException();  }

		public Key next() {
			if (!hasNext()) throw new NoSuchElementException();
			return copy.delMax();
		}
	}

	/**
	 * Unit tests the {@code MaxPQ} data type.
	 *
	 * @param args the command-line arguments
	 */


}

/**
 * Class for minimum pq.
 *
 * @param      <Key>  The key
 */
class MinPQ<Key> implements Iterable<Key> {
	/**
	 * pq array.
	 */
	private Key[] pq;                    // store items at indices 1 to n
	/**
	 *
	 */
	private int n;                       // number of items on priority queue
	/**
	 * comparator.
	 */
	private Comparator<Key> comparator;  // optional comparator

	/**
	 * Initializes an empty priority queue with the given initial capacity.
	 *
	 * @param      initCapacity  The initialize capacity
	 */
	MinPQ(final int initCapacity) {
		pq = (Key[]) new Object[initCapacity + 1];
		n = 0;
	}

	/**
	 * Initializes an empty priority queue.
	 */
	MinPQ() {
		this(1);
	}

	/**
	 * Initializes an empty priority queue with the given initial capacity,
	 * using the given comparator.
	 *
	 * @param      initCapacity  The initialize capacity
	 * @param      comparator1    The comparator
	 */
	MinPQ(final int initCapacity, final Comparator<Key> comparator1) {
		this.comparator = comparator1;
		pq = (Key[]) new Object[initCapacity + 1];
		n = 0;
	}

	/**
	 * Initializes an empty priority queue using the given comparator.
	 *
	 * @param      comparator1  The comparator
	 */
	MinPQ(final Comparator<Key> comparator1) {
		this(1, comparator1);
	}

	/**
	 * Initializes a priority queue from the array of keys.
	 *
	 * @param      keys  The keys
	 */
	MinPQ(final Key[] keys) {
		n = keys.length;
		pq = (Key[]) new Object[keys.length + 1];
		for (int i = 0; i < n; i++) {
			pq[i + 1] = keys[i];
		}
		for (int k = n / 2; k >= 1; k--) {
			sink(k);
		}
		assert isMinHeap();
	}

	/**
	 * Returns true if this priority queue is empty.
	 * Complexity :
	 *              Best Case : O(1)
	 *              Average Case : O(1)
	 *              Worst Case : O(1)
	 * @return     True if empty, False otherwise.
	 */
	public boolean isEmpty() {
		return n == 0;
	}

	/**
	 * Returns the number of keys on this priority queue.
	 * Complexity :
	 *              Best Case : O(1)
	 *              Average Case : O(1)
	 *              Worst Case : O(1)
	 * @return     { description_of_the_return_value }
	 */
	public int size() {
		return n;
	}

	/**
	 * Returns a smallest key on this priority queue.
	 * Complexity :
	 *              Best Case : O(1)
	 *              Average Case : O(1)
	 *              Worst Case : O(1)
	 * @return     { description_of_the_return_value }
	 */
	public Key min() {
		if (isEmpty()) {
			throw new NoSuchElementException(
			    "Priority queue underflow");
		}
		return pq[1];
	}

	/**
	 * helper function to double the size of the heap array.
	 * Complexity :
	 *              Best Case : O(n)
	 *              Average Case : O(n)
	 *              Worst Case : O(n)
	 * @param      capacity  The capacity
	 */
	private void resize(final int capacity) {
		assert capacity > n;
		Key[] temp = (Key[]) new Object[capacity];
		for (int i = 1; i <= n; i++) {
			temp[i] = pq[i];
		}
		pq = temp;
	}

	/**
	 * Adds a new key to this priority queue.
	 * Complexity :
	 *              Best Case : O(logn)
	 *              Average Case : O(logn)
	 *              Worst Case : O(logn)
	 * @param      x     { parameter_description }
	 */
	public void insert(final Key x) {
		// double size of array if necessary
		if (n == pq.length - 1) {
			resize(2 * pq.length);
		}

		// add x, and percolate it up to maintain heap invariant
		pq[++n] = x;
		swim(n);
		assert isMinHeap();
	}

	/**
	 * Removes and returns a smallest key on this priority queue.
	 * Complexity :
	 *              Best Case : O(logn)
	 *              Average Case : O(logn)
	 *              Worst Case : O(logn)
	 * @return     { description_of_the_return_value }
	 */
	public Key delMin() {
		final int four = 4;
		if (isEmpty()) {
			throw new NoSuchElementException(
			    "Priority queue underflow");
		}
		Key min = pq[1];
		exch(1, n--);
		sink(1);
		pq[n + 1] = null;
		if ((n > 0) && (n == (pq.length - 1) / four)) {
			resize(pq.length / 2);
		}
		assert isMinHeap();
		return min;
	}


	/**********************************************************************
	 * Helper functions to restore the heap invariant.
	 ***********************************************************************/
	/**
	 * swim function.
	 * Complexity :
	 *              Best Case : O(logn)
	 *              Average Case : O(logn)
	 *              Worst Case : O(logn)
	 * @param      k1     { parameter_description }
	 */
	private void swim(final int k1) {
		int k = k1;
		while (k > 1 && greater(k / 2, k)) {
			exch(k, k / 2);
			k = k / 2;
		}
	}

	/**
	 * Sink Function.
	 * Complexity :
	 *              Best Case : O(logn)
	 *              Average Case : O(logn)
	 *              Worst Case : O(logn)
	 * @param      k1     { parameter_description }
	 */
	private void sink(final int k1) {
		int k = k1;
		while (2 * k <= n) {
			int j = 2 * k;
			if (j < n && greater(j, j + 1)) {
				j++;
			}
			if (!greater(k, j)) {
				break;
			}
			exch(k, j);
			k = j;
		}
	}

	/***********************************************************************
	 * Helper functions for compares and swaps.
	 ***********************************************************************/
	/**
	 * greater function.
	 * Complexity :
	 *              Best Case : O(1)
	 *              Average Case : O(1)
	 *              Worst Case : O(1)
	 * @param      i     { parameter_description }
	 * @param      j     { parameter_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	private boolean greater(final int i, final int j) {
		if (comparator == null) {
			return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
		} else {
			System.out.println("greater : " + pq[i] + " - " + pq[j]);
			return comparator.compare(pq[i], pq[j]) > 0;
		}
	}

	/**
	 * exchange function.
	 * Complexity :
	 *              Best Case : O(1)
	 *              Average Case : O(1)
	 *              Worst Case : O(1)
	 * @param      i     { parameter_description }
	 * @param      j     { parameter_description }
	 */
	private void exch(final int i, final int j) {
		Key swap = pq[i];
		pq[i] = pq[j];
		pq[j] = swap;
	}

	/**
	 * Determines if minimum heap.
	 * Complexity :
	 *              Best Case : O(1)
	 *              Average Case : O(1)
	 *              Worst Case : O(1)
	 * @return     True if minimum heap, False otherwise.
	 */
	private boolean isMinHeap() {
		return isMinHeap(1);
	}

	/**
	 * Determines if minimum heap.
	 * Complexity :
	 *              Best Case : O(1)
	 *              Average Case : O(1)
	 *              Worst Case : O(1)
	 * @param      k1     { parameter_description }
	 *
	 * @return     True if minimum heap, False otherwise.
	 */
	private boolean isMinHeap(final int k1) {
		int k = k1;
		if (k > n) {
			return true;
		}
		int left = 2 * k;
		int right = 2 * k + 1;
		if (left  <= n && greater(k, left)) {
			return false;
		}
		if (right <= n && greater(k, right)) {
			return false;
		}
		return isMinHeap(left) && isMinHeap(right);
	}


	/**
	 * Returns an iterator that iterates over the keys on this priority queue
	 * in ascending order.
	 *
	 * @return     { description_of_the_return_value }
	 */
	public Iterator<Key> iterator() {
		return new HeapIterator();
	}

	/**
	 * Class for heap iterator.
	 */
	private class HeapIterator implements Iterator<Key> {
		/**
		 * create a new pq.
		 */
		private MinPQ<Key> copy;

		/**
		 * add all items to copy of heap.
		 * takes linear time since already in heap order so no keys move
		 */
		HeapIterator() {
			if (comparator == null) {
				copy = new MinPQ<Key>(size());
			} else {
				copy = new MinPQ<Key>(size(), comparator);
			}
			for (int i = 1; i <= n; i++) {
				copy.insert(pq[i]);
			}
		}
		/**
		 * Determines if it has next.
		 *
		 * @return     True if has next, False otherwise.
		 */
		public boolean hasNext() {
			return !copy.isEmpty();
		}

		/**
		 * remove function.
		 */
		public void remove() {
			throw new UnsupportedOperationException();
		}
		/**
		 * next function.
		 *
		 * @return     { description_of_the_return_value }
		 */
		public Key next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return copy.delMin();
		}
	}
}
class Queue<Item> implements Iterable<Item> {
	private Node<Item> first;    // beginning of queue
	private Node<Item> last;     // end of queue
	private int n;               // number of elements on queue

	// helper linked list class
	private static class Node<Item> {
		private Item item;
		private Node<Item> next;
	}

	/**
	 * Initializes an empty queue.
	 */
	public Queue() {
		first = null;
		last  = null;
		n = 0;
	}

	/**
	 * Returns true if this queue is empty.
	 *
	 * @return {@code true} if this queue is empty; {@code false} otherwise
	 */
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * Returns the number of items in this queue.
	 *
	 * @return the number of items in this queue
	 */
	public int size() {
		return n;
	}

	/**
	 * Returns the item least recently added to this queue.
	 *
	 * @return the item least recently added to this queue
	 * @throws NoSuchElementException if this queue is empty
	 */
	public Item peek() {
		if (isEmpty()) throw new NoSuchElementException("Queue underflow");
		return first.item;
	}

	/**
	 * Adds the item to this queue.
	 *
	 * @param  item the item to add
	 */
	public void enqueue(Item item) {
		Node<Item> oldlast = last;
		last = new Node<Item>();
		last.item = item;
		last.next = null;
		if (isEmpty()) first = last;
		else           oldlast.next = last;
		n++;
	}

	/**
	 * Removes and returns the item on this queue that was least recently added.
	 *
	 * @return the item on this queue that was least recently added
	 * @throws NoSuchElementException if this queue is empty
	 */
	public Item dequeue() {
		if (isEmpty()) throw new NoSuchElementException("Queue underflow");
		Item item = first.item;
		first = first.next;
		n--;
		if (isEmpty()) last = null;   // to avoid loitering
		return item;
	}

	/**
	 * Returns a string representation of this queue.
	 *
	 * @return the sequence of items in FIFO order, separated by spaces
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (Item item : this) {
			s.append(item);
			s.append(' ');
		}
		return s.toString();
	}

	/**
	 * Returns an iterator that iterates over the items in this queue in FIFO order.
	 *
	 * @return an iterator that iterates over the items in this queue in FIFO order
	 */
	public Iterator<Item> iterator()  {
		return new ListIterator<Item>(first);
	}

	// an iterator, doesn't implement remove() since it's optional
	private class ListIterator<Item> implements Iterator<Item> {
		private Node<Item> current;

		public ListIterator(Node<Item> first) {
			current = first;
		}

		public boolean hasNext()  { return current != null;                     }
		public void remove()      { throw new UnsupportedOperationException();  }

		public Item next() {
			if (!hasNext()) throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}
	}



}