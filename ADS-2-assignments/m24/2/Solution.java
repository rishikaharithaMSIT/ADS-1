import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int datalen = Integer.parseInt(scan.nextLine());
		RedBlackBST<Student, Integer> student = new RedBlackBST<>();
		Student s = null;
		while (datalen > 0) {
			String[] line = scan.nextLine().split(",");
			s = new Student(line[1], line[2], line[0]);
			student.put(s, Integer.parseInt(line[0]));

			datalen--;
		}
		
		int testcases = Integer.parseInt(scan.nextLine());
		while (testcases > 0) {
			String[] tokens = scan.nextLine().split(" ");
			if (tokens[0].equals("BE")) {
				//int key = Integer.parseInt(tokens[1]);
				double lower = Double.parseDouble(tokens[1]);
				double upper = Double.parseDouble(tokens[2]);
				//System.out.println("here");
				for (Student each : student.keys()) {
					//System.out.println("hi");
					//System.out.println(each);
					if (each.getMarks() >= lower && each.getMarks() <= upper) {
						System.out.println(each.getName());
					}
				}
				//System.out.println("----");

			} else if (tokens[0].equals("LE")) {
				double limit = Double.parseDouble(tokens[1]);
				for (Student each : student.keys()) {
					if (each.getMarks() <= limit) {
						System.out.println(each.getName());
					}
				}
				//System.out.println("----");
			} else if (tokens[0].equals("GE")) {
				double limit = Double.parseDouble(tokens[1]);
				for (Student each : student.keys()) {
					if (each.getMarks() >= limit) {
						System.out.println(each.getName());
					}
				}
				//System.out.println("----");
			}

			testcases--;
		}

	}
}
/**
 * Class for student.
 */
class Student implements Comparable<Student>{
	/**
	 * name.
	 */
	private String name;
	/**
	 * marks.
	 */
	private double marks;
	/**
	 * roll number.
	 */
	private int roll;
	/**
	 * Constructs the object.
	 *
	 * @param      n     { parameter_description }
	 * @param      m     { parameter_description }
	 * @param      r     { parameter_description }
	 */
	Student(String n, String m, String r) {
		this.name  = n;
		this.marks = Double.parseDouble(m);
		this.roll = Integer.parseInt(r);
	}
	/**
	 * compareTo function.
	 *
	 * @param      other  The other
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int compareTo(Student other) {
		if (this.marks > other.marks) return 1;
		if (this.marks < other.marks) return -1;		
		if (this.roll > other.roll) return 1;
		if (this.roll < other.roll) return -1;

		return 0;
	}
	/**
	 * Gets the name.
	 *
	 * @return     The name.
	 */
	public String getName(){
		return name;
	}
	/**
	 * Gets the marks.
	 *
	 * @return     The marks.
	 */
	public Double getMarks() {
		return marks;
	}
	/**
	 * Gets the roll.
	 *
	 * @return     The roll.
	 */
	public Integer getRoll() {
		return roll;
	}
}

