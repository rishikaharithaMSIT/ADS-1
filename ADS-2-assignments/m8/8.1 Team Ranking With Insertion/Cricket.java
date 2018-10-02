/**
 * Class for cricket.
 */

class Cricket implements Comparable<Cricket> {
	String name;
	int wins;
	int losses;
	int draws;
	/**
	 * Constructs the object.
	 *
	 * @param      name    The name
	 * @param      wins    The wins
	 * @param      losses  The losses
	 * @param      draws   The draws
	 */
	Cricket(String name, int wins, int losses, int draws) {
		this.name = name;
		this.wins = wins;
		this.losses = losses;
		this.draws = draws;
	}
	/**
	 * comapare two cricket objects
	 *
	 * @param      other  The other
	 *
	 * @return     returns int value
	 */


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
