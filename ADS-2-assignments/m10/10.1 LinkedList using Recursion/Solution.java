import java.util.Scanner;
public class Solution{
	public static void main(String[] args) {
		LinkedList l = new LinkedList();

		Scanner scan = new Scanner(System.in);
		
		while (scan.hasNext()) {
			String line = scan.nextLine();
			String[] tokens = line.split(" ");
			switch (tokens[0]) {
			case "insertAt":
				try {
					l.insertAt(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
					l.printList();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				break;
			case "reverse":
				try {
					l.reverse();
					l.printList();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			default:
			    break;	
			}
		}
	}
}
