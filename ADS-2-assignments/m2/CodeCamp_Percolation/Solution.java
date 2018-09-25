import java.util.*;
// public class Percolation {
//    public Percolation(int n)                // create n-by-n grid, with all sites blocked
//    public    void open(int row, int col)    // open site (row, col) if it is not open already
//    public boolean isOpen(int row, int col)  // is site (row, col) open?
//    public boolean isFull(int row, int col)  // is site (row, col) full?
//    public     int numberOfOpenSites()       // number of open sites
//    public boolean percolates()              // does the system percolate?
// }


// You can implement the above API to solve the problem
class Percolation {
	public Percolation(int n) {
		System.out.println(n);
	}
	public    void open(int row, int col) {

	}
	public boolean isOpen(int row, int col) {
		return true;
	}
	public boolean isFull(int row, int col) {
		return true;
	}
	public     int numberOfOpenSites() {
		return -1;
	}
	public boolean percolates() {
		return true;
	}
}
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int noGrids = scan.nextInt();
		Percolation p = new Percolation(noGrids);
	}
}