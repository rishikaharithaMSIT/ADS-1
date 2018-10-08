import java.util.Scanner;
import java.util.Arrays;
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String type = scan.nextLine();
		int testcases = Integer.parseInt(scan.nextLine());
		switch(type) {
			case "Integer" :
				String[] stringArr = scan.nextLine().split(",");
				Integer[] elements = Arrays.asList(stringArr).stream().map(Integer::valueOf).toArray(Integer[]::new);
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

class MinHeap<Gen> {
	Gen[] elements;
	int size;
	MinHeap(Object[] array) {
		elements = (Gen[])array;
		size = 0;
		System.out.println(Arrays.toString(elements));
	}
	public void insert(Gen element) {
		elements[size] = element;
		swim();
	}
	public void swim() {

	}
}