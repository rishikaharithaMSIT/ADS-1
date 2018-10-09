import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		MaxHeap mh = new MaxHeap(10);
		mh.insert(12);
		mh.printMaxHeap();
		mh.insert(13);
		mh.printMaxHeap();
		mh.insert(11);
		mh.printMaxHeap();
		mh.insert(14);
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
		while(!isMinHeap()) {
			for (int i = size - 1; i > 0; i--) {
			int halveVal = ((i + 1) / 2) - 1;
			if (maxHeap[i] > maxHeap[halveVal]) {
				exchange(i, halveVal);
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
	public boolean isMinHeap() {
        int flag = 1;
        if (size == 1) {
            return true;
        }
        for (int i = size - 1; i > 0; i--) {
            int halveVal = ((i + 1) / 2) - 1;
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