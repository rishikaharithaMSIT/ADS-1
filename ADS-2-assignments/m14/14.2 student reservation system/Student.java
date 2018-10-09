class Student {
    private String name;
    private String date;
    private int marks1;
    private int marks2;
    private int marks3;
    private int total;
    private String category;

    Student(final String nme, final String dte, final int m1,
        final int m2, final int m3, final int tot, final String categry) {
        this.name = nme;
        this.date = dte;
        this.marks1 = m1;
        this.marks2 = m2;
        this.marks3 = m3;
        this.total = tot;
        this.category = categry;
    }
    public String getName() {
        return this.name;
    }
    public String getDate() {
        String revdate = "";
        revdate = date.substring(2 + 2 + 2) + "-"
        + date.substring(2 + 1, 2 + 2 + 1) + "-" + date.substring(0, 2);
        return revdate;
    }
    public int getMarks1() {
        return this.marks1;
    }
    public int getMarks2() {
        return this.marks2;
    }
    public int getMarks3() {
        return this.marks3;
    }
    public int getTotal() {
        return this.total;
    }
    public String getCategory() {
        return this.category;
    }
    public String print() {
        return this.getName() + "," + this.getTotal() + ","
        + this.getCategory();
    }
    public int compareTo(final Student that) {
        if (this.getTotal() > that.getTotal()) {
            return 1;
        } else if (this.getTotal() < that.getTotal()) {
            return -1;
        } else {
            if (this.getMarks3() > that.getMarks3()) {
                return 1;
            } else if (this.getMarks3() < that.getMarks3()) {
                return -1;
            } else {
                if (this.getMarks2() > that.getMarks2()) {
                    return 1;
                } else if (this.getMarks2() < that.getMarks2()) {
                    return -1;
                } else {
                    return compareDate(this.getDate(), that.getDate());
                }
            }
        }
    }
    public int compareDate(final String d1, final String d2) {
        int res = d1.compareTo(d2);
        if (res < 0) {
            return -1;
        } else {
            return 1;
        }
    }
}
