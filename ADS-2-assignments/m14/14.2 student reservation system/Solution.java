import java.util.Scanner;

public final class Solution {

	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		HeapSort sort = new HeapSort();
		int n = sc.nextInt();
		int noOfVacancies = sc.nextInt();
		int unres = sc.nextInt();
		int bc = sc.nextInt();
		int t = sc.nextInt();
		int c = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String line = sc.nextLine();
			String[] tokens = line.split(",");
			Student student = new Student(tokens[0], tokens[1],
			                              Integer.parseInt(tokens[2]),
			                              Integer.parseInt(tokens[3]),
			                              Integer.parseInt(tokens[4]),
			                              Integer.parseInt(tokens[5]),
			                              tokens[6]);
			sort.add(student);
		}
		sort.sort();
		System.out.println(sort.toString());
		sort.vacancy1(unres);
		sort.vacancy2(unres, bc, t, c);


	}
}
