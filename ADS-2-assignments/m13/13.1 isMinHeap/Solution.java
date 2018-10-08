import java.util.Scanner;
import java.util.Arrays;
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String type = scan.nextLine();
		int testcases = Integer.parseInt(scan.nextLine());
		while (testcases > 0) {
			switch (type) {
			case "Integer" :
				String[] stringArr = scan.nextLine().split(",");
				Integer[] elements = Arrays.asList(stringArr).stream().map(Integer::valueOf).toArray(Integer[]::new);
				MinHeap<Integer> minHeap = new MinHeap<>(elements);
				boolean isMinHeap = minHeap.isMinHeap();
				System.out.println(isMinHeap);
				//System.out.println(Arrays.toString(elements));
				break;
			case "String" :
				stringArr = scan.nextLine().split(",");
				MinHeap<String> minHeapString = new MinHeap<>(stringArr);
				isMinHeap = minHeapString.isMinHeap();
				System.out.println(isMinHeap);
				break;
			case "Float" :
				stringArr = scan.nextLine().split(",");
				if(stringArr.equals("")) {
					System.out.println("false");
					break;
				}
				Float[] elementsF = Arrays.asList(stringArr).stream().map(Float::valueOf).toArray(Float[]::new);
				MinHeap<Float> minHeapFloat = new MinHeap<>(elementsF);
				isMinHeap = minHeapFloat.isMinHeap();
				System.out.println(isMinHeap);
				break;
			case "Double" :
				stringArr = scan.nextLine().split(",");
				Double[] elementsD = Arrays.asList(stringArr).stream().map(Double::valueOf).toArray(Double[]::new);
				MinHeap<Double> minHeapDouble = new MinHeap<>(elementsD);
				isMinHeap = minHeapDouble.isMinHeap();
				System.out.println(isMinHeap);
				break;
			}
			testcases--;
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
		if(size == 1) {
			return true;
		}
		for (int i = size - 1; i > 0; i--) {
			int halveVal = ((i + 1) / 2) - 1;
			if (elements[i].compareTo(elements[halveVal]) < 0 ) {
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