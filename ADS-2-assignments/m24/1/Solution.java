import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int datalen = Integer.parseInt(scan.nextLine());
        SeparateChainingHashST<Integer, Student> student
            = new SeparateChainingHashST<>();
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
                if (student.contains(key)) {
                    System.out.println(student.get(key).getName());
                } else {
                    System.out.println("Student doesn't exists...");
                }

            } else if (tokens[2].equals("2")) {
                int key = Integer.parseInt(tokens[1]);
                if (student.contains(key)) {
                    System.out.println(student.get(key).getMarks());
                } else {
                    System.out.println("Student doesn't exists...");
                }
            }

            testcases--;
        }

    }
}
/**
 * Class for student.
 */
class Student {
    /**
     * name.
     */
    private String name;
    /**
     * marks.
     */
    private double marks;
    /**
     * Student constructor.
     *
     * @param      n     { parameter_description }
     * @param      m     { parameter_description }
     */
    Student(final String n, final String m) {
        this.name  = n;
        this.marks = Double.parseDouble(m);
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return name;
    }
    public Double getMarks() {
        return marks;
    }
}
