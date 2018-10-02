class Cricket implements Comparable<Cricket> {
	String name;
	int wins;
	int losses;
	int draws;
	Cricket(String name, int wins, int losses, int draws) {
		this.name = name;
		this.wins = wins;
		this.losses = losses;
		this.draws = draws;
	}
	public int compareTo(Cricket other) {
		if (this.wins > other.wins) return 1;
		if (this.wins < other.wins) return -1;
		if (this.losses > other.losses) return -1;
		if (this.losses < other.losses) return 1;
		if (this.draws > other.draws) return 1;
		if (this.draws < other.draws) return -1;
		return 0;
	}

}
