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
		if (this.month < other.month) return -1;
		if (this.day < other.day) return 1;
		if (this.day > other.day) return -1;
		

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