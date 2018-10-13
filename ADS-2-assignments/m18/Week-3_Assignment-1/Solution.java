import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());

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
				System.out.println(s.name + " - " + s.val);
				top--;
			}
			System.out.println();
			int low = 5;
			while (low > 0) {
				Stock s = onemin.delMin();
				System.out.println(s.name + " - " + s.val);
				low--;
			}
			hours--;

		}
		// while (n > 0) {
		// 	line = scan.nextLine().split(",");
		// 	System.out.println(line[0] + " - " + line[1]);
		// 	onemin.insert(new Stock(line[0], line[1]));
		// 	onemax.insert(new Stock(line[0], line[1]));
		// 	line = scan.nextLine().split(",");
		// 	System.out.println(line[0] + " - " + line[1]);
		// 	line = scan.nextLine().split(",");
		// 	System.out.println(line[0] + " - " + line[1]);
		// 	line = scan.nextLine().split(",");
		// 	System.out.println(line[0] + " - " + line[1]);
		// 	line = scan.nextLine().split(",");
		// 	System.out.println(line[0] + " - " + line[1]);
		// 	line = scan.nextLine().split(",");
		// 	System.out.println(line[0] + " - " + line[1]);
		// 	n--;
		// 	System.out.println();
		// }
		// while (!onemax.isEmpty()) {
		// 	Stock s = onemax.delMax();
		// 	System.out.println(s.name + " - " + s.val);
		// }
		// System.out.println();
		// while (!onemin.isEmpty()) {
		// 	Stock s = onemin.delMin();
		// 	System.out.println(s.name + " - " + s.val);
		// }



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
