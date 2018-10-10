import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Solution {
	public static void main(String[] args) {

		//
		// MaxHeap mh = new MaxHeap(10);
		// MinHeap min = new MinHeap(10);
		// mh.insert(12);
		// mh.printMaxHeap();
		// mh.insert(13);
		// mh.printMaxHeap();
		// mh.insert(11);
		// mh.printMaxHeap();
		// mh.insert(14);
		// mh.printMaxHeap();
		// mh.delete();
		// mh.printMaxHeap();
		// mh.delete();
		// mh.printMaxHeap();

		// System.out.println("--------------------------");
		// min.insert(12);
		// min.printMinHeap();
		// min.insert(13);
		// min.printMinHeap();
		// min.insert(11);
		// min.printMinHeap();
		// min.insert(14);
		// min.printMinHeap();
		// min.delete();
		// System.out.println("del1");
		// min.printMinHeap();
		// System.out.println("del2");
		// min.delete();
		// min.printMinHeap();
		Scanner scan = new Scanner(System.in);
		int size = Integer.parseInt(scan.nextLine());
		int[] array = new int[size];

		int s = 0;
		while (s < size) {
			int element = Integer.parseInt(scan.nextLine());
			array[s] = element;
			s++;
		}
		for (int i = 1; i <= size; i++) {
			int[] newarray = Arrays.copyOfRange(array, 0, i);
			MaxPQ<Integer> mh = new MaxPQ<>(newarray.length);
			MinPQ<Integer> min = new MinPQ<>(newarray.length);
			for (int j = 0; j < newarray.length; j++) {
				mh.insert(newarray[j]);
				min.insert(newarray[j]);
			}
			int size1 = (newarray.length / 2) + 1;
			//System.out.println(size1);
			int element1 = 0;
			int element2 = 0;
			for (int k = 0; k < size1; k++) {
				//System.out.println("in while");
				element1 = mh.delMax();
				element2 = min.delMin();

			}
			float median = (element1+element2)/2.0f;
			
			System.out.println(median);
			
		}

		//System.out.println(Arrays.toString(array));
		// mh.insert(element);
		// min.insert(element);


		// while (size1 > 0) {
		// 	System.out.println("in while");
		// 	element1 = min.delete();
		// 	element2 = mh.delete();
		// 	System.out.println(element1 + " - " + element2);
		// 	size1--;
		// }
		// if(element1 == element2) {
		// 	System.out.println(element1);
		// }
		// else {
		// 	System.out.println((element1+element2)/2);
		// }
	}
}

// class MaxHeap {
// 	int[] maxHeap;
// 	int size;
// 	MaxHeap(int len) {
// 		maxHeap = new int[len];
// 		size = 0;
// 	}
// 	public void insert(int element) {
// 		maxHeap[size] = element;
// 		size++;
// 		swim();
// 	}
// 	public void delete() {
//         int index = maxHeap[0];
//         exchange(index, size-1);
//         maxHeap[size-1] = 0;
//         size--;
//         swim();
//         sink(index);

//     }
// 	public void swim() {
// 		while (!isMaxHeap()) {
// 			for (int i = size - 1; i > 0; i--) {
// 				int halveVal = ((i + 1) / 2) - 1;
// 				if (maxHeap[i] > maxHeap[halveVal]) {
// 					exchange(i, halveVal);
// 				}
// 			}
// 		}

// 	}
// 	public void sink(int k) {
// 		while (2*k <= n) {
//             int j = 2*k;
//             if (j < n && less(j, j+1)) j++;
//             if (!less(k, j)) break;
//             exchange(k, j);
//             k = j;
//         }

// 	}
// 	public void exchange(int i, int j) {
// 		//System.out.println("in exchange");
// 		int temp = maxHeap[i];
// 		maxHeap[i] = maxHeap[j];
// 		maxHeap[j] = temp;
// 	}
// 	public boolean isMaxHeap() {

// 		int flag = 1;
// 		if (size == 1) {
// 			return true;
// 		}
// 		for (int i = size - 1; i > 0; i--) {
// 			int halveVal = ((i + 1) / 2) - 1;
// 			//System.out.println(maxHeap[i]+" - "+ maxHeap[halveVal]);
// 			if (maxHeap[i] > maxHeap[halveVal]) {
// 				flag = 0;
// 				break;
// 			}
// 		}
// 		if (flag == 0) {
// 			return false;
// 		}
// 		return true;
// 	}
// 	public void printMaxHeap() {
// 		System.out.println(Arrays.toString(maxHeap));
// 	}

// }

// class MinHeap {
// 	int[] minHeap;
// 	int size;
// 	MinHeap(int len) {
// 		minHeap = new int[len];
// 		size = 0;
// 	}
// 	public void insert(int element) {
// 		minHeap[size] = element;
// 		size++;
// 		swim();
// 	}
// 	public int delete() {
// 		int item = minHeap[0];
// 		exchange(0, size - 1);
// 		//System.out.println(Arrays.toString(minHeap) + " array");
// 		minHeap[size - 1] = 0;
// 		size--;
// 		sink();
// 		return item;
// 	}
// 	public void swim() {
// 		while (!isMinHeap()) {
// 			for (int i = size - 1; i > 0; i--) {
// 				int halveVal = ((i + 1) / 2) - 1;
// 				if (minHeap[i] < minHeap[halveVal]) {
// 					exchange(i, halveVal);
// 				}
// 			}
// 		}

// 	}
// 	public void sink() {
// 		while (!isMinHeap()) {
// 			for (int i = 0; i < size - 1; i++) {
// 				int child1 = ((i + 1) * 2) - 1;
// 				int child2 = (((i + 1) * 2) + 1) - 1;
// 				if (minHeap[i] > minHeap[child1]) {
// 					exchange(i, child1);

// 				}
// 				if (minHeap[i] > minHeap[child2]) {
// 					exchange(i, child2);
// 				}
// 				break;
// 			}

// 		}

// 	}
// 	public void exchange(int i, int j) {
// 		//System.out.println("in exchange");
// 		int temp = minHeap[i];
// 		minHeap[i] = minHeap[j];
// 		minHeap[j] = temp;
// 	}
// 	public boolean isMinHeap() {

// 		int flag = 1;
// 		if (size == 1) {
// 			return true;
// 		}
// 		for (int i = size - 1; i > 0; i--) {
// 			int halveVal = ((i + 1) / 2) - 1;
// 			//System.out.println(maxHeap[i]+" - "+ maxHeap[halveVal]);
// 			if (minHeap[i] < minHeap[halveVal]) {
// 				flag = 0;
// 				break;
// 			}
// 		}
// 		if (flag == 0) {
// 			return false;
// 		}
// 		return true;
// 	}
// 	public void printMinHeap() {
// 		System.out.println(Arrays.toString(minHeap));
// 	}

// }

class MinPQ<Key> implements Iterable<Key> {
	private Key[] pq;                    // store items at indices 1 to n
	private int n;                       // number of items on priority queue
	private Comparator<Key> comparator;  // optional comparator

	/**
	 * Initializes an empty priority queue with the given initial capacity.
	 *
	 * @param  initCapacity the initial capacity of this priority queue
	 */
	public MinPQ(int initCapacity) {
		pq = (Key[]) new Object[initCapacity + 1];
		n = 0;
	}

	/**
	 * Initializes an empty priority queue.
	 */
	public MinPQ() {
		this(1);
	}

	/**
	 * Initializes an empty priority queue with the given initial capacity,
	 * using the given comparator.
	 *
	 * @param  initCapacity the initial capacity of this priority queue
	 * @param  comparator the order in which to compare the keys
	 */
	public MinPQ(int initCapacity, Comparator<Key> comparator) {
		this.comparator = comparator;
		pq = (Key[]) new Object[initCapacity + 1];
		n = 0;
	}

	/**
	 * Initializes an empty priority queue using the given comparator.
	 *
	 * @param  comparator the order in which to compare the keys
	 */
	public MinPQ(Comparator<Key> comparator) {
		this(1, comparator);
	}

	/**
	 * Initializes a priority queue from the array of keys.
	 * <p>
	 * Takes time proportional to the number of keys, using sink-based heap construction.
	 *
	 * @param  keys the array of keys
	 */
	public MinPQ(Key[] keys) {
		n = keys.length;
		pq = (Key[]) new Object[keys.length + 1];
		for (int i = 0; i < n; i++)
			pq[i + 1] = keys[i];
		for (int k = n / 2; k >= 1; k--)
			sink(k);
		assert isMinHeap();
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
	 * Returns a smallest key on this priority queue.
	 *
	 * @return a smallest key on this priority queue
	 * @throws NoSuchElementException if this priority queue is empty
	 */
	public Key min() {
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
	 * @param  x the key to add to this priority queue
	 */
	public void insert(Key x) {
		// double size of array if necessary
		if (n == pq.length - 1) resize(2 * pq.length);

		// add x, and percolate it up to maintain heap invariant
		pq[++n] = x;
		swim(n);
		assert isMinHeap();
	}

	/**
	 * Removes and returns a smallest key on this priority queue.
	 *
	 * @return a smallest key on this priority queue
	 * @throws NoSuchElementException if this priority queue is empty
	 */
	public Key delMin() {
		if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
		Key min = pq[1];
		exch(1, n--);
		sink(1);
		pq[n + 1] = null;   // to avoid loiterig and help with garbage collection
		if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length / 2);
		assert isMinHeap();
		return min;
	}


	/***************************************************************************
	 * Helper functions to restore the heap invariant.
	 ***************************************************************************/

	private void swim(int k) {
		while (k > 1 && greater(k / 2, k)) {
			exch(k, k / 2);
			k = k / 2;
		}
	}

	private void sink(int k) {
		while (2 * k <= n) {
			int j = 2 * k;
			if (j < n && greater(j, j + 1)) j++;
			if (!greater(k, j)) break;
			exch(k, j);
			k = j;
		}
	}

	/***************************************************************************
	 * Helper functions for compares and swaps.
	 ***************************************************************************/
	private boolean greater(int i, int j) {
		if (comparator == null) {
			return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
		} else {
			return comparator.compare(pq[i], pq[j]) > 0;
		}
	}

	private void exch(int i, int j) {
		Key swap = pq[i];
		pq[i] = pq[j];
		pq[j] = swap;
	}

	// is pq[1..N] a min heap?
	private boolean isMinHeap() {
		return isMinHeap(1);
	}

	// is subtree of pq[1..n] rooted at k a min heap?
	private boolean isMinHeap(int k) {
		if (k > n) return true;
		int left = 2 * k;
		int right = 2 * k + 1;
		if (left  <= n && greater(k, left))  return false;
		if (right <= n && greater(k, right)) return false;
		return isMinHeap(left) && isMinHeap(right);
	}


	/**
	 * Returns an iterator that iterates over the keys on this priority queue
	 * in ascending order.
	 * <p>
	 * The iterator doesn't implement {@code remove()} since it's optional.
	 *
	 * @return an iterator that iterates over the keys in ascending order
	 */
	public Iterator<Key> iterator() {
		return new HeapIterator();
	}

	private class HeapIterator implements Iterator<Key> {
		// create a new pq
		private MinPQ<Key> copy;

		// add all items to copy of heap
		// takes linear time since already in heap order so no keys move
		public HeapIterator() {
			if (comparator == null) copy = new MinPQ<Key>(size());
			else                    copy = new MinPQ<Key>(size(), comparator);
			for (int i = 1; i <= n; i++)
				copy.insert(pq[i]);
		}

		public boolean hasNext()  { return !copy.isEmpty();                     }
		public void remove()      { throw new UnsupportedOperationException();  }

		public Key next() {
			if (!hasNext()) throw new NoSuchElementException();
			return copy.delMin();
		}
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
}