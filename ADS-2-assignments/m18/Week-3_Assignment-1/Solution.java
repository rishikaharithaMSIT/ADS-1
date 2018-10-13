import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		MinPQ<Stock> one = new MinPQ<Stock>();
		String[] line;
		while (n > 0) {
			line = scan.nextLine().split(",");
			System.out.println(line[0] + " - "+ line[1]);
			one.insert(new Stock(line[0], line[1]));
			line = scan.nextLine().split(",");
			System.out.println(line[0] + " - "+ line[1]);
			line = scan.nextLine().split(",");
			System.out.println(line[0] + " - "+ line[1]);
			line = scan.nextLine().split(",");
			System.out.println(line[0] + " - "+ line[1]);
			line = scan.nextLine().split(",");
			System.out.println(line[0] + " - "+ line[1]);
			line = scan.nextLine().split(",");
			System.out.println(line[0] + " - "+ line[1]);
			n--;
			System.out.println();
		}

		while (!one.isEmpty()) {
			Stock s = one.delMin();
			System.out.println(s.name + " - " + s.val);
		}



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
		System.out.println("greater : " + this.val+ " - " + that.val);
		if (this.val < that.val) return -1;
		if (this.val > that.val) return +1;
		return 0;
	}
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
