import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		MaxHeap mh = new MaxHeap(10);
		mh.insert(12);
		mh.printMaxHeap();
		mh.insert(13);
		mh.printMaxHeap();
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
	public void swim() {
		for (int i = size - 1; i > 0; i--) {
			int halveVal = ((i + 1) / 2) - 1;
			if (maxHeap[i] < maxHeap[halveVal]) {
				exchange(i, halveVal);
			}
		}
	}
	public void exchange(int i, int j) {
		int temp = maxHeap[i];
		maxHeap[i] = maxHeap[j];
		maxHeap[j] = temp;
	}
	public void printMaxHeap() {
		System.out.println(Arrays.toString(maxHeap));
	}

}