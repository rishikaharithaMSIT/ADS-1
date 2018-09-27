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
						int a = stack.pop();
						int b = stack.pop();
						stack.push(a*b);
						break;
					case "-" :
						a = stack.pop();
						b = stack.pop();
						stack.push(a-b);
						break;
					case "/":
						a = stack.pop();
						b = stack.pop();
						stack.push(a/b);
						break;
					case "+" :
						a = stack.pop();
						b = stack.pop();
						stack.push(a+b);
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

	public int pop(){
		int item = first.data;
		first = first.next;
		return item;
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