/**
 * Class for student.
 */
class Student implements Comparable<Student> {
	private String name;
	private int marks1;
	private int marks2;
	private int marks3;
	private int tmarks;
	private String rc;
	private int day;
	private int month;
	private int year;

	public String getName(){
		return name;
	}
	public int getMarks1() {
		return marks1;
	}
	public int getMarks2() {
		return marks2;
	}
	public int getMarks3() {
		return marks3;
	}
	public int getTotal() {
		return tmarks;
	}
	public String getRC() {
		return rc;
	}
	public int getDay() {
		return day;
	}
	public int getMonth() {
		return month;
	}
	public int getYear() {
		return year;
	}

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
		if (this.tmarks > other.getTotal()) {
			return 1;
		}
		if (this.tmarks < other.getTotal()) {
			return -1;
		}
		if (this.marks3 > other.getMarks3()) {
			return 1;
		}
		if (this.marks3 < other.getMarks3()) {
			return -1;
		}
		if (this.marks2 > other.getMarks2()) {
			return 1;
		}
		if (this.marks2 < other.getMarks2()) {
			return -1;
		}
		if (this.year > other.getYear()) {
			return 1;
		}
		if (this.year < other.getYear()) {
			return -1;
		}
		if (this.month > other.getMonth()) {
			return 1;
		}
		if (this.month < other.getMonth()) {
			return -1;
		}
		if (this.day < other.getDay()) {
			return 1;
		}
		if (this.day > other.getDay()) {
			return -1;
		}
		return 0;
	}
	public int compareAgain(Student other) {
		if ((this.getRC().equals("SC") || this.getRC().equals("ST") || this.getRC().equals("BC") && other.getRC().equals("Open"))) {
			return 1;
		}
		if ((other.getRC().equals("SC") || other.getRC().equals("ST") || other.getRC().equals("BC") && this.getRC().equals("Open"))) {
			return -1;
		}

		return 0;
	}
}