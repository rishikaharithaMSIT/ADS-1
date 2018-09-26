import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) {
			int size1 = Integer.parseInt(scan.nextLine());
			int size2 = Integer.parseInt(scan.nextLine());;
			String[] in1 = scan.nextLine().split(",");
			String[] in2 = scan.nextLine().split(",");
			int[] array1 = Arrays.stream(in1).mapToInt(Integer::parseInt).toArray();
			int[] array2 = Arrays.stream(in1).mapToInt(Integer::parseInt).toArray();
			int sizet = size1+size2;
			int[] newarr = new int[sizet];
			System.out.println(sizet + "size");
			int one = 0;
			int two = size1;
			for(int i =0; i < size1;i++){
				newarr[one] = array1[i];
				one++;
				System.out.println(one);

			}
			for(int i =0; i < size2;i++){
				newarr[one] = array2[i];
				
				one++;
				System.out.println(one);
			}

			for(int i =0, j= size1; i < sizet;) {
				if(array1[i] > array1[j]) {
					System.out.println(array1[j]);
					if (j < sizet) j++;
				}
				else {
					System.out.println(array1[i]);
					if (i < size1) i++;
				}
			}
		}
	}
}