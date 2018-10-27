import java.util.Scanner;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int datalen = Integer.parseInt(scan.nextLine());
		SeparateChainingHashST<Integer, Student> student = new SeparateChainingHashST<>();
		Student s = null;
		while (datalen > 0) {
			String[] line = scan.nextLine().split(",");
			s = new Student(line[1], line[2]);
			student.put(Integer.parseInt(line[0]), s);
			datalen--;
		}
		int testcases = Integer.parseInt(scan.nextLine());
		while (testcases > 0) {
			String[] tokens = scan.nextLine().split(" ");
			if (tokens[2].equals("1")) {
				int key = Integer.parseInt(tokens[1]);
				if(student.contains(key)) {
					System.out.println(student.get(key).name);
				}else {
					System.out.println("Student doesn't exists...");
				}
				
			} else if (tokens[2].equals("2")) {
				int key = Integer.parseInt(tokens[1]);
				if(student.contains(key)) {
					System.out.println(student.get(key).marks);
				}else {
					System.out.println("Student doesn't exists...");
				}
			}

			testcases--;
		}

	}
}
class Student {
	String name;
	double marks;
	Student(String n, String m) {
		this.name  = n;
		this.marks = Double.parseDouble(m);
	}
}
