import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int size1 = Integer.parseInt(scan.nextLine());
			int size2 = Integer.parseInt(scan.nextLine());;
			String in1 = scan.nextLine();
			String in2 = scan.nextLine();
			String in3 = null;
			if (in1.equals("")) {
				in3 = in2;
			} else if (in2.equals("")) {
				in3 = in1;
			} else {
				in3 = in1 + "," + in2;
			}

			//System.out.println(in3);
			String[] inp = in3.split(",");
			int[] array1 = Arrays.stream(inp).mapToInt(Integer::parseInt).toArray();
			int sizet = size1 + size2;
			//System.out.println(sizet);
			// for(int i =0,j = size1;j < sizet;) {
			// 	if(array1[i] > array1[j]) {
			// 		System.out.println(array1[j] + " " + j);
			// 		j++;

			// 	} else {
			// 		System.out.println(array1[i] + " " + i);
			// 		if (i < size1)i++;

			// 	}
			// }
			int i = 0;
			int j = size1;
			int c = 0;
			while (c < sizet) {
				if (i < size1) {
					if (array1[i] < array1[j]) {
						System.out.print(array1[i] + ",");
						c++;
						if (i <= size1) i++;
					} else if (array1[i] > array1[j]) {
						System.out.print(array1[j] + ",");
						c++;
						j++;
					}
				} else if (j < sizet) {
					if (j == sizet - 1) {
						System.out.print(array1[j]);
					} else {
						System.out.print(array1[j] + ",");
					}

					j++;
					c++;
				}

			}
			//System.out.println(array1[sizet-1]);

		}
	}
}