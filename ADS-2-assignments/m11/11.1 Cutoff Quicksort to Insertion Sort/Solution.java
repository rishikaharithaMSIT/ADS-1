import java.util.Scanner;
import java.util.Arrays;
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testcases = Integer.parseInt(scan.nextLine());
		while (scan.hasNext()) {
			int cutoff = Integer.parseInt(scan.nextLine());
			Comparable[] array = scan.nextLine().split(" ");
			sort(array, 0, array.length - 1,cutoff);
			System.out.println(Arrays.toString(array) + " jcbdkcj");
			break;
		}
	}
	public static void insertionSort(Comparable[] array, int low , int high) {
		System.out.println("insertionSort called");
        int n = high;
        for (int i = low+1; i < n; ++i) {
            Comparable key = array[i];
            int j = i - 1;
            while (j >= low && (array[j].compareTo(key)) > 0) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }
	// public static void
	public static void sort(Comparable[] array, int low, int high, int cutoff) {
		if (low >= high) {
			return;
		}
		int partition = quickSort(array, low, high,cutoff);
		//System.out.println(partition);		
		sort(array, low, partition - 1, cutoff);
		sort(array, partition + 1, high,cutoff);


	}
	public static int quickSort(Comparable[] array, int low, int high, int cutoff) {
		
		Comparable pivot = array[low];
		int p1 = low;
		int p2 = high;
		if(high-low+1 <= cutoff){
			insertionSort(array,low,high);
		} else {
			while (p2 != p1 && p1 < p2) {
			while (p2 >= low && array[p2].compareTo(pivot) > 0) {
				//System.out.println(array[p2] + " is greater than " + pivot + " p2: " + p2);
				p2--;
			}
			while (p1 <= high && array[p1].compareTo(pivot) <= 0) {
				//System.out.println(array[p1] + " is smaller than " + pivot + " p1: " + p1);
				p1++;
			}
			if (p2 < p1) {
				p1--;
				break;
			}
			//System.out.println("excahnging : " + array[p1]+ " - " + array[p2]);
			Comparable temp = array[p1];
			array[p1] = array[p2];
			array[p2] = temp;
			p1++;
			p2--;
			//System.out.println("p1 : " +p1+ " p2 : " + p2);
		}
		//System.out.println("Exchanging");
		array[low] = array[p1];
		//System.out.println(array[low] + " low");
		array[p1] = pivot;
		//System.out.println(array[p1] + " p1");
		System.out.println(Arrays.toString(array));
		}
		
		return p1;
	}
}
