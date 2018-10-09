import java.util.Arrays;
class HeapSort {	
	Student[] students;
	int size;
	HeapSort() {
		students = new Student[40];
		this.size = 0;
	}
	public void add(Student s) {
		students[size++] = s;
	}
	public int size() {
		return size;
	}
	public void sort() {
        int n = size;
        for (int k = n/2; k >= 1; k--) {
            sink(students, k, n);
        }
        while (n > 1) {
            swap(students, 1, n--);
            sink(students, 1, n);
        }
    }
    public void sink(Student[] students, int k, int n) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && less(students, j, j+1))  {
            	j++;
            }
            if (!less(students, k, j)) {
            	break;
            }
            swap(students, k, j);
            k = j;
        }
    }
    public boolean less(Student[] students, int i, int j) {
        return students[i - 1].compareTo(students[j-1]) >= 0;
    }
	public void swap(Student[] students, int j, int min) {
		Student temp = students[j - 1];
	    students[j - 1] = students[min - 1];
	    students[min - 1] = temp;
	}
	public String toString() {
		String str = "";
		for (int i = 0; i < size; i++) {
			str += students[i].getName() + "," + students[i].getTotal() +
			 "," + students[i].getCategory() + "\n";
		}
		return str;
	}
	public boolean contains(int[] arr, int s) {
		for (int i : arr) {
			if (s == i) {
				return true;
			}
		}
		return false;
	}
	public void vacancy1(int n) {
		for (int i = 0; i < n; i++) {
			System.out.println(students[i].getName() + "," + students[i].getTotal() +
			 "," + students[i].getCategory());
		}
	}
	
	public void vacancy2(int n, int n1, int n2, int n3) {
		int[] array = new int[n1 + n2 + n3];
       	int i = 0;
        for(int k = n;k < size; k++) {
            if(students[k].getCategory().equals("BC") && n1 > 0) {
                array[i++] = k;
                n1--;
            }
            else if(students[k].getCategory().equals("SC") && n2 > 0) {
                array[i++] = k;
                n2--;
            }
            else if(students[k].getCategory().equals("ST") && n3 > 0) {
                array[i++] = k;
                n3--;
            }
        }
        if (n1 > 0) {
           for (int k = n; k < size; k++) {
           if (students[k].getCategory().equals("Open") && n1 > 0) {
                   if (!contains(array, k)) {
                       array[i++] = k;
                       n1--;
                   }
               }
           }
       }
       if (n2 > 0) {
           for (int k = n; k < size; k++) {
           if (students[k].getCategory().equals("Open") && n2 > 0) {
                   if (!contains(array, k)) {
                       array[i++] = k;
                       n2--;
                   }
               }
           }
       }
       if (n3 > 0) {
           for (int k = n; k < size; k++) {
           if (students[k].getCategory().equals("Open") && n3 > 0) {
                   if (!contains(array, k)) {
                       array[i++] = k;
                       n3--;
                   }
               }
           }
       }
       Arrays.sort(array);
       for (int k = 0; k < array.length; k++) {
           System.out.println(students[array[k]].print());
       }
	}
}

