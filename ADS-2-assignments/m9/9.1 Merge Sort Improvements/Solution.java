import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
public class Solution {

	public static void main(String[] args) {
		// String[] list = new String[9];
		// list[0] = "1";
		// list[1] = "2";
		// list[2] = "4";
		// list[3] = "4";
		// list[4] = "5";
		// list[5] = "6";
		// list[6] = "7";
		// list[7] = "8";
		// list[8] = "9";
		// i
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) {
			String[] list = scan.nextLine().split(",");
			int low  = 0;
			int high = 8;
			list  = sort(list, low, high);
			System.out.println(Arrays.toString(list)); 
		}


	}
	public static String[] sort(String[] list, int low, int high) {
		//List aux = list.subList(low, high+1);
		String[] aux = Arrays.copyOfRange(list, low, high + 1);
		boolean sorted = isSorted(list);
		if(aux.length < 8) {
			System.out.println("Insertion sort method invoked...");
			return insertionSort(aux);
		}
		// if (sorted) {
		// 	System.out.println("Array is already sorted. So, skipped the call to merge...");
		// 	return list;
		// }
		
			if (low + 1 >= high) {
				if (aux.length == 2) {
					if (aux[0].compareTo(aux[1]) > 0 ) {
						String temp = aux[0];
						aux[0] = aux[1];
						aux[1] = temp;
					}
				}
				System.out.println(Arrays.toString(aux));
				return aux;
			}
		int mid = (low + high) / 2;

		String[] a1 = sort(list, low, mid);

		//System.out.println("sort1 " +  Arrays.toString(a1) + " " + low + " " + mid);
		String[] a2 = sort(list, mid + 1, high);

		//System.out.println("sort2 " +  Arrays.toString(a2) + " " + (mid + 1) + " " + high);
		String[] a3 = merge(a1, a2);
		//System.out.println("merge " +  Arrays.toString(a3));
		return a3;

	}
	public static String[] merge(String[] arr1, String[] arr2) {
		//System.out.println("in merge function - " + Arrays.toString(a1) + " - "+ Arrays.toString(a2));
		int t = arr1.length + arr2.length;
		int n1 = arr1.length;
		int n2 = arr2.length;
		String[] arr3 = new String[t];
		int i = 0, j = 0, k = 0;

		// Traverse both array
		while (i < n1 && j < n2) {
			if (arr1[i].compareTo(arr2[j]) < 0 )
				arr3[k++] = arr1[i++];
			else
				arr3[k++] = arr2[j++];
		}
		while (i < n1)
			arr3[k++] = arr1[i++];
		while (j < n2)
			arr3[k++] = arr2[j++];
		return arr3;
	}
	public static boolean isSorted(String[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i].compareTo(array[i + 1]) > 0 ) return false;
		}
		return true;
	}

	public static String[] insertionSort(String[] list) {
		for (int i = list.length - 1; i >= 0; i--) {
			String elem = list[i];
			for (int j = i + 1; j <= list.length - 1; j++) {
				if (elem.compareTo(list[j]) == -1) {
					String temp = list[j];
					list[j] =  elem;
					list[j - 1] = temp;
				}
			}

		}
		return list;
	}
}


// class CompareVals implements Comparable<Integer> {
// 	int value;


// 	public int compareTo(Interger other) {
// 		if (this.value > other.value) return 1;
// 		if (this.value < other.value) return -1;
// 		return 0;
// 	}

// }
