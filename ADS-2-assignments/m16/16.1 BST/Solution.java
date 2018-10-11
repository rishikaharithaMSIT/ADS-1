import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		// Key k1 = new Key("Harry","JK","600.0,1");
		// Key k2 = new Key("IT","Viswas","400.0");
		// Key k3 = new Key("Street","Kiran","800.0");
		// Key k4 = new Key("Hello","Ajay","200.0");
		Scanner scan = new Scanner(System.in);
		BinaryST<Key, Integer> bst = new BinaryST<>();
		while(scan.hasNext()) {
			String[] tokens = scan.nextLine().split(",");
			switch(tokens[0]) {
				case "put":
				    Key k = new Key(tokens[1],tokens[2],tokens[3]);
				    bst.put(k,Integer.parseInt(tokens[4]));
				    break;
				case "get":
				    k = new Key(tokens[1],tokens[2],tokens[3]);
				    System.out.println(bst.get(k));
				    break;
				default:
				    break;    
			}

		}
		// bst.put(k1, 1);
		// bst.put(k2, 2);
		// bst.put(k3, 6);
		// Key g1 = new Key("Hello","Ajay","200.0");
		// System.out.println(bst.get(g1));
		// bst.put(k4,5);
		// bst.put(k4,7);
		// System.out.println(bst.get(g1));

	}
}

