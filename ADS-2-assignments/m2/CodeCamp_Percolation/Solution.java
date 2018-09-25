import java.util.Scanner;
import java.util.Arrays;
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		Percolation percolation = new Percolation(size);
		while (scan.hasNext()) {
			percolation.open(scan.nextInt(), scan.nextInt());
		}
		System.out.println(percolation.percolates());
	}
}