import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		while(scan.hasNext()) {
			String[] line = scan.nextLine().split(" ");
			Stack stack = new Stack();
			for(int i =0;i<line.length;i++){
				switch(line[i]) {
					case "*" :
						break;
					case "-" :
						break;
					case "/":
						break;
					case "+" :
						break;
					default:
						stack.push(Integer.parseInt(line[i]));
				}
			}
			stack.printList();
		}


	}

}
class Stack {
	Node first = null;
	class Node{
		int data;
		Node next;
		Node(int data) {
			this.data = data;
		}
	}

	public void push(int ele) {
		Node newnode = new Node(ele);
		newnode.next = first;
		first = newnode;
	}

	public void printList() 
    { 
        Node tnode = first; 
        while (tnode != null) 
        { 
            System.out.print(tnode.data+" "); 
            tnode = tnode.next; 
        } 
    }
}