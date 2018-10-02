import java.util.Scanner;
import java.util.ArrayList;
public class Solution {
	static ArrayList<Cricket> cricketList = new ArrayList<Cricket>();
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String line = scan.nextLine();
			String[] tokens = line.split(",");
			Cricket cricket = new Cricket(tokens[0],
			                              Integer.parseInt(tokens[1]),
			                              Integer.parseInt(tokens[2]),
			                              Integer.parseInt(tokens[3]));
			cricketList.add(cricket);


		}
		System.out.println(cricketList + " before");
		selectionSort();
		System.out.println(cricketList + " after");



	}
	public static void selectionSort(){

		for(int i = 0; i < cricketList.size(); i++) {
			Cricket max = cricketList.get(i);
			int index = -1;
			for(int j = i+1;j<cricketList.size();j++) {
				if(max.compareTo(cricketList.get(j)) == 1) {
					max = cricketList.get(j);
					index = j;
				}
			}
			System.out.println(max.name);
			Cricket temp = cricketList.get(index);
			cricketList.set(index, max);
			if(index != -1) cricketList.set(i, temp);
		}
		
	}

}
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