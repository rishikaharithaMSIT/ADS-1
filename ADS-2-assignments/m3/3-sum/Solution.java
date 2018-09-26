import java.util.*;
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = Integer.parseInt(scan.nextLine());
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = Integer.parseInt(scan.nextLine());
		}
		Arrays.sort(array);
		//System.out.println(Arrays.toString(array));
		int count = 0;
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				int sum = array[i] + array[j];
				boolean isFound = BinarySearch(0 - sum, array);
				if (isFound) count++;
			}
		}
		System.out.println("hai");
		System.out.println(count);

	}
	public static boolean BinarySearch(int ele, int[] array) {
		int start = 0;
		int end = array.length - 1;
		int mid = (start + end) / 2;
		
		while (start != end) {
			mid = (start + end) / 2;
			if (ele == array[mid]) {
				return true;
			}
			if (ele < array[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return false;
	}

}