import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
public class Solution {
	static ArrayList<Student> students = new ArrayList<>();
	static ArrayList<Student> vacanciesList = new ArrayList<>();
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
			//System.out.println(Arrays.toString(tokens));
			Student s = new Student(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5], tokens[6]);
			students.add(s);
		}
		selectionSort();

		for (int i = 0; i < students.size(); i++) {
			System.out.println(students.get(i).name + "," + students.get(i).tmarks + "," + students.get(i).rc);
		}
		System.out.println();

		fillVacancies(vacancies, unres, bc, sc, st);

	}
	public static void fillVacancies(int vacancies, int unres, int bc, int sc, int st) {
		//add bc
		int u = 0;
		int b = 0;
		int c = 0;
		int t = 0;
		int v = 0;
		for (int i = 0; i < students.size(); i++) {
			if(u == unres) break;
				vacanciesList.add(students.get(i));
				u++;
				v++;
			
		}
		for (int i = 0; i < students.size(); i++) {
			if(b == bc) break;
			if(students.get(i).rc.equals("BC")) {
				if(!vacanciesList.contains(students.get(i))) {
					vacanciesList.add(students.get(i));
					b++;
					v++;
				}
				
			}
			
		}
		// add sc
		for (int i = 0; i < students.size(); i++) {
			if(c == sc) break;
			if(students.get(i).rc.equals("SC")) {
				if(!vacanciesList.contains(students.get(i))) {

					vacanciesList.add(students.get(i));
					c++;
					v++;
				}
			}
			
		}
		//add st
		for (int i = 0; i < students.size(); i++) {
			if(t == st) break;
			if(students.get(i).rc.equals("ST")) {
				if(!vacanciesList.contains(students.get(i))) {
					vacanciesList.add(students.get(i));
					t++;
					v++;
				}
			}
			
		}

		for (int i = 0; i < students.size(); i++) {
			if(v == vacancies) break;
			if(!vacanciesList.contains(students.get(i))) {
				vacanciesList.add(students.get(i));
				v++;
			}
			
		}
		
		sortAgain();

		for (int i = 0; i < vacanciesList.size(); i++) {
			if( i == vacancies) break;
			System.out.println(vacanciesList.get(i).name + "," + vacanciesList.get(i).tmarks + "," + vacanciesList.get(i).rc);
		}
		

	}
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
		if (this.month > other.month) return -1;
		if (this.month < other.month) return 1;
		if (this.day > other.day) return 1;
		if (this.day < other.day) return -1;
		

		return 0;
	}
	public int compareAgain(Student other) {
		if((this.rc.equals("SC") || this.rc.equals("ST") || this.rc.equals("BC") && other.rc.equals("Open"))) {
			return 1;
		}
		if((other.rc.equals("SC") || other.rc.equals("ST") || other.rc.equals("BC") && this.rc.equals("Open"))) {
			return -1;
		}
		
		return 0;
	}
}