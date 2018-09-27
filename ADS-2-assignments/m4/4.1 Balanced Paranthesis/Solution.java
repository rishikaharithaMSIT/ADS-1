import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testcases = Integer.parseInt(scan.nextLine());
		while(scan.hasNext()) {
			String[] line = scan.nextLine().split("");
			Stack stack =  new Stack();
			for(int i =0; i< line.length;i++) {
				stack.push(line[i]);
			}
			
		}
	}
}

class Stack{
	String[] s;
	int size;
	Stack() {
		s = new String[50];
		size = 0;
	}
	public void push(String ele){
		s[size] = ele;
		size++;
	}
	public String pop() {
		String item =  s[size-1];
		s[size-1] = null;
		size--;
		return item;
	}
}