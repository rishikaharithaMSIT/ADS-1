public class Solution {
	public static void main(String[] args) {
		Cricket c1 = new Cricket(4,3,1);
		Cricket c2 = new Cricket(4,2,4);
		Cricket c3 = new Cricket(5,2,4);
		Cricket c4 = new Cricket(5,2,5);
		
		System.out.println(c1.compareTo(c2));
		System.out.println(c3.compareTo(c2));
		System.out.println(c3.compareTo(c4));

	}
}
class Cricket implements Comparable<Cricket>{
	int wins;
	int losses;
	int draws;
	Cricket(int wins, int losses, int draws) {
		this.wins = wins;
		this.losses = losses;
		this.draws = draws;
	}
	public int compareTo(Cricket other) {
		if(this.wins > other.wins) return 1;
		if(this.wins < other.wins) return -1;
		if(this.losses > other.losses) return 1;
		if(this.losses < other.losses) return -1;
		if(this.draws > other.draws) return 1;
		if(this.draws < other.draws) return -1;
		return 0;
	}

}
