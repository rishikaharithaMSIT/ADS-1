import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
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
	 * students array List.
	 */
	private static ArrayList<Student> students = new ArrayList<>();
	/**
	 *  Vacancies array list.
	 */
	private static ArrayList<Student> vacanciesList = new ArrayList<>();

	/**
	 * main to read input.
	 * Time Complexity : O(N).
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int noLines = Integer.parseInt(scan.nextLine());
		int vacancies = Integer.parseInt(scan.nextLine());
		int unres = Integer.parseInt(scan.nextLine());
		int bc = Integer.parseInt(scan.nextLine());
		int sc = Integer.parseInt(scan.nextLine());
		int st = Integer.parseInt(scan.nextLine());

		while (scan.hasNext()) {
			String[] tokens = scan.nextLine().split(",");
			//System.out.println(Arrays.toString(tokens));
			Student s = new Student(tokens[0], tokens[1],
			                        tokens[2], tokens[3], tokens[4],
			                        tokens[5], tokens[6]);
			students.add(s);
		}
		selectionSort();

		for (int i = 0; i < students.size(); i++) {
			System.out.println(students.get(i).getName() + ","
			                   + students.get(i).getTotal() + ","
			                   + students.get(i).getRC());
		}
		System.out.println();

		fillVacancies(vacancies, unres, bc, sc, st);

	}
	/**
	 * fill vacancies.
	 *
	 * @param      vacancies  The vacancies
	 * @param      unres      The unres
	 * @param      bc         { parameter_description }
	 * @param      sc         The screen
	 * @param      st         { parameter_description }
	 */
	public static void fillVacancies(int vacancies,
	                                 int unres, int bc, int sc, int st) {
		//add bc
		int unres1 = 0;
		int bc1 = 0;
		int sc1 = 0;
		int st1 = 0;
		int vacancies1 = 0;
		for (int i = 0; i < students.size(); i++) {
			if (unres1 == unres) break;
			vacanciesList.add(students.get(i));
			unres1++;
			vacancies1++;

		}
		for (int i = 0; i < students.size(); i++) {
			if (bc1 == bc) break;
			if (students.get(i).getRC().equals("BC")) {
				if (!vacanciesList.contains(students.get(i))) {
					vacanciesList.add(students.get(i));
					bc1++;
					vacancies1++;
				}

			}

		}
		// add sc
		for (int i = 0; i < students.size(); i++) {
			if (sc1 == sc) break;
			if (students.get(i).getRC().equals("SC")) {
				if (!vacanciesList.contains(students.get(i))) {

					vacanciesList.add(students.get(i));
					sc1++;
					vacancies1++;
				}
			}

		}
		//add st
		for (int i = 0; i < students.size(); i++) {
			if (st1 == st) break;
			if (students.get(i).getRC().equals("ST")) {
				if (!vacanciesList.contains(students.get(i))) {
					vacanciesList.add(students.get(i));
					st1++;
					vacancies1++;
				}
			}

		}

		for (int i = 0; i < students.size(); i++) {
			if (vacancies1 == vacancies) break;
			if (!vacanciesList.contains(students.get(i))) {
				vacanciesList.add(students.get(i));
				vacancies1++;
			}

		}

		sortAgain();

		for (int i = 0; i < vacanciesList.size(); i++) {
			if ( i == vacancies) break;
			System.out.println(vacanciesList.get(i).getName()
			                   + "," + vacanciesList.get(i).getTotal()
			                   + "," + vacanciesList.get(i).getRC());
		}


	}
	/**
	 * sort again.
	 */
	public static void sortAgain() {
		for (int i = vacanciesList.size() - 1; i >= 0; i--) {
			Student max = vacanciesList.get(i);
			int index = -1;
			for (int j = i - 1; j >= 0; j--) {
				if (max.compareTo(vacanciesList.get(j)) == 1) {
					max = vacanciesList.get(j);
					index = j;
				}
			}
			Student temp = vacanciesList.get(i);
			vacanciesList.set(i, max);
			if (index != -1) {
				vacanciesList.set(index, temp);
			}
		}
	}
	/**
	 * selction sort
	 */
	public static void selectionSort() {
		for (int i = students.size() - 1; i >= 0; i--) {
			Student max = students.get(i);
			int index = -1;
			for (int j = i - 1; j >= 0; j--) {
				if (max.compareTo(students.get(j)) == 1) {
					max = students.get(j);
					index = j;
				}
			}
			Student temp = students.get(i);
			students.set(i, max);
			if (index != -1) {
				students.set(index, temp);
			}
		}
	}

}
