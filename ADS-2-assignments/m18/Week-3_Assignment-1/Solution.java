import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		while(n > 0) {
			int hours = 6;
			while(hours > 0) {
				String line = scan.nextLine();
				System.out.println(line);
				hours--;
			}
			System.out.println();
			n--;
		}
	}
}