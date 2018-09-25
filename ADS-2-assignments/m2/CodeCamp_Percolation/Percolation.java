class Percolation {
	static boolean[][] matrix;
	WeightedQuickUnionUF wqu;
	int t = 0;
	int b;
	int s;
	public Percolation(int size) {
		matrix = new boolean[size][size];
		s = size;
		b = size * size + 1;
		wqu = new WeightedQuickUnionUF(size * size + 2);
	}

	public void open(int r, int c) {
		if (isOpen(r, c)) return;
		matrix[r - 1][c - 1] = true;
		if (r == 1) {
			wqu.union(t, getIndex(r, c));
		}
		if (r == s) {
			wqu.union(getIndex(r, c), b);
		}
		if (r > 1 && isOpen(r - 1, c)) {
			wqu.union(getIndex(r, c), getIndex(r - 1, c));
		}
		if (r < s && isOpen(r + 1, c)) {
			wqu.union(getIndex(r, c), getIndex(r + 1 , c));
		}
		if (c > 1 && isOpen(r, c - 1)) {
			wqu.union(getIndex(r, c), getIndex(r, c - 1));
		}
		if (c < s && isOpen(r, c + 1)) {
			wqu.union(getIndex(r, c), getIndex(r, c + 1));
		}	
	}



	public boolean isOpen(int r, int c) {
		return matrix[r - 1][c - 1];
	}

	public boolean isFull(int r, int c) {
		return wqu.connected(t, getIndex(r, c));
	}

	public boolean percolates() {
		return wqu.connected(t, b);
	}

	public int getIndex(int r, int c) {
		return ((r - 1) * s) + c;
	}
}