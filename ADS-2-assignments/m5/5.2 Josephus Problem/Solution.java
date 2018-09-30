import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
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
		String testcases = scan.nextLine();
		while (scan.hasNext()) {
			String[] line = scan.nextLine().split(" ");
			int people = Integer.parseInt(line[0]);
			int gap = Integer.parseInt(line[1]);
			Deque<Integer> que = new Deque<>();
			createCircle(que, people);
			que.josephus(people, gap);
			//q.printList();


		}
	}
	/**
	 * Creates a circle.
	 *
	 * @param      que       The quarter
	 * @param      people  The people
	 */
	public static void createCircle(final Deque<Integer> que,
	                                final int people) {
		for (int i = 0; i < people; i++) {
			que.push(i);
		}
	}
}
