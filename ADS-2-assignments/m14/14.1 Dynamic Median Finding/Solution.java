import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		MaxHeap mh = new MaxHeap(10);
		MinHeap min = new MinHeap(10);
		mh.insert(12);
		mh.printMaxHeap();
		mh.insert(13);
		mh.printMaxHeap();
		mh.insert(11);
		mh.printMaxHeap();
		mh.insert(14);
		mh.printMaxHeap();
		mh.delete();
		mh.printMaxHeap();

		min.insert(12);
		min.printMinHeap();
		min.insert(13);
		min.printMinHeap();
		min.insert(11);
		min.printMinHeap();
		min.insert(14);
		min.printMinHeap();
	}
}

class MaxHeap {
	int[] maxHeap;
	int size;
	MaxHeap(int len) {
		maxHeap = new int[len];
		size = 0;
	}
	public void insert(int element) {
		maxHeap[size] = element;
		size++;
		swim();
	}
	public void delete() {
		exchange(0, size - 1);
		maxHeap[size - 1] = 0;
		size--;
		sink();
	}
	public void swim() {
		while (!isMaxHeap()) {
			for (int i = size - 1; i > 0; i--) {
				int halveVal = ((i + 1) / 2) - 1;
				if (maxHeap[i] > maxHeap[halveVal]) {
					exchange(i, halveVal);
				}
			}
		}

	}
	public void sink() {
		while (!isMaxHeap()) {
			for (int i = 0; i < size - 1; i++) {
				int child1 = ((i + 1) * 2) - 1;
				int child2 = (((i + 1) * 2) + 1) - 1;
				if (maxHeap[i] < maxHeap[child1]) {
					exchange(i, child1);
				}
				if (maxHeap[i] < maxHeap[child2]) {
					exchange(i, child2);
				}
			}

		}

	}
	public void exchange(int i, int j) {
		System.out.println("in exchange");
		int temp = maxHeap[i];
		maxHeap[i] = maxHeap[j];
		maxHeap[j] = temp;
	}
	public boolean isMaxHeap() {

		int flag = 1;
		if (size == 1) {
			return true;
		}
		for (int i = size - 1; i > 0; i--) {
			int halveVal = ((i + 1) / 2) - 1;
			//System.out.println(maxHeap[i]+" - "+ maxHeap[halveVal]);
			if (maxHeap[i] > maxHeap[halveVal]) {
				flag = 0;
				break;
			}
		}
		if (flag == 0) {
			return false;
		}
		return true;
	}
	public void printMaxHeap() {
		System.out.println(Arrays.toString(maxHeap));
	}

}

class MinHeap {
	int[] minHeap;
	int size;
	MinHeap(int len) {
		minHeap = new int[len];
		size = 0;
	}
	public void insert(int element) {
		minHeap[size] = element;
		size++;
		swim();
	}
	public void swim() {
		while (!isMinHeap()) {
			for (int i = size - 1; i > 0; i--) {
				int halveVal = ((i + 1) / 2) - 1;
				if (minHeap[i] < minHeap[halveVal]) {
					exchange(i, halveVal);
				}
			}
		}

	}
	public void exchange(int i, int j) {
		System.out.println("in exchange");
		int temp = minHeap[i];
		minHeap[i] = minHeap[j];
		minHeap[j] = temp;
	}
	public boolean isMinHeap() {

		int flag = 1;
		if (size == 1) {
			return true;
		}
		for (int i = size - 1; i > 0; i--) {
			int halveVal = ((i + 1) / 2) - 1;
			//System.out.println(maxHeap[i]+" - "+ maxHeap[halveVal]);
			if (minHeap[i] < minHeap[halveVal]) {
				flag = 0;
				break;
			}
		}
		if (flag == 0) {
			return false;
		}
		return true;
	}
	public void printMinHeap() {
		System.out.println(Arrays.toString(minHeap));
	}

}