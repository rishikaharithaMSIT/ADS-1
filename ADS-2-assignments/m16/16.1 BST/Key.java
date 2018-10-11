class Key implements Comparable<Key> {
	String name;
	String author;
	String price;
	Key(String name, String author, String price) {
		this.name = name;
		this.author = author;
		this.price = price;
	}
	public int compareTo(Key other) {
		// if (this.name.compareTo(other.name) > 1) return 1;
		// if (this.name.compareTo(other.name) < 1) return -1;
		// return 0;
		return this.name.compareTo(other.name);
	}
	public String toString() {
		return name;
	}
}