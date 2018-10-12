import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class CubeSum implements Comparable<CubeSum> {
    private final int sum;
    private final int i;
    private final int j;

    public CubeSum(int i, int j) {
        this.sum = i * i * i + j * j * j;
        this.i = i;
        this.j = j;
    }

    public int compareTo(CubeSum that) {
        if (this.sum < that.sum) return -1;
        if (this.sum > that.sum) return +1;
        return 0;
    }

    public String toString() {
        return sum + " = " + i + "^3" + " + " + j + "^3";
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] tokens = scan.nextLine().split(" ");

        int n = Integer.parseInt("550");
        int mtimes = Integer.parseInt(tokens[1]);
        int num = Integer.parseInt(tokens[0]);
        // initialize priority queue
        MinPQ<CubeSum> pq = new MinPQ<CubeSum>(100);
        for (int i = 0; i <= n; i++) {
            pq.insert(new CubeSum(i, i));
        }

        // find smallest sum, print it out, and update
        int previous = -1;
        int m = 1;
        int nm = 0;
        while (!pq.isEmpty()) {
            CubeSum s = pq.delMin();            
            if (previous == s.sum) {
                m++;
                if (m == mtimes) {
                    nm++;
                    m = 1;
                }
            } else m = 1;
            previous = s.sum;
            if (nm == num) {
                break;
            }
            

            if (s.j < n)
                pq.insert(new CubeSum(s.i, s.j + 1));
        }
        System.out.println(previous);
    }

}
