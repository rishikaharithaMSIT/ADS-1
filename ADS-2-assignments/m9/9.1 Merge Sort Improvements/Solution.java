import java.util.ArrayList;
import java.util.List;
public class Solution {

	public static void main(String[] args) {
		int[] list = new int[100];
		int low  = 0;
		int high = 10;
		list = sort(list, low, high);


	}
	public static int[] sort(int[] list, int low, int high) {
		//List aux = list.subList(low, high+1);
		boolean sorted = isSorted(list);
		if (sorted) {
			System.out.println("Array is already sorted. So, skipped the call to merge...");
			return list;
		}
		if(low <= high) {

		}
		int mid = (low + high) / 2;
		int[] l1 = sort(list,low,mid);
		int[]l2 = sort(list,mid+1,high);
		// merge
		return list;

	}

	public static boolean isSorted(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i+1]) return false;
		}
		return true;
	}

	// public static void insertionSort() {
	// 	for (int i = cricketList.size() - 1; i >= 0; i--) {
	// 		Cricket elem = cricketList.get(i);
	// 		for (int j = i + 1; j <= cricketList.size() - 1; j++) {
	// 			if (elem.compareTo(cricketList.get(j)) == -1) {
	// 				Cricket temp = cricketList.get(j);
	// 				cricketList.set(j, elem);
	// 				cricketList.set(j - 1, temp);
	// 			}
	// 		}

	// 	}

	// }
}


// class CompareVals implements Comparable<Integer> {
// 	int value;


// 	public int compareTo(Interger other) {
// 		if (this.value > other.value) return 1;
// 		if (this.value < other.value) return -1;
// 		return 0;
// 	}

// }
