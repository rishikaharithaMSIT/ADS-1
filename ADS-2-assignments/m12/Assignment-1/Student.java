/**
 * Class for student.
 */
class Student implements Comparable<Student> {
    /**
     * name.
     */
    private String name;
    /**
     * marks1.
     */
    private int marks1;
    /**
     * marks2.
     */
    private int marks2;
    /**
     * marks3.
     */
    private int marks3;
    /**
     * markst.
     */
    private int tmarks;
    /**
     * rc
     */
    private String rc;
    /**
     * day.
     */
    private int day;
    /**
     * month.
     */
    private int month;
    /**
     * year.
     */
    private int year;
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return name;
    }
    /**
     * Gets the marks 1.
     *
     * @return     The marks 1.
     */
    public int getMarks1() {
        return marks1;
    }
    /**
     * Gets the marks 2.
     *
     * @return     The marks 2.
     */
    public int getMarks2() {
        return marks2;
    }
    /**
     * Gets the marks 3.
     *
     * @return     The marks 3.
     */
    public int getMarks3() {
        return marks3;
    }
    /**
     * Gets the total.
     *
     * @return     The total.
     */
    public int getTotal() {
        return tmarks;
    }
    /**
     * Gets the rc.
     *
     * @return     The rc.
     */
    public String getRC() {
        return rc;
    }
    /**
     * Gets the day.
     *
     * @return     The day.
     */
    public int getDay() {
        return day;
    }
    /**
     * Gets the month.
     *
     * @return     The month.
     */
    public int getMonth() {
        return month;
    }
    /**
     * Gets the year.
     *
     * @return     The year.
     */
    public int getYear() {
        return year;
    }


    public void setName(String nam) {
        name = nam ;
    }
    public void setMarks1(int m1) {
        marks1 = m1;
    }
    
    public void setMarks2(int m2) {
        marks2 = m2;
    }
    
    public void setMarks3(int m3) {
        marks3 = m3;
    }
    public void setMarkst(int mt) {
        tmarks = mt;
    }
    public void setRC(String r) {
        rc = r;
    }
    /**
     * Constructs the object.
     *
     * @param      name    The name
     * @param      dob     The dob
     * @param      marks1  The marks 1
     * @param      marks2  The marks 2
     * @param      marks3  The marks 3
     * @param      tmarks  The tmarks
     * @param      rc      The rectangle
     */
    Student(final String name,
            final String dob, final String marks1,
            final String marks2, final String marks3,
            final String tmarks, final String rc) {
        setName(name);
        String[] d = dob.split("-");
        this.day = Integer.parseInt(d[0]);
        this.month = Integer.parseInt(d[1]);
        this.year = Integer.parseInt(d[2]);
        setMarks1(Integer.parseInt(marks1));
        setMarks2(Integer.parseInt(marks2));
        setMarks3(Integer.parseInt(marks3));
        setMarkst(Integer.parseInt(tmarks));
        
        this.rc = rc;

    }
    /**
     * { function_description }.
     *
     * @param      other  The other
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Student other) {
        if (this.getTotal() > other.getTotal()) {
            return 1;
        }
        if (this.getTotal() < other.getTotal()) {
            return -1;
        }
        if (this.getMarks3() > other.getMarks3()) {
            return 1;
        }
        if (this.getMarks3() < other.getMarks3()) {
            return -1;
        }
        if (this.getMarks2() > other.getMarks2()) {
            return 1;
        }
        if (this.getMarks2() < other.getMarks2()) {
            return -1;
        }
        if (this.getYear() > other.getYear()) {
            return 1;
        }
        if (this.getYear() < other.getYear()) {
            return -1;
        }
        if (this.getMonth() > other.getMonth()) {
            return 1;
        }
        if (this.getMonth() < other.getMonth()) {
            return -1;
        }
        if (this.getDay() < other.getDay()) {
            return 1;
        }
        if (this.getDay() > other.getDay()) {
            return -1;
        }
        return 0;
    }
    /**
     * { function_description }.
     *
     * @param      other  The other
     *
     * @return     { description_of_the_return_value }
     */
    public int compareAgain(final Student other) {
        if ((this.getRC().equals("SC") || this.getRC().equals("ST")
                || this.getRC().equals("BC")
                && other.getRC().equals("Open"))) {
            return 1;
        }
        if ((other.getRC().equals("SC")
                || other.getRC().equals("ST") || other.getRC().equals("BC")
                && this.getRC().equals("Open"))) {
            return -1;
        }

        return 0;
    }
}