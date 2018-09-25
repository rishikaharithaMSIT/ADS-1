import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for solution.
 */
public class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {

	}

	/**
	 * { function_description }.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		Percolation percolation = new Percolation(size);
		while (scan.hasNext()) {
			percolation.open(scan.nextInt(), scan.nextInt());
		}
		System.out.println(percolation.percolates());
	}
}