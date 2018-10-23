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
	boolean[][] grid;
	int noOfOpenSites = 0;

	public Percolation(int n) {
		grid = new boolean[n][n];
	}
	public    void open(int row, int col) {
		grid[row-1][col-1] = true;
		noOfOpenSites++;
	}
	public boolean isOpen(int row, int col) {
		if(grid[row-1][col-1]) return true;
		return false;
	}
	public boolean isFull(int row, int col) {
		if(grid[row-1][col-1]) return false;
		return true;
	}
	public     int numberOfOpenSites() {
		return noOfOpenSites;
	}
	public boolean percolates() {
		WeightedQuickUnionUF 
		return true;
	}
}
public class Solution {
	public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        Percolation percolation = new Percolation(size);
        while (scan.hasNext()) {
            percolation.open(scan.nextInt(), scan.nextInt());
        }
        System.out.println(percolation.percolates());
    }
}