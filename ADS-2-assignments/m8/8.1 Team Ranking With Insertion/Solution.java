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
		//System.out.println(cricketList + " before");
		selectionSort();
		//System.out.println(cricketList + " after");
		for(int i =0;i<cricketList.size()-1;i++){
			System.out.print(cricketList.get(i).name + ",");
		}
		System.out.print(cricketList.get(cricketList.size()-1).name);
		System.out.println();



	}
	public static void selectionSort(){

		for(int i = cricketList.size()-1; i >= 0 ; i--) {
			Cricket max = cricketList.get(i);
			int index = -1;
			for(int j = i-1;j >= 0;j--) {
				if(max.compareTo(cricketList.get(j)) == 1) {
					max = cricketList.get(j);
					index = j;
				}
			}
			//System.out.println(max.name);
			Cricket temp = cricketList.get(i);
			cricketList.set(i, max);
			if(index != -1) cricketList.set(index, temp);
		}
		
	}

}
