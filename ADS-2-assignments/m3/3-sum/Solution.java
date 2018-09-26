import java.util.*;
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = Integer.parseInt(scan.nextLine());
		long[] array = new long[size];
		for (int i = 0; i < size; i++) {
			array[i] = Long.parseLong(scan.nextLine());
		}
		Arrays.sort(array);
		//System.out.println(Arrays.toString(array));
		int count = 0;
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {

				long sum = array[i] + array[j];
				long abc  = 0 - sum;
				long[] newArray = Arrays.copyOfRange(array, j + 1, size);
				int isFound = Arrays.binarySearch(newArray, (int)abc);
				//System.out.println(sum+" - "+ abc);
				//System.out.println(isFound);
				if (isFound > 0) {
					// System.out.println(count + " co");
					count++;
				}
			}
		}
		// System.out.println("hai");
		System.out.println(count);

	}
	// public static long BinarySearch(long ele, long[] array) {
	// 	int start = 0;
	// 	int end = array.length - 1;
	// 	int mid = ((start + end) / 2);
	// 	if(array.length == 1 && ele == array[array.length-1]) return array.length-1;
	// 	while (start != end) {
	// 		mid = (start + end) / 2;
	// 		if (ele == array[mid]) {
	// 			if (mid >= 1 && array[mid - 1] == array[mid]) {
	// 				end = mid;
	// 			} else {
	// 				return mid;
	// 			}
	// 		} else if (ele < array[mid]) {
	// 			end = mid - 1;
	// 		} else {
	// 			start = mid + 1;
	// 		}
	// 	}
	// 	return -1;
	// }

}