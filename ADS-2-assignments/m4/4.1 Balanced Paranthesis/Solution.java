import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testcases = Integer.parseInt(scan.nextLine());
		while(scan.hasNext()) {
			String[] line = scan.nextLine().split("");
			System.out.println(Arrays.toString(line));
		}
	}
}