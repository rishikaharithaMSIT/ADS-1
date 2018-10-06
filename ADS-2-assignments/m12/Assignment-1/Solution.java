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

		while(scan.hasNext()) {
			String[] tokens = scan.nextLine().split(",");
			System.out.println(Arrays.toString(tokens));
			Student s = new Student(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4],tokens[5],tokens[6]);
			students.add(s);
		}
	}
}
class Student {
	String name;
	int marks1;
	int marks2;
	int marks3;
	int tmarks;
	String rc;
	int day;
	int month;
	int year;

	Student(String name,String dob, String marks1, String marks2, String marks3, String tmarks, String rc) {
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
}