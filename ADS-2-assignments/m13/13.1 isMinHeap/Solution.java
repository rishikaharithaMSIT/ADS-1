import java.util.Scanner;
import java.util.Arrays;
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String type = scan.nextLine();
		int testcases = Integer.parseInt(scan.nextLine());
		switch (type) {
		case "Integer" :
			String[] stringArr = scan.nextLine().split(",");
			Integer[] elements = Arrays.asList(stringArr).stream().map(Integer::valueOf).toArray(Integer[]::new);
			MinHeap<Integer> minHeap = new MinHeap<>(elements);
			minHeap.isMinHeap();
			System.out.println(Arrays.toString(elements));
			break;
		case "String" :
			break;
		case "Double" :
			break;
		case "Float" :
			break;
		}
	}
}

class MinHeap<Gen extends Comparable<Gen>> {
	Gen[] elements;
	int size;
	MinHeap(Gen[] array) {
		elements = (Gen[])array;
		size = elements.length;
		//System.out.println(Arrays.toString(elements));
	}
	public boolean isMinHeap() {
		int flag = 1;
		for (int i = size - 1; i > 0; i--) {
			int halveVal = ((i + 1) / 2) - 1;
			if (elements[i].compareTo(elements[halveVal]) < 1) {
				flag = 0;
				break;
			}
		}
		if (flag == 0) {
			return false;
		}
		return true;
	}
}