import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {
		//unused.
	}
	/**
	 * main method to read input.
	 * Time Complexity : N (one while loop).
	 *
	 * @param      args  command line arguments (not used)
	 */
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int testcases = Integer.parseInt(scan.nextLine());
		Steque<Integer> st = new Steque<>();
		while (scan.hasNext()) {
			String line =  scan.nextLine();
			if (line.equals("")) {
				System.out.println();
				st = new Steque<Integer>();

			}
			String[] tokens = line.split(" ");
			switch (tokens[0]) {
			case "push":
				st.push(Integer.parseInt(tokens[1]));
				st.printList();
				break;
			case "enqueue":
				st.enqueue(Integer.parseInt(tokens[1]));
				st.printList();
				break;
			case "pop":
				st.pop();
				st.printList();
				break;
			default:
			}
		}
	}
}
