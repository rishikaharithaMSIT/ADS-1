import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		try {
			File file = new File("input.txt");
			Scanner scan =  new Scanner(file);
			String[] input = scan.nextLine().split(" ");
			int[] array = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
			Arrays.sort(array);
			int noOfPairs = 0;
			for(int i=0;i<array.length;i++) {
				int count = 1;
				while(i < array.length - 1 && array[i] == array[i+1]) {
					count++;
					i++;
				}
				//System.out.println("count : " + count);
				int pairs = count * (count - 1)/2;
				noOfPairs += pairs;
				
				//System.out.println(array[i] + " " + count);
				
			}
			System.out.println(noOfPairs);
			



		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
}