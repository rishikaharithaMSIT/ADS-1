import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Class for solution.
 */
public final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {

	}
	/**
	 * main function.
	 *
	 * @param      args  The arguments
	 */
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
		int n = scan.nextInt();

		MinPQ<Float> min = new MinPQ<Float>(n);
		MaxPQ<Float> max = new MaxPQ<Float>(n);

		Float median = 0.0f;
		for (int i = 0; i < n; i++) {
			Float val = scan.nextFloat();
			if (val > median) {
				min.insert(val);
			} else {
				max.insert(val);
			}

			if (min.size() - max.size() > 1) {
				max.insert(min.delMin());

			}
			if (max.size() - min.size() > 1) {
				min.insert(max.delMax());

			}

			if (min.size() == max.size()) {
				median = (min.min() + max.max()) / 2;
				System.out.println(median);
			}

			if (max.size() > min.size()) {
				median = max.max();
				System.out.println(median);
			}

			if (min.size() > max.size()) {
				median = min.min();
				System.out.println(median);
			}

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