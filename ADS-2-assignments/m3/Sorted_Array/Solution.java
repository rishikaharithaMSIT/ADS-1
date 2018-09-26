import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) {
			int size1 = Integer.parseInt(scan.nextLine());
			int size2 = Integer.parseInt(scan.nextLine());;
			String in1 = scan.nextLine();
			String in2 = scan.nextLine();
			String in3 = in1+","+in2;
			String[] inp = in3.split(",");
			int[] array1 = Arrays.stream(inp).mapToInt(Integer::parseInt).toArray();
			int sizet = size1+size2;

			for(int i =0, j= size1; i < size1 && j <sizet;) {
				if(array1[i] > array1[j]) {
					System.out.println(array1[j]);
					j++;
				}
				else {
					System.out.println(array1[i]);
					if(i < size1) i++;
				}
			}
		}
	}
}