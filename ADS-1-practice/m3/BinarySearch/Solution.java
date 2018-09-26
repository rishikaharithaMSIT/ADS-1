import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		try {
			File file = new File("input.txt");
			Scanner scan =  new Scanner(file);
			String[] inputin = scan.nextLine().split(",");
			String[] input = inputin[0].split(" ");
			int element = Integer.parseInt(inputin[1]);
			int[] array = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
			Arrays.sort(array);
			int isFound = BinarySearch(element, array);
			System.out.println(Arrays.toString(array));
			System.out.println(element);
			System.out.println(isFound);

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	public static int BinarySearch(int ele, int[] array) {
		int start = 0;
		int end = array.length - 1;
		int mid = (start + end) / 2;
		if(array.length == 1 && ele == array[array.length-1]) return array.length-1; 
		while (start != end) {
			mid = (start + end) / 2;
			if (ele == array[mid]) {
				if (mid >= 1 && array[mid - 1] == array[mid]) {
					end = mid;
				} else {
					return mid;
				}
			} else if (ele < array[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}
}