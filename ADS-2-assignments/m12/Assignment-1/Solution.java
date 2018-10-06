import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
public class Solution {
	static ArrayList<Student> students = new ArrayList<>();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int noLines = Integer.parseInt(scan.nextLine());
		int vacancies = Integer.parseInt(scan.nextLine());
		int unres = Integer.parseInt(scan.nextLine());
		int bc = Integer.parseInt(scan.nextLine());
		int sc = Integer.parseInt(scan.nextLine());
		int st = Integer.parseInt(scan.nextLine());

		while (scan.hasNext()) {
			String[] tokens = scan.nextLine().split(",");
			System.out.println(Arrays.toString(tokens));
			Student s = new Student(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5], tokens[6]);
			students.add(s);
		}
		selectionSort();

		for (int i = 0; i < students.size() - 1; i++) {
			System.out.print(students.get(i).name + ",");
		}
		System.out.print(students.get(students.size() - 1).name);
		System.out.println();

	}
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
class Student implements Comparable<Student> {
	String name;
	int marks1;
	int marks2;
	int marks3;
	int tmarks;
	String rc;
	int day;
	int month;
	int year;

	Student(String name, String dob, String marks1, String marks2, String marks3, String tmarks, String rc) {
		this.name = name;
		String[] d = dob.split("-");
		this.day = Integer.parseInt(d[0]);
		this.month = Integer.parseInt(d[1]);
		this.year = Integer.parseInt(d[2]);
		this.marks1 = Integer.parseInt(marks1);
		this.marks2 = Integer.parseInt(marks2);
		this.marks3 = Integer.parseInt(marks3);
		this.tmarks = Integer.parseInt(tmarks);
		this.rc = rc;

	}
	public int compareTo(Student other) {
		if (this.tmarks > other.tmarks) return 1;
		if (this.tmarks < other.tmarks) return -1;
		if (this.marks3 > other.marks3) return 1;
		if (this.marks3 < other.marks3) return -1;
		if (this.marks2 > other.marks2) return 1;
		if (this.marks2 < other.marks2) return -1;
		if (this.year > other.year) return 1;
		if (this.year < other.year) return -1;
		if (this.month > other.month) return 1;
		if (this.month > other.month) return -1;
		if (this.day > other.day) return 1;
		if (this.day < other.day) return -1;
		return 0;
	}
}